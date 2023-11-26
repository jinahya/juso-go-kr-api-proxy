package com.github.jinahya.juso.go.kr.api.proxy.stereotype;

import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.annotation.PostConstruct;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.Accessors;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;

@ToString
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Slf4j
public abstract class _BaseService {

    @PostConstruct
    private void doOnPostConstruct() {
        objectMapper = objectMapperBuilder.build();
    }

    // -----------------------------------------------------------------------------------------------------------------
    @Autowired
    private Jackson2ObjectMapperBuilder objectMapperBuilder;

    @Accessors(fluent = true)
    @Getter(AccessLevel.PROTECTED)
    private ObjectMapper objectMapper;
}
