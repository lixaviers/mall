package com.suyan.mall.goods.biz;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.suyan.exception.CommonException;
import com.suyan.mall.goods.dao.GoodsCategoryMapper;
import com.suyan.mall.goods.model.GoodsCategory;
import com.suyan.mall.goods.model.GoodsCategoryExample;
import com.suyan.mall.goods.req.GoodsCategoryQueryDTO;
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
 * @Comments: <业务层商品类目管理类>
 * @jdk 1.8
 * @Version: <1.0>
 */
@Slf4j
@Service
public class GoodsCategoryBiz {

    @Autowired
    private GoodsCategoryMapper goodsCategoryMapper;


    /**
     * 删除商品类目
     *
     * @param id
     * @return
     */
    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, rollbackFor = Exception.class)
    public Integer deleteGoodsCategory(Integer id) {
        // TODO: Describe business logic and implement it
        getBaseGoodsCategory(id);
        return goodsCategoryMapper.deleteByPrimaryKey(id);
    }

    /**
     * 创建商品类目
     *
     * @param goodsCategory
     * @return
     */
    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, rollbackFor = Exception.class)
    public Integer createGoodsCategory(GoodsCategory goodsCategory) {
        // TODO: Describe business logic and implement it
        goodsCategoryMapper.insertSelective( goodsCategory );
        return goodsCategory.getId();
    }

    /**
    * 批量创建
    *
    * @param goodsCategoryList
    * @return
    */
    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, rollbackFor = Exception.class)
    public int batchCreateGoodsCategory(List<GoodsCategory> goodsCategoryList) {
        // TODO: Describe business logic and implement it
        return goodsCategoryMapper.insertBatch( goodsCategoryList );
    }

    /**
     * 更新商品类目
     *
     * @param goodsCategory
     * @return
     */
    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, rollbackFor = Exception.class)
    public Integer updateGoodsCategory(GoodsCategory goodsCategory) {
        getBaseGoodsCategory(goodsCategory.getId());
        return goodsCategoryMapper.updateByPrimaryKeySelective(goodsCategory);
    }

    /**
     * 根据ID获取商品类目信息
     *
     * @param id
     * @return
     */
    @Transactional(readOnly = true)
    public GoodsCategory getGoodsCategory(Integer id) {
        return getBaseGoodsCategory(id);
    }

    @Transactional(readOnly = true)
    public GoodsCategory getBaseGoodsCategory(Integer id) {
        GoodsCategory goodsCategory = goodsCategoryMapper.selectByPrimaryKey(id);
        if(goodsCategory == null) {
            throw new CommonException(ResultCode.DATA_NOT_EXIST, "商品类目");
        }
        return goodsCategory;
    }

    /**
     * 分页查询商品类目信息
     *
     * @param goodsCategoryQuery
     * @return
     */
    @Transactional(readOnly = true)
    public QueryResultVO<GoodsCategory> queryGoodsCategory(GoodsCategoryQueryDTO goodsCategoryQuery) {
        QueryResultVO<GoodsCategory> queryResult = new QueryResultVO<GoodsCategory>();
        // 使用分页插件PageHelper实现分页功能
        PageHelper.startPage(goodsCategoryQuery.getPageNo(), goodsCategoryQuery.getPageSize());
        List<GoodsCategory> goodsCategoryList = goodsCategoryMapper.queryGoodsCategory(goodsCategoryQuery);
        PageInfo<GoodsCategory> pageInfo = new PageInfo<GoodsCategory>(goodsCategoryList);
        queryResult.setPageNo(pageInfo.getPageNum());
        queryResult.setPageSize(pageInfo.getPageSize());
        queryResult.setTotalPages(pageInfo.getPages());
        queryResult.setTotalRecords(pageInfo.getTotal());
        queryResult.setRecords(goodsCategoryList);
        return queryResult;
    }

    public List<GoodsCategory> getTree() {
        GoodsCategoryExample example = new GoodsCategoryExample();
        example.createCriteria().andIsEnableEqualTo(true);
        return goodsCategoryMapper.selectByExample(example);
    }
}