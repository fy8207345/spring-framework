package org.example.core.annotation.config;

import lombok.extern.slf4j.Slf4j;
import org.example.core.annotation.bean.Bean1;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Slf4j
@Component
public class BeanInComponent {

    /**
     * 在@Configuration中调用@Bean的方法时，会被aop拦截;
     * 在@Component中的@Bean方法则不会
     */
    @Bean
    public Bean1 bean1InComponent(){
        RuntimeException runtimeException = new RuntimeException("create bean1InComponent");
        log.info("create bean : ", runtimeException);
        return new Bean1();
    }
}
