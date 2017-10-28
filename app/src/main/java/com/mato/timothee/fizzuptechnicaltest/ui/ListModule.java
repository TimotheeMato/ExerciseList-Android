package com.mato.timothee.fizzuptechnicaltest.ui;

import com.mato.timothee.fizzuptechnicaltest.di.ActivityScoped;

import dagger.Binds;
import dagger.Module;
import dagger.android.ContributesAndroidInjector;

/**
 * Created by timotheemato on 10/28/17.
 */

@ActivityScoped
@Module
public abstract class ListModule {

    @ContributesAndroidInjector
    abstract ListFragment tasksFragment();

    @Binds
    abstract ListContract.Presenter taskPresenter(ListPresenter presenter);

}
