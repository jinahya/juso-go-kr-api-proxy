package com.github.jinahya.juso.go.kr.streotype;

import com.github.jinahya.juso.go.kr.context.AddrLinkApiConfiguration;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import org.mockito.Mockito;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.ExchangeFunction;
import org.springframework.web.reactive.function.client.WebClient;

//@TestConfiguration
@Configuration
@RequiredArgsConstructor(access = AccessLevel.PACKAGE)
class AddrLinkServiceTestConfiguration {

    @AddrLinkApiConfiguration.AddrLinkApi
    @Bean
    ExchangeFunction exchangeFunction() {
        return Mockito.mock(ExchangeFunction.class);
    }

    @AddrLinkApiConfiguration.AddrLinkApi
    @Bean
    WebClient webClient(final ExchangeFunction exchangeFunction) {
        return WebClient.builder()
                .exchangeFunction(exchangeFunction)
                .build();
    }
}
