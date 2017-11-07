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

    private MutableLiveData<Response<List<Movie>>> popularMoviesLiveData;
    private MutableLiveData<Response<List<Movie>>> topRatedMoviesLiveData;
    private MutableLiveData<Response<List<Movie>>> upcomingMoviesLiveData;


    private MutableLiveData<Response<List<Movie>>> searchedMovies;


    public SearchViewModel(AppDataManager appDataManager) {
        this.appDataManager = appDataManager;
    }


    LiveData<Response<List<Movie>>> getMoviesList() {
        if (popularMoviesLiveData == null) {
            popularMoviesLiveData = new MutableLiveData<>();
            appDataManager.popularMovies()
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .doOnSubscribe(disposable -> loadingLiveData.setValue(true))
                    .doAfterTerminate(() -> loadingLiveData.setValue(false))
                    .subscribe(
                            movies -> popularMoviesLiveData.setValue(Response.success(movies)),
                            throwable -> popularMoviesLiveData.setValue(Response.error(throwable))
                    );
        }
        return popularMoviesLiveData;
    }

    LiveData<Response<List<Movie>>> getTopRatedMovies() {
        if (topRatedMoviesLiveData == null) {
            topRatedMoviesLiveData = new MutableLiveData<>();
            appDataManager.topRatedMovies()
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .doOnSubscribe(disposable -> loadingLiveData.setValue(true))
                    .doAfterTerminate(() -> loadingLiveData.setValue(false))
                    .subscribe(
                            movies -> topRatedMoviesLiveData.setValue(Response.success(movies)),
                            throwable -> topRatedMoviesLiveData.setValue(Response.error(throwable))
                    );
        }
        return topRatedMoviesLiveData;
    }



    LiveData<Response<List<Movie>>> getUpcomingMovies() {
        if (upcomingMoviesLiveData == null) {
            upcomingMoviesLiveData = new MutableLiveData<>();
            appDataManager.upcomingMovies()
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .doOnSubscribe(disposable -> loadingLiveData.setValue(true))
                    .doAfterTerminate(() -> loadingLiveData.setValue(false))
                    .subscribe(
                            movies -> upcomingMoviesLiveData.setValue(Response.success(movies)),
                            throwable -> upcomingMoviesLiveData.setValue(Response.error(throwable))
                    );
        }
        return upcomingMoviesLiveData;
    }


    LiveData<Response<List<Movie>>> getSearchedMovies(String search) {
            searchedMovies = new MutableLiveData<>();
            appDataManager.searchMovies(search)
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .doOnSubscribe(disposable -> loadingLiveData.setValue(true))
                    .doAfterTerminate(() -> loadingLiveData.setValue(false))
                    .subscribe(
                            movies -> searchedMovies.setValue(Response.success(movies)),
                            throwable -> searchedMovies.setValue(Response.error(throwable))
                    );
        return searchedMovies;
    }





}
