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
import com.suyan.mall.goods.dao.GoodsSpecificationNameMapper;
import com.suyan.mall.goods.model.GoodsSpecificationName;
import com.suyan.mall.goods.req.GoodsSpecificationNameQueryDTO;
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
 * @Comments: <业务层商品规格名管理类>
 * @jdk 1.8
 * @Version: <1.0>
 */
@Slf4j
@Service
public class GoodsSpecificationNameBiz {

    @Autowired
    private GoodsSpecificationNameMapper goodsSpecificationNameMapper;


    /**
     * 删除商品规格名
     *
     * @param id
     * @return
     */
    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, rollbackFor = Exception.class)
    public Integer deleteGoodsSpecificationName(Long id) {
        // TODO: Describe business logic and implement it
        getBaseGoodsSpecificationName(id);
        return goodsSpecificationNameMapper.deleteByPrimaryKey(id);
    }

    /**
     * 创建商品规格名
     *
     * @param goodsSpecificationName
     * @return
     */
    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, rollbackFor = Exception.class)
    public Long createGoodsSpecificationName(GoodsSpecificationName goodsSpecificationName) {
        // TODO: Describe business logic and implement it
        goodsSpecificationNameMapper.insertSelective(goodsSpecificationName);
        return goodsSpecificationName.getId();
    }

    /**
     * 批量创建
     *
     * @param goodsSpecificationNameList
     * @return
     */
    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, rollbackFor = Exception.class)
    public int batchCreateGoodsSpecificationName(List<GoodsSpecificationName> goodsSpecificationNameList) {
        // TODO: Describe business logic and implement it
        return goodsSpecificationNameMapper.insertBatch(goodsSpecificationNameList);
    }

    /**
     * 更新商品规格名
     *
     * @param goodsSpecificationName
     * @return
     */
    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, rollbackFor = Exception.class)
    public Integer updateGoodsSpecificationName(GoodsSpecificationName goodsSpecificationName) {
        getBaseGoodsSpecificationName(goodsSpecificationName.getId());
        return goodsSpecificationNameMapper.updateByPrimaryKeySelective(goodsSpecificationName);
    }

    /**
     * 根据ID获取商品规格名信息
     *
     * @param id
     * @return
     */
    @Transactional(readOnly = true)
    public GoodsSpecificationName getGoodsSpecificationName(Long id) {
        return getBaseGoodsSpecificationName(id);
    }

    @Transactional(readOnly = true)
    public GoodsSpecificationName getBaseGoodsSpecificationName(Long id) {
        GoodsSpecificationName goodsSpecificationName = goodsSpecificationNameMapper.selectByPrimaryKey(id);
        if (goodsSpecificationName == null) {
            throw new CommonException(ResultCode.DATA_NOT_EXIST, "商品规格名");
        }
        return goodsSpecificationName;
    }

    /**
     * 分页查询商品规格名信息
     *
     * @param goodsSpecificationNameQuery
     * @return
     */
    @Transactional(readOnly = true)
    public QueryResultVO<GoodsSpecificationName> queryGoodsSpecificationName(GoodsSpecificationNameQueryDTO goodsSpecificationNameQuery) {
        QueryResultVO<GoodsSpecificationName> queryResult = new QueryResultVO<GoodsSpecificationName>();
        // 使用分页插件PageHelper实现分页功能
        PageHelper.startPage(goodsSpecificationNameQuery.getPageNo(), goodsSpecificationNameQuery.getPageSize());
        List<GoodsSpecificationName> goodsSpecificationNameList = goodsSpecificationNameMapper.queryGoodsSpecificationName(goodsSpecificationNameQuery);
        PageInfo<GoodsSpecificationName> pageInfo = new PageInfo<GoodsSpecificationName>(goodsSpecificationNameList);
        queryResult.setPageNo(pageInfo.getPageNum());
        queryResult.setPageSize(pageInfo.getPageSize());
        queryResult.setTotalPages(pageInfo.getPages());
        queryResult.setTotalRecords(pageInfo.getTotal());
        queryResult.setRecords(goodsSpecificationNameList);
        return queryResult;
    }

}