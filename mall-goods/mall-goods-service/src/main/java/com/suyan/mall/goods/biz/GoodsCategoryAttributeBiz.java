package com.suyan.mall.goods.biz;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.suyan.exception.CommonException;
import com.suyan.mall.goods.dao.biz.GoodsCategoryAttributeBizMapper;
import com.suyan.mall.goods.model.GoodsCategoryAttribute;
import com.suyan.mall.goods.model.GoodsCategoryAttributeExample;
import com.suyan.mall.goods.req.GoodsCategoryAttributeQueryDTO;
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
 * @Comments: <业务层商品类目属性管理类>
 */
@Slf4j
@Service
public class GoodsCategoryAttributeBiz {

    @Autowired
    private GoodsCategoryAttributeBizMapper goodsCategoryAttributeBizMapper;

    /**
     * 删除商品类目属性
     *
     * @param id
     * @return
     */
    public Integer deleteGoodsCategoryAttribute(Long id) {
        getBaseGoodsCategoryAttribute(id);
        return goodsCategoryAttributeBizMapper.logicalDeleteByPrimaryKey(id);
    }

    /**
     * 创建商品类目属性
     *
     * @param goodsCategoryAttribute
     * @return
     */
    public Long createGoodsCategoryAttribute(GoodsCategoryAttribute goodsCategoryAttribute) {
        // TODO: Describe business logic and implement it
        goodsCategoryAttributeBizMapper.insertSelective(goodsCategoryAttribute);
        return goodsCategoryAttribute.getId();
    }

    /**
     * 批量创建
     *
     * @param goodsCategoryAttributeList
     * @return
     */
    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, rollbackFor = Exception.class)
    public int batchCreateGoodsCategoryAttribute(List<GoodsCategoryAttribute> goodsCategoryAttributeList) {
        // TODO: Describe business logic and implement it
        return goodsCategoryAttributeBizMapper.insertBatch(goodsCategoryAttributeList);
    }

    /**
     * 更新商品类目属性
     *
     * @param goodsCategoryAttribute
     * @return
     */
    public Integer updateGoodsCategoryAttribute(GoodsCategoryAttribute goodsCategoryAttribute) {
        return goodsCategoryAttributeBizMapper.updateByPrimaryKeySelective(goodsCategoryAttribute);
    }

    /**
     * 根据ID获取商品类目属性信息
     *
     * @param id
     * @return
     */
    public GoodsCategoryAttribute getGoodsCategoryAttribute(Long id) {
        return getBaseGoodsCategoryAttribute(id);
    }

    public GoodsCategoryAttribute getBaseGoodsCategoryAttribute(Long id) {
        GoodsCategoryAttribute goodsCategoryAttribute = goodsCategoryAttributeBizMapper.selectByPrimaryKey(id);
        if (goodsCategoryAttribute == null || goodsCategoryAttribute.getIsDeleted()) {
            throw new CommonException(ResultCode.DATA_NOT_EXIST, "商品类目属性");
        }
        return goodsCategoryAttribute;
    }

    /**
     * 分页查询商品类目属性信息
     *
     * @param goodsCategoryAttributeQuery
     * @return
     */
    public QueryResultVO<GoodsCategoryAttribute> queryGoodsCategoryAttribute(GoodsCategoryAttributeQueryDTO goodsCategoryAttributeQuery) {
        QueryResultVO<GoodsCategoryAttribute> queryResult = new QueryResultVO<GoodsCategoryAttribute>();
        // 使用分页插件PageHelper实现分页功能
        PageHelper.startPage(goodsCategoryAttributeQuery.getPageNo(), goodsCategoryAttributeQuery.getPageSize());
        List<GoodsCategoryAttribute> goodsCategoryAttributeList = goodsCategoryAttributeBizMapper.queryGoodsCategoryAttribute(goodsCategoryAttributeQuery);
        PageInfo<GoodsCategoryAttribute> pageInfo = new PageInfo<GoodsCategoryAttribute>(goodsCategoryAttributeList);
        queryResult.setPageNo(pageInfo.getPageNum());
        queryResult.setPageSize(pageInfo.getPageSize());
        queryResult.setTotalPages(pageInfo.getPages());
        queryResult.setTotalRecords(pageInfo.getTotal());
        queryResult.setRecords(goodsCategoryAttributeList);
        return queryResult;
    }

    public List<GoodsCategoryAttribute> getByCategoryId(Integer categoryId) {
        GoodsCategoryAttributeExample example = new GoodsCategoryAttributeExample();
        example.createCriteria().andIsDeletedEqualTo(false).andCategoryIdEqualTo(categoryId);
        example.setOrderByClause("sort_number, id");
        return goodsCategoryAttributeBizMapper.selectByExample(example);
    }

    /**
     * 根据商品类目获取最大排序值
     *
     * @param categoryId
     * @return
     */
    public int getMaxSortNumberByCategoryId(Integer categoryId) {
        return goodsCategoryAttributeBizMapper.getMaxSortNumberByCategoryId(categoryId);
    }

    public List<GoodsCategoryAttribute> getTreeByCategoryId(Integer categoryId) {
        return goodsCategoryAttributeBizMapper.getTreeByCategoryId(categoryId);
    }
}