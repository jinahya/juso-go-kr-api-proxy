package com.github.jinahya.juso.go.kr.web.bind.addrlink;

import com.github.jinahya.juso.go.kr.web.bind.addrlink.type.AddrLinkApiRequest;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.reactive.server.WebTestClient;

import java.util.Optional;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Stream;

import static java.util.concurrent.ThreadLocalRandom.current;

@AutoConfigureWebTestClient
@SpringBootTest
@Slf4j
class AddrLinkApiControllerIT {

    private static Stream<String> keywords() {
        return Stream.of(
                "한국지역정보개발원",
                "유현리"
        );
    }

    @ValueSource(strings = {
            "한국지역정보개발원",
            "유현리"
    })
    @ParameterizedTest
    void __(final String keyword) {
        final var request = new AddrLinkApiRequest();
        request.setKeyword(keyword);
        request.setResultType(AddrLinkApiRequest.PROPERTY_VALUE_RESULT_TYPE_JSON);
        final var page = current().nextBoolean() ? new AtomicInteger(1) : null;
        final var size = current().nextBoolean()
                         ? current().nextInt(1, AddrLinkApiRequest.PROPERTY_MAX_COUNT_PER_PAGE + 1)
                         : null;
//        while (true) {
//            final var response = controller.post(
//                            n
//                            request,
//                            Optional.ofNullable(page).map(AtomicInteger::getAndIncrement).orElse(null),
//                            size
//                    )
//                    .block();
//            if (response.getJuso().isEmpty()) {
//                break;
//            }
//        }
    }

    @Autowired
    private WebTestClient client;
}
