/*
 * Copyright (c) 2020.
 * 项目名称：素焉商城
 * 创建人：素焉
 * 开源地址: https://github.com/lixaviers/mall
 */
package com.suyan.mall.goods.test;

import com.google.common.collect.Lists;
import com.suyan.mall.goods.GoodsBApplicationMain;
import com.suyan.mall.goods.dao.GoodsCategoryMapper;
import com.suyan.mall.goods.dao.GoodsCategoryRelationMapper;
import com.suyan.mall.goods.model.GoodsCategory;
import com.suyan.mall.goods.model.GoodsCategoryExample;
import com.suyan.mall.goods.model.GoodsCategoryRelation;
import com.suyan.utils.CollectionsUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = GoodsBApplicationMain.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class GoodsCategoryTest {

    @Autowired
    private GoodsCategoryMapper goodsCategoryMapper;
    @Autowired
    private GoodsCategoryRelationMapper goodsCategoryRelationMapper;

    @Test
    public void goodsCategory() {
        GoodsCategoryExample example = new GoodsCategoryExample();
        example.createCriteria().andCategoryTypeEqualTo((byte) 1).andCategoryLevelEqualTo(3);
        List<GoodsCategory> goodsCategoryList = goodsCategoryMapper.selectByExample(example);
        for (GoodsCategory goodsCategory : goodsCategoryList) {
            example = new GoodsCategoryExample();
            example.createCriteria().andCategoryTypeEqualTo((byte) 2).andCategoryLevelEqualTo(4).andCategoryNameEqualTo(goodsCategory.getCategoryName());
            List<GoodsCategory> goodsCategories = goodsCategoryMapper.selectByExample(example);
            if (CollectionsUtil.isNotEmpty(goodsCategories)) {
                for (GoodsCategory category : goodsCategories) {
                    GoodsCategoryRelation relation = new GoodsCategoryRelation();
                    relation.setLeftId(goodsCategory.getId());
                    relation.setRightId(category.getId());
                    goodsCategoryRelationMapper.insertSelective(relation);
                }
            }
        }
    }

    @Test
    public void dealPath() {
        GoodsCategoryExample example = new GoodsCategoryExample();
        List<GoodsCategory> goodsCategoryList = goodsCategoryMapper.selectByExample(example);

        List<GoodsCategory> topCategoryList = goodsCategoryList.stream().filter(bean -> bean.getParentId().equals(0)).collect(Collectors.toList());
        List<GoodsCategory> childCategoryList = goodsCategoryList.stream().filter(bean -> !bean.getParentId().equals(0)).collect(Collectors.toList());
        sort(topCategoryList, childCategoryList);

        for (GoodsCategory goodsCategory : topCategoryList) {
            String id = String.valueOf(goodsCategory.getId());
            String name = String.valueOf(goodsCategory.getCategoryName());
            goodsCategory.setFullIdPath(id);
            goodsCategory.setFullNamePath(name);
            goodsCategoryMapper.updateByPrimaryKeySelective(goodsCategory);

            child(goodsCategory);

        }
    }

    private void child(GoodsCategory goodsCategory) {
        if (CollectionsUtil.isNotEmpty(goodsCategory.getChildCategoryList())) {
            for (GoodsCategory child : goodsCategory.getChildCategoryList()) {
                child.setFullIdPath(goodsCategory.getFullIdPath() + "-" + child.getId());
                child.setFullNamePath(goodsCategory.getFullNamePath() + "-" + child.getCategoryName());
                goodsCategoryMapper.updateByPrimaryKeySelective(child);
                child(child);
            }

        }
    }


    private void sort(List<GoodsCategory> topCategoryList, List<GoodsCategory> childCategoryList) {
        List<GoodsCategory> copyVos = Lists.newCopyOnWriteArrayList(childCategoryList);
        for (GoodsCategory top : topCategoryList) {
            for (GoodsCategory child : childCategoryList) {
                if (Objects.equals(top.getId(), child.getParentId())) {
                    top.addChildCategoryList(child);
                    copyVos.remove(child);
                }
            }
        }
        for (GoodsCategory top : topCategoryList) {
            if (CollectionsUtil.isNotEmpty(top.getChildCategoryList())) {
                sort(top.getChildCategoryList(), copyVos);
            }
        }
    }


}
