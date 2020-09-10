package com.suyan.mall.user.controller;

import com.suyan.mall.user.enums.SystemPlatformEnum;
import com.suyan.mall.user.req.AdminDTO;
import com.suyan.mall.user.req.AdminQueryDTO;
import com.suyan.mall.user.resp.AdminVO;
import com.suyan.mall.user.resp.b.UserInfoVO;
import com.suyan.mall.user.service.IAdminService;
import com.suyan.mall.user.utils.UserUtil;
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

import java.util.UUID;

@Slf4j
@RequestMapping("admin")
@RestController
@Api(tags = "管理员管理接口")
public class AdminController extends BaseController {

    @Autowired
    private IAdminService adminService;

    @ApiOperation(value = "创建管理员", notes = "创建管理员")
    @PostMapping("login")
    public Result<UserInfoVO> login(@Validated({AdminDTO.Login.class}) @RequestBody AdminDTO adminDTO) {
        UserInfoVO userInfoVO = adminService.login(adminDTO);
        userInfoVO.setSystemPlatform(SystemPlatformEnum.E);
        String sessionId = UUID.randomUUID().toString();
        userInfoVO.setSessionId(sessionId);
        UserUtil.setRedisUser(userInfoVO, sessionId, SystemPlatformEnum.E.getCode());
        return Result.newSuccess(userInfoVO);
    }

    @ApiOperation(value = "删除管理员", notes = "删除管理员")
    @PostMapping("delete/{id}")
    public Result<Integer> delete(@PathVariable Long id) {
        return Result.newSuccess(adminService.deleteAdmin(id));
    }

    @ApiOperation(value = "创建管理员", notes = "创建管理员")
    @PostMapping("add")
    public Result<Long> add(@Validated({BaseInterface.class}) @RequestBody AdminDTO adminDTO) {
        return Result.newSuccess(adminService.createAdmin(adminDTO));
    }

    @ApiOperation(value = "更新管理员", notes = "更新管理员")
    @PostMapping("update")
    public Result<Integer> update(@Validated({BaseInterface.class, UpdateInterface.class}) @RequestBody AdminDTO adminDTO) {
        return Result.newSuccess(adminService.updateAdmin(adminDTO));
    }

    @ApiOperation(value = "获取管理员信息", notes = "根据管理员ID获取管理员信息")
    @GetMapping("get/{id}")
    public Result<AdminVO> get(@PathVariable Long id) {
        return Result.newSuccess(adminService.getAdmin(id));
    }

    @ApiOperation(value = "获取管理员列表信息", notes = "分页获取管理员列表信息")
    @PostMapping("query")
    public Result<QueryResultVO<AdminVO>> queryAdmin(@Validated @RequestBody AdminQueryDTO adminQueryDTO) {
        adminQueryDTO.setIsDeleted(false);
        return Result.newSuccess(adminService.queryAdmin(adminQueryDTO));
    }
}
