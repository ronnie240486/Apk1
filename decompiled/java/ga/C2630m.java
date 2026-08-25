package ga;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.alibaba.fastjson.JSON;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.cache.CacheMode;
import com.lzy.okgo.model.HttpParams;
import com.lzy.okgo.request.PostRequest;
import com.p2serv.android.p032ds.R;
import com.tencent.bugly.crashreport.CrashReport;
import com.tencent.mars.xlog.Log;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.UUID;
import org.bitspark.android.Spark;
import org.bitspark.android.Utils;
import org.bitspark.android.beans.AuthInfo;
import org.bitspark.android.utils.AbstractC3331m;
import org.bitspark.android.utils.AbstractC3336r;
import p003a2.AbstractC0032a;
import p055ea.AbstractC2440g;
import p055ea.AbstractC2442h;
import p055ea.AbstractC2460q;
import p055ea.C2428a;
import p187r4.AbstractC3612b;

public final class C2630m {

    public static final String f9143c = AbstractC0032a.m165s("l0e4ib8s\n", "1RTt+tpeplE=\n");

    public static long f9144d = 0;

    public static AuthInfo f9145e;

    public final Context f9146a;

    public int f9147b = 0;

    public C2630m(Context context) {
        this.f9146a = context;
    }

    public static void m5644a(C2630m c2630m, String str) {
        c2630m.getClass();
        String str2 = AbstractC0032a.m165s("M86/n/PVFpQzxLzMvQ==\n", "X6HY9p2Td/0=\n") + str + AbstractC0032a.m165s("ws9bRw==\n", "4uJ2Z4yqiVs=\n") + c2630m.f9147b;
        boolean z7 = AbstractC3331m.f11244b;
        Log.m5049i(f9143c, str2);
        c2630m.f9147b++;
    }

    public static boolean m5645b(C2630m c2630m) {
        boolean z7 = c2630m.f9147b == 1 && !TextUtils.isEmpty(m5649h(EnumC2629l.f9141l));
        String str = AbstractC0032a.m165s("agulK9rKbrlgL6U538B7rHgKpGSWjhfmOQ==\n", "GWPKXrauOss=\n") + c2630m.f9147b + " " + z7;
        boolean z10 = AbstractC3331m.f11244b;
        Log.m5049i(f9143c, str);
        return z7;
    }

    public static void m5646c(C2630m c2630m, String str) {
        String strM6775a;
        c2630m.getClass();
        if (AbstractC2442h.f8590L && (strM6775a = AbstractC3336r.m6775a()) != null) {
            String strConcat = AbstractC0032a.m165s("kH9GWbCa8VWQcVUcpYe9SMY+\n", "/B4yPMPu0S0=\n").concat(strM6775a);
            boolean z7 = AbstractC3331m.f11244b;
            Log.m5049i(f9143c, strConcat);
            ((PostRequest) ((PostRequest) OkGo.post(AbstractC0032a.m165s("V7lfiqpNBIwJ+AXIo1AFjAz1BcunVxGOBvQSw78XW9FQrE8=\n", "P80r+pBiK70=\n")).tag(c2630m)).headers(AbstractC0032a.m165s("XQyTGxe/npdoRA==\n", "BSHVcnva8PY=\n"), AbstractC0032a.m165s("FW3TCuL+WZUVbdMF5b9/\n", "eQK0bIuSPLg=\n") + str + AbstractC0032a.m165s("hA==\n", "qYmNuMVd5ro=\n") + C2428a.f8493b + AbstractC0032a.m165s("GT3v4w==\n", "N1GAhIyi494=\n"))).upFile(new File(strM6775a)).execute(new C2627j(2));
        }
    }

