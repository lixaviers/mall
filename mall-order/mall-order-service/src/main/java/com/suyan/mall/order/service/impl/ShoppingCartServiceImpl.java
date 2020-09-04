package com.suyan.mall.order.service.impl;

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
    public int deleteShoppingCart(Long id) {
        return shoppingCartBiz.deleteShoppingCart(id);
    }

    @Override
    public void createShoppingCart(ShoppingCartDTO shoppingCartDTO) {
        shoppingCartBiz.createShoppingCart(ShoppingCartConvertor.toShoppingCart(shoppingCartDTO));
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
                        shoppingCartVO.setIsGoodsFailure(false);
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

}
