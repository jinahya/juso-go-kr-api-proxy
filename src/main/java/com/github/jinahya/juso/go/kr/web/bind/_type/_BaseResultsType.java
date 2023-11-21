package com.github.jinahya.juso.go.kr.web.bind._type;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.AccessLevel;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serial;

@Setter
@Getter
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class _BaseResultsType<DATA>
        extends _BaseType {

    @Serial
    private static final long serialVersionUID = -2677127086394138508L;

    // -----------------------------------------------------------------------------------------------------------------
    @Setter
    @Getter
    @EqualsAndHashCode(callSuper = true)
    @ToString(callSuper = true)
    public static class Common
            extends _BaseType {

        @Serial
        private static final long serialVersionUID = -1440100445784510799L;

        // -------------------------------------------------------------------------------------------------- totalCount
        public static final String PROPERTY_NAME_TOTAL_COUNT = "totalCount";

        // ------------------------------------------------------------------------------------------------- currentPage
        public static final String PROPERTY_NAME_CURRENT_PAGE = "currentPage";

//        private static final int PROPERTY_MIN_CURRENT_PAGE = 1;
//
//        private static final int PROPERTY_MAX_CURRENT_PAGE = 100;
//
//        private static final int PROPERTY_DEFAULT_VALUE_CURRENT_PAGE = 10;

        // ------------------------------------------------------------------------------------------------ countPerPage
        public static final String PROPERTY_NAME_COUNT_PER_PAGE = "countPerPage";

//        private static final int PROPERTY_MIN_COUNT_PER_PAGE = 1;
//
//        private static final int PROPERTY_MAX_COUNT_PER_PAGE = 100;
//
//        private static final int PROPERTY_DEFAULT_VALUE_COUNT_PER_PAGE = 10;

        // --------------------------------------------------------------------------------------------------- errorCode
        public static final String PROPERTY_NAME_ERROR_CODE = "errorCode";

        public static final String PROPERTY_VALUE_ERROR_CODE_0 = "0";

        public static final String PROPERTY_VALUE_ERROR_CODE_E0001 = "E0001";

        // ------------------------------------------------------------------------------------------------ errorMessage
        public static final String PROPERTY_NAME_ERROR_MESSAGE = "errorMessage";

        // -------------------------------------------------------------------------------------------------------------
        @PositiveOrZero
        @NotNull
        @JsonProperty(PROPERTY_NAME_TOTAL_COUNT)
        private Integer totalCount;

        @Positive
        @NotNull
        @JsonProperty(PROPERTY_NAME_CURRENT_PAGE)
        private Integer currentPage;

        @Positive
        @NotNull
        @JsonProperty(PROPERTY_NAME_COUNT_PER_PAGE)
        private Integer countPerPage;

        @JsonProperty(PROPERTY_NAME_ERROR_CODE)
        private String errorCode;

        @JsonProperty(PROPERTY_NAME_ERROR_MESSAGE)
        private String errorMessage;
    }

    // -----------------------------------------------------------------------------------------------------------------

    // -----------------------------------------------------------------------------------------------------------------

    // ---------------------------------------------------------------------------------------------------------- common

    // ------------------------------------------------------------------------------------------------------------ data

    // -----------------------------------------------------------------------------------------------------------------
    private Common common;

    @JsonIgnore
    @Setter(AccessLevel.PROTECTED)
    @Getter(AccessLevel.PROTECTED)
    private DATA data;
}
