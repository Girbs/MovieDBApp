package com.wgu.moviedbapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.google.android.material.floatingactionbutton.FloatingActionButton;


public class ListOfMovies extends AppCompatActivity {
    RecyclerView recyclerView;
    FloatingActionButton add_Button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_of_movies);

        recyclerView= findViewById(R.id.idrecycleview);
        add_Button = findViewById(R.id.floatingActionButton);

        add_Button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ListOfMovies.this, CreateMovie.class);
                startActivity(intent);
            }
        });
    }
}