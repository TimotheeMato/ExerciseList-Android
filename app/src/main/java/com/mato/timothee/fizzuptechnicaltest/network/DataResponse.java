package com.mato.timothee.fizzuptechnicaltest.network;

import com.google.gson.annotations.Expose;

/**
 * Created by timotheemato on 10/28/17.
 */

public class DataResponse<T> {

    @Expose
    private T data;

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
