package com.github.jinahya.juso.go.kr.api.proxy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;

@ConfigurationPropertiesScan(
        basePackageClasses = {
                com.github.jinahya.juso.go.kr.api.proxy._NoOp.class // not required; just for the documentation
        }
)
@SpringBootApplication(
        scanBasePackageClasses = {
                com.github.jinahya.juso.go.kr.api.proxy._NoOp.class // not required; just for the documentation
        }
)
class Application {

    public static void main(final String... args) {
        SpringApplication.run(Application.class, args);
    }
}
