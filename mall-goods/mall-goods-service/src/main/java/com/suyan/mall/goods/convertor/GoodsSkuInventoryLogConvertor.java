package com.suyan.mall.goods.convertor;

import com.suyan.mall.goods.model.GoodsSkuInventoryLog;
import com.suyan.mall.goods.req.GoodsSkuInventoryLogDTO;
import com.suyan.mall.goods.resp.GoodsSkuInventoryLogVO;
import com.suyan.query.QueryResultVO;
import org.springframework.cglib.beans.BeanCopier;

import java.util.ArrayList;
import java.util.List;

/**
 * @CopyRright (c): <素焉代码生成工具>
 * @Comments: <对象相互转换>
 */
public abstract class GoodsSkuInventoryLogConvertor {

    private static final BeanCopier beanCopierForGoodsSkuInventoryLogVO = BeanCopier.create(GoodsSkuInventoryLog.class, GoodsSkuInventoryLogVO.class, false);
    private static final BeanCopier beanCopierForGoodsSkuInventoryLog = BeanCopier.create(GoodsSkuInventoryLogDTO.class, GoodsSkuInventoryLog.class, false);

    public static GoodsSkuInventoryLogVO toGoodsSkuInventoryLogVO(GoodsSkuInventoryLog goodsSkuInventoryLog) {
        if (goodsSkuInventoryLog == null) {
            return null;
        }
        GoodsSkuInventoryLogVO goodsSkuInventoryLogVO = new GoodsSkuInventoryLogVO();
        beanCopierForGoodsSkuInventoryLogVO.copy(goodsSkuInventoryLog, goodsSkuInventoryLogVO, null);
        return goodsSkuInventoryLogVO;
    }

    public static GoodsSkuInventoryLog toGoodsSkuInventoryLog(GoodsSkuInventoryLogDTO goodsSkuInventoryLogDTO) {
        GoodsSkuInventoryLog goodsSkuInventoryLog = new GoodsSkuInventoryLog();
        beanCopierForGoodsSkuInventoryLog.copy(goodsSkuInventoryLogDTO, goodsSkuInventoryLog, null);
        return goodsSkuInventoryLog;
    }

    public static List<GoodsSkuInventoryLogVO> toGoodsSkuInventoryLogVOList(List<GoodsSkuInventoryLog> goodsSkuInventoryLogList) {
        if (goodsSkuInventoryLogList == null || goodsSkuInventoryLogList.isEmpty()) {
            return null;
        }
        List<GoodsSkuInventoryLogVO> goodsSkuInventoryLogInfoList = new ArrayList<GoodsSkuInventoryLogVO>(goodsSkuInventoryLogList.size());
        for (GoodsSkuInventoryLog goodsSkuInventoryLog : goodsSkuInventoryLogList) {
            goodsSkuInventoryLogInfoList.add(toGoodsSkuInventoryLogVO(goodsSkuInventoryLog));
        }
        return goodsSkuInventoryLogInfoList;
    }

    public static List<GoodsSkuInventoryLog> toGoodsSkuInventoryLogList(List<GoodsSkuInventoryLogDTO> goodsSkuInventoryLogDTOList) {
        if (goodsSkuInventoryLogDTOList == null || goodsSkuInventoryLogDTOList.isEmpty()) {
            return null;
        }
        List<GoodsSkuInventoryLog> goodsSkuInventoryLogList = new ArrayList<GoodsSkuInventoryLog>(goodsSkuInventoryLogDTOList.size());
        for (GoodsSkuInventoryLogDTO goodsSkuInventoryLogDTO : goodsSkuInventoryLogDTOList) {
            goodsSkuInventoryLogList.add(toGoodsSkuInventoryLog(goodsSkuInventoryLogDTO));
        }
        return goodsSkuInventoryLogList;
    }

    public static QueryResultVO<GoodsSkuInventoryLogVO> toQueryResult(QueryResultVO<GoodsSkuInventoryLog> queryResult) {
        QueryResultVO<GoodsSkuInventoryLogVO> queryResultInfo = new QueryResultVO<GoodsSkuInventoryLogVO>();
        queryResultInfo.setPageNo(queryResult.getPageNo());
        queryResultInfo.setPageSize(queryResult.getPageSize());
        queryResultInfo.setTotalPages(queryResult.getTotalPages());
        queryResultInfo.setTotalRecords(queryResult.getTotalRecords());
        queryResultInfo.setRecords(toGoodsSkuInventoryLogVOList(queryResult.getRecords()));
        return queryResultInfo;
    }
}