package com.github.jinahya.juso.go.kr.api.proxy.stereotype;

import com.github.jinahya.juso.go.kr.api.proxy.context.AddrLinkApiConfiguration;
import com.github.jinahya.juso.go.kr.api.proxy.context.properties.AddrLinkApiConfigurationProperties;
import com.github.jinahya.juso.go.kr.api.proxy.stereotype.type.__BaseTypeGroup;
import com.github.jinahya.juso.go.kr.api.proxy.stereotype.type.addrlink.AddrLinkApiRequest;
import com.github.jinahya.juso.go.kr.api.proxy.stereotype.type.addrlink.AddrLinkApiResponse;
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
public class AddrLinkApiService
        extends _BaseService<AddrLinkApiRequest, AddrLinkApiResponse> {

    public static final String CACHE_NAME_ADDR_LINK = AddrLinkApiConfigurationProperties.BASE_URL;

    // -----------------------------------------------------------------------------------------------------------------
    @Cacheable(cacheNames = {CACHE_NAME_ADDR_LINK})
    @Validated({__BaseTypeGroup.class})
    public Mono<AddrLinkApiResponse> retrieve(@Valid final AddrLinkApiRequest request) {
        return webClient
                .get()
                .uri(b -> {
                    final var built = b.queryParams(request.toMultivalueMap(objectMapper())).build();
                    log.debug("built: {}", built);
                    return built;
                })
                .retrieve()
                .bodyToMono(AddrLinkApiResponse.class);
    }

    // -----------------------------------------------------------------------------------------------------------------
    @AddrLinkApiConfiguration.AddrLinkApi
    @Autowired
    @SuppressWarnings({"java:S6813"})
    private WebClient webClient;
}
