package com.suyan.mall.goods.service;

import com.suyan.mall.goods.req.GoodsSpecificationNameDTO;
import com.suyan.mall.goods.req.GoodsSpecificationNameQueryDTO;
import com.suyan.mall.goods.resp.GoodsSpecificationNameVO;
import com.suyan.query.QueryResultVO;


/**
 * @CopyRright (c): <素焉代码生成工具>
 * @Comments: <Service 商品规格名管理类>
 */
public interface IGoodsSpecificationNameService {

    /**
     * 删除商品规格名
     *
     * @param id
     * @return
     */
    int deleteGoodsSpecificationName(Long id);

    /**
     * 创建商品规格名
     *
     * @param goodsSpecificationNameDTO
     * @return
     */
    Long createGoodsSpecificationName(GoodsSpecificationNameDTO goodsSpecificationNameDTO);

    /**
     * 更新商品规格名
     *
     * @param goodsSpecificationNameDTO
     * @return
     */
    int updateGoodsSpecificationName(GoodsSpecificationNameDTO goodsSpecificationNameDTO);

    /**
     * 根据ID获取商品规格名信息
     *
     * @param id
     * @return
     */
    GoodsSpecificationNameVO getGoodsSpecificationName(Long id);

    /**
     * 分页查询商品规格名信息
     *
     * @param goodsSpecificationNameQueryDTO
     * @return
     */
    QueryResultVO<GoodsSpecificationNameVO> queryGoodsSpecificationName(GoodsSpecificationNameQueryDTO goodsSpecificationNameQueryDTO);

}