package com.github.jinahya.juso.go.kr.context;

import com.github.jinahya.juso.go.kr.context.properties.AddrLinkApiConfigurationProperties;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Configuration
@RequiredArgsConstructor(access = AccessLevel.PACKAGE)
public class AddrLinkApiConfiguration
        extends _AddrApiConfiguration<AddrLinkApiConfigurationProperties> {

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

    @Override
    WebClient.Builder webClientBuilder() {
        return super.webClientBuilder()
                .baseUrl(properties().getBaseUrl());
    }

    @AddrLinkApi
    @Bean
    WebClient webClientAddrLink() {
        return super.webClient();
    }
}
