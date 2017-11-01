package com.vladan.mymovies.data.local.db;



import android.arch.persistence.room.TypeConverter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Vladan on 11/1/2017.
 */

public class Converters {

    @TypeConverter
    public static Genres toList(String genreIds) {
        List<Integer> list = new ArrayList<>();
        String[] array = genreIds.split(",");
        for(String s: array){
         list.add(Integer.parseInt(s));
        }
        return new Genres(list);
    }

    @TypeConverter
    public static String fromList(Genres genres) {
        List<Integer> list = genres.getList();
        String genreIds = "";
        for(int i : list){
            genreIds += ","+i;
        }
        return genreIds;
    }

    public Class[] value(){
        Class[] classes = new Class[]{this.getClass()};
        return classes;
    }



}
