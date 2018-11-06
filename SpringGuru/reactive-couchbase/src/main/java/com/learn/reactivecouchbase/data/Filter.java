package com.learn.reactivecouchbase.data;


/**
 * Filter as it wil be saved in database.
 */
public class Filter {

    /**
     * Occurring number
     */
    private int count;
    /**
     * filter phrase
     */
    private String filter;
    /**
     * filter phrase category
     */
    private String category;

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public String getFilter() {
        return filter;
    }

    public void setFilter(String filter) {
        this.filter = filter;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = fixCategory(category);
    }

    private String fixCategory(String category) {
        if(category.startsWith("shopkat")) {
            category = category.replace("shopkat", "hierarchicalFacetCriteria_");
        }

        return category;
    }
}
