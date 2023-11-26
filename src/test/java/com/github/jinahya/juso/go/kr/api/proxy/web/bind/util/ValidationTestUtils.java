package com.github.jinahya.juso.go.kr.api.proxy.web.bind.util;

import jakarta.validation.Validator;

import java.util.Objects;

import static org.assertj.core.api.Assertions.assertThat;

public final class ValidationTestUtils {

    public static <T> void assertValid(final Validator validator, final T object, final Class<?>... groups) {
        Objects.requireNonNull(object, "object is null");
        Objects.requireNonNull(groups, "groups is null");
        final var violations = validator.validate(object, groups);
        assertThat(violations).isEmpty();
    }

    private ValidationTestUtils() {
        super();
    }
}
