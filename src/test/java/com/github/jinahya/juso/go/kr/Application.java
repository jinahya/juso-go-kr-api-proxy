package com.github.jinahya.juso.go.kr;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//@ConfigurationPropertiesScan//(basePackageClasses = {_NoOp.class})
public class Application {

    public static void main(final String... args) {
        SpringApplication.run(Application.class, args);
    }
}
