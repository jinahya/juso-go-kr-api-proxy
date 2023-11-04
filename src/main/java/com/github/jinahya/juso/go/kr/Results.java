package com.github.jinahya.juso.go.kr;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.NoArgsConstructor;

import java.util.Objects;

@NoArgsConstructor
public class Results {

    // ---------------------------------------------------------------------------------------------------------- common
    public static final String PROPERTY_NAME_COMMON = "common";

    public static class Common {

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

    @Override
    public String toString() {
        return super.toString() + '{' +
               "common=" + common +
               '}';
    }

    @Override
    public boolean equals(final Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Results that)) {
            return false;
        }
        return Objects.equals(common, that.common);
    }

    @Override
    public int hashCode() {
        return Objects.hash(common);
    }

    // ---------------------------------------------------------------------------------------------------------- common

    public Common getCommon() {
        return common;
    }

    public void setCommon(final Common common) {
        this.common = common;
    }

    // -----------------------------------------------------------------------------------------------------------------
    @Valid
    @NotNull
    @JsonProperty(PROPERTY_NAME_COMMON)
    private Common common;
}
