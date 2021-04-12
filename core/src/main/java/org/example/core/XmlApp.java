package org.example.core;

import lombok.extern.slf4j.Slf4j;
import org.example.core.beans.Bean1;
import org.example.core.beans.Extra;
import org.springframework.beans.factory.config.AutowireCapableBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Arrays;

@Slf4j
public class XmlApp {

    public static void main(String[] args) {
        ConfigurableApplicationContext applicationContext = new ClassPathXmlApplicationContext("application.xml", "services.xml");
        for (String beanDefinitionName : applicationContext.getBeanDefinitionNames()) {
            Object bean = applicationContext.getBean(beanDefinitionName);
            log.info("bean: {} - {}", beanDefinitionName, bean);
        }

        Object prototype = applicationContext.getBean("prototype");
        Object prototype1 = applicationContext.getBean("prototype");
        log.info("prototype : {} - {}", prototype, prototype1);

        //get bean by alias
        Bean1 bean1 = applicationContext.getBean("bean12", Bean1.class);
        log.info("alias bean : {}", bean1);

        applicationContext.registerShutdownHook();
        applicationContext.close();

        log.info("app close");
    }
}
