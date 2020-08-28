package com.suyan.mall.operation.feignClient.c;

import com.suyan.mall.operation.req.c.AddressListDTO;
import com.suyan.mall.operation.resp.AddressVO;
import com.suyan.result.Result;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;


@FeignClient(value = "mall-operation-c-web", path = "/feign/c/address")
public interface AddressFeignClient {

    /**
     * 根据编码获取信息
     *
     * @param addressCode 地址id
     * @return
     */
    @GetMapping(value = "/getAddressByCode")
    Result<List<AddressVO>> getAddressByCode(@RequestParam("addressCode") String addressCode);

}
