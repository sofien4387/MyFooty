package com.useradgents.burgers.test.mvp.models;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Sofien on 15/08/2017.
 */

public class Thread {

    @SerializedName("site_full")
    public String url;

    @SerializedName("main_image")
    public String iconUrl;

    @SerializedName("title")
    public String title;

    @SerializedName("text")
    public String text;

    public String getIconUrl() {
        return iconUrl;
    }

    public void setIconUrl(String iconUrl) {
        this.iconUrl = iconUrl;
    }


    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
