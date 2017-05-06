package com.gac.data.net.service;


import com.gac.data.bean.model.User;
import com.gac.data.net.request.CreateAuthorization;
import com.gac.data.net.response.AuthorizationResp;

import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;
import rx.Observable;

/**
 * account service
 * Created by spencer on 10/17/16.
 */
public interface AccountService {

    @POST("/authorizations")
    Observable<AuthorizationResp> createAuthorization(@Body CreateAuthorization createAuthorization);

    @GET("/user")
    Observable<User> getUser(@Query("access_token") String accessToken);
}
