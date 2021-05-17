package com.davydov.shop.logger;

import com.davydov.shop.dto.JwtRequest;
import org.aspectj.lang.ProceedingJoinPoint;
import org.slf4j.Logger;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class RestControllerLogger {

  private final static Logger logger = LoggerFactory.getLogger(RestControllerLogger.class);

  @Around("execution(public * com.davydov.shop.controllers.AuthController.*(..))")
  public void methodProfiling(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
    logger.debug("start profiling");
    long begin = System.currentTimeMillis();
    Object[] args = proceedingJoinPoint.getArgs();
    proceedingJoinPoint.proceed();
    if (args.length > 0) {
      logger.debug("Arguments:");
      for (Object o : args) {
        JwtRequest jwtRequest = (JwtRequest) o;
        logger.debug(o.toString());
      }
    }
    long end = System.currentTimeMillis();
    long duration = end - begin;

    logger.debug((MethodSignature) proceedingJoinPoint.getSignature() + " duration: " + duration);
    logger.debug("end profiling");
  }
}
