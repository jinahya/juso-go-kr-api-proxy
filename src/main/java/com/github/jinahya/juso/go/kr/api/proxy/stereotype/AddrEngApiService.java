package com.github.jinahya.juso.go.kr.api.proxy.stereotype;

import com.github.jinahya.juso.go.kr.api.proxy.context.AddrEngApiConfiguration;
import com.github.jinahya.juso.go.kr.api.proxy.context.properties.AddrEngApiConfigurationProperties;
import com.github.jinahya.juso.go.kr.api.proxy.stereotype.type.__BaseTypeGroup;
import com.github.jinahya.juso.go.kr.api.proxy.stereotype.type.addrlink.AddrEngApiRequest;
import com.github.jinahya.juso.go.kr.api.proxy.stereotype.type.addrlink.AddrEngApiResponse;
import jakarta.validation.Valid;
import jakarta.validation.Validator;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
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
public class AddrEngApiService
        extends _BaseService<AddrEngApiRequest, AddrEngApiResponse> {

    public static final String CACHE_NAME_ADDR_ENG = AddrEngApiConfigurationProperties.BASE_URL;

    // -----------------------------------------------------------------------------------------------------------------
    @Cacheable(cacheNames = {CACHE_NAME_ADDR_ENG})
    @Validated({__BaseTypeGroup.class})
    public Mono<AddrEngApiResponse> retrieve(@Valid final AddrEngApiRequest request) {
        return webClient
                .get()
                .uri(b -> request.put(b).build())
                .retrieve()
                .bodyToMono(AddrEngApiResponse.class);
    }

    // -----------------------------------------------------------------------------------------------------------------
    @CacheEvict(cacheNames = {CACHE_NAME_ADDR_ENG})
    @Override
    public void evictCache() {
        // empty
    }

    // -----------------------------------------------------------------------------------------------------------------
    @AddrEngApiConfiguration.AddrEngApi
    @Autowired
    @SuppressWarnings({"java:S6813"})
    private WebClient webClient;

    @Autowired
    @SuppressWarnings({"java:S6813"})
    private Validator validator;
}
