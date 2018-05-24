package com.ramirez.labo8.Threads;


import android.os.AsyncTask;
import android.support.v7.widget.RecyclerView;

import com.ramirez.labo8.Adapter.MovieAdapter;
import com.ramirez.labo8.Classes.AppDatabase;
import com.ramirez.labo8.Classes.Movie;

import java.util.List;

public class Thread extends AsyncTask{

    private List<Movie> movies;
    private RecyclerView rv;
    private MovieAdapter adapter;
    private AppDatabase db;

    public Thread(List<Movie> movies, RecyclerView rv, MovieAdapter adapter, AppDatabase db) {
        this.movies = movies;
        this.rv = rv;
        this.adapter = adapter;
        this.db = db;
    }

    @Override
    protected Object doInBackground(Object[] objects) {
        addMovie(movies);
        adapter = new MovieAdapter(movies);
        rv.setAdapter(adapter);
        return null;
    }

    private void addMovie(List<Movie> movies) {
        movies.add(new Movie("Prueba","prueba 2","prueba3"));
        movies.add(new Movie("Prueba4","prueb5","prueba6"));
    }
}