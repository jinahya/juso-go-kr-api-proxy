package com.github.jinahya.juso.go.kr.context;

import com.github.jinahya.juso.go.kr.context.properties.AddrLinkApiConfigurationProperties;
import io.netty.channel.ChannelOption;
import io.netty.handler.logging.LogLevel;
import io.netty.handler.timeout.ReadTimeoutHandler;
import io.netty.handler.timeout.WriteTimeoutHandler;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.client.reactive.ReactorClientHttpConnector;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.netty.http.client.HttpClient;
import reactor.netty.transport.logging.AdvancedByteBufFormat;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Configuration
@RequiredArgsConstructor
public class AddrLinkApiConfiguration {

    @Qualifier
    @Documented
    @Retention(RetentionPolicy.RUNTIME)
    @Target({
            ElementType.CONSTRUCTOR,
            ElementType.METHOD,
            ElementType.PARAMETER,
            ElementType.FIELD,
            ElementType.ANNOTATION_TYPE
    })
    public @interface AddrLinkApi {

    }

    @AddrLinkApi
    @Bean
    WebClient webClient() {
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
        return WebClient.builder()
                .baseUrl(AddrLinkApiConfigurationProperties.BASE_URL)
                .defaultHeader(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON_VALUE)
                .clientConnector(new ReactorClientHttpConnector(httpClient))
                .build();
    }

    private final AddrLinkApiConfigurationProperties properties;
}
