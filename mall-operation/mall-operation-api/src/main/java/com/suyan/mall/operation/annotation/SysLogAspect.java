package com.suyan.mall.operation.annotation;

import com.suyan.mall.operation.async.SystemLogAsync;
import com.suyan.mall.user.utils.UserUtil;
import com.suyan.utils.HttpContextUtil;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 系统日志，切面处理类
 */
@Aspect
@Component
public class SysLogAspect {
    @Autowired
    private SystemLogAsync systemLogAsync;

    @Pointcut("@annotation(com.suyan.mall.operation.annotation.SysLog)")
    public void logPointCut() {

    }

    @Around("logPointCut()")
    public Object around(ProceedingJoinPoint point) throws Throwable {
        long beginTime = System.currentTimeMillis();
        //执行方法
        Object result = point.proceed();
        //执行时长(毫秒)
        long time = System.currentTimeMillis() - beginTime;

        //保存日志
        systemLogAsync.add(point, time, UserUtil.getShopUser(), HttpContextUtil.getHttpServletRequest());

        return result;
    }

}