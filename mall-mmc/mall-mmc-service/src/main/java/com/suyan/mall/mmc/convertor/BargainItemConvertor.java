package com.suyan.mall.mmc.convertor;

import com.suyan.mall.mmc.model.BargainItem;
import com.suyan.mall.mmc.req.BargainItemDTO;
import com.suyan.mall.mmc.resp.BargainItemVO;
import com.suyan.query.QueryResultVO;
import org.springframework.cglib.beans.BeanCopier;

import java.util.ArrayList;
import java.util.List;

/**
 * @CopyRright (c): <素焉代码生成工具>
 * @Comments: <对象相互转换>
 */
public abstract class BargainItemConvertor {

    private static final BeanCopier beanCopierForBargainItemVO = BeanCopier.create(BargainItem.class, BargainItemVO.class, false);
    private static final BeanCopier beanCopierForBargainItem = BeanCopier.create(BargainItemDTO.class, BargainItem.class, false);

    public static BargainItemVO toBargainItemVO(BargainItem bargainItem) {
        if (bargainItem == null) {
            return null;
        }
        BargainItemVO bargainItemVO = new BargainItemVO();
        beanCopierForBargainItemVO.copy(bargainItem, bargainItemVO, null);
        return bargainItemVO;
    }

    public static BargainItem toBargainItem(BargainItemDTO bargainItemDTO) {
        BargainItem bargainItem = new BargainItem();
        beanCopierForBargainItem.copy(bargainItemDTO, bargainItem, null);
        return bargainItem;
    }

    public static List<BargainItemVO> toBargainItemVOList(List<BargainItem> bargainItemList) {
        if (bargainItemList == null || bargainItemList.isEmpty()) {
            return null;
        }
        List<BargainItemVO> bargainItemInfoList = new ArrayList<BargainItemVO>(bargainItemList.size());
        for (BargainItem bargainItem : bargainItemList) {
            bargainItemInfoList.add(toBargainItemVO(bargainItem));
        }
        return bargainItemInfoList;
    }

    public static List<BargainItem> toBargainItemList(List<BargainItemDTO> bargainItemDTOList) {
        if (bargainItemDTOList == null || bargainItemDTOList.isEmpty()) {
            return null;
        }
        List<BargainItem> bargainItemList = new ArrayList<BargainItem>(bargainItemDTOList.size());
        for (BargainItemDTO bargainItemDTO : bargainItemDTOList) {
            bargainItemList.add(toBargainItem(bargainItemDTO));
        }
        return bargainItemList;
    }

    public static QueryResultVO<BargainItemVO> toQueryResult(QueryResultVO<BargainItem> queryResult) {
        QueryResultVO<BargainItemVO> queryResultInfo = new QueryResultVO<BargainItemVO>();
        queryResultInfo.setPageNo(queryResult.getPageNo());
        queryResultInfo.setPageSize(queryResult.getPageSize());
        queryResultInfo.setTotalPages(queryResult.getTotalPages());
        queryResultInfo.setTotalRecords(queryResult.getTotalRecords());
        queryResultInfo.setRecords(toBargainItemVOList(queryResult.getRecords()));
        return queryResultInfo;
    }
}