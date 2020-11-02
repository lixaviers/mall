/*
 * Copyright (c) 2020.
 * 项目名称：素焉商城
 * 创建人：素焉
 * 开源地址: https://github.com/lixaviers/mall
 */
package com.suyan.mall.operation.biz;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.suyan.exception.CommonException;
import com.suyan.mall.operation.dao.ShopMapper;
import com.suyan.mall.operation.enums.CommonStatusEnum;
import com.suyan.mall.operation.model.Address;
import com.suyan.mall.operation.model.Shop;
import com.suyan.mall.operation.model.ShopExample;
import com.suyan.mall.operation.req.ShopQueryDTO;
import com.suyan.query.QueryResultVO;
import com.suyan.result.ResultCode;
import com.suyan.utils.CollectionsUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @CopyRright (c): <素焉代码生成工具>
 * @Comments: <业务层店铺管理类>
 * @jdk 1.8
 * @Version: <1.0>
 */
@Slf4j
@Service
public class ShopBiz {

    @Autowired
    private ShopMapper shopMapper;

    @Autowired
    private AddressBiz addressBiz;


    /**
     * 删除店铺
     *
     * @param id
     * @return
     */
    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, rollbackFor = Exception.class)
    public Integer deleteShop(Long id) {
        getBaseShop(id);
        return shopMapper.deleteByPrimaryKey(id);
    }

    /**
     * 创建店铺
     *
     * @param shop
     * @return
     */
    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, rollbackFor = Exception.class)
    public Long createShop(Shop shop) {

        // 检查店铺名称是否存在
        ShopExample example = new ShopExample();
        example.createCriteria().andShopNameEqualTo(shop.getShopName());
        List<Shop> shopList = shopMapper.selectByExample(example);
        if (CollectionsUtil.isNotEmpty(shopList)) {
            throw new CommonException(ResultCode.DATA_EXIST, "店铺名称");
        }

        // 查询地址
        Address province = addressBiz.getBaseAddress(shop.getProvinceId(), "省份");
        Address city = addressBiz.getBaseAddress(shop.getCityId(), "城市");
        if (!city.getParentId().equals(province.getId())) {
            throw new CommonException(ResultCode.COMMON_PARAM_INVALID, "城市");
        }
        Address area = addressBiz.getBaseAddress(shop.getAreaId(), "区");
        if (!area.getParentId().equals(city.getId())) {
            throw new CommonException(ResultCode.COMMON_PARAM_INVALID, "区");
        }
        shop.setProvinceName(province.getName());
        shop.setCityName(city.getName());
        shop.setAreaName(area.getName());

        shop.setCommonStatus(CommonStatusEnum.NORMAL.getValue());
        shopMapper.insertSelective(shop);
        return shop.getId();
    }


    /**
     * 更新店铺
     *
     * @param shop
     * @return
     */
    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, rollbackFor = Exception.class)
    public Integer updateShop(Shop shop) {
        getBaseShop(shop.getId());
        return shopMapper.updateByPrimaryKeySelective(shop);
    }

    /**
     * 根据ID获取店铺信息
     *
     * @param id
     * @return
     */
    @Transactional(readOnly = true)
    public Shop getShop(Long id) {
        return getBaseShop(id);
    }

    /**
     * 获取店铺信息
     *
     * @return
     */
    @Transactional(readOnly = true)
    public List<Shop> getShopList(String uniqueUserId) {
        return shopMapper.selectByUniqueUserId(uniqueUserId);
    }

    @Transactional(readOnly = true)
    public Shop getBaseShop(Long id) {
        Shop shop = shopMapper.selectByPrimaryKey(id);
        if (shop == null || shop.getIsDeleted()) {
            throw new CommonException(ResultCode.DATA_NOT_EXIST, "店铺");
        }
        return shop;
    }

    /**
     * 分页查询店铺信息
     *
     * @param shopQuery
     * @return
     */
    @Transactional(readOnly = true)
    public QueryResultVO<Shop> queryShop(ShopQueryDTO shopQuery) {
        QueryResultVO<Shop> queryResult = new QueryResultVO<Shop>();
        // 使用分页插件PageHelper实现分页功能
        PageHelper.startPage(shopQuery.getPageNo(), shopQuery.getPageSize());
        List<Shop> shopList = shopMapper.queryShop(shopQuery);
        PageInfo<Shop> pageInfo = new PageInfo<Shop>(shopList);
        queryResult.setPageNo(pageInfo.getPageNum());
        queryResult.setPageSize(pageInfo.getPageSize());
        queryResult.setTotalPages(pageInfo.getPages());
        queryResult.setTotalRecords(pageInfo.getTotal());
        queryResult.setRecords(shopList);
        return queryResult;
    }

    /**
     * 选择店铺
     *
     * @param id
     */
    public Shop select(String uniqueUserId, Long id) {
        Shop shop = getBaseShop(id);
        if (!shop.getUniqueUserId().equals(uniqueUserId)) {
            throw new CommonException(ResultCode.C401);
        }
        return shop;
    }
}