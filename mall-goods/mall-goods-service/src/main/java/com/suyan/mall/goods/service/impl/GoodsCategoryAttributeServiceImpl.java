package com.suyan.mall.goods.service.impl;

import com.suyan.mall.goods.biz.GoodsCategoryAttributeBiz;
import com.suyan.mall.goods.biz.GoodsCategoryAttributeValueBiz;
import com.suyan.mall.goods.convertor.GoodsCategoryAttributeConvertor;
import com.suyan.mall.goods.convertor.GoodsCategoryAttributeValueConvertor;
import com.suyan.mall.goods.model.GoodsCategoryAttribute;
import com.suyan.mall.goods.model.GoodsCategoryAttributeValue;
import com.suyan.mall.goods.req.GoodsCategoryAttributeDTO;
import com.suyan.mall.goods.req.GoodsCategoryAttributeQueryDTO;
import com.suyan.mall.goods.req.GoodsCategoryAttributeValueDTO;
import com.suyan.mall.goods.resp.GoodsCategoryAttributeQueryVO;
import com.suyan.mall.goods.resp.GoodsCategoryAttributeVO;
import com.suyan.mall.goods.service.IGoodsCategoryAttributeService;
import com.suyan.query.QueryResultVO;
import com.suyan.utils.CollectionsUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


/**
 * @CopyRright (c): <素焉代码生成工具>
 * @Comments: <Service 商品类目属性管理类>
 */
@Slf4j
@Service("goodsCategoryAttributeService")
public class GoodsCategoryAttributeServiceImpl implements IGoodsCategoryAttributeService {

    @Autowired
    private GoodsCategoryAttributeBiz goodsCategoryAttributeBiz;
    @Autowired
    private GoodsCategoryAttributeValueBiz goodsCategoryAttributeValueBiz;

    @Override
    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, rollbackFor = Exception.class)
    public int deleteGoodsCategoryAttribute(Long id) {
        return goodsCategoryAttributeBiz.deleteGoodsCategoryAttribute(id);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, rollbackFor = Exception.class)
    public Long createGoodsCategoryAttribute(GoodsCategoryAttributeDTO goodsCategoryAttributeDTO) {
        Long id = goodsCategoryAttributeBiz.createGoodsCategoryAttribute(GoodsCategoryAttributeConvertor.toGoodsCategoryAttribute(goodsCategoryAttributeDTO));
        if (goodsCategoryAttributeDTO.getIsEnum()) {
            // 添加选项值
            List<String> valueNames = goodsCategoryAttributeDTO.getAttributeValues().stream().map(GoodsCategoryAttributeValueDTO::getValueName).collect(Collectors.toList());
            goodsCategoryAttributeValueBiz.batchCreateGoodsCategoryAttributeValue(id, valueNames);
        }
        return id;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, rollbackFor = Exception.class)
    public int updateGoodsCategoryAttribute(GoodsCategoryAttributeDTO goodsCategoryAttributeDTO) {
        GoodsCategoryAttribute goodsCategoryAttribute = GoodsCategoryAttributeConvertor.toGoodsCategoryAttribute(goodsCategoryAttributeDTO);
        if (!goodsCategoryAttribute.getIsEnum()) {
            // 删除所有选项
            goodsCategoryAttributeValueBiz.deleteGoodsCategoryAttributeValue(goodsCategoryAttribute.getId());
        } else {
            goodsCategoryAttributeValueBiz.batchUpdateGoodsCategoryAttributeValue(goodsCategoryAttribute.getId(), GoodsCategoryAttributeValueConvertor.toGoodsCategoryAttributeValueList(goodsCategoryAttributeDTO.getAttributeValues()));
        }
        return goodsCategoryAttributeBiz.updateGoodsCategoryAttribute(goodsCategoryAttribute);
    }

    @Override
    @Transactional(readOnly = true)
    public GoodsCategoryAttributeVO getGoodsCategoryAttribute(Long id) {
        GoodsCategoryAttributeVO vo = GoodsCategoryAttributeConvertor.toGoodsCategoryAttributeVO(goodsCategoryAttributeBiz.getGoodsCategoryAttribute(id));
        vo.setAttributeValues(GoodsCategoryAttributeValueConvertor.toGoodsCategoryAttributeValueVOList(goodsCategoryAttributeValueBiz.getGoodsCategoryAttributeValueByAttributeId(id)));
        return vo;
    }

    @Override
    @Transactional(readOnly = true)
    public QueryResultVO<GoodsCategoryAttributeQueryVO> queryGoodsCategoryAttribute(GoodsCategoryAttributeQueryDTO goodsCategoryAttributeQueryDTO) {
        List<GoodsCategoryAttributeQueryVO> voList = new ArrayList<>();
        QueryResultVO<GoodsCategoryAttribute> queryResultVO = goodsCategoryAttributeBiz.queryGoodsCategoryAttribute(goodsCategoryAttributeQueryDTO);
        if (CollectionsUtil.isNotEmpty(queryResultVO.getRecords())) {
            List<Long> idList = queryResultVO.getRecords().stream().filter(bean -> bean.getIsEnum()).map(GoodsCategoryAttribute::getId).collect(Collectors.toList());
            List<GoodsCategoryAttributeValue> values = goodsCategoryAttributeValueBiz.getGoodsCategoryAttributeValues(idList);
            if (CollectionsUtil.isNotEmpty(values)) {
                Map<Long, List<GoodsCategoryAttributeValue>> map = values.stream().collect(Collectors.groupingBy(GoodsCategoryAttributeValue::getGoodsCategoryAttributeId));
                for (GoodsCategoryAttribute record : queryResultVO.getRecords()) {
                    record.setValueList(map.get(record.getId()));
                }
            }

            for (GoodsCategoryAttribute record : queryResultVO.getRecords()) {
                if (CollectionsUtil.isNotEmpty(record.getValueList())) {
                    for (GoodsCategoryAttributeValue value : record.getValueList()) {
                        GoodsCategoryAttributeQueryVO vo = GoodsCategoryAttributeConvertor.toGoodsCategoryAttributeQueryVO(record);
                        vo.setValueId(value.getId());
                        vo.setValueName(value.getValueName());
                        vo.setValueIsEnable(value.getIsEnable());
                        vo.setValueSortNumber(value.getSortNumber());
                        voList.add(vo);
                    }
                } else {
                    voList.add(GoodsCategoryAttributeConvertor.toGoodsCategoryAttributeQueryVO(record));
                }
            }
        }
        QueryResultVO<GoodsCategoryAttributeQueryVO> queryResultInfo = new QueryResultVO<GoodsCategoryAttributeQueryVO>();
        queryResultInfo.setPageNo(queryResultVO.getPageNo());
        queryResultInfo.setPageSize(queryResultVO.getPageSize());
        queryResultInfo.setTotalPages(queryResultVO.getTotalPages());
        queryResultInfo.setTotalRecords(queryResultVO.getTotalRecords());
        queryResultInfo.setRecords(voList);
        return queryResultInfo;
    }

}