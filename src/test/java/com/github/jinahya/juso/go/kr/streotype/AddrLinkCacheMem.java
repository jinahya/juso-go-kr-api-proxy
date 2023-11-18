package com.github.jinahya.juso.go.kr.streotype;

import com.github.jinahya.juso.go.kr.web.bind.addrlink.type.AddrLinkApiRequest;
import com.github.jinahya.juso.go.kr.web.bind.addrlink.type.AddrLinkApiResponse;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.CacheManager;
import org.springframework.stereotype.Component;

//@Component
@RequiredArgsConstructor(access = AccessLevel.PACKAGE)
class AddrLinkCacheMem
        implements AddrLinkCache {

    @Override
    public AddrLinkApiResponse get(final AddrLinkApiRequest request) {
        final var cache = cacheManager.getCache(AddrLinkCache.CACHE_NAME_ADDR_LINK);
        if (cache == null) {
            return null;
        }
        return cache.get(request, AddrLinkApiResponse.class);
    }

    private final CacheManager cacheManager;
}
