package com.github.jinahya.juso.go.kr.api.proxy.web.bind._type.util;

import java.util.List;
import java.util.Objects;
import java.util.regex.Pattern;
import java.util.stream.Collector;

public final class KeywordUtils {

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

    public static boolean containsAnyUnsafeCharacter(final String keyword) {
        Objects.requireNonNull(keyword, "keyword is null");
        for (final char c : UNSAFE_CHARACTERS) {
            if (keyword.indexOf(c) != -1) {
                return true;
            }
        }
        return false;
    }

    public static String removeUnsafeCharacters(final String keyword) {
        Objects.requireNonNull(keyword, "keyword is null");
        return PATTERN_UNSAFE_CHARACTERS.matcher(keyword).replaceAll("");
    }

    // -----------------------------------------------------------------------------------------------------------------
    public static boolean containsAnySqlReservedWord(final String keyword) {
        Objects.requireNonNull(keyword, "keyword is null");
        for (var sqlReservedWord : SqlReservedWords.getSqlReservedWords()) {
            if (keyword.contains(sqlReservedWord)) {
                return true;
            }
        }
        return false;
    }

    private static final String REGEXP_SQL_RESERVED_WORDS =
            "(" +
            String.join("|", SqlReservedWords.getSqlReservedWords()) +
            ")";

    private static final Pattern PATTERN_SQL_RESERVED_WORDS = Pattern.compile(REGEXP_SQL_RESERVED_WORDS);

    public static String removeAllSqlReservedWords(final String keyword) {
        Objects.requireNonNull(keyword, "keyword is null");
        return PATTERN_SQL_RESERVED_WORDS.matcher(keyword).replaceAll("");
    }

    // -----------------------------------------------------------------------------------------------------------------

    private KeywordUtils() {
        throw new AssertionError("instantiation is not allowed");
    }
}
