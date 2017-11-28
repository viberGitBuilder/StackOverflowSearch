package com.sergey.stackoverflowtest.stackapi.pojo;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by sergey on 27.11.17.
 */

public class StackResponse<T> {

    @SerializedName("items")
    private List<T> items;
    @SerializedName("has_more")
    private boolean hasMore;
    @SerializedName("page")
    private int page;
    @SerializedName("total")
    private int total;


    public List<T> getItems() {
        return items;
    }

    public boolean isHasMore() {
        return hasMore;
    }

    public int getPage() {
        return page;
    }

    public int getTotal() {
        return total;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof StackResponse)) return false;

        StackResponse<?> that = (StackResponse<?>) o;

        if (isHasMore() != that.isHasMore()) return false;
        if (getPage() != that.getPage()) return false;
        if (getTotal() != that.getTotal()) return false;
        return getItems() != null ? getItems().equals(that.getItems()) : that.getItems() == null;
    }

    @Override
    public int hashCode() {
        int result = getItems() != null ? getItems().hashCode() : 0;
        result = 31 * result + (isHasMore() ? 1 : 0);
        result = 31 * result + getPage();
        result = 31 * result + getTotal();
        return result;
    }
}
