package com.github.jinahya.juso.go.kr.web.bind;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

@Slf4j
class RemoveMeTest {

    @Test
    void __1over7() {
        {
            var value = 1.0d / 7;
            log.debug("value: {}, formatted: {}", value, String.format("%1$.20f", value));
            log.debug("value: {}, formatted: {}", value, String.format("%1$.17f", value));
            log.debug("value: {}, formatted: {}", value, String.format("%1$.16f", value));
            log.debug("value: {}, formatted: {}", value, BigDecimal.valueOf(value).stripTrailingZeros());
        }
        {
            var value = 1.0d / 3;
            log.debug("value: {}, formatted: {}", value, String.format("%1$.20f", value));
            log.debug("value: {}, formatted: {}", value, String.format("%1$.17f", value));
            log.debug("value: {}, formatted: {}", value, String.format("%1$.16f", value));
            log.debug("value: {}, formatted: {}", value, BigDecimal.valueOf(value).stripTrailingZeros());
        }
    }

    @Test
    void __1over3() {
        {
            var value = 1.0f / 3;
            log.debug("value: {}, formatted(20): {}", value, String.format("%1$.20f", value));
            log.debug("value: {}, formatted(17): {}", value, String.format("%1$.17f", value));
            log.debug("value: {}, formatted(16): {}", value, String.format("%1$.16f", value));
            log.debug("value: {}, formatted: {}", value, BigDecimal.valueOf(value).stripTrailingZeros());
        }
        {
            var value = 1.0d / 3;
            log.debug("value: {}, formatted(20): {}", value, String.format("%1$.20f", value));
            log.debug("value: {}, formatted(17): {}", value, String.format("%1$.17f", value));
            log.debug("value: {}, formatted(16): {}", value, String.format("%1$.16f", value));
            log.debug("value: {}, formatted: {}", value, BigDecimal.valueOf(value).stripTrailingZeros());
        }
    }
}
