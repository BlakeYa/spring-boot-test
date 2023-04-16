package com.example.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class SecurityAspect {

    private boolean hasPermission = true; // 模拟权限标志

    @Before("execution(* com.example.aop.service.*.*(..))")
    public void checkPermission(JoinPoint joinPoint) {
        if (!hasPermission) {
            throw new RuntimeException("没有权限执行方法: " + joinPoint.getSignature().getName());
        }
    }
}
