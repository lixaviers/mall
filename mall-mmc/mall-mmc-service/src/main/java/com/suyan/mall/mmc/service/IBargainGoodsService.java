package com.suyan.mall.mmc.service;

import com.suyan.mall.mmc.req.BargainGoodsDTO;
import com.suyan.mall.mmc.req.BargainGoodsQueryDTO;
import com.suyan.mall.mmc.resp.BargainGoodsVO;
import com.suyan.query.QueryResultVO;

import java.util.List;

/**
 * @CopyRright (c): <素焉代码生成工具>
 */
public interface IBargainGoodsService {

    /**
     * 删除砍价商品
     * 
     * @author 
    * @param id
     * @return
     */
    int deleteBargainGoods(Long id);
    
    /**
     * 创建砍价商品
     * 
     * @param bargainGoodsDTO
     * @return
     */
    Long createBargainGoods(BargainGoodsDTO bargainGoodsDTO);


    /**
     * 更新砍价商品
     * 
     * @param bargainGoodsDTO
     * @return
     */
    int updateBargainGoods(BargainGoodsDTO bargainGoodsDTO);
    
    /**
     * 根据ID获取砍价商品信息
     * 
     * @param id
     * @return
     */
    BargainGoodsVO getBargainGoods(Long id);

    /**
     * 分页查询砍价商品信息
     * 
     * @param bargainGoodsQueryDTO
     * @return
     */
    QueryResultVO<BargainGoodsVO> queryBargainGoods(BargainGoodsQueryDTO bargainGoodsQueryDTO);



}