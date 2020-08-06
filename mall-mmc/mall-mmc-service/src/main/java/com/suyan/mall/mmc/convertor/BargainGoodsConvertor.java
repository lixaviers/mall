package com.suyan.mall.mmc.convertor;

import com.suyan.mall.mmc.model.BargainGoods;
import com.suyan.mall.mmc.req.BargainGoodsDTO;
import com.suyan.mall.mmc.resp.BargainGoodsVO;
import com.suyan.query.QueryResultVO;
import org.springframework.cglib.beans.BeanCopier;

import java.util.ArrayList;
import java.util.List;

/**
 * @CopyRright (c): <素焉代码生成工具>
 * @Comments: <对象相互转换>
 */
public abstract class BargainGoodsConvertor {

    private static final BeanCopier beanCopierForBargainGoodsVO = BeanCopier.create(BargainGoods.class, BargainGoodsVO.class, false);
    private static final BeanCopier beanCopierForBargainGoods = BeanCopier.create(BargainGoodsDTO.class, BargainGoods.class, false);

    public static BargainGoodsVO toBargainGoodsVO(BargainGoods bargainGoods) {
        if (bargainGoods == null) {
            return null;
        }
        BargainGoodsVO bargainGoodsVO = new BargainGoodsVO();
        beanCopierForBargainGoodsVO.copy(bargainGoods, bargainGoodsVO, null);
        return bargainGoodsVO;
    }

    public static BargainGoods toBargainGoods(BargainGoodsDTO bargainGoodsDTO) {
        BargainGoods bargainGoods = new BargainGoods();
        beanCopierForBargainGoods.copy(bargainGoodsDTO, bargainGoods, null);
        return bargainGoods;
    }

    public static List<BargainGoodsVO> toBargainGoodsVOList(List<BargainGoods> bargainGoodsList) {
        if (bargainGoodsList == null || bargainGoodsList.isEmpty()) {
            return null;
        }
        List<BargainGoodsVO> bargainGoodsInfoList = new ArrayList<BargainGoodsVO>(bargainGoodsList.size());
        for (BargainGoods bargainGoods : bargainGoodsList) {
            bargainGoodsInfoList.add(toBargainGoodsVO(bargainGoods));
        }
        return bargainGoodsInfoList;
    }

    public static List<BargainGoods> toBargainGoodsList(List<BargainGoodsDTO> bargainGoodsDTOList) {
        if (bargainGoodsDTOList == null || bargainGoodsDTOList.isEmpty()) {
            return null;
        }
        List<BargainGoods> bargainGoodsList = new ArrayList<BargainGoods>(bargainGoodsDTOList.size());
        for (BargainGoodsDTO bargainGoodsDTO : bargainGoodsDTOList) {
            bargainGoodsList.add(toBargainGoods(bargainGoodsDTO));
        }
        return bargainGoodsList;
    }

    public static QueryResultVO<BargainGoodsVO> toQueryResult(QueryResultVO<BargainGoods> queryResult) {
        QueryResultVO<BargainGoodsVO> queryResultInfo = new QueryResultVO<BargainGoodsVO>();
        queryResultInfo.setPageNo(queryResult.getPageNo());
        queryResultInfo.setPageSize(queryResult.getPageSize());
        queryResultInfo.setTotalPages(queryResult.getTotalPages());
        queryResultInfo.setTotalRecords(queryResult.getTotalRecords());
        queryResultInfo.setRecords(toBargainGoodsVOList(queryResult.getRecords()));
        return queryResultInfo;
    }
}