package com.suyan.mall.goods.biz;

import lombok.extern.slf4j.Slf4j;
import com.suyan.mall.goods.dao.GoodsCategoryAttributeMapper;
import com.suyan.mall.goods.model.GoodsCategoryAttribute;
import com.suyan.mall.goods.req.GoodsCategoryAttributeQueryDTO;
import com.suyan.exception.CommonException;
import com.suyan.query.QueryResultVO;
import com.suyan.result.ResultCode;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

/**
 * @CopyRright (c): <素焉代码生成工具>
 * @Comments: <业务层商品类目属性管理类>
 */
@Slf4j
@Service
public class GoodsCategoryAttributeBiz {

    @Autowired
    private GoodsCategoryAttributeMapper goodsCategoryAttributeMapper;

    /**
     * 删除商品类目属性
     *
     * @param id
     * @return
     */
    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, rollbackFor = Exception.class)
    public Integer deleteGoodsCategoryAttribute(Long id) {
        // TODO: Describe business logic and implement it
        getBaseGoodsCategoryAttribute(id);
        return goodsCategoryAttributeMapper.logicalDeleteByPrimaryKey(id);
    }

    /**
     * 创建商品类目属性
     * 
     * @param goodsCategoryAttribute
     * @return
     */
    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, rollbackFor = Exception.class)
    public Long createGoodsCategoryAttribute(GoodsCategoryAttribute goodsCategoryAttribute) {
        // TODO: Describe business logic and implement it
        goodsCategoryAttributeMapper.insertSelective( goodsCategoryAttribute );
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
        return goodsCategoryAttributeMapper.insertBatch( goodsCategoryAttributeList );
    }

    /**
     * 更新商品类目属性
     * 
     * @param goodsCategoryAttribute
     * @return
     */
    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, rollbackFor = Exception.class)
    public Integer updateGoodsCategoryAttribute(GoodsCategoryAttribute goodsCategoryAttribute) {
        getBaseGoodsCategoryAttribute(goodsCategoryAttribute.getId());
        return goodsCategoryAttributeMapper.updateByPrimaryKeySelective(goodsCategoryAttribute);
    }
    
    /**
     * 根据ID获取商品类目属性信息
     * 
     * @param id
     * @return
     */
    @Transactional(readOnly = true)
    public GoodsCategoryAttribute getGoodsCategoryAttribute(Long id) {
        return getBaseGoodsCategoryAttribute(id);
    }

    @Transactional(readOnly = true)
    public GoodsCategoryAttribute getBaseGoodsCategoryAttribute(Long id) {
        GoodsCategoryAttribute goodsCategoryAttribute = goodsCategoryAttributeMapper.selectByPrimaryKey(id);
        if(goodsCategoryAttribute == null || goodsCategoryAttribute.getIsDeleted()) {
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
    @Transactional(readOnly = true)
    public QueryResultVO<GoodsCategoryAttribute> queryGoodsCategoryAttribute(GoodsCategoryAttributeQueryDTO goodsCategoryAttributeQuery) {
        QueryResultVO<GoodsCategoryAttribute> queryResult = new QueryResultVO<GoodsCategoryAttribute>();
        // 使用分页插件PageHelper实现分页功能
        PageHelper.startPage(goodsCategoryAttributeQuery.getPageNo(), goodsCategoryAttributeQuery.getPageSize());
        List<GoodsCategoryAttribute> goodsCategoryAttributeList = goodsCategoryAttributeMapper.queryGoodsCategoryAttribute(goodsCategoryAttributeQuery);
        PageInfo<GoodsCategoryAttribute> pageInfo = new PageInfo<GoodsCategoryAttribute>(goodsCategoryAttributeList);
        queryResult.setPageNo(pageInfo.getPageNum());
        queryResult.setPageSize(pageInfo.getPageSize());
        queryResult.setTotalPages(pageInfo.getPages());
        queryResult.setTotalRecords(pageInfo.getTotal());
        queryResult.setRecords(goodsCategoryAttributeList);
        return queryResult;
    }

}