    public static void m5647d(C2630m c2630m, String str, int i6) {
        String string;
        c2630m.getClass();
        try {
            String str2 = AbstractC2440g.f8552a;
            AbstractC3331m.m6762l(str2);
            AuthInfo authInfo = (AuthInfo) JSON.parseObject(str, AuthInfo.class);
            f9145e = authInfo;
            AbstractC3331m.m6763m(authInfo.code, str2);
            AuthInfo authInfo2 = f9145e;
            if (authInfo2 == null) {
                Spark.m6678t0(0, "2131886504" + AbstractC0032a.m165s("s+M=\n", "icM9Q0530w4=\n") + i6);
                AbstractC3331m.m6762l(str2);
                Spark.f11002X1.sendEmptyMessage(10);
                return;
            }
            int i10 = authInfo2.code;
            if (i10 == 0) {
                Spark.f11002X1.sendEmptyMessage(15);
                return;
            }
            Context context = c2630m.f9146a;
            if (i10 == -11) {
                string = context.getString(R.string.no_such_accout_err);
            } else if (i10 == -10) {
                string = context.getString(R.string.password_err);
            } else {
                string = f9145e.result + AbstractC0032a.m165s("org=\n", "mJiUIcicoR4=\n") + f9145e.code + AbstractC0032a.m165s("X2UN\n", "f0otmnsntLM=\n") + i6;
            }
            Spark.m6678t0(1, string);
            AbstractC3331m.m6762l(str2);
            Spark.f11002X1.sendEmptyMessage(10);
        } catch (Exception unused) {
            String strM165s = AbstractC0032a.m165s("MRBtNmq7YyQkAz8hbu93dyQDbSp9ug==\n", "QXEfRQ+bFlc=\n");
            boolean z7 = AbstractC3331m.f11244b;
            Log.m5049i(f9143c, strM165s);
            Spark.m6678t0(1, AbstractC0032a.m165s("+Oi7VgCMmY7N++lBBNiN3c37u0oXlsw=\n", "qInJJWWs7P0=\n") + i6);
            Spark.f11002X1.sendEmptyMessage(10);
        }
    }

    public static String m5648e(String str) {
        AuthInfo.ServiceBean serviceBean;
        AuthInfo authInfo = f9145e;
        if (authInfo == null || (serviceBean = authInfo.service) == null || serviceBean.token == null) {
            return str;
        }
        if (str == null || str.isEmpty()) {
            return "";
        }
        if (str.indexOf(AbstractC0032a.m165s("xQ==\n", "+rYOTwlx7Ec=\n")) > 0) {
            StringBuilder sbM5498l = AbstractC2460q.m5498l(str);
            sbM5498l.append(AbstractC0032a.m165s("zzBz\n", "6UROD68saN0=\n"));
            sbM5498l.append(f9145e.service.token);
            return sbM5498l.toString();
        }
        StringBuilder sbM5498l2 = AbstractC2460q.m5498l(str);
        sbM5498l2.append(AbstractC0032a.m165s("XIdf\n", "Y/NiINf5/qY=\n"));
        sbM5498l2.append(f9145e.service.token);
        return sbM5498l2.toString();
    }

