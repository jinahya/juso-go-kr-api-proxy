package com.github.jinahya.juso.go.kr.streotype;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.github.jinahya.juso.go.kr.context.AddrEngApiConfiguration;
import com.github.jinahya.juso.go.kr.context.properties.AddrEngApiConfigurationProperties;
import com.github.jinahya.juso.go.kr.web.bind._type._BaseResultsType;
import com.github.jinahya.juso.go.kr.web.bind.addrlink._type.AddrEngApiRequest;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.jackson.JacksonAutoConfiguration;
import org.springframework.boot.autoconfigure.validation.ValidationAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(
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
    void __(final String keyword) throws JsonProcessingException {
        final var request = new AddrEngApiRequest();
        request.setConfmKey(properties.getConfmKey());
        request.setKeyword(keyword);
        request.setResultType("json");
        request.setCountPerPage(10);
        for (var currentPage = 1; ; currentPage++) {
            if (false && currentPage > 5) {
                break;
            }
            request.setCurrentPage(currentPage);
            System.out.println(objectMapper().writerWithDefaultPrettyPrinter().writeValueAsString(request));
            // ---------------------------------------------------------------------------------------------------- when
            final var response = serviceInstance().get(request).block();
            log.debug("response: {}", response);
            System.out.println(objectMapper().writerWithDefaultPrettyPrinter().writeValueAsString(response));
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
            assertThat(validator().validate(response)).isEmpty();
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
