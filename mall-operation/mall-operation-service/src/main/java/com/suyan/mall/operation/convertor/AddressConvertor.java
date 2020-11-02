/*
 * Copyright (c) 2020.
 * 项目名称：素焉商城
 * 创建人：素焉
 * 开源地址: https://github.com/lixaviers/mall
 */
/*
 * Copyright (c) 2020.
 * 项目名称：素焉商城
 * 创建人：素焉
 * 开源地址: https://github.com/lixaviers/mall
 */
package com.suyan.mall.operation.convertor;

import com.suyan.mall.operation.model.Address;
import com.suyan.mall.operation.resp.AddressVO;
import com.suyan.query.QueryResultVO;
import org.springframework.cglib.beans.BeanCopier;

import java.util.ArrayList;
import java.util.List;

/**
 * @CopyRright (c): <素焉代码生成工具>
 * @Comments: <对象相互转换>
 * @jdk 1.8
 * @Version: <1.0>
 */
public abstract class AddressConvertor {

    private static final BeanCopier beanCopierForAddressVO = BeanCopier.create(Address.class, AddressVO.class, false);

    public static AddressVO toAddressVO(Address address) {
        if (address == null) {
            return null;
        }
        AddressVO addressVO = new AddressVO();
        beanCopierForAddressVO.copy(address, addressVO, null);
        return addressVO;
    }

    public static List<AddressVO> toAddressVOList(List<Address> addressList) {
        if (addressList == null || addressList.isEmpty()) {
            return null;
        }
        List<AddressVO> addressInfoList = new ArrayList<AddressVO>(addressList.size());
        for (Address address : addressList) {
            addressInfoList.add(toAddressVO(address));
        }
        return addressInfoList;
    }

    public static QueryResultVO<AddressVO> toQueryResult(QueryResultVO<Address> queryResult) {
        QueryResultVO<AddressVO> queryResultInfo = new QueryResultVO<AddressVO>();
        queryResultInfo.setPageNo(queryResult.getPageNo());
        queryResultInfo.setPageSize(queryResult.getPageSize());
        queryResultInfo.setTotalPages(queryResult.getTotalPages());
        queryResultInfo.setTotalRecords(queryResult.getTotalRecords());
        queryResultInfo.setRecords(toAddressVOList(queryResult.getRecords()));
        return queryResultInfo;
    }

}