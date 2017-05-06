package com.gac.ui.main;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import com.gac.R;
import com.gac.data.pref.AppPref;
import com.gac.ui.base.BaseActivity;

import butterknife.ButterKnife;

public class MainActivity extends BaseActivity {

    public static void launch(Context context) {
        Intent intent = new Intent(context, MainActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        if (AppPref.isFirstRunning(this)) {
            AppPref.setAlreadyRun(this);
        }
    }

}