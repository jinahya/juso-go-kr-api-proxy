package com.github.jinahya.juso.go.kr.web.bind;

import java.util.Objects;

abstract class ControllerTest<CONTROLLER> {

    ControllerTest(final Class<CONTROLLER> controllerClass) {
        super();
        this.controllerClass = Objects.requireNonNull(controllerClass, "controllerClass is null");
    }

    protected final Class<CONTROLLER> controllerClass;
}
