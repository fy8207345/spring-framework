package org.example.core.lifecycle;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.Lifecycle;
import org.springframework.context.LifecycleProcessor;
import org.springframework.context.SmartLifecycle;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Slf4j
public class LifecycleBean implements InitializingBean, DisposableBean, SmartLifecycle, LifecycleProcessor {

    private boolean running;

    @Override
    public void afterPropertiesSet() throws Exception {
        log.info("afterPropertiesSet");
    }

    @Override
    public void destroy() throws Exception {
        log.info("destroy");
    }

    @PostConstruct
    public void init(){
        log.info("init");
    }

    @PreDestroy
    public void destory(){
        log.info("destory");
    }

    @Override
    public void onRefresh() {
        log.info("onRefresh");
    }

    @Override
    public void onClose() {
        log.info("onClose");
    }

    @Override
    public void start() {
        log.info("start");
        running = true;
    }

    @Override
    public void stop() {
        log.info("stop");
        running = false;
    }

    @Override
    public boolean isRunning() {
        log.info("isRunning : {}", running);
        return running;
    }

    @Override
    public void stop(Runnable callback) {
        SmartLifecycle.super.stop(callback);
        log.info("stop : {}", callback);
    }
}
