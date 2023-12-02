package com.github.jinahya.juso.go.kr.api.proxy.stereotype;

import com.github.jinahya.juso.go.kr.api.proxy.context.AddrCoordApiConfiguration;
import com.github.jinahya.juso.go.kr.api.proxy.context.properties.AddrCoordApiConfigurationProperties;
import com.github.jinahya.juso.go.kr.api.proxy.stereotype.type.__BaseTypeGroup;
import com.github.jinahya.juso.go.kr.api.proxy.stereotype.type.addrlink.AddrCoordApiRequest;
import com.github.jinahya.juso.go.kr.api.proxy.stereotype.type.addrlink.AddrCoordApiResponse;
import jakarta.validation.Valid;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Validated
@Service
@ToString
@NoArgsConstructor(access = AccessLevel.PACKAGE)
@Slf4j
public class AddrCoordApiService
        extends _BaseService<AddrCoordApiRequest, AddrCoordApiResponse> {

    public static final String CACHE_NAME_ADDR_COORD = AddrCoordApiConfigurationProperties.BASE_URL;

    // -----------------------------------------------------------------------------------------------------------------
    @Cacheable(cacheNames = {CACHE_NAME_ADDR_COORD})
    @Validated({__BaseTypeGroup.class})
    public Mono<AddrCoordApiResponse> retrieve(@Valid final AddrCoordApiRequest request) {
        return webClient
                .get()
                .uri(b -> b.queryParams(request.toMultivalueMap(objectMapper())).build())
                .retrieve()
                .bodyToMono(AddrCoordApiResponse.class);
    }

    // -----------------------------------------------------------------------------------------------------------------
    @AddrCoordApiConfiguration.AddrCoordApi
    @Autowired
    @SuppressWarnings({"java:S6813"})
    private WebClient webClient;
}
