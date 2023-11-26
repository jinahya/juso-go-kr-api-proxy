package com.github.jinahya.juso.go.kr.api.proxy.context.properties;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.test.context.ContextConfiguration;

import static org.assertj.core.api.Assertions.assertThat;

@ContextConfiguration(
        classes = {
                AddrDetailApiConfigurationPropertiesSpringBootTest.Context_.class
        }
)
@Slf4j
class AddrDetailApiConfigurationPropertiesSpringBootTest
        extends _AddrApiConfigurationPropertiesSpringBootTest<AddrDetailApiConfigurationProperties> {

    @EnableConfigurationProperties({
            AddrDetailApiConfigurationProperties.class
    })
    static class Context_ {

    }

    AddrDetailApiConfigurationPropertiesSpringBootTest() {
        super(AddrDetailApiConfigurationProperties.class);
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
