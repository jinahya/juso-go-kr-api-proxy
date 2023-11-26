package com.github.jinahya.juso.go.kr.api.proxy.stereotype;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.github.jinahya.juso.go.kr.api.proxy.context.AddrDetailApiConfiguration;
import com.github.jinahya.juso.go.kr.api.proxy.context.properties.AddrDetailApiConfigurationProperties;
import com.github.jinahya.juso.go.kr.api.proxy.stereotype.type._BaseResultsType;
import com.github.jinahya.juso.go.kr.api.proxy.stereotype.type.addrlink.AddrDetailApiRequest;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.jackson.JacksonAutoConfiguration;
import org.springframework.boot.autoconfigure.validation.ValidationAutoConfiguration;
import org.springframework.test.context.ContextConfiguration;

import static org.assertj.core.api.Assertions.assertThat;

@ContextConfiguration(
        classes = {
                AddrDetailService.class,
                AddrDetailApiConfiguration.class,
                AddrDetailApiConfigurationProperties.class,
                JacksonAutoConfiguration.class,
                ValidationAutoConfiguration.class
        }
)
@Slf4j
class AddrDetailServiceIT
        extends _BaseServiceIT<AddrDetailService> {

    AddrDetailServiceIT() {
        super(AddrDetailService.class);
    }

    // -----------------------------------------------------------------------------------------------------------------
    @Test
    void retrieve__() throws JsonProcessingException {
        // ------------------------------------------------------------------------------------------------------- given
        final var request = AddrDetailApiRequest.builder()
                .confmKey(properties.getConfmKey())
                .admCd("1135010200")
                .rnMgtSn("113503109006")
                .udrtYn("0")
                .buldMnnm(111)
                .buldSlno(0)
                .searchType(AddrDetailApiRequest.PROPERTY_VALUE_SEARCH_TYPE_DONG)
                .dongNm("17동")
                .resultType(AddrDetailApiRequest.PROPERTY_VALUE_RESULT_TYPE_JSON)
                .build();
        log.debug("request: {}", request);
        printPretty(request);
        // -------------------------------------------------------------------------------------------------------- when
        final var response = serviceInstance().retrieve(request).block();
        log.debug("response: {}", response);
        printPretty(response);
        // -------------------------------------------------------------------------------------------------------- then
        assertThat(response)
                .isNotNull()
                .satisfies(r -> {
                    assertThat(r.getUnknownProperties()).isEmpty();
                });
        final var results = response.getResults();
        assertThat(results)
                .isNotNull()
                .satisfies(r -> {
                    assertThat(r.getUnknownProperties()).isEmpty();
                });
        final var common = results.getCommon();
        assertThat(common)
                .isNotNull()
                .satisfies(c -> {
                    assertThat(c.getErrorCode())
                            .isEqualTo(_BaseResultsType.Common.PROPERTY_VALUE_ERROR_CODE_0);
                    assertThat(c.getUnknownProperties()).isEmpty();
                });
        final var juso = results.getJuso();
        assertThat(juso)
                .isNotNull()
                .isNotEmpty()
                .doesNotContainNull()
                .allSatisfy(j -> {
                    assertThat(j.getUnknownProperties()).isEmpty();
                });
        assertValid(response);
    }

    // ------------------------------------------------------------------------------------------------------ properties
    @Autowired
    private AddrDetailApiConfigurationProperties properties;
}
