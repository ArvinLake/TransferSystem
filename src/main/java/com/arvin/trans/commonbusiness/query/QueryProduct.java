package com.arvin.trans.commonbusiness.query;

public enum QueryProduct {
    QUERY_1(Query1Template.class),
    QUERY_2(Query2Template.class);

    public final Class<? extends AbstractQueryTemplate> template;

    QueryProduct(Class<? extends AbstractQueryTemplate> template) {
        this.template = template;
    }
}
