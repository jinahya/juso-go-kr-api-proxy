package com.github.jinahya.juso.go.kr.api.proxy.stereotype;

import java.util.Objects;

abstract class __BaseServiceTestBase<SERVICE extends _BaseService> {

    __BaseServiceTestBase(final Class<SERVICE> serviceClass) {
        super();
        this.serviceClass = Objects.requireNonNull(serviceClass, "serviceClass is null");
    }

    protected final Class<SERVICE> serviceClass;
}
