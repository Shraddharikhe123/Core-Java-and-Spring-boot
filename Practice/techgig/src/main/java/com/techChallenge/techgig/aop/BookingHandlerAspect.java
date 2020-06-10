package com.techChallenge.techgig.aop;

import com.techChallenge.techgig.beans.IGenericVo;
import com.techChallenge.techgig.handler.AvailableRoomHandler;
import com.techChallenge.techgig.handler.BookingHandler;
import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import sun.rmi.server.InactiveGroupException;

@Aspect
@Component
public class BookingHandlerAspect {
    private static final Logger LOGGER = Logger.getLogger(BookingHandler.class);

    @Before(value = "execution(* com.techChallenge.techgig.handler.BookingHandler.*(..)))")
    public void beforeAdvice(JoinPoint joinPoint){
        LOGGER.info("Before Method :"+joinPoint.getSignature());

    }
    @AfterReturning(value="execution(* com.techChallenge.techgig.handler.BookingHandler.*(..))",returning="response")
    public void afterReturningAdvice(JoinPoint joinPoint, ResponseEntity response)
    {
        LOGGER.info("After Method : "+joinPoint.getSignature());
        LOGGER.info(joinPoint.getArgs().toString());
       LOGGER.info(response.toString());
    }

    @AfterThrowing(value = "execution(* com.techChallenge.techgig.handler.BookingHandler.*(..))",throwing="ex")
    public void afterThrowingException(JoinPoint joinPoint, Exception ex){
        LOGGER.info("After Throwing exception in method:"+joinPoint.getSignature());
        LOGGER.info("Exception is:"+ex.getMessage());
        LOGGER.info(ex.getCause());
    }
}
