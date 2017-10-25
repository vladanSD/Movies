package com.vladan.mymovies.ui.main.search;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;

import com.vladan.mymovies.data.AppDataManager;
import com.vladan.mymovies.data.model.Movie;
import com.vladan.mymovies.data.model.Response;

import java.util.Collections;
import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by Vladan on 10/21/2017.
 */

public class SearchViewModel extends ViewModel {

    private AppDataManager appDataManager;

    private final MutableLiveData<Boolean> loadingLiveData = new MutableLiveData<>();

    private MutableLiveData<Response<List<Movie>>> moviesLiveData;

    public SearchViewModel(AppDataManager appDataManager) {
        this.appDataManager = appDataManager;
    }

    LiveData<Response<List<Movie>>> getMoviesList() {
        if (moviesLiveData == null) {
            moviesLiveData = new MutableLiveData<>();
            appDataManager.popularMovies()
                    .map(movies -> {
                        Collections.sort(movies, (first, second) -> second.getId() - first.getId());
                        return movies;
                    })
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .doOnSubscribe(disposable -> loadingLiveData.setValue(true))
                    .doAfterTerminate(() -> loadingLiveData.setValue(false))
                    .subscribe(
                            movies -> moviesLiveData.setValue(Response.success(movies)),
                            throwable -> moviesLiveData.setValue(Response.error(throwable))
                    );
        }
        return moviesLiveData;
    }



}
