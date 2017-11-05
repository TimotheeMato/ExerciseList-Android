package com.mato.timothee.fizzuptechnicaltest.network;

import android.content.Context;

import com.mato.timothee.fizzuptechnicaltest.db.ExerciseDataSource;

import javax.inject.Singleton;

import dagger.Binds;
import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by timotheemato on 10/28/17.
 */

@Module
public class DataModule {

    private String baseUrl;

    public DataModule(String baseUrl) {
        this.baseUrl = baseUrl;
    }

    @Singleton
    @Provides
    Retrofit provideRetrofit() {
        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
        logging.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
        httpClient.addInterceptor(logging);

        return new Retrofit.Builder()
                .baseUrl(this.baseUrl)
                .client(httpClient.build())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    @Singleton
    @Provides
    DataService provideDataService(Retrofit retrofit) {
        return retrofit.create(DataService.class);
    }

    @Singleton
    @Provides
    ExerciseDataSource provideExerciseDataSource(Context context) {
        return new ExerciseDataSource(context);
    }
}
