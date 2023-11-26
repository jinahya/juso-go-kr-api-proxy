package com.github.jinahya.juso.go.kr.api.proxy.stereotype;

import com.github.jinahya.juso.go.kr.api.proxy.context.AddrEngApiConfiguration;
import com.github.jinahya.juso.go.kr.api.proxy.context.properties.AddrEngApiConfigurationProperties;
import com.github.jinahya.juso.go.kr.api.proxy.stereotype.type._BaseResultsType;
import com.github.jinahya.juso.go.kr.api.proxy.stereotype.type.addrlink.AddrEngApiRequest;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.jackson.JacksonAutoConfiguration;
import org.springframework.boot.autoconfigure.validation.ValidationAutoConfiguration;
import org.springframework.test.context.ContextConfiguration;

import static org.assertj.core.api.Assertions.assertThat;

@ContextConfiguration(
        classes = {
                AddrEngService.class,
//                CacheConfiguration.class,
                AddrEngApiConfiguration.class,
                AddrEngApiConfigurationProperties.class,
                JacksonAutoConfiguration.class,
                ValidationAutoConfiguration.class
        }
)
@Slf4j
class AddrEngServiceIT
        extends _BaseServiceIT<AddrEngService> {

    AddrEngServiceIT() {
        super(AddrEngService.class);
    }

    // -----------------------------------------------------------------------------------------------------------------
    @ValueSource(strings = {
            "한국지역정보개발원",
            "청와대"
    })
    @ParameterizedTest
    void retrieve__(final String keyword) {
        final var request = AddrEngApiRequest.builder()
                .confmKey(properties.getConfmKey())
                .keyword(keyword)
                .resultType("json")
                .countPerPage(10)
                .build();
        for (var currentPage = 1; ; currentPage++) {
            request.setCurrentPage(currentPage);
            log.debug("reqeust: {}", request);
            printPretty(request);
            // ---------------------------------------------------------------------------------------------------- when
            final var response = serviceInstance().retrieve(request).block();
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
            assertThat(juso).isNotNull().doesNotContainNull().allSatisfy(j -> {
                assertThat(j.getUnknownProperties()).isEmpty();
            });
            assertValid(response);
            if (juso.isEmpty()) {
                break;
            }
        }
    }

    // ------------------------------------------------------------------------------------------------------ properties

    // --------------------------------------------------------------------------------------------------------- service

    // ---------------------------------------------------------------------------------------------------- objectMapper

    // ------------------------------------------------------------------------------------------------------- validator

    // -----------------------------------------------------------------------------------------------------------------
    @Autowired
    private AddrEngApiConfigurationProperties properties;
}
