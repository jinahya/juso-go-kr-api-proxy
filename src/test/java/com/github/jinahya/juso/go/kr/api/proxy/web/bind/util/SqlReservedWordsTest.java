package com.github.jinahya.juso.go.kr.api.proxy.web.bind.util;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.nio.charset.StandardCharsets;

import static org.assertj.core.api.Assertions.assertThat;

@Slf4j
class SqlReservedWordsTest {

    @Test
    void __() {
        final var sqlReservedWords = SqlReservedWords.getSqlReservedWords();
        assertThat(sqlReservedWords)
                .isNotEmpty()
                .allSatisfy(w -> {
                    assertThat(w)
                            .isNotNull()
                            .isNotBlank()
                            .doesNotContainAnyWhitespaces()
                            .doesNotStartWith("#");
                    assertThat(w.getBytes(StandardCharsets.US_ASCII).length)
                            .isEqualTo(w.length());
                });
    }

    @Nested
    class RemoveAllSqlReservedWordsTest {

        @Test
        void __() {
            for (final var sqlReservedWord : SqlReservedWords.getSqlReservedWords()) {
//                log.debug("sqlReservedWord: {}", sqlReservedWord);
                {
                    final var filtered = SqlReservedWords.removeAllSqlReservedWords(sqlReservedWord);
                    assertThat(filtered).isEmpty();
                }
                {
                    final var filtered = SqlReservedWords.removeAllSqlReservedWords(sqlReservedWord.toLowerCase());
                    assertThat(filtered).isEmpty();
                }
            }
        }
    }
}
