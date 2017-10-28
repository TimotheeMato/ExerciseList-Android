package com.mato.timothee.fizzuptechnicaltest.di;

import android.app.Application;
import android.content.Context;

import javax.inject.Singleton;

import dagger.Binds;
import dagger.Module;

/**
 * Created by timotheemato on 10/28/17.
 */

@Module
public abstract class AppModule {

    @Singleton
    @Binds
    abstract Context bindContext(Application application);
}

