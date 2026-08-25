package com.tencent.bugly.proguard;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.os.Environment;
import android.text.TextUtils;
import android.util.Pair;
import androidx.media3.common.C0565C;
import com.tencent.bugly.BuglyStrategy;
import com.tencent.bugly.crashreport.common.info.PlugInBean;
import com.tencent.bugly.crashreport.common.strategy.StrategyBean;
import com.tencent.bugly.crashreport.crash.CrashDetailBean;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;
import p000a.AbstractC0004e;
import p055ea.AbstractC2460q;

public final class C2036as {

    public static int f7352a;

    private static final Map<Integer, Pair<String, String>> f7353h;

    private static final ArrayList<C2079h0> f7354i;

    private static final Map<Integer, Integer> f7355j;

    private static final Map<Integer, String> f7356k;

    private static final Map<Integer, String> f7357l;

    protected final Context f7358b;

    protected final C2026ai f7359c;

    protected final C2103w f7360d;

    protected final C2020ac f7361e;

    protected InterfaceC2040aw f7362f;

    protected BuglyStrategy.C2006a f7363g;

    static {
        C2017a0 c2017a0 = new C2017a0();
        c2017a0.put(3, new Pair("203", "103"));
        c2017a0.put(7, new Pair("208", "108"));
        c2017a0.put(0, new Pair("200", "100"));
        c2017a0.put(1, new Pair("201", "101"));
        c2017a0.put(2, new Pair("202", "102"));
        c2017a0.put(4, new Pair("204", "104"));
        c2017a0.put(6, new Pair("206", "106"));
        c2017a0.put(5, new Pair("207", "107"));
        f7353h = c2017a0;
        C2068c c2068c = new C2068c();
        c2068c.add(new C2079h0(3, 0));
        c2068c.add(new C2079h0(7, 1));
        c2068c.add(new C2079h0(2, 2));
        c2068c.add(new C2079h0(0, 3));
        c2068c.add(new C2079h0(1, 6));
        c2068c.add(new C2079h0(4, 7));
        c2068c.add(new C2079h0(5, 4));
        c2068c.add(new C2079h0(6, 5));
        f7354i = c2068c;
        C2075f0 c2075f0 = new C2075f0();
        c2075f0.put(3, 4);
        c2075f0.put(7, 7);
        c2075f0.put(2, 1);
        c2075f0.put(0, 0);
        c2075f0.put(1, 2);
        c2075f0.put(4, 3);
        c2075f0.put(5, 5);
        c2075f0.put(6, 6);
        f7355j = c2075f0;
        C2017a0 c2017a1 = new C2017a0();
        c2017a1.put(3, "BuglyAnrCrash");
        c2017a1.put(0, "BuglyJavaCrash");
        c2017a1.put(1, "BuglyNativeCrash");
        f7356k = c2017a1;
        C2017a0 c2017a2 = new C2017a0();
        c2017a2.put(3, "BuglyAnrCrashReport");
        c2017a2.put(0, "BuglyJavaCrashReport");
        c2017a2.put(1, "BuglyNativeCrashReport");
        f7357l = c2017a2;
    }

    public C2036as(Context context, C2026ai c2026ai, C2103w c2103w, C2020ac c2020ac, BuglyStrategy.C2006a c2006a) {
        f7352a = 1004;
        this.f7358b = context;
        this.f7359c = c2026ai;
        this.f7360d = c2103w;
        this.f7361e = c2020ac;
        this.f7363g = c2006a;
        this.f7362f = null;
    }

