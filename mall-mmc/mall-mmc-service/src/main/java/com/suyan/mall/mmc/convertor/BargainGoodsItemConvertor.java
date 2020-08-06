package com.suyan.mall.mmc.convertor;

import com.suyan.mall.mmc.model.BargainGoodsItem;
import com.suyan.mall.mmc.req.BargainGoodsItemDTO;
import com.suyan.mall.mmc.resp.BargainGoodsItemVO;
import com.suyan.query.QueryResultVO;
import org.springframework.cglib.beans.BeanCopier;

import java.util.ArrayList;
import java.util.List;

/**
 * @CopyRright (c): <素焉代码生成工具>
 * @Comments: <对象相互转换>
 */
public abstract class BargainGoodsItemConvertor {

    private static final BeanCopier beanCopierForBargainGoodsItemVO = BeanCopier.create(BargainGoodsItem.class, BargainGoodsItemVO.class, false);
    private static final BeanCopier beanCopierForBargainGoodsItem = BeanCopier.create(BargainGoodsItemDTO.class, BargainGoodsItem.class, false);

    public static BargainGoodsItemVO toBargainGoodsItemVO(BargainGoodsItem bargainGoodsItem) {
        if (bargainGoodsItem == null) {
            return null;
        }
        BargainGoodsItemVO bargainGoodsItemVO = new BargainGoodsItemVO();
        beanCopierForBargainGoodsItemVO.copy(bargainGoodsItem, bargainGoodsItemVO, null);
        return bargainGoodsItemVO;
    }

    public static BargainGoodsItem toBargainGoodsItem(BargainGoodsItemDTO bargainGoodsItemDTO) {
        BargainGoodsItem bargainGoodsItem = new BargainGoodsItem();
        beanCopierForBargainGoodsItem.copy(bargainGoodsItemDTO, bargainGoodsItem, null);
        return bargainGoodsItem;
    }

    public static List<BargainGoodsItemVO> toBargainGoodsItemVOList(List<BargainGoodsItem> bargainGoodsItemList) {
        if (bargainGoodsItemList == null || bargainGoodsItemList.isEmpty()) {
            return null;
        }
        List<BargainGoodsItemVO> bargainGoodsItemInfoList = new ArrayList<BargainGoodsItemVO>(bargainGoodsItemList.size());
        for (BargainGoodsItem bargainGoodsItem : bargainGoodsItemList) {
            bargainGoodsItemInfoList.add(toBargainGoodsItemVO(bargainGoodsItem));
        }
        return bargainGoodsItemInfoList;
    }

    public static List<BargainGoodsItem> toBargainGoodsItemList(List<BargainGoodsItemDTO> bargainGoodsItemDTOList) {
        if (bargainGoodsItemDTOList == null || bargainGoodsItemDTOList.isEmpty()) {
            return null;
        }
        List<BargainGoodsItem> bargainGoodsItemList = new ArrayList<BargainGoodsItem>(bargainGoodsItemDTOList.size());
        for (BargainGoodsItemDTO bargainGoodsItemDTO : bargainGoodsItemDTOList) {
            bargainGoodsItemList.add(toBargainGoodsItem(bargainGoodsItemDTO));
        }
        return bargainGoodsItemList;
    }

    public static QueryResultVO<BargainGoodsItemVO> toQueryResult(QueryResultVO<BargainGoodsItem> queryResult) {
        QueryResultVO<BargainGoodsItemVO> queryResultInfo = new QueryResultVO<BargainGoodsItemVO>();
        queryResultInfo.setPageNo(queryResult.getPageNo());
        queryResultInfo.setPageSize(queryResult.getPageSize());
        queryResultInfo.setTotalPages(queryResult.getTotalPages());
        queryResultInfo.setTotalRecords(queryResult.getTotalRecords());
        queryResultInfo.setRecords(toBargainGoodsItemVOList(queryResult.getRecords()));
        return queryResultInfo;
    }
}