package com.wang.utils;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.Objects;

public class JsonUtils {
    private static Gson mGson;

    public static <T> T stringToObject(String json, Class<T> cls) {
        if (mGson == null) {
            mGson = new Gson();
        }
        if (Objects.isNull(json)) {
            return null;
        }

        T obj = mGson.fromJson(json, cls);
        if (Objects.isNull(obj)) {
            return null;
        } else {
            return obj;
        }

    }


    public static <T> String objectToJson(T fromClass) {
        if (mGson == null) {
            mGson = new Gson();
        }
        if (Objects.isNull(fromClass)) {
            return null;
        }
        String json = mGson.toJson(fromClass);

        if (Objects.isNull(json)) {
            return null;
        } else {
            return json;
        }
    }
}
