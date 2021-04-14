package org.example.boot.controller;

import org.example.boot.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {


    @Autowired
    @Qualifier("serviceInConfiguration")
    public TestService serviceInConfiguration;

    @Autowired
    @Qualifier("serviceInComponent")
    public TestService serviceInComponent;

    @GetMapping("/component")
    public String component(){
        serviceInComponent.work();
        return "test";
    }

    @GetMapping("/configuration")
    public String configuration(){
        serviceInConfiguration.work();
        return "test";
    }
}
