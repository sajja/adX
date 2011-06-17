package com.adx.core.domain;


public class DomainObject {
    protected String id;

    @Override
    public int hashCode() {
        return id != null ? id.hashCode():super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof DomainObject) {
            DomainObject dObj = (DomainObject) obj;
            return dObj.getId() != null && this.id != null && this.id.equals(dObj.getId());
        }
        return false;
    }

    public DomainObject() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
