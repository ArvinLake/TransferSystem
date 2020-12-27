package com.arvin.trans.service.query.core;

import com.arvin.trans.service.CoreService;
import com.arvin.trans.vo.query.core.foo.BaseFooCoreRequest;
import com.arvin.trans.vo.query.core.foo.BaseFooCoreResponse;

public interface FooCoreService extends CoreService {

    BaseFooCoreResponse coreFoo(BaseFooCoreRequest request);
}
