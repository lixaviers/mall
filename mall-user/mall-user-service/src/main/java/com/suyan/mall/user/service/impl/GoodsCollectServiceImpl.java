package com.suyan.mall.user.service.impl;

import com.suyan.mall.user.service.IGoodsCollectService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.suyan.mall.user.biz.GoodsCollectBiz;
import com.suyan.mall.user.convertor.GoodsCollectConvertor;
import com.suyan.mall.user.model.GoodsCollect;
import com.suyan.mall.user.req.GoodsCollectDTO;
import com.suyan.mall.user.req.GoodsCollectQueryDTO;
import com.suyan.mall.user.resp.GoodsCollectVO;
import com.suyan.query.QueryResultVO;

import java.util.List;


/**
 * @CopyRright (c): <素焉代码生成工具>
 * @Comments: <Service 商品收藏管理类>
 */
@Slf4j
@Service("goodsCollectService")
public class GoodsCollectServiceImpl implements IGoodsCollectService {

    @Autowired
    private GoodsCollectBiz goodsCollectBiz;

    @Override
    public int deleteGoodsCollect(Long id) {
        return goodsCollectBiz.deleteGoodsCollect(id);
    }

    @Override
    public void createGoodsCollect(GoodsCollectDTO goodsCollectDTO) {
        goodsCollectBiz.createGoodsCollect(GoodsCollectConvertor.toGoodsCollect(goodsCollectDTO));
    }

    @Override
    public QueryResultVO<GoodsCollectVO> queryGoodsCollect(GoodsCollectQueryDTO goodsCollectQueryDTO) {
        return GoodsCollectConvertor.toQueryResult(goodsCollectBiz.queryGoodsCollect(goodsCollectQueryDTO));
    }

}