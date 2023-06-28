package com.wgu.moviedbapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    private static String DATABASE_PATH_AND_NAME;
    private static String CHECK_DATABASES_FOLDER;
    private static final String DATABASE_NAME = "moviedatabase.db";
    private static final String LOG_TAG = "moviedatabase.db";
    Context ctx;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setupDatabaseStrings();
    }

    protected void setupDatabaseStrings()
    {
// Full path to where we will copy music.db to on the emulator!
        DATABASE_PATH_AND_NAME = "/data/data/" + getApplicationContext().getPackageName() +
                "/databases/" + DATABASE_NAME;
// Used to check if the "databases" folder exists
        CHECK_DATABASES_FOLDER = "/data/data/" + getApplicationContext().getPackageName() +
                "/databases";
// Debug information
        Log.i("DATABASE_PATH_AND_NAME","DATABASE_PATH_AND_NAME = " + DATABASE_PATH_AND_NAME);
        Log.i("CHECK_DATABASES_FOLDER","CHECK_DATABASES_FOLDER = " + CHECK_DATABASES_FOLDER);
    } // protected void setupDatabaseStrings()

}