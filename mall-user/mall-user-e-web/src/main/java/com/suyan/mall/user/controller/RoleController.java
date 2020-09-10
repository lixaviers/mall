package com.suyan.mall.user.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import com.suyan.mall.user.convertor.RoleConvertor;
import org.springframework.validation.BindingResult;
import com.suyan.mall.user.req.RoleDTO;
import com.suyan.mall.user.req.RoleQueryDTO;
import com.suyan.mall.user.resp.RoleVO;
import com.suyan.query.QueryResultVO;
import com.suyan.result.Result;
import com.suyan.result.ResultCode;
import com.suyan.service.BaseInterface;
import com.suyan.service.UpdateInterface;
import com.suyan.mall.user.service.IRoleService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import javax.validation.Valid;

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
    @PostMapping("add")
    public Result<Long> add(@Validated({BaseInterface.class}) @RequestBody RoleDTO roleDTO) {
        return Result.newSuccess(roleService.createRole(roleDTO));
    }
    
    @ApiOperation(value = "更新", notes = "更新")
    @PostMapping("update")
    public Result<Integer> update(@Validated({BaseInterface.class, UpdateInterface.class}) @RequestBody RoleDTO roleDTO) {
        return Result.newSuccess(roleService.updateRole(roleDTO));
    }
    
    @ApiOperation(value = "获取信息", notes = "根据ID获取信息")
    @GetMapping("get/{id}")
    public Result<RoleVO> get(@PathVariable Long id ){
        return Result.newSuccess(roleService.getRole(id));
    }
    
    @ApiOperation(value = "获取列表信息", notes = "分页获取列表信息")
    @PostMapping("query")
    public Result<QueryResultVO<RoleVO>> queryRole(@Validated @RequestBody RoleQueryDTO roleQueryDTO){
        roleQueryDTO.setIsDeleted(false);
        return Result.newSuccess(roleService.queryRole(roleQueryDTO));
    }
}
