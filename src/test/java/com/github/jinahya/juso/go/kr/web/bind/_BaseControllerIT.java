package com.github.jinahya.juso.go.kr.web.bind;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Arrays;

@Slf4j
public abstract class _BaseControllerIT<CONTROLLER extends _BaseController>
        extends __BaseControllerTestBase<CONTROLLER> {

    protected _BaseControllerIT(final Class<CONTROLLER> controllerClass) {
        super(controllerClass);
    }

    // -----------------------------------------------------------------------------------------------------------------
//    @PostConstruct
//    protected void doOnPostConstruct() {
//        webTestClient = WebTestClient.bindToController(controllerInstance)
//                .configureClient()
//                .baseUrl(requestMappingPath())
//                .build();
//    }

    // ------------------------------------------------------------------------------------------------- controllerClass
    protected String clientBaseUrl() {
        final var requestMapping = controllerClass.getAnnotation(RequestMapping.class);
        return Arrays.stream(requestMapping.path()).findFirst()
                .orElseThrow(() -> new RuntimeException("no @RequestMapping#path"));
    }

    // ---------------------------------------------------------------------------------------------- controllerInstance

    // --------------------------------------------------------------------------------------------------- webTestClient
    protected WebTestClient webTestClient() {
        if (webTestClient == null) {
            webTestClient = WebTestClient.bindToController(controllerInstance)
                    .configureClient()
                    .baseUrl(clientBaseUrl())
                    .build();
        }
        return webTestClient;
    }

    // -----------------------------------------------------------------------------------------------------------------
    @Autowired
    private CONTROLLER controllerInstance;

    private WebTestClient webTestClient;
}
