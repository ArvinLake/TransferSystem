package com.arvin.trans.vo.query.core.bar;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class Bar1CoreResponse extends BaseBarCoreResponse {
    private String coreBarRspField;
}
