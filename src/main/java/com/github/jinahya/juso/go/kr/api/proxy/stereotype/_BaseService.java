package com.github.jinahya.juso.go.kr.api.proxy.stereotype;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.jinahya.juso.go.kr.api.proxy.stereotype.type._BaseResponseType;
import com.github.jinahya.juso.go.kr.api.proxy.stereotype.type._BaseType;
import jakarta.annotation.PostConstruct;
import jakarta.validation.Valid;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.Accessors;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;
import reactor.core.publisher.Mono;

@ToString
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Slf4j
@SuppressWarnings({
        "java:S6813" // no constructor injection
})
public abstract class _BaseService<REQUEST extends _BaseType, RESPONSE extends _BaseResponseType<?>> {

    @PostConstruct
    private void doOnPostConstruct() {
        objectMapper = objectMapperBuilder.build();
    }

    // -----------------------------------------------------------------------------------------------------------------
    public abstract Mono<RESPONSE> retrieve(@Valid REQUEST request);

    // -----------------------------------------------------------------------------------------------------------------
    @Autowired
    private Jackson2ObjectMapperBuilder objectMapperBuilder;

    @Accessors(fluent = true)
    @Getter(AccessLevel.PROTECTED)
    private ObjectMapper objectMapper;
}
