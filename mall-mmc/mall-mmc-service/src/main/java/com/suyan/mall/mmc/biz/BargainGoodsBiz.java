package com.suyan.mall.mmc.biz;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.suyan.exception.CommonException;
import com.suyan.mall.mmc.dao.BargainGoodsMapper;
import com.suyan.mall.mmc.model.BargainGoods;
import com.suyan.mall.mmc.req.BargainGoodsQueryDTO;
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
 * @Comments: <业务层砍价商品管理类>
 */
@Slf4j
@Service
public class BargainGoodsBiz {

    @Autowired
    private BargainGoodsMapper bargainGoodsMapper;

    /**
     * 删除砍价商品
     *
     * @param id
     * @return
     */
    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, rollbackFor = Exception.class)
    public Integer deleteBargainGoods(Long id) {
        // TODO: Describe business logic and implement it
        getBaseBargainGoods(id);
        return bargainGoodsMapper.deleteByPrimaryKey(id);
    }

    /**
     * 创建砍价商品
     *
     * @param bargainGoods
     * @return
     */
    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, rollbackFor = Exception.class)
    public Long createBargainGoods(BargainGoods bargainGoods) {
        // TODO: Describe business logic and implement it
        bargainGoodsMapper.insertSelective(bargainGoods);
        return bargainGoods.getId();
    }

    /**
     * 批量创建
     *
     * @param bargainGoodsList
     * @return
     */
    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, rollbackFor = Exception.class)
    public int batchCreateBargainGoods(List<BargainGoods> bargainGoodsList) {
        // TODO: Describe business logic and implement it
        return bargainGoodsMapper.insertBatch(bargainGoodsList);
    }

    /**
     * 更新砍价商品
     *
     * @param bargainGoods
     * @return
     */
    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, rollbackFor = Exception.class)
    public Integer updateBargainGoods(BargainGoods bargainGoods) {
        getBaseBargainGoods(bargainGoods.getId());
        return bargainGoodsMapper.updateByPrimaryKeySelective(bargainGoods);
    }

    /**
     * 根据ID获取砍价商品信息
     *
     * @param id
     * @return
     */
    @Transactional(readOnly = true)
    public BargainGoods getBargainGoods(Long id) {
        return getBaseBargainGoods(id);
    }

    @Transactional(readOnly = true)
    public BargainGoods getBaseBargainGoods(Long id) {
        BargainGoods bargainGoods = bargainGoodsMapper.selectByPrimaryKey(id);
        if (bargainGoods == null || bargainGoods.getIsDeleted()) {
            throw new CommonException(ResultCode.DATA_NOT_EXIST, "砍价商品");
        }
        return bargainGoods;
    }

    /**
     * 分页查询砍价商品信息
     *
     * @param bargainGoodsQuery
     * @return
     */
    @Transactional(readOnly = true)
    public QueryResultVO<BargainGoods> queryBargainGoods(BargainGoodsQueryDTO bargainGoodsQuery) {
        QueryResultVO<BargainGoods> queryResult = new QueryResultVO<BargainGoods>();
        // 使用分页插件PageHelper实现分页功能
        PageHelper.startPage(bargainGoodsQuery.getPageNo(), bargainGoodsQuery.getPageSize());
        List<BargainGoods> bargainGoodsList = bargainGoodsMapper.queryBargainGoods(bargainGoodsQuery);
        PageInfo<BargainGoods> pageInfo = new PageInfo<BargainGoods>(bargainGoodsList);
        queryResult.setPageNo(pageInfo.getPageNum());
        queryResult.setPageSize(pageInfo.getPageSize());
        queryResult.setTotalPages(pageInfo.getPages());
        queryResult.setTotalRecords(pageInfo.getTotal());
        queryResult.setRecords(bargainGoodsList);
        return queryResult;
    }

}