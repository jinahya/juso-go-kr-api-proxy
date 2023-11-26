# juso-go-kr-api-proxy

[주소기반산업지원서비스](https://business.juso.go.kr) 에서 제공하는 API 를 proxy 하기 위한 ~~application~~library 입니다.

## How to build and test

Copy `src/test/resources/application-private-template.yaml` into `application-private.yaml` file, which is listed in the `.gitignore` file, in the same directory, and put required values. See below for an example.

## How to extend

### `@SpringBootApplication` class

Add your own `@SpringBootApplication` class with an additional component scanning path. (`com.github.jinahya.juso.go.kr.api.proxy._NoOp.class` might help.)

```java
package whatever;

@SpringBootApplication(
        scanBasePackageClasses = {
                Application.class,
                com.github.jinahya.juso.go.kr.api.proxy._NoOp.class
        }
)
class Application {

    public static void main(final String... args) {
        SpringApplication.run(Application.class, args);
    }
}
```

### Application properties

Provide required application properties.

| name                                            | value | description     | notes |
|-------------------------------------------------|-------|-----------------|-------|
| `juso-go-kr.addrlink.addr-link-api.confm-key`   |       | 도로명주소 API key   |       |
| `juso-go-kr.addrlink.addr-eng-api.confm-key`    |       | 영문주소 검색 API key |       |
| `juso-go-kr.addrlink.addr-detail-api.confm-key` |       | 상세주소 API key    |       |

e.g.

```yaml
juso-go-kr:
  addrlink:
    addr-link-api:
      confm-key: dev...=
      wiretap-http-client: true # debugging purpose only
    addr-eng-api:
      confm-key: dev...=
      wiretap-http-client: true # debugging purpose only
    addr-detail-api:
      confm-key: dev...=
      wiretap-http-client: true # debugging purpose only
```

## Links

* [Spring Boot 3.0 Migration Guide](https://github.com/spring-projects/spring-boot/wiki/Spring-Boot-3.0-Migration-Guide) (
  github.com/spring-projects/spring-boot)
* [Spring Boot Test 3 NoClassDefFoundError: jakarta/servlet/ServletConnection](https://github.com/spring-projects/spring-boot/issues/33661) (
  github.com/spring-projects/spring-boot)
