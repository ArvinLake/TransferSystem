package com.arvin.trans.vo.query.core.bar;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class Bar1CoreRequest extends BaseBarCoreRequest {
    private String coreBarReqField;
}
