package com.folen.androidshowreel.model;

import com.google.gson.annotations.SerializedName;

public class Feature {

    @SerializedName("id")
    private Integer id;
    @SerializedName("name")
    private String name;
    @SerializedName("description")
    private String description;
    @SerializedName("img")
    private String imageUrl;
    @SerializedName("isdone")
    private boolean isDone;

    public Feature(Integer id, String name, String description, String imageUrl, boolean isDone) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.imageUrl = imageUrl;
        this.isDone = isDone;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public boolean isDone() { return isDone; }
}
