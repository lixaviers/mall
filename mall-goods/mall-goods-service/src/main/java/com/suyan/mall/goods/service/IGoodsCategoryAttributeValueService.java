package com.suyan.mall.goods.service;

import com.suyan.mall.goods.req.GoodsCategoryAttributeValueDTO;
import com.suyan.mall.goods.req.GoodsCategoryAttributeValueQueryDTO;
import com.suyan.mall.goods.resp.GoodsCategoryAttributeValueVO;
import com.suyan.query.QueryResultVO;

import java.util.List;

/**
 * @CopyRright (c): <素焉代码生成工具>
 */
public interface IGoodsCategoryAttributeValueService {

    /**
     * 删除商品类目属性值
     * 
     * @author 
    * @param id
     * @return
     */
    int deleteGoodsCategoryAttributeValue(Long id);
    
    /**
     * 创建商品类目属性值
     * 
     * @param goodsCategoryAttributeValueDTO
     * @return
     */
    Long createGoodsCategoryAttributeValue(GoodsCategoryAttributeValueDTO goodsCategoryAttributeValueDTO);


    /**
     * 更新商品类目属性值
     * 
     * @param goodsCategoryAttributeValueDTO
     * @return
     */
    int updateGoodsCategoryAttributeValue(GoodsCategoryAttributeValueDTO goodsCategoryAttributeValueDTO);
    
    /**
     * 根据ID获取商品类目属性值信息
     * 
     * @param id
     * @return
     */
    GoodsCategoryAttributeValueVO getGoodsCategoryAttributeValue(Long id);

    /**
     * 分页查询商品类目属性值信息
     * 
     * @param goodsCategoryAttributeValueQueryDTO
     * @return
     */
    QueryResultVO<GoodsCategoryAttributeValueVO> queryGoodsCategoryAttributeValue(GoodsCategoryAttributeValueQueryDTO goodsCategoryAttributeValueQueryDTO);



}