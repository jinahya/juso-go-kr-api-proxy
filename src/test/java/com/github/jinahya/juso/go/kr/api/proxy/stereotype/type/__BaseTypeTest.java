package com.github.jinahya.juso.go.kr.api.proxy.stereotype.type;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonFactoryBuilder;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.experimental.Accessors;
import nl.jqno.equalsverifier.EqualsVerifier;
import nl.jqno.equalsverifier.api.SingleTypeEqualsVerifierApi;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.JsonTest;
import org.springframework.boot.test.json.JacksonTester;

import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.io.IOException;
import java.io.InputStream;
import java.io.UncheckedIOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Objects;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;

@JsonTest
public abstract class __BaseTypeTest<TYPE extends __BaseType> {

    protected __BaseTypeTest(final Class<TYPE> typeClass) {
        super();
        this.typeClass = Objects.requireNonNull(typeClass, "typeClass is null");
    }

    // -----------------------------------------------------------------------------------------------------------------
    @Test
    void toString_NotBlank_() {
        final var instance = newTypeInstance();
        final var string = instance.toString();
        assertThat(string).isNotBlank();
    }

    // -----------------------------------------------------------------------------------------------------------------
    protected SingleTypeEqualsVerifierApi<TYPE> equalsVerifier() {
        return EqualsVerifier.simple().forClass(typeClass);
    }

    @Test
    protected void equals_Verify_() {
        equalsVerifier().verify();
    }

    // -----------------------------------------------------------------------------------------------------------------
    @Test
    void accessors__() throws IntrospectionException, InvocationTargetException, IllegalAccessException {
        final var instance = newTypeInstance();
        for (Class<?> c = typeClass; c != null; c = c.getSuperclass()) {
            final var info = Introspector.getBeanInfo(c);
            for (final var descriptor : info.getPropertyDescriptors()) {
                final var reader = descriptor.getReadMethod();
                if (reader == null) {
                    continue;
                }
                if (!reader.canAccess(instance)) {
                    reader.setAccessible(true);
                }
                final Object value = reader.invoke(instance);
                final var writer = descriptor.getWriteMethod();
                if (writer == null) {
                    continue;
                }
                if (!writer.canAccess(instance)) {
                    writer.setAccessible(true);
                }
                assertThatCode(() -> {
                    writer.invoke(instance, value);
                }).doesNotThrowAnyException();
            }
        }
    }

    // -----------------------------------------------------------------------------------------------------------------

    protected <R> R applyResource(final String name, final Function<? super InputStream, ? extends R> function)
            throws IOException {
        Objects.requireNonNull(name, "name is null");
        Objects.requireNonNull(function, "function is null");
        try (var stream = getClass().getResourceAsStream(name)) {
            assertThat(stream)
                    .as("resource named as '%1$s'", name)
                    .isNotNull();
            return function.apply(stream);
        }
    }

    protected <R> R deserializeResource(final String name, final Function<? super TYPE, ? extends R> function)
            throws IOException {
        Objects.requireNonNull(function, "function is null");
        return applyResource(
                name,
                r -> {
                    try {
                        final TYPE value = objectMapper().reader().readValue(r, typeClass);
                        return function.apply(value);
                    } catch (final IOException e) {
                        throw new UncheckedIOException(e);
                    }
                }
        );
    }

    protected TYPE deserializeResource(final String name) throws IOException {
        return deserializeResource(name, Function.identity());
    }

    // ------------------------------------------------------------------------------------------------------- typeClass

    protected TYPE newTypeInstance() {
        try {
            return typeClass.getConstructor().newInstance();
        } catch (final ReflectiveOperationException roe) {
            throw new RuntimeException(roe);
        }
    }

    protected TYPE newTypeInstance(final UnaryOperator<TYPE> operator) {
        Objects.requireNonNull(operator, "operator is null");
        return Objects.requireNonNull(operator.apply(newTypeInstance()), "operator.apply(newTypeInstance()) is null");
    }

    protected TYPE newTypeSpy(final Supplier<? extends TYPE> supplier) {
        Objects.requireNonNull(supplier, "supplier is null");
        return Mockito.spy(Objects.requireNonNull(supplier.get(), "supplier.get() is null"));
    }

    protected TYPE newTypeSpy() {
        return newTypeSpy(this::newTypeInstance);
    }

    // ----------------------------------------------------------------------------------------------------- jsonFactory
    protected JsonFactory jsonFactory() {
        var result = jsonFactory;
        if (result == null) {
            result = jsonFactory = new JsonFactoryBuilder().build();
        }
        return result;
    }

    // ---------------------------------------------------------------------------------------------------- objectMapper
    protected ObjectMapper objectMapper() {
        var result = objectMapper;
        if (result == null) {
            result = objectMapper = new ObjectMapper(jsonFactory());
        }
        return result;
    }

    // -----------------------------------------------------------------------------------------------------------------
    protected final Class<TYPE> typeClass;

    // -----------------------------------------------------------------------------------------------------------------
    private JsonFactory jsonFactory;

    private ObjectMapper objectMapper;

    // -----------------------------------------------------------------------------------------------------------------
    @Autowired
    @Accessors(fluent = true)
    @Getter(AccessLevel.PROTECTED)
    private JacksonTester<TYPE> jacksonTester;
}
