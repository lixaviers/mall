package com.suyan.mall.mmc.convertor;

import com.suyan.mall.mmc.model.Bargain;
import com.suyan.mall.mmc.req.BargainDTO;
import com.suyan.mall.mmc.resp.BargainVO;
import com.suyan.query.QueryResultVO;
import org.springframework.cglib.beans.BeanCopier;

import java.util.ArrayList;
import java.util.List;

/**
 * @CopyRright (c): <素焉代码生成工具>
 * @Comments: <对象相互转换>
 */
public abstract class BargainConvertor {

    private static final BeanCopier beanCopierForBargainVO = BeanCopier.create(Bargain.class, BargainVO.class, false);
    private static final BeanCopier beanCopierForBargain = BeanCopier.create(BargainDTO.class, Bargain.class, false);

    public static BargainVO toBargainVO(Bargain bargain) {
        if (bargain == null) {
            return null;
        }
        BargainVO bargainVO = new BargainVO();
        beanCopierForBargainVO.copy(bargain, bargainVO, null);
        bargainVO.setBargainItemList(BargainItemConvertor.toBargainItemVOList(bargain.getBargainItemList()));
        return bargainVO;
    }

    public static Bargain toBargain(BargainDTO bargainDTO) {
        Bargain bargain = new Bargain();
        beanCopierForBargain.copy(bargainDTO, bargain, null);
        bargain.setBargainItemList(BargainItemConvertor.toBargainItemList(bargainDTO.getBargainItemList()));
        return bargain;
    }

    public static List<BargainVO> toBargainVOList(List<Bargain> bargainList) {
        if (bargainList == null || bargainList.isEmpty()) {
            return null;
        }
        List<BargainVO> bargainInfoList = new ArrayList<BargainVO>(bargainList.size());
        for (Bargain bargain : bargainList) {
            bargainInfoList.add(toBargainVO(bargain));
        }
        return bargainInfoList;
    }

    public static List<Bargain> toBargainList(List<BargainDTO> bargainDTOList) {
        if (bargainDTOList == null || bargainDTOList.isEmpty()) {
            return null;
        }
        List<Bargain> bargainList = new ArrayList<Bargain>(bargainDTOList.size());
        for (BargainDTO bargainDTO : bargainDTOList) {
            bargainList.add(toBargain(bargainDTO));
        }
        return bargainList;
    }

    public static QueryResultVO<BargainVO> toQueryResult(QueryResultVO<Bargain> queryResult) {
        QueryResultVO<BargainVO> queryResultInfo = new QueryResultVO<BargainVO>();
        queryResultInfo.setPageNo(queryResult.getPageNo());
        queryResultInfo.setPageSize(queryResult.getPageSize());
        queryResultInfo.setTotalPages(queryResult.getTotalPages());
        queryResultInfo.setTotalRecords(queryResult.getTotalRecords());
        queryResultInfo.setRecords(toBargainVOList(queryResult.getRecords()));
        return queryResultInfo;
    }
}