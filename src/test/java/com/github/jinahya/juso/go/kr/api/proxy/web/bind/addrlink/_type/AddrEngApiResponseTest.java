package com.github.jinahya.juso.go.kr.api.proxy.web.bind.addrlink._type;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.assertj.core.api.Assertions.assertThat;

class AddrEngApiResponseTest
        extends _AddrlinkResponseTypeTest<AddrEngApiResponse> {

    AddrEngApiResponseTest() {
        super(AddrEngApiResponse.class);
    }

    @Nested
    class ResourceTest {

        @DisplayName("AddrEngApiResponse1.json")
        @Nested
        class AddrEngApiResponse1 {

            private static final String NAME = "AddrEngApiResponse1.json";

            @Test
            void __() throws IOException {
                final var value = deserializeResource(NAME);
                assertThat(value).isNotNull();
            }
        }
    }
}
