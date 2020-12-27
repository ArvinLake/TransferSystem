package com.arvin.trans.controller;

import com.arvin.trans.commonbusiness.query.AbstractQueryTemplate;
import com.arvin.trans.service.query.self.BarService;
import com.arvin.trans.service.query.self.FooService;
import com.arvin.trans.vo.query.self.BaseRequest;
import com.arvin.trans.vo.query.self.BaseResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class QueryController {

    @Autowired
    FooService fooService;
    @Autowired
    BarService barService;

    @RequestMapping("query")
    public <T extends BaseRequest, R extends BaseResponse> R query(T request) {
        AbstractQueryTemplate template = null;//ApplicationContext.getBean(product.template);
        R response = (R) template.getResponseClass().cast(new BaseResponse());

        if (template.getFoo().isExec()) {
            fooService.exec(request, response);
        }
        if (template.getBar().isExec()) {
            barService.exec(request, response);
        }

        return response;
    }

}
