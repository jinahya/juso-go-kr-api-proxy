package com.github.jinahya.juso.go.kr.web.bind.addrlink.type;

import com.github.jinahya.juso.go.kr.Results;
import com.github.jinahya.juso.go.kr.web.bind.type._BaseType;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.io.Serial;
import java.util.List;

@Setter
@Getter
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@NoArgsConstructor
public class AddrLinkApiResponse
        extends _BaseType {

    @Serial
    private static final long serialVersionUID = -3105641034884770051L;

    // -----------------------------------------------------------------------------------------------------------------

    // -----------------------------------------------------------------------------------------------------------------

    // -----------------------------------------------------------------------------------------------------------------
    @Valid
    @NotNull
    private Results results;

    private List<@Valid @NotNull Juso> juso;
}
