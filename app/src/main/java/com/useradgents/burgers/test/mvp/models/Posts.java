package com.useradgents.burgers.test.mvp.models;

import com.google.gson.annotations.SerializedName;

import java.util.Arrays;
import java.util.List;

/**
 * Created by Sofien on 15/08/2017.
 */

public class Posts {

    @SerializedName("posts")
    public Post post[];

    public List<Post> getPost() {
        return Arrays.asList(post);
    }

}
