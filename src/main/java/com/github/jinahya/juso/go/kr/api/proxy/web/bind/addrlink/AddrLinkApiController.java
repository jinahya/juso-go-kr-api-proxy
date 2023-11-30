package com.github.jinahya.juso.go.kr.api.proxy.web.bind.addrlink;

import com.github.jinahya.juso.go.kr.api.proxy.context.properties.AddrLinkApiConfigurationProperties;
import com.github.jinahya.juso.go.kr.api.proxy.stereotype.AddrLinkApiService;
import com.github.jinahya.juso.go.kr.api.proxy.stereotype.type.addrlink.AddrLinkApiRequest;
import com.github.jinahya.juso.go.kr.api.proxy.stereotype.type.addrlink.AddrLinkApiResponse;
import com.github.jinahya.juso.go.kr.api.proxy.util.KeywordUtils;
import com.github.jinahya.juso.go.kr.api.proxy.web.bind.WebBindConstants;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.http.MediaType;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.util.Objects;
import java.util.Optional;

@Validated
@RestController
@RequestMapping(
        path = {
                AddrLinkApiController.REQUEST_MAPPING_PATH
        }
)
@RequiredArgsConstructor(access = AccessLevel.PACKAGE)
@Slf4j
class AddrLinkApiController
        extends _AddrLinkController {

    static final String REQUEST_MAPPING_PATH = AddrLinkApiConfigurationProperties.REQUEST_URI;

    // -----------------------------------------------------------------------------------------------------------------
    private void set(final AddrLinkApiRequest request, final Integer page, final Integer size) {
        Objects.requireNonNull(request, "request is null");
        if (request.getConfmKey() == null) {
            request.setConfmKey(properties.getConfmKey());
        }
        if (request.getCurrentPage() == null) {
            request.setCurrentPage(
                    Optional.ofNullable(page)
                            .map(v -> v + 1)
                            .orElse(AddrLinkApiRequest.PROPERTY_DEFAULT_VALUE_CURRENT_PAGE)
            );
        }
        if (request.getCountPerPage() == null) {
            request.setCountPerPage(
                    Optional.ofNullable(size)
                            .orElse(AddrLinkApiRequest.PROPERTY_DEFAULT_VALUE_COUNT_PER_PAGE)
            );
        }
        request.setKeyword(KeywordUtils.filter(request.getKeyword()));
        request.setResultType(AddrLinkApiRequest.PROPERTY_VALUE_RESULT_TYPE_JSON);
    }

    // -----------------------------------------------------------------------------------------------------------------
    @Operation(summary = "주소 검색", description = "주소를 검색한다.")
    @GetMapping(
            produces = {
                    MediaType.APPLICATION_JSON_VALUE
            }
    )
    Mono<AddrLinkApiResponse> get(
            final ServerWebExchange exchange,
            @Valid final AddrLinkApiRequest request,
            final BindingResult bindingResult,
            @PositiveOrZero
            @RequestParam(name = WebBindConstants.PARAM_NAME_PAGE, required = false) final Integer page,
            @Max(AddrLinkApiRequest.PROPERTY_MAX_COUNT_PER_PAGE)
            @Positive
            @RequestParam(name = WebBindConstants.PARAM_NAME_SIZE, required = false) final Integer size) {
        bindingResult.getAllErrors().stream().forEach(e -> {
            log.error("binding error: {}", e);
        });
        return post(exchange, request, page, size);
    }

    @PostMapping(
            consumes = {
                    MediaType.APPLICATION_JSON_VALUE
            },
            produces = {
                    MediaType.APPLICATION_JSON_VALUE
            }
    )
    Mono<AddrLinkApiResponse> post(
            final ServerWebExchange exchange,
            @Valid @NotNull @RequestBody final AddrLinkApiRequest request,
            @PositiveOrZero
            @RequestParam(name = WebBindConstants.PARAM_NAME_PAGE, required = false) final Integer page,
            @Max(AddrLinkApiRequest.PROPERTY_MAX_COUNT_PER_PAGE)
            @Positive
            @RequestParam(name = WebBindConstants.PARAM_NAME_SIZE, required = false) final Integer size) {
        set(request, page, size);
        return service.retrieve(request);
    }

    // -----------------------------------------------------------------------------------------------------------------
    private final AddrLinkApiConfigurationProperties properties;

    private final AddrLinkApiService service;

    // -----------------------------------------------------------------------------------------------------------------
    @Lazy
    @Autowired
    private AddrLinkApiController self;
}
