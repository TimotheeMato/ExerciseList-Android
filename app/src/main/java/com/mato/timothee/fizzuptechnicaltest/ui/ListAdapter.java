package com.mato.timothee.fizzuptechnicaltest.ui;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.mato.timothee.fizzuptechnicaltest.R;
import com.mato.timothee.fizzuptechnicaltest.models.Exercise;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by timotheemato on 11/5/17.
 */

public class ListAdapter extends RecyclerView.Adapter<ListAdapter.ViewHolder> {

    private List<Exercise> exerciseList;
    private Context context;

    public static class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.thumb)
        ImageView thumb;
        @BindView(R.id.name)
        TextView name;

        public ViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }

    public ListAdapter(Context context, List<Exercise> exerciseList) {
        this.exerciseList = exerciseList;
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.row_exercise, viewGroup, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, final int position) {
        Exercise exercise = exerciseList.get(position);
        viewHolder.name.setText(exercise.getName());
        Glide.with(context)
                .load(exercise.getImageUrl())
                .into(viewHolder.thumb);
    }

    @Override
    public int getItemCount() {
        return exerciseList.size();
    }

    public void setExerciseList(List<Exercise> exerciseList) {
        this.exerciseList = exerciseList;
        this.notifyDataSetChanged();
    }
}
