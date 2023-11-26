package com.github.jinahya.juso.go.kr.api.proxy.stereotype.type.addrlink;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
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
//@Jacksonized
@SuperBuilder(toBuilder = true)
public class AddrEngApiResult
        extends _AddrlinkResultType<List<AddrEngApiResultJuso>> {

    @Serial
    private static final long serialVersionUID = 648232080495866649L;

    // -----------------------------------------------------------------------------------------------------------------
    public static final String PROPERTY_NAME_RESULTS = "results";

    public static final String PROPERTY_NAME_JUSO = "juso";

    // -----------------------------------------------------------------------------------------------------------------

    // -----------------------------------------------------------------------------------------------------------------

    // -----------------------------------------------------------------------------------------------------------------
    @JsonProperty
    public List<@Valid @NotNull AddrEngApiResultJuso> getJuso() {
        return super.getData();
    }

    public void setJuso(final List<AddrEngApiResultJuso> juso) {
        super.setData(juso);
    }
}
