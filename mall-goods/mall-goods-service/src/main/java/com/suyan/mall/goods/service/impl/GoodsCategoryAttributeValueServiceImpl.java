/*
 * Copyright (c) 2020.
 * 项目名称：素焉商城
 * 创建人：素焉
 * 开源地址: https://github.com/lixaviers/mall
 */
package com.suyan.mall.goods.service.impl;

import com.suyan.mall.goods.biz.GoodsCategoryAttributeValueBiz;
import com.suyan.mall.goods.convertor.GoodsCategoryAttributeValueConvertor;
import com.suyan.mall.goods.req.GoodsCategoryAttributeValueDTO;
import com.suyan.mall.goods.req.GoodsCategoryAttributeValueQueryDTO;
import com.suyan.mall.goods.resp.GoodsCategoryAttributeValueVO;
import com.suyan.mall.goods.service.IGoodsCategoryAttributeValueService;
import com.suyan.query.QueryResultVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;


/**
 * @CopyRright (c): <素焉代码生成工具>
 * @Comments: <Service 商品类目属性值管理类>
 */
@Slf4j
@Service("goodsCategoryAttributeValueService")
public class GoodsCategoryAttributeValueServiceImpl implements IGoodsCategoryAttributeValueService {

    @Autowired
    private GoodsCategoryAttributeValueBiz goodsCategoryAttributeValueBiz;

    @Override
    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, rollbackFor = Exception.class)
    public int deleteGoodsCategoryAttributeValue(Long id) {
        return goodsCategoryAttributeValueBiz.deleteGoodsCategoryAttributeValue(id);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, rollbackFor = Exception.class)
    public Long createGoodsCategoryAttributeValue(GoodsCategoryAttributeValueDTO goodsCategoryAttributeValueDTO) {
        return goodsCategoryAttributeValueBiz.createGoodsCategoryAttributeValue(GoodsCategoryAttributeValueConvertor.toGoodsCategoryAttributeValue(goodsCategoryAttributeValueDTO));
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, rollbackFor = Exception.class)
    public int updateGoodsCategoryAttributeValue(GoodsCategoryAttributeValueDTO goodsCategoryAttributeValueDTO) {
        return goodsCategoryAttributeValueBiz.updateGoodsCategoryAttributeValue(GoodsCategoryAttributeValueConvertor.toGoodsCategoryAttributeValue(goodsCategoryAttributeValueDTO));
    }

    @Override
    @Transactional(readOnly = true)
    public GoodsCategoryAttributeValueVO getGoodsCategoryAttributeValue(Long id) {
        return GoodsCategoryAttributeValueConvertor.toGoodsCategoryAttributeValueVO(goodsCategoryAttributeValueBiz.getGoodsCategoryAttributeValue(id));
    }

    @Override
    @Transactional(readOnly = true)
    public QueryResultVO<GoodsCategoryAttributeValueVO> queryGoodsCategoryAttributeValue(GoodsCategoryAttributeValueQueryDTO goodsCategoryAttributeValueQueryDTO) {
        return GoodsCategoryAttributeValueConvertor.toQueryResult(goodsCategoryAttributeValueBiz.queryGoodsCategoryAttributeValue(goodsCategoryAttributeValueQueryDTO));
    }

}