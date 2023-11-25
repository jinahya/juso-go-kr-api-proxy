package com.github.jinahya.juso.go.kr.api.proxy.context.properties;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

//@EnableConfigurationProperties({
//        AddrLinkApiConfigurationProperties.class
//})
@ConfigurationPropertiesScan
@SpringBootTest(
        classes = {
                AddrLinkApiConfigurationProperties.class
        }
)
@Slf4j
class AddrLinkApiConfigurationPropertiesTest
        extends _AddrApiConfigurationPropertiesTest<AddrLinkApiConfigurationProperties> {

    AddrLinkApiConfigurationPropertiesTest() {
        super(AddrLinkApiConfigurationProperties.class);
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
