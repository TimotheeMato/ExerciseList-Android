package com.mato.timothee.fizzuptechnicaltest.network;

import com.mato.timothee.fizzuptechnicaltest.models.Exercise;

import java.util.List;

import io.reactivex.Single;
import retrofit2.http.GET;

/**
 * Created by timotheemato on 10/28/17.
 */

public interface DataService {

    @GET("/sample.json")
    Single<DataResponse<List<Exercise>>> getExercises();
}
