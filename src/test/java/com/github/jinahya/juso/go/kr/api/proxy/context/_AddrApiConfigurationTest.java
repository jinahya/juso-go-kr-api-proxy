package com.github.jinahya.juso.go.kr.api.proxy.context;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.experimental.Accessors;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Objects;

abstract class _AddrApiConfigurationTest<CONFIGURATION extends _AddrApiConfiguration<?>> {

    _AddrApiConfigurationTest(final Class<CONFIGURATION> configurationClass) {
        super();
        this.configurationClass = Objects.requireNonNull(configurationClass, "configurationClass is null");
    }

    @Test
    void __() {
    }

    final Class<CONFIGURATION> configurationClass;

    @Autowired
    @Accessors(fluent = true)
    @Getter(AccessLevel.PROTECTED)
    private CONFIGURATION configurationInstance;
}
