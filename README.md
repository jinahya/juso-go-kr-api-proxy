# juso-go-kr-api-proxy

An application for proxying APIs from https://business.juso.go.kr.

## How to extend

### `@SpringBootApplication` class

Add your own `@SpringBootApplication` class with an additional component scanning
path. (`com.github.jinahya.juso.go.kr.api.proxy._NoOp.class` might help.)

```java
package whatever;

@SpringBootApplication(
        scanBasePackageClasses = {
                Application.class,
                com.github.jinahya.juso.go.kr.api.proxy._NoOp.class
        }
)
public class Application {

    public static void main(final String... args) {
        SpringApplication.run(Application.class, args);
    }
}
```

### Application properties

Provide required application properties.

| name                                          | value | description      | notes |
|-----------------------------------------------|-------|------------------|-------|
| `juso-go-kr.addrlink.addr-link-api.confm-key` |       | 검색 API key       |       |
| `juso-go-kr.addrlink.addr-eng-api.confm-key`  |       | 영문 주소 검색 API key |       |

e.g.

```yaml
juso-go-kr:
  addrlink:
    addr-link-api:
      confm-key: devU01TX0FVVEgyMDIzMTEwNDEzNTEzNjExNDI0MTQ=
      wiretap-http-client: true
    addr-eng-api:
      confm-key: devU01TX0FVVEgyMDIzMTEwNDE0NDUwODExNDI0MTU=
      wiretap-http-client: true
```

## Links

* [Spring Boot 3.0 Migration Guide](https://github.com/spring-projects/spring-boot/wiki/Spring-Boot-3.0-Migration-Guide) (
  github.com/spring-projects/spring-boot)
* [Spring Boot Test 3 NoClassDefFoundError: jakarta/servlet/ServletConnection](https://github.com/spring-projects/spring-boot/issues/33661) (
  github.com/spring-projects/spring-boot)
