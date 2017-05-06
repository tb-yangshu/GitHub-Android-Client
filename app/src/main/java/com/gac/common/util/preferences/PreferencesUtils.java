package com.gac.common.util.preferences;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;

import java.io.File;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Preferences Utils
 * Created by spencer on 16/02/2017.
 */
final class PreferencesUtils implements IPreferences {

    private static Map<String, IPreferences> sCache = new ConcurrentHashMap<>();
    private SharedPreferences mSharedPreferences;
    private String mPreferencesFileName;

    private PreferencesUtils(Context context, String preferencesFileName) {
        mPreferencesFileName = preferencesFileName;
        mSharedPreferences = context.getSharedPreferences(mPreferencesFileName, Context.MODE_PRIVATE);
    }

    static IPreferences getCache(Context context, String preferencesFileName) {
        if (!sCache.containsKey(preferencesFileName)) {
            sCache.put(preferencesFileName, new PreferencesUtils(context, preferencesFileName));
        }
        return sCache.get(preferencesFileName);
    }

    public boolean containsKey(String key) {
        return mSharedPreferences.contains(key);
    }

    public void removeKey(String key) {
        mSharedPreferences.edit().remove(key).apply();
    }

    @SuppressLint({"CommitPrefEdits", "ApplySharedPref"})
    public void removeKeyImmediately(String key) {
        mSharedPreferences.edit().remove(key).commit();
    }

    public boolean getBoolean(String key, boolean defValue) {
        return mSharedPreferences.getBoolean(key, defValue);
    }

    public void putBoolean(String key, boolean value) {
        mSharedPreferences.edit().putBoolean(key, value).apply();
    }

    @SuppressLint({"CommitPrefEdits", "ApplySharedPref"})
    public void putBooleanImmediate(String key, boolean value) {
        mSharedPreferences.edit().putBoolean(key, value).commit();
    }


    public int getInt(String key, int defValue) {
        return mSharedPreferences.getInt(key, defValue);
    }

    public void putInt(String key, int value) {
        mSharedPreferences.edit().putInt(key, value).apply();
    }

    @SuppressLint({"CommitPrefEdits", "ApplySharedPref"})
    public void putIntImmediate(String key, int value) {
        mSharedPreferences.edit().putInt(key, value).commit();
    }

    public long getLong(String key, long defValue) {
        return mSharedPreferences.getLong(key, defValue);
    }

    public void putLong(String key, long value) {
        mSharedPreferences.edit().putLong(key, value).apply();
    }

    @SuppressLint({"CommitPrefEdits", "ApplySharedPref"})
    public void putLongImmediate(String key, long value) {
        mSharedPreferences.edit().putLong(key, value).commit();
    }

    public String getString(String key) {
        return getString(key, "");
    }

    public String getString(String key, String defValue) {
        return mSharedPreferences.getString(key, defValue);
    }

    public void putString(String key, String value) {
        mSharedPreferences.edit().putString(key, value).apply();
    }

    @SuppressLint({"CommitPrefEdits", "ApplySharedPref"})
    public void putStringImmediately(String key, String value) {
        mSharedPreferences.edit().putString(key, value).commit();
    }

    public Set<String> getStringSet(String key) {
        return mSharedPreferences.getStringSet(key, new HashSet<String>());
    }

    public void putStringSet(String key, Set<String> value) {
        mSharedPreferences.edit().putStringSet(key, value).apply();
    }

    @SuppressLint({"CommitPrefEdits", "ApplySharedPref"})
    public void putStringSetImmediately(String key, Set<String> value) {
        mSharedPreferences.edit().putStringSet(key, value).commit();
    }

    public void putFloat(String key, float value) {
        mSharedPreferences.edit().putFloat(key, value).apply();
    }

    @SuppressLint({"CommitPrefEdits", "ApplySharedPref"})
    public void putFloatImmediately(String key, float value) {
        mSharedPreferences.edit().putFloat(key, value).commit();
    }

    @Override
    public float getFloat(String key, float defValue) {
        return mSharedPreferences.getFloat(key, defValue);
    }

    @Override
    public SharedPreferences getSharedPreferences() {
        return mSharedPreferences;
    }

    public void clearAll() {
        mSharedPreferences.edit().clear().apply();
    }

    @SuppressLint({"CommitPrefEdits", "ApplySharedPref"})
    public void clearAllImmediately() {
        mSharedPreferences.edit().clear().commit();
    }

    /**
     * 删除 preferences 文件
     */
    public boolean removePreferencesFile(Context context) {
        try {
            clearAll();

            PackageManager packageManager = context.getPackageManager();
            String packageName = context.getPackageName();
            PackageInfo packageInfo = packageManager.getPackageInfo(packageName, 0);
            String applicationBaseFolderPath = packageInfo.applicationInfo.dataDir;
            File sharedPrefsFolder = new File(applicationBaseFolderPath, "shared_prefs");
            File preferencesFile = new File(sharedPrefsFolder, mPreferencesFileName + ".xml");
            return preferencesFile.delete();
        } catch (Exception e) {
            return false;
        }
    }

    public long getPreferencesFileLength(Context context) {
        try {
            PackageManager packageManager = context.getPackageManager();
            String packageName = context.getPackageName();
            PackageInfo packageInfo = packageManager.getPackageInfo(packageName, 0);
            String applicationBaseFolderPath = packageInfo.applicationInfo.dataDir;
            File sharedPrefsFolder = new File(applicationBaseFolderPath, "shared_prefs");
            File preferencesFile = new File(sharedPrefsFolder, mPreferencesFileName + ".xml");
            if (preferencesFile.exists()) {
                return preferencesFile.length();
            } else {
                return 0;
            }
        } catch (PackageManager.NameNotFoundException e) {
            return 0;
        }
    }
}