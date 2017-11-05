package com.mato.timothee.fizzuptechnicaltest.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.mato.timothee.fizzuptechnicaltest.models.Exercise;
import com.mato.timothee.fizzuptechnicaltest.db.ExercisesReaderContract.ExerciseEntry;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by timotheemato on 11/5/17.
 */

public class ExerciseDataSource {

    private SQLiteDatabase database;
    private MySQLiteHelper dbHelper;
    private String[] allColumns = {
            ExerciseEntry._ID,
            ExerciseEntry.COLUMN_NAME,
            ExerciseEntry.COLUMN_IMAGE_URL
    };

    public ExerciseDataSource(Context context) {
        dbHelper = new MySQLiteHelper(context);
    }

    public void open() throws SQLException {
        database = dbHelper.getWritableDatabase();
    }

    public void close() {
        dbHelper.close();
    }

    public void storeExercise(Exercise exercise) {
        ContentValues values = new ContentValues();
        values.put(ExerciseEntry.COLUMN_NAME, exercise.getName());
        values.put(ExerciseEntry.COLUMN_IMAGE_URL, exercise.getImageUrl());
        long id = database.insert(ExerciseEntry.TABLE_NAME, null, values);
    }

    public List<Exercise> getAllExercises() {
        List<Exercise> exerciseList = new ArrayList<>();
        Cursor cursor = database.query(ExerciseEntry.TABLE_NAME,
                allColumns, null, null, null, null, null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            Exercise exercise = cursorToExercise(cursor);
            exerciseList.add(exercise);
            cursor.moveToNext();
        }
        cursor.close();
        return exerciseList;
    }

    private Exercise cursorToExercise(Cursor cursor) {
        Exercise exercise = new Exercise();
        exercise.setId(cursor.getInt(0));
        exercise.setName(cursor.getString(1));
        exercise.setImageUrl(cursor.getString(2));
        return exercise;
    }
}
