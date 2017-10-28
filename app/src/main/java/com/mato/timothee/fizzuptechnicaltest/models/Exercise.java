package com.mato.timothee.fizzuptechnicaltest.models;

import com.google.gson.annotations.Expose;

/**
 * Created by timotheemato on 10/28/17.
 */

public class Exercise {

    @Expose
    private Integer id;
    @Expose
    private String name;
    @Expose
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
