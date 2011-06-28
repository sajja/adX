package com.adx.core.index;

import com.adx.core.domain.DomainObject;
import com.adx.core.dp.DocumentStore;

import java.util.Date;

/**
 * Created by IntelliJ IDEA.
 * User: sajith
 * Date: 15/6/11
 * Time: 8:53 PM
 * To change this template use File | Settings | File Templates.
 */
public class DefaultIndexBuilder implements IndexBuilder {
    private DocumentStore documentStore;

    public int buildIndex() {
        DomainObject[] documentsToIndex = documentStore.getChangedDocuments(new Date());
        System.out.println("found " + documentsToIndex.length + " to index");
        return 0;  //To change body of implemented methods use File | Settings | File Templates.
    }

    public void addDocument() {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    public void removeDocument() {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    public void purge() {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    public void search() {
        //To change body of implemented methods use File | Settings | File Templates.
    }
}
