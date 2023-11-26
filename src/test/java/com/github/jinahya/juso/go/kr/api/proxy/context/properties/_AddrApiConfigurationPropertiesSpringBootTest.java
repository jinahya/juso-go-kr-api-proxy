package com.github.jinahya.juso.go.kr.api.proxy.context.properties;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.experimental.Accessors;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@Slf4j
abstract class _AddrApiConfigurationPropertiesSpringBootTest<PROPERTIES extends _AddrApiConfigurationProperties>
        extends __AddrApiConfigurationPropertiesTestBase<PROPERTIES> {

    _AddrApiConfigurationPropertiesSpringBootTest(final Class<PROPERTIES> propertiesClass) {
        super(propertiesClass);
    }

    // -----------------------------------------------------------------------------------------------------------------
    @Test
    void newHttpClient_NotNull_() {
        final var httpClient = propertiesInstance.newHttpClient();
        assertThat(httpClient).isNotNull();
    }

    // -----------------------------------------------------------------------------------------------------------------
    @Autowired
    @Accessors(fluent = true)
    @Getter(AccessLevel.PACKAGE)
    private PROPERTIES propertiesInstance;
}
