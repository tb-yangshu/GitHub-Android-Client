package com.gac.di.component;

import android.app.Application;
import android.content.Context;

import com.gac.di.ApplicationContext;
import com.gac.di.module.ApplicationModule;

import javax.inject.Singleton;

import dagger.Component;

/**
 * application component
 * Created by spencer on 10/17/16.
 */
@Singleton
@Component(modules = ApplicationModule.class)
public interface ApplicationComponent {

    @ApplicationContext
    Context context();

    Application application();
}
