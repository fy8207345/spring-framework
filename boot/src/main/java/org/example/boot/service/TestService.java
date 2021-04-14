package org.example.boot.service;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class TestService {

    public void work(){
        throw new RuntimeException("test exception");
    }
}
