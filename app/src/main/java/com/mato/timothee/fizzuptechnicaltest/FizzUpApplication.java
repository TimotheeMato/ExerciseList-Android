package com.mato.timothee.fizzuptechnicaltest;

import android.content.Context;

import com.mato.timothee.fizzuptechnicaltest.di.AppComponent;
import com.mato.timothee.fizzuptechnicaltest.di.DaggerAppComponent;

import javax.inject.Inject;

import dagger.android.AndroidInjector;
import dagger.android.DaggerApplication;

/**
 * Created by timotheemato on 10/28/17.
 */

public class FizzUpApplication extends DaggerApplication {

    @Override
    protected AndroidInjector<? extends DaggerApplication> applicationInjector() {
        AppComponent appComponent = DaggerAppComponent.builder().application(this).build();
        appComponent.inject(this);
        return appComponent;
    }
}
