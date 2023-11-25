package com.github.jinahya.juso.go.kr.api.proxy.web.bind.addrlink._type;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.jinahya.juso.go.kr.api.proxy.web.bind._type.__BaseTypeConstants;
import com.github.jinahya.juso.go.kr.api.proxy.web.bind._type.__BaseTypeGroup;
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

    private static final int PROPERTY_DEFAULT_VALUE_COUNT_PER_PAGE = 10;

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

    // ------------------------------------------------------------------------------------------------------- addInfoYn
    public static final String PROPERTY_NAME_ADD_INFO_YN = "addInfoYn";

    // -----------------------------------------------------------------------------------------------------------------

    // -----------------------------------------------------------------------------------------------------------------

    // -------------------------------------------------------------------------------------------------------- confmKey

    // ----------------------------------------------------------------------------------------------------- currentPage

    // ---------------------------------------------------------------------------------------------------- countPerPage

    // --------------------------------------------------------------------------------------------------------- keyword

    // ------------------------------------------------------------------------------------------------------ resultType

    // --------------------------------------------------------------------------------------------------------- hstryYn

    // ------------------------------------------------------------------------------------------------------- firstSort

    // ------------------------------------------------------------------------------------------------------- addInfoYn

    // -----------------------------------------------------------------------------------------------------------------
    @NotBlank(groups = {__BaseTypeGroup.class}) // may be supplied by the properties
    @ToString.Exclude
    private String confmKey;

    @Min(PROPERTY_MIN_CURRENT_PAGE)
    @NotNull(groups = {__BaseTypeGroup.class}) // ?page
    private Integer currentPage;

    @Max(PROPERTY_MAX_COUNT_PER_PAGE)
    @Min(PROPERTY_MIN_COUNT_PER_PAGE)
    @NotNull(groups = {__BaseTypeGroup.class}) // ?size
    private Integer countPerPage;

    @NotBlank
    private String keyword;

    @Nullable
    @JsonProperty(PROPERTY_NAME_RESULT_TYPE)
    private String resultType;

    @Pattern(regexp = __BaseTypeConstants.PROPERTY_PATTERN_REGEXP_YN)
    @JsonProperty(PROPERTY_NAME_HSTRY_YN)
    @Builder.Default
    private String hstryYn = __BaseTypeConstants.PROPERTY_VALUE_N;

    @JsonProperty(PROPERTY_NAME_FIRST_SORT)
    @Builder.Default
    private String firstSort = PROPERTY_VALUE_FIRST_SORT_NONE;

    @Pattern(regexp = __BaseTypeConstants.PROPERTY_PATTERN_REGEXP_YN)
    @Builder.Default
    private String addInfoYn = __BaseTypeConstants.PROPERTY_VALUE_N;
}
