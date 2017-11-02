package com.vladan.mymovies.data.local.db;



import android.arch.persistence.room.TypeConverter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Vladan on 11/1/2017.
 */

public class Converters {

    @TypeConverter
    public static List<Integer> toList(String genreIds) {
        List<Integer> list = new ArrayList<>();
        String[] array = genreIds.split(",");
        for(String s: array){
         if(!s.equals("")){
             list.add(Integer.parseInt(s));
         }
        }
        return list;
    }

    @TypeConverter
    public static String fromList(List<Integer> list) {
        String genreIds = "";
        for(int i : list){
            genreIds += i+",";
        }
        return genreIds;
    }



}
