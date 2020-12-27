package com.arvin.trans.service.query.self.impl;

import com.arvin.trans.service.query.core.BarCoreService;
import com.arvin.trans.service.query.self.BarService;
import com.arvin.trans.vo.query.self.BaseRequest;
import com.arvin.trans.vo.query.self.BaseResponse;
import org.springframework.stereotype.Service;

@Service
public class BarServiceImpl implements BarService {

    @Override
    public <T extends BaseRequest, R extends BaseResponse> void exec(T request, R response) {
        BarCoreService barCoreService = null;//TODO
        barCoreService.exec(request, response);
    }
}
