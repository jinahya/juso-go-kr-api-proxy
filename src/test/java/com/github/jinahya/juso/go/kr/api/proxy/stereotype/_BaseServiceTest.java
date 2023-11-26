package com.github.jinahya.juso.go.kr.api.proxy.stereotype;

public abstract class _BaseServiceTest<SERVICE extends _BaseService>
        extends __BaseServiceTestBase<SERVICE> {

    protected _BaseServiceTest(final Class<SERVICE> serviceClass) {
        super(serviceClass);
    }
}
