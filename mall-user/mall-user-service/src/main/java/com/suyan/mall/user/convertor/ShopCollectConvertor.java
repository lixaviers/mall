package com.suyan.mall.user.convertor;

import com.suyan.mall.user.model.ShopCollect;
import com.suyan.mall.user.req.ShopCollectDTO;
import com.suyan.mall.user.resp.ShopCollectVO;
import com.suyan.query.QueryResultVO;
import org.springframework.cglib.beans.BeanCopier;

import java.util.ArrayList;
import java.util.List;

/**
 * @CopyRright (c): <素焉代码生成工具>
 * @Comments: <对象相互转换>
 */
public abstract class ShopCollectConvertor {

    private static final BeanCopier beanCopierForShopCollectVO = BeanCopier.create(ShopCollect.class, ShopCollectVO.class, false);
    private static final BeanCopier beanCopierForShopCollect = BeanCopier.create(ShopCollectDTO.class, ShopCollect.class, false);

    public static ShopCollectVO toShopCollectVO(ShopCollect shopCollect) {
        if (shopCollect == null) {
            return null;
        }
        ShopCollectVO shopCollectVO = new ShopCollectVO();
        beanCopierForShopCollectVO.copy(shopCollect, shopCollectVO, null);
        return shopCollectVO;
    }

    public static ShopCollect toShopCollect(ShopCollectDTO shopCollectDTO) {
        ShopCollect shopCollect = new ShopCollect();
        beanCopierForShopCollect.copy(shopCollectDTO, shopCollect, null);
        return shopCollect;
    }

    public static List<ShopCollectVO> toShopCollectVOList(List<ShopCollect> shopCollectList) {
        if (shopCollectList == null || shopCollectList.isEmpty()) {
            return null;
        }
        List<ShopCollectVO> shopCollectInfoList = new ArrayList<ShopCollectVO>(shopCollectList.size());
        for (ShopCollect shopCollect : shopCollectList) {
            shopCollectInfoList.add(toShopCollectVO(shopCollect));
        }
        return shopCollectInfoList;
    }

    public static List<ShopCollect> toShopCollectList(List<ShopCollectDTO> shopCollectDTOList) {
        if (shopCollectDTOList == null || shopCollectDTOList.isEmpty()) {
            return null;
        }
        List<ShopCollect> shopCollectList = new ArrayList<ShopCollect>(shopCollectDTOList.size());
        for (ShopCollectDTO shopCollectDTO : shopCollectDTOList) {
            shopCollectList.add(toShopCollect(shopCollectDTO));
        }
        return shopCollectList;
    }

    public static QueryResultVO<ShopCollectVO> toQueryResult(QueryResultVO<ShopCollect> queryResult) {
        QueryResultVO<ShopCollectVO> queryResultInfo = new QueryResultVO<ShopCollectVO>();
        queryResultInfo.setPageNo(queryResult.getPageNo());
        queryResultInfo.setPageSize(queryResult.getPageSize());
        queryResultInfo.setTotalPages(queryResult.getTotalPages());
        queryResultInfo.setTotalRecords(queryResult.getTotalRecords());
        queryResultInfo.setRecords(toShopCollectVOList(queryResult.getRecords()));
        return queryResultInfo;
    }
}