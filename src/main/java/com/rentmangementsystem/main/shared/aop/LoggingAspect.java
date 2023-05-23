package com.rentmangementsystem.main.shared.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

@Component
@Aspect
@Slf4j
public class LoggingAspect {


    @Pointcut(value = "execution(* com.rentmangementsystem.*.service.*.*(..))")
    public void loggingPointCut() {
    }


//    @Around("loggingPointCut()")
//    public void nd(ProceedingJoinPoint joinPoint) throws Throwable{
//
//        log.info("Before Method invoked::"+joinPoint.getSignature());
//
//
//        Object object= joinPoint.proceed();
//
//        log.info("After Method invoked::"+joinPoint.getSignature());
//
//
//    }

    @Before("loggingPointCut()")
    public void before(JoinPoint joinPoint) {

        log.info("Before Method invoked::" + joinPoint.getSignature());


    }

    @After("loggingPointCut()")
    public void after(JoinPoint joinPoint) {

        log.info("After Method invoked::" + joinPoint.getSignature());
        // Access the target object of the intercepted method
        Object targetObject = joinPoint.getTarget();



        // Get the list of called methods within the intercepted method
        Method[] methods = targetObject.getClass().getMethods();

        // Iterate over the methods and perform desired actions
        for (Method method : methods) {
            System.out.println("Called method: " + method.getName());

            // Perform additional actions with the called methods if needed
        }


    }

}