package com.suyan.mall.mmc.biz;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.suyan.mall.mmc.dao.PromotionScopeMapper;
import com.suyan.mall.mmc.enums.PromotionTypeEnum;
import com.suyan.mall.mmc.model.PromotionScope;
import com.suyan.mall.mmc.model.PromotionScopeExample;
import com.suyan.mall.mmc.req.PromotionScopeQueryDTO;
import com.suyan.query.QueryResultVO;
import com.suyan.utils.CollectionsUtil;
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
     * @return
     */
    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, rollbackFor = Exception.class)
    public Integer deletePromotionScope(List<Long> deleteIdList) {
        PromotionScopeExample example = new PromotionScopeExample();
        example.createCriteria().andIdIn(deleteIdList);
        return promotionScopeMapper.deleteByExample(example);
    }

    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, rollbackFor = Exception.class)
    public Integer deletePromotionScopeByPromotion(byte promotionType, Long promotionId) {
        PromotionScopeExample example = new PromotionScopeExample();
        example.createCriteria().andPromotionTypeEqualTo(promotionType).andPromotionIdEqualTo(promotionId);
        return promotionScopeMapper.deleteByExample(example);
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
    public int batchCreatePromotionScope(Byte promotionType, Long promotionId, List<PromotionScope> promotionScopeList) {
        if (CollectionsUtil.isNotEmpty(promotionScopeList)) {
            promotionScopeList.forEach(promotionScope -> {
                promotionScope.setPromotionType(promotionType);
                promotionScope.setPromotionId(promotionId);
            });
        }
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
        return promotionScopeMapper.updateByPrimaryKeySelective(promotionScope);
    }

    /**
     * 获取促销适用范围信息
     *
     * @param promotionType
     * @param promotionId
     * @return
     */
    @Transactional(readOnly = true)
    public List<PromotionScope> getPromotionScopeListByPromotion(byte promotionType, Long promotionId) {
        PromotionScopeExample example = new PromotionScopeExample();
        example.createCriteria().andPromotionTypeEqualTo(promotionType).andPromotionIdEqualTo(promotionId);
        return promotionScopeMapper.selectByExample(example);
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