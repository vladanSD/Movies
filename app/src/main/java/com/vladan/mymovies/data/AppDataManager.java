package com.vladan.mymovies.data;

import android.content.Context;

import com.vladan.mymovies.data.model.Movie;

import com.vladan.mymovies.data.local.db.AppDatabaseHelper;
import com.vladan.mymovies.data.model.MovieResponse;
import com.vladan.mymovies.data.remote.ApiService;

import java.util.List;

import io.reactivex.Observable;


/**
 * Created by Vladan on 10/21/2017.
 */

public class AppDataManager {

    private AppDataManager instance;

    private final Context context;
    private final AppDatabaseHelper database;
    private final ApiService service;

    public AppDataManager(Context context, AppDatabaseHelper database, ApiService service) {
        this.context = context;
        this.database = database;
        this.service = service;
    }


        public Observable<List<Movie>> popularMovies() {
            return service.popularMovies()
                    .map(MovieResponse::getMovies)
                    .doOnNext(movies -> {
                        Observable<List<Movie>> currentMovies = database.getAllMovies();
                        database.clearAll(((List<Movie>) currentMovies));
                        database.insertAll(movies);
                    })
                    .onErrorResumeNext(throwable -> {
                        return database.getAllMovies();

                    });
        }
    }


