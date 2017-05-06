package com.gac.di.component;


import com.gac.di.PerActivity;
import com.gac.di.module.AccountModule;
import com.gac.di.module.ActivityModule;
import com.gac.ui.signin.SignInActivity;

import dagger.Component;

/**
 * Account Component
 * Created by spencer on 10/17/16.
 */
@PerActivity
@Component(dependencies = ApplicationComponent.class,
        modules = {ActivityModule.class, AccountModule.class})
public interface AccountComponent extends ActivityComponent {

    void inject(SignInActivity signInActivity);
}