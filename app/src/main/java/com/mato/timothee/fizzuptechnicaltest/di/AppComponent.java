package com.mato.timothee.fizzuptechnicaltest.di;

import android.app.Application;

import com.mato.timothee.fizzuptechnicaltest.FizzUpApplication;
import com.mato.timothee.fizzuptechnicaltest.network.NetworkModule;

import javax.inject.Singleton;

import dagger.BindsInstance;
import dagger.Component;
import dagger.android.AndroidInjector;
import dagger.android.DaggerApplication;
import dagger.android.support.AndroidSupportInjectionModule;

/**
 * Created by timotheemato on 10/28/17.
 */

@Singleton
@Component(modules = {
        AppModule.class,
        NetworkModule.class,
        ActivityBindingModule.class,
        AndroidSupportInjectionModule.class
})
public interface AppComponent extends AndroidInjector<DaggerApplication> {

    void inject(FizzUpApplication application);

    @Override
    void inject(DaggerApplication instance);

    @Component.Builder
    interface Builder {

        @BindsInstance
        AppComponent.Builder application(Application application);

        AppComponent.Builder networkModule(NetworkModule networkModule);

        AppComponent build();
    }
}
