package com.suyan.mall.goods.test;

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

@RunWith(SpringRunner.class)
@SpringBootTest
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


}
