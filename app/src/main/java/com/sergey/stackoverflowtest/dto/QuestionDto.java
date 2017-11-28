package com.sergey.stackoverflowtest.dto;

import com.sergey.stackoverflowtest.stackapi.pojo.Question;

/**
 * Created by smilevkiy on 28.11.17.
 */

public class QuestionDto {


    private String title;
    private int answerCount;
    private boolean isAnswered;
    private String link;
    private String displayName;
    private String profileImage;

    public QuestionDto(Question question) {
        title = question.getTitle();
        answerCount = question.getAnswerCount();
        isAnswered = question.isAnswered();
        link = question.getLink();
        displayName = question.getOwner() != null ? question.getOwner().getDisplayName() : "";
        profileImage = question.getOwner() != null ? question.getOwner().getProfileImage() : "";
    }


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

    public String getDisplayName() {
        return displayName;
    }

    public String getProfileImage() {
        return profileImage;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof QuestionDto)) return false;

        QuestionDto that = (QuestionDto) o;

        if (getAnswerCount() != that.getAnswerCount()) return false;
        if (isAnswered() != that.isAnswered()) return false;
        if (getTitle() != null ? !getTitle().equals(that.getTitle()) : that.getTitle() != null)
            return false;
        if (getLink() != null ? !getLink().equals(that.getLink()) : that.getLink() != null)
            return false;
        if (getDisplayName() != null ? !getDisplayName().equals(that.getDisplayName()) : that.getDisplayName() != null)
            return false;
        return getProfileImage() != null ? getProfileImage().equals(that.getProfileImage()) : that.getProfileImage() == null;
    }

    @Override
    public int hashCode() {
        int result = getTitle() != null ? getTitle().hashCode() : 0;
        result = 31 * result + getAnswerCount();
        result = 31 * result + (isAnswered() ? 1 : 0);
        result = 31 * result + (getLink() != null ? getLink().hashCode() : 0);
        result = 31 * result + (getDisplayName() != null ? getDisplayName().hashCode() : 0);
        result = 31 * result + (getProfileImage() != null ? getProfileImage().hashCode() : 0);
        return result;
    }
}
