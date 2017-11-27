package com.sergey.stackoverflowtest.stackapi.pojo;

import com.google.gson.annotations.SerializedName;

/**
 * Created by sergey on 27.11.17.
 */

public class Question {

    @SerializedName("title")
    String title;
    @SerializedName("answer_count")
    int answerCount;
    @SerializedName("is_answered")
    boolean isAnswered;
    @SerializedName("link")
    String link;
    @SerializedName("owner")
    Owner owner;

}
