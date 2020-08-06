package com.suyan.mall.mmc.service.impl;

import com.suyan.mall.mmc.service.IBargainActivityService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.suyan.mall.mmc.biz.BargainActivityBiz;
import com.suyan.mall.mmc.convertor.BargainActivityConvertor;
import com.suyan.mall.mmc.model.BargainActivity;
import com.suyan.mall.mmc.req.BargainActivityDTO;
import com.suyan.mall.mmc.req.BargainActivityQueryDTO;
import com.suyan.mall.mmc.resp.BargainActivityVO;
import com.suyan.query.QueryResultVO;

import java.util.List;


/**
 * @CopyRright (c): <素焉代码生成工具>
 * @Comments: <Service 砍价活动管理类>
 */
@Slf4j
@Service("bargainActivityService")
public class BargainActivityServiceImpl implements IBargainActivityService {

    @Autowired
    private BargainActivityBiz bargainActivityBiz;

    @Override
    public int deleteBargainActivity(Long id) {
        return bargainActivityBiz.deleteBargainActivity(id);
    }

    @Override
    public Long createBargainActivity(BargainActivityDTO bargainActivityDTO) {
        return bargainActivityBiz.createBargainActivity(BargainActivityConvertor.toBargainActivity(bargainActivityDTO));
    }

    @Override
    public int updateBargainActivity(BargainActivityDTO bargainActivityDTO) {
        return bargainActivityBiz.updateBargainActivity(BargainActivityConvertor.toBargainActivity(bargainActivityDTO));
    }

    @Override
    public BargainActivityVO getBargainActivity(Long id ) {
        return BargainActivityConvertor.toBargainActivityVO(bargainActivityBiz.getBargainActivity(id));
    }

    @Override
    public QueryResultVO<BargainActivityVO> queryBargainActivity(BargainActivityQueryDTO bargainActivityQueryDTO) {
        return BargainActivityConvertor.toQueryResult(bargainActivityBiz.queryBargainActivity(bargainActivityQueryDTO));
    }

}