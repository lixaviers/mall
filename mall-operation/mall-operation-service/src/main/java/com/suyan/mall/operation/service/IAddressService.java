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
     * 获取地址树
     * @return
     */
    List<AddressVO> getTree();

    /**
     * 根据列表获取地址信息
     *
     * @param dto
     * @return
     */
    List<AddressVO> getAddressList(AddressListDTO dto);

}