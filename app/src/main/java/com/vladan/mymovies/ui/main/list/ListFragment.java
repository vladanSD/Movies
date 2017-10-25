package com.vladan.mymovies.ui.main.list;

import com.vladan.mymovies.data.model.Movie;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.LayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.vladan.mymovies.R;
import com.vladan.mymovies.ui.MoviesRecyclerAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Vladan on 10/16/2017.
 */

public class ListFragment extends Fragment implements MoviesRecyclerAdapter.OnItemClicked {

    View mRootView;

    RecyclerView mRecyclerView;
    LayoutManager mLayoutManger;
    MoviesRecyclerAdapter mAdapter;

    List<Movie> mList;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mRootView = inflater.inflate(R.layout.list_fragment, container, false);
        return mRootView;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initRecycler();
    }

    private void initRecycler(){
        mRecyclerView = mRootView.findViewById(R.id.rv_picked_list);
        mLayoutManger = new LinearLayoutManager(getContext());
        mAdapter = new MoviesRecyclerAdapter(randomTestData(), getContext(), this);
        mRecyclerView.setLayoutManager(mLayoutManger);
        mRecyclerView.setAdapter(mAdapter);

    }

    List<Movie> randomTestData(){
        mList = new ArrayList<>();

        Movie m = new Movie();
        Movie m1 = new Movie();
        Movie m2 = new Movie();
        Movie m3 = new Movie();
        Movie m4 = new Movie();

        m.setPosterPath("http://t2.gstatic.com/images?q=tbn:ANd9GcRo9vfJCM6dzPkZHIHBVCtlJnAnew9Ai26kEdrli0-tfmatmciD");
        m1.setPosterPath("https://pbs.twimg.com/media/DIYBKtiUwAEu5M5.jpg");
        m2.setPosterPath("https://resizing.flixster.com/iBMbm0q6aAkWJoDNAqkIrszZlYU=/206x305/v1.bTsxMTE2OTE4MztqOzE3NTQ0OzEyMDA7ODAwOzEyMDA");
        m3.setPosterPath("https://dw9to29mmj727.cloudfront.net/misc/newsletter-naruto3.png");
        m4.setPosterPath("http://t0.gstatic.com/images?q=tbn:ANd9GcTrF2mGRl72HSQT3PjTQIhLjSRYnGNoD8w69yp4n4-XXquwYXvv");

        m.setTitle("Inception");
        m1.setTitle("Shutter island");
        m2.setTitle("Intouchables");
        m3.setTitle("Naruto");
        m4.setTitle("Handmaiden");

//        m.setGenres(1);
//        m1.setGenres(1);
//        m2.setGenres(1);
//        m3.setGenres(1);
//        m4.setGenres(1);

        mList.add(m);
        mList.add(m1);
        mList.add(m2);
        mList.add(m3);
        mList.add(m4);

        return  mList;
    }


    @Override
    public void onItemClicked(int position) {
        
    }
}
