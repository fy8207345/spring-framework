package org.example.core.aop.aspectj;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Slf4j
@Aspect
public class NotVeryUsefulAspect {

    @Pointcut("execution(* transfer(..))")
    private void anyTransfer(){
    }

    @Pointcut("execution(public * *(..))")
    public void anyPublic(){
    }

    @Pointcut("within(org.example.core.aop..*)")
    private void inTrading(){
    }

    @Pointcut("anyPublic() && inTrading()")
    private void publicTrading(){
    }

    @Pointcut("execution(* set*(..))")
    public void setMethod(){}

    @Pointcut("execution(* org.example.core.aop.config.AopConfig.*(..))")
    public void anyMethodInAClass(){}

    @Pointcut("execution(* org.example.core.aop.config.*.*(..))")
    public void anyMethodInConfigPackage(){}

    @Pointcut("execution(* org.example.core.aop..*.*(..))")
    public void anyMethodInPackageAndSubPackages(){}

    @Pointcut("within(org.example.core.aop.*)")
    public void anyMethodInPackage(){}

    /**
     * 所有实现该接口的子类
     */
    @Pointcut("this(java.io.Serializable)")
    public void implementedClasses(){}

    /**
     * 运行时是Serializable就会匹配
     */
    @Pointcut("args(java.io.Serializable)")
    public void args(){}

    /**
     * 方法声明是Serializable
     */
    @Pointcut("execution(* *(java.io.Serializable))")
    public void execution(){}

    @Pointcut("@target(org.springframework.transaction.annotation.Transactional)")
    public void annotationOnClass(){ }

    @Before("annotationOnClass()")
    public void before1(JoinPoint joinPoint){
        log.info("annotationOnClass : {}", joinPoint);
    }

}
