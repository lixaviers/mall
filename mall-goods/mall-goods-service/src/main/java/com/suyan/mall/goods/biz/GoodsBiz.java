package com.suyan.mall.goods.biz;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.suyan.exception.CommonException;
import com.suyan.mall.goods.constants.Constant;
import com.suyan.mall.goods.dao.GoodsMapper;
import com.suyan.mall.goods.enums.GoodsStatusEnum;
import com.suyan.mall.goods.model.Goods;
import com.suyan.mall.goods.model.GoodsDescription;
import com.suyan.mall.goods.model.GoodsSku;
import com.suyan.mall.goods.req.GoodsQueryDTO;
import com.suyan.mall.user.resp.b.UserInfoVO;
import com.suyan.mall.user.utils.UserUtil;
import com.suyan.query.QueryResultVO;
import com.suyan.result.ResultCode;
import com.suyan.utils.CollectionsUtil;
import com.suyan.utils.JsonUtil;
import com.suyan.utils.StringUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

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
    private GoodsMapper goodsMapper;

    @Autowired
    private GoodsSkuBiz goodsSkuBiz;
    @Autowired
    private GoodsDescriptionBiz goodsDescriptionBiz;


    /**
     * 创建商品
     *
     * @param goods
     * @return
     */
    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, rollbackFor = Exception.class)
    public Long createGoods(Goods goods) {
        // 处理信息
        dealInfo(goods);

        goodsMapper.insertSelective(goods);

        goods.getSkuList().forEach(sku -> {
            sku.setGoodsId(goods.getId());
        });
        goodsSkuBiz.batchCreateGoodsSku(goods.getSkuList());

        // 添加商品描述
        GoodsDescription goodsDescription = new GoodsDescription();
        goodsDescription.setGoodsId(goods.getId());
        goodsDescription.setDescription(goods.getDescription());
        goodsDescriptionBiz.createGoodsDescription(goodsDescription);

        return goods.getId();
    }

    private void dealInfo(Goods goods) {
        // 商品最低价格设为列表价
        BigDecimal minPirce = goods.getSkuList().get(0).getPrice();
        // 总库存
        int totalInventory = 0;
        // 当前的sku编码
        Long skuCode = null;
        String maxSkuCode = goodsSkuBiz.getMaxSkuCode();
        if (StringUtils.isEmpty(maxSkuCode)) {
            skuCode = Constant.MIN_SKU_CODE;
        } else {
            skuCode = new Long(maxSkuCode) + 1;
        }
        for (GoodsSku goodsSku : goods.getSkuList()) {
            goodsSku.setGoodsId(goods.getId());
            goodsSku.setShopId(goods.getShopId());
            goodsSku.setSales(0);
            goodsSku.setCommonStatus(GoodsStatusEnum.NORMAL.getValue());
            totalInventory += goodsSku.getInventory();
            if (goodsSku.getPrice().compareTo(minPirce) < 0) {
                minPirce = goodsSku.getPrice();
            }
            if (goodsSku.getId() == null) {
                goodsSku.setSkuCode(String.valueOf(skuCode));
                skuCode++;
            }
        }

        if (goods.getIsMoreSpec()) {
            // 多规格
            goods.setSpecValue(JsonUtil.toJsonString(goods.getGoodsSpecificationList()));
        } else {
            // 单规格
            goods.setSpecValue("");
        }
        goods.setGoodsStatus(GoodsStatusEnum.NORMAL.getValue());
        goods.setSales(0);
        goods.setInventory(totalInventory);
        goods.setListPrice(minPirce);
    }


    /**
     * 更新商品
     *
     * @param goods
     * @return
     */
    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, rollbackFor = Exception.class)
    public Integer updateGoods(Goods goods) {
        // 查询商品
        Goods goodsLast = getBaseGoods(goods.getId());
        if (!goodsLast.getShopId().equals(goods.getShopId())) {
            // 非本店铺商品
            throw new CommonException(ResultCode.NO_PERMISSION_OPERATE, "此商品");
        }

        // 添加的sku列表
        List<GoodsSku> addSkuList = null;
        // 编辑的sku列表
        List<GoodsSku> updateSkuList = null;
        // 删除的sku id列表
        List<Long> deletedSkuIdList = null;

        // 查询sku
        List<GoodsSku> oldSkuList = goodsSkuBiz.getGoodsSku(goods.getId());
        List<Long> oldSkuIdList = oldSkuList.stream().map(GoodsSku::getId).collect(Collectors.toList());
        // 编辑后的sku
        List<GoodsSku> newSkuList = goods.getSkuList();
        if (goodsLast.getIsMoreSpec()) {

            if (goods.getIsMoreSpec()) {
                // 之前多规格，编辑还是多规格

                // 获取传入sku列表 id不为空 的列表
                List<GoodsSku> updateList = newSkuList.stream().filter(item -> item.getId() != null).collect(Collectors.toList());
                // 获取传入sku列表 id为空 的列表
                addSkuList = newSkuList.stream().filter(item -> item.getId() == null).collect(Collectors.toList());
                // 前端的参数不可信，需要重新过滤下
                List<GoodsSku> filterAddList = updateList.stream().filter(item -> !oldSkuIdList.contains(item.getId())).collect(Collectors.toList());
                updateSkuList = updateList.stream().filter(item -> oldSkuIdList.contains(item.getId())).collect(Collectors.toList());
                if (CollectionsUtil.isNotEmpty(filterAddList)) {
                    if (CollectionsUtil.isNotEmpty(addSkuList)) {
                        addSkuList.addAll(filterAddList);
                    } else {
                        addSkuList = filterAddList;
                    }
                }

                if (CollectionsUtil.isEmpty(updateSkuList)) {
                    // 编辑商品的为空，删除之前所有的sku
                    deletedSkuIdList = oldSkuIdList;
                } else {
                    List<Long> updateSkuIdList = updateSkuList.stream().map(GoodsSku::getId).collect(Collectors.toList());
                    deletedSkuIdList = oldSkuIdList.stream().filter(id -> !updateSkuIdList.contains(id)).collect(Collectors.toList());
                }
            } else {
                // 之前多规格，编辑为单规格
                deletedSkuIdList = oldSkuIdList;
                addSkuList = newSkuList;
            }
        } else {
            if (goods.getIsMoreSpec()) {
                // 之前单规格，编辑为多规格
                deletedSkuIdList = oldSkuIdList;
                addSkuList = newSkuList;
            } else {
                // 之前单规格，编辑为单规格
                GoodsSku goodsSku = newSkuList.get(0);
                goodsSku.setId(oldSkuIdList.get(0));
                addSkuList = Arrays.asList(goodsSku);
            }

        }

        List<GoodsSku> skuList = new ArrayList<>();
        if (CollectionsUtil.isNotEmpty(addSkuList)) {
            skuList.addAll(skuList);
            goodsSkuBiz.batchCreateGoodsSku(addSkuList);
        }
        if (CollectionsUtil.isNotEmpty(updateSkuList)) {
            skuList.addAll(updateSkuList);
            goodsSkuBiz.batchUpdate(updateSkuList);
        }
        // 删除sku
        goodsSkuBiz.deleteGoodsSku(deletedSkuIdList);
        goods.setSkuList(skuList);
        // 处理信息
        dealInfo(goods);

        // 编辑商品详情
        GoodsDescription goodsDescription = new GoodsDescription();
        goodsDescription.setGoodsId(goods.getId());
        goodsDescription.setDescription(goods.getDescription());
        goodsDescriptionBiz.updateGoodsDescription(goodsDescription);

        return goodsMapper.updateByPrimaryKeySelective(goods);
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
        return goodsMapper.deleteByPrimaryKey(id);
    }

    /**
     * 根据ID获取商品信息
     *
     * @param id
     * @return
     */
    @Transactional(readOnly = true)
    public Goods getGoods(Long id) {
        UserInfoVO shopUser = UserUtil.getShopUser();
        Goods goods = getBaseGoods(id);
        if (!goods.getShopId().equals(shopUser.getShopId())) {
            // 非本店铺商品不能查看
            throw new CommonException(ResultCode.DATA_NOT_EXIST, "商品");
        }
        // 商品详情
        goods.setDescription(goodsDescriptionBiz.getGoodsDescription(id));
        // 商品sku
        List<GoodsSku> skuList = goodsSkuBiz.getGoodsSku(id);
        goods.setSkuList(skuList);
        return goods;
    }

    @Transactional(readOnly = true)
    public Goods getBaseGoods(Long id) {
        Goods goods = goodsMapper.selectByPrimaryKey(id);
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
        List<Goods> goodsList = goodsMapper.queryGoods(goodsQuery);
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
        goodsMapper.updateByPrimaryKeySelective(goods);
    }
}