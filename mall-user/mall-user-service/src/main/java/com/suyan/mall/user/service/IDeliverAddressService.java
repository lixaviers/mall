package com.suyan.mall.user.service;

import com.suyan.mall.user.req.DeliverAddressDTO;
import com.suyan.mall.user.req.DeliverAddressQueryDTO;
import com.suyan.mall.user.resp.DeliverAddressVO;
import com.suyan.query.QueryResultVO;

/**
 * @CopyRright (c): <素焉代码生成工具>
 */
public interface IDeliverAddressService {

    /**
     * 删除收货地址
     *
     * @param id
     * @return
     * @author
     */
    int deleteDeliverAddress(Long id);

    /**
     * 创建收货地址
     *
     * @param deliverAddressDTO
     * @return
     */
    Long createDeliverAddress(DeliverAddressDTO deliverAddressDTO);


    /**
     * 更新收货地址
     *
     * @param deliverAddressDTO
     * @return
     */
    int updateDeliverAddress(DeliverAddressDTO deliverAddressDTO);

    /**
     * 根据ID获取收货地址信息
     *
     * @param id
     * @return
     */
    DeliverAddressVO getDeliverAddress(Long id);

    /**
     * 分页查询收货地址信息
     *
     * @param deliverAddressQueryDTO
     * @return
     */
    QueryResultVO<DeliverAddressVO> queryDeliverAddress(DeliverAddressQueryDTO deliverAddressQueryDTO);


    /**
     * 获取用户地址-C端
     *
     * @return
     */
    DeliverAddressVO getAddress();

}