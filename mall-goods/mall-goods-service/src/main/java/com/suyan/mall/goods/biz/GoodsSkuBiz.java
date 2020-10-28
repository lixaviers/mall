package com.suyan.mall.goods.biz;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.suyan.exception.CommonException;
import com.suyan.mall.goods.biz.async.GoodsSkuInventoryLogAsyncBiz;
import com.suyan.mall.goods.constants.Constant;
import com.suyan.mall.goods.constants.ExceptionDefGoods;
import com.suyan.mall.goods.dao.biz.GoodsSkuBizMapper;
import com.suyan.mall.goods.enums.GoodsInventoryWayEnum;
import com.suyan.mall.goods.model.GoodsSku;
import com.suyan.mall.goods.model.GoodsSkuExample;
import com.suyan.mall.goods.model.GoodsSkuInventoryLog;
import com.suyan.mall.goods.req.GoodsSkuDTO;
import com.suyan.mall.goods.req.GoodsSkuQueryDTO;
import com.suyan.mall.goods.req.c.GoodsSkuDeductionInventoryDTO;
import com.suyan.query.QueryResultVO;
import com.suyan.result.ResultCode;
import com.suyan.utils.CollectionsUtil;
import com.suyan.utils.StringUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @CopyRright (c): <素焉代码生成工具>
 * @Comments: <业务层商品规格管理类>
 * @jdk 1.8
 * @Version: <1.0>
 */
@Slf4j
@Service
public class GoodsSkuBiz {

    @Autowired
    private GoodsSkuBizMapper goodsSkuBizMapper;

    @Autowired
    private GoodsSkuInventoryLogAsyncBiz goodsSkuInventoryLogAsyncBiz;


