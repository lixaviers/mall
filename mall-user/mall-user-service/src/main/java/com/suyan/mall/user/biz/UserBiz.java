package com.suyan.mall.user.biz;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.suyan.exception.CommonException;
import com.suyan.mall.user.dao.UserMapper;
import com.suyan.mall.user.enums.CommonStatusEnum;
import com.suyan.mall.user.enums.UserSourceEnum;
import com.suyan.mall.user.model.User;
import com.suyan.mall.user.model.UserExample;
import com.suyan.mall.user.req.UserQueryDTO;
import com.suyan.query.QueryResultVO;
import com.suyan.result.ResultCode;
import com.suyan.utils.CodeGeneratorUtil;
import com.suyan.utils.CollectionsUtil;
import com.suyan.utils.PasswordEncoderUtil;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;

/**
 * @CopyRright (c): <素焉代码生成工具>
 * @Comments: <业务层用户管理类>
 * @jdk 1.8
 * @Version: <1.0>
 */
@Service
@Slf4j
public class UserBiz {
    private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private PasswordEncoderUtil passwordEncoderUtil;


    /**
     * 删除用户
     *
     * @param id
     * @return
     */
    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, rollbackFor = Exception.class)
    public Integer deleteUser(Long id) {
        getBaseUser(id);
        return userMapper.deleteByPrimaryKey(id);
    }

    /**
     * 创建用户
     *
     * @param user
     * @return
     */
    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, rollbackFor = Exception.class)
    public Long createUser(User user) {
        user.setUserPwd(passwordEncoderUtil.encode(user.getUserPwd()));
        userMapper.insertSelective(user);
        return user.getId();
    }

    /**
     * 批量创建
     *
     * @param userList
     * @return
     */
    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, rollbackFor = Exception.class)
    public int batchCreateUser(List<User> userList) {
        return userMapper.insertBatch(userList);
    }

    /**
     * 更新用户
     *
     * @param user
     * @return
     */
    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, rollbackFor = Exception.class)
    public Integer updateUser(User user) {
        getBaseUser(user.getId());
        return userMapper.updateByPrimaryKeySelective(user);
    }

    /**
     * 根据ID获取用户信息
     *
     * @param id
     * @return
     */
    @Transactional(readOnly = true)
    public User getUser(Long id) {
        return getBaseUser(id);
    }

    @Transactional(readOnly = true)
    public User getBaseUser(Long id) {
        User user = userMapper.selectByPrimaryKey(id);
        if (user == null || user.getIsDeleted()) {
            throw new CommonException(ResultCode.DATA_NOT_EXIST, "用户");
        }
        return user;
    }

    /**
     * 分页查询用户信息
     *
     * @param userQuery
     * @return
     */
    @Transactional(readOnly = true)
    public QueryResultVO<User> queryUser(UserQueryDTO userQuery) {
        QueryResultVO<User> queryResult = new QueryResultVO<User>();
        // 使用分页插件PageHelper实现分页功能
        PageHelper.startPage(userQuery.getPageNo(), userQuery.getPageSize());
        List<User> userList = userMapper.queryUser(userQuery);
        PageInfo<User> pageInfo = new PageInfo<User>(userList);
        queryResult.setPageNo(pageInfo.getPageNum());
        queryResult.setPageSize(pageInfo.getPageSize());
        queryResult.setTotalPages(pageInfo.getPages());
        queryResult.setTotalRecords(pageInfo.getTotal());
        queryResult.setRecords(userList);
        return queryResult;
    }

    /**
     * 用户登录
     *
     * @param user
     * @return
     */
    @Transactional(readOnly = true)
    public User userLogin(User user) {
        User userLast = getUserByUserName(UserSourceEnum.USER.getValue(), user.getMobile());
        if (Objects.isNull(userLast)) {
            throw new CommonException(ResultCode.DATA_NOT_EXIST, "手机号");
        }
        if (!passwordEncoderUtil.matches(user.getUserPwd(), userLast.getUserPwd())) {
            throw new CommonException(ResultCode.LOGIN_ERROR);
        }
        if (CommonStatusEnum.DISABLE.equal(userLast.getUserStatus())) {
            throw new CommonException(ResultCode.USER_DISABLE_ERROR);
        }
        return userLast;
    }

    /**
     * 商户登录
     *
     * @param user
     * @return
     */
    @Transactional(readOnly = true)
    public User shopLogin(User user) {
        User userLast = getUserByUserName(UserSourceEnum.SHOP.getValue(), user.getMobile());
        if (userLast == null) {
            throw new CommonException(ResultCode.DATA_NOT_EXIST, "手机号");
        }
        if (!passwordEncoderUtil.matches(user.getUserPwd(), userLast.getUserPwd())) {
            throw new CommonException(ResultCode.LOGIN_ERROR);
        }
        if (CommonStatusEnum.DISABLE.equal(userLast.getUserStatus())) {
            throw new CommonException(ResultCode.USER_DISABLE_ERROR);
        }
        return userLast;
    }

    /**
     * 商户注册
     *
     * @param user
     * @return
     */
    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, rollbackFor = Exception.class)
    public User shopRegister(User user) {
        User userLast = getUserByMobile(UserSourceEnum.SHOP.getValue(), user.getMobile());
        if (userLast != null) {
            throw new CommonException(ResultCode.DATA_EXIST, "手机号");
        }
        user.setUniqueUserId(generateUniqueUserId());
        user.setUserPwd(passwordEncoderUtil.encode(user.getUserPwd()));
        user.setUserStatus(CommonStatusEnum.NORMAL.getValue());
        // 账号为手机号
        user.setUserName(user.getMobile());
        user.setNickName("素焉商城用户");
        user.setUserSource(UserSourceEnum.SHOP.getValue());
        userMapper.insertSelective(user);
        return user;
    }

    /**
     * 生成用户唯一标识
     *
     * @return
     */
    public String generateUniqueUserId() {
        String uniqueUserId;
        User user;
        do {
            uniqueUserId = CodeGeneratorUtil.generateUniqueUserId();
            user = userMapper.selectByUniqueUserId(uniqueUserId);
        } while (user != null);
        return uniqueUserId;
    }

    /**
     * 根据手机号查询用户是否存在
     *
     * @param userSource
     * @param mobile
     * @return
     */
    @Transactional(readOnly = true)
    public User getUserByMobile(Byte userSource, String mobile) {
        UserExample example = new UserExample();
        example.createCriteria().andMobileEqualTo(mobile).andUserSourceEqualTo(userSource).andIsDeletedEqualTo(false);
        List<User> userList = userMapper.selectByExample(example);
        if (CollectionsUtil.isEmpty(userList)) {
            return null;
        }
        return userList.get(0);
    }

    /**
     * 根据用户名查询用户是否存在
     *
     * @param userSource
     * @param userName
     * @return
     */
    @Transactional(readOnly = true)
    public User getUserByUserName(Byte userSource, String userName) {
        UserExample example = new UserExample();
        example.createCriteria().andUserNameEqualTo(userName).andUserSourceEqualTo(userSource).andIsDeletedEqualTo(false);
        List<User> userList = userMapper.selectByExample(example);
        if (CollectionsUtil.isEmpty(userList)) {
            return null;
        }
        return userList.get(0);
    }

}