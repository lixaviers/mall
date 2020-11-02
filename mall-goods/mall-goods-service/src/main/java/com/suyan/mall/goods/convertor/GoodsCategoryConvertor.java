/*
 * Copyright (c) 2020.
 * 项目名称：素焉商城
 * 创建人：素焉
 * 开源地址: https://github.com/lixaviers/mall
 */
package com.suyan.mall.goods.convertor;

import com.google.common.collect.Lists;
import com.suyan.mall.goods.model.GoodsCategory;
import com.suyan.mall.goods.req.GoodsCategoryDTO;
import com.suyan.mall.goods.resp.GoodsCategoryVO;
import com.suyan.query.QueryResultVO;
import com.suyan.utils.CollectionsUtil;
import org.springframework.cglib.beans.BeanCopier;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * @CopyRright (c): <素焉代码生成工具>
 * @Comments: <对象相互转换>
 * @jdk 1.8
 * @Version: <1.0>
 */
public abstract class GoodsCategoryConvertor {

    private static final BeanCopier beanCopierForGoodsCategoryVO = BeanCopier.create(GoodsCategory.class, GoodsCategoryVO.class, false);
    private static final BeanCopier beanCopierForGoodsCategory = BeanCopier.create(GoodsCategoryDTO.class, GoodsCategory.class, false);

    public static GoodsCategoryVO toGoodsCategoryVO(GoodsCategory goodsCategory) {
        if (goodsCategory == null) {
            return null;
        }
        GoodsCategoryVO goodsCategoryVO = new GoodsCategoryVO();
        beanCopierForGoodsCategoryVO.copy(goodsCategory, goodsCategoryVO, null);
        return goodsCategoryVO;
    }

    public static GoodsCategory toGoodsCategory(GoodsCategoryDTO goodsCategoryDTO) {
        GoodsCategory goodsCategory = new GoodsCategory();
        beanCopierForGoodsCategory.copy(goodsCategoryDTO, goodsCategory, null);
        return goodsCategory;
    }

    public static List<GoodsCategoryVO> toGoodsCategoryVOList(List<GoodsCategory> goodsCategoryList) {
        if (goodsCategoryList == null || goodsCategoryList.isEmpty()) {
            return null;
        }
        List<GoodsCategoryVO> goodsCategoryInfoList = new ArrayList<GoodsCategoryVO>(goodsCategoryList.size());
        for (GoodsCategory goodsCategory : goodsCategoryList) {
            goodsCategoryInfoList.add(toGoodsCategoryVO(goodsCategory));
        }
        return goodsCategoryInfoList;
    }

    public static List<GoodsCategory> toGoodsCategoryList(List<GoodsCategoryDTO> goodsCategoryDTOList) {
        if (goodsCategoryDTOList == null || goodsCategoryDTOList.isEmpty()) {
            return null;
        }
        List<GoodsCategory> goodsCategoryList = new ArrayList<GoodsCategory>(goodsCategoryDTOList.size());
        for (GoodsCategoryDTO goodsCategoryDTO : goodsCategoryDTOList) {
            goodsCategoryList.add(toGoodsCategory(goodsCategoryDTO));
        }
        return goodsCategoryList;
    }

    public static QueryResultVO<GoodsCategoryVO> toQueryResult(QueryResultVO<GoodsCategory> queryResult) {
        QueryResultVO<GoodsCategoryVO> queryResultInfo = new QueryResultVO<GoodsCategoryVO>();
        queryResultInfo.setPageNo(queryResult.getPageNo());
        queryResultInfo.setPageSize(queryResult.getPageSize());
        queryResultInfo.setTotalPages(queryResult.getTotalPages());
        queryResultInfo.setTotalRecords(queryResult.getTotalRecords());
        queryResultInfo.setRecords(toGoodsCategoryVOList(queryResult.getRecords()));
        return queryResultInfo;
    }


    public static List<GoodsCategoryVO> toTree(List<GoodsCategory> categoryList) {
        if (CollectionsUtil.isNotEmpty(categoryList)) {
            // 顶级类目
            List<GoodsCategoryVO> topCategoryList = toGoodsCategoryVOList(categoryList.stream().filter(bean -> bean.getParentId().equals(0)).collect(Collectors.toList()));
            List<GoodsCategoryVO> childCategoryList = toGoodsCategoryVOList(categoryList.stream().filter(bean -> !bean.getParentId().equals(0)).collect(Collectors.toList()));
            sort(topCategoryList, childCategoryList);

            return topCategoryList;
        }
        return null;
    }


    private static void sort(List<GoodsCategoryVO> topCategoryList, List<GoodsCategoryVO> childCategoryList) {
        List<GoodsCategoryVO> copyVos = Lists.newCopyOnWriteArrayList(childCategoryList);
        for (GoodsCategoryVO top : topCategoryList) {
            for (GoodsCategoryVO child : childCategoryList) {
                if (Objects.equals(top.getId(), child.getParentId())) {
                    top.addChildCategoryList(child);
                    copyVos.remove(child);
                }
            }
        }
        for (GoodsCategoryVO top : topCategoryList) {
            if (CollectionsUtil.isNotEmpty(top.getChildCategoryList())) {
                sort(top.getChildCategoryList(), copyVos);
            }
        }
    }


}