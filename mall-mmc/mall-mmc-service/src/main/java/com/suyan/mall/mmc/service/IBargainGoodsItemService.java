package com.suyan.mall.mmc.service;

import com.suyan.mall.mmc.req.BargainGoodsItemDTO;
import com.suyan.mall.mmc.req.BargainGoodsItemQueryDTO;
import com.suyan.mall.mmc.resp.BargainGoodsItemVO;
import com.suyan.query.QueryResultVO;

import java.util.List;

/**
 * @CopyRright (c): <素焉代码生成工具>
 */
public interface IBargainGoodsItemService {

    /**
     * 删除砍价商品阶段
     * 
     * @author 
    * @param id
     * @return
     */
    int deleteBargainGoodsItem(Long id);
    
    /**
     * 创建砍价商品阶段
     * 
     * @param bargainGoodsItemDTO
     * @return
     */
    Long createBargainGoodsItem(BargainGoodsItemDTO bargainGoodsItemDTO);


    /**
     * 更新砍价商品阶段
     * 
     * @param bargainGoodsItemDTO
     * @return
     */
    int updateBargainGoodsItem(BargainGoodsItemDTO bargainGoodsItemDTO);
    
    /**
     * 根据ID获取砍价商品阶段信息
     * 
     * @param id
     * @return
     */
    BargainGoodsItemVO getBargainGoodsItem(Long id);

    /**
     * 分页查询砍价商品阶段信息
     * 
     * @param bargainGoodsItemQueryDTO
     * @return
     */
    QueryResultVO<BargainGoodsItemVO> queryBargainGoodsItem(BargainGoodsItemQueryDTO bargainGoodsItemQueryDTO);



}