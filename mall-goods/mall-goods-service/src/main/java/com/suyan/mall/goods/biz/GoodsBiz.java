/*
 * Copyright (c) 2020.
 * 项目名称：素焉商城
 * 创建人：素焉
 * 开源地址: https://github.com/lixaviers/mall
 */
package com.suyan.mall.goods.biz;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.suyan.exception.CommonException;
import com.suyan.mall.goods.convertor.GoodsBrandConvertor;
import com.suyan.mall.goods.convertor.GoodsConvertor;
import com.suyan.mall.goods.dao.biz.GoodsBizMapper;
import com.suyan.mall.goods.enums.GoodsStatusEnum;
import com.suyan.mall.goods.es.model.GoodsES;
import com.suyan.mall.goods.es.repository.GoodsRepository;
import com.suyan.mall.goods.model.Goods;
import com.suyan.mall.goods.model.GoodsExample;
import com.suyan.mall.goods.model.GoodsSku;
import com.suyan.mall.goods.req.GoodsQueryDTO;
import com.suyan.mall.goods.req.GoodsSearchDTO;
import com.suyan.mall.goods.resp.GoodsBrandVO;
import com.suyan.mall.goods.resp.GoodsSearchVO;
import com.suyan.mall.user.resp.b.UserInfoVO;
import com.suyan.mall.user.utils.UserUtil;
import com.suyan.query.QueryResultVO;
import com.suyan.result.ResultCode;
import com.suyan.utils.JsonUtil;
import com.suyan.utils.StringUtils;
import lombok.extern.slf4j.Slf4j;
import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.aggregations.AggregationBuilders;
import org.elasticsearch.search.aggregations.bucket.terms.LongTerms;
import org.elasticsearch.search.sort.SortBuilders;
import org.elasticsearch.search.sort.SortOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.elasticsearch.core.aggregation.AggregatedPage;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.*;

/**
 * @CopyRright (c): <素焉代码生成工具>
 * @Comments: <业务层商品管理类>
 * @jdk 1.8
 * @Version: <1.0>
 */
@Slf4j
@Service
public class GoodsBiz {

    @Autowired
    private GoodsBizMapper goodsBizMapper;

    @Autowired
    private GoodsSkuBiz goodsSkuBiz;
    @Autowired
    private GoodsDescriptionBiz goodsDescriptionBiz;
    @Autowired
    private GoodsBrandBiz goodsBrandBiz;

    @Autowired
    private GoodsRepository goodsRepository;


    /**
     * 创建商品
     *
     * @param goods
     * @return
     */
    public Long createGoods(Goods goods) {
        // 处理信息
        dealInfo(goods);

        goods.setGoodsStatus(GoodsStatusEnum.NORMAL.getValue());
        // 商品分类
        goodsBizMapper.insertSelective(goods);
        return goods.getId();
    }

    private void dealInfo(Goods goods) {
        // 商品最低价格设为列表价
        BigDecimal minPirce = goods.getSkuList().get(0).getPrice();
        // 总库存
        int totalInventory = 0;

        for (GoodsSku goodsSku : goods.getSkuList()) {
            goodsSku.setGoodsId(goods.getId());
            goodsSku.setGoodsName(goods.getGoodsName());
            goodsSku.setGoodsPicture(goods.getPictureUrls().split(",")[0]);
            goodsSku.setShopId(goods.getShopId());
            goodsSku.setSales(0);
            goodsSku.setCommonStatus(GoodsStatusEnum.NORMAL.getValue());
            totalInventory += goodsSku.getInventory();
            if (goodsSku.getPrice().compareTo(minPirce) < 0) {
                minPirce = goodsSku.getPrice();
            }
        }

        if (goods.getIsMoreSpec()) {
            // 多规格
            goods.setSpecValue(JsonUtil.toJsonString(goods.getGoodsSpecificationList()));
        } else {
            // 单规格
            goods.setSpecValue("");
        }
        goods.setInventory(totalInventory);
        goods.setSales(0);
        goods.setListPrice(minPirce);
    }


    /**
     * 更新商品
     *
     * @param goods
     * @return
     */
    public Goods updateGoods(Goods goods) {
        // 查询商品
        Goods goodsLast = getBaseGoods(goods.getId());
        if (!goodsLast.getShopId().equals(goods.getShopId())) {
            // 非本店铺商品
            throw new CommonException(ResultCode.NO_PERMISSION_OPERATE, "此商品");
        }
        // 处理信息
        dealInfo(goods);

        goodsBizMapper.updateByPrimaryKeySelective(goods);
        return goodsLast;
    }

