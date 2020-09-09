package com.suyan.mall.user.biz;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.suyan.exception.CommonException;
import com.suyan.mall.goods.resp.GoodsVO;
import com.suyan.mall.user.client.GoodsClient;
import com.suyan.mall.user.dao.biz.GoodsCollectBizMapper;
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

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @CopyRright (c): <素焉代码生成工具>
 * @Comments: <业务层商品收藏管理类>
 */
@Slf4j
@Service
public class GoodsCollectBiz {

    @Autowired
    private GoodsCollectBizMapper goodsCollectBizMapper;

    @Autowired
    private GoodsClient goodsClient;

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
        return goodsCollectBizMapper.logicalDeleteByPrimaryKey(id);
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
        GoodsCollect goodsCollectLast = getGoodsCollect(goodsCollect.getGoodsId(), user.getUniqueUserId());
        if (goodsCollectLast != null) {
            if (goodsCollect.getDeleteFlag() != null && goodsCollect.getDeleteFlag()) {
                goodsCollectBizMapper.logicalDeleteByPrimaryKey(goodsCollectLast.getId());
            }
            return;
        }

        // 获取商品信息
        Result<GoodsVO> result = goodsClient.getGoodsInfo(goodsCollect.getGoodsId());
        GoodsVO goodsVO = result.getData();
        goodsCollect.setShopId(goodsVO.getShopId());
        goodsCollect.setGoodsPrice(goodsVO.getListPrice());
        goodsCollect.setUniqueUserId(user.getUniqueUserId());
        goodsCollectBizMapper.insertSelective(goodsCollect);
    }

    /**
     * 批量创建商品收藏
     *
     * @param goodsIdList
     * @return
     */
    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, rollbackFor = Exception.class)
    public void batchCreateGoodsCollect(List<Long> goodsIdList) {
        if (CollectionsUtil.isNotEmpty(goodsIdList)) {
            // 获取商品信息
            List<GoodsVO> goodsInfo = goodsClient.getGoodsInfo(goodsIdList);
            if (CollectionsUtil.isEmpty(goodsInfo)) {
                throw new CommonException(ResultCode.DATA_NOT_EXIST, "商品");
            }
            Map<Long, GoodsVO> map = goodsInfo.stream().collect(Collectors.toMap(GoodsVO::getId, item -> item));
            UserInfoVO user = UserUtil.getUser();
            for (Long goodsId : goodsIdList) {

                GoodsVO goodsVO = map.get(goodsId);
                if (goodsVO != null) {
                    // 查询是否已经收藏
                    GoodsCollect goodsCollectLast = getGoodsCollect(goodsId, user.getUniqueUserId());
                    if (goodsCollectLast == null) {
                        GoodsCollect goodsCollect = new GoodsCollect();
                        goodsCollect.setGoodsId(goodsId);
                        goodsCollect.setShopId(goodsVO.getShopId());
                        goodsCollect.setGoodsPrice(goodsVO.getListPrice());
                        goodsCollect.setUniqueUserId(user.getUniqueUserId());
                        goodsCollectBizMapper.insertSelective(goodsCollect);
                    } else {
                        log.warn("创建商品收藏时，用户{}商品{}已收藏", user.getUniqueUserId(), goodsId);
                    }
                } else {
                    log.warn("创建商品收藏时，商品{}未查询到", goodsId);
                }
            }
        }

    }

    /**
     * 根据商品id查询是否收藏
     *
     * @param goodsId
     * @return
     */
    @Transactional(readOnly = true)
    public GoodsCollect getGoodsCollect(Long goodsId, String uniqueUserId) {
        GoodsCollectExample example = new GoodsCollectExample();
        example.createCriteria().andIsDeletedEqualTo(false).andUniqueUserIdEqualTo(uniqueUserId).andGoodsIdEqualTo(goodsId);
        List<GoodsCollect> goodsCollectList = goodsCollectBizMapper.selectByExample(example);
        if (CollectionsUtil.isNotEmpty(goodsCollectList)) {
            return goodsCollectList.get(0);
        }
        return null;
    }

    @Transactional(readOnly = true)
    public GoodsCollect getBaseGoodsCollect(Long id) {
        GoodsCollect goodsCollect = goodsCollectBizMapper.selectByPrimaryKey(id);
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
        QueryResultVO<GoodsCollect> queryResult = new QueryResultVO<GoodsCollect>();
        // 使用分页插件PageHelper实现分页功能
        PageHelper.startPage(goodsCollectQuery.getPageNo(), goodsCollectQuery.getPageSize());
        List<GoodsCollect> goodsCollectList = goodsCollectBizMapper.getUserGoodsCollects(user.getUniqueUserId());
        PageInfo<GoodsCollect> pageInfo = new PageInfo<GoodsCollect>(goodsCollectList);
        queryResult.setPageNo(pageInfo.getPageNum());
        queryResult.setPageSize(pageInfo.getPageSize());
        queryResult.setTotalPages(pageInfo.getPages());
        queryResult.setTotalRecords(pageInfo.getTotal());
        queryResult.setRecords(goodsCollectList);
        return queryResult;
    }

    /**
     * 查询收藏商品数
     *
     * @return
     */
    public int getNumber() {
        GoodsCollectExample example = new GoodsCollectExample();
        example.createCriteria().andIsDeletedEqualTo(false).andUniqueUserIdEqualTo(UserUtil.getUser().getUniqueUserId());
        List<GoodsCollect> goodsCollectList = goodsCollectBizMapper.selectByExample(example);
        if (CollectionsUtil.isNotEmpty(goodsCollectList)) {
            return goodsCollectList.size();
        }
        return 0;
    }

}