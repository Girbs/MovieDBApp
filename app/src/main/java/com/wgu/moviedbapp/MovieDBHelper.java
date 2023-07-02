package com.wgu.moviedbapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import org.jetbrains.annotations.Nullable;

public class MovieDBHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "Moviedb.db";
    private static final int DATABASE_VERSION = 1;
    private static final String TABLE_NAME = "Movies";
    private static final String COLUMN_ID = "_id";
    private static final String COLUMN_TITLE = "title";
    private static final String COLUMN_AUTHOR = "author";
    private static final String COLUMN_YEAR = "year";
    private static final String COLUMN_CATEGORY = "category";
    private static final String COLUMN_LANGUAGE = "languages";
    private Context context;

    public MovieDBHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String query = "CREATE TABLE " + TABLE_NAME +
                " (" + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COLUMN_TITLE + " TEXT, " +
                COLUMN_AUTHOR + " TEXT, " +
                COLUMN_YEAR + " TEXT, " +
                COLUMN_CATEGORY + " TEXT, " +
                COLUMN_LANGUAGE + " TEXT);";
        db.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    void addMovie(String title, String author, String year, String category, String languages) {

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(COLUMN_TITLE, title);
        cv.put(COLUMN_AUTHOR, author);
        cv.put(COLUMN_YEAR, year);
        cv.put(COLUMN_CATEGORY, category);
        cv.put(COLUMN_LANGUAGE, languages);

        Long result = db.insert(TABLE_NAME, null, cv);
        if (result == -1) {
            Toast.makeText(context, "Inssertion failed", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(context, "Movie " + title + " inserted successfully", Toast.LENGTH_SHORT).show();

        }
    }

    Cursor readAllData() {
        String query = "SELECT * FROM " + TABLE_NAME;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = null;
        if (db != null) {
            cursor = db.rawQuery(query, null);
        }
        return cursor;
    }

    void updateData(String row_id, String title, String author, String year, String category, String languages) {
        SQLiteDatabase db = this.getReadableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(COLUMN_TITLE, title);
        cv.put(COLUMN_AUTHOR, author);
        cv.put(COLUMN_YEAR, year);
        cv.put(COLUMN_CATEGORY, category);
        cv.put(COLUMN_LANGUAGE, languages);

        long result = db.update(TABLE_NAME, cv, "_id=?", new String[]{row_id});

        if (result == -1) {
            Toast.makeText(context, "update failed", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(context, title + " Movie update successfully", Toast.LENGTH_SHORT).show();
        }
    }

    void deleteOneRow(String row_id) {
        SQLiteDatabase db = this.getWritableDatabase();
        long result = db.delete(TABLE_NAME, "_id=?", new String[]{row_id});
        if (result == -1) {
            Toast.makeText(context, "Failed to deleted", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(context, "Record deleted successfullty", Toast.LENGTH_SHORT).show();
        }
    }
}

