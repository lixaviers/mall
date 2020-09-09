package com.suyan.mall.goods.service.impl;

import com.suyan.mall.goods.biz.GoodsBiz;
import com.suyan.mall.goods.convertor.GoodsConvertor;
import com.suyan.mall.goods.req.GoodsDTO;
import com.suyan.mall.goods.req.GoodsQueryDTO;
import com.suyan.mall.goods.req.GoodsSearchDTO;
import com.suyan.mall.goods.resp.GoodsVO;
import com.suyan.mall.goods.service.IGoodsService;
import com.suyan.query.QueryResultVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;


/**
 * @CopyRright (c): <素焉代码生成工具>
 * @Comments: <Service 商品管理类>
 */
@Slf4j
@Service("goodsService")
public class GoodsServiceImpl implements IGoodsService {

    @Autowired
    private GoodsBiz goodsBiz;

    @Override
    public int deleteGoods(Long id) {
        return goodsBiz.deleteGoods(id);
    }

    @Override
    public Long createGoods(GoodsDTO goodsDTO) {
        return goodsBiz.createGoods(GoodsConvertor.toGoods(goodsDTO));
    }

    @Override
    public int updateGoods(GoodsDTO goodsDTO) {
        return goodsBiz.updateGoods(GoodsConvertor.toGoods(goodsDTO));
    }

    @Override
    public GoodsVO getGoods(Long id) {
        return GoodsConvertor.toGoodsVO(goodsBiz.getGoods(id));
    }

    @Override
    public GoodsVO getGoodsForC(Long id) {
        return GoodsConvertor.toGoodsVO(goodsBiz.getGoodsForC(id));
    }

    @Override
    public GoodsVO getGoodsInfo(Long id) {
        return GoodsConvertor.toGoodsVO(goodsBiz.getBaseGoods(id));
    }

    @Override
    public List<GoodsVO> getGoodsInfo(List<Long> idList) {
        return GoodsConvertor.toGoodsVOList(goodsBiz.getGoodsInfo(idList));
    }

    @Override
    public QueryResultVO<GoodsVO> queryGoods(GoodsQueryDTO goodsQueryDTO) {
        return GoodsConvertor.toQueryResult(goodsBiz.queryGoods(goodsQueryDTO));
    }

    @Override
    public void shelves(GoodsDTO goodsDTO) {
        goodsBiz.shelves(GoodsConvertor.toGoods(goodsDTO));
    }

    @Override
    public Map<String, Object> search(GoodsSearchDTO goodsSearchDTO) {
        return goodsBiz.search(goodsSearchDTO);
    }
}