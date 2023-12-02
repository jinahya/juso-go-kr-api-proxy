package com.github.jinahya.juso.go.kr.api.proxy.web.bind.addrlink;

import com.github.jinahya.juso.go.kr.api.proxy.web.bind._BaseControllerWebFluxTest;

abstract class _AddrlinkControllerWebFluxTest<CONTROLLER extends _AddrLinkController>
        extends _BaseControllerWebFluxTest<CONTROLLER> {

    _AddrlinkControllerWebFluxTest(final Class<CONTROLLER> controllerClass) {
        super(controllerClass);
    }
}
