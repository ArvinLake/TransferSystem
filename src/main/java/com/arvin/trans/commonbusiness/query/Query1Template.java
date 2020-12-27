package com.arvin.trans.commonbusiness.query;

import com.arvin.trans.commonbusiness.TemplateItem;
import com.arvin.trans.service.query.core.BarCoreService;
import com.arvin.trans.service.query.core.FooCoreService;
import com.arvin.trans.service.query.core.impl.Bar1CoreServiceImpl;
import com.arvin.trans.service.query.core.impl.Foo1CoreServiceImpl;
import com.arvin.trans.service.query.core.impl.Foo2CoreServiceImpl;
import com.arvin.trans.vo.query.self.BaseRequest;
import com.arvin.trans.vo.query.self.BaseResponse;
import com.arvin.trans.vo.query.self.Query1Request;
import com.arvin.trans.vo.query.self.Query1Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class Query1Template extends AbstractQueryTemplate {

    @Autowired
    @Qualifier("foo1CoreService")
    FooCoreService fooCoreService;
    @Autowired
    @Qualifier("bar1CoreService")
    BarCoreService barCoreService;

    @Override
    public TemplateItem getFoo() {
        return new TemplateItem(fooCoreService, true);
    }

    @Override
    public TemplateItem getBar() {
        return new TemplateItem(barCoreService, true);
    }

    @Override
    public Class<? extends BaseRequest> getRequestClass() {
        return Query1Request.class;
    }

    @Override
    public Class<? extends BaseResponse> getResponseClass() {
        return Query1Response.class;
    }
}
