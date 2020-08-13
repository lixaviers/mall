package com.suyan.mall.mmc.biz;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.suyan.exception.CommonException;
import com.suyan.mall.goods.enums.GoodsInventoryWayEnum;
import com.suyan.mall.goods.feignClient.GoodsSkuFeignClient;
import com.suyan.mall.goods.req.GoodsSkuInventoryLogDTO;
import com.suyan.mall.mmc.constant.ExceptionDefMmc;
import com.suyan.mall.mmc.dao.BargainMapper;
import com.suyan.mall.mmc.enums.CommonStatusMmcEnum;
import com.suyan.mall.mmc.enums.PromotionTypeEnum;
import com.suyan.mall.mmc.model.Bargain;
import com.suyan.mall.mmc.model.BargainExample;
import com.suyan.mall.mmc.req.BargainQueryDTO;
import com.suyan.query.QueryResultVO;
import com.suyan.result.Result;
import com.suyan.result.ResultCode;
import com.suyan.utils.CollectionsUtil;
import com.suyan.utils.JsonUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @CopyRright (c): <素焉代码生成工具>
 * @Comments: <业务层砍价管理类>
 */
@Slf4j
@Service
public class BargainBiz {

    @Autowired
    private BargainMapper bargainMapper;

    @Autowired
    private BargainItemBiz bargainItemBiz;

    @Autowired
    private GoodsSkuFeignClient goodsSkuFeignClient;

    /**
     * 删除砍价
     *
     * @param id
     * @return
     */
    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, rollbackFor = Exception.class)
    public Integer deleteBargain(Long id) {
        getBaseBargain(id);
        return bargainMapper.deleteByPrimaryKey(id);
    }

    /**
     * 创建砍价
     *
     * @param bargain
     * @return
     */
    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, rollbackFor = Exception.class)
    public Long createBargain(Bargain bargain) {
        checkGoods(bargain);

        // 扣库存
        updateGoodsInventory(bargain.getGoodsSkuCode(), GoodsInventoryWayEnum.TAKE.getValue(), bargain.getInventory(), null, "砍价占用库存");

        bargain.setActivityStatus(CommonStatusMmcEnum.SAVED.getValue());
        bargainMapper.insertSelective(bargain);
        bargainItemBiz.createBargainItem(bargain.getId(), bargain.getBargainItemList());
        return bargain.getId();
    }

    private void checkGoods(Bargain bargain) {
        BargainExample example = new BargainExample();
        BargainExample.Criteria criteria = example.createCriteria().andGoodsSkuCodeEqualTo(bargain.getGoodsSkuCode()).andIsDeletedEqualTo(false)
                .andStartTimeLessThanOrEqualTo(bargain.getEndTime())
                .andEndTimeGreaterThanOrEqualTo(bargain.getStartTime());
        if (bargain.getId() != null) {
            criteria.andIdNotEqualTo(bargain.getId());
        }
        List<Bargain> beanList = bargainMapper.selectByExample(example);
        if (CollectionsUtil.isNotEmpty(beanList)) {
            throw new CommonException(ExceptionDefMmc.EXCEPTION_10001);
        }
    }

    /**
     * 更新砍价
     *
     * @param bargain
     * @return
     */
    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, rollbackFor = Exception.class)
    public Integer updateBargain(Bargain bargain) {
        Bargain bargainLast = getBaseBargain(bargain.getId());
        if (!bargainLast.getShopId().equals(bargain.getShopId())) {
            // 非本店铺砍价
            throw new CommonException(ResultCode.NO_PERMISSION_OPERATE, "此砍价");
        }
        checkGoods(bargain);

        // 库存差异
        int number = bargain.getInventory() - bargainLast.getInventory();
        if (number > 0) {
            // 扣库存
            updateGoodsInventory(bargain.getGoodsSkuCode(), GoodsInventoryWayEnum.TAKE.getValue(), bargain.getInventory(), bargain.getId(), "砍价编辑新增占用库存");
        } else if (number < 0) {
            // 还库存
            updateGoodsInventory(bargain.getGoodsSkuCode(), GoodsInventoryWayEnum.THE_RETURN.getValue(), bargain.getInventory() * -1, bargain.getId(), "砍价编辑归还库存");
        } else {
            log.info("编辑库存未发生变化");
        }

        bargainItemBiz.updateBargainItem(bargain.getId(), bargain.getBargainItemList());
        return bargainMapper.updateByPrimaryKeySelective(bargain);
    }

    /**
     * 更新商品库存
     *
     * @param goodsSkuCode
     * @param inventoryWay
     * @param inventory
     * @param associatedId
     * @param associatedDesc
     */
    private void updateGoodsInventory(String goodsSkuCode, byte inventoryWay, int inventory, Long associatedId, String associatedDesc) {
        GoodsSkuInventoryLogDTO dto = new GoodsSkuInventoryLogDTO();
        dto.setGoodsSkuCode(goodsSkuCode);
        dto.setInventoryWay(inventoryWay);
        dto.setInventory(inventory);
        dto.setAssociatedId(associatedId);
        dto.setAssociatedDesc(associatedDesc);
        dto.setLogType(PromotionTypeEnum.BARGAIN.getValue());
        log.info("调用商品库存入参={}", JsonUtil.toJsonString(dto));
        Result<Integer> result = goodsSkuFeignClient.updateInventory(dto);
        log.info("调用商品库存出参={}", JsonUtil.toJsonString(result));
        if (!result.isSuccess()) {
            throw new CommonException(ResultCode.COMMON_MESSAGE, result.getMessage());
        }
    }

    /**
     * 根据ID获取砍价信息
     *
     * @param id
     * @return
     */
    @Transactional(readOnly = true)
    public Bargain getBargain(Long id) {
        Bargain bargain = getBaseBargain(id);
        bargain.setBargainItemList(bargainItemBiz.getBargainItemListByBargainId(id));
        return bargain;
    }

    @Transactional(readOnly = true)
    public Bargain getBaseBargain(Long id) {
        Bargain bargain = bargainMapper.selectByPrimaryKey(id);
        if (bargain == null || bargain.getIsDeleted()) {
            throw new CommonException(ResultCode.DATA_NOT_EXIST, "砍价");
        }
        return bargain;
    }

    /**
     * 分页查询砍价信息
     *
     * @param bargainQuery
     * @return
     */
    @Transactional(readOnly = true)
    public QueryResultVO<Bargain> queryBargain(BargainQueryDTO bargainQuery) {
        QueryResultVO<Bargain> queryResult = new QueryResultVO<Bargain>();
        // 使用分页插件PageHelper实现分页功能
        PageHelper.startPage(bargainQuery.getPageNo(), bargainQuery.getPageSize());
        List<Bargain> bargainList = bargainMapper.queryBargain(bargainQuery);
        PageInfo<Bargain> pageInfo = new PageInfo<Bargain>(bargainList);
        queryResult.setPageNo(pageInfo.getPageNum());
        queryResult.setPageSize(pageInfo.getPageSize());
        queryResult.setTotalPages(pageInfo.getPages());
        queryResult.setTotalRecords(pageInfo.getTotal());
        queryResult.setRecords(bargainList);
        return queryResult;
    }

}