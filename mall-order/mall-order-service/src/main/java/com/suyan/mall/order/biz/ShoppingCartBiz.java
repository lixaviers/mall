package com.suyan.mall.order.biz;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.suyan.exception.CommonException;
import com.suyan.mall.goods.resp.GoodsSkuVO;
import com.suyan.mall.order.client.GoodsSkuClient;
import com.suyan.mall.order.dao.ShoppingCartMapper;
import com.suyan.mall.order.model.ShoppingCart;
import com.suyan.mall.order.model.ShoppingCartExample;
import com.suyan.mall.order.req.ShoppingCartQueryDTO;
import com.suyan.mall.user.utils.UserUtil;
import com.suyan.query.QueryResultVO;
import com.suyan.result.Result;
import com.suyan.result.ResultCode;
import com.suyan.utils.CollectionsUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @CopyRright (c): <素焉代码生成工具>
 * @Comments: <业务层购物车管理类>
 */
@Slf4j
@Service
public class ShoppingCartBiz {

    @Autowired
    private ShoppingCartMapper shoppingCartMapper;

    @Autowired
    private GoodsSkuClient goodsSkuClient;

    /**
     * 删除购物车
     *
     * @param id
     * @return
     */
    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, rollbackFor = Exception.class)
    public Integer deleteShoppingCart(Long id) {
        getBaseShoppingCart(id);
        return shoppingCartMapper.logicalDeleteByPrimaryKey(id);
    }

    /**
     * 创建购物车
     *
     * @param shoppingCart
     * @return
     */
    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, rollbackFor = Exception.class)
    public void createShoppingCart(ShoppingCart shoppingCart) {
        String uniqueUserId = UserUtil.getUser().getUniqueUserId();
        ShoppingCartExample example = new ShoppingCartExample();
        example.createCriteria().andUniqueUserIdEqualTo(uniqueUserId).andGoodsSkuCodeEqualTo(shoppingCart.getGoodsSkuCode()).andIsDeletedEqualTo(false);
        List<ShoppingCart> shoppingCartList = shoppingCartMapper.selectByExample(example);
        if (CollectionsUtil.isNotEmpty(shoppingCartList)) {
            // 已经添加过的商品，只增加数量
            ShoppingCart shoppingCartLast = shoppingCartList.get(0);
            shoppingCartLast.setGoodsNumber(shoppingCartLast.getGoodsNumber() + shoppingCart.getGoodsNumber());
            shoppingCartMapper.updateByPrimaryKeySelective(shoppingCartLast);
        } else {
            Result<List<GoodsSkuVO>> result = goodsSkuClient.getGoodsInfo(Arrays.asList(shoppingCart.getGoodsSkuCode()));
            if (CollectionsUtil.isEmpty(result.getData())) {
                throw new CommonException(ResultCode.API_INVLID_DATA, "商品");
            }
            GoodsSkuVO goodsSkuVO = result.getData().get(0);
            shoppingCart.setShopId(goodsSkuVO.getShopId());
            shoppingCart.setGoodsPrice(goodsSkuVO.getPrice());
            shoppingCart.setUniqueUserId(uniqueUserId);
            shoppingCartMapper.insertSelective(shoppingCart);
        }

    }

    /**
     * 更新购物车
     *
     * @param shoppingCart
     * @return
     */
    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, rollbackFor = Exception.class)
    public Integer updateShoppingCart(ShoppingCart shoppingCart) {
        getBaseShoppingCart(shoppingCart.getId());
        return shoppingCartMapper.updateByPrimaryKeySelective(shoppingCart);
    }

    /**
     * 根据ID获取购物车信息
     *
     * @param id
     * @return
     */
    @Transactional(readOnly = true)
    public ShoppingCart getShoppingCart(Long id) {
        return getBaseShoppingCart(id);
    }

    @Transactional(readOnly = true)
    public ShoppingCart getBaseShoppingCart(Long id) {
        ShoppingCart shoppingCart = shoppingCartMapper.selectByPrimaryKey(id);
        if (shoppingCart == null || shoppingCart.getIsDeleted()) {
            throw new CommonException(ResultCode.DATA_NOT_EXIST, "购物车");
        }
        return shoppingCart;
    }

    /**
     * 分页查询购物车信息
     *
     * @param shoppingCartQuery
     * @return
     */
    @Transactional(readOnly = true)
    public QueryResultVO<ShoppingCart> queryShoppingCart(ShoppingCartQueryDTO shoppingCartQuery) {
        QueryResultVO<ShoppingCart> queryResult = new QueryResultVO<ShoppingCart>();
        // 使用分页插件PageHelper实现分页功能
        PageHelper.startPage(shoppingCartQuery.getPageNo(), shoppingCartQuery.getPageSize());
        List<ShoppingCart> shoppingCartList = shoppingCartMapper.queryShoppingCart(shoppingCartQuery);
        PageInfo<ShoppingCart> pageInfo = new PageInfo<ShoppingCart>(shoppingCartList);
        queryResult.setPageNo(pageInfo.getPageNum());
        queryResult.setPageSize(pageInfo.getPageSize());
        queryResult.setTotalPages(pageInfo.getPages());
        queryResult.setTotalRecords(pageInfo.getTotal());
        queryResult.setRecords(shoppingCartList);
        return queryResult;
    }

}