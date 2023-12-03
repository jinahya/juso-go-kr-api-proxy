package com.github.jinahya.juso.go.kr.api.proxy.web.bind.addrlink;

import com.github.jinahya.juso.go.kr.api.proxy.context.properties.AddrEngApiConfigurationProperties;
import com.github.jinahya.juso.go.kr.api.proxy.stereotype.AddrEngApiService;
import com.github.jinahya.juso.go.kr.api.proxy.stereotype.type.addrlink.AddrEngApiRequest;
import com.github.jinahya.juso.go.kr.api.proxy.stereotype.type.addrlink.AddrEngApiResponse;
import com.github.jinahya.juso.go.kr.api.proxy.web.bind.WebBindConstants;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.Mockito;
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.BodyInserters;
import reactor.core.publisher.Mono;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.argThat;
import static org.mockito.ArgumentMatchers.notNull;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@WebFluxTest(
        controllers = {
                AddrEngApiController.class
        }
)
@Slf4j
class AddrEngApiControllerWebFluxTest
        extends _AddrlinkControllerWebFluxTest<AddrEngApiController> {

    // -----------------------------------------------------------------------------------------------------------------
    AddrEngApiControllerWebFluxTest() {
        super(AddrEngApiController.class);
    }

    @BeforeEach
    void __() {
        given(service.retrieve(notNull(AddrEngApiRequest.class))).willAnswer(i -> {
            final var request = i.getArgument(0, AddrEngApiRequest.class);
            final var response = AddrEngApiResponse.builder()
                    .build();
            return Mono.just(response);
        });
        Mockito.clearInvocations(service);
    }

    // -----------------------------------------------------------------------------------------------------------------
    @ValueSource(strings = {
            "한국지역정보개발원",
            "청와대"
    })
    @ParameterizedTest
    void get__(final String keyword) {
        // ------------------------------------------------------------------------------------------------------- given
        final var request = new AddrEngApiRequest();
        request.setKeyword(keyword);
        // --------------------------------------------------------------------------------------------------- when/then
        final var result = webTestClient()
                .get()
                .uri(b -> {
                    return b.path(AddrEngApiController.REQUEST_MAPPING_PATH)
                            .queryParams(request.toMultivalueMap(objectMapper()))
                            .queryParam(WebBindConstants.PARAM_NAME_PAGE, 0)
                            .queryParam(WebBindConstants.PARAM_NAME_SIZE, 5)
                            .build();
                })
                .exchange()
                .expectStatus()
                .isOk()
                .expectBody(AddrEngApiResponse.class)
                .returnResult();
        final var response = result.getResponseBody();
        assertThat(response).isNotNull();
        verify(service, times(1)).retrieve(argThat(q -> {
            assertValid(q);
            return true;
        }));
    }

    @ValueSource(strings = {
            "한국지역정보개발원",
            "청와대"
    })
    @ParameterizedTest
    void post__(final String keyword) {
        // ------------------------------------------------------------------------------------------------------- given
        final var request = new AddrEngApiRequest();
        request.setKeyword(keyword);
        // --------------------------------------------------------------------------------------------------- when/then
        final var result = webTestClient()
                .post()
                .uri(b -> {
                    return b.path(AddrEngApiController.REQUEST_MAPPING_PATH)
                            .queryParam(WebBindConstants.PARAM_NAME_PAGE, 0)
                            .queryParam(WebBindConstants.PARAM_NAME_SIZE, 5)
                            .build();
                })
                .contentType(MediaType.APPLICATION_JSON)
                .body(BodyInserters.fromValue(request))
                .exchange()
                .expectStatus()
                .isOk()
                .expectBody(AddrEngApiResponse.class)
                .returnResult();
        final var response = result.getResponseBody();
        assertThat(response).isNotNull();
        verify(service, times(1)).retrieve(argThat(q -> {
            assertValid(q);
            return true;
        }));
    }

    // -----------------------------------------------------------------------------------------------------------------
    @MockBean
    private AddrEngApiConfigurationProperties properties;

    @MockBean
    private AddrEngApiService service;
}
