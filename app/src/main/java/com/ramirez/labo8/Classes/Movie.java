package com.ramirez.labo8.Classes;


import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

@Entity(tableName = "movie")
public class Movie {

    @PrimaryKey(autoGenerate = true)
    private int idMovie;

    @ColumnInfo(name = "nom_movie")
    private String nomMovie;

    @ColumnInfo(name = "des_movie")
    private String des_movie;

    @ColumnInfo(name = "nom_category")
    private String nomCategory;

    @ColumnInfo(name = "nom_studio")
    private String nomEstudio;

    public Movie(){

    }

    public Movie(String nomMovie, String nomCategory, String nomEstudio) {
        this.nomMovie = nomMovie;
        this.nomCategory = nomCategory;
        this.nomEstudio = nomEstudio;
    }

    //getter and setters
    public int getIdMovie() {
        return idMovie;
    }

    public void setIdMovie(int idMovie) {
        this.idMovie = idMovie;
    }

    public String getNomMovie() {
        return nomMovie;
    }

    public void setNomMovie(String nomMovie) {
        this.nomMovie = nomMovie;
    }

    public String getDes_movie() {
        return des_movie;
    }

    public void setDes_movie(String des_movie) {
        this.des_movie = des_movie;
    }

    public String getNomCategory() {
        return nomCategory;
    }

    public void setNomCategory(String nomCategory) {
        this.nomCategory = nomCategory;
    }

    public String getNomEstudio() {
        return nomEstudio;
    }

    public void setNomEstudio(String nomEstudio) {
        this.nomEstudio = nomEstudio;
    }
}
