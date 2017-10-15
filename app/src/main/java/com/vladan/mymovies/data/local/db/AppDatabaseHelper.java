package com.vladan.mymovies.data.local.db;

import com.vladan.mymovies.data.model.Genre;
import com.vladan.mymovies.data.model.Movie;

import java.util.List;
import java.util.concurrent.Callable;

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
        return Observable.fromCallable(new Callable<List<Movie>>() {
            @Override
            public List<Movie> call() throws Exception {
                return appDatabase.movieDao().getAllMovies();
            }
        });
    }

    @Override
    public Observable<List<Movie>> getMoviesByGenre(final int genre) {

        return Observable.fromCallable(new Callable<List<Movie>>() {
            @Override
            public List<Movie> call() throws Exception {
                return appDatabase.movieDao().getMoviesByGenre(genre);
            }
        });
    }

    @Override
    public Observable<Boolean> updateMovie(final Movie movie) {
        return Observable.fromCallable(new Callable<Boolean>() {
            @Override
            public Boolean call() throws Exception {
                 appDatabase.movieDao().updateMovie(movie);
                 return true;
            }
        });
    }

    @Override
    public Observable<List<Genre>> getAllGenres() {

        return Observable.fromCallable(new Callable<List<Genre>>() {
            @Override
            public List<Genre> call() throws Exception {
                return appDatabase.genreDao().getAllGenres();
            }
        });
    }



}
