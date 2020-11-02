/*
 * Copyright (c) 2020.
 * 项目名称：素焉商城
 * 创建人：素焉
 * 开源地址: https://github.com/lixaviers/mall
 */
package com.suyan.mall.goods.convertor;

import com.suyan.mall.goods.model.GoodsCategoryBrand;
import com.suyan.mall.goods.req.GoodsCategoryBrandDTO;
import com.suyan.mall.goods.resp.GoodsCategoryBrandVO;
import com.suyan.query.QueryResultVO;
import org.springframework.cglib.beans.BeanCopier;

import java.util.ArrayList;
import java.util.List;

/**
 * @CopyRright (c): <素焉代码生成工具>
 * @Comments: <对象相互转换>
 */
public abstract class GoodsCategoryBrandConvertor {

    private static final BeanCopier beanCopierForGoodsCategoryBrandVO = BeanCopier.create(GoodsCategoryBrand.class, GoodsCategoryBrandVO.class, false);
    private static final BeanCopier beanCopierForGoodsCategoryBrand = BeanCopier.create(GoodsCategoryBrandDTO.class, GoodsCategoryBrand.class, false);

    public static GoodsCategoryBrandVO toGoodsCategoryBrandVO(GoodsCategoryBrand goodsCategoryBrand) {
        if (goodsCategoryBrand == null) {
            return null;
        }
        GoodsCategoryBrandVO goodsCategoryBrandVO = new GoodsCategoryBrandVO();
        beanCopierForGoodsCategoryBrandVO.copy(goodsCategoryBrand, goodsCategoryBrandVO, null);
        return goodsCategoryBrandVO;
    }

    public static GoodsCategoryBrand toGoodsCategoryBrand(GoodsCategoryBrandDTO goodsCategoryBrandDTO) {
        GoodsCategoryBrand goodsCategoryBrand = new GoodsCategoryBrand();
        beanCopierForGoodsCategoryBrand.copy(goodsCategoryBrandDTO, goodsCategoryBrand, null);
        return goodsCategoryBrand;
    }

    public static List<GoodsCategoryBrandVO> toGoodsCategoryBrandVOList(List<GoodsCategoryBrand> goodsCategoryBrandList) {
        if (goodsCategoryBrandList == null || goodsCategoryBrandList.isEmpty()) {
            return null;
        }
        List<GoodsCategoryBrandVO> goodsCategoryBrandInfoList = new ArrayList<GoodsCategoryBrandVO>(goodsCategoryBrandList.size());
        for (GoodsCategoryBrand goodsCategoryBrand : goodsCategoryBrandList) {
            goodsCategoryBrandInfoList.add(toGoodsCategoryBrandVO(goodsCategoryBrand));
        }
        return goodsCategoryBrandInfoList;
    }

    public static List<GoodsCategoryBrand> toGoodsCategoryBrandList(List<GoodsCategoryBrandDTO> goodsCategoryBrandDTOList) {
        if (goodsCategoryBrandDTOList == null || goodsCategoryBrandDTOList.isEmpty()) {
            return null;
        }
        List<GoodsCategoryBrand> goodsCategoryBrandList = new ArrayList<GoodsCategoryBrand>(goodsCategoryBrandDTOList.size());
        for (GoodsCategoryBrandDTO goodsCategoryBrandDTO : goodsCategoryBrandDTOList) {
            goodsCategoryBrandList.add(toGoodsCategoryBrand(goodsCategoryBrandDTO));
        }
        return goodsCategoryBrandList;
    }

    public static QueryResultVO<GoodsCategoryBrandVO> toQueryResult(QueryResultVO<GoodsCategoryBrand> queryResult) {
        QueryResultVO<GoodsCategoryBrandVO> queryResultInfo = new QueryResultVO<GoodsCategoryBrandVO>();
        queryResultInfo.setPageNo(queryResult.getPageNo());
        queryResultInfo.setPageSize(queryResult.getPageSize());
        queryResultInfo.setTotalPages(queryResult.getTotalPages());
        queryResultInfo.setTotalRecords(queryResult.getTotalRecords());
        queryResultInfo.setRecords(toGoodsCategoryBrandVOList(queryResult.getRecords()));
        return queryResultInfo;
    }
}