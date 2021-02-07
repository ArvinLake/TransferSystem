package com.arvin.trans.vo.query.core.foo;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class Foo1CoreRequest extends BaseFooCoreRequest {
    private String coreFooReqField;
}
