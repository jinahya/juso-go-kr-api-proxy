package com.github.jinahya.juso.go.kr.api.proxy.web.bind.addrlink;

import com.github.jinahya.juso.go.kr.api.proxy.context.AddrCoordApiConfiguration;
import com.github.jinahya.juso.go.kr.api.proxy.stereotype.AddrCoordApiService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.test.mock.mockito.MockBean;

@Slf4j
class AddrCoordApiControllerSpringBootTest
        extends _AddrlinkControllerSpringBootTest<AddrCoordApiController> {

    // -----------------------------------------------------------------------------------------------------------------
    AddrCoordApiControllerSpringBootTest() {
        super(AddrCoordApiController.class);
    }

    // -----------------------------------------------------------------------------------------------------------------

    // -----------------------------------------------------------------------------------------------------------------
    @MockBean
    private AddrCoordApiConfiguration configuration;

    @MockBean
    private AddrCoordApiService service;
}
