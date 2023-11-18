package com.github.jinahya.juso.go.kr.context;

import com.github.jinahya.juso.go.kr.context.properties.AddrLinkApiConfigurationProperties;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(
        classes = {
                AddrLinkApiConfiguration.class,
                AddrLinkApiConfigurationProperties.class
        }
)
class AddrLinkApiConfigurationTest
        extends _AddrApiConfigurationTest<AddrLinkApiConfiguration> {

    AddrLinkApiConfigurationTest() {
        super(AddrLinkApiConfiguration.class);
    }
}
