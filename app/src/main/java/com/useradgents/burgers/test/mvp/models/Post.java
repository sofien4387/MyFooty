package com.useradgents.burgers.test.mvp.models;

import com.google.gson.annotations.SerializedName;

import java.util.Date;

/**
 * Created by Sofien on 15/08/2017.
 */

public class Post {

    @SerializedName("uuid")
    public String uuid;
    @SerializedName("author")
    public String author;
    @SerializedName("published")
    public Date published;
    @SerializedName("title")
    public String title;
    @SerializedName("text")
    public String text;
    @SerializedName("thread")
    public Thread thread;

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Date getPublished() {
        return published;
    }

    public void setPublished(Date published) {
        this.published = published;
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

    public Thread getThread() {
        return thread;
    }

    public void setThread(Thread thread) {
        this.thread = thread;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }
}
