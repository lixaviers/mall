package com.suyan.mall.goods.test;

import com.alibaba.fastjson.JSON;
import com.suyan.mall.goods.dao.GoodsBrandMapper;
import com.suyan.mall.goods.dao.GoodsCategoryBrandMapper;
import com.suyan.mall.goods.model.GoodsBrand;
import com.suyan.mall.goods.model.GoodsBrandExample;
import com.suyan.mall.goods.model.GoodsCategoryBrand;
import com.suyan.mall.goods.model.GoodsCategoryBrandExample;
import com.suyan.utils.CollectionsUtil;
import com.suyan.utils.FileUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class GoodsBrandTest {

    @Autowired
    private GoodsBrandMapper goodsBrandMapper;
    @Autowired
    private GoodsCategoryBrandMapper goodsCategoryBrandMapper;

    /**
     * 测试创建商品品牌
     */
    @Test
    public void createGoodsBrand() {
        try {
            for (int i = 1; i < 5; i++) {
                String fileName = "/testData/goodsBrand" + i + ".json";
                String jsonContext = FileUtil.getResourceContent(fileName);
                List<TBrand> brandList = JSON.parseArray(jsonContext, TBrand.class);
                for (TBrand tBrand : brandList) {
                    String name = tBrand.getName();
                    GoodsBrandExample example = new GoodsBrandExample();
                    example.createCriteria().andBrandNameEqualTo(name);
                    List<GoodsBrand> goodsBrands = goodsBrandMapper.selectByExample(example);
                    Integer brandId;
                    if (CollectionsUtil.isNotEmpty(goodsBrands)) {
                        brandId = goodsBrands.get(0).getId();
                    } else {
                        GoodsBrand goodsBrand = new GoodsBrand();
                        goodsBrand.setBrandName(name);
                        goodsBrand.setIsEnable(true);
                        brandId = goodsBrandMapper.insertSelective(goodsBrand);
                    }
                    int[] categoryIdList = {3877,
                            3878,
                            3879,
                            3880,
                            3881,
                            3882,
                            3883};
                    for (int categoryId : categoryIdList) {
                        GoodsCategoryBrandExample example1 = new GoodsCategoryBrandExample();
                        example1.createCriteria().andGoodsBrandIdEqualTo(brandId).andGoodsCategoryIdEqualTo(categoryId);
                        List<GoodsCategoryBrand> goodsCategoryBrands = goodsCategoryBrandMapper.selectByExample(example1);
                        if (CollectionsUtil.isEmpty(goodsCategoryBrands)) {
                            GoodsCategoryBrand goodsCategoryBrand = new GoodsCategoryBrand();
                            goodsCategoryBrand.setGoodsBrandId(brandId);
                            goodsCategoryBrand.setGoodsCategoryId(categoryId);
                            goodsCategoryBrandMapper.insertSelective(goodsCategoryBrand);
                        }
                    }

                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}