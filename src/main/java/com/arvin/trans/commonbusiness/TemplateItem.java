package com.arvin.trans.commonbusiness;

import com.arvin.trans.service.CoreService;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class TemplateItem {
    private CoreService coreService;
    private boolean isExec;
}
