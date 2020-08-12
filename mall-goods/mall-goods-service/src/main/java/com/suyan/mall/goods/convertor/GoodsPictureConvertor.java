package com.suyan.mall.goods.convertor;

import com.suyan.mall.goods.model.GoodsPicture;
import com.suyan.mall.goods.req.GoodsPictureDTO;
import com.suyan.mall.goods.resp.GoodsPictureVO;
import com.suyan.query.QueryResultVO;
import org.springframework.cglib.beans.BeanCopier;

import java.util.ArrayList;
import java.util.List;

/**
 * @CopyRright (c): <素焉代码生成工具>
 * @Comments: <对象相互转换>
 */
public abstract class GoodsPictureConvertor {

    private static final BeanCopier beanCopierForGoodsPictureVO = BeanCopier.create(GoodsPicture.class, GoodsPictureVO.class, false);
    private static final BeanCopier beanCopierForGoodsPicture = BeanCopier.create(GoodsPictureDTO.class, GoodsPicture.class, false);

    public static GoodsPictureVO toGoodsPictureVO(GoodsPicture goodsPicture) {
        if (goodsPicture == null) {
            return null;
        }
        GoodsPictureVO goodsPictureVO = new GoodsPictureVO();
        beanCopierForGoodsPictureVO.copy(goodsPicture, goodsPictureVO, null);
        return goodsPictureVO;
    }

    public static GoodsPicture toGoodsPicture(GoodsPictureDTO goodsPictureDTO) {
        GoodsPicture goodsPicture = new GoodsPicture();
        beanCopierForGoodsPicture.copy(goodsPictureDTO, goodsPicture, null);
        return goodsPicture;
    }

    public static List<GoodsPictureVO> toGoodsPictureVOList(List<GoodsPicture> goodsPictureList) {
        if (goodsPictureList == null || goodsPictureList.isEmpty()) {
            return null;
        }
        List<GoodsPictureVO> goodsPictureInfoList = new ArrayList<GoodsPictureVO>(goodsPictureList.size());
        for (GoodsPicture goodsPicture : goodsPictureList) {
            goodsPictureInfoList.add(toGoodsPictureVO(goodsPicture));
        }
        return goodsPictureInfoList;
    }

    public static List<GoodsPicture> toGoodsPictureList(List<GoodsPictureDTO> goodsPictureDTOList) {
        if (goodsPictureDTOList == null || goodsPictureDTOList.isEmpty()) {
            return null;
        }
        List<GoodsPicture> goodsPictureList = new ArrayList<GoodsPicture>(goodsPictureDTOList.size());
        for (GoodsPictureDTO goodsPictureDTO : goodsPictureDTOList) {
            goodsPictureList.add(toGoodsPicture(goodsPictureDTO));
        }
        return goodsPictureList;
    }

    public static QueryResultVO<GoodsPictureVO> toQueryResult(QueryResultVO<GoodsPicture> queryResult) {
        QueryResultVO<GoodsPictureVO> queryResultInfo = new QueryResultVO<GoodsPictureVO>();
        queryResultInfo.setPageNo(queryResult.getPageNo());
        queryResultInfo.setPageSize(queryResult.getPageSize());
        queryResultInfo.setTotalPages(queryResult.getTotalPages());
        queryResultInfo.setTotalRecords(queryResult.getTotalRecords());
        queryResultInfo.setRecords(toGoodsPictureVOList(queryResult.getRecords()));
        return queryResultInfo;
    }
}