package com.wgu.moviedbapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class CreateMovie extends AppCompatActivity {
    EditText title_input, author_input, year_input, category_input, languages_input;
    Button save_movie_button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_movie);

        title_input = findViewById(R.id.idTitle);
        author_input = findViewById(R.id.idAuthor);
        year_input = findViewById(R.id.idYear);
        category_input = findViewById(R.id.idCategory);
        languages_input = findViewById(R.id.idLanguage);

        save_movie_button = findViewById(R.id.create_movie);

        save_movie_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MovieDBHelper movieDBHelper = new MovieDBHelper(CreateMovie.this);
                movieDBHelper.addMovie(
                        title_input.getText().toString().trim(),
                        author_input.getText().toString().trim(),
                        year_input.getText().toString().trim(),
                        category_input.getText().toString().trim(),
                        languages_input.getText().toString().trim());
                startActivity(new Intent(CreateMovie.this, ListOfMovies.class));
            }
        });
    }
}