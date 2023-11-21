package com.github.jinahya.juso.go.kr.streotype;

import jakarta.validation.Validator;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.Accessors;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

@ToString
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Slf4j
public abstract class _BaseService {

    // -----------------------------------------------------------------------------------------------------------------
    @Autowired
    @Accessors(fluent = true)
    @Getter(AccessLevel.PROTECTED)
    private Validator validator;
}
