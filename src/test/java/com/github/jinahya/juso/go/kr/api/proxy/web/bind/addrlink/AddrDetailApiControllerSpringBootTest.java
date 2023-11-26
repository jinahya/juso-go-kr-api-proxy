package com.github.jinahya.juso.go.kr.api.proxy.web.bind.addrlink;

import com.github.jinahya.juso.go.kr.api.proxy.context.AddrDetailApiConfiguration;
import com.github.jinahya.juso.go.kr.api.proxy.stereotype.AddrDetailApiService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.test.mock.mockito.MockBean;

@Slf4j
class AddrDetailApiControllerSpringBootTest
        extends _AddrlinkControllerSpringBootTest<AddrDetailApiController> {

    // -----------------------------------------------------------------------------------------------------------------
    AddrDetailApiControllerSpringBootTest() {
        super(AddrDetailApiController.class);
    }

    // -----------------------------------------------------------------------------------------------------------------

    // -----------------------------------------------------------------------------------------------------------------
    @MockBean
    private AddrDetailApiConfiguration configuration;

    @MockBean
    private AddrDetailApiService service;
}
