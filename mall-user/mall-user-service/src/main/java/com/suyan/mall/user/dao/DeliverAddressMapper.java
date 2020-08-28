package com.suyan.mall.user.dao;

import com.suyan.mall.user.model.DeliverAddress;
import com.suyan.mall.user.model.DeliverAddressExample;
import com.suyan.mall.user.req.DeliverAddressQueryDTO;
import org.apache.ibatis.annotations.Param;

import java.time.LocalDateTime;
import java.util.List;

public interface DeliverAddressMapper {
    
    long countByExample(DeliverAddressExample example);

    int deleteByExample(DeliverAddressExample example);

    int deleteByPrimaryKey(Long id);

    int insert(DeliverAddress record);

    int insertSelective(DeliverAddress record);

    List<DeliverAddress> selectByExample(DeliverAddressExample example);

    DeliverAddress selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") DeliverAddress record, @Param("example") DeliverAddressExample example);

    int updateByExample(@Param("record") DeliverAddress record, @Param("example") DeliverAddressExample example);

    int updateByPrimaryKeySelective(DeliverAddress record);

    int updateByPrimaryKey(DeliverAddress record);

    int logicalDeleteByPrimaryKey(
            @Param("id") Long id
    );

    DeliverAddress selectByPrimaryKeyForUpdate(Long id);

    List<DeliverAddress> queryDeliverAddress(DeliverAddressQueryDTO deliverAddressQuery);

    int insertBatch(@Param("modelList") List<DeliverAddress> modelList);

    
    List<DeliverAddress> selectByUniqueUserId(@Param("uniqueUserId") String uniqueUserId);


}