    /**
     * 删除商品规格
     *
     * @param idList
     * @return
     */
    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, rollbackFor = Exception.class)
    public void deleteGoodsSku(List<Long> idList) {
        if (CollectionsUtil.isNotEmpty(idList)) {
            GoodsSkuExample example = new GoodsSkuExample();
            example.createCriteria().andIdIn(idList);
            GoodsSku goodsSku = new GoodsSku();
            goodsSku.setIsDeleted(true);
            int count = goodsSkuBizMapper.updateByExampleSelective(goodsSku, example);
            log.info("删除商品规格idList={},result={}", idList, count);
        }
        log.info("删除商品规格idList为空");
    }

    /**
     * 批量创建
     *
     * @param goodsSkuList
     * @return
     */
    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, rollbackFor = Exception.class)
    public void batchCreateGoodsSku(Long goodsId, List<GoodsSku> goodsSkuList) {
        if (CollectionsUtil.isNotEmpty(goodsSkuList)) {
            // 当前的sku编码
            Long skuCode = null;
            String maxSkuCode = getMaxSkuCode();
            if (StringUtils.isEmpty(maxSkuCode)) {
                skuCode = Constant.MIN_SKU_CODE;
            } else {
                skuCode = new Long(maxSkuCode) + 1;
            }
            for (GoodsSku goodsSku : goodsSkuList) {
                goodsSku.setGoodsId(goodsId);
                if (goodsSku.getId() == null) {
                    goodsSku.setSkuCode(String.valueOf(skuCode));
                    skuCode++;
                }
            }
            goodsSkuBizMapper.insertBatch(goodsSkuList);
        }
    }

    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, rollbackFor = Exception.class)
    public void batchUpdate(List<GoodsSku> goodsSkuList) {
        if (CollectionsUtil.isNotEmpty(goodsSkuList)) {
            goodsSkuList.forEach(goodsSku -> {
                goodsSkuBizMapper.updateByPrimaryKeySelective(goodsSku);
            });
        }
    }

    /**
     * 根据商品id获取商品规格信息
     *
     * @param goodsId
     * @return
     */
    @Transactional(readOnly = true)
    public List<GoodsSku> getGoodsSku(Long goodsId) {
        GoodsSkuExample example = new GoodsSkuExample();
        example.createCriteria().andGoodsIdEqualTo(goodsId).andIsDeletedEqualTo(false);
        return goodsSkuBizMapper.selectByExample(example);
    }

    @Transactional(readOnly = true)
    public GoodsSku getGoodsSku(String skuCode) {
        return goodsSkuBizMapper.selectBySkuCode(skuCode);
    }

    @Transactional(readOnly = true)
    public List<GoodsSku> getGoodsSku(List<String> skuCodeList) {
        GoodsSkuExample example = new GoodsSkuExample();
        example.createCriteria().andSkuCodeIn(skuCodeList).andIsDeletedEqualTo(false);
        return goodsSkuBizMapper.selectByExample(example);
    }

    /**
     * 分页查询商品规格信息
     *
     * @param goodsSkuQuery
     * @return
     */
    @Transactional(readOnly = true)
    public QueryResultVO<GoodsSku> queryGoodsSku(GoodsSkuQueryDTO goodsSkuQuery) {
        QueryResultVO<GoodsSku> queryResult = new QueryResultVO<GoodsSku>();
        // 使用分页插件PageHelper实现分页功能
        PageHelper.startPage(goodsSkuQuery.getPageNo(), goodsSkuQuery.getPageSize());
        List<GoodsSku> goodsSkuList = goodsSkuBizMapper.queryGoodsSku(goodsSkuQuery);
        PageInfo<GoodsSku> pageInfo = new PageInfo<GoodsSku>(goodsSkuList);
        queryResult.setPageNo(pageInfo.getPageNum());
        queryResult.setPageSize(pageInfo.getPageSize());
        queryResult.setTotalPages(pageInfo.getPages());
        queryResult.setTotalRecords(pageInfo.getTotal());
        queryResult.setRecords(goodsSkuList);
        return queryResult;
    }

    /**
     * 获取最大规格编码
     *
     * @return
     */
    @Transactional(readOnly = true)
    public String getMaxSkuCode() {
        return goodsSkuBizMapper.getMaxSkuCode();
    }

    /**
     * 更改状态
     *
     * @param goodsId
     * @param goodsStatus
     */
    public void updateStatus(Long goodsId, Byte goodsStatus) {
        GoodsSku goodsSku = new GoodsSku();
        goodsSku.setCommonStatus(goodsStatus);
        GoodsSkuExample example = new GoodsSkuExample();
        example.createCriteria().andGoodsIdEqualTo(goodsId).andIsDeletedEqualTo(false);
        goodsSkuBizMapper.updateByExampleSelective(goodsSku, example);
    }

    /**
     * 修改库存
     *
     * @param log
     */
    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, rollbackFor = Exception.class)
    public void updateInventory(GoodsSkuInventoryLog log) {
        GoodsSku goodsSku = getGoodsSku(log.getGoodsSkuCode());
        if (goodsSku == null || goodsSku.getIsDeleted()) {
            throw new CommonException(ResultCode.DATA_NOT_EXIST, "商品");
        }
        if (GoodsInventoryWayEnum.TAKE.equal(log.getInventoryWay())) {
            // 占用
            if (goodsSku.getInventory() < log.getInventory()) {
                // 库存不足
                throw new CommonException(ExceptionDefGoods.EXCEPTION_8001);
            }
            int count = goodsSkuBizMapper.deductionInventory(goodsSku.getId(), log.getInventory());
            if (count < 1) {
                // 库存不足
                throw new CommonException(ExceptionDefGoods.EXCEPTION_8001);
            }
        } else if (GoodsInventoryWayEnum.THE_RETURN.equal(log.getInventoryWay())) {
            // 归还
            goodsSkuBizMapper.addInventory(goodsSku.getId(), log.getInventory());
        }

        // 异步添加记录
        goodsSkuInventoryLogAsyncBiz.createGoodsSkuInventoryLog(log);
    }


    /**
     * 批量扣减库存
     *
     * @param dto
     */
    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, rollbackFor = Exception.class)
    public void deductionInventory(GoodsSkuDeductionInventoryDTO dto) {
        for (GoodsSkuDTO goodsSkuDTO : dto.getGoodsSkuList()) {
            int count = goodsSkuBizMapper.deductionInventorySku(goodsSkuDTO.getSkuCode(), goodsSkuDTO.getNumber());
            if (count < 1) {
                // 库存不足
                throw new CommonException(ExceptionDefGoods.EXCEPTION_8001);
            }
        }
    }


}