package com.suyan.mall.user.service.impl;

import com.suyan.mall.user.service.IShopCollectService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.suyan.mall.user.biz.ShopCollectBiz;
import com.suyan.mall.user.convertor.ShopCollectConvertor;
import com.suyan.mall.user.model.ShopCollect;
import com.suyan.mall.user.req.ShopCollectDTO;
import com.suyan.mall.user.req.ShopCollectQueryDTO;
import com.suyan.mall.user.resp.ShopCollectVO;
import com.suyan.query.QueryResultVO;

import java.util.List;


/**
 * @CopyRright (c): <素焉代码生成工具>
 * @Comments: <Service 店铺收藏管理类>
 */
@Slf4j
@Service("shopCollectService")
public class ShopCollectServiceImpl implements IShopCollectService {

    @Autowired
    private ShopCollectBiz shopCollectBiz;

    @Override
    public int deleteShopCollect(Long id) {
        return shopCollectBiz.deleteShopCollect(id);
    }

    @Override
    public Long createShopCollect(ShopCollectDTO shopCollectDTO) {
        return shopCollectBiz.createShopCollect(ShopCollectConvertor.toShopCollect(shopCollectDTO));
    }

    @Override
    public void setTop(ShopCollectDTO shopCollectDTO) {
        shopCollectBiz.setTop(ShopCollectConvertor.toShopCollect(shopCollectDTO));
    }

    @Override
    public ShopCollectVO getShopCollect(Long id ) {
        return ShopCollectConvertor.toShopCollectVO(shopCollectBiz.getShopCollect(id));
    }

    @Override
    public QueryResultVO<ShopCollectVO> queryShopCollect(ShopCollectQueryDTO shopCollectQueryDTO) {
        return ShopCollectConvertor.toQueryResult(shopCollectBiz.queryShopCollect(shopCollectQueryDTO));
    }

}