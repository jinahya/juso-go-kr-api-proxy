package com.github.jinahya.juso.go.kr.api.proxy.web.bind.addrlink;

import com.github.jinahya.juso.go.kr.api.proxy.context.AddrLinkApiConfiguration;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest;

@WebFluxTest(controllers = {AddrLinkApiConfiguration.class})
@Slf4j
class AddrLinkApiControllerWebFluxTest
        extends _AddrlinkControllerWebFluxTest<AddrLinkApiController> {

    // -----------------------------------------------------------------------------------------------------------------
    AddrLinkApiControllerWebFluxTest() {
        super(AddrLinkApiController.class);
    }
}
