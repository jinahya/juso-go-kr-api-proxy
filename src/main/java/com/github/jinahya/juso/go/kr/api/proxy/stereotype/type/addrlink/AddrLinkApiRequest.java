package com.github.jinahya.juso.go.kr.api.proxy.stereotype.type.addrlink;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.jinahya.juso.go.kr.api.proxy.stereotype.type._PropertyEnum;
import com.github.jinahya.juso.go.kr.api.proxy.stereotype.type.__BaseTypeConstants;
import com.github.jinahya.juso.go.kr.api.proxy.stereotype.type.__BaseTypeGroup;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Builder;
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
public class AddrLinkApiRequest
        extends _AddrlinkType {

    @Serial
    private static final long serialVersionUID = 3161918070629510134L;

    // ----------------------------------------------------------------------------------------------------- currentPage
    public static final String PROPERTY_NAME_CURRENT_PAGE = "currentPage";

    public static final int PROPERTY_MIN_CURRENT_PAGE = 1;

    public static final int PROPERTY_DEFAULT_VALUE_CURRENT_PAGE = 1;

    // ---------------------------------------------------------------------------------------------------- countPerPage
    public static final String PROPERTY_NAME_COUNT_PER_PAGE = "countPerPage";

    public static final int PROPERTY_MIN_COUNT_PER_PAGE = 1;

    public static final int PROPERTY_MAX_COUNT_PER_PAGE = 100;

    public static final int PROPERTY_DEFAULT_VALUE_COUNT_PER_PAGE = 10;

    // --------------------------------------------------------------------------------------------------------- keyword
    public static final String PROPERTY_NAME_KEYWORD = "keyword";

    // ------------------------------------------------------------------------------------------------------ resultType
    public static final String PROPERTY_NAME_RESULT_TYPE = "resultType";

    public static final String PROPERTY_VALUE_RESULT_TYPE_XML = "xml";

    public static final String PROPERTY_VALUE_RESULT_TYPE_JSON = "json";

    // --------------------------------------------------------------------------------------------------------- hstryYn
    public static final String PROPERTY_NAME_HSTRY_YN = "hstryYn";

    // ------------------------------------------------------------------------------------------------------- firstSort
    public static final String PROPERTY_NAME_FIRST_SORT = "firstSort";

    public static final String PROPERTY_VALUE_FIRST_SORT_NONE = "none";

    public static final String PROPERTY_VALUE_FIRST_SORT_ROAD = "road";

    public static final String PROPERTY_VALUE_FIRST_SORT_LOCATION = "location";

    public enum FirstSort
            implements _PropertyEnum.OfString<FirstSort> {

        NONE(PROPERTY_VALUE_FIRST_SORT_NONE),

        ROAD(PROPERTY_VALUE_FIRST_SORT_ROAD),

        LOCATION(PROPERTY_VALUE_FIRST_SORT_LOCATION);

        // -------------------------------------------------------------------------------------------------------------
        public static FirstSort valueOfPropertyValue(final String propertyValue) {
            return OfString.valueOfProeprtyValue(FirstSort.class, propertyValue);
        }

        // -------------------------------------------------------------------------------------------------------------

        FirstSort(final String propertyValue) {
            this.propertyValue = Objects.requireNonNull(propertyValue, "propertyValue is null");
        }

        FirstSort() {
            this(null);
        }

        @Override
        public String getPropertyValue() {
            return Objects.requireNonNullElseGet(propertyValue, () -> name().toLowerCase());
        }

        private final String propertyValue;
    }

    // ------------------------------------------------------------------------------------------------------- addInfoYn
    public static final String PROPERTY_NAME_ADD_INFO_YN = "addInfoYn";

    // -----------------------------------------------------------------------------------------------------------------
//    @Override
//    public boolean canEqual(final Object obj) {
//        return obj instanceof AddrCoordApiRequest;
//    }
    // -----------------------------------------------------------------------------------------------------------------

    // -------------------------------------------------------------------------------------------------------- confmKey

    // ----------------------------------------------------------------------------------------------------- currentPage

    // ---------------------------------------------------------------------------------------------------- countPerPage

    // --------------------------------------------------------------------------------------------------------- keyword

    // ------------------------------------------------------------------------------------------------------ resultType

    // --------------------------------------------------------------------------------------------------------- hstryYn

    // ------------------------------------------------------------------------------------------------------- firstSort

    @Schema(hidden = true)
    @JsonIgnore
    FirstSort getFirstSortAsEnum() {
        return Optional.ofNullable(firstSort)
                .map(FirstSort::valueOfPropertyValue)
                .orElse(null);
    }

    void setFirstSortAsEnum(final FirstSort firstSortAsEnum) {
        setFirstSort(
                Optional.ofNullable(firstSortAsEnum)
                        .map(_PropertyEnum::getPropertyValue)
                        .orElse(null)
        );
    }

    // ------------------------------------------------------------------------------------------------------- addInfoYn

    // -----------------------------------------------------------------------------------------------------------------
    @Schema(description = "신청 시 발급받은 승인키")
    @NotBlank(groups = {__BaseTypeGroup.class}) // may be supplied by the properties
    @ToString.Exclude
    private String confmKey;

    @Schema(description = "현재 페이지 번호 ( n>0 )")
    @Min(PROPERTY_MIN_CURRENT_PAGE)
    @NotNull(groups = {__BaseTypeGroup.class}) // ?page
    private Integer currentPage;

    @Schema(description = "페이지당 출력 할 결과 Row 수 (0<n<=100 )")
    @Max(PROPERTY_MAX_COUNT_PER_PAGE)
    @Min(PROPERTY_MIN_COUNT_PER_PAGE)
    @NotNull(groups = {__BaseTypeGroup.class}) // ?size
    private Integer countPerPage;

    @Schema(description = "주소 검색어")
    @NotBlank
    private String keyword;

    @Schema(description = "검색결과형식 설정(기본 XML형식) json 입력 시 JSON형식의 결과제공")
    @Nullable
    @JsonProperty(PROPERTY_NAME_RESULT_TYPE)
    private String resultType;

    @Schema(description = "변동된 주소정보 포함 여부")
    @Pattern(regexp = __BaseTypeConstants.PROPERTY_PATTERN_REGEXP_YN)
    @JsonProperty(PROPERTY_NAME_HSTRY_YN)
    @Builder.Default
    private String hstryYn = __BaseTypeConstants.PROPERTY_VALUE_N;

    @JsonProperty(PROPERTY_NAME_FIRST_SORT)
    @Builder.Default
    private String firstSort = PROPERTY_VALUE_FIRST_SORT_NONE;

    @Schema(description = "출력결과에 추가된 항목(hstryYn, relJibun, hemdNm) 제공여부")
    @Pattern(regexp = __BaseTypeConstants.PROPERTY_PATTERN_REGEXP_YN)
    @Builder.Default
    private String addInfoYn = __BaseTypeConstants.PROPERTY_VALUE_N;
}
