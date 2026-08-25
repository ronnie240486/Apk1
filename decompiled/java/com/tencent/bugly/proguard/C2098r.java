package com.tencent.bugly.proguard;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import androidx.lifecycle.RunnableC0552u0;
import com.google.android.material.datepicker.RunnableC1790i;
import com.tencent.bugly.crashreport.biz.UserInfoBean;
import com.tencent.bugly.crashreport.common.strategy.StrategyBean;
import java.io.BufferedReader;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import p007a7.C0069f;

public final class C2098r {

    private static boolean f7668e = true;

    private Context f7669a;

    private long f7670b;

    private int f7671c;

    private boolean f7672d;

    public C2098r(Context context, boolean z7) {
        this.f7669a = context;
        this.f7672d = z7;
    }

    private static void m4964b(List<UserInfoBean> list, List<UserInfoBean> list2) {
        Iterator<UserInfoBean> it = list.iterator();
        while (it.hasNext()) {
            UserInfoBean next = it.next();
            if (next.f7052f != -1) {
                it.remove();
                if (next.f7051e < C2033ap.m4695b()) {
                    list2.add(next);
                }
            }
        }
    }

    public final void m4967a(int i6, boolean z7) {
        C2020ac c2020acM4570a = C2020ac.m4570a();
        if (c2020acM4570a != null && !c2020acM4570a.m4579c().f7075g && i6 != 1 && i6 != 3) {
            C2029al.m4646e("UserInfo is disable", new Object[0]);
            return;
        }
        if (i6 == 1 || i6 == 3) {
            this.f7671c++;
        }
        C2018aa c2018aaM4507a = C2018aa.m4507a(this.f7669a);
        UserInfoBean userInfoBean = new UserInfoBean();
        userInfoBean.f7048b = i6;
        userInfoBean.f7049c = c2018aaM4507a.f7228d;
        userInfoBean.f7050d = c2018aaM4507a.m4524f();
        userInfoBean.f7051e = System.currentTimeMillis();
        userInfoBean.f7052f = -1L;
        userInfoBean.f7060n = c2018aaM4507a.f7239o;
        userInfoBean.f7061o = i6 == 1 ? 1 : 0;
        userInfoBean.f7058l = c2018aaM4507a.m4515a();
        userInfoBean.f7059m = c2018aaM4507a.f7249y;
        userInfoBean.f7053g = c2018aaM4507a.f7250z;
        userInfoBean.f7054h = c2018aaM4507a.f7176A;
        userInfoBean.f7055i = c2018aaM4507a.f7177B;
        userInfoBean.f7057k = c2018aaM4507a.f7178C;
        userInfoBean.f7064r = c2018aaM4507a.m4539t();
        userInfoBean.f7065s = c2018aaM4507a.m4544y();
        userInfoBean.f7062p = c2018aaM4507a.m4545z();
        userInfoBean.f7063q = c2018aaM4507a.f7248x;
        C2028ak.m4631a().m4634a(new RunnableC0552u0(this, userInfoBean, z7), 0L);
    }

    public final void m4969b() {
        C2028ak c2028akM4631a = C2028ak.m4631a();
        if (c2028akM4631a != null) {
            c2028akM4631a.m4633a(new RunnableC2091n0(this, 0));
        }
    }

    private static void m4963b(List<UserInfoBean> list) {
        if (list.size() == 0) {
            return;
        }
        StringBuilder sb = new StringBuilder();
        for (int i6 = 0; i6 < list.size() && i6 < 50; i6++) {
            UserInfoBean userInfoBean = list.get(i6);
            sb.append(" or _id = ");
            sb.append(userInfoBean.f7047a);
        }
        String string = sb.toString();
        if (string.length() > 0) {
            string = string.substring(4);
        }
        sb.setLength(0);
        try {
            C2029al.m4644c("[Database] deleted %s data %d", "t_ui", Integer.valueOf(C2103w.m5011a().m5024a("t_ui", string)));
        } catch (Throwable th) {
            if (C2029al.m4641a(th)) {
                return;
            }
            th.printStackTrace();
        }
    }

    private static ContentValues m4962b(UserInfoBean userInfoBean) {
        if (userInfoBean == null) {
            return null;
        }
        try {
            ContentValues contentValues = new ContentValues();
            long j10 = userInfoBean.f7047a;
            if (j10 > 0) {
                contentValues.put("_id", Long.valueOf(j10));
            }
            contentValues.put("_tm", Long.valueOf(userInfoBean.f7051e));
            contentValues.put("_ut", Long.valueOf(userInfoBean.f7052f));
            contentValues.put("_tp", Integer.valueOf(userInfoBean.f7048b));
            contentValues.put("_pc", userInfoBean.f7049c);
            contentValues.put("_dt", C2033ap.m4692a(userInfoBean));
            return contentValues;
        } catch (Throwable th) {
            if (!C2029al.m4641a(th)) {
                th.printStackTrace();
            }
            return null;
        }
    }

