package org.example.core.aop.aspectj;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Slf4j
@Aspect
public class BeforeExample {

    @Before("org.example.core.aop.aspectj.NotVeryUsefulAspect.anyPublic()")
    public void doCheck(JoinPoint joinPoint){
        log.info("public method invoked : {}", joinPoint);
    }
}
