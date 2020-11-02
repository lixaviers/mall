/*
 * Copyright (c) 2020.
 * 项目名称：素焉商城
 * 创建人：素焉
 * 开源地址: https://github.com/lixaviers/mall
 */
package com.suyan.mall.goods.service.impl;

import com.suyan.mall.goods.biz.GoodsAttributeBiz;
import com.suyan.mall.goods.biz.GoodsBiz;
import com.suyan.mall.goods.biz.GoodsDescriptionBiz;
import com.suyan.mall.goods.biz.GoodsSkuBiz;
import com.suyan.mall.goods.convertor.GoodsAttributeConvertor;
import com.suyan.mall.goods.convertor.GoodsConvertor;
import com.suyan.mall.goods.convertor.GoodsSkuConvertor;
import com.suyan.mall.goods.model.Goods;
import com.suyan.mall.goods.model.GoodsDescription;
import com.suyan.mall.goods.req.GoodsDTO;
import com.suyan.mall.goods.req.GoodsQueryDTO;
import com.suyan.mall.goods.req.GoodsSearchDTO;
import com.suyan.mall.goods.resp.GoodsVO;
import com.suyan.mall.goods.service.IGoodsService;
import com.suyan.query.QueryResultVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;


/**
 * @CopyRright (c): <素焉代码生成工具>
 * @Comments: <Service 商品管理类>
 */
@Slf4j
@Service("goodsService")
public class GoodsServiceImpl implements IGoodsService {

    @Autowired
    private GoodsBiz goodsBiz;
    @Autowired
    private GoodsSkuBiz goodsSkuBiz;
    @Autowired
    private GoodsDescriptionBiz goodsDescriptionBiz;
    @Autowired
    private GoodsAttributeBiz goodsAttributeBiz;

    @Override
    public int deleteGoods(Long id) {
        return goodsBiz.deleteGoods(id);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, rollbackFor = Exception.class)
    public void createGoods(GoodsDTO goodsDTO) {
        // 1.创建商品
        Goods goods = GoodsConvertor.toGoods(goodsDTO);
        Long id = goodsBiz.createGoods(goods);

        // 2.创建商品sku
        goodsSkuBiz.batchCreateGoodsSku(id, goods.getSkuList());

        // 3.创建商品描述
        GoodsDescription goodsDescription = new GoodsDescription();
        goodsDescription.setGoodsId(goods.getId());
        goodsDescription.setDescription(goods.getDescription());
        goodsDescriptionBiz.createGoodsDescription(goodsDescription);

        // 4.创建商品属性
        goodsAttributeBiz.createGoodsAttribute(id, goodsDTO.getAttributeList());

    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, rollbackFor = Exception.class)
    public void updateGoods(GoodsDTO goodsDTO) {
        // 编辑商品
        Goods goods = GoodsConvertor.toGoods(goodsDTO);
        Goods goodsLast = goodsBiz.updateGoods(goods);
        // 编辑商品sku
        goodsSkuBiz.updateGoodsSku(goods, goodsLast.getIsMoreSpec());

        // 编辑商品详情
        GoodsDescription goodsDescription = new GoodsDescription();
        goodsDescription.setGoodsId(goodsDTO.getId());
        goodsDescription.setDescription(goodsDTO.getDescription());
        goodsDescriptionBiz.updateGoodsDescription(goodsDescription);

        // 编辑商品属性
        goodsAttributeBiz.updateGoodsAttribute(goodsDTO.getId(), goodsDTO.getAttributeList());
    }

    @Override
    @Transactional(readOnly = true)
    public GoodsVO getGoods(Long id) {
        GoodsVO goodsVO = GoodsConvertor.toGoodsVO(goodsBiz.getGoods(id));
        // 商品sku
        goodsVO.setSkuList(GoodsSkuConvertor.toGoodsSkuVOList(goodsSkuBiz.getGoodsSku(id)));
        // 商品详情
        goodsVO.setDescription(goodsDescriptionBiz.getGoodsDescription(id));
        // 商品属性
        goodsVO.setAttributeList(GoodsAttributeConvertor.toGoodsAttributeVOList(goodsAttributeBiz.getGoodsAttributes(id)));
        return goodsVO;
    }

    @Override
    public GoodsVO getGoodsForC(Long id) {
        return GoodsConvertor.toGoodsVO(goodsBiz.getGoodsForC(id));
    }

    @Override
    public GoodsVO getGoodsInfo(Long id) {
        return GoodsConvertor.toGoodsVO(goodsBiz.getBaseGoods(id));
    }

    @Override
    public List<GoodsVO> getGoodsInfo(List<Long> idList) {
        return GoodsConvertor.toGoodsVOList(goodsBiz.getGoodsInfo(idList));
    }

    @Override
    public QueryResultVO<GoodsVO> queryGoods(GoodsQueryDTO goodsQueryDTO) {
        return GoodsConvertor.toQueryResult(goodsBiz.queryGoods(goodsQueryDTO));
    }

    @Override
    public void shelves(GoodsDTO goodsDTO) {
        goodsBiz.shelves(GoodsConvertor.toGoods(goodsDTO));
    }

    @Override
    public Map<String, Object> search(GoodsSearchDTO goodsSearchDTO) {
        return goodsBiz.search(goodsSearchDTO);
    }
}