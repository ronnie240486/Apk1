package com.tencent.bugly.proguard;

import android.content.ContentValues;
import android.database.Cursor;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Pair;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import p000a.AbstractC0004e;
import p000a.RunnableC0005f;

public final class C2024ag {

    private final SimpleDateFormat f7267a;

    private final C2021ad f7268b;

    public static class a {

        private static final C2024ag f7269a = new C2024ag(0);
    }

    public static class b {

        String f7270a;

        public long f7271b;

        public String f7272c;

        public final String toString() {
            StringBuilder sb = new StringBuilder("SLAData{uuid='");
            sb.append(this.f7270a);
            sb.append("', time=");
            sb.append(this.f7271b);
            sb.append(", data='");
            return AbstractC0004e.m26t(sb, this.f7272c, "'}");
        }
    }

    public C2024ag(byte b8) {
        this();
    }

    public static void m4598c(List<b> list) {
        if (list == null || list.isEmpty()) {
            C2029al.m4644c("sla batch report data is empty", new Object[0]);
            return;
        }
        C2029al.m4644c("sla batch report list size:%s", Integer.valueOf(list.size()));
        if (list.size() > 30) {
            list = list.subList(0, 29);
        }
        ArrayList arrayList = new ArrayList();
        Iterator<b> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(it.next().f7272c);
        }
        Pair<Integer, String> pairM4581a = C2021ad.m4581a(arrayList);
        C2029al.m4644c("sla batch report result, rspCode:%s rspMsg:%s", pairM4581a.first, pairM4581a.second);
        if (((Integer) pairM4581a.first).intValue() == 200) {
            m4599d(list);
        }
    }

    public static void m4599d(List<b> list) {
        if (list == null || list.isEmpty()) {
            C2029al.m4644c("sla batch delete list is null", new Object[0]);
            return;
        }
        C2029al.m4644c("sla batch delete list size:%s", Integer.valueOf(list.size()));
        try {
            String str = "_id in (" + m4595a(",", list) + ")";
            C2029al.m4644c("sla batch delete where:%s", str);
            C2103w.m5011a().m5024a("t_sla", str);
        } catch (Throwable th) {
            C2029al.m4643b(th);
        }
    }

    private static void m4600e(List<b> list) {
        for (b bVar : list) {
            C2029al.m4644c("sla save id:%s time:%s msg:%s", bVar.f7270a, Long.valueOf(bVar.f7271b), bVar.f7272c);
            try {
                ContentValues contentValues = new ContentValues();
                contentValues.put("_id", bVar.f7270a);
                contentValues.put("_tm", Long.valueOf(bVar.f7271b));
                contentValues.put("_dt", bVar.f7272c);
                C2103w.m5011a().m5025a("t_sla", contentValues, (InterfaceC2102v) null);
            } catch (Throwable th) {
                C2029al.m4643b(th);
            }
        }
    }

    public final void m4602a(List<c> list) {
        if (list == null || list.isEmpty()) {
            C2029al.m4645d("sla batch report event is null", new Object[0]);
            return;
        }
        C2029al.m4644c("sla batch report event size:%s", Integer.valueOf(list.size()));
        ArrayList arrayList = new ArrayList();
        Iterator<c> it = list.iterator();
        while (it.hasNext()) {
            b bVarM4597b = m4597b(it.next());
            if (bVarM4597b != null) {
                arrayList.add(bVarM4597b);
            }
        }
        m4600e(arrayList);
        m4603b(arrayList);
    }

    public final void m4603b(List<b> list) {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            C2028ak.m4631a().m4633a(new RunnableC0005f(11, list));
        } else {
            m4598c(list);
        }
    }

    private C2024ag() {
        this.f7267a = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SSS", Locale.US);
        this.f7268b = new C2021ad();
    }

    private b m4597b(c cVar) {
        if (cVar != null && !TextUtils.isEmpty(cVar.f7274b)) {
            C2018aa c2018aaM4509b = C2018aa.m4509b();
            if (c2018aaM4509b == null) {
                C2029al.m4645d("sla convert failed because ComInfoManager is null", new Object[0]);
                return null;
            }
            StringBuilder sb = new StringBuilder("&app_version=");
            sb.append(c2018aaM4509b.f7239o);
            sb.append("&app_name=");
            sb.append(c2018aaM4509b.f7241q);
            sb.append("&app_bundle_id=");
            sb.append(c2018aaM4509b.f7227c);
            sb.append("&client_type=android&user_id=");
            sb.append(c2018aaM4509b.m4524f());
            sb.append("&sdk_version=");
            sb.append(c2018aaM4509b.f7232h);
            sb.append("&event_code=");
            sb.append(cVar.f7274b);
            sb.append("&event_result=");
            sb.append(cVar.f7276d ? 1 : 0);
            sb.append("&event_time=");
            sb.append(this.f7267a.format(new Date(cVar.f7275c)));
            sb.append("&event_cost=");
            sb.append(cVar.f7277e);
            sb.append("&device_id=");
            sb.append(c2018aaM4509b.m4526g());
            sb.append("&debug=");
            sb.append(c2018aaM4509b.f7179D ? 1 : 0);
            sb.append("&param_0=");
            sb.append(cVar.f7278f);
            sb.append("&param_1=");
            sb.append(cVar.f7273a);
            sb.append("&param_2=");
            sb.append(c2018aaM4509b.f7188M ? "rqd" : "ext");
            sb.append("&param_4=");
            sb.append(c2018aaM4509b.m4522e());
            String string = sb.toString();
            if (!TextUtils.isEmpty(cVar.f7279g)) {
                StringBuilder sbM29w = AbstractC0004e.m29w(string, "&param_3=");
                sbM29w.append(cVar.f7279g);
                string = sbM29w.toString();
            }
            C2029al.m4644c("sla convert eventId:%s eventType:%s, eventTime:%s success:%s cost:%s from:%s uploadMsg:", cVar.f7273a, cVar.f7274b, Long.valueOf(cVar.f7275c), Boolean.valueOf(cVar.f7276d), Long.valueOf(cVar.f7277e), cVar.f7278f, cVar.f7279g);
            String str = cVar.f7273a + "-" + cVar.f7274b;
            b bVar = new b();
            bVar.f7270a = str;
            bVar.f7271b = cVar.f7275c;
            bVar.f7272c = string;
            return bVar;
        }
        C2029al.m4645d("sla convert event is null", new Object[0]);
        return null;
    }

    public static class c {

        String f7273a;

        String f7274b;

        long f7275c;

        boolean f7276d;

        long f7277e;

        String f7278f;

        String f7279g;

        public c(String str, String str2, long j10, boolean z7, long j11, String str3, String str4) {
            this.f7273a = str;
            this.f7274b = str2;
            this.f7275c = j10;
            this.f7276d = z7;
            this.f7277e = j11;
            this.f7278f = str3;
            this.f7279g = str4;
        }

        public c() {
        }
    }

    private static String m4595a(String str, Iterable<b> iterable) {
        Iterator<b> it = iterable.iterator();
        if (!it.hasNext()) {
            return "";
        }
        StringBuilder sb = new StringBuilder("'");
        sb.append(it.next().f7270a);
        sb.append("'");
        while (it.hasNext()) {
            sb.append(str);
            sb.append("'");
            sb.append(it.next().f7270a);
            sb.append("'");
        }
        return sb.toString();
    }

    public static List<b> m4596a() {
        Cursor cursorM5027a = C2103w.m5011a().m5027a("t_sla", new String[]{"_id", "_tm", "_dt"}, (String) null, "_tm", "30");
        if (cursorM5027a == null) {
            return null;
        }
        if (cursorM5027a.getCount() <= 0) {
            cursorM5027a.close();
            return null;
        }
        ArrayList arrayList = new ArrayList();
        while (cursorM5027a.moveToNext()) {
            try {
                b bVar = new b();
                bVar.f7270a = cursorM5027a.getString(cursorM5027a.getColumnIndex("_id"));
                bVar.f7271b = cursorM5027a.getLong(cursorM5027a.getColumnIndex("_tm"));
                bVar.f7272c = cursorM5027a.getString(cursorM5027a.getColumnIndex("_dt"));
                C2029al.m4644c(bVar.toString(), new Object[0]);
                arrayList.add(bVar);
            } catch (Throwable th) {
                try {
                    C2029al.m4643b(th);
                } finally {
                    cursorM5027a.close();
                }
            }
        }
        return arrayList;
    }

    public final void m4601a(c cVar) {
        if (TextUtils.isEmpty(cVar.f7274b)) {
            C2029al.m4645d("sla report event is null", new Object[0]);
        } else {
            C2029al.m4644c("sla report single event", new Object[0]);
            m4602a(Collections.singletonList(cVar));
        }
    }
}
