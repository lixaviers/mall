package com.suyan.mall.goods.biz;

import com.suyan.mall.goods.dao.GoodsDescriptionMapper;
import com.suyan.mall.goods.model.GoodsDescription;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * @CopyRright (c): <素焉代码生成工具>
 * @Comments: <业务层商品描述管理类>
 * @jdk 1.8
 * @Version: <1.0>
 */
@Slf4j
@Service
public class GoodsDescriptionBiz {

    @Autowired
    private GoodsDescriptionMapper goodsDescriptionMapper;


    /**
     * 创建商品描述
     *
     * @param goodsDescription
     * @return
     */
    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, rollbackFor = Exception.class)
    public Long createGoodsDescription(GoodsDescription goodsDescription) {
        goodsDescriptionMapper.insertSelective(goodsDescription);
        return goodsDescription.getGoodsId();
    }

    /**
     * 更新商品描述
     *
     * @param goodsDescription
     * @return
     */
    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, rollbackFor = Exception.class)
    public void updateGoodsDescription(GoodsDescription goodsDescription) {
        GoodsDescription goodsDescriptionLast = goodsDescriptionMapper.selectByPrimaryKey(goodsDescription.getGoodsId());
        if (goodsDescriptionLast == null) {
            createGoodsDescription(goodsDescription);
        } else {
            goodsDescriptionMapper.updateByPrimaryKeySelective(goodsDescription);
        }
    }

    /**
     * 根据商品id获取商品描述信息
     *
     * @param goodsId
     * @return
     */
    @Transactional(readOnly = true)
    public String getGoodsDescription(Long goodsId) {
        GoodsDescription goodsDescription = goodsDescriptionMapper.selectByPrimaryKey(goodsId);
        if (goodsDescription == null) {
            return null;
        }
        return goodsDescription.getDescription();
    }

}