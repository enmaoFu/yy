package com.yy;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.springframework.lang.NonNull;
import org.springframework.util.StringUtils;

import java.io.Reader;
import java.lang.reflect.Type;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class GsonUtils {

    private static final String KEY_DEFAULT   = "defaultGson";
    private static final String KEY_DELEGATE  = "delegateGson";

    private static final Map<String, Gson> GSONS = new ConcurrentHashMap<>();

    private GsonUtils() {
        throw new UnsupportedOperationException("u can't instantiate me...");
    }

    /**
     * 设置默认的 Gson 代理对象
     * @param delegate
     */
    public static void setGsonDelegate(Gson delegate) {
        if (delegate == null) return;
        GSONS.put(KEY_DELEGATE, delegate);
    }

    /**
     * 设置 Gson 对象
     * @param key
     * @param gson
     */
    public static void setGson(final String key, final Gson gson) {
        if (StringUtils.isEmpty(key) || gson == null) return;
        GSONS.put(key, gson);
    }

    /**
     * 获取 Gson 对象
     * @param key
     * @return
     */
    public static Gson getGson(final String key) {
        return GSONS.get(key);
    }

    /**
     * 获取 Gson 对象
     * @return
     */
    public static Gson getGson() {
        Gson gsonDelegate = GSONS.get(KEY_DELEGATE);
        if (gsonDelegate != null) {
            return gsonDelegate;
        }
        Gson gsonDefault = GSONS.get(KEY_DEFAULT);
        if (gsonDefault == null) {
            gsonDefault = createGson();
            GSONS.put(KEY_DEFAULT, gsonDefault);
        }
        return gsonDefault;
    }

    /**
     * 对象转 Json 串
     * @param object
     * @return
     */
    public static String toJson(final Object object) {
        return toJson(getGson(), object);
    }

    /**
     * 对象转 Json 串
     * @param src
     * @param typeOfSrc
     * @return
     */
    public static String toJson(final Object src, @NonNull final Type typeOfSrc) {
        return toJson(getGson(), src, typeOfSrc);
    }

    /**
     * 对象转 Json 串
     * @param gson
     * @param object
     * @return
     */
    public static String toJson(@NonNull final Gson gson, final Object object) {
        return gson.toJson(object);
    }

    /**
     * 对象转 Json 串
     * @param gson
     * @param src
     * @param typeOfSrc
     * @return
     */
    public static String toJson(@NonNull final Gson gson, final Object src, @NonNull final Type typeOfSrc) {
        return gson.toJson(src, typeOfSrc);
    }

    /**
     * Json 串转对象
     * @param json
     * @param type
     * @param <T>
     * @return
     */
    public static <T> T fromJson(final String json, @NonNull final Class<T> type) {
        return fromJson(getGson(), json, type);
    }

    /**
     * Json 串转对象
     * @param json
     * @param type
     * @param <T>
     * @return
     */
    public static <T> T fromJson(final String json, @NonNull final Type type) {
        return fromJson(getGson(), json, type);
    }

    /**
     * Json 串转对象
     * @param reader
     * @param type
     * @param <T>
     * @return
     */
    public static <T> T fromJson(@NonNull final Reader reader, @NonNull final Class<T> type) {
        return fromJson(getGson(), reader, type);
    }

    /**
     * Json 串转对象
     * @param reader
     * @param type
     * @param <T>
     * @return
     */
    public static <T> T fromJson(@NonNull final Reader reader, @NonNull final Type type) {
        return fromJson(getGson(), reader, type);
    }

    /**
     * Json 串转对象
     * @param gson
     * @param json
     * @param type
     * @param <T>
     * @return
     */
    public static <T> T fromJson(@NonNull final Gson gson, final String json, @NonNull final Class<T> type) {
        return gson.fromJson(json, type);
    }

    /**
     * Json 串转对象
     * @param gson
     * @param json
     * @param type
     * @param <T>
     * @return
     */
    public static <T> T fromJson(@NonNull final Gson gson, final String json, @NonNull final Type type) {
        return gson.fromJson(json, type);
    }

    /**
     * Json 串转对象
     * @param gson
     * @param reader
     * @param type
     * @param <T>
     * @return
     */
    public static <T> T fromJson(@NonNull final Gson gson, final Reader reader, @NonNull final Class<T> type) {
        return gson.fromJson(reader, type);
    }

    /**
     * Json 串转对象
     * @param gson
     * @param reader
     * @param type
     * @param <T>
     * @return
     */
    public static <T> T fromJson(@NonNull final Gson gson, final Reader reader, @NonNull final Type type) {
        return gson.fromJson(reader, type);
    }

    private static Gson createGson() {
        return new GsonBuilder().serializeNulls().disableHtmlEscaping().create();
    }

}
