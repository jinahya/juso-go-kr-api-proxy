package com.github.jinahya.juso.go.kr.api.proxy.web.bind.addrlink;

import com.github.jinahya.juso.go.kr.api.proxy.stereotype.type._BaseResultsType;
import com.github.jinahya.juso.go.kr.api.proxy.stereotype.type.addrlink.AddrDetailApiRequest;
import com.github.jinahya.juso.go.kr.api.proxy.stereotype.type.addrlink.AddrDetailApiResponse;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.BodyInserters;

import static org.assertj.core.api.Assertions.assertThat;

@Slf4j
class AddrDetailApiControllerSpringBootIT
        extends _AddrlinkControllerSpringBootIT<AddrDetailApiController> {

    // -----------------------------------------------------------------------------------------------------------------
    AddrDetailApiControllerSpringBootIT() {
        super(AddrDetailApiController.class);
    }

    // -----------------------------------------------------------------------------------------------------------------
    @Test
    void get__() {
        // ------------------------------------------------------------------------------------------------------- given
        final var request = AddrDetailApiRequest.builder()
                .admCd("1135010200")
                .rnMgtSn("113503109006")
                .udrtYn("0")
                .buldMnnm(111)
                .buldSlno(0)
//                .searchType(AddrDetailApiRequest.PROPERTY_VALUE_SEARCH_TYPE_DONG)
//                .dongNm("17동")
//                .resultType(AddrDetailApiRequest.PROPERTY_VALUE_RESULT_TYPE_JSON)
                .build();
        log.debug("request: {}", request);
        printPretty(request);
        // -------------------------------------------------------------------------------------------------------- when
        final var response =
                webTestClient()
                        .get()
                        .uri(b -> {
                            return b.path('/' + AddrDetailApiController.REQUEST_MAPPING_PATH)
                                    .queryParams(request.toMultivalueMap(objectMapper()))
                                    .build();
                        })
                        .accept(MediaType.APPLICATION_JSON)
                        .exchange()
                        .expectStatus().isOk()
                        .returnResult(AddrDetailApiResponse.class)
                        .getResponseBody()
                        .blockLast();
        log.debug("response: {}", response);
        printPretty(response);
        // -------------------------------------------------------------------------------------------------------- then
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
    }

    @Test
    void post__() {
        // ------------------------------------------------------------------------------------------------------- given
        final var request = AddrDetailApiRequest.builder()
                .admCd("1135010200")
                .rnMgtSn("113503109006")
                .udrtYn("0")
                .buldMnnm(111)
                .buldSlno(0)
//                .searchType(AddrDetailApiRequest.PROPERTY_VALUE_SEARCH_TYPE_DONG)
//                .dongNm("17동")
//                .resultType(AddrDetailApiRequest.PROPERTY_VALUE_RESULT_TYPE_JSON)
                .build();
        log.debug("request: {}", request);
        printPretty(request);
        // -------------------------------------------------------------------------------------------------------- when
        final var response =
                webTestClient()
                        .post()
                        .uri(b -> b.path('/' + AddrDetailApiController.REQUEST_MAPPING_PATH).build())
                        .accept(MediaType.APPLICATION_JSON)
                        .contentType(MediaType.APPLICATION_JSON)
                        .body(BodyInserters.fromValue(request))
                        .exchange()
                        .expectStatus().isOk()
                        .returnResult(AddrDetailApiResponse.class)
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
        assertThat(juso)
                .isNotNull()
                .isNotEmpty()
                .allSatisfy(j -> {
                    assertThat(j).isNotNull();
                    assertThat(j.getUnknownProperties()).isEmpty();
                });
    }
}
