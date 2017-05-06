package com.gac.common.util;

import android.content.Context;
import android.support.annotation.StringRes;
import android.widget.Toast;

/**
 * toast util
 * Created by spencer on 5/6/17.
 */
public final class ToastUtil {

    private ToastUtil() {
        // no instance.
    }

    public static void showToast(Context context, String message) {
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show();
    }

    public static void showToast(Context context, @StringRes int resId) {
        Toast.makeText(context, resId, Toast.LENGTH_SHORT).show();
    }
}
