package com.arvin.trans.vo.query.self;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class Query1Response extends BaseResponse {
    private String fooRspField;
}
