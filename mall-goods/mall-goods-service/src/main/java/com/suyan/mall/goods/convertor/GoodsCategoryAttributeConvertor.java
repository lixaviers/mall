package com.suyan.mall.goods.convertor;

import com.suyan.mall.goods.model.GoodsCategoryAttribute;
import com.suyan.mall.goods.req.GoodsCategoryAttributeDTO;
import com.suyan.mall.goods.resp.GoodsCategoryAttributeVO;
import com.suyan.query.QueryResultVO;
import org.springframework.cglib.beans.BeanCopier;

import java.util.ArrayList;
import java.util.List;

/**
 * @CopyRright (c): <素焉代码生成工具>
 * @Comments: <对象相互转换>
 */
public abstract class GoodsCategoryAttributeConvertor {

    private static final BeanCopier beanCopierForGoodsCategoryAttributeVO = BeanCopier.create(GoodsCategoryAttribute.class, GoodsCategoryAttributeVO.class, false);
    private static final BeanCopier beanCopierForGoodsCategoryAttribute = BeanCopier.create(GoodsCategoryAttributeDTO.class, GoodsCategoryAttribute.class, false);

    public static GoodsCategoryAttributeVO toGoodsCategoryAttributeVO(GoodsCategoryAttribute goodsCategoryAttribute) {
        if (goodsCategoryAttribute == null) {
            return null;
        }
        GoodsCategoryAttributeVO goodsCategoryAttributeVO = new GoodsCategoryAttributeVO();
        beanCopierForGoodsCategoryAttributeVO.copy(goodsCategoryAttribute, goodsCategoryAttributeVO, null);
        return goodsCategoryAttributeVO;
    }

    public static GoodsCategoryAttribute toGoodsCategoryAttribute(GoodsCategoryAttributeDTO goodsCategoryAttributeDTO) {
        GoodsCategoryAttribute goodsCategoryAttribute = new GoodsCategoryAttribute();
        beanCopierForGoodsCategoryAttribute.copy(goodsCategoryAttributeDTO, goodsCategoryAttribute, null);
        return goodsCategoryAttribute;
    }

    public static List<GoodsCategoryAttributeVO> toGoodsCategoryAttributeVOList(List<GoodsCategoryAttribute> goodsCategoryAttributeList) {
        if (goodsCategoryAttributeList == null || goodsCategoryAttributeList.isEmpty()) {
            return null;
        }
        List<GoodsCategoryAttributeVO> goodsCategoryAttributeInfoList = new ArrayList<GoodsCategoryAttributeVO>(goodsCategoryAttributeList.size());
        for (GoodsCategoryAttribute goodsCategoryAttribute : goodsCategoryAttributeList) {
            goodsCategoryAttributeInfoList.add(toGoodsCategoryAttributeVO(goodsCategoryAttribute));
        }
        return goodsCategoryAttributeInfoList;
    }

    public static List<GoodsCategoryAttribute> toGoodsCategoryAttributeList(List<GoodsCategoryAttributeDTO> goodsCategoryAttributeDTOList) {
        if (goodsCategoryAttributeDTOList == null || goodsCategoryAttributeDTOList.isEmpty()) {
            return null;
        }
        List<GoodsCategoryAttribute> goodsCategoryAttributeList = new ArrayList<GoodsCategoryAttribute>(goodsCategoryAttributeDTOList.size());
        for (GoodsCategoryAttributeDTO goodsCategoryAttributeDTO : goodsCategoryAttributeDTOList) {
            goodsCategoryAttributeList.add(toGoodsCategoryAttribute(goodsCategoryAttributeDTO));
        }
        return goodsCategoryAttributeList;
    }

    public static QueryResultVO<GoodsCategoryAttributeVO> toQueryResult(QueryResultVO<GoodsCategoryAttribute> queryResult) {
        QueryResultVO<GoodsCategoryAttributeVO> queryResultInfo = new QueryResultVO<GoodsCategoryAttributeVO>();
        queryResultInfo.setPageNo(queryResult.getPageNo());
        queryResultInfo.setPageSize(queryResult.getPageSize());
        queryResultInfo.setTotalPages(queryResult.getTotalPages());
        queryResultInfo.setTotalRecords(queryResult.getTotalRecords());
        queryResultInfo.setRecords(toGoodsCategoryAttributeVOList(queryResult.getRecords()));
        return queryResultInfo;
    }
}