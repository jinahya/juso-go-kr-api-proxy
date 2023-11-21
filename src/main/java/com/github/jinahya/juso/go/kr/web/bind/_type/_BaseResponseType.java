package com.github.jinahya.juso.go.kr.web.bind._type;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AccessLevel;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.io.Serial;

@Setter
@Getter
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public abstract class _BaseResponseType<RESULT extends _BaseResultsType<?>>
        extends _BaseType {

    @Serial
    private static final long serialVersionUID = -7721822329899789683L;

    // -----------------------------------------------------------------------------------------------------------------
    public static final String PROPERTY_NAME_RESULTS = "results";

    // -----------------------------------------------------------------------------------------------------------------
    @JsonProperty(PROPERTY_NAME_RESULTS)
    private RESULT results;
}
