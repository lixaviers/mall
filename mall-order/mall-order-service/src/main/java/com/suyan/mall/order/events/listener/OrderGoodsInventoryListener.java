package com.suyan.mall.order.events.listener;

import com.suyan.exception.CommonException;
import com.suyan.mall.goods.feignClient.c.GoodsSkuCFeignClient;
import com.suyan.mall.goods.req.GoodsSkuDTO;
import com.suyan.mall.goods.req.c.GoodsSkuDeductionInventoryDTO;
import com.suyan.mall.order.events.OrderCreateEvent;
import com.suyan.mall.order.events.OrderCreateEventContext;
import com.suyan.mall.order.model.OrderGoods;
import com.suyan.result.Result;
import com.suyan.utils.JsonUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * 订单商品库存处理
 * 这里可以有两种处理逻辑
 * 1、先调用扣减库存，在异步创建订单（需调整Order顺序）
 * 2、先创建订单，在调用扣减库存（我使用此方法）
 */
@Component
@Order(4)
@Slf4j
public class OrderGoodsInventoryListener implements ApplicationListener<OrderCreateEvent> {

    @Autowired
    private GoodsSkuCFeignClient goodsSkuCFeignClient;

    @Override
    public void onApplicationEvent(OrderCreateEvent event) {
        log.info("创建订单-商品扣减库存");
        OrderCreateEventContext context = event.getContext();
        List<GoodsSkuDTO> goodsSkuDTOList = new ArrayList<>(context.getOrder().getOrderGoodsList().size());
        for (OrderGoods orderGoods : context.getOrder().getOrderGoodsList()) {
            GoodsSkuDTO goodsSkuDTO = new GoodsSkuDTO();
            goodsSkuDTO.setSkuCode(orderGoods.getGoodsSkuCode());
            goodsSkuDTO.setNumber(orderGoods.getGoodsNumber());
            goodsSkuDTOList.add(goodsSkuDTO);
        }
        GoodsSkuDeductionInventoryDTO dto = new GoodsSkuDeductionInventoryDTO();
        dto.setGoodsSkuList(goodsSkuDTOList);
        log.info("调用商品根据商品编码列表扣减库存入参={}", JsonUtil.toJsonString(dto));
        Result<Integer> result = goodsSkuCFeignClient.deductionInventory(dto);
        log.info("调用商品根据商品编码列表扣减库存出参={}", JsonUtil.toJsonString(result));
        if (!result.isSuccess()) {
            throw new CommonException(result.getCode(), result.getMessage());
        }
    }

}
