package com.github.jinahya.juso.go.kr.api.proxy.context;

import com.github.jinahya.juso.go.kr.api.proxy.context.properties.AddrCoordApiConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(
        classes = {
                AddrCoordApiConfiguration.class,
                AddrCoordApiConfigurationSpringBootTest.Context_.class
        }
)
class AddrCoordApiConfigurationSpringBootTest
        extends _AddrApiConfigurationSpringBootTest<AddrCoordApiConfiguration> {

    @EnableConfigurationProperties({
            AddrCoordApiConfigurationProperties.class
    })
    static class Context_ {

    }

    AddrCoordApiConfigurationSpringBootTest() {
        super(AddrCoordApiConfiguration.class);
    }
}
