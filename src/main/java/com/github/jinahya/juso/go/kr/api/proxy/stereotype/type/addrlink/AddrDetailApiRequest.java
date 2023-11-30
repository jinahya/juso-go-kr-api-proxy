package com.github.jinahya.juso.go.kr.api.proxy.stereotype.type.addrlink;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.github.jinahya.juso.go.kr.api.proxy.stereotype.type._PropertyEnum;
import com.github.jinahya.juso.go.kr.api.proxy.stereotype.type.__BaseTypeGroup;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.AssertTrue;
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
import java.util.Objects;
import java.util.Optional;

@Setter
@Getter
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@NoArgsConstructor
@Jacksonized
@SuperBuilder(toBuilder = true)
public class AddrDetailApiRequest
        extends _AddrlinkType {

    @Serial
    private static final long serialVersionUID = -642188028222547663L;

    // -------------------------------------------------------------------------------------------------------- confmKey

    // ----------------------------------------------------------------------------------------------------------- amdCd

    // ---------------------------------------------------------------------------------------------------------- rnMgSn

    // ---------------------------------------------------------------------------------------------------------- udrtYn
    public static final String PROPERTY_VALUE_UDRT_0 = "0";

    public static final String PROPERTY_VALUE_UDRT_1 = "1";

    // -----------------------------------------------------------------------------------------------------------------
//    @Override
//    public boolean canEqual(final Object obj) {
//        return obj instanceof AddrDetailApiRequest;
//    }

    // -------------------------------------------------------------------------------------------------------- buldMnnm

    // -------------------------------------------------------------------------------------------------------- buldSlno

    // ------------------------------------------------------------------------------------------------------ searchType
    public static final String PROPERTY_VALUE_SEARCH_TYPE_DONG = "dong";

    public static final String PROPERTY_VALUE_SEARCH_TYPE_FLOORHO = "floorho";

    public enum SearchType
            implements _PropertyEnum.OfString<SearchType> {

        DONG(PROPERTY_VALUE_SEARCH_TYPE_DONG),

        FLOORHO(PROPERTY_VALUE_SEARCH_TYPE_FLOORHO);

        public static SearchType valueOfPropertyValue(final String propertyValue) {
            return _PropertyEnum.OfString.valueOfProeprtyValue(SearchType.class, propertyValue);
        }

        SearchType(final String propertyValue) {
            this.propertyValue = Objects.requireNonNull(propertyValue, "propertyValue is null");
        }

        @Override
        public String getPropertyValue() {
            return propertyValue;
        }

        private final String propertyValue;
    }

    // ---------------------------------------------------------------------------------------------------------- dongNm

    // ------------------------------------------------------------------------------------------------------ resultType
    public static final String PROPERTY_VALUE_RESULT_TYPE_XML = "xml";

    public static final String PROPERTY_VALUE_RESULT_TYPE_JSON = "json";

    public enum ResultType
            implements _PropertyEnum.OfString<ResultType> {

        XML(PROPERTY_VALUE_RESULT_TYPE_XML),

        JSON(PROPERTY_VALUE_RESULT_TYPE_JSON);

        public static ResultType valueOfPropertyValue(final String propertyValue) {
            return _PropertyEnum.OfString.valueOfProeprtyValue(ResultType.class, propertyValue);
        }

        ResultType(final String propertyValue) {
            this.propertyValue = Objects.requireNonNull(propertyValue, "propertyValue is null");
        }

        @Override
        public String getPropertyValue() {
            return propertyValue;
        }

        private final String propertyValue;
    }
    // -----------------------------------------------------------------------------------------------------------------

    // -----------------------------------------------------------------------------------------------------------------

    // -------------------------------------------------------------------------------------------------------- confmKey

    // ----------------------------------------------------------------------------------------------------------- amdCd

    // ---------------------------------------------------------------------------------------------------------- rnMgSn

    // ---------------------------------------------------------------------------------------------------------- udrtYn

    // -------------------------------------------------------------------------------------------------------- buldMnnm

    // -------------------------------------------------------------------------------------------------------- buldSlno

    // ------------------------------------------------------------------------------------------------------ searchType

    @Schema(hidden = true)
    @JsonIgnore
    @Nullable
    SearchType getSearchTypeAsEnum_() {
        return Optional.ofNullable(getSearchType())
                .map(SearchType::valueOfPropertyValue)
                .orElse(null);
    }

    void setSearchTypeAsEnum(@Nullable final SearchType searchTypeAsEnum_) {
        setSearchType(
                Optional.ofNullable(searchTypeAsEnum_)
                        .map(_PropertyEnum.OfString::getPropertyValue)
                        .orElse(null)
        );
    }

    // ---------------------------------------------------------------------------------------------------------- dongNm
    @AssertTrue(message = "'dongNm' should be specified when 'searchType' is 'floorho'")
    private boolean isDongNmSpecifiedWhenSearchTypeIsFloorho() {
        if (!PROPERTY_VALUE_SEARCH_TYPE_FLOORHO.equals(searchType)) {
            return true;
        }
        return dongNm != null;
    }

    // ------------------------------------------------------------------------------------------------------ resultType

    @Schema(hidden = true)
    @JsonIgnore
    @Nullable
    ResultType getResultTypeAsEnum_() {
        return Optional.ofNullable(getResultType())
                .map(ResultType::valueOfPropertyValue)
                .orElse(null);
    }

    void setResultTypeAsEnum(@Nullable final ResultType resultTypeAsEnum_) {
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

    @Schema(description = "건물부번")
    @Nullable
    private String searchType;

    @Schema(description = "동 (층호 검색 시 입력")
    @Nullable
    private String dongNm;

    @Schema(description = "검색결과형식 설정(xml, json)")
    @Nullable
    private String resultType;
}
