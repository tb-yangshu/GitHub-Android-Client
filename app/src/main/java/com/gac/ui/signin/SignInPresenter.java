package com.gac.ui.signin;

import android.app.Application;
import android.text.TextUtils;

import com.gac.data.net.api.AccountApi;
import com.gac.data.pref.UserPref;
import com.gac.presenter.RxMvpPresenter;

import javax.inject.Inject;

import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Sign In Presenter
 * Created by spencer on 5/6/17.
 */
public class SignInPresenter extends RxMvpPresenter<SignInView> {

    private final AccountApi mAccountApi;

    @Inject
    Application mApplication;

    @Inject
    public SignInPresenter(AccountApi accountApi) {
        mAccountApi = accountApi;
    }

    public void signIn() {
        if (!checkUsernameAvailable() || !checkPasswordAvailable()) {
            return;
        }

        mCompositeSubscription.add(mAccountApi.signIn(getMvpView().getUsername(), getMvpView().getPassword())
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .doOnSubscribe(() -> getMvpView().showLoading())
                .doOnTerminate(() -> getMvpView().dismissLoading())
                .subscribe(user -> {
                            UserPref.saveSignInUser(mApplication, user);
                            getMvpView().signInSuccess(user);
                        }, throwable -> getMvpView().error(throwable)
                ));
    }

    public boolean checkPasswordAvailable() {
        return !TextUtils.isEmpty(getMvpView().getUsername());
    }

    public boolean checkUsernameAvailable() {
        return !TextUtils.isEmpty(getMvpView().getPassword());
    }
}
