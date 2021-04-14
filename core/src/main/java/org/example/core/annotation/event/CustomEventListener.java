package org.example.core.annotation.event;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class CustomEventListener implements ApplicationListener<CustomEvent> {
    @Override
    public void onApplicationEvent(CustomEvent event) {
        log.info("recevied event : {}", event);
    }

    @EventListener
    public void onReceive(CustomEvent customEvent){
        log.info("onReceive : {}", customEvent);
    }
}
