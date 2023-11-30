package com.github.jinahya.juso.go.kr.api.proxy.stereotype.type.addrlink;

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

@Setter
@Getter
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@NoArgsConstructor
@Jacksonized
@SuperBuilder(toBuilder = true)
public class AddrCoordApiResultJuso
        extends _AddrlinkType {

    @Serial
    private static final long serialVersionUID = -3903289972124704464L;

    // -----------------------------------------------------------------------------------------------------------------
//    @Override
//    public boolean canEqual(final Object obj) {
//        return obj instanceof AddrCoordApiResultJuso;
//    }

    // -----------------------------------------------------------------------------------------------------------------

    // -----------------------------------------------------------------------------------------------------------------
    @Schema(description = "행정구역코드")
    @NotNull
    private String admCd;

    @Schema(description = "도로명코드")
    @NotNull
    private String rnMgtSn;

    @Schema(description = "지하여부(0: 지상, 1: 지하)")
    @NotNull
    private String udrtYn;

    @Schema(description = "건물본번")
    @NotNull
    private Integer buldMnnm;

    @Schema(description = "건물부번")
    @NotNull
    private Integer buldSlno;

    @Schema(description = "건물관리번호")
    @NotNull
    private String bdMgtSn;

    @Schema(description = "X좌표")
    @NotNull
    private String entX;

    @Schema(description = "Y좌표")
    @NotNull
    private String entY;

    @Schema(description = "건물명")
    @Nullable
    @jakarta.annotation.Nullable
    private String bdNm;
}
