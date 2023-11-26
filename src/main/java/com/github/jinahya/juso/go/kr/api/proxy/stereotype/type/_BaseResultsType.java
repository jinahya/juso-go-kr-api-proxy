package com.github.jinahya.juso.go.kr.api.proxy.stereotype.type;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.AccessLevel;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;
import org.springframework.lang.Nullable;

import java.io.Serial;

@Setter
@Getter
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@SuperBuilder(toBuilder = true)
public class _BaseResultsType<DATA>
        extends __BaseType {

    @Serial
    private static final long serialVersionUID = -2677127086394138508L;

    // -----------------------------------------------------------------------------------------------------------------
    @Setter
    @Getter
    @EqualsAndHashCode(callSuper = true)
    @ToString(callSuper = true)
    public static class Common
            extends __BaseType {

        @Serial
        private static final long serialVersionUID = -1440100445784510799L;

        // -------------------------------------------------------------------------------------------------- totalCount

        // ------------------------------------------------------------------------------------------------- currentPage

        // ------------------------------------------------------------------------------------------------ countPerPage

        // --------------------------------------------------------------------------------------------------- errorCode
        public static final String PROPERTY_VALUE_ERROR_CODE_0 = "0";

        public static final String PROPERTY_VALUE_ERROR_CODE_E0001 = "E0001";

        // ------------------------------------------------------------------------------------------------ errorMessage

        // -------------------------------------------------------------------------------------------------------------
        @PositiveOrZero
        @NotNull
        private Integer totalCount;

        @Positive
//        @NotNull
        @Nullable
        @jakarta.annotation.Nullable
        private Integer currentPage;

        @Positive
//        @NotNull
        @Nullable
        @jakarta.annotation.Nullable
        private Integer countPerPage;

        private String errorCode;

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
