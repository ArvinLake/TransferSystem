package com.arvin.trans.service.query.core.impl;

import com.arvin.trans.service.query.core.BarCoreService;
import com.arvin.trans.vo.query.core.bar.BaseBarCoreRequest;
import com.arvin.trans.vo.query.core.bar.BaseBarCoreResponse;
import com.arvin.trans.vo.query.self.BaseRequest;
import com.arvin.trans.vo.query.self.BaseResponse;
import com.arvin.trans.vo.query.self.Query1Request;
import org.springframework.stereotype.Service;

@Service("bar1CoreService")
public class Bar1CoreServiceImpl implements BarCoreService {

    @Override
    public <T extends BaseRequest, R extends BaseResponse> void exec(T request, R response) {
        Query1Request origRequest = (Query1Request) request;
    }

    @Override
    public BaseBarCoreResponse coreBar(BaseBarCoreRequest request) {
        return null;
    }
}
