/*
 * Copyright (c) 2020.
 * 项目名称：素焉商城
 * 创建人：素焉
 * 开源地址: https://github.com/lixaviers/mall
 */
package com.suyan.mall.goods.biz;

import com.google.common.collect.Lists;
import com.suyan.exception.CommonException;
import com.suyan.mall.goods.constants.ExceptionDefGoods;
import com.suyan.mall.goods.dao.GoodsAttributeMapper;
import com.suyan.mall.goods.model.GoodsAttribute;
import com.suyan.mall.goods.model.GoodsAttributeExample;
import com.suyan.mall.goods.model.GoodsCategoryAttribute;
import com.suyan.mall.goods.model.GoodsCategoryAttributeValue;
import com.suyan.mall.goods.req.GoodsAttributeDTO;
import com.suyan.utils.CollectionsUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @CopyRright (c): <素焉代码生成工具>
 * @Comments: <业务层商品属性管理类>
 */
@Slf4j
@Service
public class GoodsAttributeBiz {

    @Autowired
    private GoodsAttributeMapper goodsAttributeMapper;
    @Autowired
    private GoodsCategoryAttributeBiz goodsCategoryAttributeBiz;
    @Autowired
    private GoodsCategoryAttributeValueBiz goodsCategoryAttributeValueBiz;

    /**
     * 创建商品属性
     *
     * @param attributeList
     * @return
     */
    public void createGoodsAttribute(Long goodsId, List<GoodsAttributeDTO> attributeList) {
        if (CollectionsUtil.isNotEmpty(attributeList)) {
            // 前端传过来的是id，缓存商品属性名称、属性值名称，方便查询
            attributeList.forEach(bean -> {
                bean.setAttributeValueId(bean.getAttributeValueId() == null ? 0L : bean.getAttributeValueId());
            });
            List<GoodsAttribute> goodsAttributeList = new ArrayList<>(attributeList.size());
            // 根据商品类目属性id分组
            Map<Long, List<GoodsAttributeDTO>> map = attributeList.stream().collect(Collectors.groupingBy(GoodsAttributeDTO::getAttributeId));
            List<Long> goodsAttributeIdList = new ArrayList<>(map.keySet());
            // 根据商品类目属性id列表查询信息
            List<GoodsCategoryAttribute> goodsCategoryAttributeList = goodsCategoryAttributeBiz.getByIdList(goodsAttributeIdList);
            if (CollectionsUtil.isEmpty(goodsCategoryAttributeList) || goodsCategoryAttributeList.size() != goodsAttributeIdList.size()) {
                throw new CommonException(ExceptionDefGoods.EXCEPTION_8002);
            }
            for (GoodsCategoryAttribute goodsCategoryAttribute : goodsCategoryAttributeList) {
                map.forEach((k, v) -> {
                    if (k.equals(goodsCategoryAttribute.getId())) {
                        v.forEach(dto -> {
                            dto.setAttributeName(goodsCategoryAttribute.getAttributeName());
                        });
                    }
                });
            }
            List<Long> attributeValueIdList = attributeList.stream().filter(bean -> bean.getAttributeValueId() != null).map(GoodsAttributeDTO::getAttributeValueId).collect(Collectors.toList());
            if (CollectionsUtil.isNotEmpty(attributeValueIdList)) {
                // 根据商品类目属性值id列表查询信息
                List<GoodsCategoryAttributeValue> goodsCategoryAttributeValueList = goodsCategoryAttributeValueBiz.getByIdList(attributeValueIdList);
                if (CollectionsUtil.isEmpty(goodsCategoryAttributeValueList) || goodsCategoryAttributeValueList.size() != goodsCategoryAttributeValueList.size()) {
                    throw new CommonException(ExceptionDefGoods.EXCEPTION_8002);
                }
                Map<Long, List<GoodsAttributeDTO>> attributeValueMap = attributeList.stream().collect(Collectors.groupingBy(GoodsAttributeDTO::getAttributeValueId));
                for (GoodsCategoryAttributeValue value : goodsCategoryAttributeValueList) {
                    attributeValueMap.forEach((k, v) -> {
                        if (k.equals(value.getId())) {
                            v.forEach(temp -> {
                                temp.setAttributeValueName(value.getValueName());
                            });
                        }
                    });
                }
            }


            for (GoodsAttributeDTO goodsAttributeDTO : attributeList) {
                GoodsAttribute goodsAttribute = new GoodsAttribute();
                goodsAttribute.setGoodsId(goodsId);
                goodsAttribute.setGoodsCategoryAttributeId(goodsAttributeDTO.getAttributeId());
                goodsAttribute.setGoodsCategoryAttributeName(goodsAttributeDTO.getAttributeName());
                goodsAttribute.setGoodsCategoryAttributeValueId(goodsAttributeDTO.getAttributeValueId());
                goodsAttribute.setGoodsCategoryAttributeValueName(goodsAttributeDTO.getAttributeValueName());
                goodsAttributeList.add(goodsAttribute);
            }
            // 分批插入
            List<List<GoodsAttribute>> partition = Lists.partition(goodsAttributeList, 50);
            for (List<GoodsAttribute> goodsAttributes : partition) {
                goodsAttributeMapper.insertBatch(goodsAttributes);
            }
        }
    }

    /**
     * 更新商品属性
     *
     * @param attributeList
     * @return
     */
    public void updateGoodsAttribute(Long goodsId, List<GoodsAttributeDTO> attributeList) {
        // 这里不匹配，直接删除旧的，在新增
        deleteGoodsAttribute(goodsId);

        createGoodsAttribute(goodsId, attributeList);
    }

    /**
     * 删除商品属性
     *
     * @param goodsId
     * @return
     */
    public Integer deleteGoodsAttribute(Long goodsId) {
        GoodsAttributeExample example = new GoodsAttributeExample();
        example.createCriteria().andIsDeletedEqualTo(false).andGoodsIdEqualTo(goodsId);
        GoodsAttribute bean = new GoodsAttribute();
        bean.setIsDeleted(true);
        return goodsAttributeMapper.updateByExampleSelective(bean, example);
    }

    public List<GoodsAttribute> getGoodsAttributes(Long goodsId) {
        GoodsAttributeExample example = new GoodsAttributeExample();
        example.createCriteria().andIsDeletedEqualTo(false).andGoodsIdEqualTo(goodsId);
        return goodsAttributeMapper.selectByExample(example);
    }

}