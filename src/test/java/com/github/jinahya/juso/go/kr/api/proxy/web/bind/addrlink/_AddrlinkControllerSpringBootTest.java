package com.github.jinahya.juso.go.kr.api.proxy.web.bind.addrlink;

import com.github.jinahya.juso.go.kr.api.proxy.web.bind._BaseControllerSpringBootTest;

abstract class _AddrlinkControllerSpringBootTest<CONTROLLER extends _AddrLinkController>
        extends _BaseControllerSpringBootTest<CONTROLLER> {

    _AddrlinkControllerSpringBootTest(final Class<CONTROLLER> controllerClass) {
        super(controllerClass);
    }
}
