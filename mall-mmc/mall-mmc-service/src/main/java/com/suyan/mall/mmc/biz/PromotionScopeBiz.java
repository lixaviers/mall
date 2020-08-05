package com.suyan.mall.mmc.biz;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.suyan.exception.CommonException;
import com.suyan.mall.mmc.dao.PromotionScopeMapper;
import com.suyan.mall.mmc.model.PromotionScope;
import com.suyan.mall.mmc.req.PromotionScopeQueryDTO;
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
 * @Comments: <业务层促销适用范围管理类>
 */
@Slf4j
@Service
public class PromotionScopeBiz {

    @Autowired
    private PromotionScopeMapper promotionScopeMapper;

    /**
     * 删除促销适用范围
     *
     * @param id
     * @return
     */
    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, rollbackFor = Exception.class)
    public Integer deletePromotionScope(Long id) {
        getBasePromotionScope(id);
        return promotionScopeMapper.deleteByPrimaryKey(id);
    }

    /**
     * 创建促销适用范围
     *
     * @param promotionScope
     * @return
     */
    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, rollbackFor = Exception.class)
    public Long createPromotionScope(PromotionScope promotionScope) {
        promotionScopeMapper.insertSelective(promotionScope);
        return promotionScope.getId();
    }

    /**
     * 批量创建
     *
     * @param promotionScopeList
     * @return
     */
    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, rollbackFor = Exception.class)
    public int batchCreatePromotionScope(List<PromotionScope> promotionScopeList) {
        return promotionScopeMapper.insertBatch(promotionScopeList);
    }

    /**
     * 更新促销适用范围
     *
     * @param promotionScope
     * @return
     */
    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, rollbackFor = Exception.class)
    public Integer updatePromotionScope(PromotionScope promotionScope) {
        getBasePromotionScope(promotionScope.getId());
        return promotionScopeMapper.updateByPrimaryKeySelective(promotionScope);
    }

    /**
     * 根据ID获取促销适用范围信息
     *
     * @param id
     * @return
     */
    @Transactional(readOnly = true)
    public PromotionScope getPromotionScope(Long id) {
        return getBasePromotionScope(id);
    }

    @Transactional(readOnly = true)
    public PromotionScope getBasePromotionScope(Long id) {
        PromotionScope promotionScope = promotionScopeMapper.selectByPrimaryKey(id);
        if (promotionScope == null) {
            throw new CommonException(ResultCode.DATA_NOT_EXIST, "促销适用范围");
        }
        return promotionScope;
    }

    /**
     * 分页查询促销适用范围信息
     *
     * @param promotionScopeQuery
     * @return
     */
    @Transactional(readOnly = true)
    public QueryResultVO<PromotionScope> queryPromotionScope(PromotionScopeQueryDTO promotionScopeQuery) {
        QueryResultVO<PromotionScope> queryResult = new QueryResultVO<PromotionScope>();
        // 使用分页插件PageHelper实现分页功能
        PageHelper.startPage(promotionScopeQuery.getPageNo(), promotionScopeQuery.getPageSize());
        List<PromotionScope> promotionScopeList = promotionScopeMapper.queryPromotionScope(promotionScopeQuery);
        PageInfo<PromotionScope> pageInfo = new PageInfo<PromotionScope>(promotionScopeList);
        queryResult.setPageNo(pageInfo.getPageNum());
        queryResult.setPageSize(pageInfo.getPageSize());
        queryResult.setTotalPages(pageInfo.getPages());
        queryResult.setTotalRecords(pageInfo.getTotal());
        queryResult.setRecords(promotionScopeList);
        return queryResult;
    }

}