package com.vladan.mymovies.data.local.db.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import com.vladan.mymovies.data.local.model.Genre;
import com.vladan.mymovies.data.local.model.Movie;

import java.util.List;

/**
 * Created by Vladan on 10/14/2017.
 */

@Dao
public interface MovieDao {

    @Query("SELECT * FROM Movie")
    List<Movie> getAllMovies();

    @Query("SELECT * FROM Movie WHERE genres IN(:genre)")
    List<Movie> getMoviesByGenre(Genre genre);

    @Query("SELECT * FROM Movie Where id = :id")
    Movie getMovie(int id);

    @Update (onConflict = OnConflictStrategy.REPLACE)
    void updateMovie(Movie movie);

}
