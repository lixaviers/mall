package com.suyan.mall.operation.dao;

import com.suyan.mall.operation.model.Category;
import com.suyan.mall.operation.model.CategoryExample;
import com.suyan.mall.operation.req.CategoryQueryDTO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CategoryMapper {
    
    long countByExample(CategoryExample example);

    int deleteByExample(CategoryExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Category record);

    int insertSelective(Category record);

    List<Category> selectByExample(CategoryExample example);

    Category selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Category record, @Param("example") CategoryExample example);

    int updateByExample(@Param("record") Category record, @Param("example") CategoryExample example);

    int updateByPrimaryKeySelective(Category record);

    int updateByPrimaryKey(Category record);


    Category selectByPrimaryKeyForUpdate(Integer id);

    List<Category> queryCategory(CategoryQueryDTO categoryQuery);

    int insertBatch(@Param("modelList") List<Category> modelList);



}