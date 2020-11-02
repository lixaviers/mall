/*
 * Copyright (c) 2020.
 * 项目名称：素焉商城
 * 创建人：素焉
 * 开源地址: https://github.com/lixaviers/mall
 */
package com.suyan.mall.goods.service.impl;

import com.suyan.mall.goods.biz.GoodsSpecificationValueBiz;
import com.suyan.mall.goods.convertor.GoodsSpecificationValueConvertor;
import com.suyan.mall.goods.model.GoodsSpecificationValue;
import com.suyan.mall.goods.req.GoodsSpecificationValueDTO;
import com.suyan.mall.goods.req.GoodsSpecificationValueQueryDTO;
import com.suyan.mall.goods.resp.GoodsSpecificationValueVO;
import com.suyan.mall.goods.service.IGoodsSpecificationValueService;
import com.suyan.query.QueryResultVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * @CopyRright (c): <素焉代码生成工具>
 * @Comments: <Service 商品规格值管理类>
 */
@Slf4j
@Service("goodsSpecificationValueService")
public class GoodsSpecificationValueServiceImpl implements IGoodsSpecificationValueService {

    @Autowired
    private GoodsSpecificationValueBiz goodsSpecificationValueBiz;

    @Override
    public int deleteGoodsSpecificationValue(Long id) {
        return goodsSpecificationValueBiz.deleteGoodsSpecificationValue(id);
    }

    @Override
    public Long createGoodsSpecificationValue(GoodsSpecificationValueDTO goodsSpecificationValueDTO) {
        GoodsSpecificationValue goodsSpecificationValue = GoodsSpecificationValueConvertor.toGoodsSpecificationValue(goodsSpecificationValueDTO);
        return goodsSpecificationValueBiz.createGoodsSpecificationValue(goodsSpecificationValue);
    }

    @Override
    public int updateGoodsSpecificationValue(GoodsSpecificationValueDTO goodsSpecificationValueDTO) {
        GoodsSpecificationValue goodsSpecificationValue = GoodsSpecificationValueConvertor.toGoodsSpecificationValue(goodsSpecificationValueDTO);
        return goodsSpecificationValueBiz.updateGoodsSpecificationValue(goodsSpecificationValue);
    }

    @Override
    public GoodsSpecificationValueVO getGoodsSpecificationValue(Long id) {
        GoodsSpecificationValue goodsSpecificationValue = goodsSpecificationValueBiz.getGoodsSpecificationValue(id);
        return GoodsSpecificationValueConvertor.toGoodsSpecificationValueVO(goodsSpecificationValue);
    }

    @Override
    public QueryResultVO<GoodsSpecificationValueVO> queryGoodsSpecificationValue(GoodsSpecificationValueQueryDTO goodsSpecificationValueQueryDTO) {
        return GoodsSpecificationValueConvertor.toQueryResult(goodsSpecificationValueBiz.queryGoodsSpecificationValue(goodsSpecificationValueQueryDTO));
    }

}