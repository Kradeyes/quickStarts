package com.example.restservice.aspects;


import com.example.restservice.Greeting;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;


@Component
@Aspect
public class LoggingAspect {

    Logger logger = Logger.getLogger(LoggingAspect.class.getName());

    @Around(value = "execution(public com.example.restservice.Greeting greeting(..))")
    public Object aroundGreetingAdvice(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        Object[] args = proceedingJoinPoint.getArgs();
        Object result = proceedingJoinPoint.proceed();
        Greeting resultForLogs = (Greeting) proceedingJoinPoint.proceed();

        //Logging(not really nice cause of [])
     logger.log(Level.INFO,"Param for this iteration " + Arrays.toString(args) +
             " and result " + resultForLogs.getContent());

     return result;
    }
}
