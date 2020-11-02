/*
 * Copyright (c) 2020.
 * 项目名称：素焉商城
 * 创建人：素焉
 * 开源地址: https://github.com/lixaviers/mall
 */
package com.suyan.mall.mmc.service.impl;

import com.suyan.mall.mmc.service.ISubPromotionService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.suyan.mall.mmc.biz.SubPromotionBiz;
import com.suyan.mall.mmc.convertor.SubPromotionConvertor;
import com.suyan.mall.mmc.model.SubPromotion;
import com.suyan.mall.mmc.req.SubPromotionDTO;
import com.suyan.mall.mmc.req.SubPromotionQueryDTO;
import com.suyan.mall.mmc.resp.SubPromotionVO;
import com.suyan.query.QueryResultVO;

import java.util.List;


/**
 * @CopyRright (c): <素焉代码生成工具>
 * @Comments: <Service 订单促销管理类>
 */
@Slf4j
@Service("subPromotionService")
public class SubPromotionServiceImpl implements ISubPromotionService {

    @Autowired
    private SubPromotionBiz subPromotionBiz;

    @Override
    public int deleteSubPromotion(Long id) {
        return subPromotionBiz.deleteSubPromotion(id);
    }

    @Override
    public Long createSubPromotion(SubPromotionDTO subPromotionDTO) {
        return subPromotionBiz.createSubPromotion(SubPromotionConvertor.toSubPromotion(subPromotionDTO));
    }

    @Override
    public int updateSubPromotion(SubPromotionDTO subPromotionDTO) {
        return subPromotionBiz.updateSubPromotion(SubPromotionConvertor.toSubPromotion(subPromotionDTO));
    }

    @Override
    public SubPromotionVO getSubPromotion(Long id ) {
        return SubPromotionConvertor.toSubPromotionVO(subPromotionBiz.getSubPromotion(id));
    }

    @Override
    public QueryResultVO<SubPromotionVO> querySubPromotion(SubPromotionQueryDTO subPromotionQueryDTO) {
        return SubPromotionConvertor.toQueryResult(subPromotionBiz.querySubPromotion(subPromotionQueryDTO));
    }

}