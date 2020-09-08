package com.suyan.mall.user.biz;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.suyan.exception.CommonException;
import com.suyan.mall.goods.resp.GoodsSkuVO;
import com.suyan.mall.user.client.GoodsSkuClient;
import com.suyan.mall.user.dao.GoodsCollectMapper;
import com.suyan.mall.user.model.GoodsCollect;
import com.suyan.mall.user.model.GoodsCollectExample;
import com.suyan.mall.user.req.GoodsCollectQueryDTO;
import com.suyan.mall.user.resp.b.UserInfoVO;
import com.suyan.mall.user.utils.UserUtil;
import com.suyan.query.QueryResultVO;
import com.suyan.result.Result;
import com.suyan.result.ResultCode;
import com.suyan.utils.CollectionsUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.List;

/**
 * @CopyRright (c): <素焉代码生成工具>
 * @Comments: <业务层商品收藏管理类>
 */
@Slf4j
@Service
public class GoodsCollectBiz {

    @Autowired
    private GoodsCollectMapper goodsCollectMapper;

    @Autowired
    private GoodsSkuClient goodsSkuClient;

    /**
     * 删除商品收藏
     *
     * @param id
     * @return
     */
    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, rollbackFor = Exception.class)
    public Integer deleteGoodsCollect(Long id) {
        GoodsCollect goodsCollect = getBaseGoodsCollect(id);
        UserInfoVO user = UserUtil.getUser();
        if (!user.getUniqueUserId().equals(goodsCollect.getUniqueUserId())) {
            throw new CommonException(ResultCode.DATA_NOT_EXIST, "收藏");
        }
        return goodsCollectMapper.logicalDeleteByPrimaryKey(id);
    }

    /**
     * 创建商品收藏
     *
     * @param goodsCollect
     * @return
     */
    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, rollbackFor = Exception.class)
    public void createGoodsCollect(GoodsCollect goodsCollect) {
        UserInfoVO user = UserUtil.getUser();

        // 查询是否已经收藏
        GoodsCollectExample example = new GoodsCollectExample();
        example.createCriteria().andIsDeletedEqualTo(false).andUniqueUserIdEqualTo(user.getUniqueUserId()).andGoodsSkuCodeEqualTo(goodsCollect.getGoodsSkuCode());
        List<GoodsCollect> goodsCollectList = goodsCollectMapper.selectByExample(example);
        if (CollectionsUtil.isNotEmpty(goodsCollectList)) {
            return;
        }

        // 获取商品信息
        Result<List<GoodsSkuVO>> result = goodsSkuClient.getGoodsInfo(Arrays.asList(goodsCollect.getGoodsSkuCode()));
        if (CollectionsUtil.isEmpty(result.getData())) {
            throw new CommonException(ResultCode.API_INVLID_DATA, "商品");
        }
        GoodsSkuVO goodsSkuVO = result.getData().get(0);
        goodsCollect.setShopId(goodsSkuVO.getShopId());
        goodsCollect.setGoodsPrice(goodsSkuVO.getPrice());
        goodsCollect.setUniqueUserId(user.getUniqueUserId());
        goodsCollectMapper.insertSelective(goodsCollect);
    }

    /**
     * 根据ID获取商品收藏信息
     *
     * @param id
     * @return
     */
    @Transactional(readOnly = true)
    public GoodsCollect getGoodsCollect(Long id) {
        return getBaseGoodsCollect(id);
    }

    @Transactional(readOnly = true)
    public GoodsCollect getBaseGoodsCollect(Long id) {
        GoodsCollect goodsCollect = goodsCollectMapper.selectByPrimaryKey(id);
        if (goodsCollect == null || goodsCollect.getIsDeleted()) {
            throw new CommonException(ResultCode.DATA_NOT_EXIST, "商品收藏");
        }
        return goodsCollect;
    }

    /**
     * 分页查询商品收藏信息
     *
     * @param goodsCollectQuery
     * @return
     */
    @Transactional(readOnly = true)
    public QueryResultVO<GoodsCollect> queryGoodsCollect(GoodsCollectQueryDTO goodsCollectQuery) {
        UserInfoVO user = UserUtil.getUser();
        goodsCollectQuery.setUniqueUserId(user.getUniqueUserId());
        goodsCollectQuery.setIsDeleted(false);
        QueryResultVO<GoodsCollect> queryResult = new QueryResultVO<GoodsCollect>();
        // 使用分页插件PageHelper实现分页功能
        PageHelper.startPage(goodsCollectQuery.getPageNo(), goodsCollectQuery.getPageSize());
        List<GoodsCollect> goodsCollectList = goodsCollectMapper.queryGoodsCollect(goodsCollectQuery);
        PageInfo<GoodsCollect> pageInfo = new PageInfo<GoodsCollect>(goodsCollectList);
        queryResult.setPageNo(pageInfo.getPageNum());
        queryResult.setPageSize(pageInfo.getPageSize());
        queryResult.setTotalPages(pageInfo.getPages());
        queryResult.setTotalRecords(pageInfo.getTotal());
        queryResult.setRecords(goodsCollectList);
        return queryResult;
    }

}