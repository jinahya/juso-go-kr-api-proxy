package com.github.jinahya.juso.go.kr.api.proxy.stereotype.type.addrlink;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.github.jinahya.juso.go.kr.api.proxy.stereotype.type._PropertyEnum;
import com.github.jinahya.juso.go.kr.api.proxy.stereotype.type.__BaseTypeConstants;
import com.github.jinahya.juso.go.kr.api.proxy.stereotype.type.__BaseTypeGroup;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
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
public class AddrCoordApiRequest
        extends _AddrlinkType {

    @Serial
    private static final long serialVersionUID = 5984790532129504813L;

    // -------------------------------------------------------------------------------------------------------- confmKey

    // ----------------------------------------------------------------------------------------------------------- amdCd

    // ---------------------------------------------------------------------------------------------------------- rnMgSn

    // ---------------------------------------------------------------------------------------------------------- udrtYn
    public static final String PROPERTY_VALUE_UDRT_0 = "0";

    public static final String PROPERTY_VALUE_UDRT_1 = "1";

    // -------------------------------------------------------------------------------------------------------- buldMnnm

    // -------------------------------------------------------------------------------------------------------- buldSlno

    // ------------------------------------------------------------------------------------------------------ resultType

    // -----------------------------------------------------------------------------------------------------------------

    // -----------------------------------------------------------------------------------------------------------------

    // -------------------------------------------------------------------------------------------------------- confmKey

    // ----------------------------------------------------------------------------------------------------------- amdCd

    // ---------------------------------------------------------------------------------------------------------- rnMgSn

    // ---------------------------------------------------------------------------------------------------------- udrtYn

    // -------------------------------------------------------------------------------------------------------- buldMnnm

    // -------------------------------------------------------------------------------------------------------- buldSlno

    // ------------------------------------------------------------------------------------------------------ resultType

    @Schema(hidden = true)
    @JsonIgnore
    @Nullable
    __BaseTypeConstants.ResultType getResultTypeAsEnum_() {
        return Optional.ofNullable(getResultType())
                .map(__BaseTypeConstants.ResultType::valueOfPropertyValue)
                .orElse(null);
    }

    void setResultTypeAsEnum(@Nullable final __BaseTypeConstants.ResultType resultTypeAsEnum_) {
        setResultType(
                Optional.ofNullable(resultTypeAsEnum_)
                        .map(_PropertyEnum.OfString::getPropertyValue)
                        .orElse(null)
        );
    }

    // -----------------------------------------------------------------------------------------------------------------
    @Schema(description = "신청시 발급받은 승인키")
    @NotBlank(groups = {__BaseTypeGroup.class}) // may be supplied by the properties
    @ToString.Exclude
    private String confmKey;

    @Schema(description = "행정구역코드")
    @NotBlank
    private String admCd;

    @Schema(description = "도로명코드")
    @NotBlank
    private String rnMgtSn;

    @Schema(description = "지하여부(0: 지상, 1: 지하")
    @NotBlank
    private String udrtYn;

    @Schema(description = "건물본번")
    @NotNull
    private Integer buldMnnm;

    @Schema(description = "건물부번")
    @NotNull
    private Integer buldSlno;

    @Schema(description = "검색결과형식 설정(xml, json)")
    @Nullable
    @jakarta.annotation.Nullable
    private String resultType;
}
