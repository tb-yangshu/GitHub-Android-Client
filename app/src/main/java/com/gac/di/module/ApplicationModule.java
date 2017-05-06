package com.gac.di.module;

import android.app.Application;
import android.content.Context;

import com.gac.di.ApplicationContext;

import dagger.Module;
import dagger.Provides;

/**
 * application module
 * Created by spencer on 10/17/16.
 */
@Module
public class ApplicationModule {

    private final Application mApplication;

    public ApplicationModule(Application application) {
        mApplication = application;
    }

    @Provides
    Application provideApplication() {
        return mApplication;
    }

    @Provides
    @ApplicationContext
    Context provideContext() {
        return mApplication;
    }

}
