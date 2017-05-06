package com.gac.ui.introduce;

import android.widget.Button;
import android.widget.TextView;

import com.gac.R;
import com.gac.ui.base.BaseFragment;
import com.gac.ui.main.MainActivity;
import com.gac.ui.signin.SignInActivity;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * end intro slide fragment
 * Created by spencer on 5/6/17.
 */
public class EndIntroSlideFragment extends BaseFragment {

    @BindView(R.id.btn_sign_in)
    Button mBtnSignIn;
    @BindView(R.id.tv_look_around)
    TextView mTvLookAround;

    public static EndIntroSlideFragment newInstance() {
        return new EndIntroSlideFragment();
    }

    @Override
    public int getLayoutResId() {
        return R.layout.fragment_end_intro_slide;
    }

    @OnClick(R.id.btn_sign_in)
    public void signIn() {
        SignInActivity.launch(getActivity());
    }

    @OnClick(R.id.tv_look_around)
    public void lookAround() {
        MainActivity.launch(getActivity());
    }
}
