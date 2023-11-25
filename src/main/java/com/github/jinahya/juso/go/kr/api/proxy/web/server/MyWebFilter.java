package com.github.jinahya.juso.go.kr.api.proxy.web.server;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import org.springframework.web.server.WebFilter;
import org.springframework.web.server.WebFilterChain;
import reactor.core.publisher.Mono;

@Component
@Slf4j
class MyWebFilter
        implements WebFilter {

    @Override
    public Mono<Void> filter(final ServerWebExchange exchange, final WebFilterChain chain) {
        final var request = exchange.getRequest();
        final var path = request.getPath();
        log.debug("path: {}", path);
        final var queryParams = request.getQueryParams();
        final var headers = request.getHeaders();
        log.debug("headers: {}", headers);
        return chain.filter(exchange);
    }
}
