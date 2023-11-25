package com.github.jinahya.juso.go.kr.api.proxy.web.bind.addrlink;

import com.github.jinahya.juso.go.kr.api.proxy.web.bind._BaseControllerIT;

abstract class _AddrLinkControllerIT<CONTROLLER extends _AddrLinkController>
        extends _BaseControllerIT<CONTROLLER> {

    _AddrLinkControllerIT(final Class<CONTROLLER> controllerClass) {
        super(controllerClass);
    }
}
