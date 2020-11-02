/*
 * Copyright (c) 2020.
 * 项目名称：素焉商城
 * 创建人：素焉
 * 开源地址: https://github.com/lixaviers/mall
 */
package com.suyan.mall.mmc.controller;

import com.suyan.mall.mmc.enums.PromotionUseTypeEnum;
import com.suyan.result.Result;
import com.suyan.vo.EnumEntityVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
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
        for (PromotionUseTypeEnum value : PromotionUseTypeEnum.values()) {
            if (value.getType() == type) {
                list.add(new EnumEntityVO(value.getValue(), value.getDesc()));
            }
        }
        return Result.newSuccess(list);
    }
}
