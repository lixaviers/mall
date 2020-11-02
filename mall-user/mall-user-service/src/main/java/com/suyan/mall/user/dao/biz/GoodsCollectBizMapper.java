/*
 * Copyright (c) 2020.
 * 项目名称：素焉商城
 * 创建人：素焉
 * 开源地址: https://github.com/lixaviers/mall
 */
package com.suyan.mall.user.dao.biz;

import com.suyan.mall.user.dao.GoodsCollectMapper;
import com.suyan.mall.user.model.GoodsCollect;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface GoodsCollectBizMapper extends GoodsCollectMapper {

    List<GoodsCollect> getUserGoodsCollects(@Param("uniqueUserId") String uniqueUserId);

}