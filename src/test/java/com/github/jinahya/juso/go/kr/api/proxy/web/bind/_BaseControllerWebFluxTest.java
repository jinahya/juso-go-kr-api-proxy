package com.github.jinahya.juso.go.kr.api.proxy.web.bind;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.reactive.server.WebTestClient;

//@AutoConfigureWebTestClient(timeout = "PT36S")
// https://docs.spring.io/spring-framework/reference/testing/webtestclient.html
@Slf4j
public abstract class _BaseControllerWebFluxTest<CONTROLLER extends _BaseController>
        extends __BaseControllerTestBase<CONTROLLER> {

    protected _BaseControllerWebFluxTest(final Class<CONTROLLER> controllerClass) {
        super(controllerClass);
    }

    // -----------------------------------------------------------------------------------------------------------------
    @Autowired
    @Accessors(fluent = true)
    @Setter(AccessLevel.NONE)
    @Getter(AccessLevel.PROTECTED)
    private WebTestClient webTestClient;
}
