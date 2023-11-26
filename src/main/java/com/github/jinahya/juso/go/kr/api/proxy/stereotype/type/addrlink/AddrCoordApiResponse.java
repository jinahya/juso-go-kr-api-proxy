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
public class AddrCoordApiResponse
        extends _AddrlinkResponseType<AddrCoordApiResult> {

    @Serial
    private static final long serialVersionUID = 8187507688240797566L;

    // -----------------------------------------------------------------------------------------------------------------

    // -----------------------------------------------------------------------------------------------------------------

    // -----------------------------------------------------------------------------------------------------------------
}
