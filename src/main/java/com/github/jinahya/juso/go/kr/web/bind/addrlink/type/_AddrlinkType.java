package com.github.jinahya.juso.go.kr.web.bind.addrlink.type;

import com.github.jinahya.juso.go.kr.web.bind.type._BaseType;
import lombok.AccessLevel;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serial;

@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public abstract class _AddrlinkType
        extends _BaseType {

    @Serial
    private static final long serialVersionUID = 8833698205101327174L;
}