package com.suyan.mall.mmc.biz;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.suyan.exception.CommonException;
import com.suyan.mall.mmc.dao.BargainActivityMapper;
import com.suyan.mall.mmc.model.BargainActivity;
import com.suyan.mall.mmc.req.BargainActivityQueryDTO;
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
 * @Comments: <业务层砍价活动管理类>
 */
@Slf4j
@Service
public class BargainActivityBiz {

    @Autowired
    private BargainActivityMapper bargainActivityMapper;

    /**
     * 删除砍价活动
     *
     * @param id
     * @return
     */
    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, rollbackFor = Exception.class)
    public Integer deleteBargainActivity(Long id) {
        // TODO: Describe business logic and implement it
        getBaseBargainActivity(id);
        return bargainActivityMapper.deleteByPrimaryKey(id);
    }

    /**
     * 创建砍价活动
     *
     * @param bargainActivity
     * @return
     */
    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, rollbackFor = Exception.class)
    public Long createBargainActivity(BargainActivity bargainActivity) {
        // TODO: Describe business logic and implement it
        bargainActivityMapper.insertSelective(bargainActivity);
        return bargainActivity.getId();
    }

    /**
     * 批量创建
     *
     * @param bargainActivityList
     * @return
     */
    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, rollbackFor = Exception.class)
    public int batchCreateBargainActivity(List<BargainActivity> bargainActivityList) {
        // TODO: Describe business logic and implement it
        return bargainActivityMapper.insertBatch(bargainActivityList);
    }

    /**
     * 更新砍价活动
     *
     * @param bargainActivity
     * @return
     */
    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, rollbackFor = Exception.class)
    public Integer updateBargainActivity(BargainActivity bargainActivity) {
        getBaseBargainActivity(bargainActivity.getId());
        return bargainActivityMapper.updateByPrimaryKeySelective(bargainActivity);
    }

    /**
     * 根据ID获取砍价活动信息
     *
     * @param id
     * @return
     */
    @Transactional(readOnly = true)
    public BargainActivity getBargainActivity(Long id) {
        return getBaseBargainActivity(id);
    }

    @Transactional(readOnly = true)
    public BargainActivity getBaseBargainActivity(Long id) {
        BargainActivity bargainActivity = bargainActivityMapper.selectByPrimaryKey(id);
        if (bargainActivity == null || bargainActivity.getIsDeleted()) {
            throw new CommonException(ResultCode.DATA_NOT_EXIST, "砍价活动");
        }
        return bargainActivity;
    }

    /**
     * 分页查询砍价活动信息
     *
     * @param bargainActivityQuery
     * @return
     */
    @Transactional(readOnly = true)
    public QueryResultVO<BargainActivity> queryBargainActivity(BargainActivityQueryDTO bargainActivityQuery) {
        QueryResultVO<BargainActivity> queryResult = new QueryResultVO<BargainActivity>();
        // 使用分页插件PageHelper实现分页功能
        PageHelper.startPage(bargainActivityQuery.getPageNo(), bargainActivityQuery.getPageSize());
        List<BargainActivity> bargainActivityList = bargainActivityMapper.queryBargainActivity(bargainActivityQuery);
        PageInfo<BargainActivity> pageInfo = new PageInfo<BargainActivity>(bargainActivityList);
        queryResult.setPageNo(pageInfo.getPageNum());
        queryResult.setPageSize(pageInfo.getPageSize());
        queryResult.setTotalPages(pageInfo.getPages());
        queryResult.setTotalRecords(pageInfo.getTotal());
        queryResult.setRecords(bargainActivityList);
        return queryResult;
    }

}