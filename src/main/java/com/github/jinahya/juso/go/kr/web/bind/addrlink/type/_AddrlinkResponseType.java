package com.github.jinahya.juso.go.kr.web.bind.addrlink.type;

import com.github.jinahya.juso.go.kr.web.bind.type._BaseResponseType;
import lombok.AccessLevel;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serial;

@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public abstract class _AddrlinkResponseType<RESULT extends _AddrlinkResultType<?>>
        extends _BaseResponseType<RESULT> {

    @Serial
    private static final long serialVersionUID = -7038571444460634185L;
}
