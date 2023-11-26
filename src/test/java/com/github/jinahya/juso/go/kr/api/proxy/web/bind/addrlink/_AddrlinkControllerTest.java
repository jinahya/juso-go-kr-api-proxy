package com.github.jinahya.juso.go.kr.api.proxy.web.bind.addrlink;

import com.github.jinahya.juso.go.kr.api.proxy.web.bind._BaseControllerTest;

abstract class _AddrlinkControllerTest<CONTROLLER extends _AddrLinkController>
        extends _BaseControllerTest<CONTROLLER> {

    _AddrlinkControllerTest(final Class<CONTROLLER> controllerClass) {
        super(controllerClass);
    }
}
