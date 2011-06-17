package com.adx.core.domain;

import java.util.ArrayList;
import java.util.List;

public class Ad extends DomainObject {
    protected String name;
    protected List<Keyword> keywords = new ArrayList<Keyword>();

    public Ad(String name) {
        this.name = name;
    }

    public void addKeyword(Keyword keyword) {
        keywords.add(keyword);
    }

    public List getKeywords() {
        return keywords;
    }

    public String getName() {
        return name;
    }
}
