package com.suyan.mall.mmc.biz;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.suyan.exception.CommonException;
import com.suyan.mall.mmc.dao.SubPromotionMapper;
import com.suyan.mall.mmc.enums.CommonStatusMmcEnum;
import com.suyan.mall.mmc.enums.PromotionScopeEnum;
import com.suyan.mall.mmc.enums.PromotionTypeEnum;
import com.suyan.mall.mmc.enums.PromotionUseTypeEnum;
import com.suyan.mall.mmc.model.PromotionScope;
import com.suyan.mall.mmc.model.SubPromotion;
import com.suyan.mall.mmc.req.SubPromotionQueryDTO;
import com.suyan.mall.user.resp.b.UserInfoVO;
import com.suyan.mall.user.utils.UserUtil;
import com.suyan.query.QueryResultVO;
import com.suyan.result.ResultCode;
import com.suyan.utils.CollectionsUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @CopyRright (c): <素焉代码生成工具>
 * @Comments: <业务层订单促销管理类>
 */
@Slf4j
@Service
public class SubPromotionBiz {

    @Autowired
    private SubPromotionMapper subPromotionMapper;

    @Autowired
    private PromotionScopeBiz promotionScopeBiz;


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
        UserInfoVO shopUser = UserUtil.getShopUser();
        subPromotion.setShopId(shopUser.getShopId());
        // 已保存
        subPromotion.setSubPromotionStatus(CommonStatusMmcEnum.SAVED.getValue());
        if (PromotionUseTypeEnum.FULL_LADDER_COUPON.equal(subPromotion.getSubPromotionType())) {
            // 阶梯满减
            subPromotion.setPromotionScopeAmount(JSON.toJSONString(subPromotion.getPromotionAmountScopeList()));
        }
        subPromotionMapper.insertSelective(subPromotion);
        if (PromotionScopeEnum.GOODS_CATEGORY.equal(subPromotion.getSubPromotionScope())) {
            // 按商品类目
            promotionScopeBiz.batchCreatePromotionScope(PromotionTypeEnum.SUB_PROMOTION.getValue(), subPromotion.getId(), subPromotion.getPromotionScopeList());
        }
        return subPromotion.getId();
    }

    /**
     * 更新订单促销
     *
     * @param subPromotion
     * @return
     */
    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, rollbackFor = Exception.class)
    public Integer updateSubPromotion(SubPromotion subPromotion) {
        SubPromotion subPromotionLast = getBaseSubPromotion(subPromotion.getId());
        UserInfoVO shopUser = UserUtil.getShopUser();
        if (!subPromotionLast.getShopId().equals(shopUser.getShopId())) {
            // 非本店铺订单促销
            throw new CommonException(ResultCode.NO_PERMISSION_OPERATE, "此订单促销");
        }
        if (subPromotion.getSubPromotionScope().equals(subPromotionLast.getSubPromotionScope())) {
            if (PromotionScopeEnum.GOODS_CATEGORY.equal(subPromotion.getSubPromotionScope())) {
                // 按商品类目 对比类目
                List<PromotionScope> oldPromotionScopeList = promotionScopeBiz.getPromotionScopeListByPromotion(PromotionTypeEnum.SUB_PROMOTION.getValue(), subPromotion.getId());
                List<Integer> oldGoodsCategoryIdIdList = oldPromotionScopeList.stream().map(PromotionScope::getGoodsCategoryId).collect(Collectors.toList());

                List<Integer> newGoodsCategoryIdIdList = subPromotion.getPromotionScopeList().stream().map(PromotionScope::getGoodsCategoryId).collect(Collectors.toList());

                // 删除的列表
                List<Long> deleteIdList = oldPromotionScopeList.stream().filter(item -> !newGoodsCategoryIdIdList.contains(item.getGoodsCategoryId()))
                        .map(PromotionScope::getId).collect(Collectors.toList());
                if (CollectionsUtil.isNotEmpty(deleteIdList)) {
                    promotionScopeBiz.deletePromotionScope(deleteIdList);
                }
                // 新增的列表
                List<PromotionScope> addList = subPromotion.getPromotionScopeList().stream().filter(item -> !oldGoodsCategoryIdIdList.contains(item.getGoodsCategoryId())).collect(Collectors.toList());
                if (CollectionsUtil.isNotEmpty(addList)) {
                    promotionScopeBiz.batchCreatePromotionScope(PromotionTypeEnum.SUB_PROMOTION.getValue(), subPromotion.getId(), addList);
                }
            }
        } else {
            if (PromotionScopeEnum.GOODS_CATEGORY.equal(subPromotion.getSubPromotionScope())) {
                // 新增为[按商品类目]
                promotionScopeBiz.batchCreatePromotionScope(PromotionTypeEnum.SUB_PROMOTION.getValue(), subPromotion.getId(), subPromotion.getPromotionScopeList());
            } else if (PromotionScopeEnum.SHOP.equal(subPromotion.getSubPromotionScope())) {
                // 新增为[全店通用]
                promotionScopeBiz.deletePromotionScopeByPromotion(PromotionTypeEnum.SUB_PROMOTION.getValue(), subPromotion.getId());
            }
        }
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
        SubPromotion subPromotion = getBaseSubPromotion(id);
        subPromotion.setPromotionScopeList(promotionScopeBiz.getPromotionScopeListByPromotion(PromotionTypeEnum.SUB_PROMOTION.getValue(), id));
        return subPromotion;
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