package com.suyan.mall.user.service.impl;

import com.suyan.mall.user.biz.AdminBiz;
import com.suyan.mall.user.convertor.AdminConvertor;
import com.suyan.mall.user.req.AdminDTO;
import com.suyan.mall.user.req.AdminQueryDTO;
import com.suyan.mall.user.resp.AdminVO;
import com.suyan.mall.user.resp.b.UserInfoVO;
import com.suyan.mall.user.service.IAdminService;
import com.suyan.query.QueryResultVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;


/**
 * @CopyRright (c): <素焉代码生成工具>
 * @Comments: <Service 管理员管理类>
 */
@Slf4j
@Service("adminService")
public class AdminServiceImpl implements IAdminService {

    @Autowired
    private AdminBiz adminBiz;

    @Override
    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, rollbackFor = Exception.class)
    public int deleteAdmin(Long id) {
        return adminBiz.deleteAdmin(id);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, rollbackFor = Exception.class)
    public Long createAdmin(AdminDTO adminDTO) {
        return adminBiz.createAdmin(AdminConvertor.toAdmin(adminDTO));
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, rollbackFor = Exception.class)
    public int updateAdmin(AdminDTO adminDTO) {
        return adminBiz.updateAdmin(AdminConvertor.toAdmin(adminDTO));
    }

    @Override
    @Transactional(readOnly = true)
    public AdminVO getAdmin(Long id) {
        return AdminConvertor.toAdminVO(adminBiz.getAdmin(id));
    }

    @Override
    @Transactional(readOnly = true)
    public QueryResultVO<AdminVO> queryAdmin(AdminQueryDTO adminQueryDTO) {
        return AdminConvertor.toQueryResult(adminBiz.queryAdmin(adminQueryDTO));
    }

    @Override
    @Transactional(readOnly = true)
    public UserInfoVO login(AdminDTO adminDTO) {
        return AdminConvertor.toUserInfoVO(adminBiz.login(AdminConvertor.toAdmin(adminDTO)));
    }

}