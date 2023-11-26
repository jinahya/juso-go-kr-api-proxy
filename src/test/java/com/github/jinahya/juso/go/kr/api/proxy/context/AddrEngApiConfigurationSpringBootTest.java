package com.github.jinahya.juso.go.kr.api.proxy.context;

import com.github.jinahya.juso.go.kr.api.proxy.context.properties.AddrEngApiConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(
        classes = {
                AddrEngApiConfiguration.class,
                AddrEngApiConfigurationSpringBootTest.Context_.class
        }
)
class AddrEngApiConfigurationSpringBootTest
        extends _AddrApiConfigurationSpringBootTest<AddrEngApiConfiguration> {

    @EnableConfigurationProperties({
            AddrEngApiConfigurationProperties.class
    })
    static class Context_ {

    }

    AddrEngApiConfigurationSpringBootTest() {
        super(AddrEngApiConfiguration.class);
    }
}
