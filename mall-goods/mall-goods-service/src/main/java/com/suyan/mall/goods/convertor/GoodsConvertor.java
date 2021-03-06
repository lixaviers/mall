/*
 * Copyright (c) 2020.
 * 项目名称：素焉商城
 * 创建人：素焉
 * 开源地址: https://github.com/lixaviers/mall
 */
package com.suyan.mall.goods.convertor;

import com.alibaba.fastjson.JSON;
import com.suyan.mall.goods.es.model.GoodsES;
import com.suyan.mall.goods.model.Goods;
import com.suyan.mall.goods.model.GoodsSpecification;
import com.suyan.mall.goods.req.GoodsDTO;
import com.suyan.mall.goods.resp.GoodsSearchVO;
import com.suyan.mall.goods.resp.GoodsSpecificationNameVO;
import com.suyan.mall.goods.resp.GoodsVO;
import com.suyan.query.QueryResultVO;
import com.suyan.utils.BeanUtil;
import com.suyan.utils.CollectionsUtil;
import com.suyan.utils.StringUtils;
import org.springframework.cglib.beans.BeanCopier;

import java.util.ArrayList;
import java.util.List;

/**
 * @CopyRright (c): <素焉代码生成工具>
 * @Comments: <对象相互转换>
 */
public abstract class GoodsConvertor {

    private static final BeanCopier beanCopierForGoodsVO = BeanCopier.create(Goods.class, GoodsVO.class, false);
    private static final BeanCopier beanCopierForGoods = BeanCopier.create(GoodsDTO.class, Goods.class, false);
    private static final BeanCopier beanCopierForGoodsSearchVO = BeanCopier.create(GoodsES.class, GoodsSearchVO.class, false);

    public static GoodsVO toGoodsVO(Goods goods) {
        if (goods == null) {
            return null;
        }
        GoodsVO goodsVO = new GoodsVO();
        beanCopierForGoodsVO.copy(goods, goodsVO, null);
        goodsVO.setSkuList(GoodsSkuConvertor.toGoodsSkuVOList(goods.getSkuList()));
        if (StringUtils.isNotEmpty(goods.getSpecValue())) {
            goodsVO.setSpecificationList(JSON.parseArray(goods.getSpecValue(), GoodsSpecificationNameVO.class));
        }
        return goodsVO;
    }

    public static Goods toGoods(GoodsDTO goodsDTO) {
        Goods goods = new Goods();
        beanCopierForGoods.copy(goodsDTO, goods, null);
        goods.setSkuList(GoodsSkuConvertor.toGoodsSkuList(goodsDTO.getSkuList()));
        goods.setGoodsSpecificationList(BeanUtil.fastBeanCopy(goodsDTO.getGoodsSpecificationList(), GoodsSpecification.class));
        return goods;
    }

    public static List<GoodsVO> toGoodsVOList(List<Goods> goodsList) {
        if (goodsList == null || goodsList.isEmpty()) {
            return null;
        }
        List<GoodsVO> goodsInfoList = new ArrayList<GoodsVO>(goodsList.size());
        for (Goods goods : goodsList) {
            goodsInfoList.add(toGoodsVO(goods));
        }
        return goodsInfoList;
    }

    public static List<Goods> toGoodsList(List<GoodsDTO> goodsDTOList) {
        if (goodsDTOList == null || goodsDTOList.isEmpty()) {
            return null;
        }
        List<Goods> goodsList = new ArrayList<Goods>(goodsDTOList.size());
        for (GoodsDTO goodsDTO : goodsDTOList) {
            goodsList.add(toGoods(goodsDTO));
        }
        return goodsList;
    }

    public static QueryResultVO<GoodsVO> toQueryResult(QueryResultVO<Goods> queryResult) {
        QueryResultVO<GoodsVO> queryResultInfo = new QueryResultVO<GoodsVO>();
        queryResultInfo.setPageNo(queryResult.getPageNo());
        queryResultInfo.setPageSize(queryResult.getPageSize());
        queryResultInfo.setTotalPages(queryResult.getTotalPages());
        queryResultInfo.setTotalRecords(queryResult.getTotalRecords());
        queryResultInfo.setRecords(toGoodsVOList(queryResult.getRecords()));
        return queryResultInfo;
    }


    public static GoodsSearchVO toGoodsSearchVO(GoodsES goodsES) {
        GoodsSearchVO goodsSearchVO = new GoodsSearchVO();
        beanCopierForGoodsSearchVO.copy(goodsES, goodsSearchVO, null);
        return goodsSearchVO;
    }

    public static List<GoodsSearchVO> toGoodsSearchVOList(List<GoodsES> beanList) {
        if (CollectionsUtil.isNotEmpty(beanList)) {
            List<GoodsSearchVO> returnList = new ArrayList<>(beanList.size());
            for (GoodsES goodsES : beanList) {
                returnList.add(toGoodsSearchVO(goodsES));
            }
            return returnList;
        }
        return null;
    }


}