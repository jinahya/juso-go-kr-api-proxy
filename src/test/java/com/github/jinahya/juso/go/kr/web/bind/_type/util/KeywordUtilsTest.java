package com.github.jinahya.juso.go.kr.web.bind._type.util;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

@Slf4j
class KeywordUtilsTest {

    @Nested
    class ReplaceUnsafeCharactersTest {

        @ValueSource(strings = {
                "",
                " ",
                ">",
                "%<",
                "a=b",
                "c<d=f%"
        })
        @ParameterizedTest
        void __(final String keyword) {
            final var replaced = KeywordUtils.removeUnsafeCharacters(keyword);
            log.debug("keyword: {}, replaced: {}", keyword, replaced);
            assertThat(KeywordUtils.containsAnyUnsafeCharacter(replaced)).isFalse();
        }
    }
}
