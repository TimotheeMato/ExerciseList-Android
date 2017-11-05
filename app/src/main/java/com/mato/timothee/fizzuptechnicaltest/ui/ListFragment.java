package com.mato.timothee.fizzuptechnicaltest.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import com.mato.timothee.fizzuptechnicaltest.R;
import com.mato.timothee.fizzuptechnicaltest.di.ActivityScoped;
import com.mato.timothee.fizzuptechnicaltest.models.Exercise;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import dagger.android.support.DaggerFragment;

/**
 * Created by timotheemato on 10/28/17.
 */

@ActivityScoped
public class ListFragment extends DaggerFragment implements ListContract.View {

    private final static String TAG = ListFragment.class.getName();

    @Inject
    ListContract.Presenter presenter;

    Unbinder unbinder;
    @BindView(R.id.recycler_view)
    RecyclerView recyclerView;
    @BindView(R.id.progress_bar)
    ProgressBar progressBar;

    private ListAdapter adapter;

    @Inject
    public ListFragment() {
        // Requires empty public constructor
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        adapter = new ListAdapter(getContext(), new ArrayList<>(0));
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        showLoading(true);
        presenter.takeView(this);
        presenter.fetchData();
    }

    @Override
    public void onResume() {
        super.onResume();
        presenter.takeView(this);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        presenter.dropView();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_list, container, false);
        unbinder = ButterKnife.bind(this, root);
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    public void showLoading(boolean loading) {
        progressBar.setVisibility(loading ? View.VISIBLE : View.GONE);
        recyclerView.setVisibility(loading ? View.GONE : View.VISIBLE);
    }

    @Override
    public void showContent(List<Exercise> exerciseList) {
        showLoading(false);
        adapter.setExerciseList(exerciseList);
    }

    @Override
    public void showError(Throwable throwable) {
        showLoading(false);
        Log.d(TAG, "Error while fetching", throwable);
        Snackbar.make(getView(), "Error while fetching", Snackbar.LENGTH_LONG).show();
    }

}
