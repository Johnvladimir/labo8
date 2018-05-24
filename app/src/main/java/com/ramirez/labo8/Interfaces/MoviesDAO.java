package com.ramirez.labo8.Interfaces;


import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import com.ramirez.labo8.Classes.Movie;

import java.util.List;

import static android.arch.persistence.room.OnConflictStrategy.REPLACE;

public interface MoviesDAO {

    @Query("SELECT * FROM MOVIE")
    List<Movie> getAll();

    @Insert(onConflict = REPLACE)
    void insertMovie(Movie movie);
}
