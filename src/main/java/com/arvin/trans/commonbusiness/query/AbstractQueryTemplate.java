package com.arvin.trans.commonbusiness.query;

import com.arvin.trans.commonbusiness.TemplateItem;
import com.arvin.trans.service.TemplateService;
import com.arvin.trans.vo.query.self.BaseRequest;
import com.arvin.trans.vo.query.self.BaseResponse;
import lombok.Data;

import java.util.SortedMap;
import java.util.TreeMap;

@Data
public abstract class AbstractQueryTemplate {
    private SortedMap<Integer, TemplateService> sortedServices = new TreeMap<>();

    private TemplateItem foo = new TemplateItem(null,  false);

    private TemplateItem bar = new TemplateItem(null, false);

    public abstract Class<? extends BaseRequest> getRequestClass();

    public abstract Class<? extends BaseResponse> getResponseClass();


}
