package com.github.jinahya.juso.go.kr.api.proxy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@EnableAspectJAutoProxy
@ConfigurationPropertiesScan
@SpringBootApplication
class Application {

    public static void main(final String... args) {
        SpringApplication.run(Application.class, args);
    }
}
