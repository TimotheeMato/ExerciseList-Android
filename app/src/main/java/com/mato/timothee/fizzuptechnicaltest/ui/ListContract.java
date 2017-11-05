package com.mato.timothee.fizzuptechnicaltest.ui;

import com.mato.timothee.fizzuptechnicaltest.BasePresenter;
import com.mato.timothee.fizzuptechnicaltest.BaseView;
import com.mato.timothee.fizzuptechnicaltest.models.Exercise;

import java.util.List;

/**
 * Created by timotheemato on 10/28/17.
 */

public interface ListContract {

    interface View extends BaseView<Presenter> {

        void showContent(List<Exercise> exerciseList);

        void showError(Throwable throwable);
    }

    interface Presenter extends BasePresenter<View> {

        void fetchData();

        void takeView(ListContract.View view);

        void dropView();
    }
}
