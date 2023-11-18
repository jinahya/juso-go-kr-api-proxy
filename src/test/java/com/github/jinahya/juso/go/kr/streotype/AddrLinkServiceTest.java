package com.github.jinahya.juso.go.kr.streotype;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.jinahya.juso.go.kr.context.AddrLinkApiConfiguration;
import com.github.jinahya.juso.go.kr.context.CacheConfiguration;
import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.jackson.JacksonAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;
import org.springframework.web.reactive.function.client.ExchangeFunction;

@Import(
        value = {
                AddrLinkServiceTestConfiguration.class,
                CacheConfiguration.class,
                JacksonAutoConfiguration.class
        }
)
@SpringBootTest(
        classes = {
                AddrLinkService.class,
                AddrLinkCacheMem.class,
        }
)
@Slf4j
class AddrLinkServiceTest {

    @PostConstruct
    private void doOnPostConstruct() {
        objectMapper = objectMapperBuilder.build();
    }

    // -----------------------------------------------------------------------------------------------------------------
    @Test
    void __() {
        log.debug("service: {}", service);
        log.debug("exchangeFunction: {}", exchangeFunction);
    }

    // -----------------------------------------------------------------------------------------------------------------
    @Autowired
    private AddrLinkService service;

    @Autowired
    private Jackson2ObjectMapperBuilder objectMapperBuilder;

    private ObjectMapper objectMapper;

    @AddrLinkApiConfiguration.AddrLinkApi
    @Autowired
    private ExchangeFunction exchangeFunction;
}
