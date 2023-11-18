package com.github.jinahya.juso.go.kr.web.bind.type.util;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

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
                });
    }
}
