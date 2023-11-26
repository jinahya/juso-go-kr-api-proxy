package com.github.jinahya.juso.go.kr.api.proxy.context;

import com.github.jinahya.juso.go.kr.api.proxy.context.properties.AddrLinkApiConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(
        classes = {
                AddrLinkApiConfiguration.class,
                AddrLinkApiConfigurationSpringBootTest.Context_.class
        }
)
class AddrLinkApiConfigurationSpringBootTest
        extends _AddrApiConfigurationSpringBootTest<AddrLinkApiConfiguration> {

    @EnableConfigurationProperties({
            AddrLinkApiConfigurationProperties.class
    })
    static class Context_ {

    }

    AddrLinkApiConfigurationSpringBootTest() {
        super(AddrLinkApiConfiguration.class);
    }
}
