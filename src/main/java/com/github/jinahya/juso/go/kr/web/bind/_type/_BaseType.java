package com.github.jinahya.juso.go.kr.web.bind._type;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import lombok.AccessLevel;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.io.Serial;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@EqualsAndHashCode
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public abstract class _BaseType
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
