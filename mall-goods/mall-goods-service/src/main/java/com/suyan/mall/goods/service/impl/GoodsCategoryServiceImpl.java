package com.suyan.mall.goods.service.impl;

import com.suyan.mall.goods.biz.GoodsCategoryBiz;
import com.suyan.mall.goods.convertor.GoodsCategoryConvertor;
import com.suyan.mall.goods.model.GoodsCategory;
import com.suyan.mall.goods.req.GoodsCategoryDTO;
import com.suyan.mall.goods.req.GoodsCategoryQueryDTO;
import com.suyan.mall.goods.resp.GoodsCategoryVO;
import com.suyan.mall.goods.service.IGoodsCategoryService;
import com.suyan.query.QueryResultVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


/**
 * @CopyRright (c): <素焉代码生成工具>
 * @Comments: <Service 商品类目管理类>
 */
@Slf4j
@Service("goodsCategoryService")
public class GoodsCategoryServiceImpl implements IGoodsCategoryService {

    @Autowired
    private GoodsCategoryBiz goodsCategoryBiz;

    @Override
    public int deleteGoodsCategory(Integer id) {
        return goodsCategoryBiz.deleteGoodsCategory(id);
    }

    @Override
    public Integer createGoodsCategory(GoodsCategoryDTO goodsCategoryDTO) {
        GoodsCategory goodsCategory = GoodsCategoryConvertor.toGoodsCategory(goodsCategoryDTO);
        return goodsCategoryBiz.createGoodsCategory(goodsCategory);
    }

    @Override
    public int updateGoodsCategory(GoodsCategoryDTO goodsCategoryDTO) {
        GoodsCategory goodsCategory = GoodsCategoryConvertor.toGoodsCategory(goodsCategoryDTO);
        return goodsCategoryBiz.updateGoodsCategory(goodsCategory);
    }

    @Override
    public GoodsCategoryVO getGoodsCategory(Integer id) {
        GoodsCategory goodsCategory = goodsCategoryBiz.getGoodsCategory(id);
        return GoodsCategoryConvertor.toGoodsCategoryVO(goodsCategory);
    }

    @Override
    public QueryResultVO<GoodsCategoryVO> queryGoodsCategory(GoodsCategoryQueryDTO goodsCategoryQueryDTO) {
        return GoodsCategoryConvertor.toQueryResult(goodsCategoryBiz.queryGoodsCategory(goodsCategoryQueryDTO));
    }

    @Override
    public List<GoodsCategoryVO> getTree(byte type) {
        return GoodsCategoryConvertor.toTree(goodsCategoryBiz.getTree(type));
    }

    @Override
    public List<GoodsCategoryVO> getByParentId(Integer parentId, byte type) {
        return GoodsCategoryConvertor.toGoodsCategoryVOList(goodsCategoryBiz.getByParentId(parentId, type));
    }
}