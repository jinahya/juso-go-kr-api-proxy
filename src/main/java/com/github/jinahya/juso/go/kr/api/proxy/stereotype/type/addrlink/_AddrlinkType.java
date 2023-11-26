package com.github.jinahya.juso.go.kr.api.proxy.stereotype.type.addrlink;

import com.github.jinahya.juso.go.kr.api.proxy.stereotype.type._BaseType;
import lombok.AccessLevel;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

import java.io.Serial;

@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@SuperBuilder(toBuilder = true)
public abstract class _AddrlinkType
        extends _BaseType {

    @Serial
    private static final long serialVersionUID = 8833698205101327174L;
}
