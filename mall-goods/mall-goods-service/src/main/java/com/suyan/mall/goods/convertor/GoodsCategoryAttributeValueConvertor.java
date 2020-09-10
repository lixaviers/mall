package com.suyan.mall.goods.convertor;

import com.suyan.mall.goods.model.GoodsCategoryAttributeValue;
import com.suyan.mall.goods.req.GoodsCategoryAttributeValueDTO;
import com.suyan.mall.goods.resp.GoodsCategoryAttributeValueVO;
import com.suyan.query.QueryResultVO;
import org.springframework.cglib.beans.BeanCopier;

import java.util.ArrayList;
import java.util.List;

/**
 * @CopyRright (c): <素焉代码生成工具>
 * @Comments: <对象相互转换>
 */
public abstract class GoodsCategoryAttributeValueConvertor {

    private static final BeanCopier beanCopierForGoodsCategoryAttributeValueVO = BeanCopier.create(GoodsCategoryAttributeValue.class, GoodsCategoryAttributeValueVO.class, false);
    private static final BeanCopier beanCopierForGoodsCategoryAttributeValue = BeanCopier.create(GoodsCategoryAttributeValueDTO.class, GoodsCategoryAttributeValue.class, false);

    public static GoodsCategoryAttributeValueVO toGoodsCategoryAttributeValueVO(GoodsCategoryAttributeValue goodsCategoryAttributeValue) {
        if (goodsCategoryAttributeValue == null) {
            return null;
        }
        GoodsCategoryAttributeValueVO goodsCategoryAttributeValueVO = new GoodsCategoryAttributeValueVO();
        beanCopierForGoodsCategoryAttributeValueVO.copy(goodsCategoryAttributeValue, goodsCategoryAttributeValueVO, null);
        return goodsCategoryAttributeValueVO;
    }

    public static GoodsCategoryAttributeValue toGoodsCategoryAttributeValue(GoodsCategoryAttributeValueDTO goodsCategoryAttributeValueDTO) {
        GoodsCategoryAttributeValue goodsCategoryAttributeValue = new GoodsCategoryAttributeValue();
        beanCopierForGoodsCategoryAttributeValue.copy(goodsCategoryAttributeValueDTO, goodsCategoryAttributeValue, null);
        return goodsCategoryAttributeValue;
    }

    public static List<GoodsCategoryAttributeValueVO> toGoodsCategoryAttributeValueVOList(List<GoodsCategoryAttributeValue> goodsCategoryAttributeValueList) {
        if (goodsCategoryAttributeValueList == null || goodsCategoryAttributeValueList.isEmpty()) {
            return null;
        }
        List<GoodsCategoryAttributeValueVO> goodsCategoryAttributeValueInfoList = new ArrayList<GoodsCategoryAttributeValueVO>(goodsCategoryAttributeValueList.size());
        for (GoodsCategoryAttributeValue goodsCategoryAttributeValue : goodsCategoryAttributeValueList) {
            goodsCategoryAttributeValueInfoList.add(toGoodsCategoryAttributeValueVO(goodsCategoryAttributeValue));
        }
        return goodsCategoryAttributeValueInfoList;
    }

    public static List<GoodsCategoryAttributeValue> toGoodsCategoryAttributeValueList(List<GoodsCategoryAttributeValueDTO> goodsCategoryAttributeValueDTOList) {
        if (goodsCategoryAttributeValueDTOList == null || goodsCategoryAttributeValueDTOList.isEmpty()) {
            return null;
        }
        List<GoodsCategoryAttributeValue> goodsCategoryAttributeValueList = new ArrayList<GoodsCategoryAttributeValue>(goodsCategoryAttributeValueDTOList.size());
        for (GoodsCategoryAttributeValueDTO goodsCategoryAttributeValueDTO : goodsCategoryAttributeValueDTOList) {
            goodsCategoryAttributeValueList.add(toGoodsCategoryAttributeValue(goodsCategoryAttributeValueDTO));
        }
        return goodsCategoryAttributeValueList;
    }

    public static QueryResultVO<GoodsCategoryAttributeValueVO> toQueryResult(QueryResultVO<GoodsCategoryAttributeValue> queryResult) {
        QueryResultVO<GoodsCategoryAttributeValueVO> queryResultInfo = new QueryResultVO<GoodsCategoryAttributeValueVO>();
        queryResultInfo.setPageNo(queryResult.getPageNo());
        queryResultInfo.setPageSize(queryResult.getPageSize());
        queryResultInfo.setTotalPages(queryResult.getTotalPages());
        queryResultInfo.setTotalRecords(queryResult.getTotalRecords());
        queryResultInfo.setRecords(toGoodsCategoryAttributeValueVOList(queryResult.getRecords()));
        return queryResultInfo;
    }
}