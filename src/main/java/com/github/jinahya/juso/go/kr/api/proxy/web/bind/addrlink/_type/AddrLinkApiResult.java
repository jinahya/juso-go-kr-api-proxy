package com.github.jinahya.juso.go.kr.api.proxy.web.bind.addrlink._type;

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
public class AddrLinkApiResult
        extends _AddrlinkResultType<List<AddrLinkApiResultJuso>> {

    @Serial
    private static final long serialVersionUID = -3105641034884770051L;

    // -----------------------------------------------------------------------------------------------------------------
    public static final String PROPERTY_NAME_RESULTS = "results";

    public static final String PROPERTY_NAME_JUSO = "juso";

    // -----------------------------------------------------------------------------------------------------------------

    // -----------------------------------------------------------------------------------------------------------------

    // -----------------------------------------------------------------------------------------------------------------
    @JsonProperty
    public List<AddrLinkApiResultJuso> getJuso() {
        return super.getData();
    }

    public void setJuso(final List<AddrLinkApiResultJuso> juso) {
        super.setData(juso);
    }
}
