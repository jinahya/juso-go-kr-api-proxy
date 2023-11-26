package com.github.jinahya.juso.go.kr.api.proxy.context.properties;

import lombok.extern.slf4j.Slf4j;
import org.springframework.util.ReflectionUtils;

import static org.mockito.Mockito.spy;

@Slf4j
abstract class _AddrApiConfigurationPropertiesTest<PROPERTIES extends _AddrApiConfigurationProperties>
        extends __AddrApiConfigurationPropertiesTestBase<PROPERTIES> {

    _AddrApiConfigurationPropertiesTest(final Class<PROPERTIES> propertiesClass) {
        super(propertiesClass);
    }

    // ------------------------------------------------------------------------------------------------- propertiesClass

    /**
     * Returns a new {@link org.mockito.Mockito#spy(Object) spy} instance of {@link #propertiesClass}.
     *
     * @return a new {@link org.mockito.Mockito#spy(Object) spy} instance of {@link #propertiesClass}.
     */
    PROPERTIES newPropertiesSpy() {
        return spy(newPropertiesInstance());
    }

    /**
     * Returns a new instance of {@link #propertiesClass}.
     *
     * @return a new instance of {@link #propertiesClass}.
     */
    PROPERTIES newPropertiesInstance() {
        try {
            return ReflectionUtils
                    .accessibleConstructor(propertiesClass)
                    .newInstance();
        } catch (final ReflectiveOperationException roe) {
            throw new RuntimeException("failed to instantiate " + propertiesClass, roe);
        }
    }
}
