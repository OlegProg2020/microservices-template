package com.example.microservice2.aop.audit;

import com.example.microservice2.messaging.producer.AuditNotificationService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

@Aspect
@Component
@RequiredArgsConstructor
public class AuditAspect {

    private final AuditNotificationService auditNotificationService;

    @After("com.example.microservice2.aop.audit.AuditPointcuts.inController()")
    public void afterControllerMethod() {
        HttpServletRequest request =
                ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes())
                        .getRequest();
        String information = "method: " +
                request.getMethod() +
                ", url: " +
                request.getServerName() +
                request.getServerPort() +
                request.getRequestURI();

        auditNotificationService.sendRequestInformation(information);
    }

}
