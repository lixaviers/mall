package com.suyan.mall.operation.convertor;

import com.google.common.collect.Lists;
import com.suyan.mall.operation.model.Address;
import com.suyan.mall.operation.resp.AddressVO;
import com.suyan.query.QueryResultVO;
import com.suyan.utils.CollectionsUtil;
import org.springframework.cglib.beans.BeanCopier;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * @CopyRright (c): <素焉代码生成工具>
 * @Comments: <对象相互转换>
 * @jdk 1.8
 * @Version: <1.0>
 */
public abstract class AddressConvertor {

    private static final BeanCopier beanCopierForAddressVO = BeanCopier.create(Address.class, AddressVO.class, false);

    public static AddressVO toAddressVO(Address address) {
        if (address == null) {
            return null;
        }
        AddressVO addressVO = new AddressVO();
        beanCopierForAddressVO.copy(address, addressVO, null);
        return addressVO;
    }

    public static List<AddressVO> toAddressVOList(List<Address> addressList) {
        if (addressList == null || addressList.isEmpty()) {
            return null;
        }
        List<AddressVO> addressInfoList = new ArrayList<AddressVO>(addressList.size());
        for (Address address : addressList) {
            addressInfoList.add(toAddressVO(address));
        }
        return addressInfoList;
    }

    public static QueryResultVO<AddressVO> toQueryResult(QueryResultVO<Address> queryResult) {
        QueryResultVO<AddressVO> queryResultInfo = new QueryResultVO<AddressVO>();
        queryResultInfo.setPageNo(queryResult.getPageNo());
        queryResultInfo.setPageSize(queryResult.getPageSize());
        queryResultInfo.setTotalPages(queryResult.getTotalPages());
        queryResultInfo.setTotalRecords(queryResult.getTotalRecords());
        queryResultInfo.setRecords(toAddressVOList(queryResult.getRecords()));
        return queryResultInfo;
    }


    public static List<AddressVO> toTree(List<AddressVO> categoryList) {
        if (CollectionsUtil.isNotEmpty(categoryList)) {
            // 顶级类目
            List<AddressVO> topCategoryList = categoryList.stream().filter(bean -> bean.getParentId().equals(1)).sorted(Comparator.comparing(AddressVO::getOrderNum)).collect(Collectors.toList());
            List<AddressVO> childCategoryList = categoryList.stream().filter(bean -> !bean.getParentId().equals(1)).collect(Collectors.toList());
            sort(topCategoryList, childCategoryList);

            return topCategoryList;
        }
        return null;
    }

    private static void sort(List<AddressVO> topCategoryList, List<AddressVO> childCategoryList) {
        List<AddressVO> copyVos = Lists.newCopyOnWriteArrayList(childCategoryList);
        for (AddressVO top : topCategoryList) {
            for (AddressVO child : childCategoryList) {
                if (Objects.equals(top.getId(), child.getParentId())) {
                    top.addChildCategoryList(child);
                    copyVos.remove(child);
                }
            }
        }
        for (AddressVO top : topCategoryList) {
            if (CollectionsUtil.isNotEmpty(top.getChildren())) {
                // 排序
                top.setChildren(top.getChildren().stream().sorted(Comparator.comparing(AddressVO::getOrderNum)).collect(Collectors.toList()));
                sort(top.getChildren(), copyVos);
            }
        }
    }

}