package com.google.android.gms.internal.cast;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import java.math.BigInteger;
import java.util.Map;
import p018b5.AbstractC1312l;
import p230v4.C3988b;

public final class C1652p2 {

    public static final C3988b f5537d = new C3988b("ApplicationAnalyticsUtils", null);

    public static final String f5538e = "22.1.0";

    public final String f5539a;

    public final Map f5540b;

    public final Map f5541c;

    public C1652p2(String str, Bundle bundle) {
        this.f5539a = str;
        this.f5540b = AbstractC1503a1.m3697h("com.google.android.gms.cast.DICTIONARY_CAST_STATUS_CODES_TO_APP_SESSION_ERROR", bundle);
        this.f5541c = AbstractC1503a1.m3697h("com.google.android.gms.cast.DICTIONARY_CAST_STATUS_CODES_TO_APP_SESSION_CHANGE_REASON", bundle);
    }

    public final C1585i3 m3970a(C1634n2 c1634n2, int i6) {
        int iIntValue;
        int iIntValue2;
        C1575h3 c1575h3M3971b = m3971b(c1634n2);
        C1515b3 c1515b3M3745m = C1525c3.m3745m(c1575h3M3971b.m3837d());
        Map map = this.f5541c;
        if (map != null) {
            Integer numValueOf = Integer.valueOf(i6);
            if (map.containsKey(numValueOf)) {
                Integer num = (Integer) map.get(numValueOf);
                AbstractC1312l.m3198e(num);
                iIntValue = num.intValue();
            } else {
                iIntValue = i6 + 10000;
            }
        } else {
            iIntValue = i6 + 10000;
        }
        c1515b3M3745m.m3841c();
        C1525c3.m3753u((C1525c3) c1515b3M3745m.f5338b, iIntValue);
        Map map2 = this.f5540b;
        if (map2 != null) {
            Integer numValueOf2 = Integer.valueOf(i6);
            if (map2.containsKey(numValueOf2)) {
                Integer num2 = (Integer) map2.get(numValueOf2);
                AbstractC1312l.m3198e(num2);
                iIntValue2 = num2.intValue();
            } else {
                iIntValue2 = i6 + 10000;
            }
        } else {
            iIntValue2 = i6 + 10000;
        }
        c1515b3M3745m.m3841c();
        C1525c3.m3749q((C1525c3) c1515b3M3745m.f5338b, iIntValue2);
        c1575h3M3971b.m3838e((C1525c3) c1515b3M3745m.m3839a());
        return (C1585i3) c1575h3M3971b.m3839a();
    }

