package com.gac.di.component;

import android.app.Activity;

import com.gac.di.PerActivity;
import com.gac.di.module.ActivityModule;

import dagger.Component;

/**
 * activity component
 * Created by spencer on 10/17/16.
 */
@PerActivity
@Component(dependencies = ApplicationComponent.class, modules = {ActivityModule.class})
public interface ActivityComponent {

    Activity activity();

}
