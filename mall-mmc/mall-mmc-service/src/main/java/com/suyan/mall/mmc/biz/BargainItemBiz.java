/*
 * Copyright (c) 2020.
 * 项目名称：素焉商城
 * 创建人：素焉
 * 开源地址: https://github.com/lixaviers/mall
 */
package com.suyan.mall.mmc.biz;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.suyan.mall.mmc.dao.BargainItemMapper;
import com.suyan.mall.mmc.model.BargainItem;
import com.suyan.mall.mmc.req.BargainItemQueryDTO;
import com.suyan.query.QueryResultVO;
import com.suyan.utils.CollectionsUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @CopyRright (c): <素焉代码生成工具>
 * @Comments: <业务层砍价阶段管理类>
 */
@Slf4j
@Service
public class BargainItemBiz {

    @Autowired
    private BargainItemMapper bargainItemMapper;

    /**
     * 创建砍价阶段
     *
     * @return
     */
    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, rollbackFor = Exception.class)
    public void createBargainItem(Long bargainId, List<BargainItem> bargainItemList) {
        if (CollectionsUtil.isNotEmpty(bargainItemList)) {
            bargainItemList.forEach(bargainItem -> {
                bargainItem.setBargainId(bargainId);
            });
            bargainItemMapper.insertBatch(bargainItemList);
        }
    }

    /**
     * 更新砍价阶段
     *
     * @return
     */
    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, rollbackFor = Exception.class)
    public void updateBargainItem(Long bargainId, List<BargainItem> bargainItemList) {
        if (CollectionsUtil.isNotEmpty(bargainItemList)) {
            // 新增
            List<BargainItem> addList = bargainItemList.stream().filter(item -> item.getId() == null).collect(Collectors.toList());
            createBargainItem(bargainId, addList);
            // 更新
            List<BargainItem> updateList = bargainItemList.stream().filter(item -> item.getId() != null).collect(Collectors.toList());
            if (CollectionsUtil.isNotEmpty(updateList)) {
                for (BargainItem bargainItem : updateList) {
                    bargainItemMapper.updateByPrimaryKeySelective(bargainItem);
                }
            }
        }
    }

    /**
     * 根据砍价ID获取砍价阶段信息
     *
     * @param bargainId
     * @return
     */
    @Transactional(readOnly = true)
    public List<BargainItem> getBargainItemListByBargainId(Long bargainId) {
        return bargainItemMapper.selectByBargainId(bargainId);
    }

    /**
     * 分页查询砍价阶段信息
     *
     * @param bargainItemQuery
     * @return
     */
    @Transactional(readOnly = true)
    public QueryResultVO<BargainItem> queryBargainItem(BargainItemQueryDTO bargainItemQuery) {
        QueryResultVO<BargainItem> queryResult = new QueryResultVO<BargainItem>();
        // 使用分页插件PageHelper实现分页功能
        PageHelper.startPage(bargainItemQuery.getPageNo(), bargainItemQuery.getPageSize());
        List<BargainItem> bargainItemList = bargainItemMapper.queryBargainItem(bargainItemQuery);
        PageInfo<BargainItem> pageInfo = new PageInfo<BargainItem>(bargainItemList);
        queryResult.setPageNo(pageInfo.getPageNum());
        queryResult.setPageSize(pageInfo.getPageSize());
        queryResult.setTotalPages(pageInfo.getPages());
        queryResult.setTotalRecords(pageInfo.getTotal());
        queryResult.setRecords(bargainItemList);
        return queryResult;
    }

}