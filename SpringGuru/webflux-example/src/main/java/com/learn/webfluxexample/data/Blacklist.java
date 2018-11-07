package com.learn.webfluxexample.data;


import com.couchbase.client.java.repository.annotation.Field;
import org.springframework.data.couchbase.core.mapping.Document;

import java.util.LinkedHashSet;
import java.util.Set;

/**
 * id is blacklist::shopname
 */
@Document
public class Blacklist extends Entity {
    private static final String BLACKLIST = "blacklist";
    public static String getId(String shopName) {
        return BLACKLIST + "::" + shopName;
    }
    @Field
    private String shop;
    @Field
    private Set<String> blackList = new LinkedHashSet<>();

    public static Blacklist create(String shopName, Set<String> blackListSet) {
        Blacklist blacklist = new Blacklist();
        blacklist.setShop(shopName);
        blacklist.setBlackList(blackListSet);
        blacklist.setId(getId(shopName));

        return blacklist;
    }

    public String getId() {
        return Blacklist.getId(shop);
    }

    public String getShop() {
        return shop;
    }

    public void setShop(String shop) {
        this.shop = shop;
    }

    public Set<String> getBlackList() {
        return blackList;
    }

    public void setBlackList(Set<String> blackList) {
        this.blackList = blackList;
    }
    public void addBlackListItem(String blackListItem) {
        blackList.add(blackListItem);
    }
}
