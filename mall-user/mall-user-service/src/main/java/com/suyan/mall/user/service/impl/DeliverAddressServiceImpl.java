/*
 * Copyright (c) 2020.
 * 项目名称：素焉商城
 * 创建人：素焉
 * 开源地址: https://github.com/lixaviers/mall
 */
package com.suyan.mall.user.service.impl;

import com.suyan.mall.user.biz.DeliverAddressBiz;
import com.suyan.mall.user.convertor.DeliverAddressConvertor;
import com.suyan.mall.user.req.DeliverAddressDTO;
import com.suyan.mall.user.req.DeliverAddressQueryDTO;
import com.suyan.mall.user.resp.DeliverAddressVO;
import com.suyan.mall.user.service.IDeliverAddressService;
import com.suyan.query.QueryResultVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * @CopyRright (c): <素焉代码生成工具>
 * @Comments: <Service 收货地址管理类>
 */
@Slf4j
@Service("deliverAddressService")
public class DeliverAddressServiceImpl implements IDeliverAddressService {

    @Autowired
    private DeliverAddressBiz deliverAddressBiz;

    @Override
    public int deleteDeliverAddress(Long id) {
        return deliverAddressBiz.deleteDeliverAddress(id);
    }

    @Override
    public Long createDeliverAddress(DeliverAddressDTO deliverAddressDTO) {
        return deliverAddressBiz.createDeliverAddress(DeliverAddressConvertor.toDeliverAddress(deliverAddressDTO));
    }

    @Override
    public int updateDeliverAddress(DeliverAddressDTO deliverAddressDTO) {
        return deliverAddressBiz.updateDeliverAddress(DeliverAddressConvertor.toDeliverAddress(deliverAddressDTO));
    }

    @Override
    public DeliverAddressVO getDeliverAddress(Long id) {
        return DeliverAddressConvertor.toDeliverAddressVO(deliverAddressBiz.getDeliverAddress(id));
    }

    @Override
    public QueryResultVO<DeliverAddressVO> queryDeliverAddress(DeliverAddressQueryDTO deliverAddressQueryDTO) {
        return DeliverAddressConvertor.toQueryResult(deliverAddressBiz.queryDeliverAddress(deliverAddressQueryDTO));
    }

    @Override
    public DeliverAddressVO getAddress() {
        return DeliverAddressConvertor.toDeliverAddressVO(deliverAddressBiz.getAddress());
    }

}