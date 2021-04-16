package org.example.core.aop.service;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class TransactionalAopService implements TransactionalInterface{

    public void test(){
        log.info("test");
    }
}
