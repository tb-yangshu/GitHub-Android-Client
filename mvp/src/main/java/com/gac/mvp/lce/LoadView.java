package com.gac.mvp.lce;

import android.support.annotation.UiThread;

import com.gac.mvp.MvpView;


/**
 * load view
 * Created by spencer on 10/17/16.
 */
public interface LoadView extends MvpView {

    @UiThread
    void showLoading();

    @UiThread
    void dismissLoading();

    @UiThread
    void error(Throwable e);

}
