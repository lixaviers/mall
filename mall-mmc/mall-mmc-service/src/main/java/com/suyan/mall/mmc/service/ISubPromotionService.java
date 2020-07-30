package com.suyan.mall.mmc.service;

import com.suyan.mall.mmc.req.SubPromotionDTO;
import com.suyan.mall.mmc.req.SubPromotionQueryDTO;
import com.suyan.mall.mmc.resp.SubPromotionVO;
import com.suyan.query.QueryResultVO;

import java.util.List;

/**
 * @CopyRright (c): <素焉代码生成工具>
 */
public interface ISubPromotionService {

    /**
     * 删除订单促销
     * 
     * @author 
     * @param id
     * @return
     */
    int deleteSubPromotion(Long id);

    /**
     * 创建订单促销
     * 
     * @param subPromotionDTO
     * @return
     */
    Long createSubPromotion(SubPromotionDTO subPromotionDTO);


    /**
     * 更新订单促销
     * 
     * @param subPromotionDTO
     * @return
     */
    int updateSubPromotion(SubPromotionDTO subPromotionDTO);
    
    /**
     * 根据ID获取订单促销信息
     * 
     * @param id
     * @return
     */
    SubPromotionVO getSubPromotion(Long id);

    /**
     * 分页查询订单促销信息
     * 
     * @param subPromotionQueryDTO
     * @return
     */
    QueryResultVO<SubPromotionVO> querySubPromotion(SubPromotionQueryDTO subPromotionQueryDTO);



}