    public final C1575h3 m3971b(C1634n2 c1634n2) {
        int i6;
        long jLongValue;
        C1575h3 c1575h3M3848m = C1585i3.m3848m();
        long j10 = c1634n2.f5429d;
        c1575h3M3848m.m3841c();
        C1585i3.m3861z((C1585i3) c1575h3M3848m.f5338b, j10);
        int i10 = c1634n2.f5430e;
        c1634n2.f5430e = i10 + 1;
        c1575h3M3848m.m3841c();
        C1585i3.m3855t((C1585i3) c1575h3M3848m.f5338b, i10);
        String str = c1634n2.f5428c;
        if (str != null) {
            c1575h3M3848m.m3841c();
            C1585i3.m3858w((C1585i3) c1575h3M3848m.f5338b, str);
        }
        C1617l5 c1617l5M3943l = C1627m5.m3943l();
        if (!TextUtils.isEmpty(c1634n2.f5433h)) {
            String str2 = c1634n2.f5433h;
            c1575h3M3848m.m3841c();
            C1585i3.m3854s((C1585i3) c1575h3M3848m.f5338b, str2);
            String str3 = c1634n2.f5433h;
            c1617l5M3943l.m3841c();
            C1627m5.m3946o((C1627m5) c1617l5M3943l.f5338b, str3);
        }
        if (!TextUtils.isEmpty(c1634n2.f5434i)) {
            String str4 = c1634n2.f5434i;
            c1617l5M3943l.m3841c();
            C1627m5.m3947p((C1627m5) c1617l5M3943l.f5338b, str4);
        }
        if (!TextUtils.isEmpty(c1634n2.f5435j)) {
            String str5 = c1634n2.f5435j;
            c1617l5M3943l.m3841c();
            C1627m5.m3948q((C1627m5) c1617l5M3943l.f5338b, str5);
        }
        if (!TextUtils.isEmpty(c1634n2.f5436k)) {
            String str6 = c1634n2.f5436k;
            c1617l5M3943l.m3841c();
            C1627m5.m3944m((C1627m5) c1617l5M3943l.f5338b, str6);
        }
        if (!TextUtils.isEmpty(c1634n2.f5437l)) {
            String str7 = c1634n2.f5437l;
            c1617l5M3943l.m3841c();
            C1627m5.m3945n((C1627m5) c1617l5M3943l.f5338b, str7);
        }
        if (!TextUtils.isEmpty(c1634n2.f5438m)) {
            String str8 = c1634n2.f5438m;
            c1617l5M3943l.m3841c();
            C1627m5.m3949r((C1627m5) c1617l5M3943l.f5338b, str8);
        }
        int i11 = c1634n2.f5439n;
        if (i11 != 1) {
            i6 = 3;
            if (i11 != 2) {
                if (i11 != 3) {
                    i6 = 5;
                    if (i11 != 4) {
                        i6 = i11 != 5 ? 1 : 6;
                    }
                } else {
                    i6 = 4;
                }
            }
        } else {
            i6 = 2;
        }
        c1617l5M3943l.m3841c();
        C1627m5.m3950s((C1627m5) c1617l5M3943l.f5338b, i6);
        C1627m5 c1627m5 = (C1627m5) c1617l5M3943l.m3839a();
        c1575h3M3848m.m3841c();
        C1585i3.m3857v((C1585i3) c1575h3M3848m.f5338b, c1627m5);
        C1733y2 c1733y2M4061l = C1742z2.m4061l();
        c1733y2M4061l.m3841c();
        C1742z2.m4063n((C1742z2) c1733y2M4061l.f5338b, f5538e);
        c1733y2M4061l.m3841c();
        C1742z2.m4062m((C1742z2) c1733y2M4061l.f5338b, this.f5539a);
        C1742z2 c1742z2 = (C1742z2) c1733y2M4061l.m3839a();
        c1575h3M3848m.m3841c();
        C1585i3.m3850o((C1585i3) c1575h3M3848m.f5338b, c1742z2);
        C1515b3 c1515b3M3744l = C1525c3.m3744l();
        if (c1634n2.f5427b != null) {
            C1743z3 c1743z3M3715l = C1506a4.m3715l();
            String str9 = c1634n2.f5427b;
            c1743z3M3715l.m3841c();
            C1506a4.m3716m((C1506a4) c1743z3M3715l.f5338b, str9);
            C1506a4 c1506a4 = (C1506a4) c1743z3M3715l.m3839a();
            c1515b3M3744l.m3841c();
            C1525c3.m3747o((C1525c3) c1515b3M3744l.f5338b, c1506a4);
        }
        c1515b3M3744l.m3841c();
        C1525c3.m3752t((C1525c3) c1515b3M3744l.f5338b, false);
        String str10 = c1634n2.f5431f;
        if (str10 != null) {
            try {
                String strReplace = str10.replace("-", "");
                jLongValue = new BigInteger(strReplace.substring(0, Math.min(16, strReplace.length())), 16).longValue();
            } catch (NumberFormatException e5) {
                Object[] objArr = {str10};
                C3988b c3988b = f5537d;
                Log.w(c3988b.f13521a, c3988b.m7977d("receiverSessionId %s is not valid for hash", objArr), e5);
                jLongValue = 0;
            }
            c1515b3M3744l.m3841c();
            C1525c3.m3754v((C1525c3) c1515b3M3744l.f5338b, jLongValue);
        }
        int i12 = c1634n2.f5432g;
        c1515b3M3744l.m3841c();
        C1525c3.m3748p((C1525c3) c1515b3M3744l.f5338b, i12);
        boolean z7 = c1634n2.f5426a.f5332f == 2;
        c1515b3M3744l.m3841c();
        C1525c3.m3750r((C1525c3) c1515b3M3744l.f5338b, z7);
        boolean z10 = c1634n2.f5440o;
        c1515b3M3744l.m3841c();
        C1525c3.m3751s((C1525c3) c1515b3M3744l.f5338b, z10);
        c1575h3M3848m.m3841c();
        C1585i3.m3852q((C1585i3) c1575h3M3848m.f5338b, (C1525c3) c1515b3M3744l.m3839a());
        return c1575h3M3848m;
    }
}
