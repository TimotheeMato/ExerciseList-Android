package com.mato.timothee.fizzuptechnicaltest.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by timotheemato on 10/28/17.
 */

public class Exercise {

    @Expose
    private Integer id;
    @Expose
    private String name;
    @Expose
    @SerializedName("image_url")
    private String imageUrl;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}
