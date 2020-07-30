package com.suyan.mall.operation.service;

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


}