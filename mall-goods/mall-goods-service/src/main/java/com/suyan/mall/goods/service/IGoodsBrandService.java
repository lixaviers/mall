package com.suyan.mall.goods.service;

import com.suyan.mall.goods.req.GoodsBrandDTO;
import com.suyan.mall.goods.req.GoodsBrandQueryDTO;
import com.suyan.mall.goods.resp.GoodsBrandVO;
import com.suyan.query.QueryResultVO;

import java.util.List;

/**
 * @CopyRright (c): <素焉代码生成工具>
 */
public interface IGoodsBrandService {

    /**
     * 删除商品品牌
     *
     * @param id
     * @return
     * @author
     */
    int deleteGoodsBrand(Integer id);

    /**
     * 创建商品品牌
     *
     * @param goodsBrandDTO
     * @return
     */
    Integer createGoodsBrand(GoodsBrandDTO goodsBrandDTO);


    /**
     * 更新商品品牌
     *
     * @param goodsBrandDTO
     * @return
     */
    int updateGoodsBrand(GoodsBrandDTO goodsBrandDTO);

    /**
     * 根据ID获取商品品牌信息
     *
     * @param id
     * @return
     */
    GoodsBrandVO getGoodsBrand(Integer id);

    /**
     * 分页查询商品品牌信息
     *
     * @param goodsBrandQueryDTO
     * @return
     */
    QueryResultVO<GoodsBrandVO> queryGoodsBrand(GoodsBrandQueryDTO goodsBrandQueryDTO);

    /**
     * 根据商品类目ID获取商品品牌信息
     *
     * @param categoryId
     * @return
     */
    List<GoodsBrandVO> getGoodsBrandListByCategoryId(Integer categoryId);


}