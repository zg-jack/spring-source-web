package com.zhuguang.jack.aop.aspect;

import com.zhuguang.jack.annotation.TargetMethod;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Service;

@Service
@Aspect
public class AspectAnnotation {

    @Pointcut("execution(public * com.zhuguang.jack.service.*.*(..))")
    public void pc1(){}

    @Before("pc1()")
    public void before(JoinPoint joinPoint) {
        System.out.println("==============AspectAnnotation 前置通知=========");
    }

    @After("pc1()")
    public void after(JoinPoint joinPoint) {
        System.out.println("==============AspectAnnotation 后置通知=========");
    }

    @Around("pc1()")
    public void around(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("==============AspectAnnotation around前置通知=========");
        joinPoint.proceed();
        System.out.println("==============AspectAnnotation around后置通知=========");
    }

    @Before(value = "@annotation(targetMethod)",argNames = "joinPoint,targetMethod")
    public void xx(JoinPoint joinPoint, TargetMethod targetMethod) {
        System.out.println("===============注解拦截 前置通知=========");
        System.out.println("==================targetMethod.name = " + targetMethod.name());
    }

    @Before(value = "pc1()&&@annotation(targetMethod)",argNames = "joinPoint,targetMethod")
    public void aa(JoinPoint joinPoint,TargetMethod targetMethod) {
        System.out.println("===============注解拦截 前置通知=========");
        System.out.println("==================targetMethod.name = " + targetMethod.name());
    }
}
