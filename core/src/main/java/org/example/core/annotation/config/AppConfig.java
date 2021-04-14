package org.example.core.annotation.config;

import lombok.extern.slf4j.Slf4j;
import org.example.core.annotation.bean.Bean1;
import org.example.core.annotation.bean.TestBean;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.InjectionPoint;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.*;

@Slf4j
@Configuration
@ComponentScan(value = "org.example.core.annotation", nameGenerator = FullyQualifiedAnnotationBeanNameGenerator.class)
public class AppConfig {

    /**
     * 在@Configuration中调用@Bean的方法时，会被aop拦截;
     * 在@Component中的@Bean方法则不会
     */
    @Bean
    public Bean1 bean1InConfiguration(){
        RuntimeException runtimeException = new RuntimeException("create bean1InConfiguration");
        log.info("create bean : ", runtimeException);
        return new Bean1();
    }

    @Bean
    @Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
    public TestBean testBean(InjectionPoint injectionPoint){
        return new TestBean(injectionPoint);
    }

    /**
     * 静态方法的@Bean创建时，不需要创建它所作的配置类的实例；
     * {@link BeanPostProcessor}， {@link BeanFactoryPostProcessor}最好声明为 static
     * static的@Bean永远不会触发 Aop代理
     */
    @Bean
    public static BeanPostProcessor myBeanPostProcessor(){
        return new BeanPostProcessor() {
            @Override
            public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
                return BeanPostProcessor.super.postProcessBeforeInitialization(bean, beanName);
            }

            @Override
            public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
                return BeanPostProcessor.super.postProcessAfterInitialization(bean, beanName);
            }
        };
    }
}
