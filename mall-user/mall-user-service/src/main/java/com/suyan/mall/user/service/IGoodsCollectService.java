/*
 * Copyright (c) 2020.
 * 项目名称：素焉商城
 * 创建人：素焉
 * 开源地址: https://github.com/lixaviers/mall
 */
package com.suyan.mall.user.service;

import com.suyan.mall.user.req.GoodsCollectDTO;
import com.suyan.mall.user.req.GoodsCollectQueryDTO;
import com.suyan.mall.user.req.c.BatchGoodsCollectDTO;
import com.suyan.mall.user.resp.GoodsCollectVO;
import com.suyan.query.QueryResultVO;

import java.util.List;

/**
 * @CopyRright (c): <素焉代码生成工具>
 */
public interface IGoodsCollectService {

    /**
     * 删除商品收藏
     *
     * @param id
     * @return
     * @author
     */
    int deleteGoodsCollect(Long id);

    /**
     * 创建商品收藏
     *
     * @param goodsCollectDTO
     * @return
     */
    void createGoodsCollect(GoodsCollectDTO goodsCollectDTO);

    void batchCreateGoodsCollect(BatchGoodsCollectDTO batchGoodsCollectDTO);


    /**
     * 分页查询商品收藏信息
     *
     * @param goodsCollectQueryDTO
     * @return
     */
    QueryResultVO<GoodsCollectVO> queryGoodsCollect(GoodsCollectQueryDTO goodsCollectQueryDTO);


    /**
     * 根据商品id查询是否收藏
     *
     * @param goodsId
     * @return
     */
    Boolean get(Long goodsId);

    /**
     * 查询收藏商品数
     *
     * @return
     */
    Integer getNumber();

}