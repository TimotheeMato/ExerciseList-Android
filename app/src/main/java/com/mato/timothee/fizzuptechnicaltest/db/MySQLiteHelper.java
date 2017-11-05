package com.mato.timothee.fizzuptechnicaltest.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.mato.timothee.fizzuptechnicaltest.db.ExercisesReaderContract.ExerciseEntry;


/**
 * Created by timotheemato on 11/5/17.
 */

public class MySQLiteHelper extends SQLiteOpenHelper {
    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "exercises.db";

    private static final String SQL_CREATE_ENTRIES =
            "CREATE TABLE " + ExerciseEntry.TABLE_NAME + " (" +
                    ExerciseEntry._ID + " INTEGER PRIMARY KEY," +
                    ExerciseEntry.COLUMN_NAME + " TEXT," +
                    ExerciseEntry.COLUMN_IMAGE_URL + " TEXT)";

    private static final String SQL_DELETE_ENTRIES =
            "DROP TABLE IF EXISTS " + ExerciseEntry.TABLE_NAME;

    public MySQLiteHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQL_CREATE_ENTRIES);
    }
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(SQL_DELETE_ENTRIES);
        onCreate(db);
    }
    public void onDowngrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        onUpgrade(db, oldVersion, newVersion);
    }
}
