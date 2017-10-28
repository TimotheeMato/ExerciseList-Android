package com.mato.timothee.fizzuptechnicaltest.ui;

import com.mato.timothee.fizzuptechnicaltest.di.ActivityScoped;

import javax.inject.Inject;

/**
 * Created by timotheemato on 10/28/17.
 */

@ActivityScoped
public class ListPresenter implements ListContract.Presenter {

    @Inject
    public ListPresenter() {
        // Requires empty public constructor
    }

    @Override
    public void takeView(ListContract.View view) {

    }

    @Override
    public void dropView() {

    }
}
