package androidx.media3.exoplayer.hls;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Base64;
import androidx.media3.common.AdViewProvider;
import androidx.media3.common.MediaItem;
import androidx.media3.common.Timeline;
import androidx.media3.common.TrackGroup;
import androidx.media3.common.util.Consumer;
import androidx.media3.exoplayer.source.MediaLoadData;
import androidx.media3.exoplayer.source.MediaSource;
import androidx.media3.exoplayer.source.MediaSourceEventListener;
import androidx.media3.exoplayer.source.ads.AdsMediaSource;
import androidx.media3.exoplayer.trackselection.DefaultTrackSelector;
import com.alibaba.fastjson.JSONReader;
import com.lzy.okgo.cookie.SerializableCookie;
import com.lzy.okgo.model.Progress;
import com.tencent.mars.xlog.Log;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.bitspark.android.beans.ChannelBean;
import org.bitspark.android.utils.AbstractC3331m;
import p000a.RunnableC0005f;
import p001a0.C0023f;
import p003a2.AbstractC0032a;
import p005a4.C0049h;
import p005a4.C0050i;
import p005a4.C0051j;
import p005a4.C0055n;
import p050e4.C2409a;
import p050e4.C2410b;
import p050e4.C2412d;
import p050e4.C2413e;
import p050e4.C2414f;
import p050e4.C2415g;
import p050e4.EnumC2411c;
import p069g4.C2611a;
import p087i4.C2696a;
import p087i4.C2697b;
import p087i4.C2702g;
import p087i4.InterfaceC2700e;
import p090i8.InterfaceC2708b;
import p098j4.InterfaceC2775b;
import p116ka.C2930l0;
import p116ka.ViewOnKeyListenerC2932m0;
import p122l4.AbstractC2972a;
import p156o9.AbstractC3280d;
import p169p8.C3377b;
import p248x3.C4106b;

public final class C0775b implements Consumer, DefaultTrackSelector.TrackInfo.Factory, InterfaceC2775b, InterfaceC2700e, InterfaceC2708b {

    public final int f2856a;

    public final Object f2857b;

    public final Object f2858c;

    public final Object f2859d;

    public C0775b(Object obj, Object obj2, Object obj3, int i6) {
        this.f2856a = i6;
        this.f2858c = obj;
        this.f2857b = obj2;
        this.f2859d = obj3;
    }

    @Override
    public void mo1735a(C3377b c3377b) {
        String str = (String) this.f2859d;
        C2930l0 c2930l0 = (C2930l0) this.f2858c;
        c2930l0.getClass();
        AbstractC0032a.m165s("JDvDg7A=\n", "ZmiV7NRk9q4=\n");
        AbstractC0032a.m165s("U7BZO0Vur3JJtEYgRXGZVEC7CCFOTq5SQrBbPRo9\n", "IdUoTiAd2zE=\n");
        String strM165s = AbstractC0032a.m165s("6Q==\n", "ssLGnk0hAPw=\n");
        String str2 = (String) this.f2857b;
        if (str2.startsWith(strM165s)) {
            String strM165s2 = AbstractC0032a.m165s("JMv0mX8=\n", "Zpii9hvzieM=\n");
            String strM165s3 = AbstractC0032a.m165s("1bA2q5rmKf/J5EU2RhGpFyQ5/1ofHeNqL26CZX1q8ABTQuU2XwQP5NuwC7uVYOM1Um/E\n", "ut5l3vmFTIw=\n");
            boolean z7 = AbstractC3331m.f11244b;
            Log.m5049i(strM165s2, strM165s3);
            return;
        }
        if (str2.startsWith(AbstractC0032a.m165s("Og==\n", "QUsuebrB1AQ=\n"))) {
            try {
                ChannelBean channelBean = (ChannelBean) new JSONReader(new StringReader(str2)).readObject(ChannelBean.class);
                if (channelBean.getSources() == null || channelBean.getSources().isEmpty()) {
                    ViewOnKeyListenerC2932m0.f9950E0.post(new RunnableC0005f(25, c2930l0));
                    ViewOnKeyListenerC2932m0 viewOnKeyListenerC2932m0 = c2930l0.f9944d;
                    viewOnKeyListenerC2932m0.f9983v0.f13009v = false;
                    viewOnKeyListenerC2932m0.f9987z0.put(str, Boolean.FALSE);
                } else {
                    String strM165s4 = AbstractC0032a.m165s("aDWKbgI=\n", "KmbcAWaTd5A=\n");
                    String str3 = AbstractC0032a.m165s("zUcWefQBnQvRE2U=\n", "oilFDJdi+Hg=\n") + channelBean.getSources().size();
                    boolean z10 = AbstractC3331m.f11244b;
                    Log.m5049i(strM165s4, str3);
                    c3377b.m6873c(channelBean);
                }
            } catch (Exception e5) {
                throw new RuntimeException(e5);
            }
        }
    }

