package com.github.jinahya.juso.go.kr.web.bind.addrlink;

import com.github.jinahya.juso.go.kr.context.AddrLinkApiConfiguration;
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
                AddrLinkApiController.REQUEST_MAPPING_PATH
        }
)
@RequiredArgsConstructor(access = AccessLevel.PACKAGE)
class AddrLinkApiController
        extends _AddrlinkController {

    static final String REQUEST_MAPPING_PATH = "/addrlink/addrLinkApi.do";

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

//    @PostMapping(
//            consumes = {
//                    MediaType.APPLICATION_JSON_VALUE
//            },
//            produces = {
//                    MediaType.APPLICATION_JSON_VALUE
//            }
//    )
//    Mono<AddrLinkApiResponse> post(
//            final ServerWebExchange exchange,
//            @Valid
//            @NotNull
//            @RequestBody final AddrLinkApiRequest request,
//            @PositiveOrZero
//            @RequestParam(name = WebBindConstants.PARAM_NAME_PAGE, required = false) final Integer page,
//            @Max(AddrLinkApiRequest.PROPERTY_MAX_COUNT_PER_PAGE)
//            @Positive
//            @RequestParam(name = WebBindConstants.PARAM_NAME_SIZE, required = false) final Integer size) {
//        return self.get(exchange, request, page, size);
//    }

    // -----------------------------------------------------------------------------------------------------------------
    private final AddrLinkApiConfigurationProperties properties;

    @AddrLinkApiConfiguration.AddrLinkApi
    private final WebClient webClient;

    // -----------------------------------------------------------------------------------------------------------------
    @Lazy
    @Autowired
    private AddrLinkApiController self;
}
