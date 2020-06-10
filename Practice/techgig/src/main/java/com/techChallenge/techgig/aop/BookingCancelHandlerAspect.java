package com.techChallenge.techgig.aop;

import com.techChallenge.techgig.handler.BookingCancelHandler;
import com.techChallenge.techgig.handler.BookingHandler;
import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class BookingCancelHandlerAspect {

    private static final Logger LOGGER = Logger.getLogger(BookingCancelHandler.class);


   @Before(value = "execution(* com.techChallenge.techgig.handler.BookingCancelHandler.*(..))) and args(referenceId)")
    public void beforeAdvice(JoinPoint joinPoint){
        LOGGER.info("Before Method :"+joinPoint.getSignature());


    }
    @AfterReturning(value="execution(* com.techChallenge.techgig.handler.BookingCancelHandler.*(..))",returning="response")
    public void afterReturningAdvice(JoinPoint joinPoint, ResponseEntity response)
    {
        LOGGER.info("After Method : "+joinPoint.getSignature());
        LOGGER.info(joinPoint.getArgs().toString());
        LOGGER.info(response.toString());
    }

    @AfterThrowing(value = "execution(* com.techChallenge.techgig.handler.BookingCancelHandler.*(..))",throwing="ex")
    public void afterThrowingException(JoinPoint joinPoint, Exception ex){
        LOGGER.info("After Throwing exception in method:"+joinPoint.getSignature());
        LOGGER.info("Exception is:"+ex.getMessage());
        LOGGER.info(ex.getCause());
    }
}
