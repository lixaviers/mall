package com.suyan.mall.goods.service;

import com.suyan.mall.goods.req.GoodsCategoryDTO;
import com.suyan.mall.goods.req.GoodsCategoryQueryDTO;
import com.suyan.mall.goods.resp.GoodsCategoryVO;
import com.suyan.query.QueryResultVO;

import java.util.List;


/**
 * @CopyRright (c): <素焉代码生成工具>
 * @Comments: <Service 商品类目管理类>
 */
public interface IGoodsCategoryService {

    /**
     * 删除商品类目
     *
     * @param id
     * @return
     */
    int deleteGoodsCategory(Integer id);

    /**
     * 创建商品类目
     *
     * @param goodsCategoryDTO
     * @return
     */
    Integer createGoodsCategory(GoodsCategoryDTO goodsCategoryDTO);

    /**
     * 更新商品类目
     *
     * @param goodsCategoryDTO
     * @return
     */
    int updateGoodsCategory(GoodsCategoryDTO goodsCategoryDTO);

    /**
     * 根据ID获取商品类目信息
     *
     * @param id
     * @return
     */
    GoodsCategoryVO getGoodsCategory(Integer id);

    /**
     * 分页查询商品类目信息
     *
     * @param goodsCategoryQueryDTO
     * @return
     */
    QueryResultVO<GoodsCategoryVO> queryGoodsCategory(GoodsCategoryQueryDTO goodsCategoryQueryDTO);

    /**
     * 获取类目树
     *
     * @return
     */
    List<GoodsCategoryVO> getTree();
}