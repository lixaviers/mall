/*
 * Copyright (c) 2020.
 * 项目名称：素焉商城
 * 创建人：素焉
 * 开源地址: https://github.com/lixaviers/mall
 */
package com.suyan.mall.goods.service;

import com.suyan.mall.goods.req.GoodsCategoryDTO;
import com.suyan.mall.goods.req.GoodsCategoryQueryDTO;
import com.suyan.mall.goods.resp.GoodsCategoryVO;
import com.suyan.query.QueryResultVO;

import java.util.List;


/**
 * @CopyRright (c): <素焉代码生成工具>
 * @Comments: <Service 商品类目管理类>
 */
public interface IGoodsCategoryService {

    /**
     * 删除商品类目
     *
     * @param id
     * @return
     */
    int deleteGoodsCategory(Integer id);

    /**
     * 创建商品类目
     *
     * @param goodsCategoryDTO
     * @return
     */
    Integer createGoodsCategory(GoodsCategoryDTO goodsCategoryDTO);

    /**
     * 更新商品类目
     *
     * @param goodsCategoryDTO
     * @return
     */
    int updateGoodsCategory(GoodsCategoryDTO goodsCategoryDTO);

    /**
     * 根据ID获取商品类目信息
     *
     * @param id
     * @return
     */
    GoodsCategoryVO getGoodsCategory(Integer id);

    /**
     * 分页查询商品类目信息-E端
     *
     * @param goodsCategoryQueryDTO
     * @return
     */
    QueryResultVO<GoodsCategoryVO> queryGoodsCategory(GoodsCategoryQueryDTO goodsCategoryQueryDTO);

    /**
     * 获取类目树
     *
     * @return
     */
    List<GoodsCategoryVO> getTree(byte type);

    /**
     * 根据父类id查询
     *
     * @param parentId
     * @param type
     * @return
     */
    List<GoodsCategoryVO> getByParentId(Integer parentId, byte type);

    /**
     * 获取最近发布的商品类目-B端
     *
     * @return
     */
    GoodsCategoryVO getRecentlyReleasedGoodsCategory();

}