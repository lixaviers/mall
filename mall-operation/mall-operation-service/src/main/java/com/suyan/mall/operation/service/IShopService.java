/*
 * Copyright (c) 2020.
 * 项目名称：素焉商城
 * 创建人：素焉
 * 开源地址: https://github.com/lixaviers/mall
 */
package com.suyan.mall.operation.service;

import com.suyan.mall.operation.req.ShopDTO;
import com.suyan.mall.operation.req.ShopQueryDTO;
import com.suyan.mall.operation.resp.ShopVO;
import com.suyan.query.QueryResultVO;

import java.util.List;

/**
 * @CopyRright (c): <素焉代码生成工具>
 */
public interface IShopService {

    /**
     * 删除店铺
     *
     * @param id
     * @return
     */
    int deleteShop(Long id);

    /**
     * 创建店铺
     *
     * @param shopDTO
     * @return
     */
    Long createShop(ShopDTO shopDTO);

    /**
     * 更新店铺
     *
     * @param shopDTO
     * @return
     */
    int updateShop(ShopDTO shopDTO);

    /**
     * 获取店铺信息
     *
     * @return
     */
    List<ShopVO> getShopList(String uniqueUserId);

    /**
     * 获取店铺信息
     *
     * @return
     */
    ShopVO getShop(Long id);

    /**
     * 分页查询店铺信息
     *
     * @param shopQueryDTO
     * @return
     */
    QueryResultVO<ShopVO> queryShop(ShopQueryDTO shopQueryDTO);

    /**
     * 选择店铺
     *
     * @param uniqueUserId
     * @param id
     * @return
     */
    ShopVO select(String uniqueUserId, Long id);


}