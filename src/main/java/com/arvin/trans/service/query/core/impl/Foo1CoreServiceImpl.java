package com.arvin.trans.service.query.core.impl;

import com.arvin.trans.service.query.core.FooCoreService;
import com.arvin.trans.vo.query.core.foo.BaseFooCoreRequest;
import com.arvin.trans.vo.query.core.foo.BaseFooCoreResponse;
import com.arvin.trans.vo.query.self.BaseRequest;
import com.arvin.trans.vo.query.self.BaseResponse;
import com.arvin.trans.vo.query.self.Query1Request;
import org.springframework.stereotype.Service;

@Service("foo1CoreService")
public class Foo1CoreServiceImpl implements FooCoreService {

    @Override
    public <T extends BaseRequest, R extends BaseResponse> void exec(T request, R response) {
        Query1Request origRequest = (Query1Request) request;
    }

    @Override
    public BaseFooCoreResponse coreFoo(BaseFooCoreRequest request) {
        return null;
    }
}
