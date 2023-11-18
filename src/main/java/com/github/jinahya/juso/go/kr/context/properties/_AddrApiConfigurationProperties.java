package com.github.jinahya.juso.go.kr.context.properties;

import io.netty.channel.ChannelOption;
import io.netty.handler.logging.LogLevel;
import io.netty.handler.timeout.ReadTimeoutHandler;
import io.netty.handler.timeout.WriteTimeoutHandler;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import reactor.netty.http.client.HttpClient;
import reactor.netty.transport.logging.AdvancedByteBufFormat;

import java.time.Duration;
import java.util.Optional;

@Setter
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public abstract class _AddrApiConfigurationProperties {

    static final Duration DEFAULT_CONNECT_TIMEOUT = Duration.ofSeconds(2L);

    static final Duration DEFAULT_WRITE_TIMEOUT = Duration.ofSeconds(4L);

    static final Duration DEFAULT_READ_TIMEOUT = Duration.ofSeconds(8L);

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

    /**
     * Creates a new instance of {@link HttpClient} configured from this configuration properties.
     *
     * @return a new instance of {@link HttpClient} configured from this configuration properties.
     */
    public HttpClient newHttpClient() {
        final var httpClient = HttpClient.create()
                .option(ChannelOption.CONNECT_TIMEOUT_MILLIS, Math.toIntExact(getConnectTimeout().toMillis()))
                .doOnConnected(c -> {
                    Optional.ofNullable(getWriteTimeout()).ifPresent(wt -> {
                        c.addHandlerFirst(new WriteTimeoutHandler(Math.toIntExact(wt.toSeconds())));
                    });
                    c.addHandlerFirst(new ReadTimeoutHandler(Math.toIntExact(getReadTimeout().toSeconds())));
                });
        if (isWiretapHttpClient()) {
//            httpClient.wiretap(true);
            httpClient.wiretap(HttpClient.class.getCanonicalName(), LogLevel.DEBUG, AdvancedByteBufFormat.TEXTUAL);
        }
        return httpClient;
    }

    // -----------------------------------------------------------------------------------------------------------------
    @NotBlank
    private String confmKey;

    @NotNull
    private Duration connectTimeout = DEFAULT_CONNECT_TIMEOUT;

    //    @NotNull
    private Duration writeTimeout = DEFAULT_WRITE_TIMEOUT;

    @NotNull
    private Duration readTimeout = DEFAULT_READ_TIMEOUT;

    private boolean wiretapHttpClient = false;
}
