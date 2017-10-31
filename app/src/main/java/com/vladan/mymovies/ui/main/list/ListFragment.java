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
        mAdapter = new MoviesRecyclerAdapter(new ArrayList<>(), getContext(), this);
        mRecyclerView.setLayoutManager(mLayoutManger);
        mRecyclerView.setAdapter(mAdapter);

    }



    @Override
    public void onItemClicked(int position) {
        
    }
}
