package com.github.jinahya.juso.go.kr.api.proxy.web.bind.addrlink;

import com.github.jinahya.juso.go.kr.api.proxy.web.bind._BaseControllerSpringBootIT;

abstract class _AddrlinkControllerSpringBootIT<CONTROLLER extends _AddrLinkController>
        extends _BaseControllerSpringBootIT<CONTROLLER> {

    _AddrlinkControllerSpringBootIT(final Class<CONTROLLER> controllerClass) {
        super(controllerClass);
    }
}
