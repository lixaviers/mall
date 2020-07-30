package com.suyan.mall.operation.biz;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.suyan.exception.CommonException;
import com.suyan.mall.operation.dao.CategoryMapper;
import com.suyan.mall.operation.model.Category;
import com.suyan.mall.operation.model.CategoryExample;
import com.suyan.mall.operation.req.CategoryQueryDTO;
import com.suyan.query.QueryResultVO;
import com.suyan.result.ResultCode;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @CopyRright (c): <素焉代码生成工具>
 * @Comments: <业务层类目管理类>
 * @jdk 1.8
 * @Version: <1.0>
 */
@Slf4j
@Service
public class CategoryBiz {

    @Autowired
    private CategoryMapper categoryMapper;

    /**
     * 删除类目
     *
     * @param id
     * @return
     */
    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, rollbackFor = Exception.class)
    public Integer deleteCategory(Integer id) {
        // TODO: Describe business logic and implement it
        getBaseCategory(id);
        return categoryMapper.deleteByPrimaryKey(id);
    }

    /**
     * 创建类目
     *
     * @param category
     * @return
     */
    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, rollbackFor = Exception.class)
    public Integer createCategory(Category category) {
        // TODO: Describe business logic and implement it
        categoryMapper.insertSelective(category);
        return category.getId();
    }

    /**
     * 批量创建
     *
     * @param categoryList
     * @return
     */
    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, rollbackFor = Exception.class)
    public int batchCreateCategory(List<Category> categoryList) {
        // TODO: Describe business logic and implement it
        return categoryMapper.insertBatch(categoryList);
    }

    /**
     * 更新类目
     *
     * @param category
     * @return
     */
    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, rollbackFor = Exception.class)
    public Integer updateCategory(Category category) {
        getBaseCategory(category.getId());
        return categoryMapper.updateByPrimaryKeySelective(category);
    }

    /**
     * 根据ID获取类目信息
     *
     * @param id
     * @return
     */
    @Transactional(readOnly = true)
    public Category getCategory(Integer id) {
        return getBaseCategory(id);
    }

    @Transactional(readOnly = true)
    public List<Category> getTree() {
        CategoryExample example = new CategoryExample();
        example.setOrderByClause("sort_number");
        return categoryMapper.selectByExample(example);
    }

    @Transactional(readOnly = true)
    public Category getBaseCategory(Integer id) {
        Category category = categoryMapper.selectByPrimaryKey(id);
        if (category == null) {
            throw new CommonException(ResultCode.DATA_NOT_EXIST, "类目");
        }
        return category;
    }

    /**
     * 分页查询类目信息
     *
     * @param categoryQuery
     * @return
     */
    @Transactional(readOnly = true)
    public QueryResultVO<Category> queryCategory(CategoryQueryDTO categoryQuery) {
        QueryResultVO<Category> queryResult = new QueryResultVO<Category>();
        // 使用分页插件PageHelper实现分页功能
        PageHelper.startPage(categoryQuery.getPageNo(), categoryQuery.getPageSize());
        List<Category> categoryList = categoryMapper.queryCategory(categoryQuery);
        PageInfo<Category> pageInfo = new PageInfo<Category>(categoryList);
        queryResult.setPageNo(pageInfo.getPageNum());
        queryResult.setPageSize(pageInfo.getPageSize());
        queryResult.setTotalPages(pageInfo.getPages());
        queryResult.setTotalRecords(pageInfo.getTotal());
        queryResult.setRecords(categoryList);
        return queryResult;
    }

}