package com.vladan.mymovies.data.local.db.dao;

import com.vladan.mymovies.data.local.db.AppDatabase;
import com.vladan.mymovies.data.local.db.DatabaseHelper;
import com.vladan.mymovies.data.local.model.Genre;
import com.vladan.mymovies.data.local.model.Movie;

import java.util.List;

import io.reactivex.Observable;

/**
 * Created by Vladan on 10/14/2017.
 */

public class AppDatabaseHelper implements DatabaseHelper {

    private final AppDatabase appDatabase;

    public AppDatabaseHelper(AppDatabase appDatabase) {
        this.appDatabase = appDatabase;
    }


    @Override
    public Observable<List<Movie>> getAllMovies() {
        return null;
    }

    @Override
    public Observable<List<Movie>> getMoviesByGenre(Genre genre) {
        return null;
    }

    @Override
    public Observable<Boolean> updateMovie(int id) {
        return null;
    }

    @Override
    public Observable<List<Genre>> getAllGenres() {
        return null;
    }
}
