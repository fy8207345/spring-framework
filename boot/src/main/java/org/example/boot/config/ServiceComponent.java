package org.example.boot.config;

import org.example.boot.service.TestService;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class ServiceComponent {

    @Bean
    public TestService serviceInComponent(){
        return new TestService();
    }
}
