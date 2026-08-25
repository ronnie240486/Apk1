package com.google.android.gms.internal.cast;

import android.content.SharedPreferences;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import p055ea.AbstractC2460q;
import p242w5.C4056d;

public final class RunnableC1502a0 implements Runnable {

    public final int f5197a;

    public final Object f5198b;

    public RunnableC1502a0(int i6, Object obj) {
        this.f5197a = i6;
        this.f5198b = obj;
    }

    @Override
    public final void run() {
        switch (this.f5197a) {
            case 0:
                C1512b0.f5213d.m7975b("get checkbox consent timed out", new Object[0]);
                ((C4056d) this.f5198b).m8061d(Boolean.FALSE);
                return;
            case 1:
                List list = ((C1677s0) this.f5198b).f5597e;
                if (list != null) {
                    list.isEmpty();
                }
                throw null;
            case 2:
                C1624m2 c1624m2 = (C1624m2) this.f5198b;
                C1634n2 c1634n2 = c1624m2.f5414g;
                if (c1634n2 != null) {
                    c1624m2.f5408a.m4015a((C1585i3) c1624m2.f5410c.m3971b(c1634n2).m3839a(), 223);
                }
                c1624m2.m3936e();
                return;
            default:
                C1670r2 c1670r2 = (C1670r2) this.f5198b;
                HashSet hashSet = c1670r2.f5584f;
                if (hashSet.isEmpty()) {
                    return;
                }
                HashSet hashSet2 = c1670r2.f5585g;
                long j10 = true != hashSet2.equals(hashSet) ? 86400000L : 172800000L;
                long jCurrentTimeMillis = System.currentTimeMillis();
                long j11 = c1670r2.f5586h;
                if (j11 == 0 || jCurrentTimeMillis - j11 >= j10) {
                    C1670r2.f5576i.m7975b("Upload the feature usage report.", new Object[0]);
                    C1733y2 c1733y2M4061l = C1742z2.m4061l();
                    String str = C1670r2.f5577j;
                    c1733y2M4061l.m3841c();
                    C1742z2.m4063n((C1742z2) c1733y2M4061l.f5338b, str);
                    c1733y2M4061l.m3841c();
                    C1742z2.m4062m((C1742z2) c1733y2M4061l.f5338b, c1670r2.f5581c);
                    C1742z2 c1742z2 = (C1742z2) c1733y2M4061l.m3839a();
                    ArrayList arrayList = new ArrayList();
                    arrayList.addAll(hashSet);
                    C1697u2 c1697u2M4033l = C1706v2.m4033l();
                    c1697u2M4033l.m3841c();
                    C1706v2.m4034m((C1706v2) c1697u2M4033l.f5338b, arrayList);
                    c1697u2M4033l.m3841c();
                    C1706v2.m4035n((C1706v2) c1697u2M4033l.f5338b, c1742z2);
                    C1706v2 c1706v2 = (C1706v2) c1697u2M4033l.m3839a();
                    C1575h3 c1575h3M3848m = C1585i3.m3848m();
                    c1575h3M3848m.m3841c();
                    C1585i3.m3851p((C1585i3) c1575h3M3848m.f5338b, c1706v2);
                    c1670r2.f5579a.m4015a((C1585i3) c1575h3M3848m.m3839a(), 243);
                    SharedPreferences sharedPreferences = c1670r2.f5580b;
                    SharedPreferences.Editor editorEdit = sharedPreferences.edit();
                    if (!hashSet2.equals(hashSet)) {
                        hashSet2.clear();
                        hashSet2.addAll(hashSet);
                        Iterator it = hashSet2.iterator();
                        while (it.hasNext()) {
                            String string = Integer.toString(((EnumC1679s2) it.next()).f5672a);
                            String strM5501o = AbstractC2460q.m5501o("feature_usage_timestamp_reported_feature_", string);
                            if (!sharedPreferences.contains(strM5501o)) {
                                strM5501o = AbstractC2460q.m5501o("feature_usage_timestamp_detected_feature_", string);
                            }
                            String strM5501o2 = AbstractC2460q.m5501o("feature_usage_timestamp_reported_feature_", string);
                            if (!TextUtils.equals(strM5501o, strM5501o2)) {
                                long j12 = sharedPreferences.getLong(strM5501o, 0L);
                                editorEdit.remove(strM5501o);
                                if (j12 != 0) {
                                    editorEdit.putLong(strM5501o2, j12);
                                }
                            }
                        }
                    }
                    c1670r2.f5586h = jCurrentTimeMillis;
                    editorEdit.putLong("feature_usage_last_report_time", jCurrentTimeMillis).apply();
                    return;
                }
                return;
        }
    }
}
