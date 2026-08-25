package com.tencent.bugly.proguard;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class C2103w {

    public static boolean f7699a;

    private static C2103w f7700b;

    private static C2104x f7701c;

    private C2103w(Context context, List<AbstractC2092o> list) {
        f7701c = new C2104x(context, list);
    }

    private synchronized boolean m5020b(C2105y c2105y) {
        ContentValues contentValuesM5023d;
        SQLiteDatabase writableDatabase = null;
        try {
            writableDatabase = f7701c.getWritableDatabase();
            if (writableDatabase == null || (contentValuesM5023d = m5023d(c2105y)) == null) {
                if (f7699a && writableDatabase != null) {
                    writableDatabase.close();
                }
                return false;
            }
            long jReplace = writableDatabase.replace("t_pf", "_id", contentValuesM5023d);
            if (jReplace < 0) {
                if (f7699a) {
                    writableDatabase.close();
                }
                return false;
            }
            C2029al.m4644c("[Database] insert %s success.", "t_pf");
            c2105y.f7706a = jReplace;
            if (f7699a) {
                writableDatabase.close();
            }
            return true;
        } catch (Throwable th) {
            try {
                if (!C2029al.m4641a(th)) {
                    th.printStackTrace();
                }
                return false;
            } finally {
                if (f7699a && writableDatabase != null) {
                    writableDatabase.close();
                }
            }
        }
    }

    private static ContentValues m5021c(C2105y c2105y) {
        if (c2105y == null) {
            return null;
        }
        try {
            ContentValues contentValues = new ContentValues();
            long j10 = c2105y.f7706a;
            if (j10 > 0) {
                contentValues.put("_id", Long.valueOf(j10));
            }
            contentValues.put("_tp", Integer.valueOf(c2105y.f7707b));
            contentValues.put("_pc", c2105y.f7708c);
            contentValues.put("_th", c2105y.f7709d);
            contentValues.put("_tm", Long.valueOf(c2105y.f7710e));
            byte[] bArr = c2105y.f7712g;
            if (bArr != null) {
                contentValues.put("_dt", bArr);
            }
            return contentValues;
        } catch (Throwable th) {
            if (!C2029al.m4641a(th)) {
                th.printStackTrace();
            }
            return null;
        }
    }

    private static ContentValues m5023d(C2105y c2105y) {
        if (c2105y != null && !C2033ap.m4703b(c2105y.f7711f)) {
            try {
                ContentValues contentValues = new ContentValues();
                long j10 = c2105y.f7706a;
                if (j10 > 0) {
                    contentValues.put("_id", Long.valueOf(j10));
                }
                contentValues.put("_tp", c2105y.f7711f);
                contentValues.put("_tm", Long.valueOf(c2105y.f7710e));
                byte[] bArr = c2105y.f7712g;
                if (bArr != null) {
                    contentValues.put("_dt", bArr);
                }
                return contentValues;
            } catch (Throwable th) {
                if (!C2029al.m4641a(th)) {
                    th.printStackTrace();
                }
            }
        }
        return null;
    }

    public static synchronized C2103w m5012a(Context context, List<AbstractC2092o> list) {
        try {
            if (f7700b == null) {
                f7700b = new C2103w(context, list);
            }
        } catch (Throwable th) {
            throw th;
        }
        return f7700b;
    }

    public static synchronized C2103w m5011a() {
        return f7700b;
    }

    public final Cursor m5026a(String str, String[] strArr, String str2) {
        return m5027a(str, strArr, str2, (String) null, (String) null);
    }

    private synchronized List<C2105y> m5022c(int i6) {
        SQLiteDatabase writableDatabase;
        Cursor cursorQuery;
        try {
            try {
                writableDatabase = f7701c.getWritableDatabase();
                if (writableDatabase != null) {
                    try {
                        String strConcat = "_id = ".concat(String.valueOf(i6));
                        cursorQuery = writableDatabase.query("t_pf", null, strConcat, null, null, null, null);
                        if (cursorQuery == null) {
                            if (cursorQuery != null) {
                                cursorQuery.close();
                            }
                            if (f7699a) {
                                writableDatabase.close();
                            }
                            return null;
                        }
                        try {
                            StringBuilder sb = new StringBuilder();
                            ArrayList arrayList = new ArrayList();
                            while (cursorQuery.moveToNext()) {
                                C2105y c2105yM5019b = m5019b(cursorQuery);
                                if (c2105yM5019b != null) {
                                    arrayList.add(c2105yM5019b);
                                } else {
                                    try {
                                        String string = cursorQuery.getString(cursorQuery.getColumnIndex("_tp"));
                                        sb.append(" or _tp = ");
                                        sb.append(string);
                                    } catch (Throwable unused) {
                                        C2029al.m4645d("[Database] unknown id.", new Object[0]);
                                    }
                                }
                            }
                            if (sb.length() > 0) {
                                sb.append(" and _id = ");
                                sb.append(i6);
                                C2029al.m4645d("[Database] deleted %s illegal data %d.", "t_pf", Integer.valueOf(writableDatabase.delete("t_pf", strConcat.substring(4), null)));
                            }
                            cursorQuery.close();
                            if (f7699a) {
                                writableDatabase.close();
                            }
                            return arrayList;
                        } catch (Throwable th) {
                            th = th;
                            try {
                                if (!C2029al.m4641a(th)) {
                                    th.printStackTrace();
                                }
                                if (cursorQuery != null) {
                                    cursorQuery.close();
                                }
                                if (f7699a && writableDatabase != null) {
                                    writableDatabase.close();
                                }
                                return null;
                            } catch (Throwable th2) {
                                if (cursorQuery != null) {
                                    cursorQuery.close();
                                }
                                if (f7699a && writableDatabase != null) {
                                    writableDatabase.close();
                                }
                                throw th2;
                            }
                        }
                    } catch (Throwable th3) {
                        th = th3;
                        cursorQuery = null;
                    }
                } else {
                    if (f7699a && writableDatabase != null) {
                        writableDatabase.close();
                    }
                    return null;
                }
            } catch (Throwable th4) {
                th = th4;
                writableDatabase = null;
                cursorQuery = null;
            }
        } catch (Throwable th5) {
            throw th5;
        }
    }

    public final Cursor m5027a(String str, String[] strArr, String str2, String str3, String str4) {
        return m5010a(false, str, strArr, str2, null, null, null, str3, str4, null);
    }

    public final int m5024a(String str, String str2) {
        return m5007a(str, str2, (String[]) null, (InterfaceC2102v) null);
    }

    public final synchronized long m5025a(String str, ContentValues contentValues, InterfaceC2102v interfaceC2102v) {
        long j10;
        j10 = -1;
        SQLiteDatabase writableDatabase = null;
        try {
            writableDatabase = f7701c.getWritableDatabase();
            if (writableDatabase != null && contentValues != null) {
                long jReplace = writableDatabase.replace(str, "_id", contentValues);
                if (jReplace >= 0) {
                    C2029al.m4644c("[Database] insert %s success.", str);
                } else {
                    C2029al.m4645d("[Database] replace %s error.", str);
                }
                j10 = jReplace;
            }
            if (f7699a && writableDatabase != null) {
                writableDatabase.close();
            }
        } catch (Throwable th) {
            try {
                if (!C2029al.m4641a(th)) {
                    th.printStackTrace();
                }
                if (f7699a && 0 != 0) {
                }
            } catch (Throwable th2) {
                if (f7699a && 0 != 0) {
                    writableDatabase.close();
                }
                throw th2;
            }
        }
        return j10;
    }

    public final synchronized void m5033b(int i6) {
        String strConcat;
        SQLiteDatabase writableDatabase = f7701c.getWritableDatabase();
        if (writableDatabase != null) {
            if (i6 >= 0) {
                try {
                    strConcat = "_tp = ".concat(String.valueOf(i6));
                } catch (Throwable th) {
                    try {
                        if (!C2029al.m4641a(th)) {
                            th.printStackTrace();
                        }
                        if (f7699a) {
                            return;
                        }
                    } finally {
                        if (f7699a) {
                            writableDatabase.close();
                        }
                    }
                }
            } else {
                strConcat = null;
            }
            C2029al.m4644c("[Database] deleted %s data %d", "t_lr", Integer.valueOf(writableDatabase.delete("t_lr", strConcat, null)));
            if (f7699a) {
                writableDatabase.close();
            }
        }
    }

    public synchronized Cursor m5010a(boolean z7, String str, String[] strArr, String str2, String[] strArr2, String str3, String str4, String str5, String str6, InterfaceC2102v interfaceC2102v) {
        Cursor cursorQuery;
        cursorQuery = null;
        try {
            SQLiteDatabase writableDatabase = f7701c.getWritableDatabase();
            if (writableDatabase != null) {
                cursorQuery = writableDatabase.query(z7, str, strArr, str2, strArr2, str3, str4, str5, str6);
            }
        } catch (Throwable th) {
            try {
                if (!C2029al.m4641a(th)) {
                    th.printStackTrace();
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return cursorQuery;
    }

    public synchronized int m5007a(String str, String str2, String[] strArr, InterfaceC2102v interfaceC2102v) {
        int iDelete;
        iDelete = 0;
        SQLiteDatabase writableDatabase = null;
        try {
            writableDatabase = f7701c.getWritableDatabase();
            iDelete = writableDatabase != null ? writableDatabase.delete(str, str2, strArr) : 0;
            if (f7699a && writableDatabase != null) {
                writableDatabase.close();
            }
        } catch (Throwable th) {
            try {
                if (!C2029al.m4641a(th)) {
                    th.printStackTrace();
                }
                if (f7699a && writableDatabase != null) {
                }
            } catch (Throwable th2) {
                if (f7699a && writableDatabase != null) {
                    writableDatabase.close();
                }
                throw th2;
            }
        }
        return iDelete;
    }

    private static C2105y m5019b(Cursor cursor) {
        if (cursor == null) {
            return null;
        }
        try {
            C2105y c2105y = new C2105y();
            c2105y.f7706a = cursor.getLong(cursor.getColumnIndex("_id"));
            c2105y.f7710e = cursor.getLong(cursor.getColumnIndex("_tm"));
            c2105y.f7711f = cursor.getString(cursor.getColumnIndex("_tp"));
            c2105y.f7712g = cursor.getBlob(cursor.getColumnIndex("_dt"));
            return c2105y;
        } catch (Throwable th) {
            if (!C2029al.m4641a(th)) {
                th.printStackTrace();
            }
            return null;
        }
    }

    public final boolean m5031a(int i6, String str, byte[] bArr, boolean z7) {
        if (!z7) {
            C2097q0 c2097q0 = new C2097q0(this);
            c2097q0.f7664b = i6;
            c2097q0.f7665c = str;
            c2097q0.f7666d = bArr;
            C2028ak.m4631a().m4633a(c2097q0);
            return true;
        }
        return m5016a(i6, str, bArr, (InterfaceC2102v) null);
    }

    public boolean m5016a(int i6, String str, byte[] bArr, InterfaceC2102v interfaceC2102v) {
        try {
            C2105y c2105y = new C2105y();
            c2105y.f7706a = i6;
            c2105y.f7711f = str;
            c2105y.f7710e = System.currentTimeMillis();
            c2105y.f7712g = bArr;
            return m5020b(c2105y);
        } catch (Throwable th) {
            if (!C2029al.m4641a(th)) {
                th.printStackTrace();
            }
            return false;
        }
    }

    public final Map<String, byte[]> m5029a(int i6, InterfaceC2102v interfaceC2102v) {
        HashMap map = null;
        try {
            List<C2105y> listM5022c = m5022c(i6);
            if (listM5022c == null) {
                return null;
            }
            HashMap map2 = new HashMap();
            try {
                for (C2105y c2105y : listM5022c) {
                    byte[] bArr = c2105y.f7712g;
                    if (bArr != null) {
                        map2.put(c2105y.f7711f, bArr);
                    }
                }
                return map2;
            } catch (Throwable th) {
                th = th;
                map = map2;
            }
        } catch (Throwable th2) {
            th = th2;
        }
        if (C2029al.m4641a(th)) {
            return map;
        }
        th.printStackTrace();
        return map;
    }

    public final synchronized boolean m5032a(C2105y c2105y) {
        ContentValues contentValuesM5021c;
        SQLiteDatabase writableDatabase = null;
        try {
            writableDatabase = f7701c.getWritableDatabase();
            if (writableDatabase != null && (contentValuesM5021c = m5021c(c2105y)) != null) {
                long jReplace = writableDatabase.replace("t_lr", "_id", contentValuesM5021c);
                if (jReplace >= 0) {
                    C2029al.m4644c("[Database] insert %s success.", "t_lr");
                    c2105y.f7706a = jReplace;
                    if (f7699a) {
                        writableDatabase.close();
                    }
                    return true;
                }
                if (f7699a) {
                    writableDatabase.close();
                }
                return false;
            }
            if (f7699a && writableDatabase != null) {
                writableDatabase.close();
            }
            return false;
        } catch (Throwable th) {
            try {
                if (!C2029al.m4641a(th)) {
                    th.printStackTrace();
                }
                return false;
            } finally {
                if (f7699a && writableDatabase != null) {
                    writableDatabase.close();
                }
            }
        }
    }

    public final synchronized List<C2105y> m5028a(int i6) {
        String strConcat;
        Cursor cursor;
        try {
            SQLiteDatabase writableDatabase = f7701c.getWritableDatabase();
            if (writableDatabase != null) {
                if (i6 >= 0) {
                    try {
                        strConcat = "_tp = ".concat(String.valueOf(i6));
                    } catch (Throwable th) {
                        th = th;
                        cursor = null;
                        try {
                            if (!C2029al.m4641a(th)) {
                                th.printStackTrace();
                            }
                            if (cursor != null) {
                                cursor.close();
                            }
                            if (f7699a) {
                                writableDatabase.close();
                            }
                            return null;
                        } catch (Throwable th2) {
                            if (cursor != null) {
                                cursor.close();
                            }
                            if (f7699a) {
                                writableDatabase.close();
                            }
                            throw th2;
                        }
                    }
                } else {
                    strConcat = null;
                }
                Cursor cursorQuery = writableDatabase.query("t_lr", null, strConcat, null, null, null, null);
                if (cursorQuery == null) {
                    if (cursorQuery != null) {
                        cursorQuery.close();
                    }
                    if (f7699a) {
                        writableDatabase.close();
                    }
                    return null;
                }
                try {
                    StringBuilder sb = new StringBuilder();
                    ArrayList arrayList = new ArrayList();
                    while (cursorQuery.moveToNext()) {
                        C2105y c2105yM5013a = m5013a(cursorQuery);
                        if (c2105yM5013a != null) {
                            arrayList.add(c2105yM5013a);
                        } else {
                            try {
                                long j10 = cursorQuery.getLong(cursorQuery.getColumnIndex("_id"));
                                sb.append(" or _id = ");
                                sb.append(j10);
                            } catch (Throwable unused) {
                                C2029al.m4645d("[Database] unknown id.", new Object[0]);
                            }
                        }
                    }
                    String string = sb.toString();
                    if (string.length() > 0) {
                        C2029al.m4645d("[Database] deleted %s illegal data %d", "t_lr", Integer.valueOf(writableDatabase.delete("t_lr", string.substring(4), null)));
                    }
                    cursorQuery.close();
                    if (f7699a) {
                        writableDatabase.close();
                    }
                    return arrayList;
                } catch (Throwable th3) {
                    cursor = cursorQuery;
                    th = th3;
                    if (!C2029al.m4641a(th)) {
                        th.printStackTrace();
                    }
                    if (cursor != null) {
                        cursor.close();
                    }
                    if (f7699a) {
                        writableDatabase.close();
                    }
                    return null;
                }
            }
            return null;
        } catch (Throwable th4) {
            throw th4;
        }
    }

    public final synchronized void m5030a(List<C2105y> list) {
        if (list != null) {
            try {
                if (list.size() != 0) {
                    SQLiteDatabase writableDatabase = f7701c.getWritableDatabase();
                    if (writableDatabase != null) {
                        StringBuilder sb = new StringBuilder();
                        for (C2105y c2105y : list) {
                            sb.append(" or _id = ");
                            sb.append(c2105y.f7706a);
                        }
                        String string = sb.toString();
                        if (string.length() > 0) {
                            string = string.substring(4);
                        }
                        sb.setLength(0);
                        try {
                            C2029al.m4644c("[Database] deleted %s data %d", "t_lr", Integer.valueOf(writableDatabase.delete("t_lr", string, null)));
                            if (f7699a) {
                                writableDatabase.close();
                            }
                        } catch (Throwable th) {
                            try {
                                if (!C2029al.m4641a(th)) {
                                    th.printStackTrace();
                                }
                                if (f7699a) {
                                }
                            } finally {
                                if (f7699a) {
                                    writableDatabase.close();
                                }
                            }
                        }
                    }
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    private static C2105y m5013a(Cursor cursor) {
        if (cursor == null) {
            return null;
        }
        try {
            C2105y c2105y = new C2105y();
            c2105y.f7706a = cursor.getLong(cursor.getColumnIndex("_id"));
            c2105y.f7707b = cursor.getInt(cursor.getColumnIndex("_tp"));
            c2105y.f7708c = cursor.getString(cursor.getColumnIndex("_pc"));
            c2105y.f7709d = cursor.getString(cursor.getColumnIndex("_th"));
            c2105y.f7710e = cursor.getLong(cursor.getColumnIndex("_tm"));
            c2105y.f7712g = cursor.getBlob(cursor.getColumnIndex("_dt"));
            return c2105y;
        } catch (Throwable th) {
            if (!C2029al.m4641a(th)) {
                th.printStackTrace();
            }
            return null;
        }
    }

    public synchronized boolean m5015a(int i6, String str, InterfaceC2102v interfaceC2102v) {
        String strConcat;
        boolean z7 = false;
        synchronized (this) {
            SQLiteDatabase sQLiteDatabase = null;
            try {
                SQLiteDatabase writableDatabase = f7701c.getWritableDatabase();
                if (writableDatabase != null) {
                    try {
                        if (C2033ap.m4703b(str)) {
                            strConcat = "_id = ".concat(String.valueOf(i6));
                        } else {
                            strConcat = "_id = " + i6 + " and _tp = \"" + str + "\"";
                        }
                        int iDelete = writableDatabase.delete("t_pf", strConcat, null);
                        C2029al.m4644c("[Database] deleted %s data %d", "t_pf", Integer.valueOf(iDelete));
                        z7 = iDelete > 0;
                    } catch (Throwable th) {
                        th = th;
                        sQLiteDatabase = writableDatabase;
                        try {
                            if (!C2029al.m4641a(th)) {
                                th.printStackTrace();
                            }
                            if (f7699a && sQLiteDatabase != null) {
                                sQLiteDatabase.close();
                            }
                        } catch (Throwable th2) {
                            if (f7699a && sQLiteDatabase != null) {
                                sQLiteDatabase.close();
                            }
                            throw th2;
                        }
                    }
                }
                if (f7699a && writableDatabase != null) {
                    writableDatabase.close();
                }
            } catch (Throwable th3) {
                th = th3;
            }
        }
        return z7;
    }
}
