package com.github.jinahya.juso.go.kr.api.proxy.web.bind.addrlink._type;

import com.github.jinahya.juso.go.kr.api.proxy.web.bind._type._BaseResultsType;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

import java.io.Serial;

@Setter
@Getter
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@NoArgsConstructor
@SuperBuilder(toBuilder = true)
abstract class _AddrlinkResultType<DATA>
        extends _BaseResultsType<DATA> {

    @Serial
    private static final long serialVersionUID = -8233649670091058793L;
}
