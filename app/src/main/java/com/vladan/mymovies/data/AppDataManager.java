package com.vladan.mymovies.data;

import android.content.Context;

import com.vladan.mymovies.data.local.db.AppDatabase;
import com.vladan.mymovies.data.local.db.dao.MovieDao;
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

    private final MovieDao movieDao;
    private final ApiService service;

    public AppDataManager(MovieDao dao, ApiService service) {
        this.movieDao = dao;
        this.service = service;
    }


    public Observable<List<Movie>> popularMovies() {
        return service.popularMovies()
                .map(MovieResponse::getMovies)
                .doOnNext(movies -> {
                    List<Movie> currentMovies = movieDao.getAllMovies();
                    movieDao.clearAll(currentMovies);
                    movieDao.insertAll(movies);
                })
                .onErrorResumeNext(throwable -> {
                    List<Movie> movies = movieDao.getAllMovies();
                    return Observable.just(movies);
                });
    }


}


