package com.github.jinahya.juso.go.kr.api.proxy.web.bind;

import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.annotation.PostConstruct;
import jakarta.validation.Validator;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;
import org.springframework.test.web.reactive.server.WebTestClient;

import java.util.Arrays;
import java.util.Objects;

import static org.assertj.core.api.Assertions.assertThat;

// https://docs.spring.io/spring-framework/reference/testing/webtestclient.html
@Slf4j
public abstract class _BaseControllerWebFluxTest<CONTROLLER extends _BaseController>
        extends __BaseControllerTestBase<CONTROLLER> {

    // -----------------------------------------------------------------------------------------------------------------
    protected _BaseControllerWebFluxTest(final Class<CONTROLLER> controllerClass) {
        super(controllerClass);
    }

    // -----------------------------------------------------------------------------------------------------------------
    @PostConstruct
    private void doOnPostConstruct() {
//        webTestClient = WebTestClient.bindToController(controllerInstance).build();
        objectMapper = objectMapperBuilder.build();
    }

    // --------------------------------------------------------------------------------------------------- webTestClient

    // --------------------------------------------------------------------------------------------- objectMapperBuilder

    // ---------------------------------------------------------------------------------------------------- objectMapper

    // ------------------------------------------------------------------------------------------------------- validator
    protected void assertValid(final Object object, final Class<?>... groups) {
        Objects.requireNonNull(object, "object is null");
        Objects.requireNonNull(groups, "groups is null");
        assertThat(validator.validate(object, groups))
                .as("constraint violations of %1$s with %2$s", object, Arrays.toString(groups))
                .isEmpty();
    }

    // -----------------------------------------------------------------------------------------------------------------
    @Autowired
    @Accessors(fluent = true)
    @Setter(AccessLevel.NONE)
    @Getter(AccessLevel.PROTECTED)
    private WebTestClient webTestClient;

    @Autowired
    private Jackson2ObjectMapperBuilder objectMapperBuilder;

    @Autowired
    @Accessors(fluent = true)
    @Setter(AccessLevel.NONE)
    @Getter(AccessLevel.PROTECTED)
    private ObjectMapper objectMapper;

    @Autowired
    @Accessors(fluent = true)
    @Setter(AccessLevel.NONE)
    @Getter(AccessLevel.PROTECTED)
    private Validator validator;
}
