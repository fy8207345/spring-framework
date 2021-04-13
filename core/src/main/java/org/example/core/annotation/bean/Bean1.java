package org.example.core.annotation.bean;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Bean1 {

    /**
     * close或者shutdown是默认的关闭回调方法
     */
    public void close(){
        log.info("closing");
    }

    public void shutdown(){
        log.info("shutting down");
    }
}
