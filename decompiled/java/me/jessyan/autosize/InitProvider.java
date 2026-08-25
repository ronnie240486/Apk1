package me.jessyan.autosize;

import android.app.Application;
import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import me.jessyan.autosize.utils.AutoSizeUtils;

public class InitProvider extends ContentProvider {
    @Override
    public int delete(Uri uri, String str, String[] strArr) {
        return 0;
    }

    @Override
    public String getType(Uri uri) {
        return null;
    }

    @Override
    public Uri insert(Uri uri, ContentValues contentValues) {
        return null;
    }

    @Override
    public boolean onCreate() {
        Context applicationContext = getContext().getApplicationContext();
        if (applicationContext == null) {
            applicationContext = AutoSizeUtils.getApplicationByReflect();
        }
        AutoSizeConfig.getInstance().setLog(true).init((Application) applicationContext).setUseDeviceSize(false);
        return true;
    }

    @Override
    public Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        return null;
    }

    @Override
    public int update(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        return 0;
    }
}
