package com.github.jinahya.juso.go.kr.web.bind;

import org.junit.jupiter.api.Test;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties;

class WebBindConstantsTest {

    @Test
    void page__() throws NoSuchFieldException {
        final var field = SpringDataWebProperties.Pageable.class.getDeclaredField("pageParameter");
    }

    @Test
    void size__() throws NoSuchFieldException {
        final var field = SpringDataWebProperties.Pageable.class.getDeclaredField("sizeParameter");
    }

    @Test
    void __() {
        var value = Double.MIN_VALUE;
        System.out.printf("%1$f", value);
    }
}
