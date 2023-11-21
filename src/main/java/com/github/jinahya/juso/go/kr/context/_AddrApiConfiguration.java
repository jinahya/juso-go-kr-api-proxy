package com.github.jinahya.juso.go.kr.context;

import com.github.jinahya.juso.go.kr.context.properties._AddrApiConfigurationProperties;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.experimental.Accessors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.client.reactive.ReactorClientHttpConnector;
import org.springframework.web.reactive.function.client.WebClient;

abstract class _AddrApiConfiguration<PROPERTIES extends _AddrApiConfigurationProperties> {

    WebClient.Builder webClientBuilder() {
        final var httpClient = properties().newHttpClient();
        return WebClient.builder()
                .defaultHeader(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON_VALUE)
                .clientConnector(new ReactorClientHttpConnector(httpClient));
    }

    WebClient webClient() {
        return webClientBuilder()
                .build();
    }

    @Autowired
    @Accessors(fluent = true)
    @Getter(AccessLevel.PROTECTED)
    private PROPERTIES properties;
}
