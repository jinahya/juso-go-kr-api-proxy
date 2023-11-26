package com.github.jinahya.juso.go.kr.api.proxy.web.bind.addrlink;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.github.jinahya.juso.go.kr.api.proxy.stereotype.type._BaseResultsType;
import com.github.jinahya.juso.go.kr.api.proxy.stereotype.type.addrlink.AddrEngApiRequest;
import com.github.jinahya.juso.go.kr.api.proxy.stereotype.type.addrlink.AddrEngApiResponse;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.BodyInserters;

import static org.assertj.core.api.Assertions.assertThat;

@Slf4j
class AddrEngApiControllerSpringBootIT
        extends _AddrlinkControllerSpringBootIT<AddrEngApiController> {

    // -----------------------------------------------------------------------------------------------------------------
    AddrEngApiControllerSpringBootIT() {
        super(AddrEngApiController.class);
    }

    // -----------------------------------------------------------------------------------------------------------------
    @ValueSource(strings = {
            "한국지역정보개발원",
            "청와대"
    })
    @ParameterizedTest
    void get__(final String keyword) {
        // ------------------------------------------------------------------------------------------------------- given
        final var request = AddrEngApiRequest.builder()
                .keyword(keyword)
                .countPerPage(10)
                .build();
        for (var currentPage = 1; ; currentPage++) {
            request.setCurrentPage(currentPage);
            log.debug("request: {}", request);
            printPretty(request);
            // ---------------------------------------------------------------------------------------------------- when
            final var response =
                    webTestClient()
                            .get()
                            .uri(b -> {
                                return b.path('/' + AddrEngApiController.REQUEST_MAPPING_PATH)
                                        .queryParams(request.toMultivalueMap(objectMapper()))
                                        .build();
                            })
                            .accept(MediaType.APPLICATION_JSON)
                            .exchange()
                            .expectStatus().isOk()
                            .returnResult(AddrEngApiResponse.class)
                            .getResponseBody()
                            .blockLast();
            log.debug("response: {}", response);
            printPretty(response);
            // ---------------------------------------------------------------------------------------------------- then
            assertThat(response).isNotNull().satisfies(r -> {
                assertThat(r.getUnknownProperties()).isEmpty();
            });
            final var results = response.getResults();
            assertThat(results).isNotNull().satisfies(r -> {
                assertThat(r.getUnknownProperties()).isEmpty();
                ;
            });
            final var common = results.getCommon();
            assertThat(common).isNotNull().satisfies(c -> {
                assertThat(c.getErrorCode()).isEqualTo(_BaseResultsType.Common.PROPERTY_VALUE_ERROR_CODE_0);
                assertThat(c.getUnknownProperties()).isEmpty();
            });
            final var juso = results.getJuso();
            assertThat(juso).isNotNull().allSatisfy(j -> {
                assertThat(j).isNotNull();
                assertThat(j.getUnknownProperties()).isEmpty();
            });
            if (juso.isEmpty()) {
                break;
            }
        }
    }

    @ValueSource(strings = {
            "한국지역정보개발원",
            "청와대"
    })
    @ParameterizedTest
    void post__(final String keyword) throws JsonProcessingException {
        // ------------------------------------------------------------------------------------------------------- given
        final var request = AddrEngApiRequest.builder()
                .keyword(keyword)
                .countPerPage(10)
                .build();
        for (var currentPage = 1; ; currentPage++) {
            request.setCurrentPage(currentPage);
            log.debug("request: {}", request);
            printPretty(request);
            // ---------------------------------------------------------------------------------------------------- when
            final var response =
                    webTestClient()
                            .post()
                            .uri(b -> b.path('/' + AddrEngApiController.REQUEST_MAPPING_PATH).build())
                            .contentType(MediaType.APPLICATION_JSON)
                            .accept(MediaType.APPLICATION_JSON)
                            .body(BodyInserters.fromValue(request))
                            .exchange()
                            .expectStatus().isOk()
                            .returnResult(AddrEngApiResponse.class)
                            .getResponseBody()
                            .blockLast();
            log.debug("response: {}", response);
            printPretty(response);
            // ---------------------------------------------------------------------------------------------------- then
            assertValid(response);
            assertThat(response).isNotNull().satisfies(r -> {
                assertThat(r.getUnknownProperties()).isEmpty();
            });
            final var results = response.getResults();
            assertThat(results).isNotNull().satisfies(r -> {
                assertThat(r.getUnknownProperties()).isEmpty();
            });
            final var common = results.getCommon();
            assertThat(common).isNotNull().satisfies(c -> {
                assertThat(c.getErrorCode()).isEqualTo(_BaseResultsType.Common.PROPERTY_VALUE_ERROR_CODE_0);
                assertThat(c.getUnknownProperties()).isEmpty();
            });
            final var juso = results.getJuso();
            assertThat(juso).isNotNull().allSatisfy(j -> {
                assertThat(j).isNotNull();
                assertThat(j.getUnknownProperties()).isEmpty();
            });
            if (juso.isEmpty()) {
                break;
            }
        }
    }
}
