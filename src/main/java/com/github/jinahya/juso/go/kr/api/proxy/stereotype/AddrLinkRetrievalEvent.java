package com.github.jinahya.juso.go.kr.api.proxy.stereotype;

import com.github.jinahya.juso.go.kr.api.proxy.stereotype.type.addrlink.AddrLinkApiRequest;
import com.github.jinahya.juso.go.kr.api.proxy.stereotype.type.addrlink.AddrLinkApiResponse;

import java.io.Serial;

public class AddrLinkRetrievalEvent
        extends AddrRetrievalEvent<AddrLinkApiRequest, AddrLinkApiResponse> {

    @Serial
    private static final long serialVersionUID = 8845743860814679847L;

    public AddrLinkRetrievalEvent(final Object source, final AddrLinkApiRequest request,
                                  final AddrLinkApiResponse response) {
        super(source, request, response);
    }
}
