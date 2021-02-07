package com.arvin.trans.vo.query.self;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class Query2Request extends BaseRequest {
    private String barReqField;
}
