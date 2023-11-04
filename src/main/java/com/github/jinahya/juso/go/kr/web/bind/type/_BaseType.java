package com.github.jinahya.juso.go.kr.web.bind.type;

import lombok.AccessLevel;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.io.Serial;

@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public abstract class _BaseType
        extends __BaseType {

    @Serial
    private static final long serialVersionUID = 118764886173791987L;

    // -----------------------------------------------------------------------------------------------------------------

    // -----------------------------------------------------------------------------------------------------------------
    public String toString() {
        return super.toString() + '{' +
               '}';
    }
}
