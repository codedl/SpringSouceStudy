package com.example.springsource.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class PointCut {

    public PointCut() {
    }

    @Pointcut("execution(* com.example.springsource.pojo.AdviserUser.*(..))")
    void pointcut(){
    }

    void test(){
        System.out.println("test");
    }

    @Before("pointcut()")
    void logBefore(JoinPoint joinPoint){
        System.out.println("@Before:"+joinPoint.getSignature().getName());
    }

    @After("pointcut()")
    void logAfter(JoinPoint joinPoint){
        Object[] args = joinPoint.getArgs();
        System.out.println("@After:"+joinPoint.getSignature().getName()+";args:"+args);
    }

    @Around("pointcut()")
     Object around(ProceedingJoinPoint joinPoint) throws Throwable {
        Object[] args = joinPoint.getArgs();
        System.out.println("@Around前..."+joinPoint.getSignature().getName()+";args:"+args);
        Object result = joinPoint.proceed();
        System.out.println("@Around后..."+joinPoint.getSignature().getName()+";args:"+args);
        return result;
    }

    @AfterReturning(value = "pointcut()",returning = "ret")
    void afterReturn(Object ret){
        System.out.println("@AfterReturning....");
    }

    @AfterThrowing(value="pointcut()",throwing = "ex")
    void afterThrowing(Throwable ex){
        System.out.println("@AfterThrowing....");
    }
}
