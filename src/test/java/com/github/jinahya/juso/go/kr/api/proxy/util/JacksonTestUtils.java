package com.github.jinahya.juso.go.kr.api.proxy.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.util.DefaultIndenter;
import com.fasterxml.jackson.core.util.DefaultPrettyPrinter;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;

import java.util.Map;
import java.util.Objects;
import java.util.WeakHashMap;

public final class JacksonTestUtils {

    private static final Map<ObjectMapper, ObjectWriter> PRETTY_WRITERS = new WeakHashMap<>();

    public static ObjectWriter prettyWriter(final ObjectMapper objectMapper) {
        Objects.requireNonNull(objectMapper, "objectMapper is null");
        return PRETTY_WRITERS.computeIfAbsent(objectMapper, k -> {
            final var prettyPrinter = new DefaultPrettyPrinter();
            prettyPrinter.indentArraysWith(DefaultIndenter.SYSTEM_LINEFEED_INSTANCE);
            return k.writer(prettyPrinter);
        });
    }

    public static String writeValueAsPrettyString(final ObjectMapper objectMapper, final Object value)
            throws JsonProcessingException {
        Objects.requireNonNull(value, "value is null");
        return prettyWriter(objectMapper).writeValueAsString(value);
    }

    private JacksonTestUtils() {
        throw new AssertionError("instantiation is not allowed");
    }
}
