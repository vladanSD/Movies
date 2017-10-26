package com.vladan.mymovies.ui.main.search;


import android.arch.lifecycle.LifecycleFragment;
import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.Spinner;

import com.vladan.mymovies.R;
import com.vladan.mymovies.data.AppDataManager;
import com.vladan.mymovies.data.local.db.AppDatabase;
import com.vladan.mymovies.data.local.db.AppDatabaseHelper;
import com.vladan.mymovies.data.local.db.dao.MovieDao;
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
    EditText mEditText;
    Spinner mSortSpinner;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mRootView = inflater.inflate(R.layout.search_fragment, container, false);
        mEditText = mRootView.findViewById(R.id.et_search);
        mSortSpinner = mRootView.findViewById(R.id.spinner_sort);

        return mRootView;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initRecycler();

        initViewModel();

        mSortSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                searchEngine();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });


    }

    private void initRecycler(){
        mRecyclerView = mRootView.findViewById(R.id.rv_search);
        mRecyclerView.setNestedScrollingEnabled(false);
        mLayoutManger = new LinearLayoutManager(getContext());
        mAdapter = new MoviesRecyclerAdapter(new ArrayList<>(), getContext(), this);
        mRecyclerView.setLayoutManager(mLayoutManger);
        mRecyclerView.setAdapter(mAdapter);

    }

    @Override
    public void onItemClicked(int position) {

    }


    private void initViewModel(){
        MovieDao dao = AppDatabase.getInstance(getActivity()).movieDao();
        factory = new ViewModelFactory(ApiFactory.getService(), dao);
        viewModel = ViewModelProviders.of(this, factory).get(SearchViewModel.class);

//        viewModel.getMoviesList().observe(this, listResponse -> {
//            List<Movie> list =  listResponse.getData();
//            if(!list.isEmpty()){
//                mAdapter.updateList(list);
//            }
//        });

    }

    private void searchEngine(){
        switch (mSortSpinner.getSelectedItem().toString()) {
            case "Popular":
                viewModel.getMoviesList().observe(this, listResponse -> {
                    List<Movie> list = listResponse.getData();
                    if (!list.isEmpty()) {
                        mAdapter.updateList(list);
                    }
                });
                break;
            case "Top rated":
                viewModel.getTopRatedMovies().observe(this, listResponse -> {
                    List<Movie> list =  listResponse.getData();
                    if(!list.isEmpty()){
                        mAdapter.updateList(list);
                    }
                });
                break;
            case "Upcoming":
                viewModel.getUpcomingMovies().observe(this, listResponse -> {
                    List<Movie> list =  listResponse.getData();
                    if(!list.isEmpty()){
                        mAdapter.updateList(list);
                    }
                });
                break;
        }
    }
}