    @Override
    public void accept(Object obj) {
        switch (this.f2856a) {
            case 0:
                HlsInterstitialsAdsLoader.lambda$handleContentTimelineChanged$1((AdsMediaSource) this.f2858c, this.f2857b, (Timeline) this.f2859d, (HlsInterstitialsAdsLoader.Listener) obj);
                break;
            case 1:
                ((HlsInterstitialsAdsLoader.Listener) obj).onStart((MediaItem) this.f2858c, this.f2857b, (AdViewProvider) this.f2859d);
                break;
            default:
                ((MediaSourceEventListener.EventDispatcher) this.f2858c).lambda$upstreamDiscarded$4((MediaSource.MediaPeriodId) this.f2857b, (MediaLoadData) this.f2859d, (MediaSourceEventListener) obj);
                break;
        }
    }

    @Override
    public Object apply(Object obj) {
        long jInsert;
        C2702g c2702g;
        EnumC2411c enumC2411c;
        EnumC2411c enumC2411c2;
        int i6 = 5;
        int i10 = 4;
        int i11 = 3;
        EnumC2411c enumC2411c3 = EnumC2411c.CACHE_FULL;
        int i12 = 2;
        Object obj2 = this.f2859d;
        int i13 = 0;
        Object obj3 = this.f2857b;
        Object obj4 = this.f2858c;
        int i14 = 1;
        switch (this.f2856a) {
            case 5:
                SQLiteDatabase sQLiteDatabase = (SQLiteDatabase) obj;
                C2702g c2702g2 = (C2702g) obj4;
                long jSimpleQueryForLong = c2702g2.m5697a().compileStatement("PRAGMA page_size").simpleQueryForLong() * c2702g2.m5697a().compileStatement("PRAGMA page_count").simpleQueryForLong();
                C2696a c2696a = c2702g2.f9390d;
                long j10 = c2696a.f9376a;
                C0050i c0050i = (C0050i) obj3;
                String str = c0050i.f145a;
                if (jSimpleQueryForLong >= j10) {
                    c2702g2.m5699d(1L, enumC2411c3, str);
                    return -1L;
                }
                C0051j c0051j = (C0051j) obj2;
                Long lM5694b = C2702g.m5694b(sQLiteDatabase, c0051j);
                if (lM5694b != null) {
                    jInsert = lM5694b.longValue();
                } else {
                    ContentValues contentValues = new ContentValues();
                    contentValues.put("backend_name", c0051j.f151a);
                    contentValues.put(Progress.PRIORITY, Integer.valueOf(AbstractC2972a.m6008a(c0051j.f153c)));
                    contentValues.put("next_request_ms", (Integer) 0);
                    byte[] bArr = c0051j.f152b;
                    if (bArr != null) {
                        contentValues.put("extras", Base64.encodeToString(bArr, 0));
                    }
                    jInsert = sQLiteDatabase.insert("transport_contexts", null, contentValues);
                }
                C0055n c0055n = c0050i.f147c;
                byte[] bArr2 = c0055n.f162b;
                int length = bArr2.length;
                int i15 = c2696a.f9380e;
                boolean z7 = length <= i15;
                ContentValues contentValues2 = new ContentValues();
                contentValues2.put("context_id", Long.valueOf(jInsert));
                contentValues2.put("transport_name", str);
                contentValues2.put("timestamp_ms", Long.valueOf(c0050i.f148d));
                contentValues2.put("uptime_ms", Long.valueOf(c0050i.f149e));
                contentValues2.put("payload_encoding", c0055n.f161a.f13924a);
                contentValues2.put("code", c0050i.f146b);
                contentValues2.put("num_attempts", (Integer) 0);
                contentValues2.put("inline", Boolean.valueOf(z7));
                contentValues2.put("payload", z7 ? bArr2 : new byte[0]);
                long jInsert2 = sQLiteDatabase.insert("events", null, contentValues2);
                if (!z7) {
                    int iCeil = (int) Math.ceil(((double) bArr2.length) / ((double) i15));
                    for (int i16 = 1; i16 <= iCeil; i16++) {
                        byte[] bArrCopyOfRange = Arrays.copyOfRange(bArr2, (i16 - 1) * i15, Math.min(i16 * i15, bArr2.length));
                        ContentValues contentValues3 = new ContentValues();
                        contentValues3.put("event_id", Long.valueOf(jInsert2));
                        contentValues3.put("sequence_num", Integer.valueOf(i16));
                        contentValues3.put("bytes", bArrCopyOfRange);
                        sQLiteDatabase.insert("event_payloads", null, contentValues3);
                    }
                }
                for (Map.Entry entry : Collections.unmodifiableMap(c0050i.f150f).entrySet()) {
                    ContentValues contentValues4 = new ContentValues();
                    contentValues4.put("event_id", Long.valueOf(jInsert2));
                    contentValues4.put(SerializableCookie.NAME, (String) entry.getKey());
                    contentValues4.put("value", (String) entry.getValue());
                    sQLiteDatabase.insert("event_metadata", null, contentValues4);
                }
                return Long.valueOf(jInsert2);
            case 6:
                Cursor cursor = (Cursor) obj;
                C2702g c2702g3 = (C2702g) obj4;
                c2702g3.getClass();
                while (cursor.moveToNext()) {
                    long j11 = cursor.getLong(0);
                    boolean z10 = cursor.getInt(7) != 0;
                    C0049h c0049h = new C0049h();
                    c0049h.f144f = new HashMap();
                    String string = cursor.getString(i14);
                    if (string == null) {
                        throw new NullPointerException("Null transportName");
                    }
                    c0049h.f139a = string;
                    c0049h.f142d = Long.valueOf(cursor.getLong(i12));
                    c0049h.f143e = Long.valueOf(cursor.getLong(3));
                    if (z10) {
                        String string2 = cursor.getString(4);
                        c0049h.f141c = new C0055n(string2 == null ? C2702g.f9386f : new C4106b(string2), cursor.getBlob(5));
                        c2702g = c2702g3;
                    } else {
                        String string3 = cursor.getString(4);
                        C4106b c4106b = string3 == null ? C2702g.f9386f : new C4106b(string3);
                        Cursor cursorQuery = c2702g3.m5697a().query("event_payloads", new String[]{"bytes"}, "event_id = ?", new String[]{String.valueOf(j11)}, null, null, "sequence_num");
                        try {
                            ArrayList arrayList = new ArrayList();
                            int length2 = 0;
                            while (cursorQuery.moveToNext()) {
                                byte[] blob = cursorQuery.getBlob(0);
                                arrayList.add(blob);
                                length2 += blob.length;
                            }
                            byte[] bArr3 = new byte[length2];
                            int i17 = 0;
                            int length3 = 0;
                            while (i17 < arrayList.size()) {
                                byte[] bArr4 = (byte[]) arrayList.get(i17);
                                ArrayList arrayList2 = arrayList;
                                C2702g c2702g4 = c2702g3;
                                System.arraycopy(bArr4, 0, bArr3, length3, bArr4.length);
                                length3 += bArr4.length;
                                i17++;
                                arrayList = arrayList2;
                                c2702g3 = c2702g4;
                            }
                            c2702g = c2702g3;
                            cursorQuery.close();
                            c0049h.f141c = new C0055n(c4106b, bArr3);
                        } catch (Throwable th) {
                            cursorQuery.close();
                            throw th;
                        }
                    }
                    if (!cursor.isNull(6)) {
                        c0049h.f140b = Integer.valueOf(cursor.getInt(6));
                    }
                    ((ArrayList) obj3).add(new C2697b(j11, (C0051j) obj2, c0049h.m198c()));
                    c2702g3 = c2702g;
                    i12 = 2;
                    i14 = 1;
                }
                return null;
            default:
                Cursor cursor2 = (Cursor) obj;
                C2702g c2702g5 = (C2702g) obj4;
                c2702g5.getClass();
                while (true) {
                    HashMap map = (HashMap) obj3;
                    if (cursor2.moveToNext()) {
                        String string4 = cursor2.getString(i13);
                        int i18 = cursor2.getInt(1);
                        EnumC2411c enumC2411c4 = EnumC2411c.REASON_UNKNOWN;
                        if (i18 != 0) {
                            if (i18 == 1) {
                                enumC2411c4 = EnumC2411c.MESSAGE_TOO_OLD;
                            } else if (i18 == 2) {
                                enumC2411c = enumC2411c3;
                                enumC2411c2 = enumC2411c;
                            } else if (i18 == i11) {
                                enumC2411c4 = EnumC2411c.PAYLOAD_TOO_BIG;
                            } else if (i18 == i10) {
                                enumC2411c4 = EnumC2411c.MAX_RETRIES_REACHED;
                            } else if (i18 == i6) {
                                enumC2411c4 = EnumC2411c.INVALID_PAYLOD;
                            } else if (i18 == 6) {
                                enumC2411c4 = EnumC2411c.SERVER_ERROR;
                            } else {
                                AbstractC3280d.m6591i("SQLiteEventStore", "%n is not valid. No matched LogEventDropped-Reason found. Treated it as REASON_UNKNOWN", Integer.valueOf(i18));
                            }
                            enumC2411c2 = enumC2411c3;
                            enumC2411c = enumC2411c4;
                        } else {
                            enumC2411c2 = enumC2411c3;
                            enumC2411c = enumC2411c4;
                        }
                        long j12 = cursor2.getLong(2);
                        if (!map.containsKey(string4)) {
                            map.put(string4, new ArrayList());
                        }
                        ((List) map.get(string4)).add(new C2412d(j12, enumC2411c));
                        enumC2411c3 = enumC2411c2;
                        i6 = 5;
                        i10 = 4;
                        i11 = 3;
                        i13 = 0;
                    } else {
                        Iterator it = map.entrySet().iterator();
                        while (true) {
                            C0023f c0023f = (C0023f) obj2;
                            if (!it.hasNext()) {
                                long jMo5893c = c2702g5.f9388b.mo5893c();
                                SQLiteDatabase sQLiteDatabaseM5697a = c2702g5.m5697a();
                                sQLiteDatabaseM5697a.beginTransaction();
                                try {
                                    Cursor cursorRawQuery = sQLiteDatabaseM5697a.rawQuery("SELECT last_metrics_upload_ms FROM global_log_event_state LIMIT 1", new String[0]);
                                    try {
                                        cursorRawQuery.moveToNext();
                                        C2415g c2415g = new C2415g(cursorRawQuery.getLong(0), jMo5893c);
                                        cursorRawQuery.close();
                                        sQLiteDatabaseM5697a.setTransactionSuccessful();
                                        sQLiteDatabaseM5697a.endTransaction();
                                        c0023f.f44b = c2415g;
                                        c0023f.f45c = new C2410b(new C2414f(c2702g5.m5697a().compileStatement("PRAGMA page_size").simpleQueryForLong() * c2702g5.m5697a().compileStatement("PRAGMA page_count").simpleQueryForLong(), C2696a.f9375f.f9376a));
                                        c0023f.f47e = (String) c2702g5.f9391e.get();
                                        return new C2409a((C2415g) c0023f.f44b, Collections.unmodifiableList((ArrayList) c0023f.f46d), (C2410b) c0023f.f45c, (String) c0023f.f47e);
                                    } catch (Throwable th2) {
                                        cursorRawQuery.close();
                                        throw th2;
                                    }
                                } catch (Throwable th3) {
                                    sQLiteDatabaseM5697a.endTransaction();
                                    throw th3;
                                }
                            }
                            Map.Entry entry2 = (Map.Entry) it.next();
                            int i19 = C2413e.f8416c;
                            new ArrayList();
                            ((ArrayList) c0023f.f46d).add(new C2413e((String) entry2.getKey(), Collections.unmodifiableList((List) entry2.getValue())));
                        }
                    }
                }
                break;
        }
    }

    @Override
    public List create(int i6, TrackGroup trackGroup, int[] iArr) {
        return DefaultTrackSelector.lambda$selectTextTrack$4((DefaultTrackSelector.Parameters) this.f2858c, (String) this.f2857b, (String) this.f2859d, i6, trackGroup, iArr);
    }

    @Override
    public Object execute() {
        C2611a c2611a = (C2611a) this.f2858c;
        C2702g c2702g = (C2702g) c2611a.f9088d;
        c2702g.getClass();
        C0051j c0051j = (C0051j) this.f2857b;
        C0050i c0050i = (C0050i) this.f2859d;
        android.util.Log.d("TransportRuntime.".concat("SQLiteEventStore"), "Storing event with priority=" + c0051j.f153c + ", name=" + c0050i.f145a + " for destination " + c0051j.f151a);
        ((Long) c2702g.m5698c(new C0775b(c2702g, c0050i, c0051j, 5))).getClass();
        c2611a.f9085a.m5668a(c0051j, 1, false);
        return null;
    }
}
