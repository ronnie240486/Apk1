package com.tencent.bugly.proguard;

import android.annotation.TargetApi;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import java.io.File;
import java.util.Iterator;
import java.util.List;

public final class C2104x extends SQLiteOpenHelper {

    public static String f7702a = "bugly_db";

    public static int f7703b = 16;

    protected Context f7704c;

    private List<AbstractC2092o> f7705d;

    public C2104x(Context context, List<AbstractC2092o> list) {
        super(context, f7702a + "_", (SQLiteDatabase.CursorFactory) null, f7703b);
        C2018aa.m4507a(context).getClass();
        this.f7704c = context;
        this.f7705d = list;
    }

    private synchronized boolean m5034a(SQLiteDatabase sQLiteDatabase) {
        try {
            String[] strArr = {"t_lr", "t_ui", "t_pf"};
            for (int i6 = 0; i6 < 3; i6++) {
                sQLiteDatabase.execSQL("DROP TABLE IF EXISTS ".concat(String.valueOf(strArr[i6])), new String[0]);
            }
        } catch (Throwable th) {
            if (!C2029al.m4643b(th)) {
                th.printStackTrace();
            }
            return false;
        }
        return true;
    }

    @Override
    public final synchronized SQLiteDatabase getReadableDatabase() {
        SQLiteDatabase readableDatabase;
        readableDatabase = null;
        int i6 = 0;
        while (readableDatabase == null && i6 < 5) {
            i6++;
            try {
                readableDatabase = super.getReadableDatabase();
            } catch (Throwable unused) {
                C2029al.m4645d("[Database] Try to get db(count: %d).", Integer.valueOf(i6));
                if (i6 == 5) {
                    C2029al.m4646e("[Database] Failed to get db.", new Object[0]);
                }
                try {
                    Thread.sleep(200L);
                } catch (InterruptedException e5) {
                    e5.printStackTrace();
                }
            }
        }
        return readableDatabase;
    }

    @Override
    public final synchronized SQLiteDatabase getWritableDatabase() {
        SQLiteDatabase writableDatabase;
        writableDatabase = null;
        int i6 = 0;
        while (writableDatabase == null && i6 < 5) {
            i6++;
            try {
                writableDatabase = super.getWritableDatabase();
            } catch (Throwable unused) {
                C2029al.m4645d("[Database] Try to get db(count: %d).", Integer.valueOf(i6));
                if (i6 == 5) {
                    C2029al.m4646e("[Database] Failed to get db.", new Object[0]);
                }
                try {
                    Thread.sleep(200L);
                } catch (InterruptedException e5) {
                    e5.printStackTrace();
                }
            }
        }
        if (writableDatabase == null) {
            C2029al.m4645d("[Database] db error delay error record 1min.", new Object[0]);
        }
        return writableDatabase;
    }

