package com.github.jinahya.juso.go.kr.web.bind.addrlink.type;

import com.github.jinahya.juso.go.kr.web.bind.type._BaseResultsType;
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
@NoArgsConstructor
abstract class _AddrlinkResultType<DATA>
        extends _BaseResultsType<DATA> {

    @Serial
    private static final long serialVersionUID = -8233649670091058793L;
}
