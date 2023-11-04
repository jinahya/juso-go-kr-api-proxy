package com.github.jinahya.juso.go.kr.util;

import com.github.jinahya.juso.go.kr.web.bind.type.util.PropertyEnum;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * An abstract class for testing subclasses of {@link PropertyEnum} interface.
 *
 * @param <E> enum type parameter
 * @param <P> property type parameter
 * @author Jin Kwon &lt;onacit_at_gmail.com&gt;
 */
@Slf4j
public abstract class PropertyEnumTest<E extends Enum<E> & PropertyEnum<E, P>, P> {

    public static abstract class OfStringTest<E extends Enum<E> & PropertyEnum.OfString<E>>
            extends PropertyEnumTest<E, String> {

        protected OfStringTest(final Class<E> enumClass) {
            super(enumClass, String.class);
        }

        @DisplayName("valueOfPropertyValue(given.propertyValue)given")
        @Test
        @Override
        void valueOfPropertyValue_Same_() {
            for (final E enumConstant : enumClass.getEnumConstants()) {
                assertThat(PropertyEnum.OfString.valueOfProeprtyValue(enumClass, enumConstant.getPropertyValue()))
                        .isSameAs(enumConstant);
            }
        }
    }

    protected PropertyEnumTest(final Class<E> enumClass, final Class<P> propertyClass) {
        super();
        this.enumClass = Objects.requireNonNull(enumClass, "enumClass is null");
        this.propertyClass = Objects.requireNonNull(propertyClass, "propertyClass is null");
    }

    // -----------------------------------------------------------------------------------------------------------------
    @Test
    void getPropertyValue_Unique_() {
        final Set<P> set = new HashSet<>();
        for (final E enumConstant : enumClass.getEnumConstants()) {
            assertThat(set.add(enumConstant.getPropertyValue())).isTrue();
        }
    }

    @DisplayName("valueOfPropertyValue(given.propertyValue)given")
    @Test
    void valueOfPropertyValue_Same_() {
        for (final E enumConstant : enumClass.getEnumConstants()) {
            assertThat(PropertyEnum.valueOfProeprtyValue(enumClass, enumConstant.getPropertyValue()))
                    .isSameAs(enumConstant);
        }
    }

    @DisplayName("redefined.valueOfPropertyValue(given.propertyValue)given")
    @Test
    void valueOfPropertyValue_Same_Redefined() {
        try {
            final var method = enumClass.getMethod("valueOfPropertyValue", propertyClass);
            for (final E enumConstant : enumClass.getEnumConstants()) {
                final var enumValue = method.invoke(null, enumConstant.getPropertyValue());
                assertThat(enumValue).isSameAs(enumConstant);
            }
        } catch (final ReflectiveOperationException roe) {
            log.warn("failed to find/invoke valueOfPropertyValue({}) on {}", propertyClass.getSimpleName(), enumClass);
        }
    }

    // -----------------------------------------------------------------------------------------------------------------
    protected final Class<E> enumClass;

    protected final Class<P> propertyClass;
}
