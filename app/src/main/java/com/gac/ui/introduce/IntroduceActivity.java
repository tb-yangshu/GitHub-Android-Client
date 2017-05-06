package com.gac.ui.introduce;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.Button;

import com.gac.R;
import com.gac.ui.base.BaseActivity;
import com.gac.ui.main.MainActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * introduce activity
 * Created by spencer on 10/17/16.
 */
public class IntroduceActivity extends BaseActivity {

    @BindView(R.id.btn_jump_to_main)
    Button mBtnJumpToMain;

    public static void launch(Context context) {
        context.startActivity(new Intent(context, IntroduceActivity.class));
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_introduce);
        ButterKnife.bind(this);
    }


    @OnClick(R.id.btn_jump_to_main)
    void jumpToMain() {
        MainActivity.launch(this);
        finish();
    }
}
