package com.suyan.mall.mmc.biz;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.suyan.exception.CommonException;
import com.suyan.mall.mmc.dao.BargainGoodsItemMapper;
import com.suyan.mall.mmc.model.BargainGoodsItem;
import com.suyan.mall.mmc.req.BargainGoodsItemQueryDTO;
import com.suyan.query.QueryResultVO;
import com.suyan.result.ResultCode;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @CopyRright (c): <素焉代码生成工具>
 * @Comments: <业务层砍价商品阶段管理类>
 */
@Slf4j
@Service
public class BargainGoodsItemBiz {

    @Autowired
    private BargainGoodsItemMapper bargainGoodsItemMapper;

    /**
     * 删除砍价商品阶段
     *
     * @param id
     * @return
     */
    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, rollbackFor = Exception.class)
    public Integer deleteBargainGoodsItem(Long id) {
        // TODO: Describe business logic and implement it
        getBaseBargainGoodsItem(id);
        return bargainGoodsItemMapper.deleteByPrimaryKey(id);
    }

    /**
     * 创建砍价商品阶段
     *
     * @param bargainGoodsItem
     * @return
     */
    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, rollbackFor = Exception.class)
    public Long createBargainGoodsItem(BargainGoodsItem bargainGoodsItem) {
        // TODO: Describe business logic and implement it
        bargainGoodsItemMapper.insertSelective(bargainGoodsItem);
        return bargainGoodsItem.getId();
    }

    /**
     * 批量创建
     *
     * @param bargainGoodsItemList
     * @return
     */
    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, rollbackFor = Exception.class)
    public int batchCreateBargainGoodsItem(List<BargainGoodsItem> bargainGoodsItemList) {
        // TODO: Describe business logic and implement it
        return bargainGoodsItemMapper.insertBatch(bargainGoodsItemList);
    }

    /**
     * 更新砍价商品阶段
     *
     * @param bargainGoodsItem
     * @return
     */
    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, rollbackFor = Exception.class)
    public Integer updateBargainGoodsItem(BargainGoodsItem bargainGoodsItem) {
        getBaseBargainGoodsItem(bargainGoodsItem.getId());
        return bargainGoodsItemMapper.updateByPrimaryKeySelective(bargainGoodsItem);
    }

    /**
     * 根据ID获取砍价商品阶段信息
     *
     * @param id
     * @return
     */
    @Transactional(readOnly = true)
    public BargainGoodsItem getBargainGoodsItem(Long id) {
        return getBaseBargainGoodsItem(id);
    }

    @Transactional(readOnly = true)
    public BargainGoodsItem getBaseBargainGoodsItem(Long id) {
        BargainGoodsItem bargainGoodsItem = bargainGoodsItemMapper.selectByPrimaryKey(id);
        if (bargainGoodsItem == null) {
            throw new CommonException(ResultCode.DATA_NOT_EXIST, "砍价商品阶段");
        }
        return bargainGoodsItem;
    }

    /**
     * 分页查询砍价商品阶段信息
     *
     * @param bargainGoodsItemQuery
     * @return
     */
    @Transactional(readOnly = true)
    public QueryResultVO<BargainGoodsItem> queryBargainGoodsItem(BargainGoodsItemQueryDTO bargainGoodsItemQuery) {
        QueryResultVO<BargainGoodsItem> queryResult = new QueryResultVO<BargainGoodsItem>();
        // 使用分页插件PageHelper实现分页功能
        PageHelper.startPage(bargainGoodsItemQuery.getPageNo(), bargainGoodsItemQuery.getPageSize());
        List<BargainGoodsItem> bargainGoodsItemList = bargainGoodsItemMapper.queryBargainGoodsItem(bargainGoodsItemQuery);
        PageInfo<BargainGoodsItem> pageInfo = new PageInfo<BargainGoodsItem>(bargainGoodsItemList);
        queryResult.setPageNo(pageInfo.getPageNum());
        queryResult.setPageSize(pageInfo.getPageSize());
        queryResult.setTotalPages(pageInfo.getPages());
        queryResult.setTotalRecords(pageInfo.getTotal());
        queryResult.setRecords(bargainGoodsItemList);
        return queryResult;
    }

}