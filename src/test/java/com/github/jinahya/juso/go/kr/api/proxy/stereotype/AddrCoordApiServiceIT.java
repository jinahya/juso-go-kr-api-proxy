package com.github.jinahya.juso.go.kr.api.proxy.stereotype;

import com.github.jinahya.juso.go.kr.api.proxy.context.AddrCoordApiConfiguration;
import com.github.jinahya.juso.go.kr.api.proxy.context.properties.AddrCoordApiConfigurationProperties;
import com.github.jinahya.juso.go.kr.api.proxy.stereotype.type._BaseResultsType;
import com.github.jinahya.juso.go.kr.api.proxy.stereotype.type.__BaseTypeConstants;
import com.github.jinahya.juso.go.kr.api.proxy.stereotype.type.addrlink.AddrCoordApiRequest;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.jackson.JacksonAutoConfiguration;
import org.springframework.boot.autoconfigure.validation.ValidationAutoConfiguration;
import org.springframework.test.context.ContextConfiguration;

import static org.assertj.core.api.Assertions.assertThat;

@Disabled
@ContextConfiguration(
        classes = {
                AddrCoordApiService.class,
                AddrCoordApiConfiguration.class,
                AddrCoordApiConfigurationProperties.class,
                JacksonAutoConfiguration.class,
                ValidationAutoConfiguration.class
        }
)
@Slf4j
class AddrCoordApiServiceIT
        extends _BaseServiceIT<AddrCoordApiService> {

    AddrCoordApiServiceIT() {
        super(AddrCoordApiService.class);
    }

    // -----------------------------------------------------------------------------------------------------------------
    @Test
    void retrieve__() {
        // ------------------------------------------------------------------------------------------------------- given
        final var request = AddrCoordApiRequest.builder()
                .confmKey(properties.getConfmKey())
                .admCd("1135010200")
                .rnMgtSn("113503109006")
                .udrtYn("0")
                .buldMnnm(111)
                .buldSlno(0)
                .resultType(__BaseTypeConstants.PROPERTY_VALUE_RESULT_TYPE_JSON)
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
    private AddrCoordApiConfigurationProperties properties;
}
