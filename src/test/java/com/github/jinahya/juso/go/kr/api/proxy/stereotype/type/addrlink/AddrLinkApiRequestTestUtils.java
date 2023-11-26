package com.github.jinahya.juso.go.kr.api.proxy.stereotype.type.addrlink;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.Objects;

import static org.assertj.core.api.Assertions.assertThat;

public final class AddrLinkApiRequestTestUtils {

    public static AddrLinkApiRequest readValueFromResource(final String name, final ObjectMapper mapper)
            throws IOException {
        Objects.requireNonNull(name, "name is null");
        Objects.requireNonNull(mapper, "mapper is null");
        try (var resource = AddrLinkApiRequestTestUtils.class.getResourceAsStream(name)) {
            assertThat(resource).isNotNull();
            return mapper.readValue(resource, AddrLinkApiRequest.class);
        }
    }

    private AddrLinkApiRequestTestUtils() {
        super();
    }
}
