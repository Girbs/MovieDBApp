package com.wgu.moviedbapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class UpdateMovie extends AppCompatActivity {
    EditText title_input, author_input, year_input, category_input, languages_input;
    Button update_button;
    String id, author, year, category, languages, title;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_movie);
        title_input = findViewById(R.id.idTitle1);
        author_input = findViewById(R.id.idAuthor1);
        year_input = findViewById(R.id.idYear1);
        category_input = findViewById(R.id.idCategory1);
        languages_input = findViewById(R.id.idLanguage1);
        update_button = findViewById(R.id.update_movie);

        update_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MovieDBHelper mdh = new MovieDBHelper(UpdateMovie.this);
                mdh.updateData(id, title_input.getText().toString().trim(),
                        author_input.getText().toString().trim(),
                        year_input.getText().toString().trim(),
                        category_input.getText().toString().trim(),
                        languages_input.getText().toString().trim());
                startActivity(new Intent(UpdateMovie.this, ListOfMovies.class));
            }
        });
        getAndSetIntentData();
    }

    void getAndSetIntentData() {
        if (getIntent().hasExtra("id")) {

            //Getting data from intent
            id = getIntent().getStringExtra("id");
            title = getIntent().getStringExtra("title");
            year = getIntent().getStringExtra("year");
            author = getIntent().getStringExtra("author");
            category = getIntent().getStringExtra("category");
            languages = getIntent().getStringExtra("language");

            //setting intent Data
            title_input.setText(title);
            author_input.setText(year);
            year_input.setText(author);
            category_input.setText(category);
            languages_input.setText(languages);
        } else {
            Toast.makeText(this, "No Data", Toast.LENGTH_SHORT).show();
        }
    }
}