package com.vladan.mymovies.data.remote;

import com.vladan.mymovies.data.model.GenreResponse;
import com.vladan.mymovies.data.model.MovieResponse;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by Vladan on 10/20/2017.
 */

public interface MovieService {

    @GET("movie/popular/")
    Observable<MovieResponse> popularMovies();

    @GET("movie/top_rated/")
    Observable<MovieResponse> topRatedMovies();

    @GET("movie/upcoming/")
    Observable<MovieResponse> upcomingMovies();

    @GET("search/movie")
    Observable<MovieResponse> searchMovie(@Query("query") String search);

    @GET("genre/movie/list/")
    Observable<GenreResponse> genres();
}
