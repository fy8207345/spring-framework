package org.example.core.annotation.bean;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationContext;
import org.springframework.core.env.Environment;

import javax.inject.Inject;
import javax.inject.Named;
import javax.inject.Provider;
import java.util.Arrays;
import java.util.Optional;

@Slf4j
public class Bean1 {

    private ApplicationContext applicationContext;
    private Provider<Environment> environmentProvider;
    private String string;

    @Inject
    public void setString(@Named("test") Optional<String> optional) {
        optional.ifPresent(s -> {
            this.string = s;
        });
    }

    @Inject
    public void setApplicationContext(ApplicationContext applicationContext) {
        this.applicationContext = applicationContext;
    }

    @Inject
    public void setEnvironmentProvider(Provider<Environment> environmentProvider) {
        this.environmentProvider = environmentProvider;
    }

    /**
     * close或者shutdown是默认的关闭回调方法
     */
    public void close(){
        log.info("closing : {} - {}", applicationContext, string);
    }

    public void shutdown(){
        log.info("shutting down");
    }

    public void work(){
        RuntimeException runtimeException = new RuntimeException();
        log.info("stack trace : {}", Arrays.toString(runtimeException.getStackTrace()));
    }
}
