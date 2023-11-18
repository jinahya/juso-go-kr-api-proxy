package com.github.jinahya.juso.go.kr.streotype;

import com.github.jinahya.juso.go.kr.context.AddrLinkApiConfiguration;
import com.github.jinahya.juso.go.kr.web.bind.addrlink.type.AddrLinkApiRequest;
import com.github.jinahya.juso.go.kr.web.bind.addrlink.type.AddrLinkApiResponse;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Service
@ToString
@RequiredArgsConstructor(access = AccessLevel.PACKAGE)
@Slf4j
public class AddrLinkService {

    public static final String CACHE_NAME_ADDR_LINK = "addrLink";

    // -----------------------------------------------------------------------------------------------------------------
    @Cacheable(cacheNames = {CACHE_NAME_ADDR_LINK})
    public Mono<AddrLinkApiResponse> get(
            @Validated({AddrLinkService.class}) @Valid @NotNull final AddrLinkApiRequest request) {
        return webClient
                .get()
                .uri(b -> request.put(b).build())
                .retrieve()
                .bodyToMono(AddrLinkApiResponse.class);
    }

    // -----------------------------------------------------------------------------------------------------------------
    @AddrLinkApiConfiguration.AddrLinkApi
    private final WebClient webClient;
}
