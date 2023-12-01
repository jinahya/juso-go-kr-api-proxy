package com.github.jinahya.juso.go.kr.api.proxy.stereotype;

import com.github.jinahya.juso.go.kr.api.proxy.stereotype.type.addrlink._AddrlinkResponseType;
import com.github.jinahya.juso.go.kr.api.proxy.stereotype.type.addrlink._AddrlinkType;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationEvent;

import java.io.Serial;
import java.util.Objects;

@Setter
@Getter
@Slf4j
abstract class AddrRetrievalEvent<REQUEST extends _AddrlinkType, RESPONSE extends _AddrlinkResponseType<?>>
        extends ApplicationEvent {

    @Serial
    private static final long serialVersionUID = -1963957804595844675L;

    private static class Generic
            extends AddrRetrievalEvent<_AddrlinkType, _AddrlinkResponseType<?>> {

        @Serial
        private static final long serialVersionUID = -5011522362571586033L;

        private Generic(final Object source, final _AddrlinkType request, final _AddrlinkResponseType<?> response) {
            super(source, request, response);
        }
    }

    static AddrRetrievalEvent<_AddrlinkType, _AddrlinkResponseType<?>> newInstance(
            final Object source, final _AddrlinkType request, final _AddrlinkResponseType<?> response) {
        return new Generic(source, request, response);
    }

    AddrRetrievalEvent(final Object source, final REQUEST request, final RESPONSE response) {
        super(source);
        this.request = Objects.requireNonNull(request, "request is null");
        this.response = Objects.requireNonNull(response, "response is null");
    }

    @Override
    public String toString() {
        return super.toString() + '{' +
               "request=" + request +
               ",response=" + response +
               '}';
    }

    @Override
    public boolean equals(final Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AddrRetrievalEvent<?, ?> that)) {
            return false;
        }
        return Objects.equals(request, that.request) && Objects.equals(response, that.response);
    }

    @Override
    public int hashCode() {
        return Objects.hash(request, response);
    }

    private final REQUEST request;

    private final RESPONSE response;
}
