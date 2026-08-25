package com.lzy.okgo.p031db;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Pair;
import androidx.media3.extractor.metadata.icy.IcyHeaders;
import com.lzy.okgo.utils.OkLogger;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.locks.Lock;
import p000a.AbstractC0004e;

public abstract class BaseDao<T> {
    protected static String TAG;
    protected SQLiteDatabase database;
    protected SQLiteOpenHelper helper;
    protected Lock lock;

    public interface Action {
        void call(SQLiteDatabase sQLiteDatabase);
    }

    public BaseDao(SQLiteOpenHelper sQLiteOpenHelper) {
        TAG = getClass().getSimpleName();
        this.lock = DBHelper.lock;
        this.helper = sQLiteOpenHelper;
        this.database = openWriter();
    }

    public final void closeDatabase(SQLiteDatabase sQLiteDatabase, Cursor cursor) {
        if (cursor != null && !cursor.isClosed()) {
            cursor.close();
        }
        if (sQLiteDatabase == null || !sQLiteDatabase.isOpen()) {
            return;
        }
        sQLiteDatabase.close();
    }

    public boolean delete(String str, String[] strArr) {
        SQLiteDatabase sQLiteDatabase;
        Lock lock;
        String str2;
        StringBuilder sb;
        long jCurrentTimeMillis = System.currentTimeMillis();
        this.lock.lock();
        try {
            this.database.beginTransaction();
            this.database.delete(getTableName(), str, strArr);
            this.database.setTransactionSuccessful();
            return true;
        } catch (Exception e5) {
            OkLogger.printStackTrace(e5);
            return false;
        } finally {
            this.database.endTransaction();
            this.lock.unlock();
            AbstractC0004e.m1A(jCurrentTimeMillis, new StringBuilder(), " delete", TAG);
        }
    }

    public boolean deleteAll() {
        return delete(null, null);
    }

    public boolean deleteList(List<Pair<String, String[]>> list) {
        SQLiteDatabase sQLiteDatabase;
        Lock lock;
        String str;
        StringBuilder sb;
        long jCurrentTimeMillis = System.currentTimeMillis();
        this.lock.lock();
        try {
            this.database.beginTransaction();
            for (Pair<String, String[]> pair : list) {
                this.database.delete(getTableName(), (String) pair.first, (String[]) pair.second);
            }
            this.database.setTransactionSuccessful();
            return true;
        } catch (Exception e5) {
            OkLogger.printStackTrace(e5);
            return false;
        } finally {
            this.database.endTransaction();
            this.lock.unlock();
            AbstractC0004e.m1A(jCurrentTimeMillis, new StringBuilder(), " deleteList", TAG);
        }
    }

    public abstract ContentValues getContentValues(T t5);

    public abstract String getTableName();

