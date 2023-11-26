package com.github.jinahya.juso.go.kr.api.proxy.context;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.experimental.Accessors;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
abstract class _AddrApiConfigurationSpringBootTest<CONFIGURATION extends _AddrApiConfiguration<?>>
        extends __AddrApiConfigurationTestBase<CONFIGURATION> {

    _AddrApiConfigurationSpringBootTest(final Class<CONFIGURATION> configurationClass) {
        super(configurationClass);
    }

    @Test
    void __() {

    }

    @Autowired
    @Accessors(fluent = true)
    @Getter(AccessLevel.PACKAGE)
    private CONFIGURATION configurationInstance;
}
