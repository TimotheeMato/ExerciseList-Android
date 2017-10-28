package com.mato.timothee.fizzuptechnicaltest.network;

import javax.inject.Singleton;

import dagger.Binds;
import dagger.Module;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by timotheemato on 10/28/17.
 */

@Module
public abstract class NetworkModule {

    private String baseUrl;

    public NetworkModule(String baseUrl) {
        this.baseUrl = baseUrl;
    }

    @Singleton
    @Binds
    Retrofit provideRetrofit() {
        return new Retrofit.Builder()
                .baseUrl("https://example.com/")
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    @Singleton
    @Binds
    DataService provideDataService(Retrofit retrofit) {
        return retrofit.create(DataService.class);
    }
}
