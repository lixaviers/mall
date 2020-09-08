package com.suyan.mall.order.service;

import com.suyan.mall.order.req.ShoppingCartDTO;
import com.suyan.mall.order.req.ShoppingCartQueryDTO;
import com.suyan.mall.order.resp.ShoppingCartVO;
import com.suyan.query.QueryResultVO;

import java.util.List;

/**
 * @CopyRright (c): <素焉代码生成工具>
 */
public interface IShoppingCartService {

    /**
     * 删除购物车
     *
     * @param idList
     * @return
     * @author
     */
    void deleteShoppingCart(List<Long> idList);

    /**
     * 创建购物车
     *
     * @param shoppingCartDTO
     * @return
     */
    void createShoppingCart(ShoppingCartDTO shoppingCartDTO);

    void updateNumber(ShoppingCartDTO shoppingCartDTO);

    /**
     * 根据ID获取购物车信息
     *
     * @param id
     * @return
     */
    ShoppingCartVO getShoppingCart(Long id);

    /**
     * 分页查询购物车信息
     *
     * @param shoppingCartQueryDTO
     * @return
     */
    QueryResultVO<ShoppingCartVO> queryShoppingCart(ShoppingCartQueryDTO shoppingCartQueryDTO);


}