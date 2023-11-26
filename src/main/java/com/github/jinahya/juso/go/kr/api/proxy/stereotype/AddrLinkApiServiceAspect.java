package com.github.jinahya.juso.go.kr.api.proxy.stereotype;

import com.github.jinahya.juso.go.kr.api.proxy.stereotype.type.addrlink.AddrLinkApiRequest;
import com.github.jinahya.juso.go.kr.api.proxy.stereotype.type.addrlink.AddrLinkApiResponse;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

@Component
@Aspect
@Slf4j
class AddrLinkApiServiceAspect {

    @Pointcut("execution(* " +
              "com.github.jinahya.juso.go.kr.api.proxy.stereotype." +
              "AddrLinkApiService" +
              ".retrieve(..)" +
              ")")
    void retrieve() {
    }

    @Around("retrieve()  && args(request)")
    @SuppressWarnings({
            "unchecked"
    })
    Object __(final ProceedingJoinPoint joinPoint, final AddrLinkApiRequest request) throws Throwable {
        log.debug("------> request: {}", request);
        return ((Mono<AddrLinkApiResponse>) joinPoint.proceed())
                .handle((v, s) -> {
                    log.debug("----> response: {}", v);
                    s.next(v);
                });
    }
}
