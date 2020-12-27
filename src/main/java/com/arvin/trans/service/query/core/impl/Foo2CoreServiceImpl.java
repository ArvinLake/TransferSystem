package com.arvin.trans.service.query.core.impl;

import com.arvin.trans.service.query.core.FooCoreService;
import com.arvin.trans.vo.query.core.foo.BaseFooCoreRequest;
import com.arvin.trans.vo.query.core.foo.BaseFooCoreResponse;
import com.arvin.trans.vo.query.self.BaseRequest;
import com.arvin.trans.vo.query.self.BaseResponse;
import com.arvin.trans.vo.query.self.Query2Request;
import org.springframework.stereotype.Service;

@Service("foo2CoreService")
public class Foo2CoreServiceImpl implements FooCoreService {

    @Override
    public <T extends BaseRequest, R extends BaseResponse> void exec(T request, R response) {
        Query2Request origRequest = (Query2Request) request;
    }

    @Override
    public BaseFooCoreResponse coreFoo(BaseFooCoreRequest request) {
        return null;
    }
}
