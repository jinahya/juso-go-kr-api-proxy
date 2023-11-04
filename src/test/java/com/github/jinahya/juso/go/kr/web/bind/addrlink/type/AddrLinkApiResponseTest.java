package com.github.jinahya.juso.go.kr.web.bind.addrlink.type;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.io.IOException;

class AddrLinkApiResponseTest
        extends _AddrlinkResponseTypeTest<AddrLinkApiResponse> {

    AddrLinkApiResponseTest() {
        super(AddrLinkApiResponse.class);
    }

    @Nested
    class ResourceTest {

        private static final String NAME = "AddrLinkApiResponse.json";

        @Test
        void __() throws IOException {
            final var value = deserializeResource(NAME);
        }
    }
}
