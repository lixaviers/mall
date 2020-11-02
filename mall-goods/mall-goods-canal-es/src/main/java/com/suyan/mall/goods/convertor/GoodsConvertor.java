/*
 * Copyright (c) 2020.
 * 项目名称：素焉商城
 * 创建人：素焉
 * 开源地址: https://github.com/lixaviers/mall
 */
package com.suyan.mall.goods.convertor;

import com.suyan.mall.goods.es.model.GoodsES;
import com.suyan.mall.goods.model.Goods;
import com.suyan.utils.DateUtils;
import org.springframework.cglib.beans.BeanCopier;

import java.time.format.DateTimeFormatter;

/**
 * @CopyRright (c): <素焉代码生成工具>
 * @Comments: <对象相互转换>
 */
public abstract class GoodsConvertor {

    private static final BeanCopier beanCopierForGoodsES = BeanCopier.create(Goods.class, GoodsES.class, false);

    public static GoodsES toGoodsES(Goods goods) {
        if (goods == null) {
            return null;
        }
        GoodsES goodsES = new GoodsES();
        beanCopierForGoodsES.copy(goods, goodsES, null);
        // 后台类目id
        goodsES.setGoodsBackgroundCategoryId(goods.getGoodsCategoryId());
        goodsES.setCreateTime(DateUtils.formatterDateTime(goods.getCreateTime()));
        goodsES.setUpdateTime(DateUtils.formatterDateTime(goods.getUpdateTime()));
        return goodsES;
    }

}