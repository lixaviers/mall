/*
 * Copyright (c) 2020.
 * 项目名称：素焉商城
 * 创建人：素焉
 * 开源地址: https://github.com/lixaviers/mall
 */
package com.suyan.mall.mmc.convertor;

import com.alibaba.fastjson.JSON;
import com.suyan.mall.mmc.enums.PromotionUseTypeEnum;
import com.suyan.mall.mmc.model.PromotionAmountScope;
import com.suyan.mall.mmc.model.SubPromotion;
import com.suyan.mall.mmc.req.SubPromotionDTO;
import com.suyan.mall.mmc.resp.PromotionAmountScopeVO;
import com.suyan.mall.mmc.resp.SubPromotionVO;
import com.suyan.query.QueryResultVO;
import com.suyan.utils.BeanUtil;
import org.springframework.cglib.beans.BeanCopier;

import java.util.ArrayList;
import java.util.List;

/**
 * @CopyRright (c): <素焉代码生成工具>
 * @Comments: <对象相互转换>
 */
public abstract class SubPromotionConvertor {

    private static final BeanCopier beanCopierForSubPromotionVO = BeanCopier.create(SubPromotion.class, SubPromotionVO.class, false);
    private static final BeanCopier beanCopierForSubPromotion = BeanCopier.create(SubPromotionDTO.class, SubPromotion.class, false);

    public static SubPromotionVO toSubPromotionVO(SubPromotion subPromotion) {
        if (subPromotion == null) {
            return null;
        }
        SubPromotionVO subPromotionVO = new SubPromotionVO();
        beanCopierForSubPromotionVO.copy(subPromotion, subPromotionVO, null);
        subPromotionVO.setSubPormotionTypeDesc(PromotionUseTypeEnum.getDescByValue(subPromotion.getSubPromotionType()));
        subPromotionVO.setPromotionAmountScopeList(JSON.parseArray(subPromotion.getPromotionScopeAmount(), PromotionAmountScopeVO.class));
        subPromotionVO.setPromotionScopeList(PromotionScopeConvertor.toPromotionScopeVOList(subPromotion.getPromotionScopeList()));
        return subPromotionVO;
    }

    public static SubPromotion toSubPromotion(SubPromotionDTO subPromotionDTO) {
        SubPromotion subPromotion = new SubPromotion();
        beanCopierForSubPromotion.copy(subPromotionDTO, subPromotion, null);
        subPromotion.setPromotionAmountScopeList(BeanUtil.fastBeanCopy(subPromotionDTO.getPromotionScopeList(), PromotionAmountScope.class));
        subPromotion.setPromotionScopeList(PromotionScopeConvertor.toPromotionScopeList(subPromotionDTO.getPromotionScopeList()));
        return subPromotion;
    }

    public static List<SubPromotionVO> toSubPromotionVOList(List<SubPromotion> subPromotionList) {
        if (subPromotionList == null || subPromotionList.isEmpty()) {
            return null;
        }
        List<SubPromotionVO> subPromotionInfoList = new ArrayList<SubPromotionVO>(subPromotionList.size());
        for (SubPromotion subPromotion : subPromotionList) {
            subPromotionInfoList.add(toSubPromotionVO(subPromotion));
        }
        return subPromotionInfoList;
    }

    public static List<SubPromotion> toSubPromotionList(List<SubPromotionDTO> subPromotionDTOList) {
        if (subPromotionDTOList == null || subPromotionDTOList.isEmpty()) {
            return null;
        }
        List<SubPromotion> subPromotionList = new ArrayList<SubPromotion>(subPromotionDTOList.size());
        for (SubPromotionDTO subPromotionDTO : subPromotionDTOList) {
            subPromotionList.add(toSubPromotion(subPromotionDTO));
        }
        return subPromotionList;
    }

    public static QueryResultVO<SubPromotionVO> toQueryResult(QueryResultVO<SubPromotion> queryResult) {
        QueryResultVO<SubPromotionVO> queryResultInfo = new QueryResultVO<SubPromotionVO>();
        queryResultInfo.setPageNo(queryResult.getPageNo());
        queryResultInfo.setPageSize(queryResult.getPageSize());
        queryResultInfo.setTotalPages(queryResult.getTotalPages());
        queryResultInfo.setTotalRecords(queryResult.getTotalRecords());
        queryResultInfo.setRecords(toSubPromotionVOList(queryResult.getRecords()));
        return queryResultInfo;
    }
}