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

    public String getTitle() {
        return title;
    }

    public int getAnswerCount() {
        return answerCount;
    }

    public boolean isAnswered() {
        return isAnswered;
    }

    public String getLink() {
        return link;
    }

    public Owner getOwner() {
        return owner;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Question)) return false;

        Question question = (Question) o;

        if (getAnswerCount() != question.getAnswerCount()) return false;
        if (isAnswered() != question.isAnswered()) return false;
        if (getTitle() != null ? !getTitle().equals(question.getTitle()) : question.getTitle() != null)
            return false;
        if (getLink() != null ? !getLink().equals(question.getLink()) : question.getLink() != null)
            return false;
        return getOwner() != null ? getOwner().equals(question.getOwner()) : question.getOwner() == null;
    }

    @Override
    public int hashCode() {
        int result = getTitle() != null ? getTitle().hashCode() : 0;
        result = 31 * result + getAnswerCount();
        result = 31 * result + (isAnswered() ? 1 : 0);
        result = 31 * result + (getLink() != null ? getLink().hashCode() : 0);
        result = 31 * result + (getOwner() != null ? getOwner().hashCode() : 0);
        return result;
    }
}