    public final void m4968a(long j10) {
        C2028ak.m4631a().m4634a(new RunnableC1790i(this, j10, 1), j10);
    }

    public final void m4966a() {
        this.f7670b = C2033ap.m4695b() + 86400000;
        C2028ak.m4631a().m4634a(new RunnableC2091n0(this, 1), (this.f7670b - System.currentTimeMillis()) + 5000);
    }

    private boolean m4965b(boolean z7) {
        boolean z10 = true;
        if (!f7668e) {
            return true;
        }
        File file = new File(this.f7669a.getFilesDir(), "bugly_last_us_up_tm");
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (z7) {
            C2030am.m4650a(file, String.valueOf(jCurrentTimeMillis), 1024L, false);
            return true;
        }
        if (!file.exists()) {
            C2030am.m4650a(file, String.valueOf(jCurrentTimeMillis), 1024L, false);
        } else {
            BufferedReader bufferedReaderM4672a = C2033ap.m4672a(file);
            try {
                if (bufferedReaderM4672a != null) {
                    try {
                        long jLongValue = Long.valueOf(bufferedReaderM4672a.readLine().trim()).longValue();
                        if (jCurrentTimeMillis < jLongValue || jCurrentTimeMillis - jLongValue > 86400000 || jCurrentTimeMillis - jLongValue >= 300000) {
                            C2030am.m4650a(file, String.valueOf(jCurrentTimeMillis), 1024L, false);
                        } else {
                            z10 = false;
                        }
                        if (bufferedReaderM4672a != null) {
                            bufferedReaderM4672a.close();
                        }
                    } catch (Throwable th) {
                        try {
                            C2029al.m4643b(th);
                            C2030am.m4650a(file, String.valueOf(jCurrentTimeMillis), 1024L, false);
                            bufferedReaderM4672a.close();
                        } catch (Throwable th2) {
                            try {
                                bufferedReaderM4672a.close();
                            } catch (Exception e5) {
                                C2029al.m4641a(e5);
                            }
                            throw th2;
                        }
                    }
                } else if (bufferedReaderM4672a != null) {
                    bufferedReaderM4672a.close();
                }
            } catch (Exception e10) {
                C2029al.m4641a(e10);
            }
        }
        return z10;
    }

    private static void m4957a(List<UserInfoBean> list, List<UserInfoBean> list2) {
        int size = list.size() - 20;
        if (size > 0) {
            int i6 = 0;
            while (i6 < list.size() - 1) {
                int i10 = i6 + 1;
                for (int i11 = i10; i11 < list.size(); i11++) {
                    if (list.get(i6).f7051e > list.get(i11).f7051e) {
                        UserInfoBean userInfoBean = list.get(i6);
                        list.set(i6, list.get(i11));
                        list.set(i11, userInfoBean);
                    }
                }
                i6 = i10;
            }
            for (int i12 = 0; i12 < size; i12++) {
                list2.add(list.get(i12));
            }
        }
    }

    private static int m4950a(List<UserInfoBean> list) {
        int i6;
        long jCurrentTimeMillis = System.currentTimeMillis();
        int i10 = 0;
        for (UserInfoBean userInfoBean : list) {
            if (userInfoBean.f7051e > jCurrentTimeMillis - 600000 && ((i6 = userInfoBean.f7048b) == 1 || i6 == 4 || i6 == 3)) {
                i10++;
            }
        }
        return i10;
    }

