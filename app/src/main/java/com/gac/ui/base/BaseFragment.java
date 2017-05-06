package com.gac.ui.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.trello.rxlifecycle.components.support.RxFragment;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * base fragment
 * Created by spencer on 5/6/17.
 */
public abstract class BaseFragment extends RxFragment {

    private Unbinder mBind;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(getLayoutResId(), container, false);
        mBind = ButterKnife.bind(this, rootView);
        return rootView;
    }

    public abstract int getLayoutResId();

    @Override
    public void onDestroyView() {
        super.onDestroyView();

        if (mBind != null) {
            mBind.unbind();
        }
    }
}