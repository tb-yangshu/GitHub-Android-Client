package com.gac.data.net.api;


import com.gac.data.bean.model.User;

import rx.Observable;

/**
 * account api
 * Created by spencer on 10/17/16.
 */
public interface AccountApi {

    /**
     * login
     */
    Observable<User> signIn(String username, String password);
}
