package com.suyan.mall.mmc.biz;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.suyan.exception.CommonException;
import com.suyan.mall.mmc.dao.CouponChannelMapper;
import com.suyan.mall.mmc.model.CouponChannel;
import com.suyan.mall.mmc.req.CouponChannelQueryDTO;
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
 * @Comments: <业务层优惠券渠道管理类>
 */
@Slf4j
@Service
public class CouponChannelBiz {

    @Autowired
    private CouponChannelMapper couponChannelMapper;

    /**
     * 删除优惠券渠道
     *
     * @param id
     * @return
     */
    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, rollbackFor = Exception.class)
    public Integer deleteCouponChannel(Long id) {
        // TODO: Describe business logic and implement it
        getBaseCouponChannel(id);
        return couponChannelMapper.deleteByPrimaryKey(id);
    }

    /**
     * 创建优惠券渠道
     *
     * @param couponChannel
     * @return
     */
    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, rollbackFor = Exception.class)
    public Long createCouponChannel(CouponChannel couponChannel) {
        // TODO: Describe business logic and implement it
        couponChannelMapper.insertSelective(couponChannel);
        return couponChannel.getId();
    }

    /**
     * 批量创建
     *
     * @param couponChannelList
     * @return
     */
    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, rollbackFor = Exception.class)
    public int batchCreateCouponChannel(List<CouponChannel> couponChannelList) {
        // TODO: Describe business logic and implement it
        return couponChannelMapper.insertBatch(couponChannelList);
    }

    /**
     * 更新优惠券渠道
     *
     * @param couponChannel
     * @return
     */
    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, rollbackFor = Exception.class)
    public Integer updateCouponChannel(CouponChannel couponChannel) {
        getBaseCouponChannel(couponChannel.getId());
        return couponChannelMapper.updateByPrimaryKeySelective(couponChannel);
    }

    /**
     * 根据ID获取优惠券渠道信息
     *
     * @param id
     * @return
     */
    @Transactional(readOnly = true)
    public CouponChannel getCouponChannel(Long id) {
        return getBaseCouponChannel(id);
    }

    @Transactional(readOnly = true)
    public CouponChannel getBaseCouponChannel(Long id) {
        CouponChannel couponChannel = couponChannelMapper.selectByPrimaryKey(id);
        if (couponChannel == null) {
            throw new CommonException(ResultCode.DATA_NOT_EXIST, "优惠券渠道");
        }
        return couponChannel;
    }

    /**
     * 分页查询优惠券渠道信息
     *
     * @param couponChannelQuery
     * @return
     */
    @Transactional(readOnly = true)
    public QueryResultVO<CouponChannel> queryCouponChannel(CouponChannelQueryDTO couponChannelQuery) {
        QueryResultVO<CouponChannel> queryResult = new QueryResultVO<CouponChannel>();
        // 使用分页插件PageHelper实现分页功能
        PageHelper.startPage(couponChannelQuery.getPageNo(), couponChannelQuery.getPageSize());
        List<CouponChannel> couponChannelList = couponChannelMapper.queryCouponChannel(couponChannelQuery);
        PageInfo<CouponChannel> pageInfo = new PageInfo<CouponChannel>(couponChannelList);
        queryResult.setPageNo(pageInfo.getPageNum());
        queryResult.setPageSize(pageInfo.getPageSize());
        queryResult.setTotalPages(pageInfo.getPages());
        queryResult.setTotalRecords(pageInfo.getTotal());
        queryResult.setRecords(couponChannelList);
        return queryResult;
    }

}