package com.github.jinahya.juso.go.kr.api.proxy.web.bind.addrlink._type;

import com.github.jinahya.juso.go.kr.api.proxy.web.bind._type._BaseResultsTypeTest;

abstract class _AddrLinkApiResultsTypeTest<RESULTS extends _AddrlinkResultType<?>>
        extends _BaseResultsTypeTest<RESULTS> {

    _AddrLinkApiResultsTypeTest(final Class<RESULTS> resultsClass) {
        super(resultsClass);
    }
}
