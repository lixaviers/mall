/*
 * Copyright (c) 2020.
 * 项目名称：素焉商城
 * 创建人：素焉
 * 开源地址: https://github.com/lixaviers/mall
 */
package com.suyan.mall.operation.service;

import com.suyan.mall.operation.req.CategoryDTO;
import com.suyan.mall.operation.req.CategoryQueryDTO;
import com.suyan.mall.operation.resp.CategoryVO;
import com.suyan.query.QueryResultVO;

import java.util.List;

/**
 * @CopyRright (c): <素焉代码生成工具>
 */
public interface ICategoryService {

    /**
     * 删除类目
     *
     * @param id
     * @return
     */
    int deleteCategory(Integer id);

    /**
     * 创建类目
     *
     * @param categoryDTO
     * @return
     */
    Integer createCategory(CategoryDTO categoryDTO);

    /**
     * 更新类目
     *
     * @param categoryDTO
     * @return
     */
    int updateCategory(CategoryDTO categoryDTO);

    /**
     * 获取类目树
     *
     * @return
     */
    List<CategoryVO> getTree();

    /**
     * 分页查询类目信息
     *
     * @param categoryQueryDTO
     * @return
     */
    QueryResultVO<CategoryVO> queryCategory(CategoryQueryDTO categoryQueryDTO);


}