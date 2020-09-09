package com.suyan.mall.user.service.impl;

import com.suyan.mall.goods.resp.GoodsVO;
import com.suyan.mall.user.biz.GoodsCollectBiz;
import com.suyan.mall.user.client.GoodsClient;
import com.suyan.mall.user.convertor.GoodsCollectConvertor;
import com.suyan.mall.user.model.GoodsCollect;
import com.suyan.mall.user.req.GoodsCollectDTO;
import com.suyan.mall.user.req.GoodsCollectQueryDTO;
import com.suyan.mall.user.resp.GoodsCollectVO;
import com.suyan.mall.user.service.IGoodsCollectService;
import com.suyan.mall.user.utils.UserUtil;
import com.suyan.query.QueryResultVO;
import com.suyan.utils.CollectionsUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


/**
 * @CopyRright (c): <素焉代码生成工具>
 * @Comments: <Service 商品收藏管理类>
 */
@Slf4j
@Service("goodsCollectService")
public class GoodsCollectServiceImpl implements IGoodsCollectService {

    @Autowired
    private GoodsCollectBiz goodsCollectBiz;

    @Autowired
    private GoodsClient goodsClient;

    @Override
    public int deleteGoodsCollect(Long id) {
        return goodsCollectBiz.deleteGoodsCollect(id);
    }

    @Override
    public void createGoodsCollect(GoodsCollectDTO goodsCollectDTO) {
        goodsCollectBiz.createGoodsCollect(GoodsCollectConvertor.toGoodsCollect(goodsCollectDTO));
    }

    @Override
    public void batchCreateGoodsCollect(List<Long> goodsIdList) {
        goodsCollectBiz.batchCreateGoodsCollect(goodsIdList);
    }

    @Override
    public QueryResultVO<GoodsCollectVO> queryGoodsCollect(GoodsCollectQueryDTO goodsCollectQueryDTO) {
        QueryResultVO<GoodsCollectVO> queryResult = GoodsCollectConvertor.toQueryResult(goodsCollectBiz.queryGoodsCollect(goodsCollectQueryDTO));
        if (queryResult.getTotalRecords() > 0) {
            List<Long> idList = queryResult.getRecords().stream().map(GoodsCollectVO::getGoodsId).collect(Collectors.toList());
            List<GoodsVO> goodsVOList = goodsClient.getGoodsInfo(idList);
            if (CollectionsUtil.isNotEmpty(goodsVOList)) {
                Map<Long, GoodsVO> map = goodsVOList.stream().collect(Collectors.toMap(GoodsVO::getId, item -> item));
                for (GoodsCollectVO goodsCollectVO : queryResult.getRecords()) {
                    GoodsVO goodsVO = map.get(goodsCollectVO.getGoodsId());
                    if (goodsVO != null) {
                        goodsCollectVO.setIsGoodsFailure(false);
                        goodsCollectVO.setGoodsName(goodsVO.getGoodsName());
                        goodsCollectVO.setGoodsPicture(goodsVO.getPictureUrls().split(",")[0]);
                        goodsCollectVO.setGoodsRealPrice(goodsVO.getListPrice());
                    }
                }
            }
        }
        return queryResult;
    }

    @Override
    public Boolean get(Long goodsId) {
        GoodsCollect goodsCollect = goodsCollectBiz.getGoodsCollect(goodsId, UserUtil.getUser().getUniqueUserId());
        if (goodsCollect == null) {
            return false;
        }
        return true;
    }

    @Override
    public Integer getNumber() {
        return goodsCollectBiz.getNumber();
    }
}