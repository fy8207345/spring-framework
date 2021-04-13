package org.example.core.xml;

import lombok.extern.slf4j.Slf4j;
import org.example.core.xml.beans.Bean1;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@Slf4j
public class XmlApp {

    public static void main(String[] args) {
        ConfigurableApplicationContext applicationContext = new ClassPathXmlApplicationContext("application.xml", "services.xml");
        ConfigurableListableBeanFactory beanFactory = applicationContext.getBeanFactory();

        //代码注册的不按顺序执行
//        beanFactory.addBeanPostProcessor(new CustomPostProcessor2());
//        log.info("start refesh--------------------------------");
//        applicationContext.refresh();

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
