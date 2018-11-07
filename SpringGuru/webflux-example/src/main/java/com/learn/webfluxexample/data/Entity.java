package com.learn.webfluxexample.data;

import com.couchbase.client.java.repository.annotation.Field;

import java.util.Date;

public class Entity {
    @Field
    private String id;
    private String created;
    private String updated;
    private long cas;

    @SuppressWarnings("WeakerAccess")
    protected Entity() {
        created = updated = new Date().toString();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getType() {
        return getClass().getName();
    }

    public String getCreated() {
        return created;
    }

    public String getUpdated() {
        return updated;
    }

    public void setUpdated(String updated) {
        this.updated = updated;
    }

    public long getCas() {
        return cas;
    }

    public void setCas(long cas) {
        this.cas = cas;
    }

    public String getKey() {
        return getType() + "::" + getId();
    }
}
