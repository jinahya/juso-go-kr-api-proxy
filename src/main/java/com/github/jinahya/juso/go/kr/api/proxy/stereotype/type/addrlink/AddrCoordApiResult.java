package com.github.jinahya.juso.go.kr.api.proxy.stereotype.type.addrlink;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

import java.io.Serial;
import java.util.List;

@Setter
@Getter
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@NoArgsConstructor
@SuperBuilder(toBuilder = true)
public class AddrCoordApiResult
        extends _AddrlinkResultType<List<AddrCoordApiResultJuso>> {

    @Serial
    private static final long serialVersionUID = 2387306907866935886L;

    // -----------------------------------------------------------------------------------------------------------------

    // -----------------------------------------------------------------------------------------------------------------

    // -----------------------------------------------------------------------------------------------------------------

    // -----------------------------------------------------------------------------------------------------------------
    @JsonProperty
    public List<AddrCoordApiResultJuso> getJuso() {
        return super.getData();
    }

    public void setJuso(final List<AddrCoordApiResultJuso> juso) {
        super.setData(juso);
    }
}
