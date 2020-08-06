package com.suyan.mall.mmc.service;

import com.suyan.mall.mmc.req.BargainActivityDTO;
import com.suyan.mall.mmc.req.BargainActivityQueryDTO;
import com.suyan.mall.mmc.resp.BargainActivityVO;
import com.suyan.query.QueryResultVO;

import java.util.List;

/**
 * @CopyRright (c): <素焉代码生成工具>
 */
public interface IBargainActivityService {

    /**
     * 删除砍价活动
     * 
     * @author 
    * @param id
     * @return
     */
    int deleteBargainActivity(Long id);
    
    /**
     * 创建砍价活动
     * 
     * @param bargainActivityDTO
     * @return
     */
    Long createBargainActivity(BargainActivityDTO bargainActivityDTO);


    /**
     * 更新砍价活动
     * 
     * @param bargainActivityDTO
     * @return
     */
    int updateBargainActivity(BargainActivityDTO bargainActivityDTO);
    
    /**
     * 根据ID获取砍价活动信息
     * 
     * @param id
     * @return
     */
    BargainActivityVO getBargainActivity(Long id);

    /**
     * 分页查询砍价活动信息
     * 
     * @param bargainActivityQueryDTO
     * @return
     */
    QueryResultVO<BargainActivityVO> queryBargainActivity(BargainActivityQueryDTO bargainActivityQueryDTO);



}