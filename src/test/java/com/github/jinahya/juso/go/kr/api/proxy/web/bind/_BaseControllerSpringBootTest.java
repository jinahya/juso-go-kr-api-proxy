package com.github.jinahya.juso.go.kr.api.proxy.web.bind;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.jinahya.juso.go.kr.api.proxy.util.JacksonTestUtils;
import com.github.jinahya.juso.go.kr.api.proxy.util.ValidationTestUtils;
import jakarta.annotation.PostConstruct;
import jakarta.validation.Validator;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.experimental.Accessors;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;
import org.springframework.test.web.reactive.server.WebTestClient;

import java.util.Objects;

import static org.assertj.core.api.Assertions.assertThat;

//@AutoConfigureWebTestClient(timeout = "PT36S")
// https://docs.spring.io/spring-framework/reference/testing/webtestclient.html
@SpringBootTest
@Slf4j
public abstract class _BaseControllerSpringBootTest<CONTROLLER extends _BaseController>
        extends __BaseControllerTestBase<CONTROLLER> {

    protected _BaseControllerSpringBootTest(final Class<CONTROLLER> controllerClass) {
        super(controllerClass);
    }

    // -----------------------------------------------------------------------------------------------------------------
    @PostConstruct
    private void doOnPostConstruct() {
        log.debug("controllerInstance: {}", controllerInstance);
        objectMapper = objectMapperBuilder.build();
    }

    // -----------------------------------------------------------------------------------------------------------------
    @Test
    void controllerInstance_NotNull_() {
        log.debug("controllerInstance: {}", controllerInstance);
        assertThat(controllerInstance).isNotNull();
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

    // --------------------------------------------------------------------------------------------- objectMapperBuilder

    // ---------------------------------------------------------------------------------------------------- objectMapper
    protected void printPretty(final Object value) {
        Objects.requireNonNull(value, "value is null");
        try {
            final var string = JacksonTestUtils.writeValueAsPrettyString(objectMapper(), value);
            System.out.println(string);
        } catch (final JsonProcessingException jpe) {
            throw new RuntimeException("failed to pretty print " + value, jpe);
        }
    }

    // ------------------------------------------------------------------------------------------------------- validator
    protected void assertValid(final Object object, final Class<?>... groups) {
        ValidationTestUtils.assertValid(validator(), object, groups);
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

    @Autowired
    @Accessors(fluent = true)
    @Getter(AccessLevel.PROTECTED)
    private Validator validator;
}
