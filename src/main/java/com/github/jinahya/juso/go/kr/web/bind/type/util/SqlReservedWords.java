package com.github.jinahya.juso.go.kr.web.bind.type.util;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.util.Collections;
import java.util.Set;
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
                    .collect(Collectors.toSet());
        }
    }

    private static Set<String> set = null;

    public static Set<String> getSqlReservedWords() {
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

    private SqlReservedWords() {
        throw new AssertionError("instantiation is not allowed");
    }
}
