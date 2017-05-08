package com.gac.data.net.retrofit;


import com.gac.data.net.client.GitHubHttpClient;
import com.gac.data.net.core.ApiEndpoint;
import com.gac.data.net.core.BaseRetrofit;

import javax.inject.Inject;

import okhttp3.OkHttpClient;

/**
 * GitHub auth retrofit
 * Created by spencer on 10/17/16.
 */
public class GitHubRetrofit extends BaseRetrofit {

    private static final String END_POINT = "https://api.github.com/";

    private String mUsername;
    private String mPassword;

    @Inject
    public GitHubRetrofit() {
    }

    public void setAuthInfo(String username, String password) {
        mUsername = username;
        mPassword = password;
    }

    @Override
    protected ApiEndpoint getApiEndpoint() {
        return new ApiEndpoint(END_POINT);
    }

    @Override
    protected OkHttpClient getClient() {
        return new GitHubHttpClient().get();
    }
}
