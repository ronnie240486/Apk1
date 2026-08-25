package p087i4;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabaseLockedException;
import android.os.SystemClock;
import android.util.Base64;
import androidx.media3.exoplayer.analytics.C0707x;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Objects;
import p005a4.C0051j;
import p027c4.InterfaceC1397a;
import p050e4.EnumC2411c;
import p098j4.C2774a;
import p098j4.InterfaceC2775b;
import p098j4.InterfaceC2776c;
import p110k4.InterfaceC2890a;
import p122l4.AbstractC2972a;
import p248x3.C4106b;

public final class C2702g implements InterfaceC2699d, InterfaceC2776c, InterfaceC2698c {

    public static final C4106b f9386f = new C4106b("proto");

    public final C2704i f9387a;

    public final InterfaceC2890a f9388b;

    public final InterfaceC2890a f9389c;

    public final C2696a f9390d;

    public final InterfaceC1397a f9391e;

    public C2702g(InterfaceC2890a interfaceC2890a, InterfaceC2890a interfaceC2890a2, C2696a c2696a, C2704i c2704i, InterfaceC1397a interfaceC1397a) {
        this.f9387a = c2704i;
        this.f9388b = interfaceC2890a;
        this.f9389c = interfaceC2890a2;
        this.f9390d = c2696a;
        this.f9391e = interfaceC1397a;
    }

    public static Long m5694b(SQLiteDatabase sQLiteDatabase, C0051j c0051j) {
        StringBuilder sb = new StringBuilder("backend_name = ? and priority = ?");
        ArrayList arrayList = new ArrayList(Arrays.asList(c0051j.f151a, String.valueOf(AbstractC2972a.m6008a(c0051j.f153c))));
        byte[] bArr = c0051j.f152b;
        if (bArr != null) {
            sb.append(" and extras = ?");
            arrayList.add(Base64.encodeToString(bArr, 0));
        } else {
            sb.append(" and extras is null");
        }
        Cursor cursorQuery = sQLiteDatabase.query("transport_contexts", new String[]{"_id"}, sb.toString(), (String[]) arrayList.toArray(new String[0]), null, null, null);
        try {
            return !cursorQuery.moveToNext() ? null : Long.valueOf(cursorQuery.getLong(0));
        } finally {
            cursorQuery.close();
        }
    }

    public static String m5695f(Iterable iterable) {
        StringBuilder sb = new StringBuilder("(");
        Iterator it = iterable.iterator();
        while (it.hasNext()) {
            sb.append(((C2697b) it.next()).f9381a);
            if (it.hasNext()) {
                sb.append(',');
            }
        }
        sb.append(')');
        return sb.toString();
    }

    public static Object m5696g(Cursor cursor, InterfaceC2700e interfaceC2700e) {
        try {
            return interfaceC2700e.apply(cursor);
        } finally {
            cursor.close();
        }
    }

    public final SQLiteDatabase m5697a() {
        C2704i c2704i = this.f9387a;
        Objects.requireNonNull(c2704i);
        InterfaceC2890a interfaceC2890a = this.f9389c;
        long jMo5893c = interfaceC2890a.mo5893c();
        while (true) {
            try {
                return c2704i.getWritableDatabase();
            } catch (SQLiteDatabaseLockedException e5) {
                if (interfaceC2890a.mo5893c() >= ((long) this.f9390d.f9378c) + jMo5893c) {
                    throw new C2774a("Timed out while trying to open db.", e5);
                }
                SystemClock.sleep(50L);
            }
        }
    }

    public final Object m5698c(InterfaceC2700e interfaceC2700e) {
        SQLiteDatabase sQLiteDatabaseM5697a = m5697a();
        sQLiteDatabaseM5697a.beginTransaction();
        try {
            Object objApply = interfaceC2700e.apply(sQLiteDatabaseM5697a);
            sQLiteDatabaseM5697a.setTransactionSuccessful();
            return objApply;
        } finally {
            sQLiteDatabaseM5697a.endTransaction();
        }
    }

    @Override
    public final void close() {
        this.f9387a.close();
    }

    public final void m5699d(long j10, EnumC2411c enumC2411c, String str) {
        m5698c(new C0707x(j10, str, enumC2411c));
    }

    public final Object m5700e(InterfaceC2775b interfaceC2775b) {
        SQLiteDatabase sQLiteDatabaseM5697a = m5697a();
        InterfaceC2890a interfaceC2890a = this.f9389c;
        long jMo5893c = interfaceC2890a.mo5893c();
        while (true) {
            try {
                sQLiteDatabaseM5697a.beginTransaction();
                try {
                    Object objExecute = interfaceC2775b.execute();
                    sQLiteDatabaseM5697a.setTransactionSuccessful();
                    return objExecute;
                } finally {
                    sQLiteDatabaseM5697a.endTransaction();
                }
            } catch (SQLiteDatabaseLockedException e5) {
                if (interfaceC2890a.mo5893c() >= ((long) this.f9390d.f9378c) + jMo5893c) {
                    throw new C2774a("Timed out while trying to acquire the lock.", e5);
                }
                SystemClock.sleep(50L);
            }
        }
    }
}
