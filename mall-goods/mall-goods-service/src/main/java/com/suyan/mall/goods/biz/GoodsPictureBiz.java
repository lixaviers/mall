package com.suyan.mall.goods.biz;

import com.suyan.mall.goods.dao.GoodsPictureMapper;
import com.suyan.mall.goods.model.GoodsPicture;
import com.suyan.mall.goods.model.GoodsPictureExample;
import com.suyan.utils.CollectionsUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @CopyRright (c): <素焉代码生成工具>
 * @Comments: <业务层商品图片管理类>
 */
@Slf4j
@Service
public class GoodsPictureBiz {

    @Autowired
    private GoodsPictureMapper goodsPictureMapper;


    /**
     * 创建商品图片
     *
     * @param goodsPictureList
     * @return
     */
    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, rollbackFor = Exception.class)
    public void createGoodsPicture(Long goodsId, List<GoodsPicture> goodsPictureList) {
        if (CollectionsUtil.isNotEmpty(goodsPictureList)) {
            goodsPictureList.forEach(goodsPicture -> {
                goodsPicture.setGoodsId(goodsId);
            });
            goodsPictureMapper.insertBatch(goodsPictureList);
        }
    }

    /**
     * 更新商品图片
     *
     * @param goodsPictureList
     * @return
     */
    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, rollbackFor = Exception.class)
    public void updateGoodsPicture(Long goodsId, List<GoodsPicture> goodsPictureList) {
        // 删除之前的图片
        GoodsPictureExample example = new GoodsPictureExample();
        example.createCriteria().andGoodsIdEqualTo(goodsId);
        goodsPictureMapper.deleteByExample(example);
        // 新增
        createGoodsPicture(goodsId, goodsPictureList);
    }


}