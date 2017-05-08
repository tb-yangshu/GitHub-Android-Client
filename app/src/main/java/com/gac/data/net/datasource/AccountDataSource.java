package com.gac.data.net.datasource;

import android.app.Application;

import com.gac.common.config.GitHubConfig;
import com.gac.data.bean.model.User;
import com.gac.data.net.api.AccountApi;
import com.gac.data.net.request.CreateAuthorization;
import com.gac.data.net.response.AuthorizationResp;
import com.gac.data.net.retrofit.GitHubAuthRetrofit;
import com.gac.data.net.service.AccountService;
import com.gac.data.pref.UserPref;

import javax.inject.Inject;

import rx.Observable;
import rx.functions.Func1;

/**
 * account data source
 * Created by spencer on 10/17/16.
 */
public class AccountDataSource implements AccountApi {

    @Inject
    GitHubAuthRetrofit mGitHubAuthRetrofit;

    @Inject
    Application mApplication;

    @Inject
    public AccountDataSource() {
    }

    @Override
    public Observable<User> signIn(String username, String password) {
        mGitHubAuthRetrofit.setAuthInfo(username, password);
        final AccountService accountService = mGitHubAuthRetrofit.get().create(AccountService.class);

        CreateAuthorization createAuthorization = new CreateAuthorization();
        createAuthorization.note = GitHubConfig.NOTE;
        createAuthorization.client_id = GitHubConfig.CLIENT_ID;
        createAuthorization.client_secret = GitHubConfig.CLIENT_SECRET;
        createAuthorization.scopes = GitHubConfig.SCOPES;

        return accountService.createAuthorization(createAuthorization)
                .flatMap(new Func1<AuthorizationResp, Observable<User>>() {
                    @Override
                    public Observable<User> call(AuthorizationResp authorizationResp) {
                        String token = authorizationResp.getToken();

                        UserPref.saveSignInToken(mApplication, token);

                        return accountService.getUser(token);
                    }
                });
    }
}