    public static String m5649h(EnumC2629l enumC2629l) {
        AuthInfo authInfo = f9145e;
        String strM5648e = "";
        if ((authInfo == null || authInfo.service == null) && enumC2629l != EnumC2629l.f9131b && enumC2629l != EnumC2629l.f9130a && enumC2629l != EnumC2629l.f9141l) {
            return "";
        }
        switch (enumC2629l.ordinal()) {
            case 0:
                strM5648e = AbstractC2442h.f8595a;
                break;
            case 1:
                strM5648e = AbstractC2442h.f8596b;
                break;
            case 2:
                strM5648e = f9145e.service.auth_url;
                break;
            case 3:
                strM5648e = f9145e.service.brand_url;
                break;
            case 4:
                strM5648e = m5648e(f9145e.service.ch_url);
                break;
            case 5:
                strM5648e = m5648e(f9145e.service.vod_url);
                break;
            case 6:
                strM5648e = m5648e(f9145e.service.epg_url);
                break;
            case 7:
                strM5648e = m5648e(f9145e.service.update_url);
                break;
            case 8:
                strM5648e = m5648e(f9145e.service.message_url);
                break;
            case 9:
                strM5648e = m5648e(f9145e.service.vod_tag_url);
                break;
            case 10:
                strM5648e = f9145e.service.vod_search_url;
                break;
            case 11:
                strM5648e = f9145e.service.vod_tag_url;
                break;
            case 12:
                strM5648e = m5648e(f9145e.service.event_url);
                break;
            case 13:
                strM5648e = m5648e(f9145e.service.wsguard_url);
                break;
            case 14:
                String str = AbstractC2442h.f8595a;
                break;
        }
        int iIntValue = AbstractC3331m.m6756f(0, AbstractC0032a.m165s("XRqKIDHY\n", "Dl/YdnSKUlE=\n")).intValue();
        if (iIntValue == 0) {
            return strM5648e;
        }
        return strM5648e.replaceFirst(AbstractC0032a.m165s("zms=\n", "kkUWQq2h7PI=\n"), AbstractC0032a.m165s("XZE=\n", "cPPN1VlW6Z8=\n") + iIntValue + AbstractC0032a.m165s("jg==\n", "oOTi+OQO4DQ=\n"));
    }

