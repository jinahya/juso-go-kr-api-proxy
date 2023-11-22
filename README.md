# juso-go-kr-api-proxy

An application for proxying APIs from https://business.juso.go.kr.

## How to extend

### `@SpringBootApplication` class

Add your own `@SpringBootApplication` class with an additional component scanning
path. (`com.github.jinahya.juso.go.kr._NoOp.class` might help.)

```java
package whatever;

@SpringBootApplication(
        scanBasePackageClasses = {
                com.github.jinahya.juso.go.kr._NoOp.class
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

| name                                     | value | description      | notes |
|------------------------------------------|-------|------------------|-------|
| `jusoGoKr.addrlink.addrLinkApi.confmKey` |       | 검색 API key       |       |
| `jusoGoKr.addrlink.addrEngApi.confmKey`  |       | 영문 주소 검색 API key |       |

e.g.

```yaml
jusoGoKr:
  addrlink:
    addrLinkApi:
      confmKey: devU01TX0FVVEgyMDIzMTEwNDEzNTEzNjExNDI0MTQ=
      wiretapHttpClient: true
    addrEngApi:
      confmKey: devU01TX0FVVEgyMDIzMTEwNDE0NDUwODExNDI0MTU=
      wiretapHttpClient: true
```
