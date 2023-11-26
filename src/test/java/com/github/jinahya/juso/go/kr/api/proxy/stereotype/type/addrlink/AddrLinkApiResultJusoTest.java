package com.github.jinahya.juso.go.kr.api.proxy.stereotype.type.addrlink;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

class AddrLinkApiResultJusoTest
        extends _AddrlinkTypeTest<AddrLinkApiResultJuso> {

    AddrLinkApiResultJusoTest() {
        super(AddrLinkApiResultJuso.class);
    }

    @DisplayName("aboveGround")
    @Nested
    class AboveGroundTest {

        @DisplayName("getAboveGround")
        @Nested
        class GetAboveGroundTest {

            @Test
            void __() {
                // ----------------------------------------------------------------------------------------------- given
                final var instance = newTypeInstance();
                // ------------------------------------------------------------------------------------------------ when
                final var aboveGround = instance.getAboveGround_();
                // ------------------------------------------------------------------------------------------------ then
                assertThat(aboveGround).isNull();
            }

            @DisplayName("()True <- getUdrtYn()PROPERTY_VALUE_UDR_YN_ABOVE_GROUND")
            @Test
            void _True_PROPERTY_VALUE_UDR_YN_ABOVE_GROUND() {
                // ----------------------------------------------------------------------------------------------- given
                final var instance = newTypeSpy();
                given(instance.getUdrtYn())
                        .willReturn(AddrLinkApiResultJuso.PROPERTY_VALUE_UDR_YN_ABOVE_GROUND);
                // ------------------------------------------------------------------------------------------------ when
                final var aboveGround = instance.getAboveGround_();
                // ------------------------------------------------------------------------------------------------ then
                assertThat(aboveGround).isTrue();
            }

            @DisplayName("()True <- getUdrtYn()PROPERTY_VALUE_UDR_YN_UNDERGROUND")
            @Test
            void _False_PROPERTY_VALUE_UDR_YN_UNDERGROUND() {
                // ----------------------------------------------------------------------------------------------- given
                final var instance = newTypeSpy();
                given(instance.getUdrtYn())
                        .willReturn(AddrLinkApiResultJuso.PROPERTY_VALUE_UDR_YN_UNDERGROUND);
                // ------------------------------------------------------------------------------------------------ when
                final var aboveGround = instance.getAboveGround_();
                // ------------------------------------------------------------------------------------------------ then
                assertThat(aboveGround).isFalse();
            }
        }

        @DisplayName("setAboveGround")
        @Nested
        class SetAboveGroundTest {

            @DisplayName("(null) -> setUdrtYn(null)")
            @Test
            void _Null_Null() {
                // ----------------------------------------------------------------------------------------------- given
                final var instance = newTypeSpy();
                // ------------------------------------------------------------------------------------------------ when
                instance.setAboveGround_(null);
                // ------------------------------------------------------------------------------------------------ then
                verify(instance, times(1)).setUdrtYn(null);
            }

            @DisplayName("(TRUE) -> getUdrtYn(PROPERTY_VALUE_UDR_YN_ABOVE_GROUND)")
            @Test
            void _PROPERTY_VALUE_UDR_YN_ABOVE_GROUND_TRUE() {
                // ----------------------------------------------------------------------------------------------- given
                final var instance = newTypeSpy();
                // ------------------------------------------------------------------------------------------------ when
                instance.setAboveGround_(Boolean.TRUE);
                // ------------------------------------------------------------------------------------------------ then
                verify(instance, times(1)).setUdrtYn(AddrLinkApiResultJuso.PROPERTY_VALUE_UDR_YN_ABOVE_GROUND);
            }

            @DisplayName("(FALSE) -> getUdrtYn(PROPERTY_VALUE_UDR_YN_UNDERGROUND)")
            @Test
            void _PROPERTY_VALUE_UDR_YN_UNDERGROUND_FALSE() {
                // ----------------------------------------------------------------------------------------------- given
                final var instance = newTypeSpy();
                // ------------------------------------------------------------------------------------------------ when
                instance.setAboveGround_(Boolean.FALSE);
                // ------------------------------------------------------------------------------------------------ then
                verify(instance, times(1)).setUdrtYn(AddrLinkApiResultJuso.PROPERTY_VALUE_UDR_YN_UNDERGROUND);
            }
        }
    }
}
