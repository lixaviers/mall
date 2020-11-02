/*
 * Copyright (c) 2020.
 * 项目名称：素焉商城
 * 创建人：素焉
 * 开源地址: https://github.com/lixaviers/mall
 */
package com.suyan.mall.operation.service.impl;

import com.suyan.mall.operation.biz.CategoryBiz;
import com.suyan.mall.operation.convertor.CategoryConvertor;
import com.suyan.mall.operation.model.Category;
import com.suyan.mall.operation.req.CategoryDTO;
import com.suyan.mall.operation.req.CategoryQueryDTO;
import com.suyan.mall.operation.resp.CategoryVO;
import com.suyan.mall.operation.service.ICategoryService;
import com.suyan.query.QueryResultVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


/**
 * @CopyRright (c): <素焉代码生成工具>
 * @Comments: <Service 类目管理类>
 * @jdk 1.8
 * @Version: <1.0>
 */
@Slf4j
@Service("categoryService")
public class CategoryServiceImpl implements ICategoryService {

    @Autowired
    private CategoryBiz categoryBiz;

    @Override
    public int deleteCategory(Integer id) {
        return categoryBiz.deleteCategory(id);
    }

    @Override
    public Integer createCategory(CategoryDTO categoryDTO) {
        Category category = CategoryConvertor.toCategory(categoryDTO);
        return categoryBiz.createCategory(category);
    }

    @Override
    public int updateCategory(CategoryDTO categoryDTO) {
        Category category = CategoryConvertor.toCategory(categoryDTO);
        return categoryBiz.updateCategory(category);
    }

    @Override
    public List<CategoryVO> getTree() {
        return CategoryConvertor.toTree(categoryBiz.getTree());
    }

    @Override
    public QueryResultVO<CategoryVO> queryCategory(CategoryQueryDTO categoryQueryDTO) {
        return CategoryConvertor.toQueryResult(categoryBiz.queryCategory(categoryQueryDTO));
    }

}