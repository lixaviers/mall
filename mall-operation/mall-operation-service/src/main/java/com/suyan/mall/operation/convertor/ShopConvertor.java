package com.suyan.mall.operation.convertor;

import com.suyan.mall.operation.model.Shop;
import com.suyan.mall.operation.req.ShopDTO;
import com.suyan.mall.operation.resp.ShopVO;
import com.suyan.query.QueryResultVO;
import org.springframework.cglib.beans.BeanCopier;

import java.util.ArrayList;
import java.util.List;

/**
 * @CopyRright (c): <素焉代码生成工具>
 * @Comments: <对象相互转换>
 * @jdk 1.8
 * @Version: <1.0>
 */
public abstract class ShopConvertor {

    private static final BeanCopier beanCopierForShopVO = BeanCopier.create(Shop.class, ShopVO.class, false);
    private static final BeanCopier beanCopierForShop = BeanCopier.create(ShopDTO.class, Shop.class, false);

    public static ShopVO toShopVO(Shop shop) {
        if (shop == null) {
            return null;
        }
        ShopVO shopVO = new ShopVO();
        beanCopierForShopVO.copy(shop, shopVO, null);
        return shopVO;
    }

    public static Shop toShop(ShopDTO shopDTO) {
        Shop shop = new Shop();
        beanCopierForShop.copy(shopDTO, shop, null);
        return shop;
    }

    public static List<ShopVO> toShopVOList(List<Shop> shopList) {
        if (shopList == null || shopList.isEmpty()) {
            return null;
        }
        List<ShopVO> shopInfoList = new ArrayList<ShopVO>(shopList.size());
        for (Shop shop : shopList) {
            shopInfoList.add(toShopVO(shop));
        }
        return shopInfoList;
    }

    public static List<Shop> toShopList(List<ShopDTO> shopDTOList) {
        if (shopDTOList == null || shopDTOList.isEmpty()) {
            return null;
        }
        List<Shop> shopList = new ArrayList<Shop>(shopDTOList.size());
        for (ShopDTO shopDTO : shopDTOList) {
            shopList.add(toShop(shopDTO));
        }
        return shopList;
    }

    public static QueryResultVO<ShopVO> toQueryResult(QueryResultVO<Shop> queryResult) {
        QueryResultVO<ShopVO> queryResultInfo = new QueryResultVO<ShopVO>();
        queryResultInfo.setPageNo(queryResult.getPageNo());
        queryResultInfo.setPageSize(queryResult.getPageSize());
        queryResultInfo.setTotalPages(queryResult.getTotalPages());
        queryResultInfo.setTotalRecords(queryResult.getTotalRecords());
        queryResultInfo.setRecords(toShopVOList(queryResult.getRecords()));
        return queryResultInfo;
    }
}