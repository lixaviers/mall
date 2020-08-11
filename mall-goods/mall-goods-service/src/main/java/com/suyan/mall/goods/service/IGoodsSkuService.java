package com.suyan.mall.goods.service;

import com.suyan.mall.goods.req.GoodsSkuQueryDTO;
import com.suyan.mall.goods.resp.GoodsSkuVO;
import com.suyan.query.QueryResultVO;


/**
 * @CopyRright (c): <素焉代码生成工具>
 * @Comments: <Service 商品规格管理类>
 */
public interface IGoodsSkuService {

    /**
     * 分页查询商品规格信息
     *
     * @param goodsSkuQueryDTO
     * @return
     */
    QueryResultVO<GoodsSkuVO> queryGoodsSku(GoodsSkuQueryDTO goodsSkuQueryDTO);

    /**
     * 根据商品编码查询商品规格信息
     *
     * @param skuCode
     * @return
     */
    GoodsSkuVO getGoodsSku(String skuCode);

}