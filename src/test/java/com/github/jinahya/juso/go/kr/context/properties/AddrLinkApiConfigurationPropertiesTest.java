package com.github.jinahya.juso.go.kr.context.properties;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(
        classes = {
                AddrLinkApiConfigurationProperties.class
        })
@Slf4j
class AddrLinkApiConfigurationPropertiesTest
        extends _AddrApiConfigurationPropertiesTest<AddrLinkApiConfigurationProperties> {

    AddrLinkApiConfigurationPropertiesTest() {
        super(AddrLinkApiConfigurationProperties.class);
    }
}
