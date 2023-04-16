package com.example.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {

    @Before("execution(* com.example.aop.service.*.*(..))")
    public void logBefore(JoinPoint joinPoint) {
        System.out.println("开始执行方法: " + joinPoint.getSignature().getName());
    }

    @After("execution(* com.example.aop.service.*.*(..))")
    public void logAfter(JoinPoint joinPoint) {
        System.out.println("方法执行结束: " + joinPoint.getSignature().getName());
    }

    @AfterThrowing(pointcut = "execution(* com.example.aop.service.*.*(..))", throwing = "error")
    public void logAfterThrowing(JoinPoint joinPoint, Throwable error) {
        System.out.println("方法抛出异常: " + joinPoint.getSignature().getName());
        System.out.println("异常信息: " + error.getMessage());
    }
}
