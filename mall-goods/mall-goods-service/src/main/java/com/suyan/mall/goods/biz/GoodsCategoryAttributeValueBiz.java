/*
 * Copyright (c) 2020.
 * 项目名称：素焉商城
 * 创建人：素焉
 * 开源地址: https://github.com/lixaviers/mall
 */
package com.suyan.mall.goods.biz;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.suyan.exception.CommonException;
import com.suyan.mall.goods.dao.GoodsCategoryAttributeValueMapper;
import com.suyan.mall.goods.model.GoodsCategoryAttributeValue;
import com.suyan.mall.goods.model.GoodsCategoryAttributeValueExample;
import com.suyan.mall.goods.req.GoodsCategoryAttributeValueQueryDTO;
import com.suyan.query.QueryResultVO;
import com.suyan.result.ResultCode;
import com.suyan.utils.CollectionsUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @CopyRright (c): <素焉代码生成工具>
 * @Comments: <业务层商品类目属性值管理类>
 */
@Slf4j
@Service
public class GoodsCategoryAttributeValueBiz {

    @Autowired
    private GoodsCategoryAttributeValueMapper goodsCategoryAttributeValueMapper;

    /**
     * 删除商品类目属性值
     *
     * @return
     */
    public Integer deleteGoodsCategoryAttributeValue(Long id) {
        getBaseGoodsCategoryAttributeValue(id);
        return goodsCategoryAttributeValueMapper.logicalDeleteByPrimaryKey(id);
    }

    public Integer deleteGoodsCategoryAttributeValueByGoodsCategoryAttributeId(Long goodsCategoryAttributeId) {
        GoodsCategoryAttributeValueExample example = new GoodsCategoryAttributeValueExample();
        example.createCriteria().andIsDeletedEqualTo(false).andGoodsCategoryAttributeIdEqualTo(goodsCategoryAttributeId);
        GoodsCategoryAttributeValue goodsCategoryAttributeValue = new GoodsCategoryAttributeValue();
        goodsCategoryAttributeValue.setIsDeleted(true);
        return goodsCategoryAttributeValueMapper.updateByExampleSelective(goodsCategoryAttributeValue, example);
    }

    /**
     * 创建商品类目属性值
     *
     * @param goodsCategoryAttributeValue
     * @return
     */
    public Long createGoodsCategoryAttributeValue(GoodsCategoryAttributeValue goodsCategoryAttributeValue) {
        goodsCategoryAttributeValueMapper.insertSelective(goodsCategoryAttributeValue);
        return goodsCategoryAttributeValue.getId();
    }

    /**
     * 批量创建
     *
     * @return
     */
    public void batchCreateGoodsCategoryAttributeValue(Long goodsCategoryAttributeId, List<String> valueNames) {
        if (CollectionsUtil.isNotEmpty(valueNames)) {
            List<GoodsCategoryAttributeValue> goodsCategoryAttributeValueList = new ArrayList<>(valueNames.size());
            int index = 1;
            for (String valueName : valueNames) {
                GoodsCategoryAttributeValue value = new GoodsCategoryAttributeValue();
                value.setValueName(valueName.trim());
                value.setGoodsCategoryAttributeId(goodsCategoryAttributeId);
                value.setIsEnable(true);
                value.setSortNumber(index);
                goodsCategoryAttributeValueList.add(value);
                index++;
            }
            goodsCategoryAttributeValueMapper.insertBatch(goodsCategoryAttributeValueList);
        }
    }

    /**
     * 更新商品类目属性值
     *
     * @param goodsCategoryAttributeValue
     * @return
     */
    public Integer updateGoodsCategoryAttributeValue(GoodsCategoryAttributeValue goodsCategoryAttributeValue) {
        getBaseGoodsCategoryAttributeValue(goodsCategoryAttributeValue.getId());
        return goodsCategoryAttributeValueMapper.updateByPrimaryKeySelective(goodsCategoryAttributeValue);
    }

