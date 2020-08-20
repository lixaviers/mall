package com.suyan.mall.goods.biz;

import lombok.extern.slf4j.Slf4j;
import com.suyan.mall.goods.dao.GoodsCategoryRelationMapper;
import com.suyan.mall.goods.model.GoodsCategoryRelation;
import com.suyan.mall.goods.req.GoodsCategoryRelationQueryDTO;
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
 * @Comments: <业务层商品类目关联管理类>
 */
@Slf4j
@Service
public class GoodsCategoryRelationBiz {

    @Autowired
    private GoodsCategoryRelationMapper goodsCategoryRelationMapper;

    /**
     * 删除商品类目关联
     *
     * @param id
     * @return
     */
    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, rollbackFor = Exception.class)
    public Integer deleteGoodsCategoryRelation(Long id) {
        // TODO: Describe business logic and implement it
        getBaseGoodsCategoryRelation(id);
        return goodsCategoryRelationMapper.deleteByPrimaryKey(id);
    }

    /**
     * 创建商品类目关联
     * 
     * @param goodsCategoryRelation
     * @return
     */
    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, rollbackFor = Exception.class)
    public Long createGoodsCategoryRelation(GoodsCategoryRelation goodsCategoryRelation) {
        // TODO: Describe business logic and implement it
        goodsCategoryRelationMapper.insertSelective( goodsCategoryRelation );
        return goodsCategoryRelation.getId();
    }

    /**
    * 批量创建
    *
    * @param goodsCategoryRelationList
    * @return
    */
    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, rollbackFor = Exception.class)
    public int batchCreateGoodsCategoryRelation(List<GoodsCategoryRelation> goodsCategoryRelationList) {
        // TODO: Describe business logic and implement it
        return goodsCategoryRelationMapper.insertBatch( goodsCategoryRelationList );
    }

    /**
     * 更新商品类目关联
     * 
     * @param goodsCategoryRelation
     * @return
     */
    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, rollbackFor = Exception.class)
    public Integer updateGoodsCategoryRelation(GoodsCategoryRelation goodsCategoryRelation) {
        getBaseGoodsCategoryRelation(goodsCategoryRelation.getId());
        return goodsCategoryRelationMapper.updateByPrimaryKeySelective(goodsCategoryRelation);
    }
    
    /**
     * 根据ID获取商品类目关联信息
     * 
     * @param id
     * @return
     */
    @Transactional(readOnly = true)
    public GoodsCategoryRelation getGoodsCategoryRelation(Long id) {
        return getBaseGoodsCategoryRelation(id);
    }

    @Transactional(readOnly = true)
    public GoodsCategoryRelation getBaseGoodsCategoryRelation(Long id) {
        GoodsCategoryRelation goodsCategoryRelation = goodsCategoryRelationMapper.selectByPrimaryKey(id);
        if(goodsCategoryRelation == null) {
            throw new CommonException(ResultCode.DATA_NOT_EXIST, "商品类目关联");
        }
        return goodsCategoryRelation;
    }

    /**
     * 分页查询商品类目关联信息
     * 
     * @param goodsCategoryRelationQuery
     * @return
     */
    @Transactional(readOnly = true)
    public QueryResultVO<GoodsCategoryRelation> queryGoodsCategoryRelation(GoodsCategoryRelationQueryDTO goodsCategoryRelationQuery) {
        QueryResultVO<GoodsCategoryRelation> queryResult = new QueryResultVO<GoodsCategoryRelation>();
        // 使用分页插件PageHelper实现分页功能
        PageHelper.startPage(goodsCategoryRelationQuery.getPageNo(), goodsCategoryRelationQuery.getPageSize());
        List<GoodsCategoryRelation> goodsCategoryRelationList = goodsCategoryRelationMapper.queryGoodsCategoryRelation(goodsCategoryRelationQuery);
        PageInfo<GoodsCategoryRelation> pageInfo = new PageInfo<GoodsCategoryRelation>(goodsCategoryRelationList);
        queryResult.setPageNo(pageInfo.getPageNum());
        queryResult.setPageSize(pageInfo.getPageSize());
        queryResult.setTotalPages(pageInfo.getPages());
        queryResult.setTotalRecords(pageInfo.getTotal());
        queryResult.setRecords(goodsCategoryRelationList);
        return queryResult;
    }

}