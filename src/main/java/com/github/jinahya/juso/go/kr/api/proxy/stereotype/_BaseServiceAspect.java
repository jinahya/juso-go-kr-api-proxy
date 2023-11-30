package com.github.jinahya.juso.go.kr.api.proxy.stereotype;

import com.github.jinahya.juso.go.kr.api.proxy.stereotype.type._BaseResponseType;
import com.github.jinahya.juso.go.kr.api.proxy.stereotype.type._BaseType;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;

import java.util.Objects;

@Slf4j
abstract class _BaseServiceAspect<
        SERVICE extends _BaseService<REQUEST, RESPONSE>,
        REQUEST extends _BaseType,
        RESPONSE extends _BaseResponseType<?>> {

    _BaseServiceAspect(final Class<SERVICE> serviceClass) {
        super();
        this.serviceClass = Objects.requireNonNull(serviceClass, "serviceClass is null");
    }

    // https://stackoverflow.com/a/49080647/330457
    abstract Object __(ProceedingJoinPoint joinPoint, REQUEST request) throws Throwable;

    protected final Class<SERVICE> serviceClass;
}
