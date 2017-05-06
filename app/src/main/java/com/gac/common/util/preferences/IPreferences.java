package com.gac.common.util.preferences;

import android.content.Context;
import android.content.SharedPreferences;

import java.util.Set;

/**
 * Preferences action interface
 * Created by spencer on 16/02/2017.
 */
public interface IPreferences {

    boolean containsKey(String key);

    void removeKey(String key);

    void removeKeyImmediately(String key);

    boolean getBoolean(String key, boolean defValue);

    void putBoolean(String key, boolean value);

    void putBooleanImmediate(String key, boolean value);

    int getInt(String key, int defValue);

    void putInt(String key, int value);

    void putIntImmediate(String key, int value);

    long getLong(String key, long defValue);

    void putLong(String key, long value);

    void putLongImmediate(String key, long value);

    String getString(String key);

    String getString(String key, String defValue);

    void putString(String key, String value);

    void putStringImmediately(String key, String value);

    Set<String> getStringSet(String key);

    void putStringSet(String key, Set<String> value);

    void putStringSetImmediately(String key, Set<String> value);

    void putFloat(String key, float value);

    void putFloatImmediately(String key, float value);

    float getFloat(String key, float defValue);

    SharedPreferences getSharedPreferences();

    void clearAll();

    void clearAllImmediately();

    boolean removePreferencesFile(Context context);

    long getPreferencesFileLength(Context context);
}