    public boolean insert(T t5) {
        if (t5 == null) {
            return false;
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        this.lock.lock();
        try {
            this.database.beginTransaction();
            this.database.insert(getTableName(), null, getContentValues(t5));
            this.database.setTransactionSuccessful();
            return true;
        } catch (Exception e5) {
            OkLogger.printStackTrace(e5);
            return false;
        } finally {
            this.database.endTransaction();
            this.lock.unlock();
            AbstractC0004e.m1A(jCurrentTimeMillis, new StringBuilder(), " insertT", TAG);
        }
    }

    public SQLiteDatabase openReader() {
        return this.helper.getReadableDatabase();
    }

    public SQLiteDatabase openWriter() {
        return this.helper.getWritableDatabase();
    }

    public abstract T parseCursorToBean(Cursor cursor);

    public List<T> query(SQLiteDatabase sQLiteDatabase, String str, String[] strArr) {
        return query(sQLiteDatabase, null, str, strArr, null, null, null, null);
    }

    public List<T> queryAll(SQLiteDatabase sQLiteDatabase) {
        return query(sQLiteDatabase, null, null);
    }

    public T queryOne(SQLiteDatabase sQLiteDatabase, String str, String[] strArr) throws Throwable {
        List<T> listQuery = query(sQLiteDatabase, null, str, strArr, null, null, null, IcyHeaders.REQUEST_HEADER_ENABLE_METADATA_VALUE);
        if (listQuery.size() > 0) {
            return listQuery.get(0);
        }
        return null;
    }

    public boolean replace(T t5) {
        if (t5 == null) {
            return false;
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        this.lock.lock();
        try {
            this.database.beginTransaction();
            this.database.replace(getTableName(), null, getContentValues(t5));
            this.database.setTransactionSuccessful();
            return true;
        } catch (Exception e5) {
            OkLogger.printStackTrace(e5);
            return false;
        } finally {
            this.database.endTransaction();
            this.lock.unlock();
            AbstractC0004e.m1A(jCurrentTimeMillis, new StringBuilder(), " replaceT", TAG);
        }
    }

    public void startTransaction(Action action) {
        this.lock.lock();
        try {
            try {
                this.database.beginTransaction();
                action.call(this.database);
                this.database.setTransactionSuccessful();
            } catch (Exception e5) {
                OkLogger.printStackTrace(e5);
            }
        } finally {
            this.database.endTransaction();
            this.lock.unlock();
        }
    }

    public abstract void unInit();

    public boolean update(T t5, String str, String[] strArr) {
        if (t5 == null) {
            return false;
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        this.lock.lock();
        try {
            this.database.beginTransaction();
            this.database.update(getTableName(), getContentValues(t5), str, strArr);
            this.database.setTransactionSuccessful();
            return true;
        } catch (Exception e5) {
            OkLogger.printStackTrace(e5);
            return false;
        } finally {
            this.database.endTransaction();
            this.lock.unlock();
            AbstractC0004e.m1A(jCurrentTimeMillis, new StringBuilder(), " updateT", TAG);
        }
    }

    public long deleteAll(SQLiteDatabase sQLiteDatabase) {
        return delete(sQLiteDatabase, null, null);
    }

    public List<T> query(SQLiteDatabase sQLiteDatabase, String[] strArr, String str, String[] strArr2, String str2, String str3, String str4, String str5) throws Throwable {
        Cursor cursorQuery;
        ArrayList arrayList = new ArrayList();
        try {
            try {
                cursorQuery = sQLiteDatabase.query(getTableName(), strArr, str, strArr2, str2, str3, str4, str5);
                while (!cursorQuery.isClosed() && cursorQuery.moveToNext()) {
                    try {
                        arrayList.add(parseCursorToBean(cursorQuery));
                    } catch (Exception e5) {
                        e = e5;
                        OkLogger.printStackTrace(e);
                    }
                }
            } catch (Throwable th) {
                th = th;
                closeDatabase(null, null);
                throw th;
            }
        } catch (Exception e10) {
            e = e10;
            cursorQuery = null;
        } catch (Throwable th2) {
            th = th2;
            closeDatabase(null, null);
            throw th;
        }
        closeDatabase(null, cursorQuery);
        return arrayList;
    }

    public List<T> queryAll() {
        return query(null, null);
    }

    public T queryOne(String str, String[] strArr) throws Throwable {
        long jCurrentTimeMillis = System.currentTimeMillis();
        List<T> listQuery = query(null, str, strArr, null, null, null, IcyHeaders.REQUEST_HEADER_ENABLE_METADATA_VALUE);
        AbstractC0004e.m1A(jCurrentTimeMillis, new StringBuilder(), " queryOne", TAG);
        if (listQuery.size() > 0) {
            return listQuery.get(0);
        }
        return null;
    }

    public List<T> query(String str, String[] strArr) {
        return query(null, str, strArr, null, null, null, null);
    }

    public List<T> query(String[] strArr, String str, String[] strArr2, String str2, String str3, String str4, String str5) throws Throwable {
        Cursor cursorQuery;
        String str6;
        StringBuilder sb;
        long jCurrentTimeMillis = System.currentTimeMillis();
        this.lock.lock();
        ArrayList arrayList = new ArrayList();
        try {
            try {
                this.database.beginTransaction();
                cursorQuery = this.database.query(getTableName(), strArr, str, strArr2, str2, str3, str4, str5);
                while (!cursorQuery.isClosed() && cursorQuery.moveToNext()) {
                    try {
                        arrayList.add(parseCursorToBean(cursorQuery));
                    } catch (Exception e5) {
                        e = e5;
                        OkLogger.printStackTrace(e);
                        closeDatabase(null, cursorQuery);
                        this.database.endTransaction();
                        this.lock.unlock();
                        str6 = TAG;
                        sb = new StringBuilder();
                    }
                }
                this.database.setTransactionSuccessful();
                closeDatabase(null, cursorQuery);
                this.database.endTransaction();
                this.lock.unlock();
                str6 = TAG;
                sb = new StringBuilder();
            } catch (Throwable th) {
                th = th;
                closeDatabase(null, null);
                this.database.endTransaction();
                this.lock.unlock();
                AbstractC0004e.m1A(jCurrentTimeMillis, new StringBuilder(), " query", TAG);
                throw th;
            }
        } catch (Exception e10) {
            e = e10;
            cursorQuery = null;
        } catch (Throwable th2) {
            th = th2;
            closeDatabase(null, null);
            this.database.endTransaction();
            this.lock.unlock();
            AbstractC0004e.m1A(jCurrentTimeMillis, new StringBuilder(), " query", TAG);
            throw th;
        }
        AbstractC0004e.m1A(jCurrentTimeMillis, sb, " query", str6);
        return arrayList;
    }

    public long delete(SQLiteDatabase sQLiteDatabase, String str, String[] strArr) {
        return sQLiteDatabase.delete(getTableName(), str, strArr);
    }

    public long insert(SQLiteDatabase sQLiteDatabase, T t5) {
        return sQLiteDatabase.insert(getTableName(), null, getContentValues(t5));
    }

    public long replace(SQLiteDatabase sQLiteDatabase, T t5) {
        return sQLiteDatabase.replace(getTableName(), null, getContentValues(t5));
    }

    public long update(SQLiteDatabase sQLiteDatabase, T t5, String str, String[] strArr) {
        return sQLiteDatabase.update(getTableName(), getContentValues(t5), str, strArr);
    }

    public boolean insert(List<T> list) {
        if (list == null) {
            return false;
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        this.lock.lock();
        try {
            this.database.beginTransaction();
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                this.database.insert(getTableName(), null, getContentValues(it.next()));
            }
            this.database.setTransactionSuccessful();
            return true;
        } catch (Exception e5) {
            OkLogger.printStackTrace(e5);
            return false;
        } finally {
            this.database.endTransaction();
            this.lock.unlock();
            AbstractC0004e.m1A(jCurrentTimeMillis, new StringBuilder(), " insertList", TAG);
        }
    }

    public boolean replace(ContentValues contentValues) {
        SQLiteDatabase sQLiteDatabase;
        Lock lock;
        String str;
        StringBuilder sb;
        long jCurrentTimeMillis = System.currentTimeMillis();
        this.lock.lock();
        try {
            this.database.beginTransaction();
            this.database.replace(getTableName(), null, contentValues);
            this.database.setTransactionSuccessful();
            return true;
        } catch (Exception e5) {
            OkLogger.printStackTrace(e5);
            return false;
        } finally {
            this.database.endTransaction();
            this.lock.unlock();
            AbstractC0004e.m1A(jCurrentTimeMillis, new StringBuilder(), " replaceContentValues", TAG);
        }
    }

    public boolean update(ContentValues contentValues, String str, String[] strArr) {
        SQLiteDatabase sQLiteDatabase;
        Lock lock;
        String str2;
        StringBuilder sb;
        long jCurrentTimeMillis = System.currentTimeMillis();
        this.lock.lock();
        try {
            this.database.beginTransaction();
            this.database.update(getTableName(), contentValues, str, strArr);
            this.database.setTransactionSuccessful();
            return true;
        } catch (Exception e5) {
            OkLogger.printStackTrace(e5);
            return false;
        } finally {
            this.database.endTransaction();
            this.lock.unlock();
            AbstractC0004e.m1A(jCurrentTimeMillis, new StringBuilder(), " updateContentValues", TAG);
        }
    }

    public long replace(SQLiteDatabase sQLiteDatabase, ContentValues contentValues) {
        return sQLiteDatabase.replace(getTableName(), null, contentValues);
    }

    public long update(SQLiteDatabase sQLiteDatabase, ContentValues contentValues, String str, String[] strArr) {
        return sQLiteDatabase.update(getTableName(), contentValues, str, strArr);
    }

    public boolean replace(List<T> list) {
        if (list == null) {
            return false;
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        this.lock.lock();
        try {
            this.database.beginTransaction();
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                this.database.replace(getTableName(), null, getContentValues(it.next()));
            }
            this.database.setTransactionSuccessful();
            return true;
        } catch (Exception e5) {
            OkLogger.printStackTrace(e5);
            return false;
        } finally {
            this.database.endTransaction();
            this.lock.unlock();
            AbstractC0004e.m1A(jCurrentTimeMillis, new StringBuilder(), " replaceList", TAG);
        }
    }

    public boolean insert(SQLiteDatabase sQLiteDatabase, List<T> list) {
        try {
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                sQLiteDatabase.insert(getTableName(), null, getContentValues(it.next()));
            }
            return true;
        } catch (Exception e5) {
            OkLogger.printStackTrace(e5);
            return false;
        }
    }

    public boolean replace(SQLiteDatabase sQLiteDatabase, List<T> list) {
        try {
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                sQLiteDatabase.replace(getTableName(), null, getContentValues(it.next()));
            }
            return true;
        } catch (Exception e5) {
            OkLogger.printStackTrace(e5);
            return false;
        }
    }
}
