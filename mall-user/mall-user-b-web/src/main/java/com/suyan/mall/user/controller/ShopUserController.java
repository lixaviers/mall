/*
 * Copyright (c) 2020.
 * 项目名称：素焉商城
 * 创建人：素焉
 * 开源地址: https://github.com/lixaviers/mall
 */
package com.suyan.mall.user.controller;

import com.suyan.annotation.PassLogin;
import com.suyan.controller.BaseController;
import com.suyan.mall.user.constants.Constant;
import com.suyan.mall.user.constants.RedisKey;
import com.suyan.mall.user.enums.SmsSourceEnum;
import com.suyan.mall.user.enums.SystemPlatformEnum;
import com.suyan.mall.user.req.UserDTO;
import com.suyan.mall.user.resp.b.UserInfoVO;
import com.suyan.mall.user.service.IUserService;
import com.suyan.mall.user.service.impl.UserServiceImpl;
import com.suyan.mall.user.utils.RedisUtil;
import com.suyan.mall.user.utils.UserUtil;
import com.suyan.result.Result;
import com.suyan.result.ResultCode;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.UUID;

@Slf4j
@RequestMapping("/b/shopUser")
@RestController
@Api(tags = "用户管理接口")
public class ShopUserController extends BaseController {

    @Autowired
    private IUserService userService;

    @ApiOperation(value = "商户登录", notes = "商户登录")
    @PostMapping("login")
    @PassLogin
    public Result<UserInfoVO> login(@Validated(UserDTO.StoreLogin.class) @RequestBody UserDTO userDTO) {
        UserInfoVO userInfoVO = userService.shopLogin(userDTO);
        setUserInfoCache(userInfoVO);
        return Result.newSuccess(userInfoVO);
    }

    @ApiOperation(value = "商户注册", notes = "商户注册")
    @PostMapping("register")
    @PassLogin
    public Result<UserInfoVO> register(@Validated(UserDTO.StoreRegister.class) @RequestBody UserDTO userDTO) {
        // 验证短信验证码
        String redisKey = RedisKey.getMobileCodeKey(userDTO.getMobile(), SmsSourceEnum.STORE_REGISTER.getValue());
        Object object = RedisUtil.get(redisKey);
        if (object == null) {
            return Result.newError(ResultCode.COMMON_MESSAGE, "短信验证码错误");
        }
        if (!String.valueOf(object).equals(userDTO.getSmsVerCode())) {
            return Result.newError(ResultCode.COMMON_MESSAGE, "短信验证码错误");
        }
        UserInfoVO userInfoVO = userService.shopRegister(userDTO);
        setUserInfoCache(userInfoVO);

        // 删除短信验证码缓存
        RedisUtil.delete(redisKey);
        return Result.newSuccess(userInfoVO);
    }

    @ApiOperation(value = "商户退出", notes = "商户退出")
    @PostMapping("logout")
    public Result logout() {
        RedisUtil.delete(RedisKey.getTokenKey(getRequest().getHeader(Constant.HEADER_KEY), SystemPlatformEnum.B.getCode()));
        return Result.newSuccess();
    }

    private void setUserInfoCache(UserInfoVO userInfoVO) {
        userInfoVO.setSystemPlatform(SystemPlatformEnum.B);
        String sessionId = UUID.randomUUID().toString();
        userInfoVO.setSessionId(sessionId);
        UserUtil.setRedisUser(userInfoVO, sessionId, SystemPlatformEnum.B.getCode());
    }


}
