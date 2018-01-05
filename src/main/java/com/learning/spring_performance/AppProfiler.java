package com.learning.spring_performance;

import java.lang.reflect.Method;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class AppProfiler {

    @Pointcut("execution(* com.learning.spring_performance.*.*(..))")
    public void monitor() {
    }

    @Around("monitor()")
    public Object profile(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        long start = System.currentTimeMillis();
        Object output = proceedingJoinPoint.proceed();
        long elapsedTime = System.currentTimeMillis() - start;

        MethodSignature signature = (MethodSignature) proceedingJoinPoint.getSignature();
        Method method = signature.getMethod();
        System.out.println(method.toString() + " \t execution time: " + elapsedTime + " milliseconds.");
        return output;
    }
}
