package com.github.jinahya.juso.go.kr.api.proxy.context;

import java.util.Objects;

abstract class __AddrApiConfigurationTestBase<CONFIGURATION extends _AddrApiConfiguration<?>> {

    __AddrApiConfigurationTestBase(final Class<CONFIGURATION> configurationClass) {
        super();
        this.configurationClass = Objects.requireNonNull(configurationClass, "configurationClass is null");
    }

    // -----------------------------------------------------------------------------------------------------------------
    final Class<CONFIGURATION> configurationClass;
}
