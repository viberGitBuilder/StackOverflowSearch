package com.sergey.stackoverflowtest.stackapi.pojo;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by sergey on 27.11.17.
 */

public class StackResponse<T> {

    @SerializedName("items")
    List<T> items;
    @SerializedName("has_more")
    boolean hasMore;
    @SerializedName("page")
    private int page;
    @SerializedName("total")
    private int total;
}
