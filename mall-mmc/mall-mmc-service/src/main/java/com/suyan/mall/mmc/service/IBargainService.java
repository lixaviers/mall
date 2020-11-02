/*
 * Copyright (c) 2020.
 * 项目名称：素焉商城
 * 创建人：素焉
 * 开源地址: https://github.com/lixaviers/mall
 */
package com.suyan.mall.mmc.service;

import com.suyan.mall.mmc.req.BargainDTO;
import com.suyan.mall.mmc.req.BargainQueryDTO;
import com.suyan.mall.mmc.resp.BargainVO;
import com.suyan.query.QueryResultVO;

/**
 * @CopyRright (c): <素焉代码生成工具>
 */
public interface IBargainService {

    /**
     * 删除砍价
     *
     * @param id
     * @return
     * @author
     */
    int deleteBargain(Long id);

    /**
     * 创建砍价
     *
     * @param bargainDTO
     * @return
     */
    Long createBargain(BargainDTO bargainDTO);


    /**
     * 更新砍价
     *
     * @param bargainDTO
     * @return
     */
    int updateBargain(BargainDTO bargainDTO);

    /**
     * 根据ID获取砍价信息
     *
     * @param id
     * @return
     */
    BargainVO getBargain(Long id);

    /**
     * 分页查询砍价信息
     *
     * @param bargainQueryDTO
     * @return
     */
    QueryResultVO<BargainVO> queryBargain(BargainQueryDTO bargainQueryDTO);


}