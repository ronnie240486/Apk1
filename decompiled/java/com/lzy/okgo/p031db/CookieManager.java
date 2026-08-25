package com.lzy.okgo.p031db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import com.lzy.okgo.cookie.SerializableCookie;

public class CookieManager extends BaseDao<SerializableCookie> {
    private static Context context;
    private static volatile CookieManager instance;

    private CookieManager() {
        super(new DBHelper(context));
    }

    public static CookieManager getInstance() {
        if (instance == null) {
            synchronized (CookieManager.class) {
                try {
                    if (instance == null) {
                        instance = new CookieManager();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return instance;
    }

    public static void init(Context context2) {
        context = context2;
    }

    @Override
    public String getTableName() {
        return SerializableCookie.COOKIE;
    }

    @Override
    public ContentValues getContentValues(SerializableCookie serializableCookie) {
        return SerializableCookie.getContentValues(serializableCookie);
    }

    @Override
    public SerializableCookie parseCursorToBean(Cursor cursor) {
        return SerializableCookie.parseCursorToBean(cursor);
    }

    @Override
    public void unInit() {
    }
}
