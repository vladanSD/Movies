package com.vladan.mymovies.data.model;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Vladan on 11/2/2017.
 */

public class GenreResponse {

    @SerializedName("genres")
    private List<Genre> genres;


    public List<Genre> getGenres() {
        if(genres == null){
            return new ArrayList<>();
        }
        return genres;
    }
}
