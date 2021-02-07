package com.arvin.trans.vo.query.core.bar;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class Bar2CoreRequest extends BaseBarCoreRequest {
    private String coreBarReqField;
}
