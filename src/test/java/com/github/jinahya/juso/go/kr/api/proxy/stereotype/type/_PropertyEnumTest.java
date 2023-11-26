package com.github.jinahya.juso.go.kr.api.proxy.stereotype.type;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * An abstract class for testing subclasses of {@link _PropertyEnum} interface.
 *
 * @param <ENUM>     enum type parameter
 * @param <PROPERTY> property type parameter
 * @author Jin Kwon &lt;onacit_at_gmail.com&gt;
 */
@Slf4j
public abstract class _PropertyEnumTest<ENUM extends Enum<ENUM> & _PropertyEnum<ENUM, PROPERTY>, PROPERTY> {

    public static abstract class OfStringTest<E extends Enum<E> & _PropertyEnum.OfString<E>>
            extends _PropertyEnumTest<E, String> {

        protected OfStringTest(final Class<E> enumClass) {
            super(enumClass, String.class);
        }

        @DisplayName("valueOfPropertyValue(given.propertyValue)given")
        @Test
        @Override
        void valueOfPropertyValue_Same_() {
            for (final E enumConstant : enumClass.getEnumConstants()) {
                assertThat(_PropertyEnum.OfString.valueOfProeprtyValue(enumClass, enumConstant.getPropertyValue()))
                        .isSameAs(enumConstant);
            }
        }
    }

    protected _PropertyEnumTest(final Class<ENUM> enumClass, final Class<PROPERTY> propertyClass) {
        super();
        this.enumClass = Objects.requireNonNull(enumClass, "enumClass is null");
        this.propertyClass = Objects.requireNonNull(propertyClass, "propertyClass is null");
    }

    // -----------------------------------------------------------------------------------------------------------------
    @Test
    void getPropertyValue_Unique_() {
        final Set<PROPERTY> set = new HashSet<>();
        for (final ENUM enumConstant : enumClass.getEnumConstants()) {
            assertThat(set.add(enumConstant.getPropertyValue())).isTrue();
        }
    }

    @DisplayName("valueOfPropertyValue(given.propertyValue)given")
    @Test
    void valueOfPropertyValue_Same_() {
        for (final ENUM enumConstant : enumClass.getEnumConstants()) {
            assertThat(_PropertyEnum.valueOfProeprtyValue(enumClass, enumConstant.getPropertyValue()))
                    .isSameAs(enumConstant);
        }
    }

    @DisplayName("redefined.valueOfPropertyValue(given.propertyValue)given")
    @Test
    void valueOfPropertyValue_Same_Redefined() {
        try {
            final var method = enumClass.getMethod("valueOfPropertyValue", propertyClass);
            for (final ENUM enumConstant : enumClass.getEnumConstants()) {
                final var enumValue = method.invoke(null, enumConstant.getPropertyValue());
                assertThat(enumValue).isSameAs(enumConstant);
            }
        } catch (final ReflectiveOperationException roe) {
            log.warn("failed to find/invoke valueOfPropertyValue({}) on {}", propertyClass.getSimpleName(), enumClass);
        }
    }

    // -----------------------------------------------------------------------------------------------------------------
    protected final Class<ENUM> enumClass;

    protected final Class<PROPERTY> propertyClass;
}
