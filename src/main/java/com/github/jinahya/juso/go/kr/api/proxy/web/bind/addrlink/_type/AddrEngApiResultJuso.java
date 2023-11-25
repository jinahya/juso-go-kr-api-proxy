package com.github.jinahya.juso.go.kr.api.proxy.web.bind.addrlink._type;

import jakarta.validation.constraints.NotNull;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;
import lombok.extern.jackson.Jacksonized;

import java.io.Serial;

@Setter
@Getter
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@NoArgsConstructor
@Jacksonized
@SuperBuilder(toBuilder = true)
public class AddrEngApiResultJuso
        extends _AddrlinkType {

    @Serial
    private static final long serialVersionUID = -8860272291125680568L;

    // -----------------------------------------------------------------------------------------------------------------

    // -----------------------------------------------------------------------------------------------------------------

    // -----------------------------------------------------------------------------------------------------------------
    @NotNull
    private String roadAddr; // 영문 도로명주소

    @NotNull
    private String jibunAddr; // 영문 지번 주소

    @NotNull
    private String zipNo; // 우편번호

    @NotNull
    private String admCd; // 행정구역코드

    @NotNull
    private String rnMgtSn; // 도로명코드

    @NotNull
    private String bdKdcd; // 공동주택여부 (1:공동주택, 0: 비공동주택)

    @NotNull
    private String siNm; // 영문 시도명

    private String sggNm; // 영문 시군구명

    @NotNull
    private String emdNm; // 영문 읍면동명

    private String liNm; // 영문 법정리명

    @NotNull
    private String rn; // 영문 도로명

    @NotNull
    private String udrtYn; // 지하여부 (0:지상, 1:지하)

    @NotNull
    private String buldMnnm; // 건물본번

    @NotNull
    private String buldSlno;  // 건물부번 (부번이 없는 경우 0)

    @NotNull
    private String mtYn; // 산여부 (0:대지, 1:산)

    @NotNull
    private String lnbrMnnm; // 지번본번(번지)

    @NotNull
    private String lnbrSlno; // 지번부번(호) (부번이 없는 경우 0)

    @NotNull
    private String korAddr; // 도로명주소(한글)
}
