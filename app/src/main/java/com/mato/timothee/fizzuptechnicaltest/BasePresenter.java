package com.mato.timothee.fizzuptechnicaltest;

/**
 * Created by timotheemato on 10/28/17.
 */

public interface BasePresenter<T> {

    void takeView(T view);

    void dropView();
}
