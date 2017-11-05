package com.mato.timothee.fizzuptechnicaltest.network;

import com.mato.timothee.fizzuptechnicaltest.models.Exercise;

import java.util.List;
import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by timotheemato on 10/28/17.
 */

public interface DataService {

    @GET("/fizzup/files/public/sample.json")
    Call<DataResponse<List<Exercise>>> getExercises();
}
