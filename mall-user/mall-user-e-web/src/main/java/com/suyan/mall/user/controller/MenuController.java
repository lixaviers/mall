package com.suyan.mall.user.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import com.suyan.mall.user.convertor.MenuConvertor;
import org.springframework.validation.BindingResult;
import com.suyan.mall.user.req.MenuDTO;
import com.suyan.mall.user.req.MenuQueryDTO;
import com.suyan.mall.user.resp.MenuVO;
import com.suyan.query.QueryResultVO;
import com.suyan.result.Result;
import com.suyan.result.ResultCode;
import com.suyan.service.BaseInterface;
import com.suyan.service.UpdateInterface;
import com.suyan.mall.user.service.IMenuService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import javax.validation.Valid;
import java.util.List;

@Slf4j
@RequestMapping("menu")
@RestController
@Api(tags = "菜单管理接口")
public class MenuController extends BaseController {

    @Autowired
    private IMenuService menuService;

    @ApiOperation(value = "获取菜单信息", notes = "获取当前登录管理员菜单")
    @GetMapping("getAdminMenu")
    public Result<List<MenuVO>> getAdminMenu() {
        return Result.newSuccess(menuService.getAdminMenu());
    }

    @ApiOperation(value = "获取所有菜单信息", notes = "获取所有菜单信息")
    @GetMapping("getAllMenu")
    public Result<List<MenuVO>> getAllMenu() {
        return Result.newSuccess(menuService.getAllMenu());
    }

    @ApiOperation(value = "删除菜单", notes = "删除菜单")
    @PostMapping("delete/{id}")
    public Result<Integer> delete(@PathVariable Long id) {
        return Result.newSuccess(menuService.deleteMenu(id));
    }

    @ApiOperation(value = "创建菜单", notes = "创建菜单")
    @PostMapping("add")
    public Result<Long> add(@Validated({BaseInterface.class}) @RequestBody MenuDTO menuDTO) {
        return Result.newSuccess(menuService.createMenu(menuDTO));
    }

    @ApiOperation(value = "更新菜单", notes = "更新菜单")
    @PostMapping("update")
    public Result<Integer> update(@Validated({UpdateInterface.class, BaseInterface.class}) @RequestBody MenuDTO menuDTO) {
        return Result.newSuccess(menuService.updateMenu(menuDTO));
    }

    @ApiOperation(value = "获取菜单信息", notes = "根据菜单ID获取菜单信息")
    @GetMapping("get/{id}")
    public Result<MenuVO> get(@PathVariable Long id) {
        return Result.newSuccess(menuService.getMenu(id));
    }

    @ApiOperation(value = "获取菜单列表信息", notes = "分页获取菜单列表信息")
    @PostMapping("query")
    public Result<QueryResultVO<MenuVO>> queryMenu(@Validated @RequestBody MenuQueryDTO menuQueryDTO) {
        menuQueryDTO.setIsDeleted(false);
        return Result.newSuccess(menuService.queryMenu(menuQueryDTO));
    }

}
