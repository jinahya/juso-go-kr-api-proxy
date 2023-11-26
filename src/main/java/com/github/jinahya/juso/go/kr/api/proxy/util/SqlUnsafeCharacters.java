package com.github.jinahya.juso.go.kr.api.proxy.util;

import java.util.List;
import java.util.Objects;
import java.util.regex.Pattern;
import java.util.stream.Collector;

final class SqlUnsafeCharacters {

    // -----------------------------------------------------------------------------------------------------------------

    private static final List<Character> UNSAFE_CHARACTERS = List.of(
            '%',
            '=',
            '>',
            '<'
    );

    private static final String REGEXP_UNSAFE_CHARACTERS =
            "[" +
            UNSAFE_CHARACTERS.stream().collect(
                    Collector.of(StringBuilder::new,
                                 StringBuilder::append,
                                 StringBuilder::append,
                                 StringBuilder::toString)
            ) +
            "]";

    private static final Pattern PATTERN_UNSAFE_CHARACTERS = Pattern.compile(REGEXP_UNSAFE_CHARACTERS);

    static boolean containsAnyUnsafeCharacter(final String keyword) {
        Objects.requireNonNull(keyword, "keyword is null");
        for (final char c : UNSAFE_CHARACTERS) {
            if (keyword.indexOf(c) != -1) {
                return true;
            }
        }
        return false;
    }

    static String removeUnsafeCharacters(final String keyword) {
        Objects.requireNonNull(keyword, "keyword is null");
        return PATTERN_UNSAFE_CHARACTERS.matcher(keyword).replaceAll("");
    }

    // -----------------------------------------------------------------------------------------------------------------

    private SqlUnsafeCharacters() {
        throw new AssertionError("instantiation is not allowed");
    }
}
