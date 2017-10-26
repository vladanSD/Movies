package com.vladan.mymovies.utils;


import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProvider;

import com.vladan.mymovies.data.AppDataManager;
import com.vladan.mymovies.data.local.db.dao.MovieDao;
import com.vladan.mymovies.data.remote.MovieService;
import com.vladan.mymovies.ui.main.search.SearchViewModel;

public class ViewModelFactory implements ViewModelProvider.Factory {

    AppDataManager appDataManager;

    public ViewModelFactory(MovieService service, MovieDao dao) {
        this.appDataManager = new AppDataManager(dao, service);
    }

    @Override
    public <T extends ViewModel> T create(Class<T> modelClass) {
        if(modelClass.isAssignableFrom(SearchViewModel.class))
            return (T) new SearchViewModel(appDataManager);
        else {
            throw new IllegalArgumentException("ViewModel not found");
        }
    }
}
