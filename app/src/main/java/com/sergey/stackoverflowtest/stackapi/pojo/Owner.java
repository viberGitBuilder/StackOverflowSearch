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
}
