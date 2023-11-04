package com.github.jinahya.juso.go.kr.context;

import com.github.jinahya.juso.go.kr.context.properties.AbstractConfigurationProperties;
import com.github.jinahya.juso.go.kr.context.properties.AddrLinkApiConfigurationProperties;
import io.netty.channel.ChannelOption;
import io.netty.handler.logging.LogLevel;
import io.netty.handler.timeout.ReadTimeoutHandler;
import io.netty.handler.timeout.WriteTimeoutHandler;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.experimental.Accessors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.client.reactive.ReactorClientHttpConnector;
import org.springframework.web.reactive.function.client.ClientRequest;
import org.springframework.web.reactive.function.client.ExchangeFilterFunction;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.util.UriComponentsBuilder;
import reactor.core.publisher.Mono;
import reactor.netty.http.client.HttpClient;
import reactor.netty.transport.logging.AdvancedByteBufFormat;

import java.util.Optional;

abstract class AbstractConfiguration<PROPERTIES extends AbstractConfigurationProperties> {

    HttpClient httpClient() {
        final var httpClient = HttpClient.create()
                .option(ChannelOption.CONNECT_TIMEOUT_MILLIS,
                        Math.toIntExact(properties.getConnectTimeout().toMillis()))
                .doOnConnected(c -> {
                    c.addHandlerFirst(new WriteTimeoutHandler(
                            Math.toIntExact(properties.getWriteTimeout().toSeconds())
                    ));
                    c.addHandlerFirst(new ReadTimeoutHandler(
                            Math.toIntExact(properties.getReadTimeout().toSeconds())
                    ));
                });
        final var wiretap = properties.getWiretap();
        if (wiretap != null && wiretap) {
//            httpClient.wiretap(true);
            httpClient.wiretap("reactor.netty.http.client.HttpClient",
                               LogLevel.DEBUG, AdvancedByteBufFormat.TEXTUAL);
        }
        return httpClient;
    }

    WebClient.Builder webClientBuilder() {
        final var webClientBuilder = WebClient.builder()
                .baseUrl(AddrLinkApiConfigurationProperties.BASE_URL)
//                .defaultHeader(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON_VALUE)
                .clientConnector(new ReactorClientHttpConnector(httpClient()));
        Optional.ofNullable(properties.getConfmKey()).ifPresent(v -> {
            final var filter = ExchangeFilterFunction.ofRequestProcessor(
                    r -> Mono.just(
                            ClientRequest.from(r)
                                    .url(UriComponentsBuilder.fromUri(r.url())
                                                 .queryParam("confmKey", v)
                                                 .build(true)
                                                 .toUri()
                                    )
                                    .build())
            );
            webClientBuilder.filter(filter);
        });
        return webClientBuilder;
    }

    @Autowired
    @Accessors(fluent = true)
    @Getter(AccessLevel.PACKAGE)
    private PROPERTIES properties;
}
