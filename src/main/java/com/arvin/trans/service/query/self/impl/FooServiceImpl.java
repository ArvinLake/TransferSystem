package com.arvin.trans.service.query.self.impl;

import com.arvin.trans.service.query.core.FooCoreService;
import com.arvin.trans.service.query.self.FooService;
import com.arvin.trans.vo.query.self.BaseRequest;
import com.arvin.trans.vo.query.self.BaseResponse;
import org.springframework.stereotype.Service;

@Service
public class FooServiceImpl implements FooService {

    @Override
    public <T extends BaseRequest, R extends BaseResponse> void exec(T request, R response) {
        FooCoreService fooCoreService = null;//ApplicationContextutil.getBean();
        fooCoreService.exec(request, response);
    }
}
