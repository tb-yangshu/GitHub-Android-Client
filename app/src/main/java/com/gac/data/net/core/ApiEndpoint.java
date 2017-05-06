package com.gac.data.net.core;

/**
 * api endpoint
 * Created by spencer on 10/17/16.
 */
public class ApiEndpoint {

    private String mApiEndpoint;

    public ApiEndpoint(String apiEndpoint) {
        mApiEndpoint = apiEndpoint;
    }

    public String getApiEndpoint() {
        return mApiEndpoint;
    }

    public void setApiEndpoint(String apiEndpoint) {
        mApiEndpoint = apiEndpoint;
    }
}
