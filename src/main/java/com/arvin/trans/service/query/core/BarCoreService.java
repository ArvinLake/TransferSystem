package com.arvin.trans.service.query.core;

import com.arvin.trans.service.CoreService;
import com.arvin.trans.vo.query.core.bar.BaseBarCoreRequest;
import com.arvin.trans.vo.query.core.bar.BaseBarCoreResponse;

public interface BarCoreService extends CoreService {

    BaseBarCoreResponse coreBar(BaseBarCoreRequest request);
}
