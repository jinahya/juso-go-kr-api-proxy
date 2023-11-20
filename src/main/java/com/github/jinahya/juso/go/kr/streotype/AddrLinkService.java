package com.github.jinahya.juso.go.kr.streotype;

import com.github.jinahya.juso.go.kr.context.AddrLinkApiConfiguration;
import com.github.jinahya.juso.go.kr.web.bind.addrlink.type.AddrLinkApiRequest;
import com.github.jinahya.juso.go.kr.web.bind.addrlink.type.AddrLinkApiResponse;
import com.github.jinahya.juso.go.kr.web.bind.type._BaseTypeGroup;
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
    @Validated({_BaseTypeGroup.class})
    public Mono<AddrLinkApiResponse> get(@Valid @NotNull final AddrLinkApiRequest request) {
        return webClient
                .get()
                .uri(b -> request.put(b).build())
                .retrieve()
                .bodyToMono(AddrLinkApiResponse.class);
    }

    // -----------------------------------------------------------------------------------------------------------------
    @AddrLinkApiConfiguration.AddrLinkApi
    @Autowired
    @SuppressWarnings({"java:S6813"})
    private WebClient webClient;
}
