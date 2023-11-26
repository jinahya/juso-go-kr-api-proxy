package com.github.jinahya.juso.go.kr.api.proxy.web.bind;

import lombok.extern.slf4j.Slf4j;

import java.util.Objects;

@Slf4j
abstract class __BaseControllerTestBase<CONTROLLER extends _BaseController> {

    __BaseControllerTestBase(final Class<CONTROLLER> controllerClass) {
        super();
        this.controllerClass = Objects.requireNonNull(controllerClass, "controllerClass is null");
    }

    // -----------------------------------------------------------------------------------------------------------------
    protected final Class<CONTROLLER> controllerClass;
}
