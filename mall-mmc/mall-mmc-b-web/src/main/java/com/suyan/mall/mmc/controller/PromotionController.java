package com.suyan.mall.mmc.controller;

import com.suyan.mall.mmc.enums.PromotionTypeEnum;
import com.suyan.mall.mmc.req.CouponDTO;
import com.suyan.mall.mmc.req.CouponQueryDTO;
import com.suyan.mall.mmc.resp.CouponVO;
import com.suyan.mall.mmc.service.ICouponService;
import com.suyan.query.QueryResultVO;
import com.suyan.result.Result;
import com.suyan.service.BaseInterface;
import com.suyan.vo.EnumEntityVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@RequestMapping("/b/promotion")
@RestController
@Api(tags = "促销管理接口")
public class PromotionController extends BaseController {

    @ApiOperation(value = "获取促销类型", notes = "获取促销类型")
    @GetMapping("getTypes/{type}")
    public Result<List<EnumEntityVO>> getTypes(@PathVariable byte type) {
        List<EnumEntityVO> list = new ArrayList<>();
        for (PromotionTypeEnum value : PromotionTypeEnum.values()) {
            if (value.getType() == type) {
                list.add(new EnumEntityVO(value.getValue(), value.getDesc()));
            }
        }
        return Result.newSuccess(list);
    }
}
