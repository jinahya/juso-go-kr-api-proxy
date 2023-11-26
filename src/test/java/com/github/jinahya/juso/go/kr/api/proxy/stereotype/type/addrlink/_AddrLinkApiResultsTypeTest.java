package com.github.jinahya.juso.go.kr.api.proxy.stereotype.type.addrlink;

import com.github.jinahya.juso.go.kr.api.proxy.stereotype.type._BaseResultsTypeTest;

abstract class _AddrLinkApiResultsTypeTest<RESULTS extends _AddrlinkResultType<?>>
        extends _BaseResultsTypeTest<RESULTS> {

    _AddrLinkApiResultsTypeTest(final Class<RESULTS> resultsClass) {
        super(resultsClass);
    }
}
