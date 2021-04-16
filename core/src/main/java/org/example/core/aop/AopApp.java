package org.example.core.aop;

import org.example.core.aop.service.AopService;
import org.example.core.aop.service.TransactionalAopService;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AopApp {

    public static void main(String[] args) {
        ConfigurableApplicationContext applicationContext = new ClassPathXmlApplicationContext("application.xml");

        AopService aopService = applicationContext.getBean(AopService.class);
        TransactionalAopService transactionalAopService = applicationContext.getBean(TransactionalAopService.class);

        aopService.test();
        transactionalAopService.test();
    }
}
