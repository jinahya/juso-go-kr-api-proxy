package com.github.jinahya.juso.go.kr.web.bind.addrlink.type;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Setter
@Getter
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@NoArgsConstructor
public class AddrEngApiResult
        extends _AddrlinkResultType<List<AddrEngApiResultJuso>> {

    // -----------------------------------------------------------------------------------------------------------------
    public static final String PROPERTY_NAME_RESULTS = "results";

    public static final String PROPERTY_NAME_JUSO = "juso";

    // -----------------------------------------------------------------------------------------------------------------

    // -----------------------------------------------------------------------------------------------------------------

    // -----------------------------------------------------------------------------------------------------------------

    public List<AddrEngApiResultJuso> getJuso() {
        return super.getData();
    }

    public void setJuso(final List<AddrEngApiResultJuso> jusos) {
        super.setData(jusos);
    }
}
