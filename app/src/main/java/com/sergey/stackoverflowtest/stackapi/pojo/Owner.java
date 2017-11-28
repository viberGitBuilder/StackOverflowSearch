package com.sergey.stackoverflowtest.stackapi.pojo;

import com.google.gson.annotations.SerializedName;

/**
 * Created by sergey on 27.11.17.
 */

public class Owner {

    @SerializedName("display_name")
    String displayName;
    @SerializedName("profile_image")
    String profileImage;


    public String getDisplayName() {
        return displayName;
    }

    public String getProfileImage() {
        return profileImage;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Owner)) return false;

        Owner owner = (Owner) o;

        if (getDisplayName() != null ? !getDisplayName().equals(owner.getDisplayName()) : owner.getDisplayName() != null)
            return false;
        return getProfileImage() != null ? getProfileImage().equals(owner.getProfileImage()) : owner.getProfileImage() == null;
    }

    @Override
    public int hashCode() {
        int result = getDisplayName() != null ? getDisplayName().hashCode() : 0;
        result = 31 * result + (getProfileImage() != null ? getProfileImage().hashCode() : 0);
        return result;
    }
}
