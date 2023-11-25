package com.github.jinahya.juso.go.kr.api.proxy.context.properties;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
import reactor.netty.http.client.HttpClient;

@Component
@ConfigurationProperties(prefix = "juso-go-kr.addrlink.addr-eng-api")
//@Configuration
@Setter
@Getter
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@NoArgsConstructor
public class AddrEngApiConfigurationProperties
        extends _AddrApiConfigurationProperties {

    public static final String REQUEST_URI = "/addrlink/addrEngApi.do";

    public static final String BASE_URL = "https://business.juso.go.kr" + REQUEST_URI;

    // -----------------------------------------------------------------------------------------------------------------
    @Override
    public HttpClient newHttpClient() {
        return super.newHttpClient()
                .baseUrl(getBaseUrl());
    }

    // -----------------------------------------------------------------------------------------------------------------
    private String baseUrl = BASE_URL;
}
