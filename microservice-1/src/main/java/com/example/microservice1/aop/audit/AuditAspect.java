package com.example.microservice1.aop.audit;

import com.example.microservice1.messaging.producer.AuditNotificationService;
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

    @After("com.example.microservice1.aop.audit.AuditPointcuts.inController()")
    public void afterControllerMethod() {
        HttpServletRequest request =
                ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes())
                        .getRequest();
        StringBuilder builder = new StringBuilder();
        builder.append("method: ")
                .append(request.getMethod())
                .append(", url: ")
                .append(request.getServerName())
                .append(request.getServerPort())
                .append(request.getRequestURI());

        auditNotificationService.sendRequestInformation(builder.toString());
    }

}
