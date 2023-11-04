package com.github.jinahya.juso.go.kr.web.bind.type;

import lombok.AccessLevel;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.io.Serial;
import java.io.Serializable;

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
               '}';
    }
}
