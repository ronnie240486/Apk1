package androidx.media3.exoplayer.analytics;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import androidx.media3.common.util.ListenerSet;
import androidx.media3.exoplayer.upstream.experimental.C0961a;
import p005a4.C0051j;
import p050e4.EnumC2411c;
import p077h4.C2659i;
import p087i4.C2702g;
import p087i4.InterfaceC2700e;
import p098j4.InterfaceC2775b;

public final class C0707x implements ListenerSet.Event, InterfaceC2775b, InterfaceC2700e {

    public final long f2763a;

    public final Object f2764b;

    public final Object f2765c;

    public C0707x(long j10, Object obj, Object obj2) {
        this.f2764b = obj;
        this.f2765c = obj2;
        this.f2763a = j10;
    }

    @Override
    public Object apply(Object obj) {
        SQLiteDatabase sQLiteDatabase = (SQLiteDatabase) obj;
        int i6 = ((EnumC2411c) this.f2765c).f8413a;
        String string = Integer.toString(i6);
        String str = (String) this.f2764b;
        Cursor cursorRawQuery = sQLiteDatabase.rawQuery("SELECT 1 FROM log_event_dropped WHERE log_source = ? AND reason = ?", new String[]{str, string});
        try {
            boolean z7 = cursorRawQuery.getCount() > 0;
            cursorRawQuery.close();
            long j10 = this.f2763a;
            if (z7) {
                sQLiteDatabase.execSQL("UPDATE log_event_dropped SET events_dropped_count = events_dropped_count + " + j10 + " WHERE log_source = ? AND reason = ?", new String[]{str, Integer.toString(i6)});
            } else {
                ContentValues contentValues = new ContentValues();
                contentValues.put("log_source", str);
                contentValues.put("reason", Integer.valueOf(i6));
                contentValues.put("events_dropped_count", Long.valueOf(j10));
                sQLiteDatabase.insert("log_event_dropped", null, contentValues);
            }
            return null;
        } catch (Throwable th) {
            cursorRawQuery.close();
            throw th;
        }
    }

    @Override
    public Object execute() {
        C2659i c2659i = (C2659i) this.f2764b;
        long jMo5893c = c2659i.f9283g.mo5893c() + this.f2763a;
        C2702g c2702g = (C2702g) c2659i.f9279c;
        C0051j c0051j = (C0051j) this.f2765c;
        c2702g.getClass();
        c2702g.m5698c(new C0961a(jMo5893c, c0051j));
        return null;
    }

    @Override
    public void invoke(Object obj) {
        ((AnalyticsListener) obj).onRenderedFirstFrame((AnalyticsListener.EventTime) this.f2764b, this.f2765c, this.f2763a);
    }
}
