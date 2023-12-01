package com.github.jinahya.juso.go.kr.api.proxy.stereotype;

import com.github.jinahya.juso.go.kr.api.proxy.context.AddrLinkApiConfiguration;
import com.github.jinahya.juso.go.kr.api.proxy.context.properties.AddrLinkApiConfigurationProperties;
import com.github.jinahya.juso.go.kr.api.proxy.stereotype.type._BaseResultsType;
import com.github.jinahya.juso.go.kr.api.proxy.stereotype.type.addrlink.AddrLinkApiRequest;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;

import static org.assertj.core.api.Assertions.assertThat;

//@Import(AnnotationAwareAspectJAutoProxyCreator.class)
@ContextConfiguration(
        classes = {
                AddrRetrievalEventListener.class,
                AddrLinkApiService.class,
                AddrLinkApiConfiguration.class,
                AddrLinkApiConfigurationProperties.class
        }
)
@Slf4j
class AddrLinkApiServiceIT
        extends _BaseServiceIT<AddrLinkApiService> {

    AddrLinkApiServiceIT() {
        super(AddrLinkApiService.class);
    }

    // -----------------------------------------------------------------------------------------------------------------
    @ValueSource(strings = {
            "한국지역정보개발원",
//            "청와대"
    })
    @ParameterizedTest
    void retrieve__(final String keyword) {
        final var request = new AddrLinkApiRequest();
        request.setConfmKey(properties.getConfmKey());
        request.setKeyword(keyword);
        request.setResultType("json");
        request.setCountPerPage(10);
        for (var currentPage = 1; ; currentPage++) {
            request.setCurrentPage(currentPage);
            log.debug("request: {}", request);
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
            assertThat(juso).isNotNull().allSatisfy(j -> {
                assertThat(j).isNotNull();
                assertThat(j.getUnknownProperties()).isEmpty();
            });
            assertValid(response);
            if (juso.isEmpty()) {
                break;
            }
        }
    }

    // ------------------------------------------------------------------------------------------------------ properties

    // -----------------------------------------------------------------------------------------------------------------
    @Autowired
    private AddrLinkApiConfigurationProperties properties;
}
