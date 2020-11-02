/*
 * Copyright (c) 2020.
 * 项目名称：素焉商城
 * 创建人：素焉
 * 开源地址: https://github.com/lixaviers/mall
 */
package com.suyan.mall.user.service.impl;

import com.suyan.mall.operation.feignClient.b.ShopFeignClient;
import com.suyan.mall.operation.resp.ShopVO;
import com.suyan.mall.user.biz.UserBiz;
import com.suyan.mall.user.convertor.UserConvertor;
import com.suyan.mall.user.model.User;
import com.suyan.mall.user.req.UserDTO;
import com.suyan.mall.user.req.UserQueryDTO;
import com.suyan.mall.user.resp.UserVO;
import com.suyan.mall.user.resp.b.UserInfoVO;
import com.suyan.mall.user.service.IUserService;
import com.suyan.query.QueryResultVO;
import com.suyan.result.Result;
import com.suyan.utils.CollectionsUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


/**
 * @CopyRright (c): <素焉代码生成工具>
 * @Comments: <Service 用户管理类>
 * @jdk 1.8
 * @Version: <1.0>
 */
@Service
@Slf4j
public class UserServiceImpl implements IUserService {

    @Autowired
    private UserBiz userBiz;

    @Autowired
    private ShopFeignClient shopFeignClient;

    @Override
    public int deleteUser(Long id) {
        return userBiz.deleteUser(id);
    }

    @Override
    public Long createUser(UserDTO userDTO) {
        User user = UserConvertor.toUser(userDTO);
        return userBiz.createUser(user);
    }

    @Override
    public int updateUser(UserDTO userDTO) {
        User user = UserConvertor.toUser(userDTO);
        return userBiz.updateUser(user);
    }

    @Override
    public UserVO getUser(Long id) {
        User user = userBiz.getUser(id);
        return UserConvertor.toUserVO(user);
    }

    @Override
    public QueryResultVO<UserVO> queryUser(UserQueryDTO userQueryDTO) {
        return UserConvertor.toQueryResult(userBiz.queryUser(userQueryDTO));
    }


    @Override
    public UserInfoVO userLogin(UserDTO userDTO) {
        User user = UserConvertor.toUser(userDTO);
        return UserConvertor.toUserInfoVO(userBiz.userLogin(user));
    }

    @Override
    public UserInfoVO userRegister(UserDTO userDTO) {
        User user = UserConvertor.toUser(userDTO);
        return UserConvertor.toUserInfoVO(userBiz.userRegister(user));
    }

    @Override
    public UserInfoVO shopLogin(UserDTO userDTO) {
        User user = UserConvertor.toUser(userDTO);
        /*String body = JSON.toJSONString(userDTO);
        String topic = RocketMqTopicConstant.MqTagEnum.USER_LOGIN.getTopic();
        String tag = RocketMqTopicConstant.MqTagEnum.USER_LOGIN.getTag();
        String key = StringUtils.createMqKey(topic, tag, userDTO.getMobile(), body);
        MqMessageDataDTO mqMessageData = new MqMessageDataDTO(topic, tag, key, body);
        UserInfoVO userInfoVO = UserConvertor.toUserInfoVO(userBiz.shopLogin(mqMessageData, user));*/
        UserInfoVO userInfoVO = UserConvertor.toUserInfoVO(userBiz.shopLogin(user));
        try {
            // 获取用户店铺
            log.info("调用[operation-b]获取用户店铺入参={}", userInfoVO.getUniqueUserId());
            Result<List<ShopVO>> result = shopFeignClient.getUserShopList(userInfoVO.getUniqueUserId());
            log.info("调用[operation-b]获取用户店铺出参={}", result);
            if (result.isSuccess() && CollectionsUtil.isNotEmpty(result.getData())) {
                ShopVO shopVO = result.getData().get(0);
                userInfoVO.setShopId(shopVO.getId());
                userInfoVO.setShopName(shopVO.getShopName());
            }
        } catch (Exception e) {
            log.error("调用[operation-b]获取用户店铺出错", e);
        }
        return userInfoVO;
    }

    @Override
    public UserInfoVO shopRegister(UserDTO userDTO) {
        User user = UserConvertor.toUser(userDTO);
        return UserConvertor.toUserInfoVO(userBiz.shopRegister(user));
    }
}