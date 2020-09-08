package com.suyan.mall.user.service;

import com.suyan.mall.user.req.GoodsCollectDTO;
import com.suyan.mall.user.req.GoodsCollectQueryDTO;
import com.suyan.mall.user.resp.GoodsCollectVO;
import com.suyan.query.QueryResultVO;

/**
 * @CopyRright (c): <素焉代码生成工具>
 */
public interface IGoodsCollectService {

    /**
     * 删除商品收藏
     *
     * @param id
     * @return
     * @author
     */
    int deleteGoodsCollect(Long id);

    /**
     * 创建商品收藏
     *
     * @param goodsCollectDTO
     * @return
     */
    void createGoodsCollect(GoodsCollectDTO goodsCollectDTO);


    /**
     * 分页查询商品收藏信息
     *
     * @param goodsCollectQueryDTO
     * @return
     */
    QueryResultVO<GoodsCollectVO> queryGoodsCollect(GoodsCollectQueryDTO goodsCollectQueryDTO);


}