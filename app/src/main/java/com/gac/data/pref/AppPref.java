package com.gac.data.pref;

import android.content.Context;

import com.gac.common.util.preferences.PreferencesFactory;

/**
 * app preference
 * Created by spencer on 10/17/16.
 */
public final class AppPref {

    private static final String KEY_IS_FIRST_RUNNING = "is_first_running";

    private AppPref() {
        // no instance.
    }

    public static void setAlreadyRun(Context context) {
        PreferencesFactory.getAppPref(context).putBoolean(KEY_IS_FIRST_RUNNING, false);
    }

    public static boolean isFirstRunning(Context context) {
        return PreferencesFactory.getAppPref(context).getBoolean(KEY_IS_FIRST_RUNNING, true);
    }

}
