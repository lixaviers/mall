package com.suyan.mall.mmc.service.impl;

import com.suyan.mall.mmc.service.IBargainGoodsService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.suyan.mall.mmc.biz.BargainGoodsBiz;
import com.suyan.mall.mmc.convertor.BargainGoodsConvertor;
import com.suyan.mall.mmc.model.BargainGoods;
import com.suyan.mall.mmc.req.BargainGoodsDTO;
import com.suyan.mall.mmc.req.BargainGoodsQueryDTO;
import com.suyan.mall.mmc.resp.BargainGoodsVO;
import com.suyan.query.QueryResultVO;

import java.util.List;


/**
 * @CopyRright (c): <素焉代码生成工具>
 * @Comments: <Service 砍价商品管理类>
 */
@Slf4j
@Service("bargainGoodsService")
public class BargainGoodsServiceImpl implements IBargainGoodsService {

    @Autowired
    private BargainGoodsBiz bargainGoodsBiz;

    @Override
    public int deleteBargainGoods(Long id) {
        return bargainGoodsBiz.deleteBargainGoods(id);
    }

    @Override
    public Long createBargainGoods(BargainGoodsDTO bargainGoodsDTO) {
        return bargainGoodsBiz.createBargainGoods(BargainGoodsConvertor.toBargainGoods(bargainGoodsDTO));
    }

    @Override
    public int updateBargainGoods(BargainGoodsDTO bargainGoodsDTO) {
        return bargainGoodsBiz.updateBargainGoods(BargainGoodsConvertor.toBargainGoods(bargainGoodsDTO));
    }

    @Override
    public BargainGoodsVO getBargainGoods(Long id ) {
        return BargainGoodsConvertor.toBargainGoodsVO(bargainGoodsBiz.getBargainGoods(id));
    }

    @Override
    public QueryResultVO<BargainGoodsVO> queryBargainGoods(BargainGoodsQueryDTO bargainGoodsQueryDTO) {
        return BargainGoodsConvertor.toQueryResult(bargainGoodsBiz.queryBargainGoods(bargainGoodsQueryDTO));
    }

}