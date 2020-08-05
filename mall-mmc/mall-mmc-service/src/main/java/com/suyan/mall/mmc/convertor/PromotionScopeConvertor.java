package com.suyan.mall.mmc.convertor;

import com.suyan.mall.mmc.model.PromotionScope;
import com.suyan.mall.mmc.req.PromotionScopeDTO;
import com.suyan.mall.mmc.resp.PromotionScopeVO;
import com.suyan.query.QueryResultVO;
import org.springframework.cglib.beans.BeanCopier;

import java.util.ArrayList;
import java.util.List;

/**
 * @CopyRright (c): <素焉代码生成工具>
 * @Comments: <对象相互转换>
 */
public abstract class PromotionScopeConvertor {

    private static final BeanCopier beanCopierForPromotionScopeVO = BeanCopier.create(PromotionScope.class, PromotionScopeVO.class, false);
    private static final BeanCopier beanCopierForPromotionScope = BeanCopier.create(PromotionScopeDTO.class, PromotionScope.class, false);

    public static PromotionScopeVO toPromotionScopeVO(PromotionScope promotionScope) {
        if (promotionScope == null) {
            return null;
        }
        PromotionScopeVO promotionScopeVO = new PromotionScopeVO();
        beanCopierForPromotionScopeVO.copy(promotionScope, promotionScopeVO, null);
        return promotionScopeVO;
    }

    public static PromotionScope toPromotionScope(PromotionScopeDTO promotionScopeDTO) {
        PromotionScope promotionScope = new PromotionScope();
        beanCopierForPromotionScope.copy(promotionScopeDTO, promotionScope, null);
        return promotionScope;
    }

    public static List<PromotionScopeVO> toPromotionScopeVOList(List<PromotionScope> promotionScopeList) {
        if (promotionScopeList == null || promotionScopeList.isEmpty()) {
            return null;
        }
        List<PromotionScopeVO> promotionScopeInfoList = new ArrayList<PromotionScopeVO>(promotionScopeList.size());
        for (PromotionScope promotionScope : promotionScopeList) {
            promotionScopeInfoList.add(toPromotionScopeVO(promotionScope));
        }
        return promotionScopeInfoList;
    }

    public static List<PromotionScope> toPromotionScopeList(List<PromotionScopeDTO> promotionScopeDTOList) {
        if (promotionScopeDTOList == null || promotionScopeDTOList.isEmpty()) {
            return null;
        }
        List<PromotionScope> promotionScopeList = new ArrayList<PromotionScope>(promotionScopeDTOList.size());
        for (PromotionScopeDTO promotionScopeDTO : promotionScopeDTOList) {
            promotionScopeList.add(toPromotionScope(promotionScopeDTO));
        }
        return promotionScopeList;
    }

    public static QueryResultVO<PromotionScopeVO> toQueryResult(QueryResultVO<PromotionScope> queryResult) {
        QueryResultVO<PromotionScopeVO> queryResultInfo = new QueryResultVO<PromotionScopeVO>();
        queryResultInfo.setPageNo(queryResult.getPageNo());
        queryResultInfo.setPageSize(queryResult.getPageSize());
        queryResultInfo.setTotalPages(queryResult.getTotalPages());
        queryResultInfo.setTotalRecords(queryResult.getTotalRecords());
        queryResultInfo.setRecords(toPromotionScopeVOList(queryResult.getRecords()));
        return queryResultInfo;
    }
}