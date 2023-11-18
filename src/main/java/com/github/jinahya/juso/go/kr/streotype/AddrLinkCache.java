package com.github.jinahya.juso.go.kr.streotype;

import com.github.jinahya.juso.go.kr.web.bind.addrlink.type.AddrLinkApiRequest;
import com.github.jinahya.juso.go.kr.web.bind.addrlink.type.AddrLinkApiResponse;
import reactor.core.publisher.Mono;

public interface AddrLinkCache {

    String CACHE_NAME_ADDR_LINK = "addrLink";

    AddrLinkApiResponse get(AddrLinkApiRequest request);
}
