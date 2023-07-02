package com.wgu.moviedbapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.MyViewHolder> {

    private Context context;
    private ArrayList id, title, author, year, category, languages;

    CustomAdapter(Context context,
                  ArrayList id,
                  ArrayList title,
                  ArrayList author,
                  ArrayList year,
                  ArrayList category,
                  ArrayList languages) {
        this.context = context;
        this.id = id;
        this.title = title;
        this.author = author;
        this.year = year;
        this.category = category;
        this.languages = languages;
    }

    @NonNull
    @Override
    public CustomAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.my_row, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CustomAdapter.MyViewHolder holder, int position) {
        holder.id_val.setText(String.valueOf(id.get(position)));
        holder.title_val.setText(String.valueOf(title.get(position)));
        holder.author_val.setText(String.valueOf(author.get(position)));
        holder.year_val.setText(String.valueOf(year.get(position)));
        holder.category_val.setText(String.valueOf(category.get(position)));
        holder.languages_val.setText(String.valueOf(languages.get(position)));
    }

    @Override
    public int getItemCount() {
        return id.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView id_val, title_val, author_val, year_val, category_val, languages_val;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            id_val = itemView.findViewById(R.id.id_val);
            title_val = itemView.findViewById(R.id.title_val);
            author_val = itemView.findViewById(R.id.author_val);
            year_val = itemView.findViewById(R.id.year_val);
            category_val = itemView.findViewById(R.id.category_val);
            languages_val = itemView.findViewById(R.id.languages_val);
        }
    }
}