    /**
     * 更新商品类目属性值
     *
     * @return
     */
    public void batchUpdateGoodsCategoryAttributeValue(Long goodsCategoryAttributeId, List<GoodsCategoryAttributeValue> goodsCategoryAttributeValueList) {
        if (CollectionsUtil.isNotEmpty(goodsCategoryAttributeValueList)) {
            for (int i = 0; i < goodsCategoryAttributeValueList.size(); i++) {
                goodsCategoryAttributeValueList.get(i).setSortNumber(i + 1);
            }

            // 更新
            List<GoodsCategoryAttributeValue> updateList = goodsCategoryAttributeValueList.stream().filter(bean -> bean.getId() != null).collect(Collectors.toList());
            if (CollectionsUtil.isNotEmpty(updateList)) {
                updateList.forEach(bean -> {
                    bean.setValueName(bean.getValueName().trim());
                    goodsCategoryAttributeValueMapper.updateByPrimaryKeySelective(bean);
                });
            }

            // 删除
            List<GoodsCategoryAttributeValue> oldList = getGoodsCategoryAttributeValueByAttributeId(goodsCategoryAttributeId);
            List<Long> newIds = updateList.stream().map(GoodsCategoryAttributeValue::getId).collect(Collectors.toList());
            List<Long> deleteIdList = oldList.stream().filter(item -> !newIds.contains(item.getId())).map(GoodsCategoryAttributeValue::getId).collect(Collectors.toList());
            if (CollectionsUtil.isNotEmpty(deleteIdList)) {
                GoodsCategoryAttributeValueExample example = new GoodsCategoryAttributeValueExample();
                example.createCriteria().andIsDeletedEqualTo(false).andIdIn(deleteIdList);
                GoodsCategoryAttributeValue goodsCategoryAttributeValue = new GoodsCategoryAttributeValue();
                goodsCategoryAttributeValue.setIsDeleted(true);
                goodsCategoryAttributeValueMapper.updateByExampleSelective(goodsCategoryAttributeValue, example);
            }

            // 新增
            List<GoodsCategoryAttributeValue> addList = goodsCategoryAttributeValueList.stream().filter(bean -> bean.getId() == null).collect(Collectors.toList());
            if (CollectionsUtil.isNotEmpty(addList)) {
                addList.forEach(bean -> {
                    bean.setGoodsCategoryAttributeId(goodsCategoryAttributeId);
                    bean.setIsEnable(true);
                });
                goodsCategoryAttributeValueMapper.insertBatch(addList);
            }
        }
    }

    /**
     * 根据ID获取商品类目属性值信息
     *
     * @param id
     * @return
     */
    public GoodsCategoryAttributeValue getGoodsCategoryAttributeValue(Long id) {
        return getBaseGoodsCategoryAttributeValue(id);
    }

    public GoodsCategoryAttributeValue getBaseGoodsCategoryAttributeValue(Long id) {
        GoodsCategoryAttributeValue goodsCategoryAttributeValue = goodsCategoryAttributeValueMapper.selectByPrimaryKey(id);
        if (goodsCategoryAttributeValue == null || goodsCategoryAttributeValue.getIsDeleted()) {
            throw new CommonException(ResultCode.DATA_NOT_EXIST, "商品类目属性值");
        }
        return goodsCategoryAttributeValue;
    }

    /**
     * 分页查询商品类目属性值信息
     *
     * @param goodsCategoryAttributeValueQuery
     * @return
     */
    public QueryResultVO<GoodsCategoryAttributeValue> queryGoodsCategoryAttributeValue(GoodsCategoryAttributeValueQueryDTO goodsCategoryAttributeValueQuery) {
        QueryResultVO<GoodsCategoryAttributeValue> queryResult = new QueryResultVO<GoodsCategoryAttributeValue>();
        // 使用分页插件PageHelper实现分页功能
        PageHelper.startPage(goodsCategoryAttributeValueQuery.getPageNo(), goodsCategoryAttributeValueQuery.getPageSize());
        List<GoodsCategoryAttributeValue> goodsCategoryAttributeValueList = goodsCategoryAttributeValueMapper.queryGoodsCategoryAttributeValue(goodsCategoryAttributeValueQuery);
        PageInfo<GoodsCategoryAttributeValue> pageInfo = new PageInfo<GoodsCategoryAttributeValue>(goodsCategoryAttributeValueList);
        queryResult.setPageNo(pageInfo.getPageNum());
        queryResult.setPageSize(pageInfo.getPageSize());
        queryResult.setTotalPages(pageInfo.getPages());
        queryResult.setTotalRecords(pageInfo.getTotal());
        queryResult.setRecords(goodsCategoryAttributeValueList);
        return queryResult;
    }

    public List<GoodsCategoryAttributeValue> getGoodsCategoryAttributeValueByAttributeId(Long attributeId) {
        GoodsCategoryAttributeValueExample example = new GoodsCategoryAttributeValueExample();
        example.createCriteria().andGoodsCategoryAttributeIdEqualTo(attributeId).andIsDeletedEqualTo(false);
        example.setOrderByClause("goods_category_attribute_id, sort_number");
        return goodsCategoryAttributeValueMapper.selectByExample(example);
    }

    public List<GoodsCategoryAttributeValue> getGoodsCategoryAttributeValues(List<Long> attributeIdList) {
        if (CollectionsUtil.isEmpty(attributeIdList)) {
            return null;
        }
        GoodsCategoryAttributeValueExample example = new GoodsCategoryAttributeValueExample();
        example.createCriteria().andGoodsCategoryAttributeIdIn(attributeIdList).andIsDeletedEqualTo(false);
        example.setOrderByClause("goods_category_attribute_id, sort_number");
        return goodsCategoryAttributeValueMapper.selectByExample(example);
    }

    /**
     * 根据id列表查询
     *
     * @param idList
     * @return
     */
    public List<GoodsCategoryAttributeValue> getByIdList(List<Long> idList) {
        GoodsCategoryAttributeValueExample example = new GoodsCategoryAttributeValueExample();
        example.createCriteria().andIsDeletedEqualTo(false).andIsEnableEqualTo(true).andIdIn(idList);
        return goodsCategoryAttributeValueMapper.selectByExample(example);
    }

}