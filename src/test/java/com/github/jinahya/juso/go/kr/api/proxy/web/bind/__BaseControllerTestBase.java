package com.github.jinahya.juso.go.kr.api.proxy.web.bind;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Arrays;
import java.util.Objects;

@Slf4j
abstract class __BaseControllerTestBase<CONTROLLER extends _BaseController> {

    __BaseControllerTestBase(final Class<CONTROLLER> controllerClass) {
        super();
        this.controllerClass = Objects.requireNonNull(controllerClass, "controllerClass is null");
    }

    // ------------------------------------------------------------------------------------------------- controllerClass
    protected String clientBaseUrl() {
        final var requestMapping = controllerClass.getAnnotation(RequestMapping.class);
        return Arrays.stream(requestMapping.path())
                .findFirst()
                .orElseThrow(() -> new RuntimeException("no @RequestMapping#path"));
    }

    // -----------------------------------------------------------------------------------------------------------------
    final Class<CONTROLLER> controllerClass;
}
