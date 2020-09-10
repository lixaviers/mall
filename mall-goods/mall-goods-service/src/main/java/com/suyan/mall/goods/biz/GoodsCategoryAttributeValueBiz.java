package com.suyan.mall.goods.biz;

import lombok.extern.slf4j.Slf4j;
import com.suyan.mall.goods.dao.GoodsCategoryAttributeValueMapper;
import com.suyan.mall.goods.model.GoodsCategoryAttributeValue;
import com.suyan.mall.goods.req.GoodsCategoryAttributeValueQueryDTO;
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
 * @Comments: <业务层商品类目属性值管理类>
 */
@Slf4j
@Service
public class GoodsCategoryAttributeValueBiz {

    @Autowired
    private GoodsCategoryAttributeValueMapper goodsCategoryAttributeValueMapper;

    /**
     * 删除商品类目属性值
     *
     * @param id
     * @return
     */
    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, rollbackFor = Exception.class)
    public Integer deleteGoodsCategoryAttributeValue(Long id) {
        // TODO: Describe business logic and implement it
        getBaseGoodsCategoryAttributeValue(id);
        return goodsCategoryAttributeValueMapper.logicalDeleteByPrimaryKey(id);
    }

    /**
     * 创建商品类目属性值
     * 
     * @param goodsCategoryAttributeValue
     * @return
     */
    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, rollbackFor = Exception.class)
    public Long createGoodsCategoryAttributeValue(GoodsCategoryAttributeValue goodsCategoryAttributeValue) {
        // TODO: Describe business logic and implement it
        goodsCategoryAttributeValueMapper.insertSelective( goodsCategoryAttributeValue );
        return goodsCategoryAttributeValue.getId();
    }

    /**
    * 批量创建
    *
    * @param goodsCategoryAttributeValueList
    * @return
    */
    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, rollbackFor = Exception.class)
    public int batchCreateGoodsCategoryAttributeValue(List<GoodsCategoryAttributeValue> goodsCategoryAttributeValueList) {
        // TODO: Describe business logic and implement it
        return goodsCategoryAttributeValueMapper.insertBatch( goodsCategoryAttributeValueList );
    }

    /**
     * 更新商品类目属性值
     * 
     * @param goodsCategoryAttributeValue
     * @return
     */
    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, rollbackFor = Exception.class)
    public Integer updateGoodsCategoryAttributeValue(GoodsCategoryAttributeValue goodsCategoryAttributeValue) {
        getBaseGoodsCategoryAttributeValue(goodsCategoryAttributeValue.getId());
        return goodsCategoryAttributeValueMapper.updateByPrimaryKeySelective(goodsCategoryAttributeValue);
    }
    
    /**
     * 根据ID获取商品类目属性值信息
     * 
     * @param id
     * @return
     */
    @Transactional(readOnly = true)
    public GoodsCategoryAttributeValue getGoodsCategoryAttributeValue(Long id) {
        return getBaseGoodsCategoryAttributeValue(id);
    }

    @Transactional(readOnly = true)
    public GoodsCategoryAttributeValue getBaseGoodsCategoryAttributeValue(Long id) {
        GoodsCategoryAttributeValue goodsCategoryAttributeValue = goodsCategoryAttributeValueMapper.selectByPrimaryKey(id);
        if(goodsCategoryAttributeValue == null || goodsCategoryAttributeValue.getIsDeleted()) {
            throw new CommonException(ResultCode.DATA_NOT_EXIST, "商品类目属性值");
        }
        return goodsCategoryAttributeValue;
    }

    /**
     * 分页查询商品类目属性值信息
     * 
     * @param goodsCategoryAttributeValueQuery
     * @return
     */
    @Transactional(readOnly = true)
    public QueryResultVO<GoodsCategoryAttributeValue> queryGoodsCategoryAttributeValue(GoodsCategoryAttributeValueQueryDTO goodsCategoryAttributeValueQuery) {
        QueryResultVO<GoodsCategoryAttributeValue> queryResult = new QueryResultVO<GoodsCategoryAttributeValue>();
        // 使用分页插件PageHelper实现分页功能
        PageHelper.startPage(goodsCategoryAttributeValueQuery.getPageNo(), goodsCategoryAttributeValueQuery.getPageSize());
        List<GoodsCategoryAttributeValue> goodsCategoryAttributeValueList = goodsCategoryAttributeValueMapper.queryGoodsCategoryAttributeValue(goodsCategoryAttributeValueQuery);
        PageInfo<GoodsCategoryAttributeValue> pageInfo = new PageInfo<GoodsCategoryAttributeValue>(goodsCategoryAttributeValueList);
        queryResult.setPageNo(pageInfo.getPageNum());
        queryResult.setPageSize(pageInfo.getPageSize());
        queryResult.setTotalPages(pageInfo.getPages());
        queryResult.setTotalRecords(pageInfo.getTotal());
        queryResult.setRecords(goodsCategoryAttributeValueList);
        return queryResult;
    }

}