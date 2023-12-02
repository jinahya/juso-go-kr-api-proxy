package com.github.jinahya.juso.go.kr.api.proxy.web.bind.addrlink;

import com.github.jinahya.juso.go.kr.api.proxy.context.properties.AddrDetailApiConfigurationProperties;
import com.github.jinahya.juso.go.kr.api.proxy.stereotype.AddrDetailApiService;
import com.github.jinahya.juso.go.kr.api.proxy.stereotype.type.addrlink.AddrDetailApiRequest;
import com.github.jinahya.juso.go.kr.api.proxy.stereotype.type.addrlink.AddrDetailApiResponse;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
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
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping(
        path = {
                AddrDetailApiController.REQUEST_MAPPING_PATH
        }
)
@NoArgsConstructor(access = AccessLevel.PACKAGE)
@Slf4j
@SuppressWarnings({
        "java:S6813"
})
public class AddrDetailApiController
        extends _AddrLinkController {

    static final String REQUEST_MAPPING_PATH = AddrDetailApiConfigurationProperties.REQUEST_URI;

    // -----------------------------------------------------------------------------------------------------------------
    private AddrDetailApiRequest set(final AddrDetailApiRequest request) {
        if (request.getConfmKey() == null) {
            request.setConfmKey(properties.getConfmKey());
        }
        request.setResultType(AddrDetailApiRequest.PROPERTY_VALUE_RESULT_TYPE_JSON);
        return request;
    }

    // -----------------------------------------------------------------------------------------------------------------
    @GetMapping(
            produces = {
                    MediaType.APPLICATION_JSON_VALUE
            }
    )
    protected Mono<AddrDetailApiResponse> get(@Valid @ModelAttribute final AddrDetailApiRequest request,
                                              final BindingResult bindingResult) {
        bindingResult.getAllErrors().forEach(e -> {
            log.error("binding error: {}", e);
        });
        return post(request);
    }

    @PostMapping(
            consumes = {
                    MediaType.APPLICATION_JSON_VALUE
            },
            produces = {
                    MediaType.APPLICATION_JSON_VALUE
            }
    )
    protected Mono<AddrDetailApiResponse> post(@Valid @NotNull @RequestBody final AddrDetailApiRequest request) {
        return service.retrieve(
                set(request)
        );
    }

    // -----------------------------------------------------------------------------------------------------------------
    @Autowired
    private AddrDetailApiConfigurationProperties properties;

    @Autowired
    @Accessors(fluent = true)
    @Setter(AccessLevel.NONE)
    @Getter(AccessLevel.PROTECTED)
    private AddrDetailApiService service;
}
