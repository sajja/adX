package com.adx.core.index;

/**
 * Created by IntelliJ IDEA.
 * User: sajith
 * Date: 15/6/11
 * Time: 8:53 PM
 * To change this template use File | Settings | File Templates.
 */
public interface IndexBuilder {
    public int buildIndex();
    public void addDocument();
    public void removeDocument();
    public void purge();
}
