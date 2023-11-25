package com.github.jinahya.juso.go.kr.api.proxy.context;

import com.github.benmanes.caffeine.cache.Caffeine;
import org.springframework.cache.CacheManager;
import org.springframework.cache.caffeine.CaffeineCacheManager;
import org.springframework.context.annotation.Bean;

import java.util.concurrent.TimeUnit;

//@EnableCaching
//@Configuration
public class CacheConfiguration {

    @Bean
    Caffeine<Object, Object> caffeine() {
        return Caffeine.newBuilder().expireAfterWrite(60, TimeUnit.MINUTES);
    }

    @Bean
    CacheManager cacheManager(final Caffeine<Object, Object> caffeine) {
        final var cacheManager = new CaffeineCacheManager();
        cacheManager.setCaffeine(caffeine);
        return cacheManager;
    }
}
