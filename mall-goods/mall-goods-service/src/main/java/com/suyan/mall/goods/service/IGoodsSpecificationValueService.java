/*
 * Copyright (c) 2020.
 * 项目名称：素焉商城
 * 创建人：素焉
 * 开源地址: https://github.com/lixaviers/mall
 */
package com.suyan.mall.goods.service;

import com.suyan.mall.goods.req.GoodsSpecificationValueDTO;
import com.suyan.mall.goods.req.GoodsSpecificationValueQueryDTO;
import com.suyan.mall.goods.resp.GoodsSpecificationValueVO;
import com.suyan.query.QueryResultVO;


/**
 * @CopyRright (c): <素焉代码生成工具>
 * @Comments: <Service 商品规格值管理类>
 */
public interface IGoodsSpecificationValueService {

    /**
     * 删除商品规格值
     *
     * @param id
     * @return
     */
    int deleteGoodsSpecificationValue(Long id);

    /**
     * 创建商品规格值
     *
     * @param goodsSpecificationValueDTO
     * @return
     */
    Long createGoodsSpecificationValue(GoodsSpecificationValueDTO goodsSpecificationValueDTO);

    /**
     * 更新商品规格值
     *
     * @param goodsSpecificationValueDTO
     * @return
     */
    int updateGoodsSpecificationValue(GoodsSpecificationValueDTO goodsSpecificationValueDTO);

    /**
     * 根据ID获取商品规格值信息
     *
     * @param id
     * @return
     */
    GoodsSpecificationValueVO getGoodsSpecificationValue(Long id);

    /**
     * 分页查询商品规格值信息
     *
     * @param goodsSpecificationValueQueryDTO
     * @return
     */
    QueryResultVO<GoodsSpecificationValueVO> queryGoodsSpecificationValue(GoodsSpecificationValueQueryDTO goodsSpecificationValueQueryDTO);

}