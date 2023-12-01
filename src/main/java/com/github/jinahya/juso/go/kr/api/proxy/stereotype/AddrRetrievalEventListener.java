package com.github.jinahya.juso.go.kr.api.proxy.stereotype;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.EventListener;

@Slf4j
public class AddrRetrievalEventListener {

    @EventListener
    public void handle(final AddrRetrievalEvent<?, ?> event) {
        log.debug("event: {}", event);
    }
}
