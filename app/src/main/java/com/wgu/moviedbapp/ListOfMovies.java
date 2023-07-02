package com.wgu.moviedbapp;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;


public class ListOfMovies extends AppCompatActivity {
    private static final String TABLE_NAME = "Movies";
    private static final String COLUMN_ID = "_id";
    private static final String COLUMN_TITLE = "title";
    private static final String COLUMN_AUTHOR = "author";
    private static final String COLUMN_YEAR = "year";
    private static final String COLUMN_CATEGORY = "category";
    private static final String COLUMN_LANGUAGE = "languages";
    RecyclerView recyclerView;
    FloatingActionButton add_Button;
    MovieDBHelper mdh;
    ArrayList<String> id, title, author, year, category, languages;
    CustomAdapter customAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_of_movies);

        recyclerView = findViewById(R.id.idrecycleview);
        add_Button = findViewById(R.id.floatingActionButton);

        add_Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ListOfMovies.this, CreateMovie.class);
                startActivity(intent);
            }
        });

        mdh = new MovieDBHelper(ListOfMovies.this);
        id = new ArrayList<>();
        title = new ArrayList<>();
        author = new ArrayList<>();
        year = new ArrayList<>();
        category = new ArrayList<>();
        languages = new ArrayList<>();

        storeDatainArray();
        customAdapter = new CustomAdapter(ListOfMovies.this, id, title, author, year, category, languages);
        recyclerView.setAdapter(customAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(ListOfMovies.this));

    }

    void storeDatainArray() {
        Cursor cursor = mdh.readAllData();
        if (cursor.getCount() == 0) {
            Toast.makeText(this, "No data", Toast.LENGTH_SHORT).show();
        } else {
            while (cursor.moveToNext()) {
                id.add(cursor.getString(0));
                title.add(cursor.getString(1));
                author.add(cursor.getString(2));
                year.add(cursor.getString(3));
                category.add(cursor.getString(4));
                languages.add(cursor.getString(5));
            }
        }
    }
}