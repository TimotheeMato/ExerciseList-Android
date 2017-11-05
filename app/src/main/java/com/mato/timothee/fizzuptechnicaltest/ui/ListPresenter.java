package com.mato.timothee.fizzuptechnicaltest.ui;

import android.util.Log;

import com.mato.timothee.fizzuptechnicaltest.db.ExerciseDataSource;
import com.mato.timothee.fizzuptechnicaltest.di.ActivityScoped;
import com.mato.timothee.fizzuptechnicaltest.models.Exercise;
import com.mato.timothee.fizzuptechnicaltest.network.DataResponse;
import com.mato.timothee.fizzuptechnicaltest.network.DataService;

import java.util.List;

import javax.inject.Inject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by timotheemato on 10/28/17.
 */

@ActivityScoped
public class ListPresenter implements ListContract.Presenter {

    private DataService dataService;
    private ExerciseDataSource exerciseDataSource;
    private ListContract.View view;

    @Inject
    public ListPresenter(DataService dataService, ExerciseDataSource exerciseDataSource) {
        this.dataService = dataService;
        this.exerciseDataSource = exerciseDataSource;
    }

    @Override
    public void fetchData() {
        exerciseDataSource.open();
        List<Exercise> exerciseList = exerciseDataSource.getAllExercises();
        if (!exerciseList.isEmpty()) {
            view.showContent(exerciseList);
            exerciseDataSource.close();
        } else {
            dataService.getExercises().enqueue(
                    new Callback<DataResponse<List<Exercise>>>() {
                        @Override
                        public void onResponse(Call<DataResponse<List<Exercise>>> call, Response<DataResponse<List<Exercise>>> response) {
                            if (response.isSuccessful() && response.body() != null) {
                                List<Exercise> newExerciseList = response.body().getData();
                                view.showContent(newExerciseList);
                                for (Exercise exercise : newExerciseList) {
                                    exerciseDataSource.storeExercise(exercise);
                                }
                                exerciseDataSource.close();
                            } else {
                                view.showError(new Throwable());
                            }
                        }

                        @Override
                        public void onFailure(Call<DataResponse<List<Exercise>>> call, Throwable throwable) {
                            view.showError(throwable);
                        }
                    }
            );
        }
    }

    @Override
    public void takeView(ListContract.View view) {
        this.view = view;
    }

    @Override
    public void dropView() {
        this.view = null;
    }
}
