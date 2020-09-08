package com.suyan.mall.user.biz;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.suyan.exception.CommonException;
import com.suyan.mall.user.dao.ShopCollectMapper;
import com.suyan.mall.user.model.ShopCollect;
import com.suyan.mall.user.req.ShopCollectQueryDTO;
import com.suyan.mall.user.resp.b.UserInfoVO;
import com.suyan.mall.user.utils.UserUtil;
import com.suyan.query.QueryResultVO;
import com.suyan.result.ResultCode;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @CopyRright (c): <素焉代码生成工具>
 * @Comments: <业务层店铺收藏管理类>
 */
@Slf4j
@Service
public class ShopCollectBiz {

    @Autowired
    private ShopCollectMapper shopCollectMapper;

    /**
     * 删除店铺收藏
     *
     * @param id
     * @return
     */
    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, rollbackFor = Exception.class)
    public Integer deleteShopCollect(Long id) {
        checkBaseShopCollect(id);
        return shopCollectMapper.logicalDeleteByPrimaryKey(id);
    }

    /**
     * 创建店铺收藏
     *
     * @param shopCollect
     * @return
     */
    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, rollbackFor = Exception.class)
    public Long createShopCollect(ShopCollect shopCollect) {
        shopCollect.setUniqueUserId(UserUtil.getUser().getUniqueUserId());
        shopCollectMapper.insertSelective(shopCollect);
        return shopCollect.getId();
    }

    /**
     * 置顶店铺收藏
     *
     * @param shopCollect
     * @return
     */
    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, rollbackFor = Exception.class)
    public Integer setTop(ShopCollect shopCollect) {
        checkBaseShopCollect(shopCollect.getId());
        return shopCollectMapper.updateByPrimaryKeySelective(shopCollect);
    }

    /**
     * 根据ID获取店铺收藏信息
     *
     * @param id
     * @return
     */
    @Transactional(readOnly = true)
    public ShopCollect getShopCollect(Long id) {
        return getBaseShopCollect(id);
    }

    @Transactional(readOnly = true)
    public ShopCollect getBaseShopCollect(Long id) {
        ShopCollect shopCollect = shopCollectMapper.selectByPrimaryKey(id);
        if (shopCollect == null || shopCollect.getIsDeleted()) {
            throw new CommonException(ResultCode.DATA_NOT_EXIST, "店铺收藏");
        }
        return shopCollect;
    }

    @Transactional(readOnly = true)
    public ShopCollect checkBaseShopCollect(Long id) {
        ShopCollect shopCollect = getBaseShopCollect(id);
        if (UserUtil.getUser().getUniqueUserId().equals(shopCollect.getUniqueUserId())) {
            throw new CommonException(ResultCode.DATA_NOT_EXIST, "收藏");
        }
        return shopCollect;
    }

    /**
     * 分页查询店铺收藏信息
     *
     * @param shopCollectQuery
     * @return
     */
    @Transactional(readOnly = true)
    public QueryResultVO<ShopCollect> queryShopCollect(ShopCollectQueryDTO shopCollectQuery) {
        UserInfoVO user = UserUtil.getUser();
        shopCollectQuery.setUniqueUserId(user.getUniqueUserId());
        shopCollectQuery.setIsDeleted(false);
        QueryResultVO<ShopCollect> queryResult = new QueryResultVO<ShopCollect>();
        // 使用分页插件PageHelper实现分页功能
        PageHelper.startPage(shopCollectQuery.getPageNo(), shopCollectQuery.getPageSize());
        List<ShopCollect> shopCollectList = shopCollectMapper.queryShopCollect(shopCollectQuery);
        PageInfo<ShopCollect> pageInfo = new PageInfo<ShopCollect>(shopCollectList);
        queryResult.setPageNo(pageInfo.getPageNum());
        queryResult.setPageSize(pageInfo.getPageSize());
        queryResult.setTotalPages(pageInfo.getPages());
        queryResult.setTotalRecords(pageInfo.getTotal());
        queryResult.setRecords(shopCollectList);
        return queryResult;
    }

}