package com.example.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class TransactionAspect {

    @Around("execution(* com.example.aop.service.*.*(..))")
    public Object manageTransaction(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("开始事务");
        Object result;
        try {
            result = joinPoint.proceed();
            System.out.println("提交事务");
        } catch (Exception e) {
            System.out.println("回滚事务");
            throw e;
        }
        return result;
    }
}
