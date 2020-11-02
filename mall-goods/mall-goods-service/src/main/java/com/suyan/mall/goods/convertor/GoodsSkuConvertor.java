/*
 * Copyright (c) 2020.
 * 项目名称：素焉商城
 * 创建人：素焉
 * 开源地址: https://github.com/lixaviers/mall
 */
package com.suyan.mall.goods.convertor;

import com.suyan.mall.goods.model.GoodsSku;
import com.suyan.mall.goods.req.GoodsSkuDTO;
import com.suyan.mall.goods.resp.GoodsSkuVO;
import com.suyan.query.QueryResultVO;
import org.springframework.cglib.beans.BeanCopier;

import java.util.ArrayList;
import java.util.List;

/**
 * @CopyRright (c): <素焉代码生成工具>
 * @Comments: <对象相互转换>
 * @jdk 1.8
 * @Version: <1.0>
 */
public abstract class GoodsSkuConvertor {

    private static final BeanCopier beanCopierForGoodsSkuVO = BeanCopier.create(GoodsSku.class, GoodsSkuVO.class, false);
    private static final BeanCopier beanCopierForGoodsSku = BeanCopier.create(GoodsSkuDTO.class, GoodsSku.class, false);

    public static GoodsSkuVO toGoodsSkuVO(GoodsSku goodsSku) {
        if (goodsSku == null) {
            return null;
        }
        GoodsSkuVO goodsSkuVO = new GoodsSkuVO();
        beanCopierForGoodsSkuVO.copy(goodsSku, goodsSkuVO, null);
        return goodsSkuVO;
    }

    public static GoodsSku toGoodsSku(GoodsSkuDTO goodsSkuDTO) {
        GoodsSku goodsSku = new GoodsSku();
        beanCopierForGoodsSku.copy(goodsSkuDTO, goodsSku, null);
        return goodsSku;
    }

    public static List<GoodsSkuVO> toGoodsSkuVOList(List<GoodsSku> goodsSkuList) {
        if (goodsSkuList == null || goodsSkuList.isEmpty()) {
            return null;
        }
        List<GoodsSkuVO> goodsSkuInfoList = new ArrayList<GoodsSkuVO>(goodsSkuList.size());
        for (GoodsSku goodsSku : goodsSkuList) {
            goodsSkuInfoList.add(toGoodsSkuVO(goodsSku));
        }
        return goodsSkuInfoList;
    }

    public static List<GoodsSku> toGoodsSkuList(List<GoodsSkuDTO> goodsSkuDTOList) {
        if (goodsSkuDTOList == null || goodsSkuDTOList.isEmpty()) {
            return null;
        }
        List<GoodsSku> goodsSkuList = new ArrayList<GoodsSku>(goodsSkuDTOList.size());
        for (GoodsSkuDTO goodsSkuDTO : goodsSkuDTOList) {
            goodsSkuList.add(toGoodsSku(goodsSkuDTO));
        }
        return goodsSkuList;
    }

    public static QueryResultVO<GoodsSkuVO> toQueryResult(QueryResultVO<GoodsSku> queryResult) {
        QueryResultVO<GoodsSkuVO> queryResultInfo = new QueryResultVO<GoodsSkuVO>();
        queryResultInfo.setPageNo(queryResult.getPageNo());
        queryResultInfo.setPageSize(queryResult.getPageSize());
        queryResultInfo.setTotalPages(queryResult.getTotalPages());
        queryResultInfo.setTotalRecords(queryResult.getTotalRecords());
        queryResultInfo.setRecords(toGoodsSkuVOList(queryResult.getRecords()));
        return queryResultInfo;
    }
}