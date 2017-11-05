package com.mato.timothee.fizzuptechnicaltest.db;

import android.provider.BaseColumns;

/**
 * Created by timotheemato on 11/5/17.
 */

public class ExercisesReaderContract {

    private ExercisesReaderContract() {}

    public static class ExerciseEntry implements BaseColumns {
        public static final String TABLE_NAME = "exercises";
        public static final String COLUMN_NAME = "name";
        public static final String COLUMN_IMAGE_URL = "image_url";
    }
}
