package com.gac.common.util.preferences;

import android.content.Context;

/**
 * preferences factory
 * Created by spencer on 5/6/17.
 */
public final class PreferencesFactory {

    private PreferencesFactory() {
        // no instance.
    }

    /**
     * user logout, not remove config data.
     */
    public static IPreferences getExitNotRemovePreferences(Context context) {
        return PreferencesUtils.getCache(context, "common_config");
    }

    /**
     * user logout, remove config data.
     */
    public static IPreferences getExitRemovePreferences(Context context) {
        return PreferencesUtils.getCache(context, "config");
    }

    /**
     * user data pref
     */
    public static IPreferences getUserPref(Context context) {
        return PreferencesUtils.getCache(context, "user_pref");
    }

    /**
     * app data pref
     */
    public static IPreferences getAppPref(Context context) {
        return PreferencesUtils.getCache(context, "app_pref");
    }
}
