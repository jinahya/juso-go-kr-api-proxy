package com.github.jinahya.juso.go.kr.api.proxy.web.bind;

import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.annotation.PostConstruct;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.experimental.Accessors;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;
import org.springframework.test.web.reactive.server.WebTestClient;

//@AutoConfigureWebTestClient(timeout = "PT36S")
// https://docs.spring.io/spring-framework/reference/testing/webtestclient.html
@Slf4j
public abstract class _BaseControllerIT<CONTROLLER extends _BaseController>
        extends __BaseControllerTestBase<CONTROLLER> {

    protected _BaseControllerIT(final Class<CONTROLLER> controllerClass) {
        super(controllerClass);
    }

    // -----------------------------------------------------------------------------------------------------------------
    @PostConstruct
    private void doOnPostConstruct() {
        log.debug("controllerInstance: {}", controllerInstance);
        objectMapper = objectMapperBuilder.build();
    }

    // ---------------------------------------------------------------------------------------------- controllerInstance

    // --------------------------------------------------------------------------------------------------- webTestClient
    protected WebTestClient newWebTestClient() {
        return WebTestClient
                .bindToController(controllerInstance)
                .build();
    }

    protected WebTestClient webTestClient() {
        var result = webTestClient;
        if (result == null) {
            result = webTestClient = newWebTestClient();
        }
        return result;
    }

    // -----------------------------------------------------------------------------------------------------------------
    @Autowired
    @Accessors(fluent = true)
    @Getter(AccessLevel.PROTECTED)
    private CONTROLLER controllerInstance;

    private WebTestClient webTestClient;

    @Autowired
    private Jackson2ObjectMapperBuilder objectMapperBuilder;

    @Accessors(fluent = true)
    @Getter(AccessLevel.PROTECTED)
    private ObjectMapper objectMapper;
}
