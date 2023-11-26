package com.github.jinahya.juso.go.kr.api.proxy.stereotype.type;

import java.util.Objects;

public final class __BaseTypeConstants {

    // ----------------------------------------------------------------------------------------------------- currentPage
    public static final int PROPERTY_MIN_CURRENT_PAGE = 1;

    public static final int PROPERTY_DEFAULT_VALUE_CURRENT_PAGE = 1;

    // ---------------------------------------------------------------------------------------------------- countPerPage
    public static final String PROPERTY_NAME_COUNT_PER_PAGE = "countPerPage";

    public static final int PROPERTY_MIN_COUNT_PER_PAGE = 1;

    public static final int PROPERTY_MAX_COUNT_PER_PAGE = 100;

    private static final int PROPERTY_DEFAULT_VALUE_COUNT_PER_PAGE = 10;

    // -----------------------------------------------------------------------------------------------------------------
    public static final String PROPERTY_PATTERN_REGEXP_YN = "[YN]";

    public static final String PROPERTY_VALUE_Y = "Y";

    public static final String PROPERTY_VALUE_N = "N";

    // ------------------------------------------------------------------------------------------------------ resultType
    public static final String PROPERTY_VALUE_RESULT_TYPE_XML = "xml";

    public static final String PROPERTY_VALUE_RESULT_TYPE_JSON = "json";

    public enum ResultType
            implements _PropertyEnum.OfString<ResultType> {

        XML(PROPERTY_VALUE_RESULT_TYPE_XML),

        JSON(PROPERTY_VALUE_RESULT_TYPE_JSON);

        public static ResultType valueOfPropertyValue(final String propertyValue) {
            return OfString.valueOfProeprtyValue(ResultType.class, propertyValue);
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
    private __BaseTypeConstants() {
        throw new AssertionError("instantiation is not allowed");
    }
}
