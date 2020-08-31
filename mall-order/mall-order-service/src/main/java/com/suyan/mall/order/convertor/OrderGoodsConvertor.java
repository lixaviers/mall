package com.suyan.mall.order.convertor;

import com.suyan.mall.order.model.OrderGoods;
import com.suyan.mall.order.req.OrderGoodsDTO;
import com.suyan.mall.order.resp.OrderGoodsVO;
import com.suyan.query.QueryResultVO;
import org.springframework.cglib.beans.BeanCopier;

import java.util.ArrayList;
import java.util.List;

/**
 * @CopyRright (c): <素焉代码生成工具>
 * @Comments: <对象相互转换>
 */
public abstract class OrderGoodsConvertor {

    private static final BeanCopier beanCopierForOrderGoodsVO = BeanCopier.create(OrderGoods.class, OrderGoodsVO.class, false);
    private static final BeanCopier beanCopierForOrderGoods = BeanCopier.create(OrderGoodsDTO.class, OrderGoods.class, false);

    public static OrderGoodsVO toOrderGoodsVO(OrderGoods orderGoods) {
        if (orderGoods == null) {
            return null;
        }
        OrderGoodsVO orderGoodsVO = new OrderGoodsVO();
        beanCopierForOrderGoodsVO.copy(orderGoods, orderGoodsVO, null);
        return orderGoodsVO;
    }

    public static OrderGoods toOrderGoods(OrderGoodsDTO orderGoodsDTO) {
        OrderGoods orderGoods = new OrderGoods();
        beanCopierForOrderGoods.copy(orderGoodsDTO, orderGoods, null);
        return orderGoods;
    }

    public static List<OrderGoodsVO> toOrderGoodsVOList(List<OrderGoods> orderGoodsList) {
        if (orderGoodsList == null || orderGoodsList.isEmpty()) {
            return null;
        }
        List<OrderGoodsVO> orderGoodsInfoList = new ArrayList<OrderGoodsVO>(orderGoodsList.size());
        for (OrderGoods orderGoods : orderGoodsList) {
            orderGoodsInfoList.add(toOrderGoodsVO(orderGoods));
        }
        return orderGoodsInfoList;
    }

    public static List<OrderGoods> toOrderGoodsList(List<OrderGoodsDTO> orderGoodsDTOList) {
        if (orderGoodsDTOList == null || orderGoodsDTOList.isEmpty()) {
            return null;
        }
        List<OrderGoods> orderGoodsList = new ArrayList<OrderGoods>(orderGoodsDTOList.size());
        for (OrderGoodsDTO orderGoodsDTO : orderGoodsDTOList) {
            orderGoodsList.add(toOrderGoods(orderGoodsDTO));
        }
        return orderGoodsList;
    }

    public static QueryResultVO<OrderGoodsVO> toQueryResult(QueryResultVO<OrderGoods> queryResult) {
        QueryResultVO<OrderGoodsVO> queryResultInfo = new QueryResultVO<OrderGoodsVO>();
        queryResultInfo.setPageNo(queryResult.getPageNo());
        queryResultInfo.setPageSize(queryResult.getPageSize());
        queryResultInfo.setTotalPages(queryResult.getTotalPages());
        queryResultInfo.setTotalRecords(queryResult.getTotalRecords());
        queryResultInfo.setRecords(toOrderGoodsVOList(queryResult.getRecords()));
        return queryResultInfo;
    }
}