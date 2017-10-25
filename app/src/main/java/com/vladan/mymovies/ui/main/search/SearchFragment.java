package com.vladan.mymovies.ui.main.search;


import android.arch.lifecycle.LifecycleFragment;
import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.vladan.mymovies.R;
import com.vladan.mymovies.data.AppDataManager;
import com.vladan.mymovies.data.local.db.AppDatabase;
import com.vladan.mymovies.data.local.db.AppDatabaseHelper;
import com.vladan.mymovies.data.model.Movie;
import com.vladan.mymovies.data.model.Response;
import com.vladan.mymovies.data.remote.ApiFactory;
import com.vladan.mymovies.ui.MoviesRecyclerAdapter;
import com.vladan.mymovies.utils.ViewModelFactory;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Vladan on 10/15/2017.
 */

public class SearchFragment extends LifecycleFragment implements MoviesRecyclerAdapter.OnItemClicked{

    View mRootView;
    SearchViewModel viewModel;
    ViewModelFactory factory;

    RecyclerView mRecyclerView;
    RecyclerView.LayoutManager mLayoutManger;
    MoviesRecyclerAdapter mAdapter;

    AppDataManager appDataManager;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mRootView = inflater.inflate(R.layout.search_fragment, container, false);
        return mRootView;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initRecycler();


        initViewModel();


    }

    private void initRecycler(){
        mRecyclerView = mRootView.findViewById(R.id.rv_search);
        mLayoutManger = new LinearLayoutManager(getContext());
        mAdapter = new MoviesRecyclerAdapter(new ArrayList<>(), getContext(), this);
        mRecyclerView.setLayoutManager(mLayoutManger);
        mRecyclerView.setAdapter(mAdapter);

    }

    @Override
    public void onItemClicked(int position) {

    }


    private void initViewModel(){
        AppDatabaseHelper helper = new AppDatabaseHelper(AppDatabase.getInstance(getActivity()));
        appDataManager = new AppDataManager(getActivity(),helper, ApiFactory.getService());

        factory = new ViewModelFactory(appDataManager);
        viewModel = ViewModelProviders.of(this, factory).get(SearchViewModel.class);

        viewModel.getMoviesList().observe(SearchFragment.this, new Observer<Response<List<Movie>>>() {
            @Override
            public void onChanged(@Nullable Response<List<Movie>> listResponse) {
                List<Movie> list = new ArrayList<>();
                list =  listResponse.getData();
                mAdapter.updateList(list);
            }
        });
    }
}
