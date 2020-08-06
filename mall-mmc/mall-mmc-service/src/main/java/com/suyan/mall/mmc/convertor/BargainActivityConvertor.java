package com.suyan.mall.mmc.convertor;

import com.suyan.mall.mmc.model.BargainActivity;
import com.suyan.mall.mmc.req.BargainActivityDTO;
import com.suyan.mall.mmc.resp.BargainActivityVO;
import com.suyan.query.QueryResultVO;
import org.springframework.cglib.beans.BeanCopier;

import java.util.ArrayList;
import java.util.List;

/**
 * @CopyRright (c): <素焉代码生成工具>
 * @Comments: <对象相互转换>
 */
public abstract class BargainActivityConvertor {

    private static final BeanCopier beanCopierForBargainActivityVO = BeanCopier.create(BargainActivity.class, BargainActivityVO.class, false);
    private static final BeanCopier beanCopierForBargainActivity = BeanCopier.create(BargainActivityDTO.class, BargainActivity.class, false);

    public static BargainActivityVO toBargainActivityVO(BargainActivity bargainActivity) {
        if (bargainActivity == null) {
            return null;
        }
        BargainActivityVO bargainActivityVO = new BargainActivityVO();
        beanCopierForBargainActivityVO.copy(bargainActivity, bargainActivityVO, null);
        return bargainActivityVO;
    }

    public static BargainActivity toBargainActivity(BargainActivityDTO bargainActivityDTO) {
        BargainActivity bargainActivity = new BargainActivity();
        beanCopierForBargainActivity.copy(bargainActivityDTO, bargainActivity, null);
        return bargainActivity;
    }

    public static List<BargainActivityVO> toBargainActivityVOList(List<BargainActivity> bargainActivityList) {
        if (bargainActivityList == null || bargainActivityList.isEmpty()) {
            return null;
        }
        List<BargainActivityVO> bargainActivityInfoList = new ArrayList<BargainActivityVO>(bargainActivityList.size());
        for (BargainActivity bargainActivity : bargainActivityList) {
            bargainActivityInfoList.add(toBargainActivityVO(bargainActivity));
        }
        return bargainActivityInfoList;
    }

    public static List<BargainActivity> toBargainActivityList(List<BargainActivityDTO> bargainActivityDTOList) {
        if (bargainActivityDTOList == null || bargainActivityDTOList.isEmpty()) {
            return null;
        }
        List<BargainActivity> bargainActivityList = new ArrayList<BargainActivity>(bargainActivityDTOList.size());
        for (BargainActivityDTO bargainActivityDTO : bargainActivityDTOList) {
            bargainActivityList.add(toBargainActivity(bargainActivityDTO));
        }
        return bargainActivityList;
    }

    public static QueryResultVO<BargainActivityVO> toQueryResult(QueryResultVO<BargainActivity> queryResult) {
        QueryResultVO<BargainActivityVO> queryResultInfo = new QueryResultVO<BargainActivityVO>();
        queryResultInfo.setPageNo(queryResult.getPageNo());
        queryResultInfo.setPageSize(queryResult.getPageSize());
        queryResultInfo.setTotalPages(queryResult.getTotalPages());
        queryResultInfo.setTotalRecords(queryResult.getTotalRecords());
        queryResultInfo.setRecords(toBargainActivityVOList(queryResult.getRecords()));
        return queryResultInfo;
    }
}