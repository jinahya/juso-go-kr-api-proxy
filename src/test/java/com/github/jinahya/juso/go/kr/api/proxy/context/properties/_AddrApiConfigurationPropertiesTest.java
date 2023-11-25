package com.github.jinahya.juso.go.kr.api.proxy.context.properties;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.experimental.Accessors;
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

    // -----------------------------------------------------------------------------------------------------------------
    @Test
    void newHttpClient_NotNull_() {
        final var httpClient = propertiesInstance.newHttpClient();
        assertThat(httpClient).isNotNull();
    }

    // -----------------------------------------------------------------------------------------------------------------
    protected Class<PROPERTIES> propertiesClass;

    @Autowired
    @Accessors(fluent = true)
    @Getter(AccessLevel.PACKAGE)
    private PROPERTIES propertiesInstance;
}
