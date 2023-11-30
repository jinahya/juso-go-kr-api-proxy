package com.github.jinahya.juso.go.kr.api.proxy.stereotype.type.addrlink;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;
import lombok.extern.jackson.Jacksonized;
import org.springframework.lang.Nullable;

import java.io.Serial;
import java.util.Optional;

@Setter
@Getter
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@NoArgsConstructor
@Jacksonized
@SuperBuilder(toBuilder = true)
@SuppressWarnings({
        "java:S100" // ..._()
})
public class AddrLinkApiResultJuso
        extends _AddrlinkType {

    @Serial
    private static final long serialVersionUID = -8860272291125680568L;

    // -----------------------------------------------------------------------------------------------------------------
//    @Override
//    public boolean canEqual(final Object obj) {
//        return obj instanceof AddrLinkApiResultJuso;
//    }

    // -------------------------------------------------------------------------------------------------------- roadAddr

    // --------------------------------------------------------------------------------------------------- roadAddrPart1

    // --------------------------------------------------------------------------------------------------- roadAddrPart2

    // ------------------------------------------------------------------------------------------------------- jibunAddr

    // --------------------------------------------------------------------------------------------------------- engAddr

    // ----------------------------------------------------------------------------------------------------------- zipNo

    // ----------------------------------------------------------------------------------------------------------- admCd

    // --------------------------------------------------------------------------------------------------------- rnMgtSn

    // --------------------------------------------------------------------------------------------------------- bdMgtSn

    // ----------------------------------------------------------------------------------------------------- detBdNmList

    // ------------------------------------------------------------------------------------------------------------ bdNm

    // ---------------------------------------------------------------------------------------------------------- bdKdcd

    /**
     * A value of {@code bdKdcd} property for {@code 비공동주택}. The value is {@code value}.
     */
    public static final String PROPERTY_VALUE_BD_KDCD_0 = "0"; // 비공동주택

    /**
     * A value of {@code bdKdcd} property for {@code 공동주택}. The value is {@value}.
     */
    public static final String PROPERTY_VALUE_BD_KDCD_1 = "1"; // 공동주택

    // ------------------------------------------------------------------------------------------------------------ siNm

    // ----------------------------------------------------------------------------------------------------------- ssgNm

    // ----------------------------------------------------------------------------------------------------------- emdNm

    // ------------------------------------------------------------------------------------------------------------ liNm

    // -------------------------------------------------------------------------------------------------------------- rn

    // ----------------------------------------------------------------------------------------------------------- udrYn
    public static final String PROPERTY_VALUE_UDR_YN_0 = "0";

    public static final String PROPERTY_VALUE_UDR_YN_1 = "1";

    public static final String PROPERTY_VALUE_UDR_YN_ABOVE_GROUND = PROPERTY_VALUE_UDR_YN_0;

    public static final String PROPERTY_VALUE_UDR_YN_UNDERGROUND = PROPERTY_VALUE_UDR_YN_1;
    // -------------------------------------------------------------------------------------------------------- buldMnnm

    // -------------------------------------------------------------------------------------------------------- buldSlno

    // ------------------------------------------------------------------------------------------------------------ mtYn

    // -------------------------------------------------------------------------------------------------------- lnbrMnnm

    // -------------------------------------------------------------------------------------------------------- lnbrSlno

    // ----------------------------------------------------------------------------------------------------------- emdNo

    // --------------------------------------------------------------------------------------------------------- hstryYn

    // -------------------------------------------------------------------------------------------------------- relJibun

    // ---------------------------------------------------------------------------------------------------------- hemdNm

    // -----------------------------------------------------------------------------------------------------------------

    // -----------------------------------------------------------------------------------------------------------------

    // -------------------------------------------------------------------------------------------------------- roadAddr

    // --------------------------------------------------------------------------------------------------- roadAddrPart1

    // --------------------------------------------------------------------------------------------------- roadAddrPart2

    // ------------------------------------------------------------------------------------------------------- jibunAddr

    // --------------------------------------------------------------------------------------------------------- engAddr

    // ----------------------------------------------------------------------------------------------------------- zipNo

    // ----------------------------------------------------------------------------------------------------------- admCd

    // --------------------------------------------------------------------------------------------------------- rnMgtSn

    // --------------------------------------------------------------------------------------------------------- bdMgtSn

    // ----------------------------------------------------------------------------------------------------- detBdNmList

    // ------------------------------------------------------------------------------------------------------------ bdNm

    // ---------------------------------------------------------------------------------------------------------- bdKdcd

    // ------------------------------------------------------------------------------------------------------------ siNm

    // ----------------------------------------------------------------------------------------------------------- ssgNm

    // ----------------------------------------------------------------------------------------------------------- emdNm

    // ------------------------------------------------------------------------------------------------------------ liNm

    // -------------------------------------------------------------------------------------------------------------- rn

    // ----------------------------------------------------------------------------------------------------------- udrYn

    @Schema(hidden = true)
    @JsonIgnore
    Boolean getAboveGround_() {
        return Optional.ofNullable(getUdrtYn())
                .map(PROPERTY_VALUE_UDR_YN_ABOVE_GROUND::equals)
                .orElse(null);
    }

    void setAboveGround_(final Boolean aboveGround_) {
        setUdrtYn(
                Optional.ofNullable(aboveGround_)
                        .map(v -> Boolean.TRUE.equals(v) ?
                                  PROPERTY_VALUE_UDR_YN_ABOVE_GROUND : PROPERTY_VALUE_UDR_YN_UNDERGROUND)
                        .orElse(null)
        );
    }

    @Schema(hidden = true)
    @JsonIgnore
    Boolean getUnderground_() {
        return Optional.ofNullable(getAboveGround_())
                .map(v -> !v)
                .orElse(null);
    }

    void setUnderground_(final Boolean underground_) {
        setAboveGround_(
                Optional.ofNullable(underground_)
                        .map(v -> !v)
                        .orElse(null)
        );
    }

    // -------------------------------------------------------------------------------------------------------- buldMnnm

    // -------------------------------------------------------------------------------------------------------- buldSlno

    // ------------------------------------------------------------------------------------------------------------ mtYn

    // -------------------------------------------------------------------------------------------------------- lnbrMnnm

    // -------------------------------------------------------------------------------------------------------- lnbrSlno

    // ----------------------------------------------------------------------------------------------------------- emdNo

    // --------------------------------------------------------------------------------------------------------- hstryYn

    // -------------------------------------------------------------------------------------------------------- relJibun

    // ---------------------------------------------------------------------------------------------------------- hemdNm

    // -----------------------------------------------------------------------------------------------------------------
    @Schema(description = "전체 도로명주소")
    @NotNull
    private String roadAddr;

    @Schema(description = "도로명주소(참고항목 제외)")
    @NotNull
    private String roadAddrPart1;

    @Schema(description = "도로명주소 참고항목")
    @Nullable
    @jakarta.annotation.Nullable
    private String roadAddrPart2;

    @Schema(description = "지번 정보")
    @NotNull
    private String jibunAddr;

    @Schema(description = "도로명주소(영문)")
    @NotNull
    private String engAddr;

    @Schema(description = "우편번호")
    @NotNull
    private String zipNo;

    @Schema(description = "행정구역코드")
    @NotNull
    private String admCd;

    @Schema(description = "도로명코드")
    @NotNull
    private String rnMgtSn; // 도로명코드

    @Schema(description = "건물관리번호")
    @NotNull
    private String bdMgtSn; // 건물관리번호

    @Schema(description = "상세건물명")
    @Nullable
    @jakarta.annotation.Nullable
    private String detBdNmList; // 상세건물명

    @Schema(description = "건물명")
    @Nullable
    @jakarta.annotation.Nullable
    private String bdNm; // 건물명

    @Schema(description = "공동주택여부 (1:공동주택, 0: 비공동주택)")
    @NotNull
    private String bdKdcd; // 공동주택여부 (1:공동주택, 0: 비공동주택)

    @Schema(description = "시도명")
    @NotNull
    private String siNm; // 시도명

    @Schema(description = "시군구명")
    @Nullable
    @jakarta.annotation.Nullable
    private String sggNm; // 시군구명

    @Schema(description = "읍면동명")
    @NotNull
    private String emdNm; // 읍면동명

    @Schema(description = "법정리명")
    @Nullable
    @jakarta.annotation.Nullable
    private String liNm; // 법정리명

    @Schema(description = "도로명")
    @NotNull
    private String rn; // 도로명

    @Schema(description = "지하여부 (0:지상, 1:지하)")
    @NotNull
    private String udrtYn; // 지하여부 (0:지상, 1:지하)

    @Schema(description = "건물본번")
    @NotNull
    private Number buldMnnm; // 건물본번

    @Schema(description = "건물부번 (부번이 없는 경우 0)")
    @NotNull
    private Number buldSlno;  // 건물부번 (부번이 없는 경우 0)

    @Schema(description = "산여부 (0:대지, 1:산)")
    @NotNull
    private String mtYn; // 산여부 (0:대지, 1:산)

    @Schema(description = "지번본번(번지)")
    @NotNull
    private Number lnbrMnnm; // 지번본번(번지)

    @Schema(description = "지번부번(호) (부번이 없는 경우 0)")
    @NotNull
    private Number lnbrSlno; // 지번부번(호) (부번이 없는 경우 0)

    @Schema(description = "읍면동일련번호")
    @NotNull
    private String emdNo; // 읍면동일련번호

    @Schema(description = "* 2020년12월8일 추가된 항목\n변동이력여부(0: 현행 주소정보, 1: 요청변수의 keyword(검색어)가 변동된 주소정보에서 검색된 정보)")
    @NotNull
    private String hstryYn; // 변동이력여부(0: 현행 주소정보, 1: 요청변수의 keyword(검색어)가 변동된 주소정보에서 검색된 정보)

    @Schema(description = "* 2020년12월8일 추가된 항목\n관련지번")
    @NotNull
    private String relJibun; // 관련지번

    @Schema(description = "* 2020년12월8일 추가된 항목\n관할주민센터\n※ 참고정보이며, 실제와 다를 수 있습니다.")
    @NotNull
    private String hemdNm; // 관할주민센터
}
