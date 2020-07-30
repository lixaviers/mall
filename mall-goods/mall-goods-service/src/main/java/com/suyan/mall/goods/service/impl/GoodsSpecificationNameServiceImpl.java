package com.suyan.mall.goods.service.impl;

import com.suyan.mall.goods.biz.GoodsSpecificationNameBiz;
import com.suyan.mall.goods.convertor.GoodsSpecificationNameConvertor;
import com.suyan.mall.goods.model.GoodsSpecificationName;
import com.suyan.mall.goods.req.GoodsSpecificationNameDTO;
import com.suyan.mall.goods.req.GoodsSpecificationNameQueryDTO;
import com.suyan.mall.goods.resp.GoodsSpecificationNameVO;
import com.suyan.mall.goods.service.IGoodsSpecificationNameService;
import com.suyan.query.QueryResultVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * @CopyRright (c): <素焉代码生成工具>
 * @Comments: <Service 商品规格名管理类>
 */
@Slf4j
@Service("goodsSpecificationNameService")
public class GoodsSpecificationNameServiceImpl implements IGoodsSpecificationNameService {

    @Autowired
    private GoodsSpecificationNameBiz goodsSpecificationNameBiz;

    @Override
    public int deleteGoodsSpecificationName(Long id) {
        return goodsSpecificationNameBiz.deleteGoodsSpecificationName(id);
    }

    @Override
    public Long createGoodsSpecificationName(GoodsSpecificationNameDTO goodsSpecificationNameDTO) {
        GoodsSpecificationName goodsSpecificationName = GoodsSpecificationNameConvertor.toGoodsSpecificationName(goodsSpecificationNameDTO);
        return goodsSpecificationNameBiz.createGoodsSpecificationName(goodsSpecificationName);
    }

    @Override
    public int updateGoodsSpecificationName(GoodsSpecificationNameDTO goodsSpecificationNameDTO) {
        GoodsSpecificationName goodsSpecificationName = GoodsSpecificationNameConvertor.toGoodsSpecificationName(goodsSpecificationNameDTO);
        return goodsSpecificationNameBiz.updateGoodsSpecificationName(goodsSpecificationName);
    }

    @Override
    public GoodsSpecificationNameVO getGoodsSpecificationName(Long id) {
        GoodsSpecificationName goodsSpecificationName = goodsSpecificationNameBiz.getGoodsSpecificationName(id);
        return GoodsSpecificationNameConvertor.toGoodsSpecificationNameVO(goodsSpecificationName);
    }

    @Override
    public QueryResultVO<GoodsSpecificationNameVO> queryGoodsSpecificationName(GoodsSpecificationNameQueryDTO goodsSpecificationNameQueryDTO) {
        return GoodsSpecificationNameConvertor.toQueryResult(goodsSpecificationNameBiz.queryGoodsSpecificationName(goodsSpecificationNameQueryDTO));
    }

}