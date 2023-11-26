package com.github.jinahya.juso.go.kr.api.proxy.stereotype.type.addrlink;

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
//@Jacksonized
@SuperBuilder(toBuilder = true)
public class AddrDetailApiResponse
        extends _AddrlinkResponseType<AddrDetailApiResult> {

    @Serial
    private static final long serialVersionUID = 1207081144142650833L;

    // -----------------------------------------------------------------------------------------------------------------

    // -----------------------------------------------------------------------------------------------------------------

    // -----------------------------------------------------------------------------------------------------------------
}
