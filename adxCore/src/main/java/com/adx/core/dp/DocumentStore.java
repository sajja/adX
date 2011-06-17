package com.adx.core.dp;

import com.adx.core.domain.DomainObject;

import java.util.Date;

/**
 * Created by IntelliJ IDEA.
 * User: sajith
 * Date: 15/6/11
 * Time: 10:05 AM
 * To change this template use File | Settings | File Templates.
 */
public interface DocumentStore {
    public void store(DomainObject obj);
    public void store(DomainObject[] obj);
    public int getStoreSize();
    public DomainObject getDocument(String id);
    public DomainObject[] getChangedDocuments(Date date);

}
