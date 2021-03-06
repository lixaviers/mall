/*
 * Copyright (c) 2020.
 * 项目名称：素焉商城
 * 创建人：素焉
 * 开源地址: https://github.com/lixaviers/mall
 */
package com.suyan.mall.operation.service;

import com.suyan.mall.operation.req.c.AddressListDTO;
import com.suyan.mall.operation.resp.AddressVO;

import java.util.List;

/**
 * @CopyRright (c): <素焉代码生成工具>
 */
public interface IAddressService {

    /**
     * 获取地址信息
     *
     * @param id
     * @return
     */
    List<AddressVO> getAddress(Integer id);

    /**
     * 根据编码获取信息
     *
     * @param addressCode
     * @return
     */
    List<AddressVO> getAddressByCode(String addressCode);

}