package com.chanpion.admin.system.aop;

import com.chanpion.admin.common.utils.LogUtil;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

/**
 * @author April Chen
 * @date 2020/8/12 19:55
 */
@Aspect
public class ServiceAspect {

    @Pointcut("execution(* com.chanpion.admin.system.service.*.*(..))")
    public void pointcut(){

    }

    @Around("pointcut()")
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("aop");
        long begin = System.currentTimeMillis();
        String name = joinPoint.getSignature().getName();
        Object result;
        try {
            result = joinPoint.proceed();
        } finally {
            long end = System.currentTimeMillis();
            LogUtil.info("method:{},rt:{}", name, end - begin);
        }
        return result;
    }
}
