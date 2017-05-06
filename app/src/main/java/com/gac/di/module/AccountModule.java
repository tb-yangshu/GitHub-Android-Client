package com.gac.di.module;


import com.gac.data.net.api.AccountApi;
import com.gac.data.net.datasource.AccountDataSource;

import dagger.Module;
import dagger.Provides;

/**
 * account module
 * Created by spencer on 10/17/16.
 */
@Module
public class AccountModule {

    @Provides
    AccountApi provideAccountApi(AccountDataSource accountDataSource) {
        return accountDataSource;
    }
}