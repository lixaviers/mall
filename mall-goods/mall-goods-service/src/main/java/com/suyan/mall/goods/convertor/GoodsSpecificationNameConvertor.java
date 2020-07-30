package com.suyan.mall.goods.convertor;

import com.suyan.mall.goods.model.GoodsSpecificationName;
import com.suyan.mall.goods.req.GoodsSpecificationNameDTO;
import com.suyan.mall.goods.resp.GoodsSpecificationNameVO;
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
public abstract class GoodsSpecificationNameConvertor {

    private static final BeanCopier beanCopierForGoodsSpecificationNameVO = BeanCopier.create(GoodsSpecificationName.class, GoodsSpecificationNameVO.class, false);
    private static final BeanCopier beanCopierForGoodsSpecificationName = BeanCopier.create(GoodsSpecificationNameDTO.class, GoodsSpecificationName.class, false);

    public static GoodsSpecificationNameVO toGoodsSpecificationNameVO(GoodsSpecificationName goodsSpecificationName) {
        if (goodsSpecificationName == null) {
            return null;
        }
        GoodsSpecificationNameVO goodsSpecificationNameVO = new GoodsSpecificationNameVO();
        beanCopierForGoodsSpecificationNameVO.copy(goodsSpecificationName, goodsSpecificationNameVO, null);
        return goodsSpecificationNameVO;
    }

    public static GoodsSpecificationName toGoodsSpecificationName(GoodsSpecificationNameDTO goodsSpecificationNameDTO) {
        GoodsSpecificationName goodsSpecificationName = new GoodsSpecificationName();
        beanCopierForGoodsSpecificationName.copy(goodsSpecificationNameDTO, goodsSpecificationName, null);
        return goodsSpecificationName;
    }

    public static List<GoodsSpecificationNameVO> toGoodsSpecificationNameVOList(List<GoodsSpecificationName> goodsSpecificationNameList) {
        if (goodsSpecificationNameList == null || goodsSpecificationNameList.isEmpty()) {
            return null;
        }
        List<GoodsSpecificationNameVO> goodsSpecificationNameInfoList = new ArrayList<GoodsSpecificationNameVO>(goodsSpecificationNameList.size());
        for (GoodsSpecificationName goodsSpecificationName : goodsSpecificationNameList) {
            goodsSpecificationNameInfoList.add(toGoodsSpecificationNameVO(goodsSpecificationName));
        }
        return goodsSpecificationNameInfoList;
    }

    public static List<GoodsSpecificationName> toGoodsSpecificationNameList(List<GoodsSpecificationNameDTO> goodsSpecificationNameDTOList) {
        if (goodsSpecificationNameDTOList == null || goodsSpecificationNameDTOList.isEmpty()) {
            return null;
        }
        List<GoodsSpecificationName> goodsSpecificationNameList = new ArrayList<GoodsSpecificationName>(goodsSpecificationNameDTOList.size());
        for (GoodsSpecificationNameDTO goodsSpecificationNameDTO : goodsSpecificationNameDTOList) {
            goodsSpecificationNameList.add(toGoodsSpecificationName(goodsSpecificationNameDTO));
        }
        return goodsSpecificationNameList;
    }

    public static QueryResultVO<GoodsSpecificationNameVO> toQueryResult(QueryResultVO<GoodsSpecificationName> queryResult) {
        QueryResultVO<GoodsSpecificationNameVO> queryResultInfo = new QueryResultVO<GoodsSpecificationNameVO>();
        queryResultInfo.setPageNo(queryResult.getPageNo());
        queryResultInfo.setPageSize(queryResult.getPageSize());
        queryResultInfo.setTotalPages(queryResult.getTotalPages());
        queryResultInfo.setTotalRecords(queryResult.getTotalRecords());
        queryResultInfo.setRecords(toGoodsSpecificationNameVOList(queryResult.getRecords()));
        return queryResultInfo;
    }
}