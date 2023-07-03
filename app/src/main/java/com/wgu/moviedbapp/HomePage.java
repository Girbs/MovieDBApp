package com.wgu.moviedbapp;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class HomePage extends AppCompatActivity {
    private static final String DATABASE_NAME = "moviedatabase.db";
    private static final String LOG_TAG = "moviedatabase.db";
    private static String DATABASE_PATH_AND_NAME;
    private static String CHECK_DATABASES_FOLDER;
    TextView about;
    TextView movies;
    TextView help;

    Context ctx;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);

        about = findViewById(R.id.idAboutButton);
        movies = findViewById(R.id.buttonMovies);
        help = findViewById(R.id.buttonHelp);

        about.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(HomePage.this, About.class));
            }
        });

        movies.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(HomePage.this, ListOfMovies.class));
            }
        });

        help.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(HomePage.this, Help.class));
            }
        });

    }
}