    public final void m5650f() {
        HttpParams httpParams = new HttpParams();
        httpParams.put(AbstractC0032a.m165s("0HcMBQ==\n", "tgVjaHPfY4Y=\n"), AbstractC0032a.m165s("ASU=\n", "YFXQa/itRI8=\n"), new boolean[0]);
        int iIntValue = AbstractC3331m.m6756f(0, AbstractC2440g.f8553b).intValue();
        if (iIntValue != 2 && iIntValue != 1) {
            Spark.f11002X1.sendEmptyMessage(10);
            return;
        }
        String str = AbstractC2440g.f8556e;
        String strM6757g = AbstractC3331m.m6757g(str, "");
        boolean zIsEmpty = strM6757g.isEmpty();
        Context context = this.f9146a;
        if (!zIsEmpty) {
            CrashReport.setUserId(context, strM6757g);
        }
        httpParams.put(AbstractC0032a.m165s("8Q964853XBU=\n", "hHwfkaAWMXA=\n"), strM6757g, new boolean[0]);
        String strM165s = AbstractC0032a.m165s("8QmpluV/wbE=\n", "gWja5ZIQs9U=\n");
        String str2 = AbstractC2440g.f8557f;
        httpParams.put(strM165s, AbstractC3331m.m6757g(str2, ""), new boolean[0]);
        httpParams.put(AbstractC0032a.m165s("xBZtEBfPuv8=\n", "oHMbeXSq87s=\n"), AbstractC3612b.m7270l(context), new boolean[0]);
        httpParams.put(AbstractC0032a.m165s("/9asESLOr8Hu2qo=\n", "j7fPekOpyo8=\n"), C2428a.f8493b, new boolean[0]);
        httpParams.put(AbstractC0032a.m165s("0IXPkSs59Q==\n", "sfW/30pUkEk=\n"), C2428a.f8503l, new boolean[0]);
        httpParams.put(AbstractC0032a.m165s("Kgv1vGmTAA8kFQ==\n", "S3uF6gzhc2Y=\n"), C2428a.f8496e, new boolean[0]);
        httpParams.put(AbstractC0032a.m165s("GMiHi+MM34UU2Q==\n", "er3u54dOreQ=\n"), Build.BRAND, new boolean[0]);
        httpParams.put(AbstractC0032a.m165s("MO+qPd0BwKc276Al\n", "UprDUblRssg=\n"), Build.PRODUCT, new boolean[0]);
        httpParams.put(AbstractC0032a.m165s("PtPNCAVrYZ8uwg==\n", "XKakZGEpDv4=\n"), Build.BOARD, new boolean[0]);
        httpParams.put(AbstractC0032a.m165s("wESNsMX9wI0=\n", "ojHk3KG8gsQ=\n"), Build.CPU_ABI, new boolean[0]);
        httpParams.put(AbstractC0032a.m165s("diswnIp0SWV2PzA=\n", "GVtV7usALCg=\n"), AbstractC3331m.m6756f(0, AbstractC0032a.m165s("Iab6bvNBD583qfFz5lI=\n", "cvalKrYXRtw=\n")).intValue(), new boolean[0]);
        httpParams.put(AbstractC0032a.m165s("RGPuge+HaJ1WeuaU\n", "JhaH7YvDAe4=\n"), Build.DISPLAY, new boolean[0]);
        httpParams.put(AbstractC0032a.m165s("Sdo+gB4nwrpOww==\n", "K69X7Hpqrd4=\n"), Build.MODEL, new boolean[0]);
        httpParams.put(AbstractC0032a.m165s("lqU0J1ZoYOKKsg==\n", "5dxHcTMaE4s=\n"), Build.VERSION.RELEASE, new boolean[0]);
        String strM5649h = m5649h(EnumC2629l.f9131b);
        if (this.f9147b == 1) {
            strM5649h = m5649h(EnumC2629l.f9141l);
        }
        Log.m5049i(f9143c, AbstractC0032a.m165s("GrmBXFA3iGMVlw==\n", "e8z1MxxY7wo=\n") + this.f9147b + AbstractC0032a.m165s("DXAYIx3aaQYL\n", "UFA1A2ioBTw=\n") + strM5649h + AbstractC0032a.m165s("acmdqQ8=\n", "NOmwhC8Gc/w=\n") + AbstractC3331m.m6757g(str, "") + AbstractC0032a.m165s("5w==\n", "3TIVqEr6VKY=\n") + AbstractC3331m.m6757g(str2, ""));
        OkGo.getInstance().cancelTag(this);
        PostRequest postRequest = (PostRequest) ((PostRequest) ((PostRequest) ((PostRequest) ((PostRequest) ((PostRequest) OkGo.post(strM5649h).removeHeader(AbstractC0032a.m165s("EjLl4K6sY/MpNQ==\n", "R0GAkoPtBJY=\n"))).headers(AbstractC0032a.m165s("WWgaFpezmKdibw==\n", "DBt/ZLry/8I=\n"), C2428a.f8504m)).params(httpParams)).tag(this)).cacheMode(CacheMode.REQUEST_FAILED_READ_CACHE)).cacheTime(259200000L);
        StringBuilder sb = new StringBuilder();
        sb.append(AbstractC0032a.m165s("6z0f\n", "iFYyOklFrLs=\n"));
        sb.append(strM5649h);
        sb.append(AbstractC0032a.m165s("Ug==\n", "fzh37TiIYDg=\n"));
        sb.append(AbstractC3331m.m6757g(str, ""));
        ((PostRequest) postRequest.cacheKey(sb.toString())).execute(new C2620c(1, this));
    }

    public final void m5651g() {
        String str = AbstractC2440g.f8554c;
        String strM6757g = AbstractC3331m.m6757g(str, "");
        if (strM6757g.equals("")) {
            strM6757g = C2428a.f8499h;
            AbstractC3331m.m6764n(str, strM6757g);
        }
        if (strM6757g.equals("")) {
            String string = UUID.randomUUID().toString();
            System.out.println(string);
            strM6757g = string.replace(AbstractC0032a.m165s("nQ==\n", "sOUUl9qDS8o=\n"), "").substring(0, 12).toUpperCase();
            AbstractC3331m.m6764n(str, strM6757g);
        }
        Log.m5049i(f9143c, AbstractC2460q.m5496j("sK2PBQdmhcjCrI0aHXGFlsI=\n", "4sjobHQS4Lo=\n", new StringBuilder(), strM6757g));
        ((PostRequest) ((PostRequest) ((PostRequest) OkGo.post(m5649h(EnumC2629l.f9130a)).params(AbstractC0032a.m165s("2Yld\n", "veA5y3mau28=\n"), strM6757g, new boolean[0])).tag(this)).cacheMode(CacheMode.NO_CACHE)).execute(new C2627j(1));
    }

