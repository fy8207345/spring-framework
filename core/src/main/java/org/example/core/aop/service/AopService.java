package org.example.core.aop.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Transactional
public class AopService {

    public void test(){
        log.info("test");
    }
}
