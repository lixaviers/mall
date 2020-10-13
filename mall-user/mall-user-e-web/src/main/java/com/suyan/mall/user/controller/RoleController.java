package com.suyan.mall.user.controller;

import com.suyan.mall.user.req.RoleDTO;
import com.suyan.mall.user.req.RoleQueryDTO;
import com.suyan.mall.user.resp.RoleVO;
import com.suyan.mall.user.service.IRoleService;
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
@RequestMapping("role")
@RestController
@Api(tags = "管理接口")
public class RoleController extends BaseController {

    @Autowired
    private IRoleService roleService;

    @ApiOperation(value = "删除", notes = "删除")
    @PostMapping("delete/{id}")
    public Result<Integer> delete(@PathVariable Long id) {
        return Result.newSuccess(roleService.deleteRole(id));
    }

    @ApiOperation(value = "创建", notes = "创建")
    @PostMapping("addOrUpdate")
    public Result addOrUpdate(@Validated({BaseInterface.class}) @RequestBody RoleDTO roleDTO) {
        if(roleDTO.getId() == null) {
            roleService.createRole(roleDTO);
        } else {
            roleService.updateRole(roleDTO);
        }
        return Result.newSuccess();
    }

    @ApiOperation(value = "获取信息", notes = "根据ID获取信息")
    @GetMapping("get/{id}")
    public Result<RoleVO> get(@PathVariable Long id) {
        return Result.newSuccess(roleService.getRole(id));
    }

    @ApiOperation(value = "获取列表信息", notes = "分页获取列表信息")
    @PostMapping("query")
    public Result<QueryResultVO<RoleVO>> queryRole(@Validated @RequestBody RoleQueryDTO roleQueryDTO) {
        roleQueryDTO.setIsDeleted(false);
        return Result.newSuccess(roleService.queryRole(roleQueryDTO));
    }

}
