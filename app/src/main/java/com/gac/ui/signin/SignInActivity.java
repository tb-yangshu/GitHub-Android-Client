package com.gac.ui.signin;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.Button;
import android.widget.EditText;

import com.gac.BuildConfig;
import com.gac.GACApplication;
import com.gac.R;
import com.gac.data.bean.model.User;
import com.gac.di.HasComponent;
import com.gac.di.component.AccountComponent;
import com.gac.di.component.DaggerAccountComponent;
import com.gac.di.module.AccountModule;
import com.gac.di.module.ActivityModule;
import com.gac.ui.base.BaseActivity;
import com.gac.ui.main.MainActivity;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.OnTextChanged;

import static butterknife.OnTextChanged.Callback.AFTER_TEXT_CHANGED;

/**
 * Sign In
 * Created by zhujinming on 17/5/6.
 */
public class SignInActivity
        extends BaseActivity
        implements HasComponent<AccountComponent>, SignInView {

    @BindView(R.id.et_username)
    EditText mEtUsername;
    @BindView(R.id.et_password)
    EditText mEtPassword;
    @BindView(R.id.btn_sign_in)
    Button mBtnCommit;
    @Inject
    SignInPresenter mSignInPresenter;

    public static void launch(Context context) {
        Intent intent = new Intent(context, SignInActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signin);
        ButterKnife.bind(this);

        getComponent().inject(this);

        mSignInPresenter.attachView(this);

        mEtUsername.setText(BuildConfig.TEST_GITHUB_USERNAME);
        mEtPassword.setText(BuildConfig.TEST_GITHUB_PASSWORD);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        mSignInPresenter.detachView();
        mSignInPresenter = null;
    }

    @Override
    public AccountComponent getComponent() {
        return DaggerAccountComponent.builder()
                .applicationComponent(GACApplication.get(this).getComponent())
                .activityModule(new ActivityModule(this))
                .accountModule(new AccountModule())
                .build();
    }

    @Override
    public void showLoading() {
    }

    @Override
    public void dismissLoading() {
    }

    @Override
    public void error(Throwable e) {
    }

    @Override
    public void signInSuccess(User user) {
        MainActivity.launch(this);
    }

    @Override
    public String getUsername() {
        return mEtUsername.getText().toString();
    }

    @Override
    public String getPassword() {
        return mEtPassword.getText().toString();
    }

    @OnClick(R.id.btn_sign_in)
    void signIn() {
        mSignInPresenter.signIn();
    }

    @OnTextChanged(value = R.id.et_username, callback = AFTER_TEXT_CHANGED)
    void usernameChangedListener() {
        mBtnCommit.setEnabled(mSignInPresenter.checkUsernameAvailable()
                && mSignInPresenter.checkPasswordAvailable());
    }

    @OnTextChanged(value = R.id.et_password, callback = AFTER_TEXT_CHANGED)
    void passwordChangedListener() {
        mBtnCommit.setEnabled(mSignInPresenter.checkUsernameAvailable()
                && mSignInPresenter.checkPasswordAvailable());
    }
}