package com.vladan.mymovies.data.local.db;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

import com.vladan.mymovies.data.local.db.dao.GenreDao;
import com.vladan.mymovies.data.local.db.dao.MovieDao;
import com.vladan.mymovies.data.local.model.Genre;
import com.vladan.mymovies.data.local.model.Movie;

/**
 * Created by Vladan on 10/14/2017.
 */
@Database(entities = {Movie.class, Genre.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {

    public abstract MovieDao movieDao();

    public abstract GenreDao genreDao();

}
