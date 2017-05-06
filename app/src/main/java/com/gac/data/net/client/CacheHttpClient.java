package com.gac.data.net.client;

import android.app.Application;
import android.support.annotation.CheckResult;

import com.gac.common.util.NetworkUtil;
import com.gac.data.net.core.BaseOkHttpClient;

import java.io.File;
import java.io.IOException;

import javax.inject.Inject;

import okhttp3.Cache;
import okhttp3.CacheControl;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * cache http client
 * Created by spencer on 10/17/16.
 */
public class CacheHttpClient extends BaseOkHttpClient {

    private static final int CACHE_SIZE = 1024 * 1024 * 50;

    @Inject
    Application mApplication;

    @CheckResult
    @Override
    protected OkHttpClient.Builder customize(OkHttpClient.Builder builder) {
        File cacheFile = new File(mApplication.getCacheDir(), "android-github-cache");
        Cache cache = new Cache(cacheFile, CACHE_SIZE);
        builder.cache(cache);

        builder.addInterceptor(new CacheControlInterceptor(mApplication));

        return builder;
    }

    private static final class CacheControlInterceptor implements Interceptor {

        private final Application mApplication;

        private CacheControlInterceptor(Application application) {
            mApplication = application;
        }

        @Override
        public Response intercept(Chain chain) throws IOException {

            Request request = chain.request();

            if (!NetworkUtil.isNetworkAvailable(mApplication)) {
                request = request.newBuilder().cacheControl(CacheControl.FORCE_CACHE).build();
            }

            Response response = chain.proceed(request);

            if (NetworkUtil.isNetworkAvailable(mApplication)) {
                String cacheControl = request.cacheControl().toString();
                return response.newBuilder().header("Cache-Control", cacheControl).build();
            } else {
                return response.newBuilder().header("Cache-Control", CacheControl.FORCE_CACHE.toString()).build();
            }
        }
    }
}
