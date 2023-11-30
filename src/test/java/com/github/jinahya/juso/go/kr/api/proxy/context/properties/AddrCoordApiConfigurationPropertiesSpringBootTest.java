package com.github.jinahya.juso.go.kr.api.proxy.context.properties;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.test.context.ContextConfiguration;

import static org.assertj.core.api.Assertions.assertThat;

@ContextConfiguration(
        classes = {
                AddrCoordApiConfigurationPropertiesSpringBootTest.Context_.class
        }
)
@Slf4j
class AddrCoordApiConfigurationPropertiesSpringBootTest
        extends _AddrApiConfigurationPropertiesSpringBootTest<AddrCoordApiConfigurationProperties> {

    @EnableConfigurationProperties({
            AddrCoordApiConfigurationProperties.class
    })
    static class Context_ {

    }

    AddrCoordApiConfigurationPropertiesSpringBootTest() {
        super(AddrCoordApiConfigurationProperties.class);
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
