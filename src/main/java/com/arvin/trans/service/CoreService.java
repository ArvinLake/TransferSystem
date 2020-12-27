package com.arvin.trans.service;

import com.arvin.trans.vo.query.self.BaseRequest;
import com.arvin.trans.vo.query.self.BaseResponse;

public interface CoreService {
    <T extends BaseRequest, R extends BaseResponse> void exec(T request, R response);
}
