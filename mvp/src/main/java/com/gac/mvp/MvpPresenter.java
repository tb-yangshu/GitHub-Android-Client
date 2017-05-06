package com.gac.mvp;

import android.support.annotation.UiThread;

/**
 * mvp presenter
 * Created by spencer on 10/17/16.
 */
public interface MvpPresenter<V> {

    /**
     * Set or attach the view to this presenter
     */
    @UiThread
    void attachView(V mvpView);

    /**
     * Will be called if the view has been destroyed. Typically this method will be invoked from
     * <code>Activity.detachView()</code> or <code>Fragment.onDestroyView()</code>
     */
    @UiThread
    void detachView();

}
