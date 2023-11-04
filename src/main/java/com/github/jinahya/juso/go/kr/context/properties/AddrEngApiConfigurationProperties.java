package com.github.jinahya.juso.go.kr.context.properties;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@ConfigurationProperties(prefix = "juso-go-kr.addrlink.addr-eng-api")
@Configuration
@Setter
@Getter
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@NoArgsConstructor
public class AddrEngApiConfigurationProperties
        extends AbstractConfigurationProperties {

    public static final String BASE_URL = "https://business.juso.go.kr/addrlink/addrEngApi.do";
}
