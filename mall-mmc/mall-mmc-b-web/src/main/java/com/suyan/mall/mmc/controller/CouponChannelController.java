package com.suyan.mall.mmc.controller;

import com.suyan.mall.mmc.enums.CouponChannelTypeEnum;
import com.suyan.result.Result;
import com.suyan.vo.EnumEntityVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@RequestMapping("/b/couponChannel")
@RestController
@Api(tags = "优惠券渠道管理接口")
public class CouponChannelController extends BaseController {

    @ApiOperation(value = "渠道列表", notes = "渠道列表")
    @GetMapping("getTypes")
    public Result<List<EnumEntityVO>> getTypes() {
        List<EnumEntityVO> list = new ArrayList<>();
        for (CouponChannelTypeEnum value : CouponChannelTypeEnum.values()) {
            list.add(new EnumEntityVO(value.getValue(), value.getDesc()));
        }
        return Result.newSuccess(list);
    }

}
