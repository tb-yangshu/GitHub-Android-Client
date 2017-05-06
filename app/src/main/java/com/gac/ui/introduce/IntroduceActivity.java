package com.gac.ui.introduce;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;

import com.gac.R;
import com.github.paolorotolo.appintro.AppIntro;
import com.github.paolorotolo.appintro.AppIntroFragment;

/**
 * introduce activity
 * Created by spencer on 10/17/16.
 */
public class IntroduceActivity extends AppIntro {

    public static void launch(Context context) {
        context.startActivity(new Intent(context, IntroduceActivity.class));
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        addSlideFragment();
    }

    private void addSlideFragment() {
        addSlide(AppIntroFragment.newInstance(getString(R.string.intro_title),
                getString(R.string.intro_desc),
                R.drawable.ic_slide,
                getResources().getColor(R.color.white),
                getResources().getColor(R.color.blue_grey),
                getResources().getColor(R.color.blue_grey)));

        addSlide(EndIntroSlideFragment.newInstance());

        setProgressButtonEnabled(false);
    }
}