    @Override
    public final synchronized void onCreate(SQLiteDatabase sQLiteDatabase) {
        try {
            try {
                StringBuilder sb = new StringBuilder();
                sb.setLength(0);
                sb.append(" CREATE TABLE IF NOT EXISTS t_ui ( _id INTEGER PRIMARY KEY , _tm int , _ut int , _tp int , _dt blob , _pc text ) ");
                C2029al.m4644c(sb.toString(), new Object[0]);
                sQLiteDatabase.execSQL(sb.toString(), new String[0]);
                sb.setLength(0);
                sb.append(" CREATE TABLE IF NOT EXISTS t_lr ( _id INTEGER PRIMARY KEY , _tp int , _tm int , _pc text , _th text , _dt blob ) ");
                C2029al.m4644c(sb.toString(), new Object[0]);
                sQLiteDatabase.execSQL(sb.toString(), new String[0]);
                sb.setLength(0);
                sb.append(" CREATE TABLE IF NOT EXISTS t_pf ( _id integer , _tp text , _tm int , _dt blob,primary key(_id,_tp )) ");
                C2029al.m4644c(sb.toString(), new Object[0]);
                sQLiteDatabase.execSQL(sb.toString(), new String[0]);
                sb.setLength(0);
                sb.append(" CREATE TABLE IF NOT EXISTS t_cr ( _id INTEGER PRIMARY KEY , _tm int , _s1 text , _up int , _me int , _uc int , _dt blob ) ");
                C2029al.m4644c(sb.toString(), new Object[0]);
                sQLiteDatabase.execSQL(sb.toString(), new String[0]);
                sb.setLength(0);
                sb.append(" CREATE TABLE IF NOT EXISTS dl_1002 (_id integer primary key autoincrement, _dUrl varchar(100), _sFile varchar(100), _sLen INTEGER, _tLen INTEGER, _MD5 varchar(100), _DLTIME INTEGER)");
                C2029al.m4644c(sb.toString(), new Object[0]);
                sQLiteDatabase.execSQL(sb.toString(), new String[0]);
                sb.setLength(0);
                sb.append("CREATE TABLE IF NOT EXISTS ge_1002 (_id integer primary key autoincrement, _time INTEGER, _datas blob)");
                C2029al.m4644c(sb.toString(), new Object[0]);
                sQLiteDatabase.execSQL(sb.toString(), new String[0]);
                sb.setLength(0);
                sb.append(" CREATE TABLE IF NOT EXISTS st_1002 ( _id integer , _tp text , _tm int , _dt blob,primary key(_id,_tp )) ");
                C2029al.m4644c(sb.toString(), new Object[0]);
                sQLiteDatabase.execSQL(sb.toString(), new String[0]);
                sb.setLength(0);
                sb.append(" CREATE TABLE IF NOT EXISTS t_sla ( _id TEXT NOT NULL , _tm INTEGER NOT NULL , _dt TEXT NOT NULL , PRIMARY KEY(_id) ) ");
                String string = sb.toString();
                C2029al.m4644c(string, new Object[0]);
                sQLiteDatabase.execSQL(string, new String[0]);
            } catch (Throwable th) {
                if (!C2029al.m4643b(th)) {
                    th.printStackTrace();
                }
            }
            List<AbstractC2092o> list = this.f7705d;
            if (list == null) {
                return;
            }
            Iterator<AbstractC2092o> it = list.iterator();
            while (it.hasNext()) {
                try {
                    it.next().onDbCreate(sQLiteDatabase);
                } catch (Throwable th2) {
                    if (!C2029al.m4643b(th2)) {
                        th2.printStackTrace();
                    }
                }
            }
        } catch (Throwable th3) {
            throw th3;
        }
    }

    @Override
    @TargetApi(11)
    public final synchronized void onDowngrade(SQLiteDatabase sQLiteDatabase, int i6, int i10) {
        try {
            if (C2019ab.m4550c() >= 11) {
                C2029al.m4645d("[Database] Downgrade %d to %d drop tables.", Integer.valueOf(i6), Integer.valueOf(i10));
                List<AbstractC2092o> list = this.f7705d;
                if (list != null) {
                    Iterator<AbstractC2092o> it = list.iterator();
                    while (it.hasNext()) {
                        try {
                            it.next().onDbDowngrade(sQLiteDatabase, i6, i10);
                        } catch (Throwable th) {
                            if (!C2029al.m4643b(th)) {
                                th.printStackTrace();
                            }
                        }
                    }
                }
                if (m5034a(sQLiteDatabase)) {
                    onCreate(sQLiteDatabase);
                    return;
                }
                C2029al.m4645d("[Database] Failed to drop, delete db.", new Object[0]);
                File databasePath = this.f7704c.getDatabasePath(f7702a);
                if (databasePath != null && databasePath.canWrite()) {
                    databasePath.delete();
                }
            }
        } catch (Throwable th2) {
            throw th2;
        }
    }

    @Override
    public final synchronized void onUpgrade(SQLiteDatabase sQLiteDatabase, int i6, int i10) {
        try {
            C2029al.m4645d("[Database] Upgrade %d to %d , drop tables!", Integer.valueOf(i6), Integer.valueOf(i10));
            List<AbstractC2092o> list = this.f7705d;
            if (list != null) {
                Iterator<AbstractC2092o> it = list.iterator();
                while (it.hasNext()) {
                    try {
                        it.next().onDbUpgrade(sQLiteDatabase, i6, i10);
                    } catch (Throwable th) {
                        if (!C2029al.m4643b(th)) {
                            th.printStackTrace();
                        }
                    }
                }
            }
            if (m5034a(sQLiteDatabase)) {
                onCreate(sQLiteDatabase);
                return;
            }
            C2029al.m4645d("[Database] Failed to drop, delete db.", new Object[0]);
            File databasePath = this.f7704c.getDatabasePath(f7702a);
            if (databasePath != null && databasePath.canWrite()) {
                databasePath.delete();
            }
        } catch (Throwable th2) {
            throw th2;
        }
    }
}
