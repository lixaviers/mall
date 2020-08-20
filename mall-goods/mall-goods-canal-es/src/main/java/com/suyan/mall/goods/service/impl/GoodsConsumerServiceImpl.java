package com.suyan.mall.goods.service.impl;

import com.suyan.mall.goods.convertor.GoodsConvertor;
import com.suyan.mall.goods.dao.GoodsBrandMapper;
import com.suyan.mall.goods.dao.GoodsMapper;
import com.suyan.mall.goods.dao.biz.GoodsCategoryBizMapper;
import com.suyan.mall.goods.es.model.GoodsES;
import com.suyan.mall.goods.es.repository.GoodsRepository;
import com.suyan.mall.goods.model.Goods;
import com.suyan.mall.goods.model.GoodsBrand;
import com.suyan.mall.goods.model.GoodsCategory;
import com.suyan.mall.goods.service.ConsumerService;
import com.suyan.utils.CollectionsUtil;
import com.suyan.utils.JsonUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service("goodsConsumerService")
@Slf4j
public class GoodsConsumerServiceImpl implements ConsumerService<Goods, Long> {

    @Autowired
    private GoodsRepository goodsRepository;

    @Autowired
    private GoodsMapper goodsMapper;
    @Autowired
    private GoodsCategoryBizMapper goodsCategoryBizMapper;
    @Autowired
    private GoodsBrandMapper goodsBrandMapper;

    @Override
    public void save(Goods goods) {
        log.info("GoodsConsumerServiceImpl save:{}", JsonUtil.toJsonString(goods));
        GoodsES goodsES = GoodsConvertor.toGoodsES(goods);
        // 查询前台类目
        List<GoodsCategory> foregroundCategorys = goodsCategoryBizMapper.getForegroundCategorysByBackgroundCategoryId(goods.getGoodsCategoryId());
        if (CollectionsUtil.isNotEmpty(foregroundCategorys)) {
            String goodsForegroundCategoryIdStr = "";
            String goodsForegroundCategoryNameStr = "";
            for (int i = 0; i < foregroundCategorys.size(); i++) {
                GoodsCategory item = foregroundCategorys.get(i);
                goodsForegroundCategoryIdStr += item.getFullIdPath();
                goodsForegroundCategoryNameStr += item.getFullNamePath();
                if (i < foregroundCategorys.size() - 1) {
                    goodsForegroundCategoryIdStr += " ";
                    goodsForegroundCategoryNameStr += " ";
                }
            }
            goodsES.setGoodsForegroundCategoryIdStr(goodsForegroundCategoryIdStr);
            goodsES.setGoodsForegroundCategoryNameStr(goodsForegroundCategoryNameStr);
        }
        // 查询品牌
        GoodsBrand goodsBrand = goodsBrandMapper.selectByPrimaryKey(goods.getBrandId());
        if (!Objects.isNull(goodsBrand)) {
            goodsES.setBrandName(goodsBrand.getBrandName());
        }
        goodsRepository.save(goodsES);
    }

    @Override
    public void update(Goods goods) {
        log.info("update:{}", JsonUtil.toJsonString(goods));
        Goods goodsLast = goodsMapper.selectByPrimaryKey(goods.getId());
        if (!Objects.isNull(goodsLast)) {
            GoodsES goodsES = goodsRepository.getGoodsById(goods.getId());
            goodsES.setInventory(goodsLast.getInventory());
            goodsRepository.save(goodsES);
        }
    }

    @Override
    public void delete(Goods goods) {
        log.info("delete:{}", JsonUtil.toJsonString(goods));
        goodsRepository.deleteById(goods.getId());
    }

}
