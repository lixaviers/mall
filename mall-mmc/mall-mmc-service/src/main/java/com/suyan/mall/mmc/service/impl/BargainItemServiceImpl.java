package com.suyan.mall.mmc.service.impl;

import com.suyan.mall.mmc.biz.BargainItemBiz;
import com.suyan.mall.mmc.convertor.BargainItemConvertor;
import com.suyan.mall.mmc.req.BargainItemQueryDTO;
import com.suyan.mall.mmc.resp.BargainItemVO;
import com.suyan.mall.mmc.service.IBargainItemService;
import com.suyan.query.QueryResultVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * @CopyRright (c): <素焉代码生成工具>
 * @Comments: <Service 砍价阶段管理类>
 */
@Slf4j
@Service("bargainItemService")
public class BargainItemServiceImpl implements IBargainItemService {

    @Autowired
    private BargainItemBiz bargainItemBiz;

    @Override
    public QueryResultVO<BargainItemVO> queryBargainItem(BargainItemQueryDTO bargainItemQueryDTO) {
        return BargainItemConvertor.toQueryResult(bargainItemBiz.queryBargainItem(bargainItemQueryDTO));
    }

}