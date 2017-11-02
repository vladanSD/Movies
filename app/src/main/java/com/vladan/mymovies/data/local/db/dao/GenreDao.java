package com.vladan.mymovies.data.local.db.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import com.vladan.mymovies.data.model.Genre;

import java.util.List;

/**
 * Created by Vladan on 10/14/2017.
 */
@Dao
public interface GenreDao {


    @Query("SELECT * FROM Genre")
    List<Genre> getAllGenres();


    @Insert (onConflict = OnConflictStrategy.REPLACE)
    void insertAll(List<Genre> list);


    @Query("DELETE FROM Genre")
    public void nukeTable();

}
