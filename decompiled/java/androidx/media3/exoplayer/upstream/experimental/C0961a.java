package androidx.media3.exoplayer.upstream.experimental;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import androidx.media3.common.util.Clock;
import com.lzy.okgo.model.Progress;
import java.util.Deque;
import p005a4.C0051j;
import p087i4.InterfaceC2700e;
import p122l4.AbstractC2972a;
import p248x3.EnumC4107c;

public final class C0961a implements SlidingWeightedAverageBandwidthStatistic.SampleEvictionFunction, InterfaceC2700e {

    public final long f3036a;

    public final Object f3037b;

    public C0961a(long j10, Object obj) {
        this.f3036a = j10;
        this.f3037b = obj;
    }

    @Override
    public Object apply(Object obj) {
        SQLiteDatabase sQLiteDatabase = (SQLiteDatabase) obj;
        ContentValues contentValues = new ContentValues();
        contentValues.put("next_request_ms", Long.valueOf(this.f3036a));
        C0051j c0051j = (C0051j) this.f3037b;
        String str = c0051j.f151a;
        EnumC4107c enumC4107c = c0051j.f153c;
        if (sQLiteDatabase.update("transport_contexts", contentValues, "backend_name = ? and priority = ?", new String[]{str, String.valueOf(AbstractC2972a.m6008a(enumC4107c))}) < 1) {
            contentValues.put("backend_name", c0051j.f151a);
            contentValues.put(Progress.PRIORITY, Integer.valueOf(AbstractC2972a.m6008a(enumC4107c)));
            sQLiteDatabase.insert("transport_contexts", null, contentValues);
        }
        return null;
    }

    @Override
    public boolean shouldEvictSample(Deque deque) {
        return SlidingWeightedAverageBandwidthStatistic.lambda$getAgeBasedEvictionFunction$1(this.f3036a, (Clock) this.f3037b, deque);
    }
}
