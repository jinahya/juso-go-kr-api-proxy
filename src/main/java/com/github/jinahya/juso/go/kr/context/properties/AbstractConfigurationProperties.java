package com.github.jinahya.juso.go.kr.context.properties;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.context.annotation.Configuration;

import java.time.Duration;

@Configuration
@Setter
@Getter
@NoArgsConstructor(access = AccessLevel.PACKAGE)
abstract class AbstractConfigurationProperties {

    static final Duration DEFAULT_CONNECT_TIMEOUT = Duration.ofSeconds(1L);

    static final Duration DEFAULT_WRITE_TIMEOUT = Duration.ofSeconds(2L);

    static final Duration DEFAULT_READ_TIMEOUT = Duration.ofSeconds(4L);

    // -----------------------------------------------------------------------------------------------------------------

    // -----------------------------------------------------------------------------------------------------------------

    @Override
    public String toString() {
        return super.toString() + '{' +
               "confmKey=" + confmKey +
               ",connectTimeout=" + connectTimeout +
               ",writeTimeout=" + writeTimeout +
               ",readTimeout=" + readTimeout +
               '}';
    }

    // -----------------------------------------------------------------------------------------------------------------
    @NotBlank
    private String confmKey;

    @NotNull
    private Duration connectTimeout = DEFAULT_CONNECT_TIMEOUT;

    @NotNull
    private Duration writeTimeout = DEFAULT_WRITE_TIMEOUT;

    @NotNull
    private Duration readTimeout = DEFAULT_READ_TIMEOUT;
}