    private void m4958a(List<UserInfoBean> list, boolean z7) {
        C2018aa c2018aaM4509b;
        if (!m4965b(z7)) {
            long jCurrentTimeMillis = System.currentTimeMillis();
            for (UserInfoBean userInfoBean : list) {
                userInfoBean.f7052f = jCurrentTimeMillis;
                m4954a(userInfoBean, true);
            }
            C2029al.m4645d("uploadCheck failed", new Object[0]);
            return;
        }
        int i6 = this.f7671c == 1 ? 1 : 2;
        C2067bv c2067bv = null;
        if (list != null && list.size() != 0 && (c2018aaM4509b = C2018aa.m4509b()) != null) {
            c2018aaM4509b.m4534o();
            C2067bv c2067bv2 = new C2067bv();
            c2067bv2.f7587b = c2018aaM4509b.f7228d;
            c2067bv2.f7588c = c2018aaM4509b.m4526g();
            ArrayList<C2066bu> arrayList = new ArrayList<>();
            Iterator<UserInfoBean> it = list.iterator();
            while (it.hasNext()) {
                C2066bu c2066buM4586a = C2022ae.m4586a(it.next());
                if (c2066buM4586a != null) {
                    arrayList.add(c2066buM4586a);
                }
            }
            c2067bv2.f7589d = arrayList;
            HashMap map = new HashMap();
            c2067bv2.f7590e = map;
            map.put("A7", "");
            c2067bv2.f7590e.put("A6", C2018aa.m4510n());
            c2067bv2.f7590e.put("A5", c2018aaM4509b.m4533m());
            Map<String, String> map2 = c2067bv2.f7590e;
            StringBuilder sb = new StringBuilder();
            sb.append(c2018aaM4509b.m4531k());
            map2.put("A2", sb.toString());
            Map<String, String> map3 = c2067bv2.f7590e;
            StringBuilder sb2 = new StringBuilder();
            sb2.append(c2018aaM4509b.m4531k());
            map3.put("A1", sb2.toString());
            c2067bv2.f7590e.put("A24", c2018aaM4509b.f7235k);
            Map<String, String> map4 = c2067bv2.f7590e;
            StringBuilder sb3 = new StringBuilder();
            sb3.append(c2018aaM4509b.m4532l());
            map4.put("A17", sb3.toString());
            c2067bv2.f7590e.put("A15", c2018aaM4509b.m4536q());
            Map<String, String> map5 = c2067bv2.f7590e;
            StringBuilder sb4 = new StringBuilder();
            sb4.append(c2018aaM4509b.m4537r());
            map5.put("A13", sb4.toString());
            c2067bv2.f7590e.put("F08", c2018aaM4509b.f7180E);
            c2067bv2.f7590e.put("F09", c2018aaM4509b.f7181F);
            Map<String, String> mapM4544y = c2018aaM4509b.m4544y();
            if (mapM4544y != null && mapM4544y.size() > 0) {
                for (Map.Entry<String, String> entry : mapM4544y.entrySet()) {
                    c2067bv2.f7590e.put("C04_" + entry.getKey(), entry.getValue());
                }
            }
            if (i6 == 1) {
                c2067bv2.f7586a = (byte) 1;
            } else if (i6 != 2) {
                C2029al.m4646e("unknown up type %d ", Integer.valueOf(i6));
            } else {
                c2067bv2.f7586a = (byte) 2;
            }
            c2067bv = c2067bv2;
        }
        if (c2067bv == null) {
            C2029al.m4645d("[UserInfo] Failed to create UserInfoPackage.", new Object[0]);
            return;
        }
        byte[] bArrM4588a = C2022ae.m4588a((AbstractC2088m) c2067bv);
        if (bArrM4588a == null) {
            C2029al.m4645d("[UserInfo] Failed to encode data.", new Object[0]);
            return;
        }
        C2062bq c2062bqM4584a = C2022ae.m4584a(this.f7669a, 840, bArrM4588a);
        if (c2062bqM4584a == null) {
            C2029al.m4645d("[UserInfo] Request package is null.", new Object[0]);
            return;
        }
        C2026ai.m4605a().m4620a(1001, c2062bqM4584a, C2020ac.m4570a().m4579c().f7085q, StrategyBean.f7069a, new C0069f(this, 14, list), this.f7671c == 1);
    }

    public void m4954a(UserInfoBean userInfoBean, boolean z7) {
        List<UserInfoBean> listM4952a;
        if (userInfoBean == null) {
            return;
        }
        if (!z7 && userInfoBean.f7048b != 1 && (listM4952a = m4952a(C2018aa.m4507a(this.f7669a).f7228d)) != null && listM4952a.size() >= 20) {
            C2029al.m4640a("[UserInfo] There are too many user info in local: %d", Integer.valueOf(listM4952a.size()));
            return;
        }
        long jM5025a = C2103w.m5011a().m5025a("t_ui", m4962b(userInfoBean), (InterfaceC2102v) null);
        if (jM5025a >= 0) {
            C2029al.m4644c("[Database] insert %s success with ID: %d", "t_ui", Long.valueOf(jM5025a));
            userInfoBean.f7047a = jM5025a;
        }
    }

