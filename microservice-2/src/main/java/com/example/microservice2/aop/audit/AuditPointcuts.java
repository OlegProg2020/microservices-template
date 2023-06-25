package com.example.microservice2.aop.audit;

import org.aspectj.lang.annotation.Pointcut;

public class AuditPointcuts {

    @Pointcut("execution(public * com.example.microservice2.web.controller.*.*(..))")
    public void inController() {}

}
