package com.suyan.mall.mmc.service.impl;

import com.suyan.mall.mmc.biz.BargainBiz;
import com.suyan.mall.mmc.convertor.BargainConvertor;
import com.suyan.mall.mmc.req.BargainDTO;
import com.suyan.mall.mmc.req.BargainQueryDTO;
import com.suyan.mall.mmc.resp.BargainVO;
import com.suyan.mall.mmc.service.IBargainService;
import com.suyan.query.QueryResultVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * @CopyRright (c): <素焉代码生成工具>
 * @Comments: <Service 砍价管理类>
 */
@Slf4j
@Service("bargainService")
public class BargainServiceImpl implements IBargainService {

    @Autowired
    private BargainBiz bargainBiz;

    @Override
    public int deleteBargain(Long id) {
        return bargainBiz.deleteBargain(id);
    }

    @Override
    public Long createBargain(BargainDTO bargainDTO) {
        return bargainBiz.createBargain(BargainConvertor.toBargain(bargainDTO));
    }

    @Override
    public int updateBargain(BargainDTO bargainDTO) {
        return bargainBiz.updateBargain(BargainConvertor.toBargain(bargainDTO));
    }

    @Override
    public BargainVO getBargain(Long id) {
        return BargainConvertor.toBargainVO(bargainBiz.getBargain(id));
    }

    @Override
    public QueryResultVO<BargainVO> queryBargain(BargainQueryDTO bargainQueryDTO) {
        return BargainConvertor.toQueryResult(bargainBiz.queryBargain(bargainQueryDTO));
    }

}