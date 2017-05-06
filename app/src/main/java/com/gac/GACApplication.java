package com.gac;

import android.app.Application;
import android.content.Context;

import com.gac.di.component.ApplicationComponent;
import com.gac.di.component.DaggerApplicationComponent;
import com.gac.di.module.ApplicationModule;
import com.github.moduth.blockcanary.BlockCanary;
import com.github.moduth.blockcanary.BlockCanaryContext;
import com.squareup.leakcanary.LeakCanary;

/**
 * Android GitHub Client Application
 * Created by spencer on 31/01/2017.
 */

public class GACApplication extends Application {

    ApplicationComponent mApplicationComponent;

    public static GACApplication get(Context context) {
        return (GACApplication) context.getApplicationContext();
    }

    public ApplicationComponent getComponent() {
        if (mApplicationComponent == null) {
            mApplicationComponent = DaggerApplicationComponent.builder().applicationModule(new ApplicationModule(this)).build();
        }
        return mApplicationComponent;
    }

    public void setComponent(ApplicationComponent applicationComponent) {
        mApplicationComponent = applicationComponent;
    }

    @Override
    public void onCreate() {
        super.onCreate();

        LeakCanary.install(this);

        BlockCanary.install(this, new BlockCanaryContext()).start();
    }
}
