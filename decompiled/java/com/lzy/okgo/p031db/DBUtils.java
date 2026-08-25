package com.lzy.okgo.p031db;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.lzy.okgo.utils.OkLogger;

public class DBUtils {
    public static boolean isFieldExists(SQLiteDatabase sQLiteDatabase, String str, String str2) {
        boolean z7 = false;
        if (str == null || sQLiteDatabase == null || str2 == null || !sQLiteDatabase.isOpen()) {
            return false;
        }
        Cursor cursorRawQuery = null;
        try {
            try {
                cursorRawQuery = sQLiteDatabase.rawQuery("SELECT * FROM " + str + " LIMIT 0", null);
                if (cursorRawQuery != null && cursorRawQuery.getColumnIndex(str2) != -1) {
                    z7 = true;
                }
                return z7;
            } catch (Exception e5) {
                OkLogger.printStackTrace(e5);
                return false;
            }
        } finally {
            if (cursorRawQuery != null) {
                cursorRawQuery.close();
            }
        }
    }

    public static boolean isNeedUpgradeTable(SQLiteDatabase sQLiteDatabase, TableEntity tableEntity) {
        if (!isTableExists(sQLiteDatabase, tableEntity.tableName)) {
            return true;
        }
        Cursor cursorRawQuery = sQLiteDatabase.rawQuery("select * from " + tableEntity.tableName, null);
        if (cursorRawQuery == null) {
            return false;
        }
        try {
            int columnCount = tableEntity.getColumnCount();
            if (columnCount != cursorRawQuery.getColumnCount()) {
                return true;
            }
            for (int i6 = 0; i6 < columnCount; i6++) {
                if (tableEntity.getColumnIndex(cursorRawQuery.getColumnName(i6)) == -1) {
                    return true;
                }
            }
            return false;
        } finally {
            cursorRawQuery.close();
        }
    }

    public static boolean isTableExists(SQLiteDatabase sQLiteDatabase, String str) {
        int i6;
        if (str == null || sQLiteDatabase == null || !sQLiteDatabase.isOpen()) {
            return false;
        }
        Cursor cursorRawQuery = null;
        try {
            try {
                cursorRawQuery = sQLiteDatabase.rawQuery("SELECT COUNT(*) FROM sqlite_master WHERE type = ? AND name = ?", new String[]{"table", str});
                if (!cursorRawQuery.moveToFirst()) {
                    cursorRawQuery.close();
                    return false;
                }
                i6 = cursorRawQuery.getInt(0);
                cursorRawQuery.close();
            } catch (Exception e5) {
                OkLogger.printStackTrace(e5);
                if (cursorRawQuery != null) {
                    cursorRawQuery.close();
                }
                i6 = 0;
            }
            return i6 > 0;
        } catch (Throwable th) {
            if (cursorRawQuery != null) {
                cursorRawQuery.close();
            }
            throw th;
        }
    }
}
