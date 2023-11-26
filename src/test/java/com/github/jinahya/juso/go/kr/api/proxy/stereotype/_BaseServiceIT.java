package com.github.jinahya.juso.go.kr.api.proxy.stereotype;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.jinahya.juso.go.kr.api.proxy.util.JacksonTestUtils;
import com.github.jinahya.juso.go.kr.api.proxy.util.ValidationTestUtils;
import jakarta.annotation.PostConstruct;
import jakarta.validation.Validator;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.experimental.Accessors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;

import java.util.Objects;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public abstract class _BaseServiceIT<SERVICE extends _BaseService>
        extends __BaseServiceTestBase<SERVICE> {

    protected _BaseServiceIT(final Class<SERVICE> serviceClass) {
        super(serviceClass);
    }

    // -----------------------------------------------------------------------------------------------------------------
    @PostConstruct
    private void doOnPostConstruct() {
        objectMapper = objectMapperBuilder.build();
    }

    // ------------------------------------------------------------------------------------------------- serviceInstance

    // --------------------------------------------------------------------------------------------- objectMapperBuilder

    // ---------------------------------------------------------------------------------------------------- objectMapper
    void printPretty(final Object value) {
        Objects.requireNonNull(value, "value is null");
        try {
            final var string = JacksonTestUtils.writeValueAsPrettyString(objectMapper(), value);
            System.out.println(string);
        } catch (final JsonProcessingException jpe) {
            throw new RuntimeException("failed to pretty print " + value, jpe);
        }
    }

    // ------------------------------------------------------------------------------------------------------- validator
    void assertValid(final Object object, final Class<?>... groups) {
        ValidationTestUtils.assertValid(validator(), object, groups);
    }

    // -----------------------------------------------------------------------------------------------------------------
    @Autowired
    @Accessors(fluent = true)
    @Getter(AccessLevel.PROTECTED)
    private SERVICE serviceInstance;

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
