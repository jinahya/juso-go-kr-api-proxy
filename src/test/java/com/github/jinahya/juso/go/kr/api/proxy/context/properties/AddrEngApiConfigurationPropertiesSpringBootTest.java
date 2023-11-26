package com.github.jinahya.juso.go.kr.api.proxy.context.properties;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.test.context.ContextConfiguration;

import static org.assertj.core.api.Assertions.assertThat;

@ContextConfiguration(
        classes = {
                AddrEngApiConfigurationPropertiesSpringBootTest.Context_.class
        }
)
@Slf4j
class AddrEngApiConfigurationPropertiesSpringBootTest
        extends _AddrApiConfigurationPropertiesSpringBootTest<AddrEngApiConfigurationProperties> {

    @EnableConfigurationProperties({
            AddrEngApiConfigurationProperties.class
    })
    static class Context_ {

    }

    AddrEngApiConfigurationPropertiesSpringBootTest() {
        super(AddrEngApiConfigurationProperties.class);
    }

    // -----------------------------------------------------------------------------------------------------------------
    @Test
    void __() {
        assertThat(propertiesInstance()).isNotNull().satisfies(p -> {
            log.debug("p: {}", p);
            assertThat(p.getConfmKey()).as("confmKey").isNotBlank();
        });
    }
}