    public static List<UserInfoBean> m4952a(String str) {
        Cursor cursorM5026a;
        String str2;
        try {
            if (C2033ap.m4703b(str)) {
                str2 = null;
            } else {
                str2 = "_pc = '" + str + "'";
            }
            cursorM5026a = C2103w.m5011a().m5026a("t_ui", (String[]) null, str2);
            if (cursorM5026a == null) {
                if (cursorM5026a != null) {
                    cursorM5026a.close();
                }
                return null;
            }
            try {
                StringBuilder sb = new StringBuilder();
                ArrayList arrayList = new ArrayList();
                while (cursorM5026a.moveToNext()) {
                    UserInfoBean userInfoBeanM4951a = m4951a(cursorM5026a);
                    if (userInfoBeanM4951a != null) {
                        arrayList.add(userInfoBeanM4951a);
                    } else {
                        try {
                            long j10 = cursorM5026a.getLong(cursorM5026a.getColumnIndex("_id"));
                            sb.append(" or _id = ");
                            sb.append(j10);
                        } catch (Throwable unused) {
                            C2029al.m4645d("[Database] unknown id.", new Object[0]);
                        }
                    }
                }
                String string = sb.toString();
                if (string.length() > 0) {
                    C2029al.m4645d("[Database] deleted %s error data %d", "t_ui", Integer.valueOf(C2103w.m5011a().m5024a("t_ui", string.substring(4))));
                }
                cursorM5026a.close();
                return arrayList;
            } catch (Throwable th) {
                th = th;
                try {
                    if (!C2029al.m4641a(th)) {
                        th.printStackTrace();
                    }
                    return null;
                } finally {
                    if (cursorM5026a != null) {
                        cursorM5026a.close();
                    }
                }
            }
        } catch (Throwable th2) {
            th = th2;
            cursorM5026a = null;
        }
    }

    private static UserInfoBean m4951a(Cursor cursor) {
        if (cursor == null) {
            return null;
        }
        try {
            byte[] blob = cursor.getBlob(cursor.getColumnIndex("_dt"));
            if (blob == null) {
                return null;
            }
            long j10 = cursor.getLong(cursor.getColumnIndex("_id"));
            UserInfoBean userInfoBean = (UserInfoBean) C2033ap.m4674a(blob, UserInfoBean.CREATOR);
            if (userInfoBean != null) {
                userInfoBean.f7047a = j10;
            }
            return userInfoBean;
        } catch (Throwable th) {
            if (!C2029al.m4641a(th)) {
                th.printStackTrace();
            }
            return null;
        }
    }

    public synchronized void m4959a(boolean z7) {
        C2026ai c2026aiM4605a;
        C2020ac c2020acM4570a;
        boolean z10;
        if (this.f7672d && (c2026aiM4605a = C2026ai.m4605a()) != null && (c2020acM4570a = C2020ac.m4570a()) != null && (!c2020acM4570a.m4578b() || c2026aiM4605a.m4622b(1001))) {
            String str = C2018aa.m4507a(this.f7669a).f7228d;
            ArrayList arrayList = new ArrayList();
            List<UserInfoBean> listM4952a = m4952a(str);
            if (listM4952a != null) {
                m4957a(listM4952a, arrayList);
                m4964b(listM4952a, arrayList);
                int iM4950a = m4950a(listM4952a);
                if (iM4950a > 15) {
                    C2029al.m4645d("[UserInfo] Upload user info too many times in 10 min: %d", Integer.valueOf(iM4950a));
                    z10 = false;
                }
                if (arrayList.size() > 0) {
                    m4963b(arrayList);
                }
                if (z10 && listM4952a.size() != 0) {
                    C2029al.m4644c("[UserInfo] Upload user info(size: %d)", Integer.valueOf(listM4952a.size()));
                    m4958a(listM4952a, z7);
                    return;
                }
                C2029al.m4644c("[UserInfo] There is no user info in local database.", new Object[0]);
            }
            listM4952a = new ArrayList<>();
            z10 = true;
            if (arrayList.size() > 0) {
                m4963b(arrayList);
            }
            if (z10) {
                C2029al.m4644c("[UserInfo] Upload user info(size: %d)", Integer.valueOf(listM4952a.size()));
                m4958a(listM4952a, z7);
                return;
            }
            C2029al.m4644c("[UserInfo] There is no user info in local database.", new Object[0]);
        }
    }

    public static void m4953a(UserInfoBean userInfoBean) {
        C2018aa c2018aaM4509b;
        if (userInfoBean == null || (c2018aaM4509b = C2018aa.m4509b()) == null) {
            return;
        }
        userInfoBean.f7056j = c2018aaM4509b.m4520d();
    }
}
