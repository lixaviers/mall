package com.suyan.mall.goods.biz;

import lombok.extern.slf4j.Slf4j;
import com.suyan.mall.goods.dao.GoodsSkuInventoryLogMapper;
import com.suyan.mall.goods.model.GoodsSkuInventoryLog;
import com.suyan.mall.goods.req.GoodsSkuInventoryLogQueryDTO;
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
 * @Comments: <业务层商品sku库存日志管理类>
 */
@Slf4j
@Service
public class GoodsSkuInventoryLogBiz {

    @Autowired
    private GoodsSkuInventoryLogMapper goodsSkuInventoryLogMapper;

    /**
     * 删除商品sku库存日志
     *
     * @param id
     * @return
     */
    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, rollbackFor = Exception.class)
    public Integer deleteGoodsSkuInventoryLog(Long id) {
        // TODO: Describe business logic and implement it
        getBaseGoodsSkuInventoryLog(id);
        return goodsSkuInventoryLogMapper.deleteByPrimaryKey(id);
    }

    /**
     * 创建商品sku库存日志
     * 
     * @param goodsSkuInventoryLog
     * @return
     */
    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, rollbackFor = Exception.class)
    public Long createGoodsSkuInventoryLog(GoodsSkuInventoryLog goodsSkuInventoryLog) {
        // TODO: Describe business logic and implement it
        goodsSkuInventoryLogMapper.insertSelective( goodsSkuInventoryLog );
        return goodsSkuInventoryLog.getId();
    }

    /**
    * 批量创建
    *
    * @param goodsSkuInventoryLogList
    * @return
    */
    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, rollbackFor = Exception.class)
    public int batchCreateGoodsSkuInventoryLog(List<GoodsSkuInventoryLog> goodsSkuInventoryLogList) {
        // TODO: Describe business logic and implement it
        return goodsSkuInventoryLogMapper.insertBatch( goodsSkuInventoryLogList );
    }

    /**
     * 更新商品sku库存日志
     * 
     * @param goodsSkuInventoryLog
     * @return
     */
    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, rollbackFor = Exception.class)
    public Integer updateGoodsSkuInventoryLog(GoodsSkuInventoryLog goodsSkuInventoryLog) {
        getBaseGoodsSkuInventoryLog(goodsSkuInventoryLog.getId());
        return goodsSkuInventoryLogMapper.updateByPrimaryKeySelective(goodsSkuInventoryLog);
    }
    
    /**
     * 根据ID获取商品sku库存日志信息
     * 
     * @param id
     * @return
     */
    @Transactional(readOnly = true)
    public GoodsSkuInventoryLog getGoodsSkuInventoryLog(Long id) {
        return getBaseGoodsSkuInventoryLog(id);
    }

    @Transactional(readOnly = true)
    public GoodsSkuInventoryLog getBaseGoodsSkuInventoryLog(Long id) {
        GoodsSkuInventoryLog goodsSkuInventoryLog = goodsSkuInventoryLogMapper.selectByPrimaryKey(id);
        if(goodsSkuInventoryLog == null) {
            throw new CommonException(ResultCode.DATA_NOT_EXIST, "商品sku库存日志");
        }
        return goodsSkuInventoryLog;
    }

    /**
     * 分页查询商品sku库存日志信息
     * 
     * @param goodsSkuInventoryLogQuery
     * @return
     */
    @Transactional(readOnly = true)
    public QueryResultVO<GoodsSkuInventoryLog> queryGoodsSkuInventoryLog(GoodsSkuInventoryLogQueryDTO goodsSkuInventoryLogQuery) {
        QueryResultVO<GoodsSkuInventoryLog> queryResult = new QueryResultVO<GoodsSkuInventoryLog>();
        // 使用分页插件PageHelper实现分页功能
        PageHelper.startPage(goodsSkuInventoryLogQuery.getPageNo(), goodsSkuInventoryLogQuery.getPageSize());
        List<GoodsSkuInventoryLog> goodsSkuInventoryLogList = goodsSkuInventoryLogMapper.queryGoodsSkuInventoryLog(goodsSkuInventoryLogQuery);
        PageInfo<GoodsSkuInventoryLog> pageInfo = new PageInfo<GoodsSkuInventoryLog>(goodsSkuInventoryLogList);
        queryResult.setPageNo(pageInfo.getPageNum());
        queryResult.setPageSize(pageInfo.getPageSize());
        queryResult.setTotalPages(pageInfo.getPages());
        queryResult.setTotalRecords(pageInfo.getTotal());
        queryResult.setRecords(goodsSkuInventoryLogList);
        return queryResult;
    }

}