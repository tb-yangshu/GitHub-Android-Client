package com.gac.common.util.gson;

import android.text.TextUtils;

import com.google.gson.Gson;

import java.util.List;

/**
 * Gson Util
 * Created by spencer on 5/6/17.
 */
public final class GsonUtil {

    private static final Gson GSON = new Gson();

    private GsonUtil() {
        // no instance.
    }

    /**
     * object converter String
     *
     * @param t   t
     * @param <T> t
     * @return json
     */
    public static <T> String objectToJson(T t) {
        if (t == null) {
            throw new IllegalArgumentException("Object can not null");
        }
        return GSON.toJson(t);
    }


    /**
     * string converter object
     *
     * @param json   json
     * @param clazzT converter to class
     * @param <T>    t
     * @return object
     */
    public static <T> T jsonToObject(String json, Class<T> clazzT) {
        if (TextUtils.isEmpty(json) || clazzT == null) {
            throw new IllegalArgumentException("Json can not null!");
        }
        return GSON.fromJson(json, clazzT);
    }

    /**
     * json converter list
     *
     * @param json   json
     * @param classT List of generic type needs such as: List T, classT parameters in place, fill T.class
     * @param <T>    t
     * @return List T t
     */
    public static <T> List<T> jsonToObjectList(String json, Class<T> classT) {
        if (TextUtils.isEmpty(json) || classT == null) {
            throw new IllegalArgumentException("Json can not null!");
        }
        return GSON.fromJson(json, new ListOfSomething<>(classT));
    }
}