    private static List<C2035ar> m4726a(List<C2035ar> list) {
        if (list == null || list.size() == 0) {
            return null;
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        ArrayList arrayList = new ArrayList();
        for (C2035ar c2035ar : list) {
            if (c2035ar.f7349d && c2035ar.f7347b <= jCurrentTimeMillis - 86400000) {
                arrayList.add(c2035ar);
            }
        }
        return arrayList;
    }

    private static void m4744b(CrashDetailBean crashDetailBean, List<C2035ar> list) {
        StringBuilder sb = new StringBuilder(64);
        for (C2035ar c2035ar : list) {
            if (!c2035ar.f7350e && !c2035ar.f7349d) {
                String str = crashDetailBean.f7137s;
                StringBuilder sb2 = new StringBuilder();
                sb2.append(c2035ar.f7347b);
                if (!str.contains(sb2.toString())) {
                    crashDetailBean.f7138t++;
                    sb.append(c2035ar.f7347b);
                    sb.append("\n");
                }
            }
        }
        crashDetailBean.f7137s += sb.toString();
    }

    private static ContentValues m4750c(CrashDetailBean crashDetailBean) {
        if (crashDetailBean == null) {
            return null;
        }
        try {
            ContentValues contentValues = new ContentValues();
            long j10 = crashDetailBean.f7118a;
            if (j10 > 0) {
                contentValues.put("_id", Long.valueOf(j10));
            }
            contentValues.put("_tm", Long.valueOf(crashDetailBean.f7136r));
            contentValues.put("_s1", crashDetailBean.f7139u);
            contentValues.put("_up", Integer.valueOf(crashDetailBean.f7122d ? 1 : 0));
            contentValues.put("_me", Integer.valueOf(crashDetailBean.f7128j ? 1 : 0));
            contentValues.put("_uc", Integer.valueOf(crashDetailBean.f7130l));
            contentValues.put("_dt", C2033ap.m4692a(crashDetailBean));
            return contentValues;
        } catch (Throwable th) {
            if (!C2029al.m4641a(th)) {
                th.printStackTrace();
            }
            return null;
        }
    }

    private static void m4753d(List<C2035ar> list) {
        if (list == null || list.size() == 0) {
            return;
        }
        StringBuilder sbM5498l = AbstractC2460q.m5498l("_id in (");
        Iterator<C2035ar> it = list.iterator();
        while (it.hasNext()) {
            sbM5498l.append(it.next().f7346a);
            sbM5498l.append(",");
        }
        StringBuilder sb = new StringBuilder(sbM5498l.substring(0, sbM5498l.lastIndexOf(",")));
        sb.append(")");
        String string = sb.toString();
        sb.setLength(0);
        try {
            C2029al.m4644c("deleted %s data %d", "t_cr", Integer.valueOf(C2103w.m5011a().m5024a("t_cr", string)));
        } catch (Throwable th) {
            if (C2029al.m4641a(th)) {
                return;
            }
            th.printStackTrace();
        }
    }

    private static void m4756e(List<CrashDetailBean> list) {
        try {
            if (list.size() == 0) {
                return;
            }
            StringBuilder sb = new StringBuilder();
            for (CrashDetailBean crashDetailBean : list) {
                sb.append(" or _id = ");
                sb.append(crashDetailBean.f7118a);
            }
            String string = sb.toString();
            if (string.length() > 0) {
                string = string.substring(4);
            }
            sb.setLength(0);
            C2029al.m4644c("deleted %s data %d", "t_cr", Integer.valueOf(C2103w.m5011a().m5024a("t_cr", string)));
        } catch (Throwable th) {
            if (C2029al.m4641a(th)) {
                return;
            }
            th.printStackTrace();
        }
    }

    private static void m4748b(List<C2035ar> list) {
        List<CrashDetailBean> listM4751c = m4751c(list);
        if (listM4751c == null || listM4751c.isEmpty()) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (CrashDetailBean crashDetailBean : listM4751c) {
            String str = f7357l.get(Integer.valueOf(crashDetailBean.f7120b));
            if (!TextUtils.isEmpty(str)) {
                C2029al.m4644c("find expired data,crashId:%s eventType:%s", crashDetailBean.f7121c, str);
                arrayList.add(new C2024ag.c(crashDetailBean.f7121c, str, crashDetailBean.f7136r, false, 0L, "expired", null));
            }
        }
        C2024ag.a.f7269a.m4602a(arrayList);
    }

    private static CrashDetailBean m4721a(List<C2035ar> list, CrashDetailBean crashDetailBean) {
        CrashDetailBean crashDetailBean2;
        List<CrashDetailBean> listM4751c;
        if (list.isEmpty()) {
            return crashDetailBean;
        }
        ArrayList arrayList = new ArrayList(10);
        for (C2035ar c2035ar : list) {
            if (c2035ar.f7350e) {
                arrayList.add(c2035ar);
            }
        }
        if (arrayList.isEmpty() || (listM4751c = m4751c(arrayList)) == null || listM4751c.isEmpty()) {
            crashDetailBean2 = null;
        } else {
            Collections.sort(listM4751c);
            crashDetailBean2 = listM4751c.get(0);
            m4728a(crashDetailBean2, listM4751c);
        }
        if (crashDetailBean2 == null) {
            crashDetailBean.f7128j = true;
            crashDetailBean.f7138t = 0;
            crashDetailBean.f7137s = "";
            crashDetailBean2 = crashDetailBean;
        }
        m4744b(crashDetailBean2, list);
        if (crashDetailBean2.f7136r != crashDetailBean.f7136r) {
            String str = crashDetailBean2.f7137s;
            StringBuilder sb = new StringBuilder();
            sb.append(crashDetailBean.f7136r);
            if (!str.contains(sb.toString())) {
                crashDetailBean2.f7138t++;
                StringBuilder sb2 = new StringBuilder();
                sb2.append(crashDetailBean2.f7137s);
                crashDetailBean2.f7137s = AbstractC0004e.m25s(sb2, crashDetailBean.f7136r, "\n");
            }
        }
        return crashDetailBean2;
    }

    private static List<CrashDetailBean> m4751c(List<C2035ar> list) {
        Cursor cursorM5026a;
        if (list == null || list.size() == 0) {
            return null;
        }
        StringBuilder sbM5498l = AbstractC2460q.m5498l("_id in (");
        Iterator<C2035ar> it = list.iterator();
        while (it.hasNext()) {
            sbM5498l.append(it.next().f7346a);
            sbM5498l.append(",");
        }
        if (sbM5498l.toString().contains(",")) {
            sbM5498l = new StringBuilder(sbM5498l.substring(0, sbM5498l.lastIndexOf(",")));
        }
        sbM5498l.append(")");
        String string = sbM5498l.toString();
        sbM5498l.setLength(0);
        try {
            cursorM5026a = C2103w.m5011a().m5026a("t_cr", (String[]) null, string);
            if (cursorM5026a == null) {
                if (cursorM5026a != null) {
                    cursorM5026a.close();
                }
                return null;
            }
            try {
                ArrayList arrayList = new ArrayList();
                sbM5498l.append("_id in (");
                int i6 = 0;
                while (cursorM5026a.moveToNext()) {
                    CrashDetailBean crashDetailBeanM4720a = m4720a(cursorM5026a);
                    if (crashDetailBeanM4720a != null) {
                        arrayList.add(crashDetailBeanM4720a);
                    } else {
                        try {
                            sbM5498l.append(cursorM5026a.getLong(cursorM5026a.getColumnIndex("_id")));
                            sbM5498l.append(",");
                            i6++;
                        } catch (Throwable unused) {
                            C2029al.m4645d("unknown id!", new Object[0]);
                        }
                    }
                }
                if (sbM5498l.toString().contains(",")) {
                    sbM5498l = new StringBuilder(sbM5498l.substring(0, sbM5498l.lastIndexOf(",")));
                }
                sbM5498l.append(")");
                String string2 = sbM5498l.toString();
                if (i6 > 0) {
                    C2029al.m4645d("deleted %s illegal data %d", "t_cr", Integer.valueOf(C2103w.m5011a().m5024a("t_cr", string2)));
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

    private static String m4755e(CrashDetailBean crashDetailBean) {
        try {
            Pair<String, String> pair = f7353h.get(Integer.valueOf(crashDetailBean.f7120b));
            if (pair == null) {
                C2029al.m4646e("crash type error! %d", Integer.valueOf(crashDetailBean.f7120b));
                return "";
            }
            if (crashDetailBean.f7128j) {
                return (String) pair.first;
            }
            return (String) pair.second;
        } catch (Exception e5) {
            C2029al.m4641a(e5);
            return "";
        }
    }

    private boolean m4754d(CrashDetailBean crashDetailBean) {
        String absolutePath;
        try {
            C2029al.m4644c("save eup logs", new Object[0]);
            C2018aa c2018aaM4509b = C2018aa.m4509b();
            String str = "#--------\npackage:" + c2018aaM4509b.m4522e() + "\nversion:" + c2018aaM4509b.f7239o + "\nsdk:" + c2018aaM4509b.f7232h + "\nprocess:" + crashDetailBean.f7092A + "\ndate:" + C2033ap.m4682a(new Date(crashDetailBean.f7136r)) + "\ntype:" + crashDetailBean.f7132n + "\nmessage:" + crashDetailBean.f7133o + "\nstack:\n" + crashDetailBean.f7135q + "\neupID:" + crashDetailBean.f7121c + "\n";
            if (C2037at.f7376m == null) {
                if (Environment.getExternalStorageState().equals("mounted")) {
                    absolutePath = Environment.getExternalStorageDirectory().getAbsolutePath() + "/Tencent/" + this.f7358b.getPackageName();
                } else {
                    absolutePath = null;
                }
            } else {
                File file = new File(C2037at.f7376m);
                if (file.isFile()) {
                    file = file.getParentFile();
                }
                absolutePath = file.getAbsolutePath();
            }
            C2030am.m4652a(absolutePath + "/euplog.txt", str, C2037at.f7377n);
            return true;
        } catch (Throwable th) {
            C2029al.m4645d("rqdp{  save error} %s", th.toString());
            if (!C2029al.m4641a(th)) {
                th.printStackTrace();
            }
            return false;
        }
    }

    public final void m4761b(CrashDetailBean crashDetailBean, boolean z7) {
        if (C2037at.f7378o) {
            C2029al.m4640a("try to upload right now", new Object[0]);
            ArrayList arrayList = new ArrayList();
            arrayList.add(crashDetailBean);
            m4758a(arrayList, C0565C.DEFAULT_MAX_SEEK_TO_PREVIOUS_POSITION_MS, z7, crashDetailBean.f7120b == 7, z7);
            return;
        }
        C2029al.m4640a("do not upload spot crash right now, crash would be uploaded when app next start", new Object[0]);
    }

    public final void m4760b(CrashDetailBean crashDetailBean) {
        if (crashDetailBean == null) {
            return;
        }
        ContentValues contentValuesM4750c = m4750c(crashDetailBean);
        if (contentValuesM4750c != null) {
            long jM5025a = C2103w.m5011a().m5025a("t_cr", contentValuesM4750c, (InterfaceC2102v) null);
            if (jM5025a >= 0) {
                C2029al.m4644c("insert %s success!", "t_cr");
                crashDetailBean.f7118a = jM5025a;
            }
        }
        if (C2037at.f7375l) {
            m4754d(crashDetailBean);
        }
    }

    private static C2035ar m4742b(Cursor cursor) {
        if (cursor == null) {
            return null;
        }
        try {
            C2035ar c2035ar = new C2035ar();
            c2035ar.f7346a = cursor.getLong(cursor.getColumnIndex("_id"));
            c2035ar.f7347b = cursor.getLong(cursor.getColumnIndex("_tm"));
            c2035ar.f7348c = cursor.getString(cursor.getColumnIndex("_s1"));
            c2035ar.f7349d = cursor.getInt(cursor.getColumnIndex("_up")) == 1;
            c2035ar.f7350e = cursor.getInt(cursor.getColumnIndex("_me")) == 1;
            c2035ar.f7351f = cursor.getInt(cursor.getColumnIndex("_uc"));
            return c2035ar;
        } catch (Throwable th) {
            if (!C2029al.m4641a(th)) {
                th.printStackTrace();
            }
            return null;
        }
    }

    private static void m4728a(CrashDetailBean crashDetailBean, List<CrashDetailBean> list) {
        String[] strArrSplit;
        StringBuilder sb = new StringBuilder(128);
        for (int i6 = 1; i6 < list.size(); i6++) {
            String str = list.get(i6).f7137s;
            if (str != null && (strArrSplit = str.split("\n")) != null) {
                for (String str2 : strArrSplit) {
                    if (!crashDetailBean.f7137s.contains(str2)) {
                        crashDetailBean.f7138t++;
                        sb.append(str2);
                        sb.append("\n");
                    }
                }
            }
        }
        crashDetailBean.f7137s += sb.toString();
    }

    private static List<C2035ar> m4743b() {
        ArrayList arrayList = new ArrayList();
        Cursor cursor = null;
        try {
            Cursor cursorM5026a = C2103w.m5011a().m5026a("t_cr", new String[]{"_id", "_tm", "_s1", "_up", "_me", "_uc"}, (String) null);
            if (cursorM5026a == null) {
                if (cursorM5026a != null) {
                    cursorM5026a.close();
                }
                return null;
            }
            try {
                if (cursorM5026a.getCount() <= 0) {
                    cursorM5026a.close();
                    return arrayList;
                }
                StringBuilder sb = new StringBuilder();
                sb.append("_id in (");
                int i6 = 0;
                while (cursorM5026a.moveToNext()) {
                    C2035ar c2035arM4742b = m4742b(cursorM5026a);
                    if (c2035arM4742b != null) {
                        arrayList.add(c2035arM4742b);
                    } else {
                        try {
                            sb.append(cursorM5026a.getLong(cursorM5026a.getColumnIndex("_id")));
                            sb.append(",");
                            i6++;
                        } catch (Throwable unused) {
                            C2029al.m4645d("unknown id!", new Object[0]);
                        }
                    }
                }
                if (sb.toString().contains(",")) {
                    sb = new StringBuilder(sb.substring(0, sb.lastIndexOf(",")));
                }
                sb.append(")");
                String string = sb.toString();
                sb.setLength(0);
                if (i6 > 0) {
                    C2029al.m4645d("deleted %s illegal data %d", "t_cr", Integer.valueOf(C2103w.m5011a().m5024a("t_cr", string)));
                }
                cursorM5026a.close();
                return arrayList;
            } catch (Throwable th) {
                th = th;
                cursor = cursorM5026a;
                try {
                    if (!C2029al.m4641a(th)) {
                        th.printStackTrace();
                    }
                    return arrayList;
                } finally {
                    if (cursor != null) {
                        cursor.close();
                    }
                }
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public final boolean m4759a(CrashDetailBean crashDetailBean, boolean z7) {
        boolean z10;
        boolean zM4778k;
        Map mapOnCrashHandleStart;
        if (crashDetailBean == null) {
            C2029al.m4645d("CrashBean is null, won't handle.", new Object[0]);
            return true;
        }
        m4760b(crashDetailBean);
        if (z7 && (this.f7363g != null || this.f7362f != null)) {
            Iterator<C2079h0> it = f7354i.iterator();
            while (true) {
                if (it.hasNext()) {
                    C2079h0 next = it.next();
                    if (next.f7623a == crashDetailBean.f7120b) {
                        switch (next.f7624b) {
                            case 0:
                                zM4778k = C2037at.m4762a().m4778k();
                                break;
                            case 1:
                            case 2:
                                zM4778k = true;
                                break;
                            case 3:
                                zM4778k = C2037at.m4762a().m4777j();
                                break;
                            case 4:
                                if ((C2037at.m4762a().f7383B & 2) > 0) {
                                    zM4778k = true;
                                }
                                break;
                            case 5:
                                if ((C2037at.m4762a().f7383B & 1) > 0) {
                                    zM4778k = true;
                                }
                                break;
                            case 6:
                                zM4778k = C2037at.m4762a().m4777j();
                                break;
                            default:
                                if ((C2037at.m4762a().f7383B & 4) > 0) {
                                    zM4778k = true;
                                }
                                break;
                        }
                    }
                }
                zM4778k = false;
            }
            if (!zM4778k) {
                C2029al.m4644c("Should not call back.", new Object[0]);
            } else {
                try {
                    Map<Integer, Integer> map = f7355j;
                    if (map.containsKey(Integer.valueOf(crashDetailBean.f7120b))) {
                        int iIntValue = map.get(Integer.valueOf(crashDetailBean.f7120b)).intValue();
                        byte[] bArrOnCrashHandleStart2GetExtraDatas = null;
                        if (this.f7362f != null) {
                            C2029al.m4644c("Calling 'onCrashHandleStart' of RQD crash listener.", new Object[0]);
                            C2029al.m4644c("Calling 'getCrashExtraMessage' of RQD crash listener.", new Object[0]);
                            String strM4796b = this.f7362f.m4796b();
                            if (strM4796b != null) {
                                HashMap map2 = new HashMap(1);
                                map2.put("userData", strM4796b);
                                mapOnCrashHandleStart = map2;
                            } else {
                                mapOnCrashHandleStart = null;
                            }
                        } else if (this.f7363g != null) {
                            C2029al.m4644c("Calling 'onCrashHandleStart' of Bugly crash listener.", new Object[0]);
                            mapOnCrashHandleStart = this.f7363g.onCrashHandleStart(iIntValue, crashDetailBean.f7132n, crashDetailBean.f7133o, crashDetailBean.f7135q);
                        } else {
                            mapOnCrashHandleStart = null;
                        }
                        m4729a(crashDetailBean, (Map<String, String>) mapOnCrashHandleStart);
                        C2029al.m4640a("[crash callback] start user's callback:onCrashHandleStart2GetExtraDatas()", new Object[0]);
                        if (this.f7362f != null) {
                            C2029al.m4644c("Calling 'getCrashExtraData' of RQD crash listener.", new Object[0]);
                            bArrOnCrashHandleStart2GetExtraDatas = this.f7362f.m4795a();
                        } else if (this.f7363g != null) {
                            C2029al.m4644c("Calling 'onCrashHandleStart2GetExtraDatas' of Bugly crash listener.", new Object[0]);
                            bArrOnCrashHandleStart2GetExtraDatas = this.f7363g.onCrashHandleStart2GetExtraDatas(iIntValue, crashDetailBean.f7132n, crashDetailBean.f7133o, crashDetailBean.f7135q);
                        }
                        if (bArrOnCrashHandleStart2GetExtraDatas == null) {
                            C2029al.m4645d("extra user byte is null. CrashBean won't have userExtraByteDatas.", new Object[0]);
                        } else {
                            if (bArrOnCrashHandleStart2GetExtraDatas.length <= 100000) {
                                crashDetailBean.f7116Y = bArrOnCrashHandleStart2GetExtraDatas;
                            } else {
                                C2029al.m4645d("extra bytes size %d is over limit %d will drop over part", Integer.valueOf(bArrOnCrashHandleStart2GetExtraDatas.length), 100000);
                                crashDetailBean.f7116Y = Arrays.copyOf(bArrOnCrashHandleStart2GetExtraDatas, 100000);
                            }
                            C2029al.m4640a("add extra bytes %d ", Integer.valueOf(bArrOnCrashHandleStart2GetExtraDatas.length));
                        }
                        if (this.f7362f != null) {
                            C2029al.m4644c("Calling 'onCrashSaving' of RQD crash listener.", new Object[0]);
                            if (!this.f7362f.m4797c()) {
                                C2029al.m4645d("Crash listener 'onCrashSaving' return 'false' thus will not handle this crash.", new Object[0]);
                            }
                        }
                    } else {
                        C2029al.m4645d("Cannot get crash type for crashBean type:" + crashDetailBean.f7120b, new Object[0]);
                    }
                } catch (Throwable th) {
                    C2029al.m4645d("crash handle callback something wrong! %s", th.getClass().getName());
                    if (!C2029al.m4641a(th)) {
                        th.printStackTrace();
                    }
                }
            }
        }
        if (!C2019ab.m4566r()) {
            crashDetailBean.f7141w = C2033ap.m4676a(C2037at.f7369f, C2037at.f7374k);
        }
        String str = crashDetailBean.f7135q;
        String str2 = C2037at.f7380q;
        if (str2 == null || str2.isEmpty()) {
            z10 = false;
        } else {
            C2029al.m4644c("Crash filter for crash stack is: %s", C2037at.f7380q);
            if (str.contains(C2037at.f7380q)) {
                C2029al.m4645d("This crash contains the filter string set. It will not be record and upload.", new Object[0]);
                z10 = true;
            } else {
                z10 = false;
            }
        }
        if (z10 || m4741a(crashDetailBean.f7135q)) {
            return true;
        }
        if (crashDetailBean.f7120b != 2) {
            C2105y c2105y = new C2105y();
            c2105y.f7707b = 1;
            c2105y.f7708c = crashDetailBean.f7092A;
            c2105y.f7709d = crashDetailBean.f7093B;
            c2105y.f7710e = crashDetailBean.f7136r;
            C2103w.m5011a().m5033b(1);
            C2103w.m5011a().m5032a(c2105y);
            C2029al.m4642b("[crash] a crash occur, handling...", new Object[0]);
        } else {
            C2029al.m4642b("[crash] a caught exception occur, handling...", new Object[0]);
        }
        List<C2035ar> listM4743b = m4743b();
        ArrayList arrayList = new ArrayList(10);
        if (listM4743b != null && listM4743b.size() > 0) {
            arrayList.addAll(m4726a(listM4743b));
            listM4743b.removeAll(arrayList);
            if (listM4743b.size() > 20) {
                StringBuilder sbM5498l = AbstractC2460q.m5498l("_id in (SELECT _id FROM t_cr order by _id limit 5)");
                String string = sbM5498l.toString();
                sbM5498l.setLength(0);
                try {
                    C2029al.m4644c("deleted first record %s data %d", "t_cr", Integer.valueOf(C2103w.m5011a().m5024a("t_cr", string)));
                } catch (Throwable th2) {
                    if (!C2029al.m4641a(th2)) {
                        th2.printStackTrace();
                    }
                }
            }
            if (m4749b(crashDetailBean, listM4743b, arrayList)) {
                return true;
            }
        }
        m4760b(crashDetailBean);
        String str3 = f7356k.get(Integer.valueOf(crashDetailBean.f7120b));
        if (!TextUtils.isEmpty(str3)) {
            C2024ag.a.f7269a.m4601a(new C2024ag.c(crashDetailBean.f7121c, str3, crashDetailBean.f7136r, true, 0L, "realtime", null));
        }
        m4753d(arrayList);
        C2029al.m4642b("[crash] save crash success", new Object[0]);
        return false;
    }

    private static void m4752c(ArrayList<C2059bn> arrayList, String str) {
        if (C2033ap.m4703b(str)) {
            return;
        }
        try {
            C2059bn c2059bn = new C2059bn((byte) 1, "crashInfos.txt", str.getBytes("utf-8"));
            C2029al.m4644c("attach crash infos", new Object[0]);
            arrayList.add(c2059bn);
        } catch (Exception e5) {
            e5.printStackTrace();
            C2029al.m4641a(e5);
        }
    }

    private static void m4746b(ArrayList<C2059bn> arrayList, String str) {
        if (str != null) {
            try {
                arrayList.add(new C2059bn((byte) 1, "jniLog.txt", str.getBytes("utf-8")));
            } catch (Exception e5) {
                e5.printStackTrace();
                C2029al.m4641a(e5);
            }
        }
    }

    private static void m4745b(ArrayList<C2059bn> arrayList, CrashDetailBean crashDetailBean, Context context) {
        String str;
        if (crashDetailBean.f7120b == 1 && (str = crashDetailBean.f7140v) != null) {
            try {
                C2059bn c2059bnM4722a = m4722a("tomb.zip", context, str);
                if (c2059bnM4722a != null) {
                    C2029al.m4644c("attach tombs", new Object[0]);
                    arrayList.add(c2059bnM4722a);
                }
            } catch (Exception e5) {
                C2029al.m4641a(e5);
            }
        }
    }

    private static void m4747b(ArrayList<C2059bn> arrayList, byte[] bArr) {
        if (bArr == null || bArr.length <= 0) {
            return;
        }
        try {
            arrayList.add(new C2059bn((byte) 1, "userExtraByteData", bArr));
            C2029al.m4644c("attach extraData", new Object[0]);
        } catch (Exception e5) {
            C2029al.m4641a(e5);
        }
    }

    private boolean m4749b(CrashDetailBean crashDetailBean, List<C2035ar> list, List<C2035ar> list2) {
        boolean z7;
        int i6 = crashDetailBean.f7120b;
        boolean z10 = i6 == 0 || i6 == 1;
        boolean z11 = i6 == 3;
        if (C2094p.f7657c) {
            z7 = false;
        } else {
            z7 = (z11 || z10) ? C2037at.f7368e : true;
        }
        if (!z7) {
            return false;
        }
        ArrayList<C2035ar> arrayList = new ArrayList(10);
        if (!m4740a(crashDetailBean, list, arrayList)) {
            try {
                if (arrayList.size() >= C2037at.f7367d) {
                }
            } catch (Exception e5) {
                C2029al.m4641a(e5);
                C2029al.m4645d("Failed to merge crash.", new Object[0]);
            }
            return false;
        }
        C2029al.m4640a("same crash occur too much do merged!", new Object[0]);
        CrashDetailBean crashDetailBeanM4721a = m4721a((List<C2035ar>) arrayList, crashDetailBean);
        for (C2035ar c2035ar : arrayList) {
            if (c2035ar.f7346a != crashDetailBeanM4721a.f7118a) {
                list2.add(c2035ar);
            }
        }
        m4760b(crashDetailBeanM4721a);
        m4753d(list2);
        C2029al.m4642b("[crash] save crash success. For this device crash many times, it will not upload crashes immediately", new Object[0]);
        return true;
    }

    private static boolean m4741a(String str) {
        String str2 = C2037at.f7381r;
        if (str2 != null && !str2.isEmpty()) {
            try {
                C2029al.m4644c("Crash regular filter for crash stack is: %s", C2037at.f7381r);
                if (Pattern.compile(C2037at.f7381r).matcher(str).find()) {
                    C2029al.m4645d("This crash matches the regular filter string set. It will not be record and upload.", new Object[0]);
                    return true;
                }
            } catch (Exception e5) {
                C2029al.m4641a(e5);
                C2029al.m4645d("Failed to compile " + C2037at.f7381r, new Object[0]);
            }
        }
        return false;
    }

    private static boolean m4740a(CrashDetailBean crashDetailBean, List<C2035ar> list, List<C2035ar> list2) {
        boolean z7 = false;
        for (C2035ar c2035ar : list) {
            if (crashDetailBean.f7139u.equals(c2035ar.f7348c)) {
                if (c2035ar.f7350e) {
                    z7 = true;
                }
                list2.add(c2035ar);
            }
        }
        return z7;
    }

    public static List<CrashDetailBean> m4725a() {
        StrategyBean strategyBeanM4579c = C2020ac.m4570a().m4579c();
        if (strategyBeanM4579c == null) {
            C2029al.m4645d("have not synced remote!", new Object[0]);
            return null;
        }
        if (!strategyBeanM4579c.f7074f) {
            C2029al.m4645d("Crashreport remote closed, please check your APP ID correct and Version available, then uninstall and reinstall your app.", new Object[0]);
            C2029al.m4642b("[init] WARNING! Crashreport closed by server, please check your APP ID correct and Version available, then uninstall and reinstall your app.", new Object[0]);
            return null;
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        long jM4695b = C2033ap.m4695b();
        List<C2035ar> listM4743b = m4743b();
        C2029al.m4644c("Size of crash list loaded from DB: %s", Integer.valueOf(listM4743b.size()));
        if (listM4743b.size() <= 0) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        arrayList.addAll(m4726a(listM4743b));
        listM4743b.removeAll(arrayList);
        Iterator<C2035ar> it = listM4743b.iterator();
        while (it.hasNext()) {
            C2035ar next = it.next();
            long j10 = next.f7347b;
            if (j10 < jM4695b - C2037at.f7373j) {
                arrayList2.add(next);
                it.remove();
                arrayList.add(next);
            } else if (next.f7349d) {
                if (j10 >= jCurrentTimeMillis - 86400000) {
                    it.remove();
                } else if (!next.f7350e) {
                    it.remove();
                    arrayList.add(next);
                }
            } else if (next.f7351f >= 3 && j10 < jCurrentTimeMillis - 86400000) {
                it.remove();
                arrayList.add(next);
            }
        }
        m4748b(arrayList2);
        if (arrayList.size() > 0) {
            m4753d(arrayList);
        }
        ArrayList arrayList3 = new ArrayList();
        List<CrashDetailBean> listM4751c = m4751c(listM4743b);
        if (listM4751c != null && listM4751c.size() > 0) {
            String str = C2018aa.m4509b().f7239o;
            Iterator<CrashDetailBean> it2 = listM4751c.iterator();
            while (it2.hasNext()) {
                CrashDetailBean next2 = it2.next();
                if (!str.equals(next2.f7124f)) {
                    it2.remove();
                    arrayList3.add(next2);
                }
            }
        }
        if (arrayList3.size() > 0) {
            m4756e(arrayList3);
        }
        return listM4751c;
    }

    public final void m4757a(CrashDetailBean crashDetailBean) {
        int i6 = crashDetailBean.f7120b;
        if (i6 != 0) {
            if (i6 != 1) {
                if (i6 == 3 && !C2037at.m4762a().m4778k()) {
                    return;
                }
            } else if (!C2037at.m4762a().m4777j()) {
                return;
            }
        } else if (!C2037at.m4762a().m4777j()) {
            return;
        }
        if (this.f7362f != null) {
            C2029al.m4644c("Calling 'onCrashHandleEnd' of RQD crash listener.", new Object[0]);
        }
    }

    public final void m4758a(List<CrashDetailBean> list, long j10, boolean z7, boolean z10, boolean z11) {
        if (!C2018aa.m4507a(this.f7358b).f7230f) {
            C2029al.m4645d("warn: not upload process", new Object[0]);
            return;
        }
        C2026ai c2026ai = this.f7359c;
        if (c2026ai == null) {
            C2029al.m4645d("warn: upload manager is null", new Object[0]);
            return;
        }
        if (!z11 && !c2026ai.m4622b(C2037at.f7365a)) {
            C2029al.m4645d("warn: not crashHappen or not should upload", new Object[0]);
            return;
        }
        StrategyBean strategyBeanM4579c = this.f7361e.m4579c();
        if (!strategyBeanM4579c.f7074f) {
            C2029al.m4645d("remote report is disable!", new Object[0]);
            C2029al.m4642b("[crash] server closed bugly in this app. please check your appid if is correct, and re-install it", new Object[0]);
            return;
        }
        if (list != null && list.size() != 0) {
            try {
                String str = strategyBeanM4579c.f7086r;
                String str2 = StrategyBean.f7070b;
                C2061bp c2061bpM4724a = m4724a(this.f7358b, list, C2018aa.m4509b());
                if (c2061bpM4724a == null) {
                    C2029al.m4645d("create eupPkg fail!", new Object[0]);
                    return;
                }
                byte[] bArrM4588a = C2022ae.m4588a((AbstractC2088m) c2061bpM4724a);
                if (bArrM4588a == null) {
                    C2029al.m4645d("send encode fail!", new Object[0]);
                    return;
                }
                C2062bq c2062bqM4584a = C2022ae.m4584a(this.f7358b, 830, bArrM4588a);
                if (c2062bqM4584a == null) {
                    C2029al.m4645d("request package is null.", new Object[0]);
                    return;
                }
                C2077g0 c2077g0 = new C2077g0(System.currentTimeMillis(), list, z7);
                if (z7) {
                    this.f7359c.m4619a(f7352a, c2062bqM4584a, str, str2, c2077g0, j10, z10);
                    return;
                } else {
                    this.f7359c.m4620a(f7352a, c2062bqM4584a, str, str2, c2077g0, false);
                    return;
                }
            } catch (Throwable th) {
                C2029al.m4646e("req cr error %s", th.toString());
                if (C2029al.m4643b(th)) {
                    return;
                }
                th.printStackTrace();
                return;
            }
        }
        C2029al.m4645d("warn: crashList is null or crashList num is 0", new Object[0]);
    }

    public static void m4739a(boolean z7, List<CrashDetailBean> list) {
        if (list != null && list.size() > 0) {
            C2029al.m4644c("up finish update state %b", Boolean.valueOf(z7));
            for (CrashDetailBean crashDetailBean : list) {
                C2029al.m4644c("pre uid:%s uc:%d re:%b me:%b", crashDetailBean.f7121c, Integer.valueOf(crashDetailBean.f7130l), Boolean.valueOf(crashDetailBean.f7122d), Boolean.valueOf(crashDetailBean.f7128j));
                int i6 = crashDetailBean.f7130l + 1;
                crashDetailBean.f7130l = i6;
                crashDetailBean.f7122d = z7;
                C2029al.m4644c("set uid:%s uc:%d re:%b me:%b", crashDetailBean.f7121c, Integer.valueOf(i6), Boolean.valueOf(crashDetailBean.f7122d), Boolean.valueOf(crashDetailBean.f7128j));
            }
            Iterator<CrashDetailBean> it = list.iterator();
            while (it.hasNext()) {
                C2037at.m4762a().m4767a(it.next());
            }
            C2029al.m4644c("update state size %d", Integer.valueOf(list.size()));
        }
        if (z7) {
            return;
        }
        C2029al.m4642b("[crash] upload fail.", new Object[0]);
    }

    private static CrashDetailBean m4720a(Cursor cursor) {
        if (cursor == null) {
            return null;
        }
        try {
            byte[] blob = cursor.getBlob(cursor.getColumnIndex("_dt"));
            if (blob == null) {
                return null;
            }
            long j10 = cursor.getLong(cursor.getColumnIndex("_id"));
            CrashDetailBean crashDetailBean = (CrashDetailBean) C2033ap.m4674a(blob, CrashDetailBean.CREATOR);
            if (crashDetailBean != null) {
                crashDetailBean.f7118a = j10;
            }
            return crashDetailBean;
        } catch (Throwable th) {
            if (!C2029al.m4641a(th)) {
                th.printStackTrace();
            }
            return null;
        }
    }

    private static C2060bo m4723a(Context context, CrashDetailBean crashDetailBean, C2018aa c2018aa) {
        ArrayList<C2057bl> arrayList = null;
        if (context != null && crashDetailBean != null && c2018aa != null) {
            C2060bo c2060bo = new C2060bo();
            c2060bo.f7499a = m4755e(crashDetailBean);
            c2060bo.f7500b = crashDetailBean.f7136r;
            c2060bo.f7501c = crashDetailBean.f7132n;
            c2060bo.f7502d = crashDetailBean.f7133o;
            c2060bo.f7503e = crashDetailBean.f7134p;
            c2060bo.f7505g = crashDetailBean.f7135q;
            c2060bo.f7506h = crashDetailBean.f7144z;
            c2060bo.f7507i = crashDetailBean.f7121c;
            c2060bo.f7508j = null;
            c2060bo.f7510l = crashDetailBean.f7131m;
            c2060bo.f7511m = crashDetailBean.f7123e;
            c2060bo.f7504f = crashDetailBean.f7093B;
            c2060bo.f7512n = null;
            Map<String, PlugInBean> map = crashDetailBean.f7126h;
            if (map != null && !map.isEmpty()) {
                arrayList = new ArrayList<>(crashDetailBean.f7126h.size());
                for (Map.Entry<String, PlugInBean> entry : crashDetailBean.f7126h.entrySet()) {
                    C2057bl c2057bl = new C2057bl();
                    c2057bl.f7479a = entry.getValue().f7066a;
                    c2057bl.f7481c = entry.getValue().f7068c;
                    c2057bl.f7483e = entry.getValue().f7067b;
                    arrayList.add(c2057bl);
                }
            }
            c2060bo.f7514p = arrayList;
            C2029al.m4644c("libInfo %s", c2060bo.f7513o);
            ArrayList<C2059bn> arrayList2 = new ArrayList<>(20);
            m4731a(arrayList2, crashDetailBean);
            m4733a(arrayList2, crashDetailBean.f7141w);
            m4746b(arrayList2, crashDetailBean.f7142x);
            m4752c(arrayList2, crashDetailBean.f7117Z);
            m4734a(arrayList2, crashDetailBean.f7119aa, context);
            m4736a(arrayList2, crashDetailBean.f7143y);
            m4732a(arrayList2, crashDetailBean, context);
            m4745b(arrayList2, crashDetailBean, context);
            m4735a(arrayList2, c2018aa.f7187L);
            m4747b(arrayList2, crashDetailBean.f7116Y);
            c2060bo.f7515q = arrayList2;
            if (crashDetailBean.f7128j) {
                c2060bo.f7509k = crashDetailBean.f7138t;
            }
            c2060bo.f7516r = m4727a(crashDetailBean, c2018aa);
            c2060bo.f7517s = new HashMap();
            Map<String, String> map2 = crashDetailBean.f7110S;
            if (map2 != null && map2.size() > 0) {
                c2060bo.f7517s.putAll(crashDetailBean.f7110S);
                C2029al.m4640a("setted message size %d", Integer.valueOf(c2060bo.f7517s.size()));
            }
            Map<String, String> map3 = c2060bo.f7517s;
            C2029al.m4644c("pss:" + crashDetailBean.f7100I + " vss:" + crashDetailBean.f7101J + " javaHeap:" + crashDetailBean.f7102K, new Object[0]);
            StringBuilder sb = new StringBuilder();
            sb.append(crashDetailBean.f7100I);
            map3.put("SDK_UPLOAD_U1", sb.toString());
            StringBuilder sb2 = new StringBuilder();
            sb2.append(crashDetailBean.f7101J);
            map3.put("SDK_UPLOAD_U2", sb2.toString());
            StringBuilder sb3 = new StringBuilder();
            sb3.append(crashDetailBean.f7102K);
            map3.put("SDK_UPLOAD_U3", sb3.toString());
            C2029al.m4644c("%s rid:%s sess:%s ls:%ds isR:%b isF:%b isM:%b isN:%b mc:%d ,%s ,isUp:%b ,vm:%d", crashDetailBean.f7132n, crashDetailBean.f7121c, c2018aa.m4520d(), Long.valueOf((crashDetailBean.f7136r - crashDetailBean.f7108Q) / 1000), Boolean.valueOf(crashDetailBean.f7129k), Boolean.valueOf(crashDetailBean.f7109R), Boolean.valueOf(crashDetailBean.f7128j), Boolean.valueOf(crashDetailBean.f7120b == 1), Integer.valueOf(crashDetailBean.f7138t), crashDetailBean.f7137s, Boolean.valueOf(crashDetailBean.f7122d), Integer.valueOf(c2060bo.f7516r.size()));
            return c2060bo;
        }
        C2029al.m4645d("enExp args == null", new Object[0]);
        return null;
    }

    private static C2061bp m4724a(Context context, List<CrashDetailBean> list, C2018aa c2018aa) {
        if (context != null && list != null && list.size() != 0 && c2018aa != null) {
            C2061bp c2061bp = new C2061bp();
            c2061bp.f7521a = new ArrayList<>();
            Iterator<CrashDetailBean> it = list.iterator();
            while (it.hasNext()) {
                c2061bp.f7521a.add(m4723a(context, it.next(), c2018aa));
            }
            return c2061bp;
        }
        C2029al.m4645d("enEXPPkg args == null!", new Object[0]);
        return null;
    }

    private static C2059bn m4722a(String str, Context context, String str2) {
        FileInputStream fileInputStream;
        if (str2 != null && context != null) {
            C2029al.m4644c("zip %s", str2);
            File file = new File(str2);
            File file2 = new File(context.getCacheDir(), str);
            if (!C2033ap.m4690a(file, file2)) {
                C2029al.m4645d("zip fail!", new Object[0]);
                return null;
            }
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            try {
                fileInputStream = new FileInputStream(file2);
                try {
                    byte[] bArr = new byte[4096];
                    while (true) {
                        int i6 = fileInputStream.read(bArr);
                        if (i6 <= 0) {
                            break;
                        }
                        byteArrayOutputStream.write(bArr, 0, i6);
                        byteArrayOutputStream.flush();
                    }
                    byte[] byteArray = byteArrayOutputStream.toByteArray();
                    C2029al.m4644c("read bytes :%d", Integer.valueOf(byteArray.length));
                    C2059bn c2059bn = new C2059bn((byte) 2, file2.getName(), byteArray);
                    try {
                        fileInputStream.close();
                    } catch (IOException e5) {
                        if (!C2029al.m4641a(e5)) {
                            e5.printStackTrace();
                        }
                    }
                    if (file2.exists()) {
                        C2029al.m4644c("del tmp", new Object[0]);
                        file2.delete();
                    }
                    return c2059bn;
                } catch (Throwable th) {
                    th = th;
                    try {
                        if (!C2029al.m4641a(th)) {
                            th.printStackTrace();
                        }
                        if (fileInputStream != null) {
                            try {
                                fileInputStream.close();
                            } catch (IOException e10) {
                                if (!C2029al.m4641a(e10)) {
                                    e10.printStackTrace();
                                }
                            }
                        }
                        if (file2.exists()) {
                            C2029al.m4644c("del tmp", new Object[0]);
                        }
                        return null;
                    } finally {
                        if (fileInputStream != null) {
                            try {
                                fileInputStream.close();
                            } catch (IOException e11) {
                                if (!C2029al.m4641a(e11)) {
                                    e11.printStackTrace();
                                }
                            }
                        }
                        if (file2.exists()) {
                            C2029al.m4644c("del tmp", new Object[0]);
                            file2.delete();
                        }
                    }
                }
            } catch (Throwable th2) {
                th = th2;
                fileInputStream = null;
            }
        } else {
            C2029al.m4645d("rqdp{  createZipAttachment sourcePath == null || context == null ,pls check}", new Object[0]);
            return null;
        }
    }

    public static void m4730a(String str, String str2, String str3, String str4, String str5, CrashDetailBean crashDetailBean) {
        String str6;
        C2018aa c2018aaM4509b = C2018aa.m4509b();
        if (c2018aaM4509b == null) {
            return;
        }
        C2029al.m4646e("#++++++++++Record By Bugly++++++++++#", new Object[0]);
        C2029al.m4646e("# You can use Bugly(http:\\\\bugly.qq.com) to get more Crash Detail!", new Object[0]);
        C2029al.m4646e("# PKG NAME: %s", c2018aaM4509b.f7227c);
        C2029al.m4646e("# APP VER: %s", c2018aaM4509b.f7239o);
        C2029al.m4646e("# SDK VER: %s", c2018aaM4509b.f7232h);
        C2029al.m4646e("# LAUNCH TIME: %s", C2033ap.m4682a(new Date(C2018aa.m4509b().f7201a)));
        C2029al.m4646e("# CRASH TYPE: %s", str);
        C2029al.m4646e("# CRASH TIME: %s", str2);
        C2029al.m4646e("# CRASH PROCESS: %s", str3);
        C2029al.m4646e("# CRASH FOREGROUND: %s", Boolean.valueOf(c2018aaM4509b.m4515a()));
        C2029al.m4646e("# CRASH THREAD: %s", str4);
        if (crashDetailBean != null) {
            C2029al.m4646e("# REPORT ID: %s", crashDetailBean.f7121c);
            C2029al.m4646e("# CRASH DEVICE: %s %s", c2018aaM4509b.m4528h(), c2018aaM4509b.m4537r().booleanValue() ? "ROOTED" : "UNROOT");
            C2029al.m4646e("# RUNTIME AVAIL RAM:%d ROM:%d SD:%d", Long.valueOf(crashDetailBean.f7094C), Long.valueOf(crashDetailBean.f7095D), Long.valueOf(crashDetailBean.f7096E));
            C2029al.m4646e("# RUNTIME TOTAL RAM:%d ROM:%d SD:%d", Long.valueOf(crashDetailBean.f7097F), Long.valueOf(crashDetailBean.f7098G), Long.valueOf(crashDetailBean.f7099H));
            if (!C2033ap.m4703b(crashDetailBean.f7106O)) {
                C2029al.m4646e("# EXCEPTION FIRED BY %s %s", crashDetailBean.f7106O, crashDetailBean.f7105N);
            } else if (crashDetailBean.f7120b == 3) {
                if (crashDetailBean.f7111T == null) {
                    str6 = "null";
                } else {
                    str6 = crashDetailBean.f7111T.get("BUGLY_CR_01");
                }
                C2029al.m4646e("# EXCEPTION ANR MESSAGE:\n %s", str6);
            }
        }
        if (!C2033ap.m4703b(str5)) {
            C2029al.m4646e("# CRASH STACK: ", new Object[0]);
            C2029al.m4646e(str5, new Object[0]);
        }
        C2029al.m4646e("#++++++++++++++++++++++++++++++++++++++++++#", new Object[0]);
    }

    private static void m4729a(CrashDetailBean crashDetailBean, Map<String, String> map) {
        String value;
        if (map != null && !map.isEmpty()) {
            crashDetailBean.f7110S = new LinkedHashMap(map.size());
            for (Map.Entry<String, String> entry : map.entrySet()) {
                if (!C2033ap.m4703b(entry.getKey())) {
                    String key = entry.getKey();
                    if (key.length() > 100) {
                        key = key.substring(0, 100);
                        C2029al.m4645d("setted key length is over limit %d substring to %s", 100, key);
                    }
                    if (!C2033ap.m4703b(entry.getValue()) && entry.getValue().length() > 100000) {
                        value = entry.getValue().substring(entry.getValue().length() - 100000);
                        C2029al.m4645d("setted %s value length is over limit %d substring", key, 100000);
                    } else {
                        value = entry.getValue();
                    }
                    crashDetailBean.f7110S.put(key, value);
                    C2029al.m4640a("add setted key %s value size:%d", key, Integer.valueOf(value.length()));
                }
            }
            return;
        }
        C2029al.m4645d("extra map is empty. CrashBean won't have userDatas.", new Object[0]);
    }

    private static void m4731a(ArrayList<C2059bn> arrayList, CrashDetailBean crashDetailBean) {
        String str;
        if (crashDetailBean.f7128j && (str = crashDetailBean.f7137s) != null && str.length() > 0) {
            try {
                arrayList.add(new C2059bn((byte) 1, "alltimes.txt", crashDetailBean.f7137s.getBytes("utf-8")));
            } catch (Exception e5) {
                e5.printStackTrace();
                C2029al.m4641a(e5);
            }
        }
    }

    private static void m4733a(ArrayList<C2059bn> arrayList, String str) {
        if (str != null) {
            try {
                arrayList.add(new C2059bn((byte) 1, "log.txt", str.getBytes("utf-8")));
            } catch (Exception e5) {
                e5.printStackTrace();
                C2029al.m4641a(e5);
            }
        }
    }

    private static void m4734a(ArrayList<C2059bn> arrayList, String str, Context context) {
        if (str != null) {
            try {
                C2059bn c2059bnM4722a = m4722a("backupRecord.zip", context, str);
                if (c2059bnM4722a != null) {
                    C2029al.m4644c("attach backup record", new Object[0]);
                    arrayList.add(c2059bnM4722a);
                }
            } catch (Exception e5) {
                C2029al.m4641a(e5);
            }
        }
    }

    private static void m4736a(ArrayList<C2059bn> arrayList, byte[] bArr) {
        if (bArr == null || bArr.length <= 0) {
            return;
        }
        try {
            C2059bn c2059bn = new C2059bn((byte) 2, "buglylog.zip", bArr);
            C2029al.m4644c("attach user log", new Object[0]);
            arrayList.add(c2059bn);
        } catch (Exception e5) {
            C2029al.m4641a(e5);
        }
    }

    private static void m4732a(ArrayList<C2059bn> arrayList, CrashDetailBean crashDetailBean, Context context) {
        C2059bn c2059bnM4722a;
        if (crashDetailBean.f7120b != 3) {
            return;
        }
        C2029al.m4644c("crashBean.anrMessages:%s", crashDetailBean.f7111T);
        try {
            Map<String, String> map = crashDetailBean.f7111T;
            if (map != null && map.containsKey("BUGLY_CR_01")) {
                if (!TextUtils.isEmpty(crashDetailBean.f7111T.get("BUGLY_CR_01"))) {
                    arrayList.add(new C2059bn((byte) 1, "anrMessage.txt", crashDetailBean.f7111T.get("BUGLY_CR_01").getBytes("utf-8")));
                    C2029al.m4644c("attach anr message", new Object[0]);
                }
                crashDetailBean.f7111T.remove("BUGLY_CR_01");
            }
            String str = crashDetailBean.f7140v;
            if (str == null || (c2059bnM4722a = m4722a("trace.zip", context, str)) == null) {
                return;
            }
            C2029al.m4644c("attach traces", new Object[0]);
            arrayList.add(c2059bnM4722a);
        } catch (Exception e5) {
            e5.printStackTrace();
            C2029al.m4641a(e5);
        }
    }

    private static void m4735a(ArrayList<C2059bn> arrayList, List<String> list) {
        if (list == null || list.isEmpty()) {
            return;
        }
        StringBuilder sb = new StringBuilder();
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            sb.append(it.next());
        }
        try {
            arrayList.add(new C2059bn((byte) 1, "martianlog.txt", sb.toString().getBytes("utf-8")));
            C2029al.m4644c("attach pageTracingList", new Object[0]);
        } catch (Exception e5) {
            e5.printStackTrace();
        }
    }

    private static Map<String, String> m4727a(CrashDetailBean crashDetailBean, C2018aa c2018aa) {
        HashMap map = new HashMap(30);
        try {
            StringBuilder sb = new StringBuilder();
            sb.append(crashDetailBean.f7094C);
            map.put("A9", sb.toString());
            StringBuilder sb2 = new StringBuilder();
            sb2.append(crashDetailBean.f7095D);
            map.put("A11", sb2.toString());
            StringBuilder sb3 = new StringBuilder();
            sb3.append(crashDetailBean.f7096E);
            map.put("A10", sb3.toString());
            map.put("A23", crashDetailBean.f7124f);
            c2018aa.getClass();
            map.put("A7", "");
            map.put("A6", C2018aa.m4510n());
            map.put("A5", c2018aa.m4533m());
            map.put("A22", c2018aa.m4526g());
            StringBuilder sb4 = new StringBuilder();
            sb4.append(crashDetailBean.f7098G);
            map.put("A2", sb4.toString());
            StringBuilder sb5 = new StringBuilder();
            sb5.append(crashDetailBean.f7097F);
            map.put("A1", sb5.toString());
            map.put("A24", c2018aa.f7235k);
            StringBuilder sb6 = new StringBuilder();
            sb6.append(crashDetailBean.f7099H);
            map.put("A17", sb6.toString());
            map.put("A25", c2018aa.m4526g());
            map.put("A15", c2018aa.m4536q());
            StringBuilder sb7 = new StringBuilder();
            sb7.append(c2018aa.m4537r());
            map.put("A13", sb7.toString());
            map.put("A34", crashDetailBean.f7092A);
            if (c2018aa.f7182G != null) {
                map.put("productIdentify", c2018aa.f7182G);
            }
            map.put("A26", URLEncoder.encode(crashDetailBean.f7103L, "utf-8"));
            if (crashDetailBean.f7120b == 1) {
                map.put("A27", crashDetailBean.f7106O);
                map.put("A28", crashDetailBean.f7105N);
                StringBuilder sb8 = new StringBuilder();
                sb8.append(crashDetailBean.f7129k);
                map.put("A29", sb8.toString());
            }
            map.put("A30", crashDetailBean.f7107P);
            StringBuilder sb9 = new StringBuilder();
            sb9.append(crashDetailBean.f7108Q);
            map.put("A18", sb9.toString());
            StringBuilder sb10 = new StringBuilder();
            sb10.append(true ^ crashDetailBean.f7109R);
            map.put("A36", sb10.toString());
            StringBuilder sb11 = new StringBuilder();
            sb11.append(c2018aa.f7250z);
            map.put("F02", sb11.toString());
            StringBuilder sb12 = new StringBuilder();
            sb12.append(c2018aa.f7176A);
            map.put("F03", sb12.toString());
            map.put("F04", c2018aa.m4520d());
            StringBuilder sb13 = new StringBuilder();
            sb13.append(c2018aa.f7177B);
            map.put("F05", sb13.toString());
            map.put("F06", c2018aa.f7249y);
            map.put("F08", c2018aa.f7180E);
            map.put("F09", c2018aa.f7181F);
            StringBuilder sb14 = new StringBuilder();
            sb14.append(c2018aa.f7178C);
            map.put("F10", sb14.toString());
            m4738a(map, crashDetailBean);
        } catch (Exception e5) {
            e5.printStackTrace();
            C2029al.m4641a(e5);
        }
        return map;
    }

    private static void m4738a(Map<String, String> map, CrashDetailBean crashDetailBean) {
        if (crashDetailBean.f7112U >= 0) {
            StringBuilder sb = new StringBuilder();
            sb.append(crashDetailBean.f7112U);
            map.put("C01", sb.toString());
        }
        if (crashDetailBean.f7113V >= 0) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(crashDetailBean.f7113V);
            map.put("C02", sb2.toString());
        }
        Map<String, String> map2 = crashDetailBean.f7114W;
        if (map2 != null && map2.size() > 0) {
            for (Map.Entry<String, String> entry : crashDetailBean.f7114W.entrySet()) {
                map.put("C03_" + entry.getKey(), entry.getValue());
            }
        }
        Map<String, String> map3 = crashDetailBean.f7115X;
        if (map3 == null || map3.size() <= 0) {
            return;
        }
        for (Map.Entry<String, String> entry2 : crashDetailBean.f7115X.entrySet()) {
            map.put("C04_" + entry2.getKey(), entry2.getValue());
        }
    }

    public static void m4737a(List list, boolean z7, long j10, String str, String str2) {
        if (list == null || list.isEmpty()) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            CrashDetailBean crashDetailBean = (CrashDetailBean) it.next();
            String str3 = f7357l.get(Integer.valueOf(crashDetailBean.f7120b));
            if (!TextUtils.isEmpty(str3)) {
                arrayList.add(new C2024ag.c(crashDetailBean.f7121c, str3, crashDetailBean.f7136r, z7, j10, str, str2));
            }
        }
        C2024ag.a.f7269a.m4602a(arrayList);
    }
}
