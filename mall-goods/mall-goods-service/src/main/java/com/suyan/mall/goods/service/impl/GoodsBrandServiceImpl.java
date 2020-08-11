package com.suyan.mall.goods.service.impl;

import com.suyan.mall.goods.service.IGoodsBrandService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.suyan.mall.goods.biz.GoodsBrandBiz;
import com.suyan.mall.goods.convertor.GoodsBrandConvertor;
import com.suyan.mall.goods.model.GoodsBrand;
import com.suyan.mall.goods.req.GoodsBrandDTO;
import com.suyan.mall.goods.req.GoodsBrandQueryDTO;
import com.suyan.mall.goods.resp.GoodsBrandVO;
import com.suyan.query.QueryResultVO;

import java.util.List;


/**
 * @CopyRright (c): <素焉代码生成工具>
 * @Comments: <Service 商品品牌管理类>
 */
@Slf4j
@Service("goodsBrandService")
public class GoodsBrandServiceImpl implements IGoodsBrandService {

    @Autowired
    private GoodsBrandBiz goodsBrandBiz;

    @Override
    public int deleteGoodsBrand(Integer id) {
        return goodsBrandBiz.deleteGoodsBrand(id);
    }

    @Override
    public Integer createGoodsBrand(GoodsBrandDTO goodsBrandDTO) {
        return goodsBrandBiz.createGoodsBrand(GoodsBrandConvertor.toGoodsBrand(goodsBrandDTO));
    }

    @Override
    public int updateGoodsBrand(GoodsBrandDTO goodsBrandDTO) {
        return goodsBrandBiz.updateGoodsBrand(GoodsBrandConvertor.toGoodsBrand(goodsBrandDTO));
    }

    @Override
    public GoodsBrandVO getGoodsBrand(Integer id ) {
        return GoodsBrandConvertor.toGoodsBrandVO(goodsBrandBiz.getGoodsBrand(id));
    }

    @Override
    public QueryResultVO<GoodsBrandVO> queryGoodsBrand(GoodsBrandQueryDTO goodsBrandQueryDTO) {
        return GoodsBrandConvertor.toQueryResult(goodsBrandBiz.queryGoodsBrand(goodsBrandQueryDTO));
    }

    @Override
    public List<GoodsBrandVO> getGoodsBrandListByCategoryId(Integer categoryId) {
        return GoodsBrandConvertor.toGoodsBrandVOList(goodsBrandBiz.getGoodsBrandListByCategoryId(categoryId));
    }
}