package org.example.core.aop.aspectj;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;

@Slf4j
@Aspect
public class AfterReturningExample {

    @AfterReturning(pointcut = "org.example.core.aop.aspectj.NotVeryUsefulAspect.anyPublic()",
    returning = "val")
    public void afterReturning(JoinPoint joinPoint, Object val){
        log.info("after return : {} - {}", joinPoint,val);
    }
}