    /**
     * 删除商品
     *
     * @param id
     * @return
     */
    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, rollbackFor = Exception.class)
    public Integer deleteGoods(Long id) {
        getBaseGoods(id);
        return goodsBizMapper.deleteByPrimaryKey(id);
    }

    /**
     * 根据ID获取商品信息
     *
     * @param id
     * @return
     */
    @Transactional(readOnly = true)
    public Goods getGoodsForC(Long id) {
        Goods goods = getBaseGoods(id);
        // 商品详情
        goods.setDescription(goodsDescriptionBiz.getGoodsDescription(id));
        // 商品sku
        List<GoodsSku> skuList = goodsSkuBiz.getGoodsSku(id);
        goods.setSkuList(skuList);
        return goods;
    }

    public Goods getGoods(Long id) {
        UserInfoVO shopUser = UserUtil.getShopUser();
        Goods goods = getBaseGoods(id);
        if (!goods.getShopId().equals(shopUser.getShopId())) {
            // 非本店铺商品不能查看
            throw new CommonException(ResultCode.DATA_NOT_EXIST, "商品");
        }
        return goods;
    }

    @Transactional(readOnly = true)
    public Goods getBaseGoods(Long id) {
        Goods goods = goodsBizMapper.selectByPrimaryKey(id);
        if (goods == null || goods.getIsDeleted()) {
            throw new CommonException(ResultCode.DATA_NOT_EXIST, "商品");
        }
        return goods;
    }

    /**
     * 分页查询商品信息
     *
     * @param goodsQuery
     * @return
     */
    @Transactional(readOnly = true)
    public QueryResultVO<Goods> queryGoods(GoodsQueryDTO goodsQuery) {
        QueryResultVO<Goods> queryResult = new QueryResultVO<Goods>();
        // 使用分页插件PageHelper实现分页功能
        PageHelper.startPage(goodsQuery.getPageNo(), goodsQuery.getPageSize());
        List<Goods> goodsList = goodsBizMapper.queryGoods(goodsQuery);
        PageInfo<Goods> pageInfo = new PageInfo<Goods>(goodsList);
        queryResult.setPageNo(pageInfo.getPageNum());
        queryResult.setPageSize(pageInfo.getPageSize());
        queryResult.setTotalPages(pageInfo.getPages());
        queryResult.setTotalRecords(pageInfo.getTotal());
        queryResult.setRecords(goodsList);
        return queryResult;
    }

    /**
     * 商品上下架
     *
     * @param goods
     */
    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, rollbackFor = Exception.class)
    public void shelves(Goods goods) {
        UserInfoVO shopUser = UserUtil.getShopUser();
        Goods goodsLast = getBaseGoods(goods.getId());
        if (!goodsLast.getShopId().equals(shopUser.getShopId())) {
            // 非本店铺商品不能编辑
            throw new CommonException(ResultCode.DATA_NOT_EXIST, "商品");
        }
        goodsBizMapper.updateByPrimaryKeySelective(goods);
        goodsSkuBiz.updateStatus(goods.getId(), goods.getGoodsStatus());
    }

    /**
     * 商品搜索
     *
     * @param goodsSearchDTO
     * @return
     */
    public Map<String, Object> search(GoodsSearchDTO goodsSearchDTO) {
        Map<String, Object> map = new HashMap<>();
        QueryResultVO<GoodsSearchVO> queryResult = new QueryResultVO<GoodsSearchVO>();
        // 构造查询条件
        NativeSearchQueryBuilder queryBuilder = new NativeSearchQueryBuilder();
        queryBuilder.withQuery(getFilterQueryBuilder(goodsSearchDTO));
        // 排序条件
        queryBuilder.withSort(SortBuilders.fieldSort("id").order(SortOrder.ASC));
        // 分页条件
        queryBuilder.withPageable(PageRequest.of(goodsSearchDTO.getPageNo() - 1, goodsSearchDTO.getPageSize()));
        // 根据品牌id聚合,得到每个品牌在页面的过滤栏的信息
        queryBuilder.addAggregation(AggregationBuilders.terms("brandIds").field("brandId"));
        AggregatedPage<GoodsES> search = (AggregatedPage<GoodsES>) goodsRepository.search(queryBuilder.build());

        queryResult.setPageNo(goodsSearchDTO.getPageNo());
        queryResult.setPageSize(goodsSearchDTO.getPageSize());
        if (!Objects.isNull(search)) {
            queryResult.setTotalPages(search.getTotalPages());
            queryResult.setTotalRecords(search.getTotalElements());
            queryResult.setRecords(GoodsConvertor.toGoodsSearchVOList(search.getContent()));
            map.put("brands", getBrandAggResult(search));
        }
        map.put("goods", queryResult);
        return map;
    }

    private List<GoodsBrandVO> getBrandAggResult(AggregatedPage<GoodsES> search) {
        //取得搜索结果集page中aggCname字段的聚合结果
        LongTerms aggBrand = (LongTerms) search.getAggregation("brandIds");
        List<Integer> brandIdList = new ArrayList<>();
        for (LongTerms.Bucket bucket : aggBrand.getBuckets()) {
            brandIdList.add(bucket.getKeyAsNumber().intValue());
        }
        // 查询品牌详情
        return GoodsBrandConvertor.toGoodsBrandVOList(goodsBrandBiz.getGoodsBrandByIdList(brandIdList));
    }

    /**
     * 构建查询条件
     *
     * @param goodsSearchDTO
     * @return
     */
    private QueryBuilder getFilterQueryBuilder(GoodsSearchDTO goodsSearchDTO) {
        BoolQueryBuilder queryBuilder = QueryBuilders.boolQuery();
        // 添加must的条件 此处为匹配Goods中的all字段
        queryBuilder.must(QueryBuilders.matchAllQuery());

        if (goodsSearchDTO.getShopId() != null) {
            queryBuilder.must(QueryBuilders.termQuery("shopId", goodsSearchDTO.getShopId()));
        }
        if (goodsSearchDTO.getBrandId() != null) {
            queryBuilder.must(QueryBuilders.termQuery("brandId", goodsSearchDTO.getBrandId()));
        }
        if (StringUtils.isNotBlank(goodsSearchDTO.getKeyword())) {
            queryBuilder.must(QueryBuilders.multiMatchQuery(goodsSearchDTO.getKeyword().trim(), "brandName", "goodsForegroundCategoryNameStr", "goodsName"));
        }
        return queryBuilder;
    }

    @Transactional(readOnly = true)
    public List<Goods> getGoodsInfo(List<Long> idList) {
        GoodsExample example = new GoodsExample();
        example.createCriteria().andIsDeletedEqualTo(false).andIdIn(idList);
        return goodsBizMapper.selectByExample(example);
    }

    @Transactional(readOnly = true)
    public List<Goods> getByGoodsClassId(Long goodsClassId) {
        return goodsBizMapper.selectByGoodsClassId(goodsClassId);
    }

}