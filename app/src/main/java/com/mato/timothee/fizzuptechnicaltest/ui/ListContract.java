package com.mato.timothee.fizzuptechnicaltest.ui;

import com.mato.timothee.fizzuptechnicaltest.BasePresenter;
import com.mato.timothee.fizzuptechnicaltest.BaseView;

/**
 * Created by timotheemato on 10/28/17.
 */

public interface ListContract {

    interface View extends BaseView<Presenter> {

    }

    interface Presenter extends BasePresenter<View> {

        void takeView(ListContract.View view);

        void dropView();
    }
}
