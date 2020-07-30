package com.suyan.mall.message.config;

import com.suyan.utils.CollectionsUtil;
import com.suyan.utils.JsonUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.shardingsphere.api.sharding.complex.ComplexKeysShardingAlgorithm;
import org.apache.shardingsphere.api.sharding.complex.ComplexKeysShardingValue;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Slf4j
public class ModuloTableShardingAlgorithm implements ComplexKeysShardingAlgorithm {

    private static final int MOD_VALUE = 10;

    @Override
    public Collection<String> doSharding(Collection availableTargetNames, ComplexKeysShardingValue complexKeysShardingValue) {
        log.info("collection:{}, shardingValue:{}", availableTargetNames.toString(), JsonUtil.toJsonStringNullValue(complexKeysShardingValue));

        List<String> shardingSuffixTargetNames = new ArrayList<>();

        //获取mobile的值
        Object mobileObject = complexKeysShardingValue.getColumnNameAndShardingValuesMap().get("mobile");
        Collection<String> mobiles = null;
        if (mobileObject != null) {
            mobiles = (Collection<String>) mobileObject;
        }
        // 1.手机号不为空
        if (CollectionsUtil.isNotEmpty(mobiles)) {
            for (String mobile : mobiles) {
                String suffix = String.valueOf(Long.valueOf(mobile) % MOD_VALUE);
                for (Object availableTargetName : availableTargetNames) {
                    String targetName = String.valueOf(availableTargetName);
                    if (targetName.endsWith(suffix)) {
                        shardingSuffixTargetNames.add(targetName);
                    }
                }
            }
            log.info("return shardingSuffixTargetNames is :" + shardingSuffixTargetNames.toString());
            return shardingSuffixTargetNames;
        }

        //4. 手机号、渠道id不为空 返回全库全表
        log.info("mobile is not exist,return shardingSuffixTargetNames is :" + availableTargetNames.toString());
        return availableTargetNames;
    }
}
