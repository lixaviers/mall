package com.suyan.mall.order.biz;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.suyan.exception.CommonException;
import com.suyan.mall.order.dao.OrderGoodsMapper;
import com.suyan.mall.order.enums.OrderStatusEnum;
import com.suyan.mall.order.model.OrderGoods;
import com.suyan.mall.order.req.OrderGoodsQueryDTO;
import com.suyan.mall.user.resp.b.UserInfoVO;
import com.suyan.query.QueryResultVO;
import com.suyan.result.ResultCode;
import com.suyan.utils.CollectionsUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @CopyRright (c): <素焉代码生成工具>
 * @Comments: <业务层订单商品管理类>
 */
@Slf4j
@Service
public class OrderGoodsBiz {

    @Autowired
    private OrderGoodsMapper orderGoodsMapper;

    /**
     * 删除订单商品
     *
     * @param id
     * @return
     */
    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, rollbackFor = Exception.class)
    public Integer deleteOrderGoods(Long id) {
        getBaseOrderGoods(id);
        return orderGoodsMapper.logicalDeleteByPrimaryKey(id);
    }

    /**
     * 创建订单商品
     *
     * @param orderGoodsList
     * @return
     */
    public void createOrderGoods(List<OrderGoods> orderGoodsList, UserInfoVO user, String orderNumber) {
        if (CollectionsUtil.isEmpty(orderGoodsList)) {
            throw new CommonException(ResultCode.COMMON_PARAM_INVALID, "商品");
        }
        for (OrderGoods orderGoods : orderGoodsList) {
            // 这里的金额已经在创建订单时处理好了
            orderGoods.setUniqueUserId(user.getUniqueUserId());
            orderGoods.setShopId(user.getShopId());
            orderGoods.setCommonStatus(OrderStatusEnum.PAYMENT.getValue());
            orderGoods.setOrderNumber(orderNumber);
            orderGoodsMapper.insertSelective(orderGoods);
        }
    }


    /**
     * 更新订单商品
     *
     * @param orderGoods
     * @return
     */
    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, rollbackFor = Exception.class)
    public Integer updateOrderGoods(OrderGoods orderGoods) {
        getBaseOrderGoods(orderGoods.getId());
        return orderGoodsMapper.updateByPrimaryKeySelective(orderGoods);
    }

    /**
     * 根据ID获取订单商品信息
     *
     * @param id
     * @return
     */
    @Transactional(readOnly = true)
    public OrderGoods getOrderGoods(Long id) {
        return getBaseOrderGoods(id);
    }

    @Transactional(readOnly = true)
    public OrderGoods getBaseOrderGoods(Long id) {
        OrderGoods orderGoods = orderGoodsMapper.selectByPrimaryKey(id);
        if (orderGoods == null || orderGoods.getIsDeleted()) {
            throw new CommonException(ResultCode.DATA_NOT_EXIST, "订单商品");
        }
        return orderGoods;
    }

    /**
     * 分页查询订单商品信息
     *
     * @param orderGoodsQuery
     * @return
     */
    @Transactional(readOnly = true)
    public QueryResultVO<OrderGoods> queryOrderGoods(OrderGoodsQueryDTO orderGoodsQuery) {
        QueryResultVO<OrderGoods> queryResult = new QueryResultVO<OrderGoods>();
        // 使用分页插件PageHelper实现分页功能
        PageHelper.startPage(orderGoodsQuery.getPageNo(), orderGoodsQuery.getPageSize());
        List<OrderGoods> orderGoodsList = orderGoodsMapper.queryOrderGoods(orderGoodsQuery);
        PageInfo<OrderGoods> pageInfo = new PageInfo<OrderGoods>(orderGoodsList);
        queryResult.setPageNo(pageInfo.getPageNum());
        queryResult.setPageSize(pageInfo.getPageSize());
        queryResult.setTotalPages(pageInfo.getPages());
        queryResult.setTotalRecords(pageInfo.getTotal());
        queryResult.setRecords(orderGoodsList);
        return queryResult;
    }

}