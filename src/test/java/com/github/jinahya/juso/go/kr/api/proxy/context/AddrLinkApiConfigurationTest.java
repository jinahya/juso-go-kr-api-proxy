package com.github.jinahya.juso.go.kr.api.proxy.context;

import com.github.jinahya.juso.go.kr.api.proxy.context.properties.AddrLinkApiConfigurationProperties;
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
