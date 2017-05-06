package com.gac.di.module;

import android.app.Activity;
import android.app.Fragment;
import android.content.Context;

import com.gac.di.ActivityContext;

import dagger.Module;
import dagger.Provides;

/**
 * activity module
 * Created by spencer on 10/17/16.
 */
@Module
public class ActivityModule {

    private final Activity mActivity;

    public ActivityModule(Activity activity) {
        mActivity = activity;
    }

    public ActivityModule(Fragment fragment) {
        mActivity = fragment.getActivity();
    }

    @Provides
    Activity provideActivity() {
        return mActivity;
    }

    @Provides
    @ActivityContext
    Context providesContext() {
        return mActivity;
    }
}
