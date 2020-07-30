package com.suyan.mall.operation.async;

import com.suyan.mall.operation.annotation.SysLog;
import com.suyan.mall.operation.feignClient.SystemLogFeignClient;
import com.suyan.mall.operation.req.SystemLogDTO;
import com.suyan.mall.user.resp.b.UserInfoVO;
import com.suyan.result.Result;
import com.suyan.utils.IpUtil;
import com.suyan.utils.JsonUtil;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;

@Service
@Slf4j
public class SystemLogAsync {

    @Autowired
    private SystemLogFeignClient systemLogFeignClient;

    @Async
    public void add(ProceedingJoinPoint joinPoint, long time, UserInfoVO userInfoVO, HttpServletRequest request) {
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        Method method = signature.getMethod();

        SystemLogDTO sysLog = new SystemLogDTO();
        // 用户
        sysLog.setUniqueUserId(userInfoVO.getUniqueUserId());
        sysLog.setUserName(userInfoVO.getUserName());
        sysLog.setNickName(userInfoVO.getNickName());
        sysLog.setShopId(userInfoVO.getShopId());
        // 执行时长(毫秒)
        sysLog.setExecutionTime(time);
        SysLog syslog = method.getAnnotation(SysLog.class);
        if (syslog != null) {
            //注解上的描述
            sysLog.setOperate(syslog.value());
        }

        // 请求的方法名
        String className = joinPoint.getTarget().getClass().getName();
        String methodName = signature.getName();
        sysLog.setMethod(className + "." + methodName + "()");

        // 请求的参数
        Object[] args = joinPoint.getArgs();
        String params = JsonUtil.toJsonString(args[0]);
        sysLog.setParams(params);

        // 设置IP地址
        sysLog.setIp(IpUtil.getIpAddress(request));

        // 保存系统日志
        try {
            Result<Long> result = systemLogFeignClient.add(sysLog);
            log.info("{}", result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
