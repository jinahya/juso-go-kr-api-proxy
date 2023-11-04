package com.github.jinahya.juso.go.kr.web.bind.type;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonFactoryBuilder;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.experimental.Accessors;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.JsonTest;
import org.springframework.boot.test.json.JacksonTester;

import java.io.IOException;
import java.io.InputStream;
import java.io.UncheckedIOException;
import java.util.Objects;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;

import static org.assertj.core.api.Assertions.assertThat;

@JsonTest
public class _BaseTypeTest<TYPE extends _BaseType> {

    protected _BaseTypeTest(final Class<TYPE> typeClass) {
        super();
        this.typeClass = Objects.requireNonNull(typeClass, "typeClass is null");
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
                        final TYPE value = newObjectMapper().reader().readValue(r, typeClass);
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

    protected ObjectMapper newObjectMapper() {
        return new ObjectMapper(jsonFactory());
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
        if (jsonFactory == null) {
            jsonFactory = new JsonFactoryBuilder().build();
        }
        return jsonFactory;
    }

    // -----------------------------------------------------------------------------------------------------------------
    protected final Class<TYPE> typeClass;

    private JsonFactory jsonFactory;

    @Autowired
    @Accessors(fluent = true)
    @Getter(AccessLevel.PROTECTED)
    private JacksonTester<TYPE> jacksonTester;
}
