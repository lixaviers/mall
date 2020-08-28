package com.suyan.mall.user.controller;

import com.suyan.mall.user.req.DeliverAddressDTO;
import com.suyan.mall.user.req.DeliverAddressQueryDTO;
import com.suyan.mall.user.resp.DeliverAddressVO;
import com.suyan.mall.user.resp.b.UserInfoVO;
import com.suyan.mall.user.service.IDeliverAddressService;
import com.suyan.query.QueryResultVO;
import com.suyan.result.Result;
import com.suyan.service.BaseInterface;
import com.suyan.service.UpdateInterface;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RequestMapping("/c/deliverAddress")
@RestController
@Api(tags = "收货地址管理接口")
public class DeliverAddressController extends BaseController {

    @Autowired
    private IDeliverAddressService deliverAddressService;

    @ApiOperation(value = "删除收货地址", notes = "删除收货地址")
    @PostMapping("delete")
    public Result<Integer> delete(@PathVariable Long id) {
        UserInfoVO user = getUser();
        return Result.newSuccess(deliverAddressService.deleteDeliverAddress(id));
    }

    @ApiOperation(value = "创建收货地址", notes = "创建收货地址")
    @PostMapping("add")
    public Result<Long> add(@Validated({BaseInterface.class}) @RequestBody DeliverAddressDTO deliverAddressDTO) {
        return Result.newSuccess(deliverAddressService.createDeliverAddress(deliverAddressDTO));
    }

    @ApiOperation(value = "更新收货地址", notes = "更新收货地址")
    @PostMapping("update")
    public Result<Integer> update(@Validated({UpdateInterface.class}) @RequestBody DeliverAddressDTO deliverAddressDTO) {
        return Result.newSuccess(deliverAddressService.updateDeliverAddress(deliverAddressDTO));
    }

    @ApiOperation(value = "获取收货地址信息", notes = "根据收货地址ID获取收货地址信息")
    @GetMapping("get/{id}")
    public Result<DeliverAddressVO> get(@PathVariable Long id) {
        return Result.newSuccess(deliverAddressService.getDeliverAddress(id));
    }

    @ApiOperation(value = "获取收货地址列表信息", notes = "分页获取收货地址列表信息")
    @PostMapping("query")
    public Result<QueryResultVO<DeliverAddressVO>> queryDeliverAddress(@Validated @RequestBody DeliverAddressQueryDTO deliverAddressQueryDTO) {
        deliverAddressQueryDTO.setIsDeleted(false);
        return Result.newSuccess(deliverAddressService.queryDeliverAddress(deliverAddressQueryDTO));
    }

}
