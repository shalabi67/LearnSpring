package com.learn.webfluxexample.data;


import com.couchbase.client.java.repository.annotation.Field;

import java.util.ArrayList;
import java.util.List;

/**
 * id in entity is the searchPhrase
 */
public class CompetenceFilter extends Entity {
    public static String getId(String shopName, String searchPhrase) {
        return shopName + "::" + searchPhrase;
    }

    @Field
    private String shop;
    @Field
    private List<Filter> filters = new ArrayList<>();

    public String getId() {
        return CompetenceFilter.getId(shop, super.getId());
    }

    public String getShop() {
        return shop;
    }

    public void setShop(String shop) {
        this.shop = shop;
    }

    public List<Filter> getFilters() {
        return filters;
    }

    public void setFilters(List<Filter> filters) {
        this.filters = filters;
    }

    public void addFilter(Filter filter) {
        this.filters.add(filter);
    }

    public String getSearchPhrase() {
        return super.getId();
    }

    public void setSearchPhrase(String searchPhrase) {
        super.setId(searchPhrase);
    }
}
