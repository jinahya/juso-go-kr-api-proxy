package com.github.jinahya.juso.go.kr.api.proxy.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URISyntaxException;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Set;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

// https://en.wikipedia.org/wiki/List_of_SQL_reserved_words
final class SqlReservedWords {

    private static final String NAME = "sql-reserved-words.txt";

    private static Set<String> loadSqlReservedWords() throws URISyntaxException, IOException {
        try (final var resource = SqlReservedWords.class.getResourceAsStream(NAME)) {
            if (resource == null) {
                throw new RuntimeException("no resource loaded for " + NAME);
            }
            try (var reader = new BufferedReader(new InputStreamReader(resource));
                 var lines = reader.lines()) {
                return lines
                        .map(String::strip)
                        .filter(v -> !v.isBlank())
                        .filter(v -> !v.startsWith("#"))
                        .sorted(Comparator.comparingInt(String::length).reversed())
                        .collect(Collectors.toCollection(LinkedHashSet::new));
            }
        }
    }

    private static Set<String> set = null;

    static Set<String> getSqlReservedWords() {
        var result = set;
        if (result == null) {
            try {
                result = set = Collections.unmodifiableSet(loadSqlReservedWords());
            } catch (final Exception e) {
                throw new RuntimeException("failed to load sql reserved words", e);
            }
        }
        return result;
    }

    private static final Pattern PATTERN = Pattern.compile(
            String.join("|", getSqlReservedWords()),
            Pattern.CASE_INSENSITIVE
    );

    static String removeAllSqlReservedWords(final String string) {
        Objects.requireNonNull(string, "string is null");
        return PATTERN.matcher(string).replaceAll("");
    }

    // -----------------------------------------------------------------------------------------------------------------
    private SqlReservedWords() {
        throw new AssertionError("instantiation is not allowed");
    }
}
