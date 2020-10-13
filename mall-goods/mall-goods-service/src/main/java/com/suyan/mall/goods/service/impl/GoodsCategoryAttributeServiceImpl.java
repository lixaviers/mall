package com.suyan.mall.goods.service.impl;

import com.suyan.mall.goods.service.IGoodsCategoryAttributeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import com.suyan.mall.goods.biz.GoodsCategoryAttributeBiz;
import com.suyan.mall.goods.convertor.GoodsCategoryAttributeConvertor;
import com.suyan.mall.goods.model.GoodsCategoryAttribute;
import com.suyan.mall.goods.req.GoodsCategoryAttributeDTO;
import com.suyan.mall.goods.req.GoodsCategoryAttributeQueryDTO;
import com.suyan.mall.goods.resp.GoodsCategoryAttributeVO;
import com.suyan.query.QueryResultVO;

import java.util.List;


/**
 * @CopyRright (c): <素焉代码生成工具>
 * @Comments: <Service 商品类目属性管理类>
 */
@Slf4j
@Service("goodsCategoryAttributeService")
public class GoodsCategoryAttributeServiceImpl implements IGoodsCategoryAttributeService {

    @Autowired
    private GoodsCategoryAttributeBiz goodsCategoryAttributeBiz;

    @Override
    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, rollbackFor = Exception.class)
    public int deleteGoodsCategoryAttribute(Long id) {
        return goodsCategoryAttributeBiz.deleteGoodsCategoryAttribute(id);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, rollbackFor = Exception.class)
    public Long createGoodsCategoryAttribute(GoodsCategoryAttributeDTO goodsCategoryAttributeDTO) {
        return goodsCategoryAttributeBiz.createGoodsCategoryAttribute(GoodsCategoryAttributeConvertor.toGoodsCategoryAttribute(goodsCategoryAttributeDTO));
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, rollbackFor = Exception.class)
    public int updateGoodsCategoryAttribute(GoodsCategoryAttributeDTO goodsCategoryAttributeDTO) {
        return goodsCategoryAttributeBiz.updateGoodsCategoryAttribute(GoodsCategoryAttributeConvertor.toGoodsCategoryAttribute(goodsCategoryAttributeDTO));
    }

    @Override
    @Transactional(readOnly = true)
    public GoodsCategoryAttributeVO getGoodsCategoryAttribute(Long id ) {
        return GoodsCategoryAttributeConvertor.toGoodsCategoryAttributeVO(goodsCategoryAttributeBiz.getGoodsCategoryAttribute(id));
    }

    @Override
    @Transactional(readOnly = true)
    public QueryResultVO<GoodsCategoryAttributeVO> queryGoodsCategoryAttribute(GoodsCategoryAttributeQueryDTO goodsCategoryAttributeQueryDTO) {
        return GoodsCategoryAttributeConvertor.toQueryResult(goodsCategoryAttributeBiz.queryGoodsCategoryAttribute(goodsCategoryAttributeQueryDTO));
    }

}