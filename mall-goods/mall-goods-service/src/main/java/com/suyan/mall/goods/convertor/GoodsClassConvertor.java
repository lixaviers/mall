/*
 * Copyright (c) 2020.
 * 项目名称：素焉商城
 * 创建人：素焉
 * 开源地址: https://github.com/lixaviers/mall
 */
package com.suyan.mall.goods.convertor;

import com.suyan.mall.goods.model.GoodsClass;
import com.suyan.mall.goods.req.GoodsClassDTO;
import com.suyan.mall.goods.resp.GoodsClassVO;
import com.suyan.query.QueryResultVO;
import org.springframework.cglib.beans.BeanCopier;

import java.util.ArrayList;
import java.util.List;

/**
 * @CopyRright (c): <素焉代码生成工具>
 * @Comments: <对象相互转换>
 */
public abstract class GoodsClassConvertor {

    private static final BeanCopier beanCopierForGoodsClassVO = BeanCopier.create(GoodsClass.class, GoodsClassVO.class, false);
    private static final BeanCopier beanCopierForGoodsClass = BeanCopier.create(GoodsClassDTO.class, GoodsClass.class, false);

    public static GoodsClassVO toGoodsClassVO(GoodsClass goodsClass) {
        if (goodsClass == null) {
            return null;
        }
        GoodsClassVO goodsClassVO = new GoodsClassVO();
        beanCopierForGoodsClassVO.copy(goodsClass, goodsClassVO, null);
        return goodsClassVO;
    }

    public static GoodsClass toGoodsClass(GoodsClassDTO goodsClassDTO) {
        GoodsClass goodsClass = new GoodsClass();
        beanCopierForGoodsClass.copy(goodsClassDTO, goodsClass, null);
        return goodsClass;
    }

    public static List<GoodsClassVO> toGoodsClassVOList(List<GoodsClass> goodsClassList) {
        if (goodsClassList == null || goodsClassList.isEmpty()) {
            return null;
        }
        List<GoodsClassVO> goodsClassInfoList = new ArrayList<GoodsClassVO>(goodsClassList.size());
        for (GoodsClass goodsClass : goodsClassList) {
            goodsClassInfoList.add(toGoodsClassVO(goodsClass));
        }
        return goodsClassInfoList;
    }

    public static List<GoodsClass> toGoodsClassList(List<GoodsClassDTO> goodsClassDTOList) {
        if (goodsClassDTOList == null || goodsClassDTOList.isEmpty()) {
            return null;
        }
        List<GoodsClass> goodsClassList = new ArrayList<GoodsClass>(goodsClassDTOList.size());
        for (GoodsClassDTO goodsClassDTO : goodsClassDTOList) {
            goodsClassList.add(toGoodsClass(goodsClassDTO));
        }
        return goodsClassList;
    }

    public static QueryResultVO<GoodsClassVO> toQueryResult(QueryResultVO<GoodsClass> queryResult) {
        QueryResultVO<GoodsClassVO> queryResultInfo = new QueryResultVO<GoodsClassVO>();
        queryResultInfo.setPageNo(queryResult.getPageNo());
        queryResultInfo.setPageSize(queryResult.getPageSize());
        queryResultInfo.setTotalPages(queryResult.getTotalPages());
        queryResultInfo.setTotalRecords(queryResult.getTotalRecords());
        queryResultInfo.setRecords(toGoodsClassVOList(queryResult.getRecords()));
        return queryResultInfo;
    }
}