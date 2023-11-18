package com.github.jinahya.juso.go.kr.web.bind.addrlink;

import com.github.jinahya.juso.go.kr.context.AddrEngApiConfiguration;
import com.github.jinahya.juso.go.kr.context.properties.AddrLinkApiConfigurationProperties;
import com.github.jinahya.juso.go.kr.web.bind.WebBindConstants;
import com.github.jinahya.juso.go.kr.web.bind.addrlink.type.AddrLinkApiRequest;
import com.github.jinahya.juso.go.kr.web.bind.addrlink.type.AddrLinkApiResponse;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.http.MediaType;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping(
        path = {
                AddrEngApiController.REQUEST_MAPPING_PATH
        }
)
@RequiredArgsConstructor(access = AccessLevel.PACKAGE)
class AddrEngApiController
        extends _AddrLinkController {

    static final String REQUEST_MAPPING_PATH = "/addrlink/addrEngApi.do";

    // -----------------------------------------------------------------------------------------------------------------
    @GetMapping(
            produces = {
                    MediaType.APPLICATION_JSON_VALUE
            }
    )
    Mono<AddrLinkApiResponse> get(
            final ServerWebExchange exchange,
            @Valid
            @ModelAttribute final AddrLinkApiRequest request,
            final BindingResult bindingResult,
            @PositiveOrZero
            @RequestParam(name = WebBindConstants.PARAM_NAME_PAGE, required = false) final Integer page,
            @Max(AddrLinkApiRequest.PROPERTY_MAX_COUNT_PER_PAGE)
            @Positive
            @RequestParam(name = WebBindConstants.PARAM_NAME_SIZE, required = false) final Integer size) {
        if (request.getConfmKey() == null) {
            request.setConfmKey(properties.getConfmKey());
        }
        if (request.getCurrentPage() == null && page != null) {
            request.setCurrentPage(page + 1);
        }
        if (request.getCountPerPage() == null && page == null) {
            request.setCountPerPage(size);
        }
        if (request.getResultType() == null) {
            exchange.getRequest().getHeaders().getAccept().stream()
                    .filter(MediaType.APPLICATION_JSON::equalsTypeAndSubtype).findFirst()
                    .ifPresent(v -> request.setResultType(AddrLinkApiRequest.PROPERTY_VALUE_RESULT_TYPE_JSON));
        }
        if (request.getResultType() == null) {
            exchange.getRequest().getHeaders().getAccept().stream()
                    .filter(MediaType.APPLICATION_XML::equalsTypeAndSubtype).findFirst()
                    .ifPresent(v -> request.setResultType(AddrLinkApiRequest.PROPERTY_VALUE_RESULT_TYPE_XML));
        }
        return webClient
                .get()
                .uri(b -> request.put(b).build())
                .retrieve()
                .bodyToMono(AddrLinkApiResponse.class);
    }

    // -----------------------------------------------------------------------------------------------------------------
    private final AddrLinkApiConfigurationProperties properties;

    @AddrEngApiConfiguration.AddrEngApi
    private final WebClient webClient;

    // -----------------------------------------------------------------------------------------------------------------
    @Lazy
    @Autowired
    private AddrEngApiController self;
}
