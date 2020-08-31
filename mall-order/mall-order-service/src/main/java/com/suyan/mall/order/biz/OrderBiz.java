package com.suyan.mall.order.biz;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.suyan.exception.CommonException;
import com.suyan.mall.goods.feignClient.c.GoodsSkuCFeignClient;
import com.suyan.mall.goods.resp.GoodsSkuVO;
import com.suyan.mall.order.dao.OrderMapper;
import com.suyan.mall.order.enums.OrderStatusEnum;
import com.suyan.mall.order.model.Order;
import com.suyan.mall.order.model.OrderGoods;
import com.suyan.mall.order.req.OrderQueryDTO;
import com.suyan.mall.order.resp.OrderVO;
import com.suyan.mall.user.resp.b.UserInfoVO;
import com.suyan.query.QueryResultVO;
import com.suyan.result.Result;
import com.suyan.result.ResultCode;
import com.suyan.utils.CodeGeneratorUtil;
import com.suyan.utils.JsonUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @CopyRright (c): <素焉代码生成工具>
 * @Comments: <业务层订单管理类>
 */
@Slf4j
@Service
public class OrderBiz {

    @Autowired
    private OrderMapper orderMapper;

    @Autowired
    private GoodsSkuCFeignClient goodsSkuCFeignClient;

    /**
     * 创建订单
     *
     * @param order
     * @return
     */
    public OrderVO createOrder(Order order, UserInfoVO user) {
        // 1、查询商品信息
        List<OrderGoods> orderGoodsList = order.getOrderGoodsList();
        List<String> goodsSkuCodeList = orderGoodsList.stream().map(OrderGoods::getGoodsSkuCode).collect(Collectors.toList());
        log.info("根据商品编码列表查询商品信息入参={}", JsonUtil.toJsonString(goodsSkuCodeList));
        Result<List<GoodsSkuVO>> result = goodsSkuCFeignClient.get(goodsSkuCodeList);
        log.info("根据商品编码列表查询商品信息出参={}", JsonUtil.toJsonString(result));
        if (!result.isSuccess()) {
            throw new CommonException(ResultCode.API_INVLID_DATA, "商品");
        }

        // 2、封装商品信息
        List<GoodsSkuVO> goodsSkuVOList = result.getData();
        Map<String, GoodsSkuVO> goodsMap = goodsSkuVOList.stream().collect(Collectors.toMap(GoodsSkuVO::getSkuCode, bean -> bean));
        // 订单总金额
        BigDecimal total = BigDecimal.ZERO;
        for (OrderGoods orderGoods : orderGoodsList) {
            GoodsSkuVO goodsSkuVO = goodsMap.get(orderGoods.getGoodsSkuCode());
            if (goodsSkuVO == null) {
                throw new CommonException(ResultCode.DATA_NOT_EXIST, "商品" + orderGoods.getGoodsSkuCode());
            }
            orderGoods.setGoodsName(goodsSkuVO.getGoodsName());
            orderGoods.setGoodsPrice(goodsSkuVO.getPrice());
            orderGoods.setSpecValue(goodsSkuVO.getSpecValue());
            orderGoods.setGoodsPicture(goodsSkuVO.getGoodsPicture());
            // sku总金额
            BigDecimal skuTotalAmount = orderGoods.getGoodsPrice().multiply(new BigDecimal(orderGoods.getGoodsNumber()));
            orderGoods.setTotalAmount(skuTotalAmount);
            total = total.add(skuTotalAmount);
        }

        order.setTotalAmount(total);
        // 待付款
        order.setOrderStatus(OrderStatusEnum.PAYMENT.getValue());
        order.setUniqueUserId(user.getUniqueUserId());
        order.setShopId(user.getShopId());
        create(order, user.getUniqueUserId());

        OrderVO orderVO = new OrderVO();
        orderVO.setOrderNumber(order.getOrderNumber());
        orderVO.setTotalAmount(order.getTotalAmount());
        return orderVO;
    }

    /**
     * 创建订单，这里不做订单号重复查询，往库里插入订单号，重复触发唯一索引约束，递归创建订单
     *
     * @param order
     * @param uniqueUserId
     */
    private void create(Order order, String uniqueUserId) {
        try {
            // 订单号
            order.setOrderNumber(CodeGeneratorUtil.generateOrderNumber(uniqueUserId));
            orderMapper.insertSelective(order);
        } catch (Exception e) {
            if (e instanceof DuplicateKeyException) {
                log.warn("出现了生成订单号重复现象，orderNumber={}", order.getOrderNumber());
                create(order, uniqueUserId);
            }
            throw e;
        }
    }

    /**
     * 删除订单
     *
     * @param id
     * @return
     */
    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, rollbackFor = Exception.class)
    public Integer deleteOrder(Long id) {
        getBaseOrder(id);
        return orderMapper.logicalDeleteByPrimaryKey(id);
    }

    /**
     * 更新订单
     *
     * @param order
     * @return
     */
    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, rollbackFor = Exception.class)
    public Integer updateOrder(Order order) {
        getBaseOrder(order.getId());
        return orderMapper.updateByPrimaryKeySelective(order);
    }

    /**
     * 根据ID获取订单信息
     *
     * @param id
     * @return
     */
    @Transactional(readOnly = true)
    public Order getOrder(Long id) {
        return getBaseOrder(id);
    }

    @Transactional(readOnly = true)
    public Order getBaseOrder(Long id) {
        Order order = orderMapper.selectByPrimaryKey(id);
        if (order == null || order.getIsDeleted()) {
            throw new CommonException(ResultCode.DATA_NOT_EXIST, "订单");
        }
        return order;
    }

    /**
     * 分页查询订单信息
     *
     * @param orderQuery
     * @return
     */
    @Transactional(readOnly = true)
    public QueryResultVO<Order> queryOrder(OrderQueryDTO orderQuery) {
        QueryResultVO<Order> queryResult = new QueryResultVO<Order>();
        // 使用分页插件PageHelper实现分页功能
        PageHelper.startPage(orderQuery.getPageNo(), orderQuery.getPageSize());
        List<Order> orderList = orderMapper.queryOrder(orderQuery);
        PageInfo<Order> pageInfo = new PageInfo<Order>(orderList);
        queryResult.setPageNo(pageInfo.getPageNum());
        queryResult.setPageSize(pageInfo.getPageSize());
        queryResult.setTotalPages(pageInfo.getPages());
        queryResult.setTotalRecords(pageInfo.getTotal());
        queryResult.setRecords(orderList);
        return queryResult;
    }

    @Transactional(readOnly = true)
    public Order getOrder(String orderNumber) {
        Order order = orderMapper.selectByOrderNumber(orderNumber);
        if (order == null || order.getIsDeleted()) {
            throw new CommonException(ResultCode.DATA_NOT_EXIST, "订单");
        }
        return order;
    }

}