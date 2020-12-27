package com.arvin.trans.commonbusiness.query;

import com.arvin.trans.commonbusiness.TemplateItem;
import com.arvin.trans.service.query.core.BarCoreService;
import com.arvin.trans.vo.query.self.BaseRequest;
import com.arvin.trans.vo.query.self.BaseResponse;
import com.arvin.trans.vo.query.self.Query2Request;
import com.arvin.trans.vo.query.self.Query2Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class Query2Template extends AbstractQueryTemplate {

    @Autowired
    @Qualifier("bar2CoreService")
    BarCoreService barCoreService;

    @Override
    public TemplateItem getBar() {
        return new TemplateItem(barCoreService, true);
    }

    @Override
    public Class<? extends BaseRequest> getRequestClass() {
        return Query2Request.class;
    }

    @Override
    public Class<? extends BaseResponse> getResponseClass() {
        return Query2Response.class;
    }
}
