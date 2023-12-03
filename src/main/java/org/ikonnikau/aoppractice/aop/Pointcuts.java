package org.ikonnikau.aoppractice.aop;

import org.aspectj.lang.annotation.Pointcut;

public class Pointcuts {
    @Pointcut("execution(* org.ikonnikau.aoppractice.service.UserService.get*(..))")
    public void allFetchMethods() {}

    @Pointcut("execution(* org.ikonnikau.aoppractice.service.UserService.add*(..))")
    public void allPostMethods() {}
}
