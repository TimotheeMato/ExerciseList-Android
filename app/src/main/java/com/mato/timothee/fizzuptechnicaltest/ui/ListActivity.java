package com.mato.timothee.fizzuptechnicaltest.ui;

import android.os.Bundle;

import com.mato.timothee.fizzuptechnicaltest.R;

import javax.inject.Inject;

import dagger.Lazy;
import dagger.android.support.DaggerAppCompatActivity;

public class ListActivity extends DaggerAppCompatActivity {

    private static final String TAG_LIST_FRAGMENT = "ListFragment";

    @Inject
    ListPresenter listPresenter;
    @Inject
    Lazy<ListFragment> listFragmentProvider;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        ListFragment listFragment =
                (ListFragment) getSupportFragmentManager().findFragmentById(R.id.content_frame);
        if (listFragment == null) {
            listFragment = listFragmentProvider.get();
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.content_frame, listFragment, TAG_LIST_FRAGMENT)
                    .commit();
        }
    }
}
