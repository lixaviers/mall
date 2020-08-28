package com.suyan.mall.operation.feignClient.c;

import com.suyan.mall.operation.req.c.AddressListDTO;
import com.suyan.mall.operation.resp.AddressVO;
import com.suyan.result.Result;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;


@FeignClient(value = "mall-operation-c-web", path = "/feign/c/address")
public interface AddressFeignClient {

    /**
     * 根据id获取地址信息
     *
     * @param dto 地址id
     * @return
     */
    @GetMapping(value = "/getAddressList")
    Result<List<AddressVO>> getAddressList(@RequestBody AddressListDTO dto);

}
