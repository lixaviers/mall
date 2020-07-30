package com.suyan.mall.mmc.biz;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.suyan.exception.CommonException;
import com.suyan.mall.mmc.dao.SubPromotionMapper;
import com.suyan.mall.mmc.model.SubPromotion;
import com.suyan.mall.mmc.req.SubPromotionQueryDTO;
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
 * @Comments: <业务层订单促销管理类>
 */
@Slf4j
@Service
public class SubPromotionBiz {

    @Autowired
    private SubPromotionMapper subPromotionMapper;


    /**
     * 删除订单促销
     *
     * @param id
     * @return
     */
    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, rollbackFor = Exception.class)
    public Integer deleteSubPromotion(Long id) {
        getBaseSubPromotion(id);
        return subPromotionMapper.deleteByPrimaryKey(id);
    }

    /**
     * 创建订单促销
     *
     * @param subPromotion
     * @return
     */
    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, rollbackFor = Exception.class)
    public Long createSubPromotion(SubPromotion subPromotion) {
        // TODO: Describe business logic and implement it
        subPromotionMapper.insertSelective(subPromotion);
        return subPromotion.getId();
    }

    /**
     * 批量创建
     *
     * @param subPromotionList
     * @return
     */
    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, rollbackFor = Exception.class)
    public int batchCreateSubPromotion(List<SubPromotion> subPromotionList) {
        // TODO: Describe business logic and implement it
        return subPromotionMapper.insertBatch(subPromotionList);
    }

    /**
     * 更新订单促销
     *
     * @param subPromotion
     * @return
     */
    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, rollbackFor = Exception.class)
    public Integer updateSubPromotion(SubPromotion subPromotion) {
        getBaseSubPromotion(subPromotion.getId());
        return subPromotionMapper.updateByPrimaryKeySelective(subPromotion);
    }

    /**
     * 根据ID获取订单促销信息
     *
     * @param id
     * @return
     */
    @Transactional(readOnly = true)
    public SubPromotion getSubPromotion(Long id) {
        return getBaseSubPromotion(id);
    }

    @Transactional(readOnly = true)
    public SubPromotion getBaseSubPromotion(Long id) {
        SubPromotion subPromotion = subPromotionMapper.selectByPrimaryKey(id);
        if (subPromotion == null || subPromotion.getIsDeleted()) {
            throw new CommonException(ResultCode.DATA_NOT_EXIST, "订单促销");
        }
        return subPromotion;
    }

    /**
     * 分页查询订单促销信息
     *
     * @param subPromotionQuery
     * @return
     */
    @Transactional(readOnly = true)
    public QueryResultVO<SubPromotion> querySubPromotion(SubPromotionQueryDTO subPromotionQuery) {
        QueryResultVO<SubPromotion> queryResult = new QueryResultVO<SubPromotion>();
        // 使用分页插件PageHelper实现分页功能
        PageHelper.startPage(subPromotionQuery.getPageNo(), subPromotionQuery.getPageSize());
        List<SubPromotion> subPromotionList = subPromotionMapper.querySubPromotion(subPromotionQuery);
        PageInfo<SubPromotion> pageInfo = new PageInfo<SubPromotion>(subPromotionList);
        queryResult.setPageNo(pageInfo.getPageNum());
        queryResult.setPageSize(pageInfo.getPageSize());
        queryResult.setTotalPages(pageInfo.getPages());
        queryResult.setTotalRecords(pageInfo.getTotal());
        queryResult.setRecords(subPromotionList);
        return queryResult;
    }

}