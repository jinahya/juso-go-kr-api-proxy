package com.github.jinahya.juso.go.kr.api.proxy.web.bind.addrlink;

import com.github.jinahya.juso.go.kr.api.proxy.stereotype.type._BaseResultsType;
import com.github.jinahya.juso.go.kr.api.proxy.stereotype.type.addrlink.AddrLinkApiRequest;
import com.github.jinahya.juso.go.kr.api.proxy.stereotype.type.addrlink.AddrLinkApiResponse;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.BodyInserters;

import static org.assertj.core.api.Assertions.assertThat;

@Slf4j
class AddrLinkApiControllerSpringBootIT
        extends _AddrlinkControllerSpringBootIT<AddrLinkApiController> {

    // -----------------------------------------------------------------------------------------------------------------
    AddrLinkApiControllerSpringBootIT() {
        super(AddrLinkApiController.class);
    }

    // -----------------------------------------------------------------------------------------------------------------
    @ValueSource(strings = {
            "한국지역정보개발원",
            "청와대"
    })
    @ParameterizedTest
    void get__(final String keyword) {
        final var request = AddrLinkApiRequest.builder()
                .keyword(keyword)
                .countPerPage(10)
                .build();
        for (var currentPage = 1; ; currentPage++) {
            request.setCurrentPage(currentPage);
            // ---------------------------------------------------------------------------------------------------- when
            final var response =
                    webTestClient()
                            .get()
                            .uri(b -> {
                                return b.path('/' + AddrLinkApiController.REQUEST_MAPPING_PATH)
                                        .queryParams(request.toMultivalueMap(objectMapper()))
                                        .build();
                            })
                            .accept(MediaType.APPLICATION_JSON)
                            .exchange()
                            .expectStatus().isOk()
                            .returnResult(AddrLinkApiResponse.class)
                            .getResponseBody()
                            .blockLast();
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
    void post__(final String keyword) {
        final var request = new AddrLinkApiRequest();
        request.setKeyword(keyword);
        request.setCountPerPage(10);
        for (var currentPage = 1; ; currentPage++) {
            request.setCurrentPage(currentPage);
            // ---------------------------------------------------------------------------------------------------- when
            final var response =
                    webTestClient()
                            .post()
                            .uri(b -> b.path('/' + AddrLinkApiController.REQUEST_MAPPING_PATH).build())
                            .contentType(MediaType.APPLICATION_JSON)
                            .accept(MediaType.APPLICATION_JSON)
                            .body(BodyInserters.fromValue(request))
                            .exchange()
                            .expectStatus().isOk()
                            .returnResult(AddrLinkApiResponse.class)
                            .getResponseBody()
                            .blockLast();
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
}
