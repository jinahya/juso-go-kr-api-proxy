package com.github.jinahya.juso.go.kr.context.properties;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Objects;

@SpringBootTest
@Slf4j
abstract class AbstractConfigurationPropertiesTest<PROPERTIES extends AbstractConfigurationProperties> {

    AbstractConfigurationPropertiesTest(final Class<PROPERTIES> propertiesClass) {
        super();
        this.propertiesClass = Objects.requireNonNull(propertiesClass, "propertiesClass is null");
    }

    @Test
    void __() {
        log.debug("properties: {}", properties);
    }

    protected Class<PROPERTIES> propertiesClass;

    @Autowired
    private PROPERTIES properties;
}
