package com.vladan.mymovies.data.model;


import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Vladan on 10/20/2017.
 */

public class MovieResponse {

    @SerializedName("results")
    private List<Movie> movies;


    public List<Movie> getMovies() {
        if(movies == null){
            return new ArrayList<>();
        }
        return movies;
    }
}
