package com.github.jinahya.juso.go.kr.api.proxy.context;

import com.github.jinahya.juso.go.kr.api.proxy.context.properties.AddrDetailApiConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(
        classes = {
                AddrDetailApiConfiguration.class,
                AddrDetailApiConfigurationSpringBootTest.Context_.class
        }
)
class AddrDetailApiConfigurationSpringBootTest
        extends _AddrApiConfigurationSpringBootTest<AddrDetailApiConfiguration> {

    @EnableConfigurationProperties({
            AddrDetailApiConfigurationProperties.class
    })
    static class Context_ {

    }

    AddrDetailApiConfigurationSpringBootTest() {
        super(AddrDetailApiConfiguration.class);
    }
}
