package com.github.jinahya.juso.go.kr.api.proxy.context.properties;

import lombok.extern.slf4j.Slf4j;

import java.util.Objects;

@Slf4j
abstract class __AddrApiConfigurationPropertiesTestBase<PROPERTIES extends _AddrApiConfigurationProperties> {

    __AddrApiConfigurationPropertiesTestBase(final Class<PROPERTIES> propertiesClass) {
        super();
        this.propertiesClass = Objects.requireNonNull(propertiesClass, "propertiesClass is null");
    }

    // -----------------------------------------------------------------------------------------------------------------
    protected Class<PROPERTIES> propertiesClass;
}
