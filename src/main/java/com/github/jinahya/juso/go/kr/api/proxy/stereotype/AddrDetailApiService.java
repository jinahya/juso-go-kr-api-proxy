package com.github.jinahya.juso.go.kr.api.proxy.stereotype;

import com.github.jinahya.juso.go.kr.api.proxy.context.AddrDetailApiConfiguration;
import com.github.jinahya.juso.go.kr.api.proxy.context.properties.AddrDetailApiConfigurationProperties;
import com.github.jinahya.juso.go.kr.api.proxy.stereotype.type.__BaseTypeGroup;
import com.github.jinahya.juso.go.kr.api.proxy.stereotype.type.addrlink.AddrDetailApiRequest;
import com.github.jinahya.juso.go.kr.api.proxy.stereotype.type.addrlink.AddrDetailApiResponse;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
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
public class AddrDetailApiService
        extends _BaseService<AddrDetailApiRequest, AddrDetailApiResponse> {

    public static final String CACHE_NAME_ADDR_DETAIL = AddrDetailApiConfigurationProperties.BASE_URL;

    // -----------------------------------------------------------------------------------------------------------------
    @Cacheable(cacheNames = {CACHE_NAME_ADDR_DETAIL})
    @Validated({__BaseTypeGroup.class})
    public Mono<AddrDetailApiResponse> retrieve(@Valid final AddrDetailApiRequest request) {
        return webClient
                .get()
                .uri(b -> {
                    final var built = b.queryParams(request.toMultivalueMap(objectMapper())).build();
                    log.debug("built: {}", built);
                    return built;
                })
                .retrieve()
                .bodyToMono(AddrDetailApiResponse.class);
    }

    // -----------------------------------------------------------------------------------------------------------------
    @AddrDetailApiConfiguration.AddrDetailApi
    @Autowired
    @SuppressWarnings({"java:S6813"})
    private WebClient webClient;
}
