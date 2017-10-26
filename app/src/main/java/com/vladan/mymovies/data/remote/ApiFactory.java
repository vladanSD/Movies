package com.vladan.mymovies.data.remote;

import com.vladan.mymovies.BuildConfig;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Vladan on 10/20/2017.
 */

public final class ApiFactory {

    private static volatile OkHttpClient client;
    private static volatile MovieService service;




    public static MovieService getService(){
        MovieService service = ApiFactory.service;
            if(service == null){
                synchronized (ApiFactory.class){
                    service = ApiFactory.service;
                    if(service == null){
                        service = ApiFactory.service = createService();
                    }
                }
            }
            return service;
    }


    private static MovieService createService(){
        return new Retrofit.Builder()
                .baseUrl(BuildConfig.API_ENDPOINT)
                .client(getClient())
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build()
                .create(MovieService.class);
    }


    private static OkHttpClient getClient(){
        OkHttpClient client = ApiFactory.client;
        if(client == null){
            synchronized (ApiFactory.class){
                client = ApiFactory.client;
                if(client == null){
                    client = ApiFactory.client = buildClient();
                }
            }
        }
        return client;
    }

    private static OkHttpClient buildClient(){
        return new OkHttpClient.Builder()
                .addInterceptor(new ApiKeyInterceptor())
                .addInterceptor(new HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
                .build();
    }

}
