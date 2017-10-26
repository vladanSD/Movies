package com.vladan.mymovies.data;


import com.vladan.mymovies.data.local.db.dao.MovieDao;
import com.vladan.mymovies.data.model.Movie;

import com.vladan.mymovies.data.model.MovieResponse;
import com.vladan.mymovies.data.remote.MovieService;

import java.util.List;

import io.reactivex.Observable;


/**
 * Created by Vladan on 10/21/2017.
 */

public class AppDataManager {

    private final MovieDao movieDao;
    private final MovieService service;

    public AppDataManager(MovieDao dao, MovieService service) {
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

    public Observable<List<Movie>> topRatedMovies() {
        return service.topRatedMovies()
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


    public Observable<List<Movie>> upcomingMovies() {
        return service.upcomingMovies()
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

    public Observable<List<Movie>> searchMovies(String search) {
        return service.searchMovie(search)
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


