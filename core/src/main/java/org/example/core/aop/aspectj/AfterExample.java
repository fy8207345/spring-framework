package org.example.core.aop.aspectj;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;

@Slf4j
@Aspect
public class AfterExample {

    @After("org.example.core.aop.aspectj.NotVeryUsefulAspect.anyPublic()")
    public void after(JoinPoint joinPoint){
      log.info("after public method : {}", joinPoint);
    }
}
