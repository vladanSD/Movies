package com.vladan.mymovies.data.model;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Vladan on 10/14/2017.
 */
@Entity
public class Genre {

    @PrimaryKey
    @SerializedName("genre_id")
    @Expose
    private int genreId;

    @SerializedName("name")
    @Expose
    private String name;

    public Genre() {
    }

    public int getGenreId() {
        return genreId;
    }

    public void setGenreId(int genreId) {
        this.genreId = genreId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
