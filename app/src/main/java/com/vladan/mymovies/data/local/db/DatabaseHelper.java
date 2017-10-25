package com.vladan.mymovies.data.local.db;

import com.vladan.mymovies.data.model.Genre;
import com.vladan.mymovies.data.model.Movie;

import java.util.List;

import io.reactivex.Observable;

/**
 * Created by Vladan on 10/14/2017.
 */

public interface DatabaseHelper {

    Observable<List<Movie>> getAllMovies();

    Observable<List<Movie>> getMoviesByGenre(int genre);

    Observable<Boolean> updateMovie(Movie movie);

    Observable<List<Genre>> getAllGenres();

    Observable<Boolean> clearAll(List<Movie> list);

    Observable<Boolean> insertAll(List<Movie> list);


}
