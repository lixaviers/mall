/*
 * Copyright (c) 2020.
 * 项目名称：素焉商城
 * 创建人：素焉
 * 开源地址: https://github.com/lixaviers/mall
 */
package com.suyan.mall.goods.service;

import com.suyan.mall.goods.req.GoodsCategoryAttributeDTO;
import com.suyan.mall.goods.resp.GoodsCategoryAttributeQueryVO;
import com.suyan.mall.goods.resp.GoodsCategoryAttributeVO;

import java.util.List;

/**
 * @CopyRright (c): <素焉代码生成工具>
 */
public interface IGoodsCategoryAttributeService {

    /**
     * 删除商品类目属性
     *
     * @param id
     * @return
     * @author
     */
    void deleteGoodsCategoryAttribute(Long id);

    /**
     * 创建商品类目属性
     *
     * @param goodsCategoryAttributeDTO
     * @return
     */
    Long createGoodsCategoryAttribute(GoodsCategoryAttributeDTO goodsCategoryAttributeDTO);


    /**
     * 更新商品类目属性
     *
     * @param goodsCategoryAttributeDTO
     * @return
     */
    int updateGoodsCategoryAttribute(GoodsCategoryAttributeDTO goodsCategoryAttributeDTO);

    /**
     * 根据ID获取商品类目属性信息
     *
     * @param id
     * @return
     */
    GoodsCategoryAttributeVO getGoodsCategoryAttribute(Long id);

    /**
     * 查询商品类目属性信息
     *
     * @return
     */
    List<GoodsCategoryAttributeQueryVO> getByCategoryId(Integer categoryId);

    /**
     * 根据商品类目获取最大排序值
     *
     * @param categoryId
     * @return
     */
    Integer getMaxSortNumberByCategoryId(Integer categoryId);

    /**
     * 查询商品类目属性信息
     *
     * @return
     */
    List<GoodsCategoryAttributeVO> getTreeByCategoryId(Integer categoryId);

}