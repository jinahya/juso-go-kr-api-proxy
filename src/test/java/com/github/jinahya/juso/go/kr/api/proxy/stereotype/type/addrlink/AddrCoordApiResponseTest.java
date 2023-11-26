package com.github.jinahya.juso.go.kr.api.proxy.stereotype.type.addrlink;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.assertj.core.api.Assertions.assertThat;

@Disabled
class AddrCoordApiResponseTest
        extends _AddrlinkResponseTypeTest<AddrCoordApiResponse> {

    AddrCoordApiResponseTest() {
        super(AddrCoordApiResponse.class);
    }

    @Nested
    class ResourceTest {

        @DisplayName("AddrCoordApiResponse1.json")
        @Nested
        class AddrCoordApiResponse1 {

            private static final String NAME = "AddrCoordApiResponse1.json";

            @Test
            void __() throws IOException {
                final var value = deserializeResource(NAME);
                assertThat(value).isNotNull();
            }
        }
    }
}
