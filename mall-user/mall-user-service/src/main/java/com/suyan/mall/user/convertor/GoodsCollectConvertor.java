/*
 * Copyright (c) 2020.
 * 项目名称：素焉商城
 * 创建人：素焉
 * 开源地址: https://github.com/lixaviers/mall
 */
package com.suyan.mall.user.convertor;

import com.suyan.mall.user.model.GoodsCollect;
import com.suyan.mall.user.req.GoodsCollectDTO;
import com.suyan.mall.user.resp.GoodsCollectVO;
import com.suyan.query.QueryResultVO;
import org.springframework.cglib.beans.BeanCopier;

import java.util.ArrayList;
import java.util.List;

/**
 * @CopyRright (c): <素焉代码生成工具>
 * @Comments: <对象相互转换>
 */
public abstract class GoodsCollectConvertor {

    private static final BeanCopier beanCopierForGoodsCollectVO = BeanCopier.create(GoodsCollect.class, GoodsCollectVO.class, false);
    private static final BeanCopier beanCopierForGoodsCollect = BeanCopier.create(GoodsCollectDTO.class, GoodsCollect.class, false);

    public static GoodsCollectVO toGoodsCollectVO(GoodsCollect goodsCollect) {
        if (goodsCollect == null) {
            return null;
        }
        GoodsCollectVO goodsCollectVO = new GoodsCollectVO();
        beanCopierForGoodsCollectVO.copy(goodsCollect, goodsCollectVO, null);
        return goodsCollectVO;
    }

    public static GoodsCollect toGoodsCollect(GoodsCollectDTO goodsCollectDTO) {
        GoodsCollect goodsCollect = new GoodsCollect();
        beanCopierForGoodsCollect.copy(goodsCollectDTO, goodsCollect, null);
        return goodsCollect;
    }

    public static List<GoodsCollectVO> toGoodsCollectVOList(List<GoodsCollect> goodsCollectList) {
        if (goodsCollectList == null || goodsCollectList.isEmpty()) {
            return null;
        }
        List<GoodsCollectVO> goodsCollectInfoList = new ArrayList<GoodsCollectVO>(goodsCollectList.size());
        for (GoodsCollect goodsCollect : goodsCollectList) {
            goodsCollectInfoList.add(toGoodsCollectVO(goodsCollect));
        }
        return goodsCollectInfoList;
    }

    public static List<GoodsCollect> toGoodsCollectList(List<GoodsCollectDTO> goodsCollectDTOList) {
        if (goodsCollectDTOList == null || goodsCollectDTOList.isEmpty()) {
            return null;
        }
        List<GoodsCollect> goodsCollectList = new ArrayList<GoodsCollect>(goodsCollectDTOList.size());
        for (GoodsCollectDTO goodsCollectDTO : goodsCollectDTOList) {
            goodsCollectList.add(toGoodsCollect(goodsCollectDTO));
        }
        return goodsCollectList;
    }

    public static QueryResultVO<GoodsCollectVO> toQueryResult(QueryResultVO<GoodsCollect> queryResult) {
        QueryResultVO<GoodsCollectVO> queryResultInfo = new QueryResultVO<GoodsCollectVO>();
        queryResultInfo.setPageNo(queryResult.getPageNo());
        queryResultInfo.setPageSize(queryResult.getPageSize());
        queryResultInfo.setTotalPages(queryResult.getTotalPages());
        queryResultInfo.setTotalRecords(queryResult.getTotalRecords());
        queryResultInfo.setRecords(toGoodsCollectVOList(queryResult.getRecords()));
        return queryResultInfo;
    }
}