package com.techChallenge.techgig.aop;
import com.techChallenge.techgig.handler.AvailableRoomHandler;
import org.apache.log4j.Logger;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

/**
 * AOP for AvailableRoomHandlerAspect
 */
@Aspect
@Component
public class AvailableRoomHandlerAspect {
    private static final Logger LOGGER = Logger.getLogger(AvailableRoomHandler.class);

    @Before(value = "execution(* com.techChallenge.techgig.handler.AvailableRoomHandler.*(..))")
    public void beforeAdvice(JoinPoint joinPoint){
        LOGGER.info("Before Method :"+joinPoint.getSignature());
    }

    @After(value = "execution(* com.techChallenge.techgig.handler.AvailableRoomHandler.*(..))")
    public void afterAdvice(JoinPoint joinPoint){
        LOGGER.info("After Method : "+joinPoint.getSignature());
        LOGGER.info(joinPoint.getArgs().toString());

    }
    @AfterThrowing(value = "execution(* com.techChallenge.techgig.handler.AvailableRoomHandler.*(..))",throwing="ex")
    public void afterThrowingException(JoinPoint joinPoint,Exception ex){
        LOGGER.info("After Throwing exception in method:"+joinPoint.getSignature());
        LOGGER.info("Exception is:"+ex.getMessage());
        LOGGER.info(ex.getCause());
    }

}
