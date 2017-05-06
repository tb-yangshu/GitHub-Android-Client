package com.gac.data.net.core;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * base retrofit
 * Created by spencer on 10/17/16.
 */
public abstract class BaseRetrofit {

    public Retrofit get() {
        Retrofit.Builder builder = new Retrofit.Builder();
        builder.baseUrl(getApiEndpoint().getApiEndpoint())
                .client(getClient())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create());

        return builder.build();
    }

    protected abstract ApiEndpoint getApiEndpoint();

    protected abstract OkHttpClient getClient();

}
