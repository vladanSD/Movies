package com.vladan.mymovies.data.local.db;

import java.util.List;

/**
 * Created by Vladan on 11/1/2017.
 */

public class Genres {

    List<Integer> list = null;


    public Genres(List<Integer> list) {
        this.list = list;
    }

    public List<Integer> getList() {
        return list;
    }

    public void setList(List<Integer> list) {
        this.list = list;
    }
}
