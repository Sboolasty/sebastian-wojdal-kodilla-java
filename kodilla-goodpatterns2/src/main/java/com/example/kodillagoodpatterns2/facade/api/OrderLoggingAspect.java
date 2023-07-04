package com.example.kodillagoodpatterns2.facade.api;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Aspect
@Component
public class OrderLoggingAspect {

    private static final Logger LOGGER = LoggerFactory.getLogger(OrderLoggingAspect.class);

    @After("execution(* com.example.kodillagoodpatterns2.facade.api.OrderFacade.processOrder(..))")
    public void logProcessOrder(JoinPoint joinPoint) {
        LOGGER.info("Method processOrder() was called.");
        LOGGER.info("Arguments: " + Arrays.toString(joinPoint.getArgs()));
        LOGGER.info("Logging any additional information you want to include in the log.");
    }
}
