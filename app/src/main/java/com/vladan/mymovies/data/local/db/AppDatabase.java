package com.vladan.mymovies.data.local.db;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.arch.persistence.room.TypeConverter;
import android.content.Context;

import com.vladan.mymovies.data.local.db.dao.GenreDao;
import com.vladan.mymovies.data.local.db.dao.MovieDao;
import com.vladan.mymovies.data.model.Genre;
import com.vladan.mymovies.data.model.Movie;

/**
 * Created by Vladan on 10/14/2017.
 */
@Database(entities = {Movie.class, Genre.class}, version = 4)
public abstract class AppDatabase extends RoomDatabase {

    private static AppDatabase instance;

    public static AppDatabase getInstance(Context context){
        if(instance == null) instance = Room.databaseBuilder(context, AppDatabase.class, "movies_db")
                .fallbackToDestructiveMigration()
                .build();
        return instance;
    }

    public abstract MovieDao movieDao();

    public abstract GenreDao genreDao();

}
