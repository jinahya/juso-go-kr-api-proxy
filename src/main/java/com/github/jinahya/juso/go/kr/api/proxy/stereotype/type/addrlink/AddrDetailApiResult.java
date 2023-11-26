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
public class AddrDetailApiResult
        extends _AddrlinkResultType<List<AddrDetailApiResultJuso>> {

    @Serial
    private static final long serialVersionUID = 5176787245224751407L;

    // -----------------------------------------------------------------------------------------------------------------

    // -----------------------------------------------------------------------------------------------------------------

    // -----------------------------------------------------------------------------------------------------------------

    // -----------------------------------------------------------------------------------------------------------------
    @JsonProperty
    public List<AddrDetailApiResultJuso> getJuso() {
        return super.getData();
    }

    public void setJuso(final List<AddrDetailApiResultJuso> juso) {
        super.setData(juso);
    }
}
