package com.gac.mvp.lce;

import android.support.annotation.UiThread;

import com.gac.mvp.MvpView;

/**
 * lce view
 * Created by spencer on 10/17/16.
 */
public interface LceView<M> extends MvpView {

    @UiThread
    void showLoading();

    @UiThread
    void dismissLoading();

    @UiThread
    void showContent(M data);

    @UiThread
    void showError(Throwable e);

    @UiThread
    void showEmpty();

}
