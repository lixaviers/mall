package com.suyan.mall.goods.service;

import com.suyan.mall.goods.req.GoodsDTO;
import com.suyan.mall.goods.req.GoodsQueryDTO;
import com.suyan.mall.goods.req.GoodsSearchDTO;
import com.suyan.mall.goods.resp.GoodsVO;
import com.suyan.query.QueryResultVO;

import java.util.List;
import java.util.Map;


/**
 * @CopyRright (c): <素焉代码生成工具>
 * @Comments: <Service 商品管理类>
 */
public interface IGoodsService {

    /**
     * 删除商品
     *
     * @param id
     * @return
     */
    int deleteGoods(Long id);

    /**
     * 创建商品
     *
     * @param goodsDTO
     * @return
     */
    Long createGoods(GoodsDTO goodsDTO);

    /**
     * 更新商品
     *
     * @param goodsDTO
     * @return
     */
    int updateGoods(GoodsDTO goodsDTO);

    /**
     * 根据ID获取商品信息
     *
     * @param id
     * @return
     */
    GoodsVO getGoods(Long id);

    GoodsVO getGoodsForC(Long id);

    /**
     * 根据id获取商品信息-feign
     *
     * @param id
     * @return
     */
    GoodsVO getGoodsInfo(Long id);
    List<GoodsVO> getGoodsInfo(List<Long> idList);

    /**
     * 分页查询商品信息
     *
     * @param goodsQueryDTO
     * @return
     */
    QueryResultVO<GoodsVO> queryGoods(GoodsQueryDTO goodsQueryDTO);

    /**
     * 商品上下架
     *
     * @param goodsDTO
     */
    void shelves(GoodsDTO goodsDTO);

    /**
     * 商品搜索
     *
     * @param goodsSearchDTO
     * @return
     */
    Map<String, Object> search(GoodsSearchDTO goodsSearchDTO);

}