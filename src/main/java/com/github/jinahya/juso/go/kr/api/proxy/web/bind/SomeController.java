package com.github.jinahya.juso.go.kr.api.proxy.web.bind;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = {"/some"})
public class SomeController {

    @GetMapping
    String read() {
        return "hello";
    }
}
