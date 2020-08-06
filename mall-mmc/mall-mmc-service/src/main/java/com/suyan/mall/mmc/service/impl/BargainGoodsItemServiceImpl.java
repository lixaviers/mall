package com.suyan.mall.mmc.service.impl;

import com.suyan.mall.mmc.service.IBargainGoodsItemService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.suyan.mall.mmc.biz.BargainGoodsItemBiz;
import com.suyan.mall.mmc.convertor.BargainGoodsItemConvertor;
import com.suyan.mall.mmc.model.BargainGoodsItem;
import com.suyan.mall.mmc.req.BargainGoodsItemDTO;
import com.suyan.mall.mmc.req.BargainGoodsItemQueryDTO;
import com.suyan.mall.mmc.resp.BargainGoodsItemVO;
import com.suyan.query.QueryResultVO;

import java.util.List;


/**
 * @CopyRright (c): <素焉代码生成工具>
 * @Comments: <Service 砍价商品阶段管理类>
 */
@Slf4j
@Service("bargainGoodsItemService")
public class BargainGoodsItemServiceImpl implements IBargainGoodsItemService {

    @Autowired
    private BargainGoodsItemBiz bargainGoodsItemBiz;

    @Override
    public int deleteBargainGoodsItem(Long id) {
        return bargainGoodsItemBiz.deleteBargainGoodsItem(id);
    }

    @Override
    public Long createBargainGoodsItem(BargainGoodsItemDTO bargainGoodsItemDTO) {
        return bargainGoodsItemBiz.createBargainGoodsItem(BargainGoodsItemConvertor.toBargainGoodsItem(bargainGoodsItemDTO));
    }

    @Override
    public int updateBargainGoodsItem(BargainGoodsItemDTO bargainGoodsItemDTO) {
        return bargainGoodsItemBiz.updateBargainGoodsItem(BargainGoodsItemConvertor.toBargainGoodsItem(bargainGoodsItemDTO));
    }

    @Override
    public BargainGoodsItemVO getBargainGoodsItem(Long id ) {
        return BargainGoodsItemConvertor.toBargainGoodsItemVO(bargainGoodsItemBiz.getBargainGoodsItem(id));
    }

    @Override
    public QueryResultVO<BargainGoodsItemVO> queryBargainGoodsItem(BargainGoodsItemQueryDTO bargainGoodsItemQueryDTO) {
        return BargainGoodsItemConvertor.toQueryResult(bargainGoodsItemBiz.queryBargainGoodsItem(bargainGoodsItemQueryDTO));
    }

}