package com.vladan.mymovies.data.local.db;

import com.vladan.mymovies.data.local.model.Genre;
import com.vladan.mymovies.data.local.model.Movie;

import java.util.List;

import io.reactivex.Observable;

/**
 * Created by Vladan on 10/14/2017.
 */

public interface DatabaseHelper {

    Observable<List<Movie>> getAllMovies();

    Observable<List<Movie>> getMoviesByGenre(Genre genre);

    Observable<Boolean> updateMovie(int id);

    Observable<List<Genre>> getAllGenres();


}
