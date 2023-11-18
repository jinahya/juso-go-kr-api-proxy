package com.github.jinahya.juso.go.kr.web.bind.addrlink.type;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.jinahya.juso.go.kr.streotype.AddrLinkService;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.lang.Nullable;
import org.springframework.web.util.UriBuilder;

import java.lang.reflect.Modifier;
import java.util.Objects;

@Setter
@Getter
public class AddrLinkApiRequest {

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

    // -----------------------------------------------------------------------------------------------------------------
    public <T extends UriBuilder> T put(final T builder) {
        Objects.requireNonNull(builder, "builder is null");
        for (final var field : getClass().getDeclaredFields()) {
            final var modifiers = field.getModifiers();
            if (Modifier.isStatic(modifiers)) {
                continue;
            }
            try {
                builder.queryParam(field.getName(), field.get(this));
            } catch (final ReflectiveOperationException roe) {
                throw new RuntimeException(roe);
            }
        }
        return builder;
    }

    // -------------------------------------------------------------------------------------------------------- confmKey

    // ----------------------------------------------------------------------------------------------------- currentPage

    // ---------------------------------------------------------------------------------------------------- countPerPage

    // --------------------------------------------------------------------------------------------------------- keyword

    // ------------------------------------------------------------------------------------------------------ resultType

    // --------------------------------------------------------------------------------------------------------- hysryYn

    // ------------------------------------------------------------------------------------------------------- firstSort

    // ------------------------------------------------------------------------------------------------------- addInfoYn

    // -----------------------------------------------------------------------------------------------------------------
    @NotBlank(groups = {AddrLinkService.class}) // may be supplied by the properties
    @ToString.Exclude
    private String confmKey;

    @Min(PROPERTY_MIN_CURRENT_PAGE)
    @NotNull(groups = {AddrLinkService.class}) // may be supplied by the properties
    private Integer currentPage;

    @Max(PROPERTY_MAX_COUNT_PER_PAGE)
    @Min(PROPERTY_MIN_COUNT_PER_PAGE)
    @NotNull(groups = {AddrLinkService.class}) // may be supplied by the properties
    private Integer countPerPage;

    @NotBlank
    private String keyword;

    @Nullable
    @JsonProperty(PROPERTY_NAME_RESULT_TYPE)
    private String resultType;

    @Pattern(regexp = "[YN]")
    @JsonProperty(PROPERTY_NAME_HSTRY_YN)
    private String hstryYn = "N";

    @JsonProperty(PROPERTY_NAME_FIRST_SORT)
    private String firstSort = PROPERTY_VALUE_FIRST_SORT_NONE;

    @Pattern(regexp = "[YN]")
    private String addInfoYn;
}
