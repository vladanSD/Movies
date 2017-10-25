package com.vladan.mymovies.utils;


import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProvider;

import com.vladan.mymovies.data.AppDataManager;
import com.vladan.mymovies.ui.main.list.ListFragment;
import com.vladan.mymovies.ui.main.search.SearchFragment;
import com.vladan.mymovies.ui.main.search.SearchViewModel;
import com.vladan.mymovies.utils.rx.SchedulerProvider;

public class ViewModelFactory implements ViewModelProvider.Factory {

    AppDataManager appDataManager;

    public ViewModelFactory(AppDataManager appDataManager) {
        this.appDataManager = appDataManager;
    }

    @Override
    public <T extends ViewModel> T create(Class<T> modelClass) {
        if(modelClass.isAssignableFrom(SearchViewModel.class))
            return (T) new SearchViewModel(appDataManager);
//        else if(modelClass.isAssignableFrom(ListFragment.class))
//            return (T) new DetailRecipeViewModel(repository);
        else {
            throw new IllegalArgumentException("ViewModel not found");
        }
    }
}
