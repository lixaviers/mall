/*
 * Copyright (c) 2020.
 * 项目名称：素焉商城
 * 创建人：素焉
 * 开源地址: https://github.com/lixaviers/mall
 */
package com.suyan.mall.user.service;

import com.suyan.mall.user.req.ShopCollectDTO;
import com.suyan.mall.user.req.ShopCollectQueryDTO;
import com.suyan.mall.user.resp.ShopCollectVO;
import com.suyan.query.QueryResultVO;

/**
 * @CopyRright (c): <素焉代码生成工具>
 */
public interface IShopCollectService {

    /**
     * 删除店铺收藏
     *
     * @param id
     * @return
     * @author
     */
    int deleteShopCollect(Long id);

    /**
     * 创建店铺收藏
     *
     * @param shopCollectDTO
     * @return
     */
    Long createShopCollect(ShopCollectDTO shopCollectDTO);


    /**
     * 置顶店铺收藏
     *
     * @param shopCollectDTO
     * @return
     */
    void setTop(ShopCollectDTO shopCollectDTO);

    /**
     * 根据ID获取店铺收藏信息
     *
     * @param id
     * @return
     */
    ShopCollectVO getShopCollect(Long id);

    /**
     * 分页查询店铺收藏信息
     *
     * @param shopCollectQueryDTO
     * @return
     */
    QueryResultVO<ShopCollectVO> queryShopCollect(ShopCollectQueryDTO shopCollectQueryDTO);


}