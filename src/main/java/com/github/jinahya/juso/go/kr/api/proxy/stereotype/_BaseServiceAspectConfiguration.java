package com.github.jinahya.juso.go.kr.api.proxy.stereotype;

import com.github.jinahya.juso.go.kr.api.proxy.stereotype.type.addrlink._AddrlinkResponseType;
import com.github.jinahya.juso.go.kr.api.proxy.stereotype.type.addrlink._AddrlinkType;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.springframework.aop.Advisor;
import org.springframework.aop.aspectj.AspectJExpressionPointcut;
import org.springframework.aop.support.AbstractExpressionPointcut;
import org.springframework.aop.support.DefaultPointcutAdvisor;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.ResolvableType;
import reactor.core.publisher.Mono;

@Configuration
@RequiredArgsConstructor(access = AccessLevel.PACKAGE)
@Slf4j
class _BaseServiceAspectConfiguration {

    @Bean
    @SuppressWarnings({"unchecked"})
    Advisor advisor() {
        final AbstractExpressionPointcut pointcut = new AspectJExpressionPointcut();
        pointcut.setExpression(
                "execution(" +
                "* " +
                _BaseService.class.getCanonicalName() + "+" +
                ".retrieve(..)" +
                ")"
        );
        return new DefaultPointcutAdvisor(pointcut, new MethodInterceptor() {
            @Override
            public Object invoke(final MethodInvocation invocation) throws Throwable {
                final var this_ = invocation.getThis();
                log.debug("invocation.this: {} {}", this_, this_.getClass());
                final var staticPart = invocation.getStaticPart();
                log.debug("invocation.staticPart: {} {}", staticPart, staticPart.getClass());
                final var method = invocation.getMethod();
                log.debug("invocation.method: {} {}", method, method.getClass());
                final var declaringClass = method.getDeclaringClass();
                log.debug("invocation.method.declaringClass: {}", declaringClass);
                final var arguments = invocation.getArguments();
                log.debug("invocation.arguments: {} {}", arguments, arguments.getClass());
                final var request = invocation.getArguments()[0];
                final var result = invocation.proceed();
                assert result != null;
                log.debug("result: {}", result);
                final var resolved = ResolvableType.forInstance(result).as(Mono.class).getGeneric(0).resolve();
                log.debug("resolved: {}", resolved);
                return ((Mono<_AddrlinkResponseType<?>>) result)
                        .doOnSuccess(response -> {
                            final var event = AddrRetrievalEvent.newInstance(this, (_AddrlinkType) request, response);
                            publisher.publishEvent(event);
                        });
            }
        });
    }

    private final ApplicationEventPublisher publisher;
}
