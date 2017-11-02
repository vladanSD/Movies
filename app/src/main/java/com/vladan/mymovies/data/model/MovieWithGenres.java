package com.vladan.mymovies.data.model;

import java.util.List;

/**
 * Created by Vladan on 11/2/2017.
 */

public class MovieWithGenres {

    private int id;

    private String posterPath;

    private String overview;

    private String title;

    private String releasedDate;

    private double voteAverage;

    private List<Genre> genreList = null;

    public MovieWithGenres() {
    }

    public MovieWithGenres(int id, String posterPath, String overview, String title, String releasedDate, double voteAverage, List<Genre> genreList) {
        this.id = id;
        this.posterPath = posterPath;
        this.overview = overview;
        this.title = title;
        this.releasedDate = releasedDate;
        this.voteAverage = voteAverage;
        this.genreList = genreList;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPosterPath() {
        return posterPath;
    }

    public void setPosterPath(String posterPath) {
        this.posterPath = posterPath;
    }

    public String getOverview() {
        return overview;
    }

    public void setOverview(String overview) {
        this.overview = overview;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getReleasedDate() {
        return releasedDate;
    }

    public void setReleasedDate(String releasedDate) {
        this.releasedDate = releasedDate;
    }

    public double getVoteAverage() {
        return voteAverage;
    }

    public void setVoteAverage(double voteAverage) {
        this.voteAverage = voteAverage;
    }

    public List<Genre> getGenreList() {
        return genreList;
    }

    public void setGenreList(List<Genre> genreList) {
        this.genreList = genreList;
    }
}
