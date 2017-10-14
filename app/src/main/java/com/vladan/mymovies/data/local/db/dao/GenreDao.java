package com.vladan.mymovies.data.local.db.dao;

import android.arch.persistence.room.Query;

import com.vladan.mymovies.data.local.model.Genre;

import java.util.List;

/**
 * Created by Vladan on 10/14/2017.
 */

public interface GenreDao {


    @Query("SELECT * FROM Genre")
    List<Genre> getAllGenres();
}
