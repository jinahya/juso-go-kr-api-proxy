package com.github.jinahya.juso.go.kr.web.bind.addrlink.type;

import jakarta.validation.constraints.NotNull;
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
public class AddrEngApiResultJuso
        extends _AddrlinkType {

    @Serial
    private static final long serialVersionUID = -8860272291125680568L;

    // -----------------------------------------------------------------------------------------------------------------

    // -----------------------------------------------------------------------------------------------------------------

    // -----------------------------------------------------------------------------------------------------------------
    @NotNull
    private String roadAddr;

    @NotNull
    private String jibunAddr;

    @NotNull
    private String engAddr;

    @NotNull
    private String zipNo;

    @NotNull
    private String admCd;

    @NotNull
    private String rnMgtSn; // 도로명코드

    @NotNull
    private String bdMgtSn; // 건물관리번호

    @NotNull
    private String siNm; // 시도명

    private String sggNm; // 시군구명

    @NotNull
    private String emdNm; // 읍면동명

    private String liNm; // 법정리명

    @NotNull
    private String rn; // 도로명

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
    private String korAddr;
}
