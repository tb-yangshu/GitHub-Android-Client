package com.gac.presenter;


import com.gac.mvp.BaseMvpPresenter;
import com.gac.mvp.MvpView;

import rx.subscriptions.CompositeSubscription;

/**
 * rx mvp presenter
 * Created by spencer on 10/17/16.
 */
public class RxMvpPresenter<V extends MvpView> extends BaseMvpPresenter<V> {

    protected CompositeSubscription mCompositeSubscription;

    @Override
    public void attachView(V mvpView) {
        super.attachView(mvpView);

        mCompositeSubscription = new CompositeSubscription();
    }

    @Override
    public void detachView() {
        super.detachView();

        mCompositeSubscription.clear();
        mCompositeSubscription = null;
    }
}
