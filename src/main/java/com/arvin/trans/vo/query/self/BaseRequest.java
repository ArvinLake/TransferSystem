package com.arvin.trans.vo.query.self;

import com.arvin.trans.commonbusiness.query.QueryProduct;
import lombok.Data;

import java.util.HashMap;
import java.util.Map;

@Data
public class BaseRequest {
    private Map<String, Object> context = new HashMap<>(16);

    private QueryProduct queryProduct;

    private String baseReqFiled;
}
