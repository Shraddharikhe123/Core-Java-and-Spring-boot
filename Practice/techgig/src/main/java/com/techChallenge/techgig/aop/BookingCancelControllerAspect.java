package com.techChallenge.techgig.aop;


import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class BookingCancelControllerAspect {

    @Before(value = "execution(* com.techChallenge.techgig.controller.BookingCancelController.*(..))")
    public void beforeAdvice(JoinPoint joinPoint){
        System.out.println("Before Method :"+joinPoint.getSignature());
    }

    @After(value = "execution(* com.techChallenge.techgig.controller.BookingCancelController.*(..))")
    public void afterAdvice(JoinPoint joinPoint){
        System.out.println("After Method : "+joinPoint.getSignature());
    }
}
