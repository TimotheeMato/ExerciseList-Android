package com.mato.timothee.fizzuptechnicaltest.ui;

import com.mato.timothee.fizzuptechnicaltest.di.ActivityScoped;

import javax.inject.Inject;

import dagger.android.support.DaggerFragment;

/**
 * Created by timotheemato on 10/28/17.
 */

@ActivityScoped
public class ListFragment extends DaggerFragment implements ListContract.View {

    @Inject
    public ListFragment() {
        // Requires empty public constructor
    }
}
