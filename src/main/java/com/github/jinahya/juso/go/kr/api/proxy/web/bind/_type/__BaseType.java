package com.github.jinahya.juso.go.kr.api.proxy.web.bind._type;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AccessLevel;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import java.io.Serial;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@EqualsAndHashCode
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@SuperBuilder(toBuilder = true)
public abstract class __BaseType
        implements Serializable {

    @Serial
    private static final long serialVersionUID = 118764886173791987L;

    // -----------------------------------------------------------------------------------------------------------------

    // -----------------------------------------------------------------------------------------------------------------
    public String toString() {
        return super.toString() + '{' +
               "unknownProperties" + unknownProperties +
               '}';
    }

    // -----------------------------------------------------------------------------------------------------------------
    public MultiValueMap<String, String> toMultivalueMap(final ObjectMapper objectMapper) {
        final var parameters = new LinkedMultiValueMap<String, String>();
        parameters.setAll(toMap(objectMapper));
        return parameters;
    }

    public Map<String, String> toMap(final ObjectMapper objectMapper) {
        Objects.requireNonNull(objectMapper, "objectMapper is null");
        return objectMapper.convertValue(this, new TypeReference<>() {
        });
    }

    // ----------------------------------------------------------------------------------------------- unknownProperties
    @JsonAnyGetter
    public Map<String, Object> getUnknownProperties() {
        if (unknownProperties == null) {
            unknownProperties = new HashMap<>();
        }
        return unknownProperties;
    }

    @JsonAnySetter
    public void putUnknownProperty(final String name, final Object value) {
        Objects.requireNonNull(name, "name is null");
        getUnknownProperties().put(name, value);
    }

    // -----------------------------------------------------------------------------------------------------------------
    @EqualsAndHashCode.Exclude
    private transient Map<String, Object> unknownProperties;
}
