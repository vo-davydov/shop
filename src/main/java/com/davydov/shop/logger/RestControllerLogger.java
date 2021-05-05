package com.davydov.shop.logger;

import com.davydov.shop.dto.JwtRequest;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class RestControllerLogger {

  @Around("execution(public * com.davydov.shop.controllers.AuthController.*(..))")
  public void methodProfiling(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
    System.out.println("start profiling");
    long begin = System.currentTimeMillis();
    Object[] args = proceedingJoinPoint.getArgs();
    proceedingJoinPoint.proceed();
    if (args.length > 0) {
      System.out.println("Аргументы:");
      for (Object o : args) {
        JwtRequest jwtRequest =(JwtRequest)  o;
        System.out.println(o.toString());
      }
    }
    long end = System.currentTimeMillis();
    long duration = end - begin;

    System.out.println((MethodSignature) proceedingJoinPoint.getSignature() + " duration: " + duration);
    System.out.println("end profiling");
  }
}
