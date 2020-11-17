/*
 * Copyright (c) 2020.
 * 项目名称：素焉商城
 * 创建人：素焉
 * 开源地址: https://github.com/lixaviers/mall
 */
package com.suyan.mall.goods.service.impl;

import com.suyan.exception.CommonException;
import com.suyan.mall.goods.biz.GoodsBiz;
import com.suyan.mall.goods.biz.GoodsClassBiz;
import com.suyan.mall.goods.convertor.GoodsClassConvertor;
import com.suyan.mall.goods.model.Goods;
import com.suyan.mall.goods.req.GoodsClassDTO;
import com.suyan.mall.goods.req.GoodsClassQueryDTO;
import com.suyan.mall.goods.resp.GoodsClassVO;
import com.suyan.mall.goods.service.IGoodsClassService;
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
 * @Comments: <Service 商品分类管理类>
 */
@Slf4j
@Service("goodsClassService")
public class GoodsClassServiceImpl implements IGoodsClassService {

    @Autowired
    private GoodsClassBiz goodsClassBiz;
    @Autowired
    private GoodsBiz goodsBiz;

    @Override
    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, rollbackFor = Exception.class)
    public int deleteGoodsClass(Long id) {
        // 查询商品分类是否存在
        goodsClassBiz.getBaseGoodsClass(id);
        List<Goods> goodsList = goodsBiz.getByGoodsClassId(id);
        if (CollectionsUtil.isNotEmpty(goodsList)) {
            throw new CommonException(ResultCode.COMMON_MESSAGE, "分类下有商品，不能删除");
        }
        // 查询商品分类下是否有商品，有不能删除
        return goodsClassBiz.deleteGoodsClass(id);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, rollbackFor = Exception.class)
    public Long createGoodsClass(GoodsClassDTO goodsClassDTO) {
        return goodsClassBiz.createGoodsClass(GoodsClassConvertor.toGoodsClass(goodsClassDTO));
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, rollbackFor = Exception.class)
    public int updateGoodsClass(GoodsClassDTO goodsClassDTO) {
        return goodsClassBiz.updateGoodsClass(GoodsClassConvertor.toGoodsClass(goodsClassDTO));
    }

    @Override
    @Transactional(readOnly = true)
    public GoodsClassVO getGoodsClass(Long id) {
        return GoodsClassConvertor.toGoodsClassVO(goodsClassBiz.getGoodsClass(id));
    }

    @Override
    @Transactional(readOnly = true)
    public QueryResultVO<GoodsClassVO> queryGoodsClass(GoodsClassQueryDTO goodsClassQueryDTO) {
        return GoodsClassConvertor.toQueryResult(goodsClassBiz.queryGoodsClass(goodsClassQueryDTO));
    }

}