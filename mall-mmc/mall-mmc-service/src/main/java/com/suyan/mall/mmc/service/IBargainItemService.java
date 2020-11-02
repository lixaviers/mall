/*
 * Copyright (c) 2020.
 * 项目名称：素焉商城
 * 创建人：素焉
 * 开源地址: https://github.com/lixaviers/mall
 */
package com.suyan.mall.mmc.service;

import com.suyan.mall.mmc.req.BargainItemQueryDTO;
import com.suyan.mall.mmc.resp.BargainItemVO;
import com.suyan.query.QueryResultVO;

/**
 * @CopyRright (c): <素焉代码生成工具>
 */
public interface IBargainItemService {

    /**
     * 分页查询砍价阶段信息
     *
     * @param bargainItemQueryDTO
     * @return
     */
    QueryResultVO<BargainItemVO> queryBargainItem(BargainItemQueryDTO bargainItemQueryDTO);


}