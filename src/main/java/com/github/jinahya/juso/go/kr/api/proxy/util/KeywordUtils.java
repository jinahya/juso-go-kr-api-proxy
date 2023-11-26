package com.github.jinahya.juso.go.kr.api.proxy.util;

public final class KeywordUtils {

    public static String filter(final String keyword) {
        return SqlReservedWords.removeAllSqlReservedWords(
                SqlUnsafeCharacters.removeUnsafeCharacters(keyword)
        );
    }

    // -----------------------------------------------------------------------------------------------------------------

    private KeywordUtils() {
        throw new AssertionError("instantiation is not allowed");
    }
}
