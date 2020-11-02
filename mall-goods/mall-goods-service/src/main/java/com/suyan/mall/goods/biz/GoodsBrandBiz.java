/*
 * Copyright (c) 2020.
 * 项目名称：素焉商城
 * 创建人：素焉
 * 开源地址: https://github.com/lixaviers/mall
 */
package com.suyan.mall.goods.biz;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.suyan.exception.CommonException;
import com.suyan.mall.goods.dao.biz.GoodsBrandBizMapper;
import com.suyan.mall.goods.model.GoodsBrand;
import com.suyan.mall.goods.model.GoodsBrandExample;
import com.suyan.mall.goods.req.GoodsBrandQueryDTO;
import com.suyan.query.QueryResultVO;
import com.suyan.result.ResultCode;
import com.suyan.utils.CollectionsUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @CopyRright (c): <素焉代码生成工具>
 * @Comments: <业务层商品品牌管理类>
 */
@Slf4j
@Service
public class GoodsBrandBiz {

    @Autowired
    private GoodsBrandBizMapper goodsBrandBizMapper;

    /**
     * 删除商品品牌
     *
     * @param id
     * @return
     */
    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, rollbackFor = Exception.class)
    public Integer deleteGoodsBrand(Integer id) {
        // TODO: Describe business logic and implement it
        getBaseGoodsBrand(id);
        return goodsBrandBizMapper.deleteByPrimaryKey(id);
    }

    /**
     * 创建商品品牌
     *
     * @param goodsBrand
     * @return
     */
    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, rollbackFor = Exception.class)
    public Integer createGoodsBrand(GoodsBrand goodsBrand) {
        // TODO: Describe business logic and implement it
        goodsBrandBizMapper.insertSelective(goodsBrand);
        return goodsBrand.getId();
    }

    /**
     * 批量创建
     *
     * @param goodsBrandList
     * @return
     */
    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, rollbackFor = Exception.class)
    public int batchCreateGoodsBrand(List<GoodsBrand> goodsBrandList) {
        return goodsBrandBizMapper.insertBatch(goodsBrandList);
    }

    /**
     * 更新商品品牌
     *
     * @param goodsBrand
     * @return
     */
    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, rollbackFor = Exception.class)
    public Integer updateGoodsBrand(GoodsBrand goodsBrand) {
        getBaseGoodsBrand(goodsBrand.getId());
        return goodsBrandBizMapper.updateByPrimaryKeySelective(goodsBrand);
    }

    /**
     * 根据ID获取商品品牌信息
     *
     * @param id
     * @return
     */
    @Transactional(readOnly = true)
    public GoodsBrand getGoodsBrand(Integer id) {
        return getBaseGoodsBrand(id);
    }

    @Transactional(readOnly = true)
    public GoodsBrand getBaseGoodsBrand(Integer id) {
        GoodsBrand goodsBrand = goodsBrandBizMapper.selectByPrimaryKey(id);
        if (goodsBrand == null || goodsBrand.getIsDeleted()) {
            throw new CommonException(ResultCode.DATA_NOT_EXIST, "商品品牌");
        }
        return goodsBrand;
    }

    /**
     * 分页查询商品品牌信息
     *
     * @param goodsBrandQuery
     * @return
     */
    @Transactional(readOnly = true)
    public QueryResultVO<GoodsBrand> queryGoodsBrand(GoodsBrandQueryDTO goodsBrandQuery) {
        QueryResultVO<GoodsBrand> queryResult = new QueryResultVO<GoodsBrand>();
        // 使用分页插件PageHelper实现分页功能
        PageHelper.startPage(goodsBrandQuery.getPageNo(), goodsBrandQuery.getPageSize());
        List<GoodsBrand> goodsBrandList = goodsBrandBizMapper.queryGoodsBrand(goodsBrandQuery);
        PageInfo<GoodsBrand> pageInfo = new PageInfo<GoodsBrand>(goodsBrandList);
        queryResult.setPageNo(pageInfo.getPageNum());
        queryResult.setPageSize(pageInfo.getPageSize());
        queryResult.setTotalPages(pageInfo.getPages());
        queryResult.setTotalRecords(pageInfo.getTotal());
        queryResult.setRecords(goodsBrandList);
        return queryResult;
    }

    /**
     * 根据商品类目id获取商品品牌
     *
     * @param categoryId
     * @return
     */
    @Transactional(readOnly = true)
    public List<GoodsBrand> getGoodsBrandListByCategoryId(Integer categoryId) {
        return goodsBrandBizMapper.getGoodsBrandListByCategoryId(categoryId);
    }

    /**
     * 根据id列表查询
     *
     * @param idList
     * @return
     */
    @Transactional(readOnly = true)
    public List<GoodsBrand> getGoodsBrandByIdList(List<Integer> idList) {
        if (CollectionsUtil.isNotEmpty(idList)) {
            GoodsBrandExample example = new GoodsBrandExample();
            example.createCriteria().andIdIn(idList).andIsDeletedEqualTo(false);
            return goodsBrandBizMapper.selectByExample(example);
        }
        return null;
    }

}