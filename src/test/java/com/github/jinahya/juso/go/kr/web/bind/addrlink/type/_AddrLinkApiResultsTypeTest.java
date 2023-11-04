package com.github.jinahya.juso.go.kr.web.bind.addrlink.type;

import com.github.jinahya.juso.go.kr.web.bind.type._BaseResultsTypeTest;

abstract class _AddrLinkApiResultsTypeTest<RESULTS extends _AddrlinkResultType<?>>
        extends _BaseResultsTypeTest<RESULTS> {

    _AddrLinkApiResultsTypeTest(final Class<RESULTS> resultsClass) {
        super(resultsClass);
    }
}
