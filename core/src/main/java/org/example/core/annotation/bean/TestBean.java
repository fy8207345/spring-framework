package org.example.core.annotation.bean;

import lombok.ToString;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.InjectionPoint;

@Slf4j
@ToString
public class TestBean {

    private InjectionPoint injectionPoint;

    public TestBean(InjectionPoint injectionPoint) {
        this.injectionPoint = injectionPoint;
        log.info("injectionPoint : {}", injectionPoint);
    }
}
