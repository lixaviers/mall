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
import com.suyan.mall.goods.dao.GoodsClassMapper;
import com.suyan.mall.goods.model.GoodsClass;
import com.suyan.mall.goods.req.GoodsClassQueryDTO;
import com.suyan.query.QueryResultVO;
import com.suyan.result.ResultCode;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @CopyRright (c): <素焉代码生成工具>
 * @Comments: <业务层商品分类管理类>
 */
@Slf4j
@Service
public class GoodsClassBiz {

    @Autowired
    private GoodsClassMapper goodsClassMapper;

    /**
     * 删除商品分类
     *
     * @param id
     * @return
     */
    public Integer deleteGoodsClass(Long id) {
        return goodsClassMapper.logicalDeleteByPrimaryKey(id);
    }

    /**
     * 创建商品分类
     *
     * @param goodsClass
     * @return
     */
    public Long createGoodsClass(GoodsClass goodsClass) {
        goodsClassMapper.insertSelective(goodsClass);
        return goodsClass.getId();
    }

    /**
     * 更新商品分类
     *
     * @param goodsClass
     * @return
     */
    public Integer updateGoodsClass(GoodsClass goodsClass) {
        getBaseGoodsClass(goodsClass.getId());
        return goodsClassMapper.updateByPrimaryKeySelective(goodsClass);
    }

    /**
     * 根据ID获取商品分类信息
     *
     * @param id
     * @return
     */
    public GoodsClass getGoodsClass(Long id) {
        return getBaseGoodsClass(id);
    }

    @Transactional(readOnly = true)
    public GoodsClass getBaseGoodsClass(Long id) {
        GoodsClass goodsClass = goodsClassMapper.selectByPrimaryKey(id);
        if (goodsClass == null || goodsClass.getIsDeleted()) {
            throw new CommonException(ResultCode.DATA_NOT_EXIST, "商品分类");
        }
        return goodsClass;
    }

    /**
     * 分页查询商品分类信息
     *
     * @param goodsClassQuery
     * @return
     */
    public QueryResultVO<GoodsClass> queryGoodsClass(GoodsClassQueryDTO goodsClassQuery) {
        QueryResultVO<GoodsClass> queryResult = new QueryResultVO<GoodsClass>();
        // 使用分页插件PageHelper实现分页功能
        PageHelper.startPage(goodsClassQuery.getPageNo(), goodsClassQuery.getPageSize());
        List<GoodsClass> goodsClassList = goodsClassMapper.queryGoodsClass(goodsClassQuery);
        PageInfo<GoodsClass> pageInfo = new PageInfo<GoodsClass>(goodsClassList);
        queryResult.setPageNo(pageInfo.getPageNum());
        queryResult.setPageSize(pageInfo.getPageSize());
        queryResult.setTotalPages(pageInfo.getPages());
        queryResult.setTotalRecords(pageInfo.getTotal());
        queryResult.setRecords(goodsClassList);
        return queryResult;
    }

}