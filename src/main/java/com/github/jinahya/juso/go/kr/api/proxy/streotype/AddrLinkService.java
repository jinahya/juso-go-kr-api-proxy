package com.github.jinahya.juso.go.kr.api.proxy.streotype;

import com.github.jinahya.juso.go.kr.api.proxy.context.AddrLinkApiConfiguration;
import com.github.jinahya.juso.go.kr.api.proxy.web.bind._type.__BaseTypeGroup;
import com.github.jinahya.juso.go.kr.api.proxy.web.bind.addrlink._type.AddrLinkApiRequest;
import com.github.jinahya.juso.go.kr.api.proxy.web.bind.addrlink._type.AddrLinkApiResponse;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Validated
@Service
@ToString
@NoArgsConstructor(access = AccessLevel.PACKAGE)
@Slf4j
public class AddrLinkService
        extends _BaseService {

    public static final String CACHE_NAME_ADDR_LINK = "addrLink";

    // -----------------------------------------------------------------------------------------------------------------
//    @Cacheable(cacheNames = {CACHE_NAME_ADDR_LINK})
    @Validated({__BaseTypeGroup.class})
    public Mono<AddrLinkApiResponse> get(@Valid @NotNull final AddrLinkApiRequest request) {
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
