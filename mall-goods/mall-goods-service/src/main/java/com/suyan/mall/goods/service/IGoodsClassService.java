/*
 * Copyright (c) 2020.
 * 项目名称：素焉商城
 * 创建人：素焉
 * 开源地址: https://github.com/lixaviers/mall
 */
package com.suyan.mall.goods.service;

import com.suyan.mall.goods.req.GoodsClassDTO;
import com.suyan.mall.goods.req.GoodsClassQueryDTO;
import com.suyan.mall.goods.resp.GoodsClassVO;
import com.suyan.query.QueryResultVO;

/**
 * @CopyRright (c): <素焉代码生成工具>
 */
public interface IGoodsClassService {

    /**
     * 删除商品分类
     *
     * @param id
     * @return
     * @author
     */
    int deleteGoodsClass(Long id);

    /**
     * 创建商品分类
     *
     * @param goodsClassDTO
     * @return
     */
    Long createGoodsClass(GoodsClassDTO goodsClassDTO);


    /**
     * 更新商品分类
     *
     * @param goodsClassDTO
     * @return
     */
    int updateGoodsClass(GoodsClassDTO goodsClassDTO);

    /**
     * 根据ID获取商品分类信息
     *
     * @param id
     * @return
     */
    GoodsClassVO getGoodsClass(Long id);

    /**
     * 分页查询商品分类信息
     *
     * @param goodsClassQueryDTO
     * @return
     */
    QueryResultVO<GoodsClassVO> queryGoodsClass(GoodsClassQueryDTO goodsClassQueryDTO);


}