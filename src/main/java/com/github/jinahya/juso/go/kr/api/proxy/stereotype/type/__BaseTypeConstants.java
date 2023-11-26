package com.github.jinahya.juso.go.kr.api.proxy.stereotype.type;

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

    // -----------------------------------------------------------------------------------------------------------------
    private __BaseTypeConstants() {
        throw new AssertionError("instantiation is not allowed");
    }
}
