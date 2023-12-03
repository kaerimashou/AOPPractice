package org.ikonnikau.aoppractice.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.ikonnikau.aoppractice.entity.User;
import org.ikonnikau.aoppractice.util.CustomResponse;
import org.ikonnikau.aoppractice.util.CustomStatus;
import org.springframework.stereotype.Component;

import java.util.NoSuchElementException;

@Component
@Aspect
@Slf4j
public class CustomAspect {

    @Around("Pointcuts.allPostMethods()")
    public Object aroundPostAdvice(ProceedingJoinPoint joinPoint) {
        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        User user = null;
        if (methodSignature.getName().equals("addUser")) {
            Object[] args = joinPoint.getArgs();
            for(Object arg : args) {
                if (arg instanceof User) {
                    user = (User) arg;
                    log.info("ADDING USER {}", user);
                }
            }
        }
        Object result;
        try {
            result = joinPoint.proceed();
            log.info("USER {} ADDED", user);
        } catch (Throwable e) {
            log.error(e.getMessage(), e);
            result = new CustomResponse<>(null, CustomStatus.EXCEPTION);
        }
        return result;
    }

    @Around("Pointcuts.allFetchMethods()")
    public Object aroundFetchAdvice(ProceedingJoinPoint joinPoint) {
        Signature methodSignature = joinPoint.getSignature();
        String firstName = null;
        if (methodSignature.getName().equals("getAll")) {
            log.info("FETCHING ALL USERS");
        } else if (methodSignature.getName().equals("getUserByFirstName")) {
            Object[] args = joinPoint.getArgs();
            for (Object arg : args) {
                if (arg instanceof String) {
                    firstName = (String) arg;
                    log.info("FETCHING USER WITH FIRST NAME " + firstName);
                }
            }
        }

        Object result;
        try {
            result = joinPoint.proceed();
            log.info(firstName == null ?
              "FETCHING SUCCESS" :
              "FETCHING USER WITH FIRST NAME " + firstName + " SUCCESS");
        } catch (Throwable e) {
            log.error(e.getMessage(), e);
            result = new CustomResponse<>(null,
              e instanceof NoSuchElementException
                ? CustomStatus.NOT_FOUND
                : CustomStatus.EXCEPTION);
        }
        return result;
    }
}
