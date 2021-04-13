package org.example.core.xml.aware;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.weaving.LoadTimeWeaverAware;
import org.springframework.instrument.classloading.LoadTimeWeaver;

@Slf4j
public class MyLoadTimeWeaverAware implements LoadTimeWeaverAware {
    @Override
    public void setLoadTimeWeaver(LoadTimeWeaver loadTimeWeaver) {
        log.info("loadtime : {}", loadTimeWeaver);
    }
}
