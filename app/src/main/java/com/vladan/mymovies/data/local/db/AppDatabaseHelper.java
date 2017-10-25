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
        return Observable.fromCallable(() -> appDatabase.movieDao().getAllMovies());
    }

    @Override
    public Observable<List<Movie>> getMoviesByGenre(final int genre) {

//        return Observable.fromCallable(() -> appDatabase.movieDao().getMoviesByGenre(genre));
        return null;
    }

    @Override
    public Observable<Boolean> updateMovie(final Movie movie) {
        return Observable.fromCallable(() -> {
             appDatabase.movieDao().updateMovie(movie);
             return true;
        });
    }

    @Override
    public Observable<List<Genre>> getAllGenres() {

        return Observable.fromCallable(() -> appDatabase.genreDao().getAllGenres());
    }

    @Override
    public Observable<Boolean> clearAll(List<Movie> list) {
        return Observable.fromCallable(() -> {
            appDatabase.movieDao().clearAll(list);
            return true;
        });
    }

    @Override
    public Observable<Boolean> insertAll(List<Movie> list) {
        return Observable.fromCallable(() -> {
            appDatabase.movieDao().insertAll(list);
            return true;
        });
    }


}
