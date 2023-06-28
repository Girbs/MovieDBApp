package com.wgu.moviedbapp;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class OpenDatabase extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "moviedatabase.db";
    // TOGGLE THIS NUMBER FOR UPDATING TABLES AND DATABASE
    private static final int DATABASE_VERSION = 1;
    OpenDatabase(Context context)
    {
        super( context, DATABASE_NAME, null, DATABASE_VERSION );
    } // OpenDatabase(Context context)
    @Override
    public void onCreate(SQLiteDatabase db)
    {
    } // public void onCreate(SQLiteDatabase db)
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion)
    {
    } // public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion)
}
