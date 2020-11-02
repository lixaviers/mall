/*
 * Copyright (c) 2020.
 * 项目名称：素焉商城
 * 创建人：素焉
 * 开源地址: https://github.com/lixaviers/mall
 */
package com.suyan.mall.goods.biz;

import com.suyan.exception.CommonException;
import com.suyan.mall.goods.dao.biz.GoodsCategoryAttributeBizMapper;
import com.suyan.mall.goods.model.GoodsCategoryAttribute;
import com.suyan.mall.goods.model.GoodsCategoryAttributeExample;
import com.suyan.result.ResultCode;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @CopyRright (c): <素焉代码生成工具>
 * @Comments: <业务层商品类目属性管理类>
 */
@Slf4j
@Service
public class GoodsCategoryAttributeBiz {

    @Autowired
    private GoodsCategoryAttributeBizMapper goodsCategoryAttributeBizMapper;

    /**
     * 删除商品类目属性
     *
     * @param id
     * @return
     */
    public Integer deleteGoodsCategoryAttribute(Long id) {
        getBaseGoodsCategoryAttribute(id);
        return goodsCategoryAttributeBizMapper.logicalDeleteByPrimaryKey(id);
    }

    /**
     * 创建商品类目属性
     *
     * @param goodsCategoryAttribute
     * @return
     */
    public Long createGoodsCategoryAttribute(GoodsCategoryAttribute goodsCategoryAttribute) {
        goodsCategoryAttributeBizMapper.insertSelective(goodsCategoryAttribute);
        return goodsCategoryAttribute.getId();
    }

    /**
     * 更新商品类目属性
     *
     * @param goodsCategoryAttribute
     * @return
     */
    public Integer updateGoodsCategoryAttribute(GoodsCategoryAttribute goodsCategoryAttribute) {
        return goodsCategoryAttributeBizMapper.updateByPrimaryKeySelective(goodsCategoryAttribute);
    }

    /**
     * 根据ID获取商品类目属性信息
     *
     * @param id
     * @return
     */
    public GoodsCategoryAttribute getGoodsCategoryAttribute(Long id) {
        return getBaseGoodsCategoryAttribute(id);
    }

    public GoodsCategoryAttribute getBaseGoodsCategoryAttribute(Long id) {
        GoodsCategoryAttribute goodsCategoryAttribute = goodsCategoryAttributeBizMapper.selectByPrimaryKey(id);
        if (goodsCategoryAttribute == null || goodsCategoryAttribute.getIsDeleted()) {
            throw new CommonException(ResultCode.DATA_NOT_EXIST, "商品类目属性");
        }
        return goodsCategoryAttribute;
    }

    public List<GoodsCategoryAttribute> getByCategoryId(Integer categoryId) {
        GoodsCategoryAttributeExample example = new GoodsCategoryAttributeExample();
        example.createCriteria().andIsDeletedEqualTo(false).andCategoryIdEqualTo(categoryId);
        example.setOrderByClause("sort_number, id");
        return goodsCategoryAttributeBizMapper.selectByExample(example);
    }

    /**
     * 根据商品类目获取最大排序值
     *
     * @param categoryId
     * @return
     */
    public int getMaxSortNumberByCategoryId(Integer categoryId) {
        return goodsCategoryAttributeBizMapper.getMaxSortNumberByCategoryId(categoryId);
    }

    public List<GoodsCategoryAttribute> getTreeByCategoryId(Integer categoryId) {
        return goodsCategoryAttributeBizMapper.getTreeByCategoryId(categoryId);
    }

    /**
     * 根据id列表查询
     *
     * @param idList
     * @return
     */
    public List<GoodsCategoryAttribute> getByIdList(List<Long> idList) {
        GoodsCategoryAttributeExample example = new GoodsCategoryAttributeExample();
        example.createCriteria().andIsDeletedEqualTo(false).andIsEnableEqualTo(true).andIdIn(idList);
        return goodsCategoryAttributeBizMapper.selectByExample(example);
    }
}