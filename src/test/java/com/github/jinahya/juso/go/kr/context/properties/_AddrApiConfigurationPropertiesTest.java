package com.github.jinahya.juso.go.kr.context.properties;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Objects;

import static org.assertj.core.api.Assertions.assertThat;

@Slf4j
abstract class _AddrApiConfigurationPropertiesTest<PROPERTIES extends _AddrApiConfigurationProperties> {

    _AddrApiConfigurationPropertiesTest(final Class<PROPERTIES> propertiesClass) {
        super();
        this.propertiesClass = Objects.requireNonNull(propertiesClass, "propertiesClass is null");
    }

    @Test
    void newHttpClient__() {
        final var httpClient = propertiesInstance.newHttpClient();
        assertThat(httpClient).isNotNull();
    }

    protected Class<PROPERTIES> propertiesClass;

    @Autowired
    private PROPERTIES propertiesInstance;
}
