package com.vladan.mymovies.data.remote;

import com.vladan.mymovies.BuildConfig;

import java.io.IOException;

import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by Vladan on 10/20/2017.
 */

public class ApiKeyInterceptor implements Interceptor {
    @Override
    public Response intercept(Chain chain) throws IOException {
        Request request = chain.request();
        HttpUrl url = request.url().newBuilder()
                .addQueryParameter("api_key", BuildConfig.API_KEY)
                .build();
        request = request.newBuilder().url(url).build();
        return chain.proceed(request);
    }
}
