package com.ramirez.labo8;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.ramirez.labo8.Activities.CreateMovie;
import com.ramirez.labo8.Adapter.MovieAdapter;
import com.ramirez.labo8.Classes.AppDatabase;
import com.ramirez.labo8.Classes.Movie;
import com.ramirez.labo8.Threads.Thread;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    RecyclerView rv;
    MovieAdapter adapter;
    List<Movie> movies;
    FloatingActionButton fab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        rv = findViewById(R.id.recyclerid);
        adapter = new MovieAdapter(movies);
        rv.setLayoutManager(new LinearLayoutManager(this));

        AppDatabase db =AppDatabase.getAppDatabase(getApplicationContext());
        movies = db.moviesDAO().getAll();

        new Thread(movies,rv,adapter,db).execute();
        fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), CreateMovie.class));
            }
        });
    }
}