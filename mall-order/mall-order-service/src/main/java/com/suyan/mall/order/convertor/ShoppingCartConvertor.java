/*
 * Copyright (c) 2020.
 * 项目名称：素焉商城
 * 创建人：素焉
 * 开源地址: https://github.com/lixaviers/mall
 */
package com.suyan.mall.order.convertor;

import com.suyan.mall.order.model.ShoppingCart;
import com.suyan.mall.order.req.ShoppingCartDTO;
import com.suyan.mall.order.resp.ShoppingCartVO;
import com.suyan.query.QueryResultVO;
import org.springframework.cglib.beans.BeanCopier;

import java.util.ArrayList;
import java.util.List;

/**
 * @CopyRright (c): <素焉代码生成工具>
 * @Comments: <对象相互转换>
 */
public abstract class ShoppingCartConvertor {

    private static final BeanCopier beanCopierForShoppingCartVO = BeanCopier.create(ShoppingCart.class, ShoppingCartVO.class, false);
    private static final BeanCopier beanCopierForShoppingCart = BeanCopier.create(ShoppingCartDTO.class, ShoppingCart.class, false);

    public static ShoppingCartVO toShoppingCartVO(ShoppingCart shoppingCart) {
        if (shoppingCart == null) {
            return null;
        }
        ShoppingCartVO shoppingCartVO = new ShoppingCartVO();
        beanCopierForShoppingCartVO.copy(shoppingCart, shoppingCartVO, null);
        return shoppingCartVO;
    }

    public static ShoppingCart toShoppingCart(ShoppingCartDTO shoppingCartDTO) {
        ShoppingCart shoppingCart = new ShoppingCart();
        beanCopierForShoppingCart.copy(shoppingCartDTO, shoppingCart, null);
        return shoppingCart;
    }

    public static List<ShoppingCartVO> toShoppingCartVOList(List<ShoppingCart> shoppingCartList) {
        if (shoppingCartList == null || shoppingCartList.isEmpty()) {
            return null;
        }
        List<ShoppingCartVO> shoppingCartInfoList = new ArrayList<ShoppingCartVO>(shoppingCartList.size());
        for (ShoppingCart shoppingCart : shoppingCartList) {
            shoppingCartInfoList.add(toShoppingCartVO(shoppingCart));
        }
        return shoppingCartInfoList;
    }

    public static List<ShoppingCart> toShoppingCartList(List<ShoppingCartDTO> shoppingCartDTOList) {
        if (shoppingCartDTOList == null || shoppingCartDTOList.isEmpty()) {
            return null;
        }
        List<ShoppingCart> shoppingCartList = new ArrayList<ShoppingCart>(shoppingCartDTOList.size());
        for (ShoppingCartDTO shoppingCartDTO : shoppingCartDTOList) {
            shoppingCartList.add(toShoppingCart(shoppingCartDTO));
        }
        return shoppingCartList;
    }

    public static QueryResultVO<ShoppingCartVO> toQueryResult(QueryResultVO<ShoppingCart> queryResult) {
        QueryResultVO<ShoppingCartVO> queryResultInfo = new QueryResultVO<ShoppingCartVO>();
        queryResultInfo.setPageNo(queryResult.getPageNo());
        queryResultInfo.setPageSize(queryResult.getPageSize());
        queryResultInfo.setTotalPages(queryResult.getTotalPages());
        queryResultInfo.setTotalRecords(queryResult.getTotalRecords());
        queryResultInfo.setRecords(toShoppingCartVOList(queryResult.getRecords()));
        return queryResultInfo;
    }
}