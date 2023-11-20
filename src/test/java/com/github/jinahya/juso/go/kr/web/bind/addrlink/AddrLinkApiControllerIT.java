package com.github.jinahya.juso.go.kr.web.bind.addrlink;

import com.github.jinahya.juso.go.kr.web.bind.WebBindConstants;
import com.github.jinahya.juso.go.kr.web.bind.addrlink.type.AddrLinkApiRequest;
import com.github.jinahya.juso.go.kr.web.bind.addrlink.type.AddrLinkApiResponse;
import com.github.jinahya.juso.go.kr.web.bind.addrlink.type.AddrLinkApiResult;
import com.github.jinahya.juso.go.kr.web.bind.addrlink.type.AddrLinkApiResultJuso;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Optional;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.atomic.AtomicInteger;

import static org.assertj.core.api.Assertions.assertThat;

// https://docs.spring.io/spring-framework/reference/testing/webtestclient.html
@Slf4j
class AddrLinkApiControllerIT
        extends _AddrLinkControllerIT<AddrLinkApiController> {

    // -----------------------------------------------------------------------------------------------------------------
    AddrLinkApiControllerIT() {
        super(AddrLinkApiController.class);
    }

    // -----------------------------------------------------------------------------------------------------------------
    @ValueSource(strings = {
//            "한국지역정보개발원",
//            "경강로유현8길",
//            "경강로유현8길 11",
//            "경강로유현8길 11-10",
            "강남대로 577"
    })
    @ParameterizedTest
    void __(final String keyword) {
        final var request = new AddrLinkApiRequest();
        request.setKeyword(keyword);
        request.setResultType(AddrLinkApiRequest.PROPERTY_VALUE_RESULT_TYPE_JSON);
        final var page = new AtomicInteger(1);
        final var size = ThreadLocalRandom.current().nextBoolean()
                         ? ThreadLocalRandom.current().nextInt(1, AddrLinkApiRequest.PROPERTY_MAX_COUNT_PER_PAGE + 1)
                         : null;
        while (true) {
            final var response = webTestClient()
                    .get()
                    .uri(b -> request.put(b)
                            .queryParam(WebBindConstants.PARAM_NAME_PAGE, page.getAndIncrement())
                            .queryParamIfPresent(WebBindConstants.PARAM_NAME_SIZE, Optional.ofNullable(size))
                            .build())
                    .exchange()
                    .expectStatus().isOk()
                    .expectBody(AddrLinkApiResponse.class)
                    .returnResult()
                    .getResponseBody();
            log.debug("response:{}", response);
            assertThat(response).isNotNull();
            final var juso = Optional.ofNullable(response.getResults()).map(AddrLinkApiResult::getJuso).orElse(null);
            if (juso == null || juso.isEmpty()) {
                break;
            }
            for (final AddrLinkApiResultJuso j : juso) {
                log.debug("juso: {}", j);
            }
        }
    }
}
