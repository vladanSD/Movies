package com.vladan.mymovies.data.local.db.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import com.vladan.mymovies.data.model.Genre;
import com.vladan.mymovies.data.model.Movie;

import java.util.List;

/**
 * Created by Vladan on 10/14/2017.
 */

@Dao
public interface MovieDao {

    @Query("SELECT * FROM Movie")
    List<Movie> getAllMovies();

    @Query("SELECT * FROM Movie WHERE genres =:genre")
    List<Movie> getMoviesByGenre(int genre);

    @Query("SELECT * FROM Movie Where id = :id")
    Movie getMovie(int id);

    @Update (onConflict = OnConflictStrategy.REPLACE)
    void updateMovie(Movie movie);

    @Delete
    void clearAll(List<Movie> list);

    @Insert (onConflict = OnConflictStrategy.REPLACE)
    void insertAll(List<Movie> list);

}
