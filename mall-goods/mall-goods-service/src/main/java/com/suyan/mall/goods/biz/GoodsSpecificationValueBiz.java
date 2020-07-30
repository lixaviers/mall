package com.suyan.mall.goods.biz;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.suyan.exception.CommonException;
import com.suyan.mall.goods.dao.GoodsSpecificationValueMapper;
import com.suyan.mall.goods.model.GoodsSpecificationValue;
import com.suyan.mall.goods.req.GoodsSpecificationValueQueryDTO;
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
 * @Comments: <业务层商品规格值管理类>
 * @jdk 1.8
 * @Version: <1.0>
 */
@Slf4j
@Service
public class GoodsSpecificationValueBiz {

    @Autowired
    private GoodsSpecificationValueMapper goodsSpecificationValueMapper;


    /**
     * 删除商品规格值
     *
     * @param id
     * @return
     */
    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, rollbackFor = Exception.class)
    public Integer deleteGoodsSpecificationValue(Long id) {
        // TODO: Describe business logic and implement it
        getBaseGoodsSpecificationValue(id);
        return goodsSpecificationValueMapper.deleteByPrimaryKey(id);
    }

    /**
     * 创建商品规格值
     *
     * @param goodsSpecificationValue
     * @return
     */
    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, rollbackFor = Exception.class)
    public Long createGoodsSpecificationValue(GoodsSpecificationValue goodsSpecificationValue) {
        // TODO: Describe business logic and implement it
        goodsSpecificationValueMapper.insertSelective(goodsSpecificationValue);
        return goodsSpecificationValue.getId();
    }

    /**
     * 批量创建
     *
     * @param goodsSpecificationValueList
     * @return
     */
    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, rollbackFor = Exception.class)
    public int batchCreateGoodsSpecificationValue(List<GoodsSpecificationValue> goodsSpecificationValueList) {
        // TODO: Describe business logic and implement it
        return goodsSpecificationValueMapper.insertBatch(goodsSpecificationValueList);
    }

    /**
     * 更新商品规格值
     *
     * @param goodsSpecificationValue
     * @return
     */
    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, rollbackFor = Exception.class)
    public Integer updateGoodsSpecificationValue(GoodsSpecificationValue goodsSpecificationValue) {
        getBaseGoodsSpecificationValue(goodsSpecificationValue.getId());
        return goodsSpecificationValueMapper.updateByPrimaryKeySelective(goodsSpecificationValue);
    }

    /**
     * 根据ID获取商品规格值信息
     *
     * @param id
     * @return
     */
    @Transactional(readOnly = true)
    public GoodsSpecificationValue getGoodsSpecificationValue(Long id) {
        return getBaseGoodsSpecificationValue(id);
    }

    @Transactional(readOnly = true)
    public GoodsSpecificationValue getBaseGoodsSpecificationValue(Long id) {
        GoodsSpecificationValue goodsSpecificationValue = goodsSpecificationValueMapper.selectByPrimaryKey(id);
        if (goodsSpecificationValue == null || goodsSpecificationValue.getIsDeleted()) {
            throw new CommonException(ResultCode.DATA_NOT_EXIST, "商品规格值");
        }
        return goodsSpecificationValue;
    }

    /**
     * 分页查询商品规格值信息
     *
     * @param goodsSpecificationValueQuery
     * @return
     */
    @Transactional(readOnly = true)
    public QueryResultVO<GoodsSpecificationValue> queryGoodsSpecificationValue(GoodsSpecificationValueQueryDTO goodsSpecificationValueQuery) {
        QueryResultVO<GoodsSpecificationValue> queryResult = new QueryResultVO<GoodsSpecificationValue>();
        // 使用分页插件PageHelper实现分页功能
        PageHelper.startPage(goodsSpecificationValueQuery.getPageNo(), goodsSpecificationValueQuery.getPageSize());
        List<GoodsSpecificationValue> goodsSpecificationValueList = goodsSpecificationValueMapper.queryGoodsSpecificationValue(goodsSpecificationValueQuery);
        PageInfo<GoodsSpecificationValue> pageInfo = new PageInfo<GoodsSpecificationValue>(goodsSpecificationValueList);
        queryResult.setPageNo(pageInfo.getPageNum());
        queryResult.setPageSize(pageInfo.getPageSize());
        queryResult.setTotalPages(pageInfo.getPages());
        queryResult.setTotalRecords(pageInfo.getTotal());
        queryResult.setRecords(goodsSpecificationValueList);
        return queryResult;
    }

}