    public final void m5652i() {
        String property;
        String property2;
        String str = AbstractC2442h.f8595a;
        String str2 = AbstractC2440g.f8553b;
        if (AbstractC3331m.m6756f(0, str2).intValue() == 2 && !AbstractC3331m.m6757g(AbstractC2440g.f8554c, "").equals("")) {
            this.f9147b = 0;
            m5650f();
            return;
        }
        if (AbstractC3331m.m6756f(0, str2).intValue() == 1 && !AbstractC3331m.m6757g(AbstractC2440g.f8556e, "").equals("")) {
            this.f9147b = 0;
            m5650f();
            return;
        }
        Context context = this.f9146a;
        String strM165s = AbstractC0032a.m165s("ipuNpoLZnd2DmJahhcKY24Gar4KF3pz7g9/YxtY=\n", "7f755/et9ZQ=\n");
        String str3 = f9143c;
        Log.m5049i(str3, strM165s);
        Properties properties = new Properties();
        try {
            if (context.getFileStreamPath(AbstractC0032a.m165s("0nYx/db00kuebzfh1vDSVNl6Ng==\n", "sB9FjqaVoCA=\n")).exists()) {
                FileInputStream fileInputStreamOpenFileInput = context.openFileInput(AbstractC0032a.m165s("aICimm8QREokmaSGbxREVWOMpQ==\n", "CunW6R9xNiE=\n"));
                properties.load(fileInputStreamOpenFileInput);
                fileInputStreamOpenFileInput.close();
                if (properties.getProperty(AbstractC0032a.m165s("Dy0/fRELSCo=\n", "el5aD19qJU8=\n")) != null) {
                    property = properties.getProperty(AbstractC0032a.m165s("aewsJ90LHgs=\n", "HJ9JVZNqc24=\n"));
                    int i6 = Utils.f11162a;
                    if (property.length() >= 16) {
                        property = Utils.enc(0, property);
                    }
                } else {
                    property = "";
                }
                if (properties.getProperty(AbstractC0032a.m165s("ZfBGx8TOc/M=\n", "FZE1tJOhAZc=\n")) != null) {
                    property2 = properties.getProperty(AbstractC0032a.m165s("EoBpFkqPUu8=\n", "YuEaZR3gIIs=\n"));
                    int i10 = Utils.f11162a;
                    if (property2.length() >= 16) {
                        property2 = Utils.enc(0, property2);
                    }
                } else {
                    property2 = "";
                }
                if (!property.equals("") && !property2.equals("")) {
                    Log.m5049i(str3, AbstractC0032a.m165s("Ij5crXLhzYIjM1XoPbI=\n", "TVI4jQeSqPA=\n") + property + AbstractC0032a.m165s("6dZdd9hdk0rx1Uszkhw=\n", "hro5V6g84Dk=\n") + property2);
                    AbstractC3331m.m6763m(1, str2);
                    AbstractC3331m.m6764n(AbstractC2440g.f8556e, property);
                    AbstractC3331m.m6764n(AbstractC2440g.f8557f, property2);
                }
                Spark.f11002X1.sendEmptyMessage(10);
                return;
            }
            this.f9147b = 0;
            m5650f();
        } catch (FileNotFoundException e5) {
            e5.printStackTrace();
            Log.m5049i(str3, AbstractC0032a.m165s("W5yZJRardmtY3NVoU+J/JB7W1mMUqjklWZ4=\n", "eL+6BjWLGAQ=\n"));
        } catch (IOException e10) {
            e10.printStackTrace();
        }
    }
}
