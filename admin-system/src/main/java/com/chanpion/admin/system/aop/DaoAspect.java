package com.chanpion.admin.system.aop;

import com.chanpion.admin.common.utils.LogUtil;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

/**
 * @author April Chen
 * @date 2020/8/11 13:52
 */
@Aspect
public class DaoAspect {

    @Pointcut("execution(* com.chanpion.admin.system.dao.*.*(..))")
    public void pointcut() {
    }

    @Around("pointcut()")
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
        long begin = System.currentTimeMillis();
        String name = joinPoint.getSignature().getName();
        Object result;
        try {
            result = joinPoint.proceed();
        } finally {
            long end = System.currentTimeMillis();
            LogUtil.info("target:{}, method:{}, rt:{} ",joinPoint.getTarget(), name, end - begin);
        }
        return result;
    }
}
