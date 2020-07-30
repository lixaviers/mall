package com.suyan.mall.operation.service.impl;

import com.suyan.mall.operation.biz.AddressBiz;
import com.suyan.mall.operation.convertor.AddressConvertor;
import com.suyan.mall.operation.resp.AddressVO;
import com.suyan.mall.operation.service.IAddressService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


/**
 * @CopyRright (c): <素焉代码生成工具>
 * @Comments: <Service 地址管理类>
 * @jdk 1.8
 * @Version: <1.0>
 */
@Slf4j
@Service("addressService")
public class AddressServiceImpl implements IAddressService {

    @Autowired
    private AddressBiz addressBiz;

    @Override
    public List<AddressVO> getAddress(Integer id) {
        return AddressConvertor.toAddressVOList(addressBiz.getAddress(id));
    }


}