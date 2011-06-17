package com.adx.core.domain;

/**
 * Created by IntelliJ IDEA.
 * User: sajith
 * Date: 15/6/11
 * Time: 10:35 AM
 * To change this template use File | Settings | File Templates.
 */
public class Keyword {
    public enum MatchTypes {EXACT,BROAD,PHRASE}
    private String keyword;
    private MatchTypes matchType;

    public Keyword(String keyword, MatchTypes matchType) {
        this.keyword = keyword;
        this.matchType = matchType;
    }
}
