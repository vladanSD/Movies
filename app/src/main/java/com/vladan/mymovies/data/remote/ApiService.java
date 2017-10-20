package com.vladan.mymovies.data.remote;

import com.vladan.mymovies.data.model.MovieResponse;

import io.reactivex.Observable;
import retrofit2.http.GET;

/**
 * Created by Vladan on 10/20/2017.
 */

public interface ApiService {

    @GET("popular/")
    Observable<MovieResponse> popularMovies();
}
