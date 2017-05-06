package com.gac.ui.signin;

import com.gac.data.bean.model.User;
import com.gac.mvp.lce.LoadView;

/**
 * Sign In View
 * Created by spencer on 5/6/17.
 */
interface SignInView extends LoadView {

    void signInSuccess(User user);

    String getUsername();

    String getPassword();
}
