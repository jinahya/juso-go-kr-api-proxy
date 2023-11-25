package com.github.jinahya.juso.go.kr.api.proxy.web.bind.addrlink._type;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.Objects;

import static org.assertj.core.api.Assertions.assertThat;

public final class AddrLinkApiResponseTestUtils {

    public static AddrLinkApiResponse readValueFromResource(final String name, final ObjectMapper mapper)
            throws IOException {
        Objects.requireNonNull(name, "name is null");
        Objects.requireNonNull(mapper, "mapper is null");
        try (var resource = AddrLinkApiResponseTestUtils.class.getResourceAsStream(name)) {
            assertThat(resource).isNotNull();
            return mapper.readValue(resource, AddrLinkApiResponse.class);
        }
    }

    private AddrLinkApiResponseTestUtils() {
        super();
    }
}
