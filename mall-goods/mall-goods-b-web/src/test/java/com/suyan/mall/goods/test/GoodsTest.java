/*
 * Copyright (c) 2020.
 * 项目名称：素焉商城
 * 创建人：素焉
 * 开源地址: https://github.com/lixaviers/mall
 */
package com.suyan.mall.goods.test;

import com.google.common.collect.Lists;
import com.suyan.mall.goods.GoodsBApplicationMain;
import com.suyan.mall.goods.biz.GoodsBiz;
import com.suyan.mall.goods.dao.*;
import com.suyan.mall.goods.model.*;
import com.suyan.utils.CollectionsUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = GoodsBApplicationMain.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class GoodsTest {
    @Autowired
    private GoodsBiz goodsBiz;

    @Autowired
    private GoodsBrandMapper goodsBrandMapper;
    @Autowired
    private GoodsCategoryMapper goodsCategoryMapper;
    @Autowired
    private GoodsCategoryBrandMapper goodsCategoryBrandMapper;

    @Test
    public void createGoods() {

        List<String> urls = new ArrayList<>();
        urls.add("https://c-ssl.duitang.com/uploads/item/201702/06/20170206031650_sLKrk.thumb.400_0.jpeg");
        urls.add("https://c-ssl.duitang.com/uploads/item/201911/24/20191124125211_wxzNv.thumb.400_0.jpeg");
        urls.add("https://c-ssl.duitang.com/uploads/item/201910/05/20191005123047_zQEJK.thumb.400_0.jpeg");
        urls.add("https://c-ssl.duitang.com/uploads/item/201804/30/20180430224313_xvncx.thumb.400_0.jpeg");
        urls.add("https://c-ssl.duitang.com/uploads/item/202006/15/20200615145626_4sWAS.thumb.400_0.jpeg");
        urls.add("https://c-ssl.duitang.com/uploads/item/202006/25/20200625113804_tjxnk.thumb.400_0.png");
        urls.add("https://c-ssl.duitang.com/uploads/item/201804/13/20180413225712_jwwsf.thumb.400_0.jpeg");
        urls.add("https://c-ssl.duitang.com/uploads/item/201806/18/20180618150338_osbfp.thumb.400_0.jpeg");
        urls.add("https://c-ssl.duitang.com/uploads/item/202004/03/20200403105333_PVA55.thumb.400_0.jpeg");
        urls.add("https://c-ssl.duitang.com/uploads/item/202003/01/20200301113947_mawfz.thumb.400_0.jpg");
        urls.add("https://c-ssl.duitang.com/uploads/item/201808/20/20180820111911_qsfcq.thumb.400_0.jpg");
        urls.add("https://c-ssl.duitang.com/uploads/item/202007/02/20200702213528_HkTHR.thumb.400_0.jpeg");
        urls.add("https://c-ssl.duitang.com/uploads/item/202002/14/20200214195232_rmtE8.thumb.400_0.jpeg");
        urls.add("https://c-ssl.duitang.com/uploads/item/202008/14/20200814213331_A2LXG.thumb.400_0.jpeg");
        urls.add("https://c-ssl.duitang.com/uploads/item/201908/12/20190812223655_fpwol.thumb.400_0.jpeg");
        urls.add("https://c-ssl.duitang.com/uploads/item/202004/03/20200403104011_HyCVU.thumb.400_0.jpeg");

        GoodsCategoryExample example = new GoodsCategoryExample();
        example.createCriteria().andCategoryTypeEqualTo((byte) 2).andCategoryLevelEqualTo(4);
        List<GoodsCategory> goodsCategoryList = goodsCategoryMapper.selectByExample(example);
        for (GoodsCategory goodsCategory : goodsCategoryList) {
            List<GoodsCategoryBrand> categoryBrandList = goodsCategoryBrandMapper.selectByGoodsCategoryId(goodsCategory.getId());
            if (CollectionsUtil.isNotEmpty(categoryBrandList)) {
                for (GoodsCategoryBrand goodsCategoryBrand : categoryBrandList) {
                    GoodsBrand goodsBrand = goodsBrandMapper.selectByPrimaryKey(goodsCategoryBrand.getGoodsBrandId());
                    Goods goods = new Goods();
                    goods.setShopId(1002L);
                    goods.setGoodsName(goodsCategory.getCategoryName() + "下" + goodsBrand.getBrandName() + "的生成商品");
                    goods.setGoodsCategoryId(goodsCategory.getId());
                    goods.setBrandId(goodsCategoryBrand.getGoodsBrandId());
                    goods.setIsMoreSpec(false);
                    BigDecimal price = new BigDecimal(ThreadLocalRandom.current().nextDouble(1000));
                    goods.setOriginalPrice(price);
                    goods.setMinimumQuantity(1);
                    goods.setExpressFreight(BigDecimal.ZERO);

                    goods.setPictureUrls(urls.get(ThreadLocalRandom.current().nextInt(16)));
                    goods.setDescription(goods.getGoodsName() + goods.getGoodsName() + goods.getGoodsName() + goods.getGoodsName() + goods.getGoodsName() + goods.getGoodsName() + goods.getGoodsName() + goods.getGoodsName() + goods.getGoodsName());
                    goods.setInventory(10);
                    List<GoodsSku> skuList = new ArrayList<>();
                    GoodsSku goodsSku = new GoodsSku();
                    goodsSku.setInventory(1000);
                    goodsSku.setPrice(price.subtract(BigDecimal.ONE));
                    skuList.add(goodsSku);
                    goods.setSkuList(skuList);
                    goodsBiz.createGoods(goods);
                }
            }
        }

    }

}
