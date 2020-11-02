/*
 * Copyright (c) 2020.
 * 项目名称：素焉商城
 * 创建人：素焉
 * 开源地址: https://github.com/lixaviers/mall
 */
package com.suyan.mall.user.convertor;

import com.suyan.mall.user.model.DeliverAddress;
import com.suyan.mall.user.req.DeliverAddressDTO;
import com.suyan.mall.user.resp.DeliverAddressVO;
import com.suyan.query.QueryResultVO;
import org.springframework.cglib.beans.BeanCopier;

import java.util.ArrayList;
import java.util.List;

/**
 * @CopyRright (c): <素焉代码生成工具>
 * @Comments: <对象相互转换>
 */
public abstract class DeliverAddressConvertor {

    private static final BeanCopier beanCopierForDeliverAddressVO = BeanCopier.create(DeliverAddress.class, DeliverAddressVO.class, false);
    private static final BeanCopier beanCopierForDeliverAddress = BeanCopier.create(DeliverAddressDTO.class, DeliverAddress.class, false);

    public static DeliverAddressVO toDeliverAddressVO(DeliverAddress deliverAddress) {
        if (deliverAddress == null) {
            return null;
        }
        DeliverAddressVO deliverAddressVO = new DeliverAddressVO();
        beanCopierForDeliverAddressVO.copy(deliverAddress, deliverAddressVO, null);
        return deliverAddressVO;
    }

    public static DeliverAddress toDeliverAddress(DeliverAddressDTO deliverAddressDTO) {
        DeliverAddress deliverAddress = new DeliverAddress();
        beanCopierForDeliverAddress.copy(deliverAddressDTO, deliverAddress, null);
        return deliverAddress;
    }

    public static List<DeliverAddressVO> toDeliverAddressVOList(List<DeliverAddress> deliverAddressList) {
        if (deliverAddressList == null || deliverAddressList.isEmpty()) {
            return null;
        }
        List<DeliverAddressVO> deliverAddressInfoList = new ArrayList<DeliverAddressVO>(deliverAddressList.size());
        for (DeliverAddress deliverAddress : deliverAddressList) {
            deliverAddressInfoList.add(toDeliverAddressVO(deliverAddress));
        }
        return deliverAddressInfoList;
    }

    public static List<DeliverAddress> toDeliverAddressList(List<DeliverAddressDTO> deliverAddressDTOList) {
        if (deliverAddressDTOList == null || deliverAddressDTOList.isEmpty()) {
            return null;
        }
        List<DeliverAddress> deliverAddressList = new ArrayList<DeliverAddress>(deliverAddressDTOList.size());
        for (DeliverAddressDTO deliverAddressDTO : deliverAddressDTOList) {
            deliverAddressList.add(toDeliverAddress(deliverAddressDTO));
        }
        return deliverAddressList;
    }

    public static QueryResultVO<DeliverAddressVO> toQueryResult(QueryResultVO<DeliverAddress> queryResult) {
        QueryResultVO<DeliverAddressVO> queryResultInfo = new QueryResultVO<DeliverAddressVO>();
        queryResultInfo.setPageNo(queryResult.getPageNo());
        queryResultInfo.setPageSize(queryResult.getPageSize());
        queryResultInfo.setTotalPages(queryResult.getTotalPages());
        queryResultInfo.setTotalRecords(queryResult.getTotalRecords());
        queryResultInfo.setRecords(toDeliverAddressVOList(queryResult.getRecords()));
        return queryResultInfo;
    }
}