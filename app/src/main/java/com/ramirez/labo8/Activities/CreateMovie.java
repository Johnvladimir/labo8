package com.ramirez.labo8.Activities;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.ramirez.labo8.Classes.AppDatabase;
import com.ramirez.labo8.Classes.Movie;
import com.ramirez.labo8.MainActivity;
import com.ramirez.labo8.R;

import java.util.List;

public class CreateMovie extends AppCompatActivity{
    EditText name,studio,category;
    Button btn;
    List<Movie> movies;
    String sname,sstudio,scat;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_movie);

        btn = findViewById(R.id.submit);
        name = findViewById(R.id.name);
        studio = findViewById(R.id.studio);
        category = findViewById(R.id.category);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sname = name.getText().toString();
                sstudio = studio.getText().toString();
                scat = category.getText().toString();
                AppDatabase db = AppDatabase.getAppDatabase(getApplicationContext());
                db.moviesDAO().insertMovie(new Movie(sname,sstudio,scat));
                startActivity(new Intent(getApplicationContext(), MainActivity.class));
            }
        });
    }
}
