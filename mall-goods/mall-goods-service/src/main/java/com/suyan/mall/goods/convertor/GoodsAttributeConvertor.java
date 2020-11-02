/*
 * Copyright (c) 2020.
 * 项目名称：素焉商城
 * 创建人：素焉
 * 开源地址: https://github.com/lixaviers/mall
 */
package com.suyan.mall.goods.convertor;

import com.suyan.mall.goods.model.GoodsAttribute;
import com.suyan.mall.goods.req.GoodsAttributeDTO;
import com.suyan.mall.goods.resp.GoodsAttributeVO;
import com.suyan.query.QueryResultVO;
import org.springframework.cglib.beans.BeanCopier;

import java.util.ArrayList;
import java.util.List;

/**
 * @CopyRright (c): <素焉代码生成工具>
 * @Comments: <对象相互转换>
 */
public abstract class GoodsAttributeConvertor {

    private static final BeanCopier beanCopierForGoodsAttributeVO = BeanCopier.create(GoodsAttribute.class, GoodsAttributeVO.class, false);
    private static final BeanCopier beanCopierForGoodsAttribute = BeanCopier.create(GoodsAttributeDTO.class, GoodsAttribute.class, false);

    public static GoodsAttributeVO toGoodsAttributeVO(GoodsAttribute goodsAttribute) {
        if (goodsAttribute == null) {
            return null;
        }
        GoodsAttributeVO goodsAttributeVO = new GoodsAttributeVO();
        beanCopierForGoodsAttributeVO.copy(goodsAttribute, goodsAttributeVO, null);
        return goodsAttributeVO;
    }

    public static GoodsAttribute toGoodsAttribute(GoodsAttributeDTO goodsAttributeDTO) {
        GoodsAttribute goodsAttribute = new GoodsAttribute();
        beanCopierForGoodsAttribute.copy(goodsAttributeDTO, goodsAttribute, null);
        return goodsAttribute;
    }

    public static List<GoodsAttributeVO> toGoodsAttributeVOList(List<GoodsAttribute> goodsAttributeList) {
        if (goodsAttributeList == null || goodsAttributeList.isEmpty()) {
            return null;
        }
        List<GoodsAttributeVO> goodsAttributeInfoList = new ArrayList<GoodsAttributeVO>(goodsAttributeList.size());
        for (GoodsAttribute goodsAttribute : goodsAttributeList) {
            goodsAttributeInfoList.add(toGoodsAttributeVO(goodsAttribute));
        }
        return goodsAttributeInfoList;
    }

    public static List<GoodsAttribute> toGoodsAttributeList(List<GoodsAttributeDTO> goodsAttributeDTOList) {
        if (goodsAttributeDTOList == null || goodsAttributeDTOList.isEmpty()) {
            return null;
        }
        List<GoodsAttribute> goodsAttributeList = new ArrayList<GoodsAttribute>(goodsAttributeDTOList.size());
        for (GoodsAttributeDTO goodsAttributeDTO : goodsAttributeDTOList) {
            goodsAttributeList.add(toGoodsAttribute(goodsAttributeDTO));
        }
        return goodsAttributeList;
    }

    public static QueryResultVO<GoodsAttributeVO> toQueryResult(QueryResultVO<GoodsAttribute> queryResult) {
        QueryResultVO<GoodsAttributeVO> queryResultInfo = new QueryResultVO<GoodsAttributeVO>();
        queryResultInfo.setPageNo(queryResult.getPageNo());
        queryResultInfo.setPageSize(queryResult.getPageSize());
        queryResultInfo.setTotalPages(queryResult.getTotalPages());
        queryResultInfo.setTotalRecords(queryResult.getTotalRecords());
        queryResultInfo.setRecords(toGoodsAttributeVOList(queryResult.getRecords()));
        return queryResultInfo;
    }
}