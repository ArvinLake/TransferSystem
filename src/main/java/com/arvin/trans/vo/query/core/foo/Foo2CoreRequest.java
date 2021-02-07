package com.arvin.trans.vo.query.core.foo;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class Foo2CoreRequest extends BaseFooCoreRequest {
    private String coreFooReqField;
}
