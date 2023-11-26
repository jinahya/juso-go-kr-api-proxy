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
public class AddrEngApiResponse
        extends _AddrlinkResponseType<AddrEngApiResult> {

    @Serial
    private static final long serialVersionUID = -2359032429709470255L;

    // -----------------------------------------------------------------------------------------------------------------

    // -----------------------------------------------------------------------------------------------------------------

    // -----------------------------------------------------------------------------------------------------------------
}
