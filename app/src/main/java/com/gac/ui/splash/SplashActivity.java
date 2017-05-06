package com.gac.ui.splash;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.gac.data.pref.AppPref;
import com.gac.ui.base.BaseActivity;
import com.gac.ui.introduce.IntroduceActivity;
import com.gac.ui.main.MainActivity;

/**
 * splash activity
 * Created by spencer on 10/17/16.
 */
public class SplashActivity extends BaseActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (AppPref.isFirstRunning(this)) {
            IntroduceActivity.launch(this);
        } else {
            MainActivity.launch(this);
        }

        finish();
    }
}
