/*
 * Copyright (c) 2020.
 * 项目名称：素焉商城
 * 创建人：素焉
 * 开源地址: https://github.com/lixaviers/mall
 */
package com.suyan.mall.order.service.impl;

import com.suyan.mall.goods.enums.GoodsStatusEnum;
import com.suyan.mall.goods.resp.GoodsSkuVO;
import com.suyan.mall.order.biz.ShoppingCartBiz;
import com.suyan.mall.order.client.GoodsSkuClient;
import com.suyan.mall.order.convertor.ShoppingCartConvertor;
import com.suyan.mall.order.req.ShoppingCartDTO;
import com.suyan.mall.order.req.ShoppingCartQueryDTO;
import com.suyan.mall.order.resp.ShoppingCartVO;
import com.suyan.mall.order.service.IShoppingCartService;
import com.suyan.query.QueryResultVO;
import com.suyan.result.Result;
import com.suyan.utils.CollectionsUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


/**
 * @CopyRright (c): <素焉代码生成工具>
 * @Comments: <Service 购物车管理类>
 */
@Slf4j
@Service("shoppingCartService")
public class ShoppingCartServiceImpl implements IShoppingCartService {

    @Autowired
    private ShoppingCartBiz shoppingCartBiz;

    @Autowired
    private GoodsSkuClient goodsSkuClient;

    @Override
    public void deleteShoppingCart(List<Long> idList) {
        shoppingCartBiz.deleteShoppingCart(idList);
    }

    @Override
    public void createShoppingCart(ShoppingCartDTO shoppingCartDTO) {
        shoppingCartBiz.createShoppingCart(ShoppingCartConvertor.toShoppingCart(shoppingCartDTO));
    }

    @Override
    public void updateNumber(ShoppingCartDTO shoppingCartDTO) {
        shoppingCartBiz.updateNumber(ShoppingCartConvertor.toShoppingCart(shoppingCartDTO));
    }

    @Override
    public ShoppingCartVO getShoppingCart(Long id) {
        return ShoppingCartConvertor.toShoppingCartVO(shoppingCartBiz.getShoppingCart(id));
    }

    @Override
    public QueryResultVO<ShoppingCartVO> queryShoppingCart(ShoppingCartQueryDTO shoppingCartQueryDTO) {
        QueryResultVO<ShoppingCartVO> queryResultVO = ShoppingCartConvertor.toQueryResult(shoppingCartBiz.queryShoppingCart(shoppingCartQueryDTO));

        if (queryResultVO.getTotalRecords() > 0) {
            List<String> goodsSkuCodes = queryResultVO.getRecords().stream().map(ShoppingCartVO::getGoodsSkuCode).collect(Collectors.toList());
            Result<List<GoodsSkuVO>> result = goodsSkuClient.getGoodsInfo(goodsSkuCodes);
            if (CollectionsUtil.isNotEmpty(result.getData())) {
                Map<String, GoodsSkuVO> map = result.getData().stream().collect(Collectors.toMap(GoodsSkuVO::getSkuCode, item -> item));
                for (ShoppingCartVO shoppingCartVO : queryResultVO.getRecords()) {
                    GoodsSkuVO goodsSkuVO = map.get(shoppingCartVO.getGoodsSkuCode());
                    if (goodsSkuVO != null) {
                        if (GoodsStatusEnum.NORMAL.equal(goodsSkuVO.getCommonStatus())) {
                            // 正常
                            shoppingCartVO.setIsGoodsFailure(false);
                        }
                        shoppingCartVO.setGoodsId(goodsSkuVO.getGoodsId());
                        shoppingCartVO.setGoodsName(goodsSkuVO.getGoodsName());
                        shoppingCartVO.setGoodsRealPrice(goodsSkuVO.getPrice());
                        shoppingCartVO.setGoodsInventory(goodsSkuVO.getInventory());
                        shoppingCartVO.setGoodsPicture(goodsSkuVO.getGoodsPicture());
                        shoppingCartVO.setGoodsSpecValue(goodsSkuVO.getSpecValue());
                    }
                }
            }
        }
        return queryResultVO;
    }

    @Override
    public void collect(List<Long> idList) {
        shoppingCartBiz.collect(idList);
    }

}
