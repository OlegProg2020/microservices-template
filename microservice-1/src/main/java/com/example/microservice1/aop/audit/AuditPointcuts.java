package com.example.microservice1.aop.audit;

import org.aspectj.lang.annotation.Pointcut;

public class AuditPointcuts {

    @Pointcut("execution(public * com.example.microservice1.web.controller.*.*(..))")
    public void inController() {}

}
