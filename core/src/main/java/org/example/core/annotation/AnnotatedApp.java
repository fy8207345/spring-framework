package org.example.core.annotation;

import org.example.core.annotation.bean.Bean1;
import org.example.core.annotation.bean.TestBean;
import org.example.core.annotation.config.AppConfig;
import org.example.core.annotation.config.BeanInComponent;
import org.example.core.annotation.event.CustomEventPublisher;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AnnotatedApp {

    public static void main(String[] args) {
        ConfigurableApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class, BeanInComponent.class);
        applicationContext.start();

        Bean1 beanInConfiguration = applicationContext.getBean("bean1InConfiguration", Bean1.class);
        Bean1 beanInComponent = applicationContext.getBean("bean1InComponent", Bean1.class);
        beanInConfiguration.work();
        beanInComponent.work();

        CustomEventPublisher bean = applicationContext.getBean(CustomEventPublisher.class);
        bean.sendCustomEvent("test event");

        applicationContext.close();
    }
}
