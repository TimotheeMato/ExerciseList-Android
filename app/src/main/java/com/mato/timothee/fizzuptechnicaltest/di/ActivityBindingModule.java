package com.mato.timothee.fizzuptechnicaltest.di;

import com.mato.timothee.fizzuptechnicaltest.ui.ListActivity;
import com.mato.timothee.fizzuptechnicaltest.ui.ListModule;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

/**
 * Created by timotheemato on 10/28/17.
 */

@Module
public abstract class ActivityBindingModule {

    @ActivityScoped
    @ContributesAndroidInjector(modules = ListModule.class)
    abstract ListActivity listActivity();
}
