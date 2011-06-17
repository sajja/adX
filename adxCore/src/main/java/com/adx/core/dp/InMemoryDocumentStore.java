package com.adx.core.dp;

import com.adx.core.domain.DomainObject;

import java.util.Date;
import java.util.Hashtable;

public class InMemoryDocumentStore implements DocumentStore {
    public static Hashtable <String,DomainObject> store =
            new Hashtable<String, DomainObject>(100);

    public synchronized void store(DomainObject obj) {
        if (obj != null) {
            store.put(obj.getId(),obj);
        } else {
            System.out.println("Document is null");
        }
    }

    public void store(DomainObject[] obj) {
        for (int i = 0; i < obj.length; i++) {
            DomainObject domainObject = obj[i];
            store(domainObject);
        }
    }

    public int getStoreSize() {
        return store.size();
    }

    public DomainObject getDocument(String id) {
        return store.get(id);
    }

    public DomainObject[] getChangedDocuments(Date date) {
        return store.values().toArray(new DomainObject[]{});
    }
}
