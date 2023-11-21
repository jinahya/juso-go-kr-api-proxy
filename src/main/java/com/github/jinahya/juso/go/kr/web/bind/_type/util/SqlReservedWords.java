package com.github.jinahya.juso.go.kr.web.bind._type.util;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Set;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

// https://en.wikipedia.org/wiki/List_of_SQL_reserved_words
public final class SqlReservedWords {

    private static final String NAME = "sql-reserved-words.txt";

    private static Set<String> loadSqlReservedWords() throws URISyntaxException, IOException {
        final var resource = SqlReservedWords.class.getResource(NAME);
        if (resource == null) {
            throw new RuntimeException("no resource loaded for " + NAME);
        }
        try (var stream = Files.lines(new File(resource.toURI()).toPath())) {
            return stream
                    .map(String::strip)
                    .filter(v -> !v.isBlank())
                    .filter(v -> !v.startsWith("#"))
                    .sorted(Comparator.comparingInt(String::length).reversed())
                    .collect(Collectors.toCollection(LinkedHashSet::new));
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

    public static String removeAllSqlReservedWords(final String string) {
        Objects.requireNonNull(string, "string is null");
        if (true) {
            return PATTERN.matcher(string).replaceAll("");
        }
        final var builder = new StringBuilder(string);
        int index;
        for (final String word : getSqlReservedWords()) {
            index = builder.indexOf(word.toUpperCase());
            if (index != -1) {
                builder.delete(index, index + word.length());
            }
            index = builder.indexOf(word.toLowerCase());
            if (index != -1) {
                builder.delete(index, index + word.length());
            }
        }
        return builder.toString();
    }

    private SqlReservedWords() {
        throw new AssertionError("instantiation is not allowed");
    }
}
