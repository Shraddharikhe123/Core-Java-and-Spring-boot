package com.techChallenge.techgig.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

/**
 * AOP for AvailableRoomController
 */
@Aspect
@Component
public class AvailableRoomControllerAspect {

    @Before(value = "execution(* com.techChallenge.techgig.controller.AvailableRoomController.*(..))")
    public void beforeAdvice(JoinPoint joinPoint){
        System.out.println("Before Method :"+joinPoint.getSignature());
    }

    @After(value = "execution(* com.techChallenge.techgig.controller.AvailableRoomController.*(..))")
    public void afterAdvice(JoinPoint joinPoint){
        System.out.println("After Method : "+joinPoint.getSignature());
    }


}
