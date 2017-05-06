package com.gac.data.pref;

import android.content.Context;
import android.support.annotation.Nullable;
import android.text.TextUtils;

import com.gac.R;
import com.gac.common.util.ToastUtil;
import com.gac.common.util.crypto.CryptoUtils;
import com.gac.common.util.gson.GsonUtil;
import com.gac.common.util.preferences.PreferencesFactory;
import com.gac.data.bean.model.User;
import com.gac.ui.signin.SignInActivity;

/**
 * user preference
 * Created by spencer on 10/17/16.
 */
public final class UserPref {

    private static final String KEY_SIGN_IN_TOKEN = "sign_in_token";
    private static final String KEY_SIGN_IN_USER = "sign_in_user";

    private UserPref() {
        // no instance.
    }

    public static void saveSignInToken(Context context, String userToken) {
        try {
            PreferencesFactory.getUserPref(context).putString(KEY_SIGN_IN_TOKEN, CryptoUtils.encryptByAES(userToken));
        } catch (Exception e) {
            ToastUtil.showToast(context, R.string.text_encryption_errors);
        }
    }

    @Nullable
    public static String getSignInToken(Context context) {
        try {
            return CryptoUtils.decryptByAES(PreferencesFactory.getUserPref(context).getString(KEY_SIGN_IN_TOKEN, ""));
        } catch (Exception e) {
            ToastUtil.showToast(context, R.string.text_decryption_error);
            return null;
        }
    }

    public static void saveSignInUser(Context context, User user) {
        String userJson = GsonUtil.objectToJson(user);
        try {
            PreferencesFactory.getUserPref(context).putString(KEY_SIGN_IN_USER, CryptoUtils.encryptByAES(userJson));
        } catch (Exception e) {
            ToastUtil.showToast(context, R.string.text_encryption_errors);
        }
    }

    @Nullable
    public static User getSignInUser(Context context) {
        try {
            User user = null;
            String userJson = CryptoUtils.decryptByAES(PreferencesFactory.getUserPref(context).getString(KEY_SIGN_IN_USER, ""));
            if (!TextUtils.isEmpty(userJson)) {
                user = GsonUtil.jsonToObject(userJson, User.class);
            }
            return user;
        } catch (Exception e) {
            ToastUtil.showToast(context, R.string.text_decryption_error);
            return null;
        }
    }

    public static void removeSignInUser(Context context) {
        PreferencesFactory.getUserPref(context).removeKey(KEY_SIGN_IN_USER);
    }

    public static boolean isSignIn(Context context) {
        return getSignInUser(context) != null && !TextUtils.isEmpty(getSignInToken(context));
    }

    public static boolean checkSignIn(Context context) {
        if (!isSignIn(context)) {
            SignInActivity.launch(context);
            return false;
        }
        return true;
    }

    public static boolean isSelf(Context context, String username) {
        User user = getSignInUser(context);
        return user != null
                && !TextUtils.isEmpty(getSignInToken(context))
                && !TextUtils.isEmpty(username)
                && username.equals(user.getLogin());
    }

}
