package com.suyan.mall.goods.biz;

import lombok.extern.slf4j.Slf4j;
import com.suyan.mall.goods.dao.GoodsCategoryBrandMapper;
import com.suyan.mall.goods.model.GoodsCategoryBrand;
import com.suyan.mall.goods.req.GoodsCategoryBrandQueryDTO;
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
 * @Comments: <业务层商品类目品牌管理管理类>
 */
@Slf4j
@Service
public class GoodsCategoryBrandBiz {

    @Autowired
    private GoodsCategoryBrandMapper goodsCategoryBrandMapper;

    /**
     * 删除商品类目品牌管理
     *
     * @param id
     * @return
     */
    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, rollbackFor = Exception.class)
    public Integer deleteGoodsCategoryBrand(Long id) {
        // TODO: Describe business logic and implement it
        getBaseGoodsCategoryBrand(id);
        return goodsCategoryBrandMapper.deleteByPrimaryKey(id);
    }

    /**
     * 创建商品类目品牌管理
     * 
     * @param goodsCategoryBrand
     * @return
     */
    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, rollbackFor = Exception.class)
    public Long createGoodsCategoryBrand(GoodsCategoryBrand goodsCategoryBrand) {
        // TODO: Describe business logic and implement it
        goodsCategoryBrandMapper.insertSelective( goodsCategoryBrand );
        return goodsCategoryBrand.getId();
    }

    /**
    * 批量创建
    *
    * @param goodsCategoryBrandList
    * @return
    */
    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, rollbackFor = Exception.class)
    public int batchCreateGoodsCategoryBrand(List<GoodsCategoryBrand> goodsCategoryBrandList) {
        return goodsCategoryBrandMapper.insertBatch( goodsCategoryBrandList );
    }

    /**
     * 更新商品类目品牌管理
     * 
     * @param goodsCategoryBrand
     * @return
     */
    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, rollbackFor = Exception.class)
    public Integer updateGoodsCategoryBrand(GoodsCategoryBrand goodsCategoryBrand) {
        getBaseGoodsCategoryBrand(goodsCategoryBrand.getId());
        return goodsCategoryBrandMapper.updateByPrimaryKeySelective(goodsCategoryBrand);
    }
    
    /**
     * 根据ID获取商品类目品牌管理信息
     * 
     * @param id
     * @return
     */
    @Transactional(readOnly = true)
    public GoodsCategoryBrand getGoodsCategoryBrand(Long id) {
        return getBaseGoodsCategoryBrand(id);
    }

    @Transactional(readOnly = true)
    public GoodsCategoryBrand getBaseGoodsCategoryBrand(Long id) {
        GoodsCategoryBrand goodsCategoryBrand = goodsCategoryBrandMapper.selectByPrimaryKey(id);
        if(goodsCategoryBrand == null) {
            throw new CommonException(ResultCode.DATA_NOT_EXIST, "商品类目品牌管理");
        }
        return goodsCategoryBrand;
    }

    /**
     * 分页查询商品类目品牌管理信息
     * 
     * @param goodsCategoryBrandQuery
     * @return
     */
    @Transactional(readOnly = true)
    public QueryResultVO<GoodsCategoryBrand> queryGoodsCategoryBrand(GoodsCategoryBrandQueryDTO goodsCategoryBrandQuery) {
        QueryResultVO<GoodsCategoryBrand> queryResult = new QueryResultVO<GoodsCategoryBrand>();
        // 使用分页插件PageHelper实现分页功能
        PageHelper.startPage(goodsCategoryBrandQuery.getPageNo(), goodsCategoryBrandQuery.getPageSize());
        List<GoodsCategoryBrand> goodsCategoryBrandList = goodsCategoryBrandMapper.queryGoodsCategoryBrand(goodsCategoryBrandQuery);
        PageInfo<GoodsCategoryBrand> pageInfo = new PageInfo<GoodsCategoryBrand>(goodsCategoryBrandList);
        queryResult.setPageNo(pageInfo.getPageNum());
        queryResult.setPageSize(pageInfo.getPageSize());
        queryResult.setTotalPages(pageInfo.getPages());
        queryResult.setTotalRecords(pageInfo.getTotal());
        queryResult.setRecords(goodsCategoryBrandList);
        return queryResult;
    }

}