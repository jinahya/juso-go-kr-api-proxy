package com.github.jinahya.juso.go.kr.api.proxy.util;

import jakarta.validation.Validator;

import java.util.Arrays;
import java.util.Objects;

import static org.assertj.core.api.Assertions.assertThat;

public final class ValidationTestUtils {

    public static void assertValid(final Validator validator, final Object object, final Class<?>... groups) {
        Objects.requireNonNull(validator, "validator is null");
        Objects.requireNonNull(object, "object is null");
        Objects.requireNonNull(groups, "groups is null");
        assertThat(validator.validate(object, groups))
                .as("violations of %1$s with %2$s", object, Arrays.toString(groups))
                .isEmpty();
    }

    private ValidationTestUtils() {
        throw new AssertionError("instantiation is not allowed");
    }
}
