package com.suyan.mall.user.biz;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.suyan.exception.CommonException;
import com.suyan.mall.operation.feignClient.c.AddressFeignClient;
import com.suyan.mall.operation.req.c.AddressListDTO;
import com.suyan.mall.operation.resp.AddressVO;
import com.suyan.mall.user.constants.ExceptionDefUser;
import com.suyan.mall.user.dao.DeliverAddressMapper;
import com.suyan.mall.user.model.DeliverAddress;
import com.suyan.mall.user.req.DeliverAddressQueryDTO;
import com.suyan.mall.user.resp.b.UserInfoVO;
import com.suyan.mall.user.utils.UserUtil;
import com.suyan.query.QueryResultVO;
import com.suyan.result.Result;
import com.suyan.result.ResultCode;
import com.suyan.utils.CollectionsUtil;
import com.suyan.utils.JsonUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.List;

/**
 * @CopyRright (c): <素焉代码生成工具>
 * @Comments: <业务层收货地址管理类>
 */
@Slf4j
@Service
public class DeliverAddressBiz {

    @Autowired
    private DeliverAddressMapper deliverAddressMapper;

    @Autowired
    private AddressFeignClient addressFeignClient;

    /**
     * 删除收货地址
     *
     * @param id
     * @return
     */
    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, rollbackFor = Exception.class)
    public Integer deleteDeliverAddress(Long id) {
        UserInfoVO user = UserUtil.getUser();
        DeliverAddress deliverAddress = getBaseDeliverAddress(id);
        if (!deliverAddress.getUniqueUserId().equals(user.getUniqueUserId())) {
            // 非自己地址不能删除
            throw new CommonException(ResultCode.DATA_NOT_EXIST, "收货地址");
        }
        return deliverAddressMapper.deleteByPrimaryKey(id);
    }

    /**
     * 创建收货地址
     *
     * @param deliverAddress
     * @return
     */
    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, rollbackFor = Exception.class)
    public Long createDeliverAddress(DeliverAddress deliverAddress) {
        getAddressInfo(deliverAddress);

        UserInfoVO user = UserUtil.getUser();
        deliverAddress.setUniqueUserId(user.getUniqueUserId());
        deliverAddressMapper.insertSelective(deliverAddress);
        return deliverAddress.getId();

    }

    private void getAddressInfo(DeliverAddress deliverAddress) {
        // 查询地址
        AddressListDTO dto = new AddressListDTO();
        dto.setIdList(Arrays.asList(deliverAddress.getProvinceId(), deliverAddress.getCityId(), deliverAddress.getAreaId()));
        log.info("调用查询地址信息入参={}", JsonUtil.toJsonString(dto));
        Result<List<AddressVO>> result = addressFeignClient.getAddressList(dto);
        log.info("调用查询地址信息出参={}", JsonUtil.toJsonString(result));
        if (!result.isSuccess()) {
            throw new CommonException(ResultCode.API_INVLID_DATA, "地址信息");
        }
        List<AddressVO> addressVOList = result.getData();
        if (CollectionsUtil.isEmpty(addressVOList) || addressVOList.size() != 3) {
            throw new CommonException(ExceptionDefUser.EXCEPTION_4001);
        }
        AddressVO province = null;
        AddressVO city = null;
        AddressVO area = null;
        for (AddressVO addressVO : addressVOList) {
            if (deliverAddress.getProvinceId().equals(addressVO.getId())) {
                province = addressVO;
            } else if (deliverAddress.getCityId().equals(addressVO.getId())) {
                city = addressVO;
            } else if (deliverAddress.getAreaId().equals(addressVO.getId())) {
                area = addressVO;
            }
        }
        if (province == null || area == null || area == null) {
            throw new CommonException(ResultCode.API_INVLID_DATA, "地址信息");
        }
        if (!city.getParentId().equals(province.getId())) {
            throw new CommonException(ResultCode.COMMON_PARAM_INVALID, "城市");
        }
        if (!area.getParentId().equals(city.getId())) {
            throw new CommonException(ResultCode.COMMON_PARAM_INVALID, "区");
        }
        deliverAddress.setProvinceName(province.getName());
        deliverAddress.setCityName(city.getName());
        deliverAddress.setAreaName(area.getName());
    }


    /**
     * 更新收货地址
     *
     * @param deliverAddress
     * @return
     */
    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, rollbackFor = Exception.class)
    public Integer updateDeliverAddress(DeliverAddress deliverAddress) {
        UserInfoVO user = UserUtil.getUser();
        DeliverAddress deliverAddressLast = getBaseDeliverAddress(deliverAddress.getId());
        if (!deliverAddressLast.getUniqueUserId().equals(user.getUniqueUserId())) {
            // 非自己地址不能删除
            throw new CommonException(ResultCode.DATA_NOT_EXIST, "收货地址");
        }

        // 判断省、市、区是否改变
        if (!deliverAddress.getProvinceId().equals(deliverAddressLast.getProvinceId()) || !deliverAddress.getCityId().equals(deliverAddressLast.getCityId())
                || !deliverAddress.getAreaId().equals(deliverAddressLast.getAreaId())) {
            // 重新设置名称
            getAddressInfo(deliverAddress);
        } else {
            deliverAddress.setProvinceName(null);
            deliverAddress.setCityName(null);
            deliverAddress.setAreaName(null);
        }

        return deliverAddressMapper.updateByPrimaryKeySelective(deliverAddress);
    }

    /**
     * 根据ID获取收货地址信息
     *
     * @param id
     * @return
     */
    @Transactional(readOnly = true)
    public DeliverAddress getDeliverAddress(Long id) {
        return getBaseDeliverAddress(id);
    }

    @Transactional(readOnly = true)
    public DeliverAddress getBaseDeliverAddress(Long id) {
        DeliverAddress deliverAddress = deliverAddressMapper.selectByPrimaryKey(id);
        if (deliverAddress == null || deliverAddress.getIsDeleted()) {
            throw new CommonException(ResultCode.DATA_NOT_EXIST, "收货地址");
        }
        return deliverAddress;
    }

    /**
     * 分页查询收货地址信息
     *
     * @param deliverAddressQuery
     * @return
     */
    @Transactional(readOnly = true)
    public QueryResultVO<DeliverAddress> queryDeliverAddress(DeliverAddressQueryDTO deliverAddressQuery) {
        QueryResultVO<DeliverAddress> queryResult = new QueryResultVO<DeliverAddress>();
        // 使用分页插件PageHelper实现分页功能
        PageHelper.startPage(deliverAddressQuery.getPageNo(), deliverAddressQuery.getPageSize());
        List<DeliverAddress> deliverAddressList = deliverAddressMapper.queryDeliverAddress(deliverAddressQuery);
        PageInfo<DeliverAddress> pageInfo = new PageInfo<DeliverAddress>(deliverAddressList);
        queryResult.setPageNo(pageInfo.getPageNum());
        queryResult.setPageSize(pageInfo.getPageSize());
        queryResult.setTotalPages(pageInfo.getPages());
        queryResult.setTotalRecords(pageInfo.getTotal());
        queryResult.setRecords(deliverAddressList);
        return queryResult;
    }

}