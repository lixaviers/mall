/*
 * Copyright (c) 2020.
 * 项目名称：素焉商城
 * 创建人：素焉
 * 开源地址: https://github.com/lixaviers/mall
 */
package com.suyan.mall.operation.service.impl;

import com.suyan.mall.operation.biz.ShopBiz;
import com.suyan.mall.operation.convertor.ShopConvertor;
import com.suyan.mall.operation.req.ShopDTO;
import com.suyan.mall.operation.req.ShopQueryDTO;
import com.suyan.mall.operation.resp.ShopVO;
import com.suyan.mall.operation.service.IShopService;
import com.suyan.query.QueryResultVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


/**
 * @CopyRright (c): <素焉代码生成工具>
 * @Comments: <Service 店铺管理类>
 * @jdk 1.8
 * @Version: <1.0>
 */
@Slf4j
@Service("shopService")
public class ShopServiceImpl implements IShopService {

    @Autowired
    private ShopBiz shopBiz;

    @Override
    public int deleteShop(Long id) {
        return shopBiz.deleteShop(id);
    }

    @Override
    public Long createShop(ShopDTO shopDTO) {
        return shopBiz.createShop(ShopConvertor.toShop(shopDTO));
    }

    @Override
    public int updateShop(ShopDTO shopDTO) {
        return shopBiz.updateShop(ShopConvertor.toShop(shopDTO));
    }

    @Override
    public List<ShopVO> getShopList(String uniqueUserId) {
        return ShopConvertor.toShopVOList(shopBiz.getShopList(uniqueUserId));
    }

    @Override
    public ShopVO getShop(Long id) {
        return ShopConvertor.toShopVO(shopBiz.getShop(id));
    }

    @Override
    public QueryResultVO<ShopVO> queryShop(ShopQueryDTO shopQueryDTO) {
        return ShopConvertor.toQueryResult(shopBiz.queryShop(shopQueryDTO));
    }

    @Override
    public ShopVO select(String uniqueUserId, Long id) {
        return ShopConvertor.toShopVO(shopBiz.select(uniqueUserId, id));
    }
}