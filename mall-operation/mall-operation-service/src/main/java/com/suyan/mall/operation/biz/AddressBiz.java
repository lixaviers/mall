/*
 * Copyright (c) 2020.
 * 项目名称：素焉商城
 * 创建人：素焉
 * 开源地址: https://github.com/lixaviers/mall
 */
package com.suyan.mall.operation.biz;

import com.suyan.exception.CommonException;
import com.suyan.mall.operation.dao.AddressMapper;
import com.suyan.mall.operation.model.Address;
import com.suyan.mall.operation.model.AddressExample;
import com.suyan.result.ResultCode;
import com.suyan.utils.CollectionsUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * @CopyRright (c): <素焉代码生成工具>
 * @Comments: <业务层地址管理类>
 * @jdk 1.8
 * @Version: <1.0>
 */
@Slf4j
@Service
public class AddressBiz {

    @Autowired
    private AddressMapper addressMapper;


    /**
     * 获取地址信息
     *
     * @param parentId
     * @return
     */
    @Transactional(readOnly = true)
    public List<Address> getAddress(Integer parentId) {
        AddressExample example = new AddressExample();
        example.createCriteria().andParentIdEqualTo(parentId);
        example.setOrderByClause("order_num");
        return addressMapper.selectByExample(example);
    }

    /**
     * 获取地址信息
     *
     * @return
     */
    @Transactional(readOnly = true)
    public Address getBaseAddress(Integer id, String error) {
        Address address = addressMapper.selectByPrimaryKey(id);
        if (address == null) {
            throw new CommonException(ResultCode.DATA_EXIST, error);
        }
        return address;
    }

    /**
     * 根据编码获取信息
     *
     * @param addressCode
     * @return
     */
    public List<Address> getAddressByCode(String addressCode) {
        List<Address> addressList = new ArrayList<>();
        Address address = addressMapper.selectByAddressCode(addressCode);
        if (address != null) {
            Address addressParent = addressMapper.selectByPrimaryKey(address.getParentId());
            if (addressParent != null) {
                Address addressTop = addressMapper.selectByPrimaryKey(addressParent.getParentId());
                if (addressTop != null) {
                    addressList.add(addressTop);
                }
                addressList.add(addressParent);
            }
            addressList.add(address);
        }
        return addressList;
    }
}