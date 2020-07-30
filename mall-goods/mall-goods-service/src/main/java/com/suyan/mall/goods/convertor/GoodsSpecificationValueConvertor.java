package com.suyan.mall.goods.convertor;

import com.suyan.mall.goods.model.GoodsSpecificationValue;
import com.suyan.mall.goods.req.GoodsSpecificationValueDTO;
import com.suyan.mall.goods.resp.GoodsSpecificationValueVO;
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
public abstract class GoodsSpecificationValueConvertor {

    private static final BeanCopier beanCopierForGoodsSpecificationValueVO = BeanCopier.create(GoodsSpecificationValue.class, GoodsSpecificationValueVO.class, false);
    private static final BeanCopier beanCopierForGoodsSpecificationValue = BeanCopier.create(GoodsSpecificationValueDTO.class, GoodsSpecificationValue.class, false);

    public static GoodsSpecificationValueVO toGoodsSpecificationValueVO(GoodsSpecificationValue goodsSpecificationValue) {
        if (goodsSpecificationValue == null) {
            return null;
        }
        GoodsSpecificationValueVO goodsSpecificationValueVO = new GoodsSpecificationValueVO();
        beanCopierForGoodsSpecificationValueVO.copy(goodsSpecificationValue, goodsSpecificationValueVO, null);
        return goodsSpecificationValueVO;
    }

    public static GoodsSpecificationValue toGoodsSpecificationValue(GoodsSpecificationValueDTO goodsSpecificationValueDTO) {
        GoodsSpecificationValue goodsSpecificationValue = new GoodsSpecificationValue();
        beanCopierForGoodsSpecificationValue.copy(goodsSpecificationValueDTO, goodsSpecificationValue, null);
        return goodsSpecificationValue;
    }

    public static List<GoodsSpecificationValueVO> toGoodsSpecificationValueVOList(List<GoodsSpecificationValue> goodsSpecificationValueList) {
        if (goodsSpecificationValueList == null || goodsSpecificationValueList.isEmpty()) {
            return null;
        }
        List<GoodsSpecificationValueVO> goodsSpecificationValueInfoList = new ArrayList<GoodsSpecificationValueVO>(goodsSpecificationValueList.size());
        for (GoodsSpecificationValue goodsSpecificationValue : goodsSpecificationValueList) {
            goodsSpecificationValueInfoList.add(toGoodsSpecificationValueVO(goodsSpecificationValue));
        }
        return goodsSpecificationValueInfoList;
    }

    public static List<GoodsSpecificationValue> toGoodsSpecificationValueList(List<GoodsSpecificationValueDTO> goodsSpecificationValueDTOList) {
        if (goodsSpecificationValueDTOList == null || goodsSpecificationValueDTOList.isEmpty()) {
            return null;
        }
        List<GoodsSpecificationValue> goodsSpecificationValueList = new ArrayList<GoodsSpecificationValue>(goodsSpecificationValueDTOList.size());
        for (GoodsSpecificationValueDTO goodsSpecificationValueDTO : goodsSpecificationValueDTOList) {
            goodsSpecificationValueList.add(toGoodsSpecificationValue(goodsSpecificationValueDTO));
        }
        return goodsSpecificationValueList;
    }

    public static QueryResultVO<GoodsSpecificationValueVO> toQueryResult(QueryResultVO<GoodsSpecificationValue> queryResult) {
        QueryResultVO<GoodsSpecificationValueVO> queryResultInfo = new QueryResultVO<GoodsSpecificationValueVO>();
        queryResultInfo.setPageNo(queryResult.getPageNo());
        queryResultInfo.setPageSize(queryResult.getPageSize());
        queryResultInfo.setTotalPages(queryResult.getTotalPages());
        queryResultInfo.setTotalRecords(queryResult.getTotalRecords());
        queryResultInfo.setRecords(toGoodsSpecificationValueVOList(queryResult.getRecords()));
        return queryResultInfo;
    }
}