package com.github.jinahya.juso.go.kr.api.proxy.web.bind.addrlink;

import com.github.jinahya.juso.go.kr.api.proxy.context.properties.AddrEngApiConfigurationProperties;
import com.github.jinahya.juso.go.kr.api.proxy.stereotype.AddrEngApiService;
import com.github.jinahya.juso.go.kr.api.proxy.stereotype.type.addrlink.AddrEngApiRequest;
import com.github.jinahya.juso.go.kr.api.proxy.stereotype.type.addrlink.AddrEngApiResponse;
import com.github.jinahya.juso.go.kr.api.proxy.util.KeywordUtils;
import com.github.jinahya.juso.go.kr.api.proxy.web.bind.WebBindConstants;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping(
        path = {
                AddrEngApiController.REQUEST_MAPPING_PATH
        }
)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Slf4j
@SuppressWarnings({
        "java:S6813"
})
public class AddrEngApiController
        extends _AddrLinkController {

    static final String REQUEST_MAPPING_PATH = AddrEngApiConfigurationProperties.REQUEST_URI;

    // -----------------------------------------------------------------------------------------------------------------
    private AddrEngApiRequest set(final AddrEngApiRequest request, final Integer page, final Integer size) {
        if (request.getConfmKey() == null) {
            request.setConfmKey(properties.getConfmKey());
        }
        if (request.getCurrentPage() == null && page != null) {
            request.setCurrentPage(page + 1);
        }
        if (request.getCountPerPage() == null && size != null) {
            request.setCountPerPage(size);
        }
        request.setKeyword(KeywordUtils.filter(request.getKeyword()));
        request.setResultType(AddrEngApiRequest.PROPERTY_VALUE_RESULT_TYPE_JSON);
        return request;
    }

    // -----------------------------------------------------------------------------------------------------------------
    @GetMapping(
            produces = {
                    MediaType.APPLICATION_JSON_VALUE
            }
    )
    protected Mono<AddrEngApiResponse> get(
            @Valid
            @ModelAttribute final AddrEngApiRequest request,
            final BindingResult bindingResult,
            @PositiveOrZero
            @RequestParam(name = WebBindConstants.PARAM_NAME_PAGE, required = false) final Integer page,
            @Max(AddrEngApiRequest.PROPERTY_MAX_COUNT_PER_PAGE)
            @Positive
            @RequestParam(name = WebBindConstants.PARAM_NAME_SIZE, required = false) final Integer size) {
        bindingResult.getAllErrors().forEach(e -> {
            log.error("binding error: {}", e);
        });
        return service.retrieve(
                set(request, page, size)
        );
    }

    @PostMapping(
            consumes = {
                    MediaType.APPLICATION_JSON_VALUE
            },
            produces = {
                    MediaType.APPLICATION_JSON_VALUE
            }
    )
    protected Mono<AddrEngApiResponse> post(
            @Valid @NotNull @RequestBody final AddrEngApiRequest request,
            @PositiveOrZero
            @RequestParam(name = WebBindConstants.PARAM_NAME_PAGE, required = false) final Integer page,
            @Max(AddrEngApiRequest.PROPERTY_MAX_COUNT_PER_PAGE)
            @Positive
            @RequestParam(name = WebBindConstants.PARAM_NAME_SIZE, required = false) final Integer size) {
        return service.retrieve(
                set(request, page, size)
        );
    }

    // -----------------------------------------------------------------------------------------------------------------
    @Autowired
    private AddrEngApiConfigurationProperties properties;

    @Autowired
    @Accessors(fluent = true)
    @Setter(AccessLevel.NONE)
    @Getter(AccessLevel.PROTECTED)
    private AddrEngApiService service;
}
