/*
 * Copyright (c) 2020.
 * 项目名称：素焉商城
 * 创建人：素焉
 * 开源地址: https://github.com/lixaviers/mall
 */
package com.suyan.mall.goods.convertor;

import com.suyan.mall.goods.model.GoodsBrand;
import com.suyan.mall.goods.req.GoodsBrandDTO;
import com.suyan.mall.goods.resp.GoodsBrandVO;
import com.suyan.query.QueryResultVO;
import org.springframework.cglib.beans.BeanCopier;

import java.util.ArrayList;
import java.util.List;

/**
 * @CopyRright (c): <素焉代码生成工具>
 * @Comments: <对象相互转换>
 */
public abstract class GoodsBrandConvertor {

    private static final BeanCopier beanCopierForGoodsBrandVO = BeanCopier.create(GoodsBrand.class, GoodsBrandVO.class, false);
    private static final BeanCopier beanCopierForGoodsBrand = BeanCopier.create(GoodsBrandDTO.class, GoodsBrand.class, false);

    public static GoodsBrandVO toGoodsBrandVO(GoodsBrand goodsBrand) {
        if (goodsBrand == null) {
            return null;
        }
        GoodsBrandVO goodsBrandVO = new GoodsBrandVO();
        beanCopierForGoodsBrandVO.copy(goodsBrand, goodsBrandVO, null);
        return goodsBrandVO;
    }

    public static GoodsBrand toGoodsBrand(GoodsBrandDTO goodsBrandDTO) {
        GoodsBrand goodsBrand = new GoodsBrand();
        beanCopierForGoodsBrand.copy(goodsBrandDTO, goodsBrand, null);
        return goodsBrand;
    }

    public static List<GoodsBrandVO> toGoodsBrandVOList(List<GoodsBrand> goodsBrandList) {
        if (goodsBrandList == null || goodsBrandList.isEmpty()) {
            return null;
        }
        List<GoodsBrandVO> goodsBrandInfoList = new ArrayList<GoodsBrandVO>(goodsBrandList.size());
        for (GoodsBrand goodsBrand : goodsBrandList) {
            goodsBrandInfoList.add(toGoodsBrandVO(goodsBrand));
        }
        return goodsBrandInfoList;
    }

    public static List<GoodsBrand> toGoodsBrandList(List<GoodsBrandDTO> goodsBrandDTOList) {
        if (goodsBrandDTOList == null || goodsBrandDTOList.isEmpty()) {
            return null;
        }
        List<GoodsBrand> goodsBrandList = new ArrayList<GoodsBrand>(goodsBrandDTOList.size());
        for (GoodsBrandDTO goodsBrandDTO : goodsBrandDTOList) {
            goodsBrandList.add(toGoodsBrand(goodsBrandDTO));
        }
        return goodsBrandList;
    }

    public static QueryResultVO<GoodsBrandVO> toQueryResult(QueryResultVO<GoodsBrand> queryResult) {
        QueryResultVO<GoodsBrandVO> queryResultInfo = new QueryResultVO<GoodsBrandVO>();
        queryResultInfo.setPageNo(queryResult.getPageNo());
        queryResultInfo.setPageSize(queryResult.getPageSize());
        queryResultInfo.setTotalPages(queryResult.getTotalPages());
        queryResultInfo.setTotalRecords(queryResult.getTotalRecords());
        queryResultInfo.setRecords(toGoodsBrandVOList(queryResult.getRecords()));
        return queryResultInfo;
    }
}