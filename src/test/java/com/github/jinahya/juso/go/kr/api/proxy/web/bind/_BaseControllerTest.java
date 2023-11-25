package com.github.jinahya.juso.go.kr.api.proxy.web.bind;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public abstract class _BaseControllerTest<CONTROLLER extends _BaseController>
        extends __BaseControllerTestBase<CONTROLLER> {

    protected _BaseControllerTest(final Class<CONTROLLER> controllerClass) {
        super(controllerClass);
    }
}
