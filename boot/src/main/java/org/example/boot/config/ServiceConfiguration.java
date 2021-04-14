package org.example.boot.config;

import org.example.boot.service.TestService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class ServiceConfiguration {

    @Bean
    @Primary
    public TestService serviceInConfiguration(){
        return new TestService();
    }
}
