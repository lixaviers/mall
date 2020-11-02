/*
 * Copyright (c) 2020.
 * 项目名称：素焉商城
 * 创建人：素焉
 * 开源地址: https://github.com/lixaviers/mall
 */
package com.suyan.mall.goods.convertor;

import com.suyan.mall.goods.model.GoodsCategoryRelation;
import com.suyan.mall.goods.req.GoodsCategoryRelationDTO;
import com.suyan.mall.goods.resp.GoodsCategoryRelationVO;
import com.suyan.query.QueryResultVO;
import org.springframework.cglib.beans.BeanCopier;

import java.util.ArrayList;
import java.util.List;

/**
 * @CopyRright (c): <素焉代码生成工具>
 * @Comments: <对象相互转换>
 */
public abstract class GoodsCategoryRelationConvertor {

    private static final BeanCopier beanCopierForGoodsCategoryRelationVO = BeanCopier.create(GoodsCategoryRelation.class, GoodsCategoryRelationVO.class, false);
    private static final BeanCopier beanCopierForGoodsCategoryRelation = BeanCopier.create(GoodsCategoryRelationDTO.class, GoodsCategoryRelation.class, false);

    public static GoodsCategoryRelationVO toGoodsCategoryRelationVO(GoodsCategoryRelation goodsCategoryRelation) {
        if (goodsCategoryRelation == null) {
            return null;
        }
        GoodsCategoryRelationVO goodsCategoryRelationVO = new GoodsCategoryRelationVO();
        beanCopierForGoodsCategoryRelationVO.copy(goodsCategoryRelation, goodsCategoryRelationVO, null);
        return goodsCategoryRelationVO;
    }

    public static GoodsCategoryRelation toGoodsCategoryRelation(GoodsCategoryRelationDTO goodsCategoryRelationDTO) {
        GoodsCategoryRelation goodsCategoryRelation = new GoodsCategoryRelation();
        beanCopierForGoodsCategoryRelation.copy(goodsCategoryRelationDTO, goodsCategoryRelation, null);
        return goodsCategoryRelation;
    }

    public static List<GoodsCategoryRelationVO> toGoodsCategoryRelationVOList(List<GoodsCategoryRelation> goodsCategoryRelationList) {
        if (goodsCategoryRelationList == null || goodsCategoryRelationList.isEmpty()) {
            return null;
        }
        List<GoodsCategoryRelationVO> goodsCategoryRelationInfoList = new ArrayList<GoodsCategoryRelationVO>(goodsCategoryRelationList.size());
        for (GoodsCategoryRelation goodsCategoryRelation : goodsCategoryRelationList) {
            goodsCategoryRelationInfoList.add(toGoodsCategoryRelationVO(goodsCategoryRelation));
        }
        return goodsCategoryRelationInfoList;
    }

    public static List<GoodsCategoryRelation> toGoodsCategoryRelationList(List<GoodsCategoryRelationDTO> goodsCategoryRelationDTOList) {
        if (goodsCategoryRelationDTOList == null || goodsCategoryRelationDTOList.isEmpty()) {
            return null;
        }
        List<GoodsCategoryRelation> goodsCategoryRelationList = new ArrayList<GoodsCategoryRelation>(goodsCategoryRelationDTOList.size());
        for (GoodsCategoryRelationDTO goodsCategoryRelationDTO : goodsCategoryRelationDTOList) {
            goodsCategoryRelationList.add(toGoodsCategoryRelation(goodsCategoryRelationDTO));
        }
        return goodsCategoryRelationList;
    }

    public static QueryResultVO<GoodsCategoryRelationVO> toQueryResult(QueryResultVO<GoodsCategoryRelation> queryResult) {
        QueryResultVO<GoodsCategoryRelationVO> queryResultInfo = new QueryResultVO<GoodsCategoryRelationVO>();
        queryResultInfo.setPageNo(queryResult.getPageNo());
        queryResultInfo.setPageSize(queryResult.getPageSize());
        queryResultInfo.setTotalPages(queryResult.getTotalPages());
        queryResultInfo.setTotalRecords(queryResult.getTotalRecords());
        queryResultInfo.setRecords(toGoodsCategoryRelationVOList(queryResult.getRecords()));
        return queryResultInfo;
    }
}